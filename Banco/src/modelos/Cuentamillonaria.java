package modelos;

public class Cuentamillonaria extends Cuenta {
	protected double bono_apertura;

	public Cuentamillonaria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cuentamillonaria(double balance, String id_card) {
		super(balance, id_card);
		// TODO Auto-generated constructor stub
	}

	public Cuentamillonaria(double balance, String id_card, double bono_apertura) {
		super(balance, id_card);
		this.bono_apertura = bono_apertura;
	}
}


