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

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.alcatel.ServerHTTP.pool.AlcThreadPool;

import org.apache.log4j.Logger;

/**
 * This class is a Listen HTTP connection
 * It is a runable classes.
 *
 * @author S.C.
 * @since 18/03/02
 * @version 1.0
 */
public class AlcHttpListen extends Thread //implements AlcCleanup
{

	// HttpListen give in the constructor
	private ServerSocket m_HttpListen = null;
	private int m_IdClient;
	private AlcThreadPool m_threadsPool;
	
	private boolean m_bEnd;

	static Logger logger = Logger.getLogger(AlcHttpListen.class.getName());

	private AlcListeRessources m_ListeRessource = null;

	/**
	 * Constructor.
	 * @param .
	 * @since 18/03/02

	 */
	public AlcHttpListen(ServerSocket pServerSocket, AlcListeRessources pListeRessource) 
	{
		super("Http listen socket");

 		if (logger.isDebugEnabled() == true) {
			logger.debug("AlcHttpListen(...)");
		}
				
		this.m_HttpListen = pServerSocket;
		this.m_IdClient = 0;
		
		this.m_bEnd = false;

		this.m_ListeRessource = pListeRessource;
		
		this.m_threadsPool = new AlcThreadPool(10);
	}


	public void run()
       	{
       		
		if (logger.isDebugEnabled() == true) {
			logger.debug("--> AlcHttpListen is started and wait client connection");
		}

		Socket lSocket=null;
		AlcHttpConnection lHttpConnection = null;
		
		while (this.m_bEnd == false)
		{
			try
			{
				lSocket = this.m_HttpListen.accept(); // wait a client connection

				this.m_IdClient = this.m_IdClient + 1;
				if (this.m_IdClient == 65000 ) {
					this.m_IdClient = 1;
				}
								
		 		if (logger.isDebugEnabled() == true) {
					logger.debug("--> AlcHttpListen client connection Id=" + this.m_IdClient);
				}
				
				lHttpConnection = new AlcHttpConnection(lSocket, this.m_ListeRessource); 
				this.m_threadsPool.addRequest(lHttpConnection);

			}
			catch (IOException lException)
			{
				if (this.m_bEnd == false) {
					logger.error("ERROR in AlcHttpListen during client connection " + lException );
				}
			}
				
		}
	}

	/**
	 * Free resourses
	 */
	public synchronized void shutdown() {
		
		if (logger.isDebugEnabled() == true) {
			logger.debug("shutdown()");
		}
		
		this.m_bEnd = true;
		
		try {
			this.m_HttpListen.close();
		}
		catch(IOException e) {
		}
	}
		
		

}