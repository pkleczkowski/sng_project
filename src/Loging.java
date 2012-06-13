import java.net.URL;



import com.alcatel.xmlapi.framework.XmlApiFramework;
import com.alcatel.xmlapi.framework.XmlApiFrameworkService;
import com.alcatel.xmlapi.framework.XmlApiFrameworkServiceLocator;
import com.alcatel.xmlapi.phone.AlcLogonResult;
import com.alcatel.xmlapi.phone.XmlPhone;
import com.alcatel.xmlapi.phone.XmlPhoneServiceLocator;


public class Loging {

	private static final String FRAMEWORK_URL = "http://"
			+ CallProperties.FRAMEWORK_HOST + ":" + CallProperties.FRAMEWORK_PORT;
	private XmlApiFramework xmlApiFramework = null;
	private String sessionId = null;
	private XmlPhone xmlPhoneSerwis = null;
	private AlcLogonResult alr = null;
	private String user = null;
	private String pass = null;

	public Loging(String user, String pass) {
		this.user = user;
		this.pass = pass;
	}

	public boolean logIn(String notifUrl) {
		logIntoApiFramework();
		boolean isLogged = logIntoXmlPhone();
		subscribe(notifUrl);
		return isLogged;
	}

	private void logIntoApiFramework() {
		serviceInit();
		try {
			sessionId = xmlApiFramework.login(null, user, pass);
			System.out.println("** zalogujDoApiFramework()  - done");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (sessionId != null) {
			serviceInit();
		}
	}

	// inicjalizacja serwisu XML API Framework
	private void serviceInit() {
		System.out.println("*** inicjalizujSerwis() 1");
		try {
			XmlApiFrameworkService serwis = new XmlApiFrameworkServiceLocator();
			if (sessionId != null) {
				xmlApiFramework = serwis
						.getXmlApiFramework(new URL(
								FRAMEWORK_URL
										+ "/api/services/2.2/XMLApiFramework?ApiSessionId="
										+ sessionId));
			} else {
				xmlApiFramework = serwis.getXmlApiFramework(new URL(
						FRAMEWORK_URL + "/api/services/2.2/XMLApiFramework"));
				System.out.println("*** inicjalizujSerwis() -done");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// logowanie do Web Serwisu XMLPhone
	private boolean logIntoXmlPhone() {
		if (sessionId != null) {
			XmlPhoneServiceLocator serwis = new XmlPhoneServiceLocator();
			try {
				xmlPhoneSerwis = serwis
						.getXmlPhone(new URL(FRAMEWORK_URL
								+ "/api/services/2.2/XMLPhone?ApiSessionId="
								+ sessionId));
				alr = xmlPhoneSerwis.login();
				System.out.println("** zalogujDoXmlPhone() -done");
				return true;
			} catch (Exception ex) {
				ex.printStackTrace();
				return false;
			}
		}
		else return false;
	}

	// aktywowanie pobierania stanu polaczen
	private void subscribe(String notifUrl) {
		if (xmlPhoneSerwis != null && notifUrl != null) {
			try {
				xmlPhoneSerwis.subscribe(alr.getSessionId(), notifUrl);
				System.out.println("** subskrybuj() -done");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public boolean logOut() {
		try {
			xmlPhoneSerwis.unsubscribe(alr.getSessionId());
			xmlPhoneSerwis.logout(alr.getSessionId());
			xmlApiFramework.logout();
			System.out.println("* logOut() -done");
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}



	public XmlApiFramework getXmlApiFramework() {
		return xmlApiFramework;
	}

	public String getSessionId() {
		return sessionId;
	}

	public XmlPhone getXmlPhoneSerwis() {
		return xmlPhoneSerwis;
	}

	public AlcLogonResult getAlr() {
		return alr;
	}

	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}
}
