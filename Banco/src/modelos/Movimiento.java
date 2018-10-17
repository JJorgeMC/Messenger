package modelos;

import vistacontrol.Menu;
public class Movimiento {
	private String idmovimiento;
	private int detalle;
	private double importe;
	private String idcuenta;
	public Movimiento() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movimiento(int detalle, double importe, String idcuenta) {
		super();
		this.idmovimiento = Menu.getID_movement();
		this.detalle = detalle;
		this.importe = importe;
		this.idcuenta = idcuenta;
	}
	public String getIdmovimiento() {
		return idmovimiento;
	}
	public void setIdmovimiento(String idmovimiento) {
		this.idmovimiento = idmovimiento;
	}
	public int getDetalle() {
		return detalle;
	}
	public void setDetalle(int detalle) {
		this.detalle = detalle;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public String getIdcuenta() {
		return idcuenta;
	}
	public void setIdcuenta(String idcuenta) {
		this.idcuenta = idcuenta;
	}
	
}
