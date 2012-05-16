/*********************************************************************
 * XML API examples
 *
 * All rights reserved (c) Copyright 2004 Alcatel
 *
 */

package com.alcatel.ServerHTTP.pool;

import org.apache.log4j.Logger;

public class AlcThreadPoolThread extends Thread {
	
	private AlcThreadPool	m_parent;
	private boolean 	m_bShouldRun;
	
	static Logger logger = Logger.getLogger(AlcThreadPoolThread.class.getName());
	
	AlcThreadPoolThread(AlcThreadPool parent, int i) {
		super("AlcThreadPoolThread " + i);

		if (logger.isDebugEnabled() == true) {
			logger.debug("AlcThreadPoolThread("+ i +")");
		}

		this.m_parent = parent;
		this.m_bShouldRun = true;
	}
	
	public void mustStop() {
		if (logger.isDebugEnabled() == true) {
			logger.debug("mustStop()");
		}
					
		this.m_bShouldRun = false;
	}
	
	public void run() {

		if (logger.isDebugEnabled() == true) {
			logger.debug("run()");
		}
					
		AlcThreadPoolRequest request = null;
		while (this.m_bShouldRun == true) {
			try {
				this.m_parent.getFlag();
				while ((request == null) && (this.m_bShouldRun)) {
					request = (AlcThreadPoolRequest) this.m_parent.getFirstRequest(true);
				
					if (request == null) {
						if (logger.isDebugEnabled() == true) {
							logger.debug("Ready but nothing to do - wait");
						}
						
						// Nothing to do -> Waiting for work
						try {
							this.m_parent.waitingForWork();
						}
						catch(InterruptedException ie) {
							return;
						}
					}
				}
			} finally {
				this.m_parent.releaseFlag();
			}
			
			if (this.m_bShouldRun == false) {
				return;
			}

			if (logger.isDebugEnabled() == true) {
				logger.debug("There is something to do");
			}
							
			request.getTarget().run();
			
			try {
				this.m_parent.getFlag();
				this.m_parent.decNbRequests();
			} finally {
				this.m_parent.releaseFlag();
			}
			
			Object lock = request.getLock();
			
			if (lock != null) {
				synchronized(lock) {
					lock.notify();
				}
			}

			if (logger.isDebugEnabled() == true) {
				logger.debug("Job completed");
			}
			
			request = null;
		
		}	
	}
}