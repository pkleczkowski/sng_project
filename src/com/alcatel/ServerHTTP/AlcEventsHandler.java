/*********************************************************************
 * XML API examples
 *
 * All rights reserved (c) Copyright 2004 Alcatel
 *
 */

package com.alcatel.ServerHTTP;

import org.apache.log4j.Logger;

import com.alcatel.xmlapi.phone.Call;
import com.alcatel.xmlapi.phone.CallState;
import com.alcatel.xmlapi.phone.NomadMode;
import com.alcatel.xmlapi.phonesetprogramming.types.AlcForwardState;
import com.alcatel.xmlapi.phonesetprogramming.types.AlcForwardTargetType;
import com.alcatel.xmlapi.phonesetprogramming.types.AlcForwardType;
import com.alcatel.xmlapi.phonesetprogramming.types.AlcOverflowType;
import com.alcatel.xmlapi.phonesetprogramming.types.AlcStaticState;


public class AlcEventsHandler extends org.xml.sax.helpers.DefaultHandler {

	static org.apache.log4j.Logger LOGGER = Logger.getLogger(AlcEventsHandler.class.getName());

	private AlcEventsRessource m_eventRessource;
	private String m_strSessionId;
	private String m_currentFieldName = null;

	private static String ON_CALL_STATE_EVENT = "onCallState";
	private static String ON_NEW_SESSION_EVENT = "onNewSession";
	private static String ON_SESSION_CLOSED_EVENT = "onSessionClosed";
	private static String ON_CONNECTION_DOWN_EVENT = "onConnectionDown";
	private static String ON_PHONESET_STATIC_STATE_EVENT = "onPhoneSetStaticState";
	private static String ON_UNANSWERED_CALL_EVENT = "onUnansweredCall";
	private static String ON_NOMAD_STATE_EVENT = "onNomadState";

	private String m_eventName = null;
	private boolean m_bSessionId;

	java.util.Vector m_calls = null;
	Call m_currentCall = null;
	AlcStaticState m_staticState = null;
	java.util.Vector m_nomadEventParams = null;

	private boolean catchChar = false; // Pour copier les caractères utils

	public AlcEventsHandler(AlcEventsRessource pEventRessource) {
		super();

		this.m_eventRessource = pEventRessource;
		this.m_bSessionId = false;
		this.m_strSessionId = "";
	}

	public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) {
		if (LOGGER.isDebugEnabled() == true) {
			LOGGER.debug("startElement uri = " + uri + ", localName = " + localName + ", qName = " + qName);
		}

		m_currentFieldName = localName;
		// Which type of event
		if (uri.compareTo("http://xmlapi.alcatel.com/phone") == 0) {

			if (localName.compareTo(ON_CALL_STATE_EVENT) == 0) {
				m_eventName = ON_CALL_STATE_EVENT;
			} else if (localName.compareTo(ON_NEW_SESSION_EVENT) == 0) {
				m_eventName = ON_NEW_SESSION_EVENT;
			} else if (localName.compareTo(ON_SESSION_CLOSED_EVENT) == 0) {
				m_eventName = ON_SESSION_CLOSED_EVENT;
			} else if (localName.compareTo(ON_CONNECTION_DOWN_EVENT) == 0) {
				m_eventName = ON_CONNECTION_DOWN_EVENT;
			} else if (localName.compareTo(ON_PHONESET_STATIC_STATE_EVENT) == 0) {
				m_eventName = ON_PHONESET_STATIC_STATE_EVENT;
			} else if (localName.compareTo(ON_UNANSWERED_CALL_EVENT) == 0) {
				m_eventName = ON_UNANSWERED_CALL_EVENT;
			} else if (localName.compareTo(ON_NOMAD_STATE_EVENT) == 0) {
				m_eventName = ON_NOMAD_STATE_EVENT;
			}
		}

		if (localName.compareTo("sessionId") == 0) {
			m_bSessionId = true;
			catchChar = true;
		}
	}

	public void characters(char[] ch, int start, int length) {

		if (m_currentFieldName.compareTo("sessionId") == 0) {

			if (m_bSessionId) {
				this.m_strSessionId = (new String(ch, start, length)).trim();
				m_bSessionId = false;
			}
		} else if (m_eventName != null) {

			String strCurrentField = (new String(ch, start, length)).trim();

			if (m_eventName.equals(ON_CALL_STATE_EVENT)) {

				if (m_currentFieldName.equals("item")) {
					if (m_calls == null) {
						m_calls = new java.util.Vector();
					}
					if (m_currentCall == null) {
						m_currentCall = new Call();
					}
				}

				if ((strCurrentField != null) && (!strCurrentField.equals(""))) {

					if (m_currentFieldName.equals("callRef")) {
						m_currentCall.setCallRef((new Long(strCurrentField)).longValue());
					} else if (m_currentFieldName.equals("number")) {
						m_currentCall.setNumber(strCurrentField);
					} else if (m_currentFieldName.equals("name")) {
						m_currentCall.setName(strCurrentField);
					} else if (m_currentFieldName.equals("state")) {
						m_currentCall.setState(CallState.fromString(strCurrentField));
					} else if (m_currentFieldName.equals("correlator")) {
						m_currentCall.setCorrelator(org.apache.axis.types.HexBinary.decode(strCurrentField));
					}
				}
			} else if (m_eventName.equals(ON_PHONESET_STATIC_STATE_EVENT)) {

				if (m_currentFieldName.equals("state")) {
					if (m_staticState == null) {
						m_staticState = new AlcStaticState();
						m_staticState.setForwardState(new AlcForwardState());
					}
				}

				if ((strCurrentField != null) && (!strCurrentField.equals(""))) {
					if (m_currentFieldName.equals("type")) {
						m_staticState.getForwardState().setType(AlcForwardType.fromString(strCurrentField));
					} else if (m_currentFieldName.equals("targetNumber")) {
						m_staticState.getForwardState().setTargetNumber(strCurrentField);
					} else if (m_currentFieldName.equals("name")) {
						m_staticState.getForwardState().setName(strCurrentField);
					} else if (m_currentFieldName.equals("firstName")) {
						m_staticState.getForwardState().setFirstName(strCurrentField);
					} else if (m_currentFieldName.equals("forwardedToVoicemail")) {
						m_staticState.getForwardState().setTargetType(AlcForwardTargetType.fromString(strCurrentField));
					} else if (m_currentFieldName.equals("overflowType")) {
						m_staticState.setOverflowType(AlcOverflowType.fromString(strCurrentField));
					} else if (m_currentFieldName.equals("locked")) {
						m_staticState.setLocked(strCurrentField.equalsIgnoreCase("true"));
					} else if (m_currentFieldName.equals("doNotDisturbActivated")) {
						m_staticState.setDoNotDisturbActivated(strCurrentField.equalsIgnoreCase("true"));
					} else if (m_currentFieldName.equals("campOnActivated")) {
						m_staticState.setCampOnActivated(strCurrentField.equalsIgnoreCase("true"));
					}
				}
			} else if (m_eventName.equals(ON_NOMAD_STATE_EVENT)) {
				if ((strCurrentField != null) && (!strCurrentField.equals(""))) {
					if (m_currentFieldName.equals("mode")) {
						if (m_nomadEventParams == null) {
							m_nomadEventParams = new java.util.Vector();
						}
						NomadMode mode = NomadMode.fromString(strCurrentField);
						m_nomadEventParams.add(mode);
					} else if (m_currentFieldName.equals("homeNumber")) {
						if (m_nomadEventParams == null) {
							m_nomadEventParams = new java.util.Vector();
						}
						m_nomadEventParams.add(strCurrentField);
					}
				}
			}
		}
	}

	public void endElement(String uri, String localName, String qName) {
		catchChar = false;

		if (localName.compareTo("sessionId") == 0) {
			this.m_bSessionId = false;
		}

		if ((m_eventName != null) && (m_eventName.equals(ON_CALL_STATE_EVENT) && (localName.compareTo("item") == 0) && (m_currentCall != null))) {
			m_calls.add(m_currentCall);
			m_currentCall = null;
		}

		if (uri.compareTo("http://xmlapi.alcatel.com/phone") == 0) {

			if (localName.compareTo(ON_CALL_STATE_EVENT) == 0) {

				if (m_calls != null) {
					Call[] calls = (Call[]) m_calls.toArray(new Call[m_calls.size()]);
					this.m_eventRessource.addMessage(ON_CALL_STATE_EVENT, this.m_strSessionId, calls);
					m_calls.clear();
					m_calls = null;
				} else {
					this.m_eventRessource.addMessage(ON_CALL_STATE_EVENT, this.m_strSessionId, null);
				}
				m_eventName = null;
				this.m_strSessionId = "";
			} else if (localName.compareTo(ON_NEW_SESSION_EVENT) == 0) {
				this.m_eventRessource.addMessage(ON_NEW_SESSION_EVENT, this.m_strSessionId, null);
				m_eventName = null;
				this.m_strSessionId = "";
			} else if (localName.compareTo(ON_SESSION_CLOSED_EVENT) == 0) {
				this.m_eventRessource.addMessage(ON_SESSION_CLOSED_EVENT, this.m_strSessionId, null);
				m_eventName = null;
				this.m_strSessionId = "";
			} else if (localName.compareTo(ON_CONNECTION_DOWN_EVENT) == 0) {
				this.m_eventRessource.addMessage(ON_CONNECTION_DOWN_EVENT, this.m_strSessionId, null);
				m_eventName = null;
				this.m_strSessionId = "";
			} else if (localName.compareTo(ON_PHONESET_STATIC_STATE_EVENT) == 0) {
				this.m_eventRessource.addMessage(ON_PHONESET_STATIC_STATE_EVENT, this.m_strSessionId, m_staticState);
				m_staticState = null;
				m_eventName = null;
				this.m_strSessionId = "";
			} else if (localName.compareTo(ON_NOMAD_STATE_EVENT) == 0) {
				this.m_eventRessource.addMessage(ON_NOMAD_STATE_EVENT, this.m_strSessionId, m_nomadEventParams);
				m_nomadEventParams = null;
				m_eventName = null;
				this.m_strSessionId = "";
			} else if (localName.compareTo(ON_UNANSWERED_CALL_EVENT) == 0) {
				this.m_eventRessource.addMessage(ON_UNANSWERED_CALL_EVENT, this.m_strSessionId, null);
				m_eventName = null;
				this.m_strSessionId = "";
			}
		}
	}
}