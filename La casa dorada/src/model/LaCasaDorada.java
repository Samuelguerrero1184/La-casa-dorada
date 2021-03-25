package model;

import java.util.ArrayList;
import java.util.List;

public class LaCasaDorada {
	private List<User>userAcc;
	private List<Client>clients;
	
	public LaCasaDorada () {
		userAcc = new ArrayList<>();
		clients = new ArrayList<>();
	}

	public List<User> getUserAcc(){
		return userAcc;
	}
	public List<Client> getClients(){
		return clients;
	}
	
}