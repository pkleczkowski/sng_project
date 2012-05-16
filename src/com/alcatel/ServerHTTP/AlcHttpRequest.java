/*********************************************************************
 * XML API examples
 *
 * All rights reserved (c) Copyright 2004 Alcatel
 *
 */

package com.alcatel.ServerHTTP;

import java.util.Vector;
import java.util.Hashtable;
import java.util.Enumeration;
import java.lang.IllegalArgumentException;

import org.apache.log4j.Logger;

/**
 * @author Michel SOUBEN
 * @since 11/06/2003 10:07
 * @version 1.0
 */
 
 public class AlcHttpRequest {
	
	private String m_strRequest;
	private String m_strUrl;
	private Hashtable m_arrParams;

	static Logger logger = Logger.getLogger(AlcHttpRequest.class.getName());
	
	public AlcHttpRequest(String strRequest) throws IllegalArgumentException {
		if (logger.isDebugEnabled() == true) {
			logger.debug("AlcHttpRequest(" + "'" + strRequest +"')");
		}
				
		this.m_strRequest = strRequest;
		this.m_arrParams = new Hashtable();

		if (strRequest != null) {
			
			String[] split = split(strRequest, '?');
			if (split.length <= 2) {
				this.m_strUrl = split[0];
				if (split.length == 2) {
					String[] arrParams = split(split[1], '&');
					for(int i=0; i<arrParams.length; i++) {
						AlcParam param = new AlcParam(arrParams[i]);
						this.m_arrParams.put(param.getKey(), param.getValue());
					}
				}
			} else {
				if (logger.isDebugEnabled() == true) logger.debug("Too many '?' characters");
				throw new IllegalArgumentException("Too many '?' characters");
			}		 
		} else {
			if (logger.isDebugEnabled() == true) logger.debug("Parameter can not be null");
			throw new IllegalArgumentException("Parameter can not be null");

		}
	}
	
	public String getParameter(String strParam) {
		if (logger.isDebugEnabled() == true) {
			logger.debug("getParameter(" + "'" + strParam +"')");
		}
		
		return (String) this.m_arrParams.get(strParam);
	}
	
	public String[] getParameters() {
		if (logger.isDebugEnabled() == true) {
			logger.debug("getParameters()");
		}
		
		String[] result = new String[this.m_arrParams.size()];
		
		Enumeration params = this.m_arrParams.keys();
		
		int i = 0;
		while (params.hasMoreElements() == true) {
			result[i] = (String) params.nextElement();
			i++;
		}
		
		return result;
	}
	
	private String[] split(String message, char pattern) {
		String submessage = new String();
		Vector submessages = new Vector();
		String[] result;
		int i;
				
		for ( i=0; i<message.length(); i++) {
			if (message.charAt(i) != pattern) {
				submessage += message.charAt(i);	
			} else {
//				System.out.println("submessage : " + submessage);
				submessages.add(submessage);
				submessage = "";
			}	
		}
		
		if (submessage.compareTo("") != 0) {
			submessages.add(submessage);
		}
		
		result = new String[submessages.size()];
		
		for ( i=0; i<submessages.size(); i++) {
			result[i] = (String) submessages.elementAt(i);
		}
		
		return result;
	}	
}