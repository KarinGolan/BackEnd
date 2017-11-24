package Test;


import static org.junit.Assert.*;

import org.junit.Test;

import mypackage.VAT;

public class VatTest {
	
	@Test
	public void test() {
		
		double total_cost=35;
		
		double expected =40.95;
		VAT test1= new VAT();
		double output= test1.totalWithVat(total_cost);
		System.out.println(expected);
		System.out.println(output);
		assertEquals(expected,output,0);
	}

		
	}

	
	


