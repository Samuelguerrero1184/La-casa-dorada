package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String name;
private String tipo;
private String size;
private ArrayList<Ingredients> ingredients;
	public Product(String name, String tipo, String size){
		this.name = name;
		this.tipo = tipo;
		this.size = size;
		ingredients = new ArrayList<Ingredients>();
	}
	
	public void addIngredient(Ingredients newIngredient){
		ingredients.add(newIngredient);
	}
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
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public ArrayList<Ingredients> getIngredients() {
		return ingredients;
	}
	public void setIngredients(ArrayList<Ingredients> ingredients) {
		this.ingredients = ingredients;
	}
}
