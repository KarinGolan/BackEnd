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
			 Process proc1 = Runtime.getRuntime().exec( "java -jar C:\\FinalProject\\Database.jar "+total_cost);
			 proc1.waitFor();
			 InputStream in = proc1.getInputStream();
			 InputStream err = proc1.getErrorStream();
			   byte[] b=new byte[in.available()];
			    in.read(b,0,b.length);
			    System.out.println(new String(b));
			    byte c[]=new byte[err.available()];
			    err.read(c,0,c.length);
			    System.out.println(new String(c));
			  
		}
		
}		
				
				

	

