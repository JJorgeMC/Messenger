package modelos;

import vistacontrol.Menu;

public class Tarjeta {
	private String idcard;
	private String number;
	private String password;
	private boolean state;
	public Tarjeta() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tarjeta(String password) {
		super();
		this.idcard = Menu.getID_tajeta();
		this.number = Menu.getNum_card();
		this.password = password;
		this.state = true;
	}
	public String getIdcard() {
		return idcard;
	}

	public String getNumber() {
		return number;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	
	
}
