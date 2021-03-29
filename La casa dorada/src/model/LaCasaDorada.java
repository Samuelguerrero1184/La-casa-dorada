package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class LaCasaDorada {
	private List<User>userAcc;
	private List<Client>clients;
	private List<Employee>employee;
	
	public LaCasaDorada () {
		userAcc = new ArrayList<>();
		clients = new ArrayList<>();
		employee = new ArrayList<>();
	}
	
	public void addClient(String na, String in, String id, String add, String phone, String comments)throws IOException {
		/*int counter = 0;
		int x = this.getClients().size()+1;
		Client[]array = new Client[x];
		for (int i = 0; i<x;i++) {					
			array[i]=this.getClients().get(i);
		}
		while (counter<x && na.compareToIgnoreCase(array[counter].getName())<=0){
			counter++;
		}
		for (int i = x; i >counter; i--) {
			clients.set(i, clients.get(i-1));
		}
		clients.set(counter-1, new Client(na, in, id, add, phone, comments));
		*/
		clients.add(new Client(na, in, id, add, phone, comments));
		saveClients();
	}
	public void addEmployee(String na, String in, String id)throws IOException {
		employee.add(new Employee(na, in, id));
		saveEmployees();
	}
	
	public List<User> getUserAcc(){
		return userAcc;
	}
	public List<Client> getClients(){
		return clients;
	}
	public List<Employee> getEmployee(){
		return employee;
	}
	
	
		public void saveClients() throws IOException {
		FileOutputStream fos = new FileOutputStream("data/Saved_clients.va");
		ObjectOutputStream out = new ObjectOutputStream(fos);
		out.writeObject(clients);
		out.close();
	}
		
		public void saveEmployees() throws IOException {
			FileOutputStream fos = new FileOutputStream("data/Saved_employees.va");
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(employee);
			out.close();
		}

		@SuppressWarnings("unchecked")
		public void load() throws ClassNotFoundException, IOException {
		File cload = new File("data/Saved_clients.va");
		if (cload.exists()) {
			FileInputStream fis = new FileInputStream(cload);
			ObjectInputStream input = new ObjectInputStream(fis);
			clients = (ArrayList<Client>) input.readObject();
			input.close();
		}
		File eload = new File("data/Saved_employees.va");
		if (eload.exists()) {
			FileInputStream fis = new FileInputStream(eload);
			ObjectInputStream input = new ObjectInputStream(fis);
			employee = (ArrayList<Employee>) input.readObject();
			input.close();
		}
		}
		/**
			public void importSelleres(String namefile) throws IOException, FileNotFoundException{
		
		File input = new File ("data/" +namefile +".txt");
		if(input.exists()) {
		FileReader fr = new FileReader (input);
		BufferedReader br = new BufferedReader(fr);
		String linea;
		int contador = 0;
		while ((linea = br.readLine()) != null) {
			if (contador != 0) {
				String[] datosLinea = linea.split(";");
				String name = datosLinea[0];
				String lastname = datosLinea[1];
				String strcedula = datosLinea[2];
				int cedula = Integer.parseInt(strcedula);
				Seller newSeller = new Seller(name, lastname, cedula, 0);
				addSeller(newSeller);
			}
			contador++;
		}	
		}else 
			throw new FileNotFoundException("El archivo no pudo ser encontrado, intenta de nuevo");


	}
	*/
	public String searchEmployee(String id) {
		Collections.sort(employee, new EmployeeIdSort());
		Employee veh = null;
		String str = "";
		boolean found = false;
		int start = 0;
		int end = employee.size();
		while (start <= end && !found) {
			int medium = (int) Math.floor((start + end) / 2);
			if (medium != employee.size()) {
				String mediumElement = employee.get(medium).getId();
				int compareResult = id.compareToIgnoreCase(mediumElement);
				if (compareResult == 0) {
					found = true;
					veh = employee.get(medium);
					str += "Esta es la informacion del empleado:\n";
					str +=veh.getName() + "\n" + veh.getLastname() + "\n"+ veh.getId() + "\n";
				} else if (compareResult < 0)
					end = medium - 1;
				else if (compareResult > 0)
					start = medium + 1;
			}
		}
		if (found == false) {
			str = "No se encontro un empleado con cedula " + id +"\n";
			
		}

		return str;

	}
		public String deleteEmployee(String id) throws IOException {
		Collections.sort(employee, new EmployeeIdSort());
		Employee veh = null;
		String str = "";
		boolean found = false;
		int start = 0;
		int end = employee.size();
		while (start <= end && !found) {
			int medium = (int) Math.floor((start + end) / 2);
			if (medium != employee.size()) {
				String mediumElement = employee.get(medium).getId();
				int compareResult = id.compareToIgnoreCase(mediumElement);
				if (compareResult == 0) {
					found = true;
					veh = employee.get(medium);
					str += "Se eliminó el siguiente empleado";
					str +=veh.getName() + "\n" + veh.getLastname() + "\n"+ veh.getId() + "\n";
					employee.remove(veh);
				} else if (compareResult < 0)
					end = medium - 1;
				else if (compareResult > 0)
					start = medium + 1;
			}
		}
		if (found == false) {
			str = "No se encontro un empleado con cedula " + id +"\n";
			
		}

		return str;

	}
}