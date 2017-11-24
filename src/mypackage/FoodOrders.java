package mypackage;
import java.io.InputStream;

public class FoodOrders {


		public static void main(String[] args  ) throws Exception, InterruptedException {
			
		
		double total_cost = Double.parseDouble (args[0]);	
		//decler a VAT object
		VAT Vatobject =new VAT();
		
		
		//operate a metode 
		total_cost=Vatobject.totalWithVat(total_cost);
		
		//total_cost= maincourse+side+drink;
			System.out.println("The total cost of the order is :" +total_cost);
			
		
		//calling to Database jar to store the data
			
			  
		}
		
}		
				
				

	

