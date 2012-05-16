/*********************************************************************
 * XML API examples
 *
 * All rights reserved (c) Copyright 2004 Alcatel
 *
 */

package com.alcatel.ServerHTTP;

import java.util.Properties;
import java.lang.String;
import java.lang.System;
import java.lang.Exception;
import java.io.FileInputStream;
import java.lang.NullPointerException;
import org.apache.log4j.Logger;
/**
 * @author 
 * @since 
 * @version 
 * Donn?es ? g?rer :
 * 
 * - Appli :
 *   . nombre max de sessions,
 * 
 * - Agent :
 *  . port caract?ristique (AF_UNIX, TCP)
 *  . nb de cnx
 *  . tempo de non rep
 * 
 * - RTSP :
 *  . tempo de non rep
 *  . MIME type pour session (.ecc)
 *  . URL for "beep" (audio file) 
 *  
 * -Management :
 *  . port d'?coute
 *  . nb de cnx
 * 
 * -Traces:
 *  . info de trace (objets tracables, init)
 * 
 * .Supervision:
 *  . @ + port serveur RTSP (temporaire)
 *  . @ + port + tempo pour fct de supervision (step 2)
 */
public class ConfigDesc extends Properties 
{
	public final static String CONFIG_FILE     	  = "http_events_server.config";

	public final static String SERVER_HTTP_HOSTNAME   = "http_events_server.HttpServerName";
	public final static String SERVER_HTTP_PORT       = "http_events_server.HttpServerPort";

	public  final static String MAX_CNX               = "MaxCnx";
	
	static Logger logger = Logger.getLogger(ConfigDesc.class.getName());
	/**
	 * @author CT SR
	 * @since 19/11/2001
	 * @version 1.0
	 * Unique instance of the class.
	 */
	private static ConfigDesc mConfigDesc = null;

	// Constructor
	private ConfigDesc() throws Exception
	{
		//Gets the system property indicated in _ECC_CONFIG_FILE
		String lConfigFile = System.getProperty(ConfigDesc.CONFIG_FILE);

		load(new FileInputStream(lConfigFile));
	}
	
	/**
	 * @return ConfigDesc
	 * @exception 
	 * @author CT SR
	 * @since 19/11/2001
	 * @version 1.0
	 * Returns the unique insatnce of ConfigDesc; creates it if it doesn't exist.
	 * @roseuid 3BD5635A0015
	 */
	public static ConfigDesc instance() 
	{
		try
		{
			if (mConfigDesc == null)
				mConfigDesc = new ConfigDesc();
		}
		catch (Exception lException)
		{
			logger.error("FATAL: no config file found" + lException);
			System.exit(-1);
		}
		return mConfigDesc;
	}

	/**
	 * @return String
	 * @exception 
	 * @author CT SR
	 * @since 19/11/2001
	 * @version 1.0
	 * Returns the property associated to pKey
	 */
	public String get(String pKey) throws NullPointerException
	{
		String lValue=getProperty(pKey);
		if (logger.isDebugEnabled() == true) {
			logger.debug("get(" + "'" + pKey +"')");
		}		

		if (lValue == null) {
			logger.error("FATAL: the key " + pKey + " doesn't exist");
			throw (new NullPointerException());
		}
		return lValue;
	}

	static public void main(String[] argv)
	{
		System.out.println("MAX_CNX = " +ConfigDesc.instance().get(ConfigDesc.MAX_CNX));
	}
}
