package model;

public class User extends Person {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private float id;
	private String user;
	private String psw;
		public User (String name, String lastname, float id, String user, String psw){
		super(name, lastname);
		this.id = id;
		this.setUser(user);
		this.setPsw(psw);
	}
	public float getId() {
		return id;
	}
	public void setId(float id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	
}