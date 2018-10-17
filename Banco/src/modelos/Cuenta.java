package modelos;

import vistacontrol.Menu;

public class Cuenta {
	protected String numaccount;
	protected double balance;
	protected String id_card;
	public Cuenta() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cuenta(double balance, String id_card) {		
		this.numaccount = Menu.getNum_account();
		this.balance = balance;
		this.id_card = id_card;
	}
	public String getNumaccount() {
		return numaccount;
	}

	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getId_card() {
		return id_card;
	}
	public void setId_card(String id_card) {
		this.id_card = id_card;
	}
	
	
}
