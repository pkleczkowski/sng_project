/*********************************************************************
 * XML API examples
 *
 * All rights reserved (c) Copyright 2004 Alcatel
 *
 */

package com.alcatel.ServerHTTP.pool;

public class AlcThreadPoolRequest {
	Runnable	m_targetObject;
	Object		m_lock;
	
	AlcThreadPoolRequest(Runnable targetObject, Object lock) {
		this.m_targetObject = targetObject;
		this.m_lock = lock;
	}
	
	public Runnable getTarget() {
		return this.m_targetObject;
	}
	
	public Object getLock() {
		return this.m_lock;
	}
}