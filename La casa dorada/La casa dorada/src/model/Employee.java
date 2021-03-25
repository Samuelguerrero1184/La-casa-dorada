package model;

public class Employee extends Person{
	private float id;
		public Employee (String name, String lastname, float id){
		super(name, lastname);
		this.id = id;
	}
	public float getId() {
		return id;
	}
	public void setId(float id) {
		this.id = id;
	}
	
}
