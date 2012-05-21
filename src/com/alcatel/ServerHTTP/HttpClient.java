/*********************************************************************
 * XML API examples
 *
 * All rights reserved (c) Copyright 2004 Alcatel
 *
 */

package com.alcatel.ServerHTTP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

import org.apache.log4j.Logger;

/**
 * This class is a client Http to connect to the server Http
 *
 * @author S.C.
 * @since 18/03/02
 * @version 1.0
 */
public class HttpClient
{
	static Logger logger = Logger.getLogger(HttpClient.class.getName());

	private int mPort;
	private String mServerHttpAddress = null;
	private String mUrl = null;
	private boolean mResponseReceive;

	private Socket mHttpClientSocket = null;   // Socket with the server Http
	private BufferedReader mBufferedRead=null; // To read message on the server http
	private PrintStream mPrintStream = null;   // to put message on the server http

	/**
	 * Constructor.
	 * @param .
	 * @since 18/03/02

	 */
	public HttpClient()
	{
		mServerHttpAddress = "155.132.38.90"; // ste_PROV
		mPort = 10000;                    // ste_PROV

		mResponseReceive = false;
		// creation of the socket with input output
		try
		{
			// Creation of the socket to server Http
			mHttpClientSocket = new Socket(InetAddress.getByName(mServerHttpAddress), mPort );
			
			logger.info("\n\n--> HttpClient Constructor, socket creation");

			mBufferedRead = new BufferedReader(new InputStreamReader(mHttpClientSocket.getInputStream()));
			mPrintStream  = new PrintStream(mHttpClientSocket.getOutputStream());

		}
		catch (Exception lException)
		{
			logger.error("FATAL ERROR HttpClient constructor  " 
							   + lException );
		}
	}


	/**
	 * Send a request to the server http.
	 * @param pRequest --> request to send.
	 * @since 18/03/02

	 */
	public boolean sendRequest (String pRequest)
	{
		boolean lStatus = false;

		logger.info("--> HttpClient send a request = " + pRequest );
		
		try
		{
			mPrintStream.print(pRequest);

			lStatus = true;
		}
		catch (Exception lException)
		{
			logger.error("ERROR in HttpClient during sendRequest " 
							   + lException );
			lStatus = false;
		}
		return lStatus;
	}

	/**
	 * Receive a msg fromserver http.
	 * @param pMsgRead --> line received.
	 * @since 18/03/02

	 */
	public void onReceiveSocket ()
	{
		boolean lStatus = false;
		String lMsgResponse = null;
		while ( !mResponseReceive )
		{

			try
			{
				// actualy we read only one line
				lMsgResponse = mBufferedRead.readLine();
				if ( lMsgResponse != null )
				{
					mResponseReceive = true;
				}
			}
			catch (Exception lException)
			{
				logger.error( "HttpClient onreceiveSocket ERROR in read socket: "
					      + lException);
			}	

		}

		logger.info("--> HttpClient receive response = ");
		logger.info("--> " + lMsgResponse );
	}

	/**
	 * close the socket
	 * @param pRequest --> request to send.
	 * @since 18/03/02

	 */
	public void close ()
	{

		try
		{
			logger.info ("HttpClient close");

			mHttpClientSocket.shutdownInput();
			mBufferedRead.close();
			mHttpClientSocket.shutdownOutput();
			mPrintStream.close();
    			mHttpClientSocket.close();
			mHttpClientSocket = null;
		}
		catch (Exception lException)
		{
			logger.error ("HttpClient closeConnection --> catch exception : "
				       + lException);
		}
	}


	/**
  	 * Main for unit test
	 * @param  arguments   arguments 
	 * @since 18/03/02
	 */
	public static void main(String [] arguments) 
	{
		HttpClient lHttpClient = null;
		String lRequest = null;
		boolean lStatus = false;

		System.out.println("HttpClient --> MAIN unit Client test start\n");

		lRequest = "GET /websoftphone/getEvents HTTP/1.1\r\n"
			+ "Content-type: text/html\r\n"
			+ "\r\n"
			+"<HTML>\r\n"
			+"<HEAD><TITLE>HttpCLient</TITLE></HEAD>\r\n" + "<BODY>Hello my server</BODY>\r\n"
			+"</HTML>\r\n"
			+ "\r\n";
		
		
		lHttpClient = new HttpClient();

		lStatus = lHttpClient.sendRequest(lRequest);

		// wait and read the response
		lHttpClient.onReceiveSocket();

		lHttpClient.close();

		System.out.println("HttpClient --> MAIN unit test ended\n");
		System.exit(0);
	}
	
}
// ste_ServerHttp-
