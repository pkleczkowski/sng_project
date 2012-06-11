public class Telephone {

	
	private String number = null;
	private Loging log = null;
	private int activity=0;
	
	public Telephone(String number) {
		// Loguje agenta
		this.number = number;
	}
	
	public void logIn(){
		log = new Loging("user" + number, "123");
		log.logIn(CallProperties.getNotifUrl());
	}
	public void logOut(){
		log.logOut();
	}

	public String getNumber() {
		return number;
	}

	public Loging getLog() {
		return log;
	}

	public int getActivity() {
		return activity;
	}

	public void setActivity(int activity) {
		this.activity = activity;
	}
	

}
