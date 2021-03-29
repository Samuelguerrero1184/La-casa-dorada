package model;

public class Employee extends Person{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
		public Employee (String name, String lastname, String id){
		super(name, lastname);
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
