

package model;

public class Ingredients {

	private String name;
	private int code;
	
	public Ingredients(String name) {
		this.name = name;
		this.code = (int) (1 + (Math.random() * 1000));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
}
