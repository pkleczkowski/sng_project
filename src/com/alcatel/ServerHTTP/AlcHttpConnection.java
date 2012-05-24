/*********************************************************************
 * XML API examples
 *
 * All rights reserved (c) Copyright 2004 Alcatel
 *
 */

package com.alcatel.ServerHTTP;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Date;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

public class AlcHttpConnection implements Runnable {

	// mHttpSocket represents the connection socket
	private Socket mHttpSocket = null;
	private AlcListeRessources mListeRessource = null;

	static Logger logger = Logger.getLogger(AlcHttpConnection.class.getName());

	public AlcHttpConnection(Socket pHttpSocket, AlcListeRessources pListeRessource) {
		if (logger.isDebugEnabled() == true) {
			logger.debug("AlcHttpConnection(...)");
		}

		mHttpSocket = pHttpSocket;
		mListeRessource = pListeRessource;
	}

	private boolean parseExecuteRequest(BufferedReader pBufferRequest) {
		boolean lStatus = true;
		boolean lEndOfHtml = false;

		try {
			// Be carreful readLine on the BufferedReader delete the line
			String lRequestLine = pBufferRequest.readLine(); // First line of the request
			String lRequestPage = null; // Html Page provides with the request, can be null if
			// no HTML or XML page with the request.
			String lUserPass = null; // User and password if reception of an authenticate
			boolean lXmlHtmlPage = false;
			int lContentLength = -1;
			String lHost = null; //PCH

			// First parse of the request
			String lTmpRequestLine = new String(lRequestLine); // first and other lines of the request
			while (lTmpRequestLine != null && lEndOfHtml == false) {
				if (logger.isDebugEnabled() == true) {
					logger.debug("Request line  --> " + lTmpRequestLine);
				}

				// search the end of the HTML page to quit the while
				lEndOfHtml = (lTmpRequestLine.regionMatches(0, new String("</HTML>"), 0, 7)) || (lTmpRequestLine.regionMatches(0, new String("</XML>"), 0, 6)) || (lTmpRequestLine.length() == 0);

				//PCH+
				if (lTmpRequestLine.startsWith("Host: ")) {
					//l'@ip commence au 7eme caractere
					lHost = lTmpRequestLine.substring(6, lTmpRequestLine.lastIndexOf(':'));
					if (logger.isDebugEnabled() == true) {
						logger.debug("parseExecuteRequest Host = " + lHost);
					}
				}
				//PCH-
				// we search if there is a HTML or XML page with the request
				if (lTmpRequestLine.toLowerCase().startsWith(AlcHttpSyntaxe.CONTENT_TYPE.toLowerCase()) && ((lTmpRequestLine.toLowerCase().indexOf(AlcHttpSyntaxe.HTML.toLowerCase()) != -1) || (lTmpRequestLine.toLowerCase().indexOf(AlcHttpSyntaxe.XML.toLowerCase()) != -1) || (lTmpRequestLine.toLowerCase().indexOf(AlcHttpSyntaxe.APPLICATION_FORM.toLowerCase()) != -1))) {
					// There is a HTML or XML page with the request
					if (logger.isDebugEnabled() == true) {
						logger.debug("Find a HTML or XML Page ");
					}

					lXmlHtmlPage = true;
					lRequestPage = new String();
				}

				if (lTmpRequestLine.toLowerCase().startsWith(AlcHttpSyntaxe.CONTENT_LENGTH.toLowerCase())) {
					if (logger.isDebugEnabled() == true)
						logger.debug("Request line  --> " + lTmpRequestLine);

					int lIndex = (AlcHttpSyntaxe.CONTENT_LENGTH).length();
					lTmpRequestLine = lTmpRequestLine.substring(lIndex);
					lContentLength = (new Integer(lTmpRequestLine)).intValue();
					if (logger.isDebugEnabled() == true)
						logger.debug("ContentLength = " + lContentLength);
				}

				if ((lTmpRequestLine.compareTo("") == 0) && lXmlHtmlPage) {
					// the line is empty, the body is following
					lTmpRequestLine = null;

					// We know the length, we can read all the message
					//!!! take care of the content-type parameter !!! eg : UTF8
					int i = 0;
					for (i = 0; i < lContentLength; i++) {
						lRequestPage = lRequestPage + (char) pBufferRequest.read();
					}

					if (!lRequestPage.endsWith(AlcHttpSyntaxe.END_OF_LINE))
						lRequestPage = lRequestPage + AlcHttpSyntaxe.END_OF_LINE;

					lEndOfHtml = true;
				}

				lTmpRequestLine = null;
				if (lEndOfHtml == false)
					lTmpRequestLine = pBufferRequest.readLine();
			}

			// extract the method with the first line of the request
			if (lRequestLine.startsWith(AlcHttpSyntaxe.GET)) {
				receptGetPostMethod(AlcHttpSyntaxe.GET_METHOD, lRequestLine, lRequestPage, lHost, lUserPass);
			} else if (lRequestLine.startsWith(AlcHttpSyntaxe.POST)) {
				// the request methods is a POST
				receptGetPostMethod(AlcHttpSyntaxe.POST_METHOD, lRequestLine, lRequestPage, lHost, lUserPass);
			} else {
				// the method isn't implemented
				logger.error("Method request unknown");
				sendBadRequest();
			}

		} catch (java.io.IOException lException) {
			logger.error("ERROR in AlcHttpConnection during parse request" + lException);
		}

		return lStatus;
	}

	private void receptGetPostMethod(int pMethod, String pRequestLine, String pRequestPage, String pHost, String pUserPass) {

		String lRequestUrl, lHttpVersion;
		AlcGenericRessource lRessource = null;
		AlcHttpResponse lResponse = new AlcHttpResponse();

		int lIndex = 0;
		try {
			String lRequestLine = new String(pRequestLine);

			// the request methods is a get
			// extract the URL request
			if (pMethod == AlcHttpSyntaxe.GET_METHOD)
				lIndex = AlcHttpSyntaxe.GET.length(); // Index in the line after the Method
			else
				lIndex = AlcHttpSyntaxe.POST.length(); // Index in the line after the Method

			lRequestLine = lRequestLine.substring(lIndex);

			StringTokenizer lTokenRequestLine = new StringTokenizer(lRequestLine, " ");
			int lNbTokenRequestLine = lTokenRequestLine.countTokens();

			if (lNbTokenRequestLine > 1) {
				lRequestUrl = lTokenRequestLine.nextToken();
				lHttpVersion = lTokenRequestLine.nextToken();
				if (lHttpVersion.startsWith(AlcHttpSyntaxe.HTTP)) {
					// The request is correct
					if (logger.isDebugEnabled() == true) {
						logger.debug("receptGetPostMethod: Request URL is " + lRequestUrl);
					}

					// Find the resource
					lRessource = mListeRessource.getRessource(lRequestUrl);
					if (lRessource != null) {
						if (pMethod == AlcHttpSyntaxe.GET_METHOD) {
							lResponse = lRessource.doGet(lRequestUrl, pRequestPage); //, pHost, mHttpSocket);
						} else {
							lResponse = lRessource.doPost(lRequestUrl, pRequestPage);
						}

						if (lResponse != null) {
							// Send the response of doGet or doPost method
							sendResponse(lResponse.mStatus, lResponse.mTypeMime, null, lResponse.mResponse);
						} else {
							if (logger.isDebugEnabled() == true) {
								logger.debug("No messages for the moment - Please wait");
							}
							sendBadRequest();
						}
					} else {
						// Requested url has no associated ressource
						logger.error("No ressource found");
						sendNoRessource();
					}
				} else {
					// It isn't an http request
					logger.error("No Http Request");
					sendBadRequest();
				}

			} else {
				// No Url find
				logger.error("No URL in request");
				sendBadRequest();
			}
		} catch (IllegalArgumentException e) {
			logger.error("problem in OTS side");
			sendBadRequest();
		} catch (Exception lException) {
			logger.error("ERROR in AlcHttpConnection receptGetPostMethod during parse request" + lException);
			lException.printStackTrace();
			sendBadRequest();
		}
	}

	/**
	 * sendResponse send the Http response with Http Header
	 * @param  pStatus is the String status of the response ex OK, 
	 *                 see the Definition of the response in AlcHttpSyntaxe
	 *        pTypeMime is the type mime of the response, ex HTML
	 *                 see the Definition of the type mime in AlcHttpSyntaxe
	 *        pHttpHeaderExtend is the complement of Http hearder, null if nothing
	 *        pResponse --> content of the response, can be HTML page, null if nothing
	 * @since 05/04/02
	
	 */
	private void sendResponse(String pStatus, String pTypeMime, String pHttpHeaderExtend, String pResponse) {
		try {

			StringBuffer lHttpResponse = new StringBuffer();
			lHttpResponse.append(AlcHttpSyntaxe.HTTP_HEADER).append(pStatus).append("\r\n");
			lHttpResponse.append(AlcHttpSyntaxe.DATE).append(new Date()).append("\r\n");
			lHttpResponse.append(AlcHttpSyntaxe.SERVER).append("HttpServerDefault/1.0").append("\r\n");

			// add the Http header complement if exist
			if (pHttpHeaderExtend != null)
				lHttpResponse.append(pHttpHeaderExtend);

			if (pTypeMime != null)
				lHttpResponse.append(AlcHttpSyntaxe.CONTENT_TYPE).append(pTypeMime).append("\r\n\n");
			else
				lHttpResponse.append("\r\n");

			// add the response after the content type
			if (pResponse != null)
				lHttpResponse.append(pResponse).append("\r\n");
			if (logger.isDebugEnabled() == true) {
				logger.debug("sendResponse = " + lHttpResponse);
			}

			mHttpSocket.getOutputStream().write(lHttpResponse.toString().getBytes());

			mHttpSocket.getOutputStream().flush();
			mHttpSocket.getOutputStream().close();

			if (logger.isDebugEnabled() == true)
				logger.debug("Closing socket ...");
			mHttpSocket.close();
		} catch (Exception lException) {
			logger.error("ERROR in AlcHttpConnection during sendResponse" + lException);
			lException.printStackTrace();
		}
	}

	/**
	 * sendBadRequest send the 400 Bad Request reponse
	 * @since 05/04/02
	
	 */
	private void sendBadRequest() {
		// send a bad request
		String lStatus, lTypeMime, lResponse;

		lStatus = new String(AlcHttpSyntaxe.BAD_REQUEST);
		lTypeMime = new String(AlcHttpSyntaxe.HTML);

		lResponse = new String("<HTML>\r\n" + "<TITLE>Connection OK on MnHttpServer</TITLE>\r\n" + "<BODY><TEXT>Bad Request...</TEXT></BODY>\r\n" + "</HTML>\r\n");

		sendResponse(lStatus, lTypeMime, null, lResponse);
	}

	/**
	 * sendNoRessource send the 404 Ressource Not Found response
	 * @since 05/04/02
	
	 */
	private void sendNoRessource() {
		// send a Ressource not found
		String lStatus, lTypeMime, lResponse;

		lStatus = new String(AlcHttpSyntaxe.NOT_FOUND);
		lTypeMime = new String(AlcHttpSyntaxe.HTML);

		lResponse = new String("<HTML>\r\n" + "<TITLE>Connection OK on MnHttpServer</TITLE>\r\n" + "<BODY><TEXT>Ressource not found...</TEXT></BODY>\r\n" + "</HTML>\r\n");

		sendResponse(lStatus, lTypeMime, null, lResponse);

	}

	public void run() {

		if (logger.isDebugEnabled() == true) {
			logger.debug("Starting recept of a request client");
		}

		try {
			// read the request
			InputStream lIn = mHttpSocket.getInputStream();

			// the content of the request
			BufferedReader lBufferRead = new BufferedReader(new InputStreamReader(lIn));

			if (logger.isDebugEnabled() == true) {
				logger.debug("Request client is : " + mHttpSocket.getInetAddress().getHostAddress());
			}

			// parse and execute the request
			parseExecuteRequest(lBufferRead);

		} catch (Exception lException) {
			logger.error("ERROR in AlcHttpConnection during" + lException);
			lException.printStackTrace();
		}

		if (logger.isDebugEnabled() == true) {
			logger.debug("End of the request client");
		}
	}

}
