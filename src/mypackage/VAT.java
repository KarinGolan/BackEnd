package mypackage;


public class VAT {
double payingVat=0;

public double  totalWithVat (double total_cost) {
	
	payingVat = total_cost*17/100;
	total_cost = total_cost+payingVat;
	
	return total_cost;
}

public double kaka(double total_cost)	
	{
		return total_cost;
}
}