public class Telephone {

	
	private String number = null;
	private String name = null;
	private Loging log = null;
	private int activity=0;
	private String state = CallProperties.TELE_FREE;
	private String status = "FREE";
	
	public Telephone(String name,String number) {
		this.name=name;
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

	public String getName() {
		return name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

	

}
