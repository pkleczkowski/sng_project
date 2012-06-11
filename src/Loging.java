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

	public void logIn(String notifUrl) {
		System.out.println("* zaloguj() 1");
		logIntoApiFramework();
		logIntoXmlPhone();
		subscribe(notifUrl);
		System.out.println("* zaloguj() 2");
	}

	private void logIntoApiFramework() {
		System.out.println("** zalogujDoApiFramework() 1");
		serviceInit();
		try {
			sessionId = xmlApiFramework.login(null, user, pass);
			System.out.println("** zalogujDoApiFramework() 2");
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
				System.out.println("*** inicjalizujSerwis() 2a");
			} else {
				xmlApiFramework = serwis.getXmlApiFramework(new URL(
						FRAMEWORK_URL + "/api/services/2.2/XMLApiFramework"));
				System.out.println("*** inicjalizujSerwis() 2b");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// logowanie do Web Serwisu XMLPhone
	private void logIntoXmlPhone() {
		System.out.println("** zalogujDoXmlPhone() 1");
		if (sessionId != null) {
			XmlPhoneServiceLocator serwis = new XmlPhoneServiceLocator();
			try {
				xmlPhoneSerwis = serwis
						.getXmlPhone(new URL(FRAMEWORK_URL
								+ "/api/services/2.2/XMLPhone?ApiSessionId="
								+ sessionId));
				System.out.println("** zalogujDoXmlPhone() 2");
				alr = xmlPhoneSerwis.login();
				System.out.println("** zalogujDoXmlPhone() 3");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			System.out.println("** zalogujDoXmlPhone() 4");
		}
	}

	// aktywowanie pobierania stanu polaczen
	private void subscribe(String notifUrl) {
		System.out.println("** subskrybuj() 1");
		if (xmlPhoneSerwis != null && notifUrl != null) {
			try {
				xmlPhoneSerwis.subscribe(alr.getSessionId(), notifUrl);
				System.out.println("** subskrybuj() 2");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public void logOut() {
		try {
			xmlPhoneSerwis.unsubscribe(alr.getSessionId());
			System.out.println("* logOut() 1");
			xmlPhoneSerwis.logout(alr.getSessionId());
			System.out.println("* logOut() 2");
			xmlApiFramework.logout();
			System.out.println("* logOut() 3");
		} catch (Exception ex) {
			ex.printStackTrace();
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
