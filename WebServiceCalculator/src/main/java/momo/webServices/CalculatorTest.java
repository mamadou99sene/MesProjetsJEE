package momo.webServices;

import ucad.fst.stubgenere.Calculator;
import ucad.fst.stubgenere.CalculatorSoap;

public class CalculatorTest {

	public static void main(String[] args) {
		Calculator cal=new Calculator();
		CalculatorSoap csoap=cal.getCalculatorSoap();
		//int somme=
		System.out.println("division  "+csoap.divide(10, 5));
		System.out.println(" addition "+csoap.add(20, 6));
		System.out.println(" multiplication  "+csoap.multiply(3, 9));
	}

}
