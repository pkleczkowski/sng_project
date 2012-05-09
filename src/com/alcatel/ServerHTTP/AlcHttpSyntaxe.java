/*********************************************************************
 * XML API examples
 *
 * All rights reserved (c) Copyright 2004 Alcatel
 *
 */

package com.alcatel.ServerHTTP;

/**
 * This class describes the syntaxe Http
 *
 * @author S.C.
 * @since 05/04/02
 * @version 1.0
 */
public class AlcHttpSyntaxe
{
	/**
	 * @author
	 * @since 15/04/2002
	 * @version 1.0
	 * Constants that contains all the Http Syntaxe
	 */

	// Http definition
	public static final String HTTP                 = "HTTP";

	// definition of HTTP Header
	public static final String HTTP_HEADER          = "HTTP/1.0 ";
	public static final String DATE                 = "Date: ";
	public static final String SERVER               = "Server: ";
	public static final String CONTENT_TYPE         = "Content-type: ";
	public static final String CONTENT_LENGTH       = "Content-length: ";
	public static final String WWW_AUTHENTICATE     = "WWW-authenticate: ";
	public static final String AUTHORIZATION        = "Authorization: ";

	// Definition of type mime
	public static final String HTML                 = "text/html";
	public static final String XML                  = "text/xml";	
	public static final String TEXT                 = "text/plain";
	public static final String JPEG                 = "image/jpeg";
	public static final String APPLICATION_FORM     = "application/x-www-form-urlencoded"; // For the forms


        // Definition of Commande request
	public static final String GET                  = "GET";
	public static final String POST                 = "POST";
	public static final String HEAD                 = "HEAD";
	public static final String PUT                  = "PUT";
	public static final String DELETE               = "DELETE";

	// Definition of the status response
	public static final String OK                  = "200 OK"; // Resquest OK
	public static final String CREATED             = "201 Created"; // Resquest OK after a POST request
	public static final String NO_RESPONSE         = "204 No Response"; // Resquest OK but no response to send

	public static final String BAD_REQUEST         = "400 Bad Request"; // Syntaxe error on request or 
	                                                                    // impossible to execute
	public static final String AUTHORIZATION_REQ   = "401 Authorisation Required"; // Authorisation case
	public static final String FORBIDDEN           = "403 Forbidden"; // Resquest forbidden
	public static final String NOT_FOUND           = "404 Not Found"; // file or request not found

	// Constants for the Http authentification
	public static final String BASIC_AUTH         = "Basic"; // type of the authentification mechanism
	public static final String BASIC_REALM        = "realm="; // name of type 
	public static final String BASIC_NAME_AUTH    = "Restrict Acces"; // name of the basic authentification


	// Syntaxe Opened URL
	public static final String OPENED_URL          = "*";

	// Http end of line
	public static final String END_OF_LINE         = "\r\n";

	// Constants to define a GET or POST Method
	public static final int GET_METHOD             = 1;
	public static final int POST_METHOD            = 2;

}
