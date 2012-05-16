/*********************************************************************
 * XML API examples
 *
 * All rights reserved (c) Copyright 2004 Alcatel
 *
 */

package com.alcatel.ServerHTTP;

import java.lang.Exception;
import java.lang.System;

import java.util.*;

import org.apache.log4j.Logger;

/**
 * This class is a description of the ressource
 * We have an object GenericRessource and a String with the user/password of the ressoure.
 * If user/password is null, then the ressource isn't rectrict.
 *
 * @author S.C.
 * @since 25/04/02
 * @version 1.0
 */
public class RessourcesUserPass
{
	static Logger logger = Logger.getLogger(RessourcesUserPass.class.getName());

	private GenericRessource mGenericRessource;
	private String mUserPass;

	/**
	 * Constructor.
	 * @param .
	 * @since 25/04/02

	 */
	protected RessourcesUserPass() 
	{
		mGenericRessource = null;
		mUserPass = null;
	}

	/**
	 * Put a ressource.
	 * @param .
	 * @since 25/04/02

	 */
	public void putRessource(GenericRessource pRessource) 
	{
		mGenericRessource = pRessource;
	}

	/**
	 * get  a ressource.
	 * @param .
	 * @since 25/04/02

	 */
	public GenericRessource getRessource() 
	{
		return mGenericRessource;
	}
	/**
	 * Put a user/password.
	 * @param .
	 * @since 25/04/02

	 */
	public void putUserPass(String pUserPass) 
	{
		mUserPass = pUserPass;
	}

	/**
	 * get  a user/password.
	 * @param .
	 * @since 25/04/02

	 */
	public String getUserPass() 
	{
		return mUserPass;
	}

}
// ste_ServerHttp-
