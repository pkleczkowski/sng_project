/*********************************************************************
 * XML API examples
 *
 * All rights reserved (c) Copyright 2004 Alcatel
 *
 */

package com.alcatel.ServerHTTP;

import java.lang.Thread;
import java.lang.Exception;
import java.lang.System;

import java.io.*;
import java.net.*;
import java.util.*;

import org.apache.log4j.Logger;

public class ServerHttp
{
	static Logger logger = Logger.getLogger(ServerHttp.class.getName());

	// Unique instance of the class ServerHttp
	private static ServerHttp mServerHttp = null;
	// Listen socket
	private static ServerSocket mListenSocket = null;

	// List of Ressources subscribed
	public AlcListeRessources mListeRessources;

	protected ServerHttp(String pListenPort) 
	{
		try
		{
			if (logger.isDebugEnabled()) { 
				logger.debug("\n\n--> ServerHttp Constructor");
			}

			// liste of ressources provided
			mListeRessources = new AlcListeRessources();

			int port = Integer.parseInt(pListenPort);
			// Start the server
			mListenSocket = new ServerSocket(port);
			if (logger.isDebugEnabled()) { 
				logger.debug("--> ServerHttp Constructor : Server HTTP is running on " + InetAddress.getLocalHost() + " : " + port + ".....\n");
			}	
			new AlcHttpListen(mListenSocket, mListeRessources).start();
		}
		catch (Exception lException)
		{
			logger.error("FATAL ERROR in ServerHttp Constructor " + lException );
		}
	}

	public static  ServerHttp instance() 
	{
		return mServerHttp;
	}

	public static  ServerHttp instance(String pListenPort) 
	{
		if ( mServerHttp == null )
			mServerHttp = new ServerHttp(pListenPort);
		return mServerHttp;
	}

	public int subscribe(AlcGenericRessource pRessource, String pUrl) 
	{

		logger.info("--> AlcHttpServer put the ressource = " + pUrl /*+ " " + pUserPass +  "\n"*/);

		this.mListeRessources.putRessource(pRessource, pUrl );

		return 1;
	}
}
