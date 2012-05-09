/*********************************************************************
 * XML API examples
 *
 * All rights reserved (c) Copyright 2004 Alcatel
 *
 */

package com.alcatel.ServerHTTP;

/**
 * This class is a struture of the Http Response betwwenn
 * class ressource and the server HTTP
 *
 * @author S.C.
 * @since 05/04/02
 * @version 1.0
 */
public class AlcHttpResponse
{

	public String mStatus;    // is the String status of the response ex OK, 
	                          // see the Definition of the response in AlcHttpSyntaxe
	public String mTypeMime;  // is the type mime of the response, ex HTML
	                          // see the Definition of the type mime in AlcHttpSyntaxe
	public String mResponse;  // is the response 
	
	public AlcHttpResponse()
	{
		mStatus = null;
		mTypeMime = null;
		mResponse = null;
	}

}
