/*********************************************************************
 * XML API examples
 *
 * All rights reserved (c) Copyright 2004 Alcatel
 *
 */

package com.alcatel.ServerHTTP.pool;

import org.apache.log4j.Logger;

public class AlcCondVar {
	
	private AlcBusyFlag m_busyflag;		
	
	static Logger logger = Logger.getLogger(AlcCondVar.class.getName());

	/**
	 * Class construstor
	 */	
	public AlcCondVar() {
		if (logger.isDebugEnabled() == true) {
			logger.debug("AlcCondVar()");
		}
		
		this.m_busyflag = new AlcBusyFlag();
	}

	/**
	 * Class construstor
	 *
	 * @param busyflag An {@link AlcBusyFlag AlcBusyFlag} object used for synchronization
	 */	
	public AlcCondVar(AlcBusyFlag busyflag) {
		if (logger.isDebugEnabled() == true) {
			logger.debug("AlcCondVar(...)");
		}
					
		this.m_busyflag = busyflag;
	}

	/**
	 * Infinite wait
	 */	
	public void cvWait() throws InterruptedException {
		if (logger.isDebugEnabled() == true) {
			logger.debug("cvWait()");
		}
		
		cvTimedWait(this.m_busyflag, 0);
	}
	
	public void cvWait(AlcBusyFlag busyflag) throws InterruptedException {
		if (logger.isDebugEnabled() == true) {
			logger.debug("cvWait(...)");
		}
		
		cvTimedWait(busyflag, 0);
	}
	
	public void cvTimedWait(int millis) throws InterruptedException {
		if (logger.isDebugEnabled() == true) {
			logger.debug("cvTimedWait()");
		}
		
		cvTimedWait(this.m_busyflag, millis);
	}
	
	public void cvTimedWait(AlcBusyFlag busyflag, int millis) throws InterruptedException {

		if (logger.isDebugEnabled() == true) {
			logger.debug("cvTimedWait(...)");
		}
		
		int i = 0;
		InterruptedException errex = null;
		
		synchronized(this) {
			// Current thread must be flag owner
			if (busyflag.getOwner() != Thread.currentThread()) {
				throw new IllegalMonitorStateException("Current thread not owner");
			}
			
			// Free lock
			while (busyflag.getOwner() == Thread.currentThread()) {
				i++; // Remember number of imbrication 
				busyflag.free();
			}
			
			try {
				if (logger.isDebugEnabled() == true) {
					logger.debug("Wait activated");
				}					
				
				if (millis == 0) {
					wait(); // Infinite wait
				} else {
					wait(millis);
				}
				
				if (logger.isDebugEnabled() == true) {
					logger.debug("Wait ended");
				}					
			}
			catch(InterruptedException iex) {
				errex = iex;
			}
		}
		
		// Retrieve original imbrication
		while(i>0) {
			i--;
			busyflag.get();
		}
		
		if (errex != null) {
			throw errex;
		}
		
		return;
	}
	
	public void cvSignal() throws IllegalMonitorStateException {
		if (logger.isDebugEnabled() == true) {
			logger.debug("cvSignal()");
		}
					
		cvSignal(this.m_busyflag);
	}
	
	public synchronized void cvSignal(AlcBusyFlag busyflag) throws IllegalMonitorStateException{
		if (logger.isDebugEnabled() == true) {
			logger.debug("cvSignal(...)");
		}
		
		// Current must be flag owner
		if (busyflag.getOwner() != Thread.currentThread()) {
			throw new IllegalMonitorStateException("Current thread not owner");
		}
		notify();
	}
	
	public void cvBroadcast() throws IllegalMonitorStateException {
		if (logger.isDebugEnabled() == true) {
			logger.debug("cvBroadcast()");
		}
					
		cvBroadcast(this.m_busyflag);
	}
	
	public synchronized void cvBroadcast(AlcBusyFlag busyflag) throws IllegalMonitorStateException {
		if (logger.isDebugEnabled() == true) {
			logger.debug("cvBroadcast(...)");
		}
					
		// Current thread must be the flag owner
		if (busyflag.getOwner() != Thread.currentThread()) {
			throw new IllegalMonitorStateException("Current thread not owner");
		}
		notifyAll();			
	}
}