/*********************************************************************
 * XML API examples
 *
 * All rights reserved (c) Copyright 2004 Alcatel
 *
 */

package com.alcatel.ServerHTTP.pool;

//import com.alcatel.woti.business.AlcWatchdogThread;
//import com.alcatel.woti.business.AlcWatchDog;

import org.apache.log4j.Logger;

import java.util.NoSuchElementException;
import java.util.Vector;

public class AlcThreadPool { //implements AlcWatchDog {
	
	private Vector 			m_arrRequests;
	private int 			m_nRequests;
	private AlcCondVar 		m_cvAvailable, m_cvEmpty;
	private AlcBusyFlag 		m_cvFlag;
	
	private AlcThreadPoolThread[]	m_poolThreads;
	private boolean 		m_bTerminated;
	
//	private AlcWatchdogThread 	m_thWatchDog;
	private int			m_nRequestsCount;
	private int			m_nMaxRequests;
	
	static Logger logger = Logger.getLogger(AlcThreadPool.class.getName());
	
	public AlcThreadPool(int n) {
		
 		if (logger.isDebugEnabled() == true) {
			logger.debug("AlcThreadPool("+ n +")");
		}	 	
		
		this.m_cvFlag = new AlcBusyFlag();
		this.m_cvAvailable = new AlcCondVar(this.m_cvFlag);
		this.m_cvEmpty = new AlcCondVar(this.m_cvFlag);
		
		this.m_arrRequests = new Vector();
		
		this.m_poolThreads = new AlcThreadPoolThread[n];
		
		for(int i = 0; i<n; i++) {
			this.m_poolThreads[i] = new AlcThreadPoolThread(this, i);
			this.m_poolThreads[i].start();
		}
		
		this.m_bTerminated = false;
		this.m_nRequests = 0;
		
		this.m_nRequestsCount = 0;
		this.m_nMaxRequests = 0;
		
//		this.m_thWatchDog = new AlcWatchdogThread(this, 60); // Check every minutes
	}

	public void checkSystemIntegrity() {
		logger.info("Nb requests / minute = " + this.m_nRequestsCount);
		
		this.m_nRequestsCount = 0;	 		
	}
		
	public AlcThreadPoolRequest getFirstRequest(boolean bRemove) {
		AlcThreadPoolRequest firstRequest = null;
		
		if (this.m_arrRequests.isEmpty() == false) {
			try {
				firstRequest = (AlcThreadPoolRequest) this.m_arrRequests.firstElement();
				if (bRemove == true) {
					this.m_arrRequests.removeElementAt(0);
				}
			}
			catch(NoSuchElementException e) {
			}
		}
		
		return firstRequest;	
	}		

	public int decNbRequests() {
		this.m_nRequests--;
		if (this.m_nRequests == 0) {
			this.m_cvEmpty.cvSignal();
		}
		
		return this.m_nRequests;
	}

	public int incNbRequests() {
		this.m_nRequests++;
		return this.m_nRequests;
	}
	
	public void getFlag() {
		this.m_cvFlag.get();
	}

	public void releaseFlag() {
		this.m_cvFlag.free();
	}
	
	public void waitingForWork() throws InterruptedException {
		this.m_cvAvailable.cvWait();
	}
		
	private void add(Runnable target, Object lock) {

 		if (logger.isDebugEnabled() == true) {
			logger.debug("add(...)");
		}
		
		try {
			this.m_cvFlag.get();
			if (this.m_bTerminated == true) {
				throw new IllegalStateException("Thread pool has shut down");
			}
			
			this.m_arrRequests.addElement(new AlcThreadPoolRequest(target, lock));
			this.m_nRequests++;

			if (this.m_nRequests > this.m_nMaxRequests) {
				this.m_nMaxRequests = this.m_nRequests;
				
		 		logger.info("Max Simultaneous Requests = " + this.m_nMaxRequests);				
			}

			this.m_nRequestsCount++; // For statistics only
					
	 		if (logger.isDebugEnabled() == true) {
				logger.debug("Signal to working threads that there is something to do");
			}
			
			this.m_cvAvailable.cvSignal(); // There is something to do
			
		} finally {
			this.m_cvFlag.free();
		}
	}
	
	public void addRequest(Runnable target) {
		
 		if (logger.isDebugEnabled() == true) {
			logger.debug("addRequest(...)");
		}	
				
		add(target, null);
	}
	
	public void addRequestAndWait(Runnable target) throws InterruptedException {
 		if (logger.isDebugEnabled() == true) {
			logger.debug("addRequestAndWait(...)");
		}			
		
		Object lock = new Object();
		synchronized(lock) {
			add(target, lock);
			lock.wait();
		}
	}
	
	public void waitForAll(boolean terminate) throws InterruptedException {

 		if (logger.isDebugEnabled() == true) {
			logger.debug("waitForAll(" + terminate + ")");
		}			
		
		try {
			this.m_cvFlag.get();
			
			while (this.m_nRequests != 0) {
				this.m_cvEmpty.cvWait();
			}
			
			if (terminate == true)  {
				for(int i=0; i<this.m_poolThreads.length; i++) {
					this.m_poolThreads[i].mustStop();
				}
				this.m_cvAvailable.cvBroadcast();
				this.m_bTerminated = true;
			}
		} finally {
			this.m_cvFlag.free();
		}
		
	}
		
	public void waitForAll() throws InterruptedException {

		if (logger.isDebugEnabled() == true) {
			logger.debug("waitForAll()");
		}		
		
		waitForAll(false);
	}		

}