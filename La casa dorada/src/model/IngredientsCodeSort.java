package model;
import java.util.Comparator;
public class IngredientsCodeSort implements Comparator<Ingredients>{
@Override
	public int compare(Ingredients o1, Ingredients o2) {
		
	return o1.getName().compareToIgnoreCase(o2.getName());
	}
}
