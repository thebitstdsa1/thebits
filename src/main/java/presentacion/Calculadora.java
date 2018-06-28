package presentacion;

import java.util.ArrayList;

public class Calculadora {
	
	private ArrayList<String> operadores;
		
	
	public int suma(int a, int b) {
		return a+b;
	}
	
	public int multiplicar(int a, int b) {
		return a*b;
	}
	
	
	public void setOperadores(String e) {
		this.operadores.add(e);
	}
	
	public ArrayList<String> getOperadores(){
		return this.operadores;
	}
	
	public Calculadora() {
		this.operadores = new ArrayList<String>();
		
		this.setOperadores("SUMA");
		//this.setOperadores("MULTIPLICACION");		
	}
	
}
