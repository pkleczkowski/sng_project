/**
 * XmlPhoneSetProgramming.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.alcatel.xmlapi.phonesetprogramming;

public interface XmlPhoneSetProgramming extends java.rmi.Remote {
    public void setCurrentLine(java.lang.String pLineNumber) throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException;
    public com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingCapabilities getPhoneSetProgrammingCapabilities() throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException;
    public com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetInfo getPhoneSetInfo() throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException;
    public com.alcatel.xmlapi.phonesetprogramming.types.AlcServicePrefixes getServicePrefixes() throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException;
    public com.alcatel.xmlapi.phonesetprogramming.types.AlcStaticState getStaticState() throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException;
    public void setLockState(boolean pLocked) throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException;
    public void setDoNotDisturbState(boolean pDoNotDisturbActivated) throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException;
    public void setCampOnState(boolean pCampOnActivated) throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException;
    public void setForwardState(com.alcatel.xmlapi.phonesetprogramming.types.AlcForwardState pForwardState) throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException;
    public void setOverflowType(com.alcatel.xmlapi.phonesetprogramming.types.AlcOverflowType pOverflowType) throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException;
    public void setAssociate(java.lang.String pAssociatedNumber) throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException;
    public com.alcatel.xmlapi.phonesetprogramming.types.AlcSpeedDialingKey[] getSdkList() throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException;
    public com.alcatel.xmlapi.phonesetprogramming.types.AlcSpeedDialingKey getSdk(int pPosition) throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException;
    public void setSdk(com.alcatel.xmlapi.phonesetprogramming.types.AlcSpeedDialingKey pSdk) throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException;
    public com.alcatel.xmlapi.phonesetprogramming.types.AlcUserProgrammableKey[] getUpkList() throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException;
    public com.alcatel.xmlapi.phonesetprogramming.types.AlcUserProgrammableKey getUpk(int pPosition) throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException;
    public void setUpk(com.alcatel.xmlapi.phonesetprogramming.types.AlcUserProgrammableKey pUpk) throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException;
    public void changeSecretCode(java.lang.String pOldSecretCode, java.lang.String pNewSecretCode) throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException;
    public void clickAndDial(java.lang.String pCalledNumber) throws java.rmi.RemoteException, com.alcatel.xmlapi.phonesetprogramming.types.AlcPhoneSetProgrammingException, com.alcatel.xmlapi.common.AlcServiceException;
}
