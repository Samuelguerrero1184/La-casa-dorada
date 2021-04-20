package model;
import java.util.Comparator;
public class ClientSort implements Comparator<Client> {
@Override
	public int compare(Client o1, Client o2) {
		
		return o1.getId().compareToIgnoreCase(o2.getId());
	}
}