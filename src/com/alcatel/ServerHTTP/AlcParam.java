/*********************************************************************
 * XML API examples
 *
 * All rights reserved (c) Copyright 2004 Alcatel
 *
 */

package com.alcatel.ServerHTTP;

import java.util.Vector;

import org.apache.log4j.Logger;

/**
 * @author Michel SOUBEN
 * @since 11/06/2003 10:07
 * @version 1.0
 */

public class AlcParam {
	
	private String m_strKey = null;
	private String m_strValue = null;

	static Logger logger = Logger.getLogger(AlcParam.class.getName());
	
	public AlcParam(String strKeyValue) throws IllegalArgumentException {
		if (logger.isDebugEnabled() == true) {
			logger.debug("AlcParam(" + "'" + strKeyValue +"')");
		}
		
		if (strKeyValue != null) {
			String[] split = split(strKeyValue, '=');
			String strKey, strValue;
			
			if (split.length == 2) {
				this.m_strKey = split[0];
				this.m_strValue = split[1];
			} else {
				throw new IllegalArgumentException();
			}
		} else {
			throw new IllegalArgumentException();
		}
	}

	public AlcParam(String strKey, String strValue) throws IllegalArgumentException {
		if ((strKey != null) && (strValue != null) && (strKey.length() != 0)) {
			this.m_strKey = strKey;
			this.m_strValue = strValue;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public String getKey() {
		return this.m_strKey;
	}	
	
	public String getValue() {
		return this.m_strValue;
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