

public class CallProperties {
	public static final String FRAMEWORK_HOST = "194.29.169.39";
	public static final String FRAMEWORK_PORT = "8080";
    
	public static final String NOTIF_SERV_PORT = "10101";
	public static final String EVENT_CONTEXT = "/phone/events";
	public static final String SECRETARY_NUM = "505";
	public static final String SZEF_NUM="402";
	public static final String SZEF_NAME="Prezes Drzymala";
	public static final String HR_NUM="403";
	public static final String HR_NAME="Dzial HR";
	public static final String REKLAMACJA_1_NUM="501";
	public static final String REKLAMACJA_1_NAME="Dzial reklamacji 1";
	public static final String REKLAMACJA_2_NUM="400";
	public static final String REKLAMACJA_2_NAME="Dzial reklamacji 2";
	public static final String LOCALHOST="194.29.169.52";
	
	public static final String TELE_BUSY="BUSY";
	public static final String TELE_FREE="FREE";
    public static String getNotifUrl() {
    	String notifUrl = null;
		try {
			System.out.println("loc-host: " + LOCALHOST);
			notifUrl = "http://" + LOCALHOST + ":" + CallProperties.NOTIF_SERV_PORT
					+ CallProperties.EVENT_CONTEXT;
			System.out.println("notif-URL: " + notifUrl);
			return notifUrl;
		} catch (Exception ex) {
			ex.printStackTrace();
			return notifUrl;
		}
    }
    
}
