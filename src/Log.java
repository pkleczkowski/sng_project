import java.net.URL;

import com.alcatel.xmlapi.common.AlcServiceException;
import com.alcatel.xmlapi.framework.XmlApiFramework;
import com.alcatel.xmlapi.framework.XmlApiFrameworkService;
import com.alcatel.xmlapi.framework.XmlApiFrameworkServiceLocator;
import com.alcatel.xmlapi.phone.AlcLogonResult;
import com.alcatel.xmlapi.phone.XmlPhone;
import com.alcatel.xmlapi.phone.XmlPhoneServiceLocator;


public class Log {
	
	private String apiFwUrl = null;
	private XmlApiFramework xmlApiFramework = null;
	private String idSesji = null;
	private XmlPhone xmlPhoneSerwis = null;
	private AlcLogonResult alr = null;
	private String user = null;
	private String pass = null;
	
	
	public Log(){
		inicjujDane();
	}

	public void inicjujDane(){
		String apiFwHost = "194.29.169.39";
		String apiFwPort = "8080";
		apiFwUrl = "http://" + apiFwHost + ":" + apiFwPort;
    	user = "user505";
		pass = "123";
	}
	
	
	
	private void zalogujDoApiFramework()
	{
		inicjalizujSerwis();
 					
		try 
		{
			//System.out.println("user "+user);
			//System.out.println("pass "+pass);
			
			idSesji = xmlApiFramework.login(null, user, pass);
		} 
		catch (Exception w) 
		{
			w.printStackTrace();
		}
		
		if(idSesji != null)
			inicjalizujSerwis();
	}
	
	//inicjalizacja serwisu XML API Framework
	private void inicjalizujSerwis()
    {
		System.out.println("DB log do XmlFramework");
    	try 
    	{
			XmlApiFrameworkService serwis = new XmlApiFrameworkServiceLocator();
			if (idSesji != null) 
				xmlApiFramework = serwis.getXmlApiFramework(new URL(apiFwUrl + "/api/services/2.2/XMLApiFramework?ApiSessionId=" + idSesji));
			else 
				xmlApiFramework = serwis.getXmlApiFramework(new URL(apiFwUrl + "/api/services/2.2/XMLApiFramework"));
		} 
		catch (Exception w) 
		{
			w.printStackTrace();
		}
	}
	
	//logowanie do Web Serwisu XMLPhone
	private void zalogujDoXmlPhone()
	{
		System.out.println("DB log do XmlPhone");
		if(idSesji != null)
		{
			XmlPhoneServiceLocator serwis = new XmlPhoneServiceLocator();
			System.out.println("DB log do XmlPhone 1");
			try 
			{
				xmlPhoneSerwis = serwis.getXmlPhone(new URL(apiFwUrl + "/api/services/2.2/XMLPhone?ApiSessionId=" + idSesji));
				System.out.println("DB log do XmlPhone 2");
				alr = xmlPhoneSerwis.login();
				System.out.println("DB log do XmlPhone 3");
			}
			catch(Exception w) 
			{	
				System.out.println("Blad przy wyciaganiu ID");
				//w.printStackTrace();
			}
		}
	}

	public void zaloguj(){
		zalogujDoApiFramework();
		zalogujDoXmlPhone();
	}
	
	public void wyloguj(){

		try{
			xmlPhoneSerwis.logout(alr.getSessionId());
			xmlApiFramework.logout();
		}catch(AlcServiceException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public String getApiFwUrl() {
		return apiFwUrl;
	}



	public void setApiFwUrl(String apiFwUrl) {
		this.apiFwUrl = apiFwUrl;
	}



	public XmlApiFramework getXmlApiFramework() {
		return xmlApiFramework;
	}



	public void setXmlApiFramework(XmlApiFramework xmlApiFramework) {
		this.xmlApiFramework = xmlApiFramework;
	}



	public String getIdSesji() {
		return idSesji;
	}



	public void setIdSesji(String idSesji) {
		this.idSesji = idSesji;
	}



	public XmlPhone getXmlPhoneSerwis() {
		return xmlPhoneSerwis;
	}



	public void setXmlPhoneSerwis(XmlPhone xmlPhoneSerwis) {
		this.xmlPhoneSerwis = xmlPhoneSerwis;
	}



	public AlcLogonResult getAlr() {
		return alr;
	}



	public void setAlr(AlcLogonResult alr) {
		this.alr = alr;
	}



	public String getUser() {
		return user;
	}



	public void setUser(String user) {
		this.user = user;
	}



	public String getPass() {
		return pass;
	}



	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
	


}
