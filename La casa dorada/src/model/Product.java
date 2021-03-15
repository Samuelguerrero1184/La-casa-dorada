package model;

public class Product {
	
	private String name;
	private String tipo;
	private Ingredients[]ingredients;
	private float sizes;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Ingredients[] getIngredients() {
		return ingredients;
	}
	public void setIngredients(Ingredients[] ingredients) {
		this.ingredients = ingredients;
	}
	public float getSizes() {
		return sizes;
	}
	public void setSizes(float sizes) {
		this.sizes = sizes;
	}
	
}
