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
import java.net.*;

public interface AlcGenericRessource
{

	// doGet http server methods, IN = Http request, OUT = Http response
	public AlcHttpResponse doGet(String pRequest,String pRequestPage);
	// doPost http server methods, IN = Http request, OUT = Http response
	public AlcHttpResponse doPost(String pRequest, String pRequestPage);

}
