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
 * This class is a liste of Http ressources.
 *
 * @author S.C.
 * @since 03/04/02
 * @version 1.0
 */
public class ListeRessources
{
	static Logger logger = Logger.getLogger(ListeRessources.class.getName());

	private HashMap mClosedRessourceListe; // Closed URL
	private HashMap mOpenedRessourceListe; // Opened URL

	/**
	 * Constructor.
	 * @param .
	 * @since 03/04/02

	 */
	protected ListeRessources() 
	{
		mClosedRessourceListe = new HashMap();
		mOpenedRessourceListe = new HashMap();
	}

	/**
	 * Put a ressource in the ressource liste.
	 * @param .
	 * @since 03/04/02

	 */
	public void putRessource(RessourcesUserPass pRessourceUserPass, String pUrl) 
	{
		String lUrl = new String(pUrl);
		int lLength = 0;
		int i=0;
		boolean lStarFound = false;

		if ( pRessourceUserPass != null && pUrl != null )
		{

			lLength = lUrl.length();
			for ( i = 0; i<lLength && !lStarFound; i++ )
			{
				if ( lUrl.charAt(i) == HttpSyntaxe.OPENED_URL.charAt(0) )
					lStarFound = true; // we find a *, it is n opened URL
			}

			if ( lStarFound )
			{
				// Opened URL, we extract the *
				lUrl = lUrl.substring(0, (i-1));
				logger.info("ListeRessource : put the opened ressource  --> " 
								  + lUrl );
				mOpenedRessourceListe.put(lUrl, pRessourceUserPass);
			}	
			else
			{
				// Closed URL
				logger.info("ListeRessource : put the closed ressource  --> " 
								  + lUrl );
				mClosedRessourceListe.put(lUrl, pRessourceUserPass);
			}
		}
	}

	/**
	 * get  a ressource in the ressource liste.
	 * @param .
	 * @since 03/04/02

	 */
	public RessourcesUserPass getRessource(String pUrl) 
	{

		String lUrl = new String(pUrl);
		int lLength = 0;
		int i = 0;
		boolean lStarFound = false;
		boolean lRessourceFound = false;

		RessourcesUserPass lRessourceUserPass=null;

		if ( pUrl != null )
		{
			// At first Glance, we extract the star
			lLength = lUrl.length();
			for ( i = 0; i<lLength && !lStarFound; i++ )
			{
				if ( lUrl.charAt(i) == HttpSyntaxe.OPENED_URL.charAt(0) )
				{
					lStarFound = true; // we find a *, it is n opened URL
					lUrl = lUrl.substring(0, i); // extract after the star
				}
			}
			logger.info("ListeRessource : search the URL = " 
								  + lUrl );
			// Search in CLOSED HashmapTable ressource
			if ( (lRessourceUserPass = (RessourcesUserPass) mClosedRessourceListe.get(lUrl) ) != null )
			{
				lRessourceFound = true;
				logger.info("ListeRessource : get closed ressource = " 
								  + lRessourceUserPass.getRessource()
								  + " " + lRessourceUserPass.getUserPass() );
			}
			else
			{
				// Search in OPENED HashmapTable ressource
				// Get the list of key in the OPENED HashMap Table
				Set lListeOfKey = mOpenedRessourceListe.keySet();
				int lNbElement = lListeOfKey.size();
				if ( lNbElement > 0 )
				{
					// There is one or more opened URL in mOpenedRessourceListe
					Object[] lArrayOfKey = (Object[]) lListeOfKey.toArray();

					for ( int j=0; j<lNbElement && !lRessourceFound; j++)
					{
						// For each key, we compare the beginning of the URL
						if ( lUrl.startsWith( (String) lArrayOfKey[j] ) )
						{
							// we find an Ressource 
							lRessourceUserPass = (RessourcesUserPass) 
								mOpenedRessourceListe.get((String) lArrayOfKey[j] );
							lRessourceFound = true;
							logger.info
								      ("ListeRessource : get opened ressource =  " 
								       + lRessourceUserPass.getRessource()
								       + " " + lRessourceUserPass.getUserPass() );
						}
					}
				}
				

			}
		}

		return lRessourceUserPass;	
	}

	/**
  	 * Main for unit test
	 * @param  arguments   arguments 
	 * @since 03/04/02
	 */
	public static void main(String [] arguments) 
	{

	}
}
// ste_ServerHttp-
