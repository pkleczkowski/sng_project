/*********************************************************************
 * XML API examples
 *
 * All rights reserved (c) Copyright 2004 Alcatel
 *
 */

package com.alcatel.ServerHTTP;

import java.io.FileInputStream;

import java.lang.Exception;
import java.lang.System;

import java.net.Socket;
import org.xml.sax.InputSource;
import java.io.StringReader;
import org.apache.xerces.parsers.SAXParser;
import java.io.IOException;
import org.xml.sax.SAXException;

import org.apache.log4j.Logger;

public class AlcEventsRessource implements AlcGenericRessource {

	static Logger logger = Logger.getLogger(AlcEventsRessource.class.getName());

	String m_methodResponse;
	com.alcatel.xmlapi.phone.XmlPhoneEvents m_xmlPhoneEventsServer = null;

	public AlcEventsRessource(com.alcatel.xmlapi.phone.XmlPhoneEvents pNotifServer, String pEventContext) throws IllegalArgumentException {
		if (logger.isDebugEnabled() == true) {
			logger.debug("AlcEventsRessource()");
		}
		m_xmlPhoneEventsServer = pNotifServer;
		subscribeRessource(pEventContext);
	}

	private void subscribeRessource(String pEventContext) {

		int lResult = ServerHttp.instance().subscribe(this, pEventContext);
		if (logger.isDebugEnabled()) {
			logger.debug("--> AlcEventsRessource subscribe Ressource for " + pEventContext + "result = " + lResult);
		}
	}

	// doGet http server methods, IN = Http request, OUT = Http response
	public AlcHttpResponse doGet(String pRequest, String pRequestPage) {
		AlcHttpResponse lResponse = new AlcHttpResponse();

		if (logger.isDebugEnabled() == true) {
			logger.debug("DoGet Request Uri = " + pRequest + " - Request Page = " + pRequestPage);
		}

		lResponse.mStatus = new String(HttpSyntaxe.OK);
		lResponse.mTypeMime = new String(HttpSyntaxe.TEXT);

		lResponse.mTypeMime = new String(HttpSyntaxe.HTML);
		lResponse.mResponse = new String("<HTML>\r\n" + "<TITLE>Connection OK on HttpServer</TITLE>\r\n" + "<BODY><TEXT>CONNECTION ON CONFIG RESSOURCE IS OK</TEXT></BODY>\r\n");

		return lResponse;

	}

	// doPost http server methods, IN = Http request, OUT = Http response
	public AlcHttpResponse doPost(String pRequest, String pRequestPage) {
		AlcHttpResponse lResponse = new AlcHttpResponse();
		logger.info("DoPost Request Uri = " + pRequest + " - Request Page = \n" + pRequestPage);

		// Initialisation des objets de traitement de document XML
		AlcEventsHandler handler = new AlcEventsHandler(this);
		SAXParser parser = new SAXParser();
		parser.setContentHandler(handler);

		try {
			parser.parse(new InputSource(new StringReader(pRequestPage)));
		} catch (IOException lException) {
			logger.error("DoPost pb de parsing " + lException);
			lException.printStackTrace();
		} catch (SAXException lException) {
			logger.error("DoPost pb de parsing " + lException);
			lException.printStackTrace();
		}

		lResponse.mStatus = new String(AlcHttpSyntaxe.OK);
		lResponse.mTypeMime = new String(AlcHttpSyntaxe.XML);

		/* requete
		  <?xml version="1.0" encoding="UTF-8"?>
			<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
			 <soapenv:Body>
			  <ns1:onCallState soapenv:encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" xmlns:ns1="http://xmlapi.alcatel.com/telephony/events">
				...............
		 */
		/*
		Reponse a formater de la sorte :
		HTTP/1.1 200 OK
		Content-Type: text/xml; charset=utf-8
		Connection: close
		Date: Fri, 17 Oct 2003 15:08:05 GMT
		Server: Apache Tomcat/4.0.4 (HTTP/1.1 Connector)
		
		<?xml version="1.0" encoding="UTF-8"?>
		<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
		 <soapenv:Body>
		  <ns1:onCallStateResponse soapenv:encodingStyle="http://schemas.xmlsoap.org/soap/encoding/" xmlns:ns1="http://xmlapi.alcatel.com/telephony/events"/>
		 </soapenv:Body>
		</soapenv:Envelope>
		*/

		lResponse.mResponse =
			new String(
				"" + "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">" + "<soapenv:Body>\r\n" + " <ns1:" + m_methodResponse + " soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:ns1=\"http://xmlapi.alcatel.com/phone\"/>\r\n" + " </soapenv:Body>\r\n" + "</soapenv:Envelope>");

		return lResponse;
	}

	private AlcHttpResponse createBadRequestResponse() {

		AlcHttpResponse lResponse = new AlcHttpResponse();

		lResponse.mStatus = new String(AlcHttpSyntaxe.BAD_REQUEST);
		lResponse.mTypeMime = new String(AlcHttpSyntaxe.XML);

		/*
		HTTP/1.1 500 Internal Server Error
		Content-Type: text/xml; charset=utf-8
		Connection: close
		Date: Fri, 17 Oct 2003 14:45:57 GMT
		Server: Apache Tomcat/4.0.4 (HTTP/1.1 Connector)
		
		<?xml version="1.0" encoding="UTF-8"?>
		<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
		 <soapenv:Body>
		  <soapenv:Fault>
		   <faultcode>Server.userException</faultcode>
		   <faultstring>No such operation &apos;onCallState&apos;</faultstring>
		   <detail/>
		  </soapenv:Fault>
		 </soapenv:Body>
		</soapenv:Envelope>
		*/
		lResponse.mResponse = new String("<HTML>\r\n" + "<TITLE>Connection OK on MnHttpServer</TITLE>\r\n" + "<BODY><TEXT>Bad Request...</TEXT></BODY>\r\n" + "</HTML>\r\n");

		return lResponse;
	}

	protected void addMessage(String pMethod, String pSessionId, Object event) {
		
		try {
			if (pMethod.equals("onCallState")) {
				m_xmlPhoneEventsServer.onCallState(pSessionId, (com.alcatel.xmlapi.phone.Call[])event);
			}
			else if (pMethod.equals("onNewSession")) {
				m_xmlPhoneEventsServer.onNewSession(pSessionId);
			}
			else if (pMethod.equals("onSessionClosed")) {
				m_xmlPhoneEventsServer.onSessionClosed(pSessionId);
			}
			else if (pMethod.equals("onConnectionDown")) {
				m_xmlPhoneEventsServer.onConnectionDown();
			}
			else if (pMethod.equals("onPhoneSetStaticState")) {
				
				m_xmlPhoneEventsServer.onPhoneSetStaticState(pSessionId, (com.alcatel.xmlapi.phonesetprogramming.types.AlcStaticState)event);
			}
			else if (pMethod.equals("onUnansweredCall")) {
				m_xmlPhoneEventsServer.onUnansweredCall(pSessionId);
			}
			else if (pMethod.equals("onNomadState")) {
				String homeNumber = null;
				com.alcatel.xmlapi.phone.NomadMode mode = null;			
				java.util.Vector params = (java.util.Vector)event;
				for (int i = 0; i < params.size(); i++) {
					if (params.elementAt(i) instanceof java.lang.String) {
						homeNumber = (String)params.elementAt(i);
					}
					else if (params.elementAt(i) instanceof com.alcatel.xmlapi.phone.NomadMode) {
						mode = (com.alcatel.xmlapi.phone.NomadMode)params.elementAt(i);
					}
				}
				m_xmlPhoneEventsServer.onNomadState(pSessionId, mode, homeNumber);
			}
		}
		catch (java.rmi.RemoteException e) {
			e.printStackTrace();
		}
		
		
		m_methodResponse = pMethod + "Response";
	}

}