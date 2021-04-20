
package model;
import java.util.Comparator;
public class UsernameSort implements Comparator<User> {
@Override
	public int compare(User o1, User o2) {
		
		return o1.getUser().compareToIgnoreCase(o2.getUser());
	}
}