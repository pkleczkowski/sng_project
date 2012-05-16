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
 * This class is an interface with the Ressources HTTP objects
 * Its defines the doGet and doPost HTTP server methods.
 *
 * @author S.C.
 * @since 03/04/02
 * @version 1.0
 */
abstract public class GenericRessource
{

	/**
	 * Constructor.
	 * @param .
	 * @since 03/43/02

	 */
	protected GenericRessource() 
	{

	}

	// doGet http server methods, IN = Http request, OUT = Http response
	abstract public AlcHttpResponse doGet(String pRequest,String pRequestPage);
	// doPost http server methods, IN = Http request, OUT = Http response
	abstract public AlcHttpResponse doPost(String pRequest, String pRequestPage);

}
// ste_ServerHttp-
