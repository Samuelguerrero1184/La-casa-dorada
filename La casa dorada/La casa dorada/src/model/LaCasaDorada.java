package model;

import java.util.ArrayList;
import java.util.List;

public class LaCasaDorada {
	
	private List<User>userAcc;
	
	public LaCasaDorada () {
		userAcc = new ArrayList<>();
	}

	public List<User> getUserAcc(){
		return userAcc;
	}
}