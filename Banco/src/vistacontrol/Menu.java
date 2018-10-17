package vistacontrol;

import java.util.ArrayList;
import java.util.Scanner;

import modelos.*;

public class Menu {
	public static Scanner in = new Scanner(System.in);        
	private static int ID_tarjeta=0;
	private static int Num_card=10000000;
	private static int Num_account=100;
	private static int ID_movement=0;
	private static ArrayList<Tarjeta> cards = new ArrayList<>();
	private static ArrayList<Cuentasueldo> saccount = new ArrayList<>();
	private static ArrayList<Cuentamillonaria> maccount = new ArrayList<>();
	
	public static String getID_movement(){
		ID_movement++;
		return String.valueOf(ID_movement);
	}
	public static String getNum_account() {
		Num_account++;
		return String.valueOf(Num_account);
	}
	public static String getNum_card() {
		Num_card++;
		return String.valueOf(Num_card);
	}
	public static String getID_tajeta() {
		ID_tarjeta++;
		return String.valueOf(ID_tarjeta);		
	}
	
	//Menu
	
	public static void Menu_main() {
		System.out.println("********Menu********");
		System.out.println(" 1. Crear cuenta");
		System.out.println(" 2. Eliminar cuenta");		
		System.out.println(" 3. Crear tarjetas");
		System.out.println(" 4. Enlazar cuenta a tarjeta");
		System.out.println(" 5. Listar tarjetas y cuentas");
		System.out.println(" 6. Bloquear tarjetas");
		System.out.println(" 7. Movimiento");
		System.out.println(" 8. Consulta saldo");
		System.out.println(" 9. Salir");
		System.out.println("Ingrese un numero: ");
	}
	public static void Account_create() {
		System.out.println();
		System.out.println("*¨Crear Cuenta-");
		int n;		
		do {
			System.out.println("\t1. Solo Sueldo");
			System.out.print("Ingrese un numero: ");
			n=Integer.valueOf(in.nextLine());
			switch (n) {
			case 1:
				saccount_create();
				break;

			default:
				n=2;
				break;
			}
		} while (n==2);
		
	}
	public static void Account_delete() {
		System.out.println();
		System.out.println("* Eliminar cuenta-");
		Account_read();
		System.out.print("Ingrese el nro de cuenta que desee eliminar: ");
		String nroac=in.nextLine();
		int ps=-1;
		boolean st_elim= false;
		for(Cuentasueldo c: saccount) {
			ps++;
			if(nroac.equals(c.getNumaccount())) {
				saccount.remove(ps);
				System.out.println("Cuenta eliminada satisfactoriamente...");
				st_elim=true;
			}
		}
		if(st_elim==false) {
			System.out.println("NO SE ENCONTRO LA CUENTA...");
		}
	}
	public static void Account_read() {
		System.out.println();
		System.out.println("* Listar Cuentas-");
		if(saccount.isEmpty()) {
			System.out.println("NO EXISTEN CUENTAS...");
		}else {
			int ps=0;
			System.out.println("Nro \t Cuenta \t Saldo");
			for(Cuentasueldo s: saccount) {
				ps++;
				System.out.println(ps+"\t"+send_nrocard(s.getId_card())+"\t"+s.getNumaccount()+"\t"+String.valueOf(s.getBalance())+"\t"+send_statecard(s.getId_card()));
			}
		}
	}
	public static void Card_create() {
		System.out.println();
		System.out.println("* Crear tarjeta-");
		String password=send_password();
		Tarjeta t = new Tarjeta(password);
		System.out.println();
		System.out.println("Numero de tarjeta: "+ t.getNumber());
		System.out.println("Clave: "+ t.getPassword());
		cards.add(t);
	}
	public static void Card_block() {
		System.out.println();
		System.out.println("* Bloquear cuenta-");
		System.out.print("Ingrese el numero de la tarjeta: ");
		String nrocard = in.nextLine();
		System.out.print("Ingrese la contraseña: ");
		String pass = in.nextLine();
		for(Tarjeta t: cards) {
			if(nrocard.equals(t.getNumber()) && pass.equals(t.getPassword())) {
				t.setState(false);
			}
		}
			
		
	}
	public static void Movement() {
		boolean state=false;
		String id_card=login();			
		if(!id_card.equals(null)) {
			boolean op_B=false;
			System.out.println();
			
			ArrayList<String> aux= new ArrayList<>();
			int ps=0;
			int balance=0;
			for(Cuentasueldo c: saccount) {
				if(id_card.equals(c.getId_card())) {
					System.out.println(ps+"\t"+c.getBalance());
				}
			}
			
			
			
			do {
				System.out.println("*Movimiento-");
				System.out.println(" a. Deposito");
				System.out.println(" b. Retiro");
				System.out.println(" c. Compra");
				System.out.print("Ingrese su opcion: ");
				String op=in.nextLine();
				switch (op) {
				case "a":
					
					break;
				case "b":
					break;
				case "c":
					break;
				default:
					op_B=true;
				}
			}while(op_B);
		}else {
			System.out.println("Nro o contraseña incorrecto!!!");
		}
	}
	public static void Balance_query() {
		
	}
	
	//Metodos Secundarios
	public static String login() {
		System.out.print("Ingrese el nro de la tarjeta: ");
		String nrocard=in.nextLine();
		String pass=send_password();
		boolean state= false;
		for(Tarjeta t: cards) {
			if(t.getNumber().equals(nrocard) && t.getPassword().equals(pass)) {
				state=true;
				nrocard=t.getIdcard();
				break;
			}
		}
		if(state) {
			return nrocard;
		}else {
			return null;
		}
		
	}
	public static void linkcardtoaccount() {
		
	}
	public static String sendDetalle(Movimiento o) {
		int i=o.getDetalle();
		String a=null;
		switch (i) {
		case 1:
			a="Deposito";
			break;
		case 2:
			a="Retiro";
		case 3:
			a="Compra";
		default:
			a="Desconocido";
		}
		return a;
	}
	public static void saccount_create() {
		System.out.println("-Crear Cuenta Sueldo-");
		double balance=send_balance();		
		System.out.println("balance= "+balance);
		String id_card=null;
		boolean op=true;
		do {
			System.out.print("Tiene una tarjeta para agregar a la cuenta s/n: ");
			String sn=in.nextLine();
			if (!sn.equalsIgnoreCase("s") && !sn.equalsIgnoreCase("n")) {
				System.err.println("Valor incorrecto");
			}else {
				if(sn.equalsIgnoreCase("s")) {
					System.out.println("Ingrese el nro de la tarjeta: ");
					String num_card=in.nextLine();
					
					for(Tarjeta t: cards) {
						if(num_card.equals(t.getIdcard())) {
							id_card = t.getIdcard();
							op=false;									
						}
					}
				}else {		
					System.err.println("op=false");
					id_card ="---";
					op=false;							
				}
			}
		} while (op);
		Cuentasueldo c = new Cuentasueldo(balance, id_card);
		saccount.add(c);
	}
	public static String send_statecard(String id_card) {
		String state=null;
		if(id_card.equals("---")) {
			state="---";
		}else {
			for(Tarjeta t: cards) {
				if(id_card.equals(t.getIdcard())) {
					if(t.isState()) {
						state="Activo";
					}else {
						state="Bloqueado";
					}
				}
			}
		}
		return state;
	}
	public static String send_nrocard(String id_card) {
		String nrocard=null;
		if(id_card.equals("---")) {
			nrocard="---";
		}else {
			for(Tarjeta t: cards) {
				if(id_card.equals(t.getIdcard())) {
					nrocard=t.getNumber();
					break;
				}	
			}
		}
		return nrocard;
	}
	public static String send_password() {
		System.out.print("Ingrese una contraseña para la tarjeta: ");
		String pass = in.nextLine();
		return pass;
	}
	public static double send_balance() {
		System.out.println("Ingrese el monto del saldo: ");
		double b=Double.valueOf(in.nextLine());
		System.out.println(b);
		return b;
	}
		
	public static void main(String[] args) {
		int n;
		do {
			Menu_main();
			n=Integer.valueOf(in.nextLine());
			switch (n) {
			case 1:
				Account_create();
				break;
			case 2:
				Account_delete();
				break;				
			case 3:
				Card_create();
				break;
			case 4:
				linkcardtoaccount();
				break;
			case 6:
				Card_block();
				break;
			case 7:
				Movement();
				break;
			case 8:
				Balance_query();
				break;
			case 9:
				System.out.println("May the force be with you...");
				break;
			default:
				break;
			}
		} while (n!=9);
	}
}

