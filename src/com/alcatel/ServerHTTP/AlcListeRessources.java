/*********************************************************************
 * XML API examples
 *
 * All rights reserved (c) Copyright 2004 Alcatel
 *
 */

package com.alcatel.ServerHTTP;

import java.lang.Exception;
import java.lang.System;

import java.util.Hashtable;

import org.apache.log4j.Logger;

/**
 * This class is a liste of Http ressources.
 *
 * @author S.C.
 * @since 03/04/02
 * @version 1.0
 */
public class AlcListeRessources
{
	private Hashtable m_strUrls;

	static Logger logger = Logger.getLogger(AlcListeRessources.class.getName());

	/**
	 * Constructor.
	 * @param .
	 * @since 03/04/02

	 */
	protected AlcListeRessources() 
	{
		this.m_strUrls = new Hashtable();
	}

	/**
	 * Put a ressource in the ressource liste.
	 * @param .
	 * @since 03/04/02

	 */
	public void putRessource(AlcGenericRessource pRessource, String strUrl) 
	{
		if (strUrl != null) {
			if (strUrl.length() !=0) {
				if (logger.isDebugEnabled() == true) logger.debug("MnListeRessource : put the ressource  --> " + strUrl );

				this.m_strUrls.put(strUrl, pRessource);
			}
		}
	}

	/**
	 * get  a ressource in the ressource liste.
	 * @param .
	 * @since 03/04/02

	 */
	public AlcGenericRessource getRessource(String strUrl) 
	{

		boolean lRessourceFound = false;

		AlcGenericRessource lRessource=null;

		if (strUrl != null) {
			int iPos = getNextCharPos(strUrl, '?', 0); 
			if (iPos > 0) {
				lRessource = (AlcGenericRessource) this.m_strUrls.get(strUrl.substring(0, iPos)); 
			} else {
				lRessource = (AlcGenericRessource) this.m_strUrls.get(strUrl);
			}
		}

		return lRessource;

	}

	private int getNextCharPos(String strUrl, char c, int iPos) {
		int iResult = -1;
		int iLength = strUrl.length();
		int i = iPos;
		
		while ((i<iLength) && (iResult == -1)) {
			if (strUrl.charAt(i) == c) {
				iResult = i;
			} else {
				i++;
			}
		}
		
		return iResult;
	}
}