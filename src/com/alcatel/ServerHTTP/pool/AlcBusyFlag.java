/*********************************************************************
 * XML API examples
 *
 * All rights reserved (c) Copyright 2004 Alcatel
 *
 */

package com.alcatel.ServerHTTP.pool;

import org.apache.log4j.Logger;

/**
 * AlcBusyFlag - Manage concurrent accesses
 */
public class AlcBusyFlag {
	
	protected Thread	m_thOwner;
	protected int		m_iImbrication;
	
	static Logger logger = Logger.getLogger(AlcBusyFlag.class.getName());
	
	/**
	 * Class construstor
	 */
	public AlcBusyFlag() {
		if (logger.isDebugEnabled() == true) {
			logger.debug("AlcBusyFlag()");
		}

		this.m_thOwner = null;
		this.m_iImbrication = 0;
	}
	
	/**
	 * Get the flag. If the current thread is not the flag owner, the method doesn't return immediately 
	 * but wait that the thread owner releases the flag. To release the flag calls {@link free free} method
	 * Remark: Call to this method can be imbricated so the {@link free free} method must be call the same number of time.
	 */
	public synchronized void get() {
		if (logger.isDebugEnabled() == true) {
			logger.debug("get()");
		}

		// Try to get the flag
		while (tryGet() == false) {
			// If the current thread is not the flag owner, it must wait that the thread flag owner releases it
			try {
				wait();
			}
			catch(Exception e) {}
		}
		
		if (logger.isDebugEnabled() == true) {
			logger.debug("I got it !!! - BusyCount = " + this.m_iImbrication);
		}				
		
	}
	
	private synchronized boolean tryGet() {
		if (logger.isDebugEnabled() == true) {
			logger.debug("tryGet()");
		}

		// Flag has no owner
		if (this.m_thOwner == null) {
			this.m_thOwner = Thread.currentThread(); // Current thread becomes flag owner
			this.m_iImbrication = 1;
		
			return true;	
		}
		
		// Check if the current thread is the flag owner
		if (this.m_thOwner == Thread.currentThread()) {
			this.m_iImbrication ++;

			return true;
		}
		
		// The current thread is not the flag owner : it can't get the flag
		return false;
	}
	
	/**
	 * If the current thread is the flag owner, it discreases the number of imbrication. If the number of imbrication is null, it releases the flag and unlocks the waiting thread.   
	 */
	public synchronized void free() {
		if (logger.isDebugEnabled() == true) {
			logger.debug("free()");
		}

		// Check if the current thread is the flag owner
		if (getOwner() == Thread.currentThread()) {
			// Discrease imbrication
			this.m_iImbrication --;
											
			if (this.m_iImbrication == 0) {
				// Flag has no owner
				this.m_thOwner = null;
				
				if (logger.isDebugEnabled() == true) {
					logger.debug("BusyCount is null -> Notify waiting thread");
				}
									
				// Notify the waiting thread 				
				notify();
			} else {
				if (logger.isDebugEnabled() == true) {
					logger.debug("BusyCount = " + this.m_iImbrication);
				}
			}
		}
	}
	
	/**
	 * Retrieve the thread flag owner
	 */
	public synchronized Thread getOwner() {
		
		return this.m_thOwner;
	}
			
}