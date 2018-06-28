package presentacion;

import java.util.Scanner;

public class Presentacion {

	public static void main(String[] args) {
		
		Calculadora calc = new Calculadora();
		System.out.println(calc.getOperadores());
		
		Scanner sc = new Scanner(System.in);
		
		String s;
		System.out.print("Introduzca la operacion que quiere realizar: ");
		s = sc.nextLine();
		
		int n1;
		System.out.print("Introduzca un número entero: ");
		n1 = sc.nextInt();
		
		int n2;
		System.out.print("Introduzca otro número entero: ");
		n2 = sc.nextInt();
		
		switch(s) {
		case "SUMA": 
			System.out.println(calc.suma(n1, n2));
			break;
		
		case "MULTIPLICACION":
			System.out.println(calc.multiplicar(n1, n2));
			break;
		
		default: 
			System.out.println("EJECUTE NUEVAMENTE LA APLICACION");
			break;
		}
		
	}
	
}
		
		
		
		
		
		



