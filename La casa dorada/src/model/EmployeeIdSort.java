package model;
import java.util.Comparator;
public class EmployeeIdSort implements Comparator<Employee> {
@Override
	public int compare(Employee o1, Employee o2) {
		
		return o1.getId().compareToIgnoreCase(o2.getId());
	}
}
