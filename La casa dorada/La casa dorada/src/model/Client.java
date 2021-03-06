package model;

public class Client extends Person {
private float id;
private String address;
private String phone;
private String comments;
	public Client (String name, String lastname, float id, String address, String phone, String comments){
		super(name, lastname);
		this.id = id;
		this.address = address;
		this.phone = phone;
		this.comments = comments;
	}
	public float getId() {
		return id;
	}
	public void setId(float id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
}