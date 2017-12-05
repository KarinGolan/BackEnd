package mypackage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class FoodOrders {


		public static void main(String[] args) throws Exception, InterruptedException {
			
				ServerSocket listener = new ServerSocket(8070);
		        try {
		            while (true) {
		                new CalculateTotalCost(listener.accept()).start();
		            }
		        } finally {
		            listener.close();
		        }

		
		
		
		//operate a metode 
		//total_cost=Vatobject.totalWithVat(total_cost);
		
		//total_cost= maincourse+side+drink;
		//	System.out.println("The total cost of the order is :" +total_cost);
		}
		
	    private static class CalculateTotalCost extends Thread {
	        private Socket socket;
			BufferedReader inFromDB;
		    PrintWriter outToDB;
		    double total_cost;
	        public CalculateTotalCost(Socket socket) {
	            this.socket = socket;
	        }
	        
	        public void run() {
	            try {

	            	BufferedReader in = new BufferedReader(
	                        new InputStreamReader(socket.getInputStream()));
	                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	                while (true) {
	                    String input = in.readLine();
	                    if (input == null || input.equals(".")) {
	                        break;
	                    }
	        	        
	                    VAT Vatobject =new VAT();
	                    total_cost = Vatobject.totalWithVat(Double.parseDouble(input));
	                    out.println(total_cost);
	                    
	        		    Socket socketDB = new Socket("internal-database-ELB-1104686917.eu-west-1.elb.amazonaws.com",8090);
	        	        inFromDB = new BufferedReader(
	        	                new InputStreamReader(socketDB.getInputStream()));
	        	        outToDB = new PrintWriter(socketDB.getOutputStream(), true);
	        	        outToDB.println(total_cost);

	            }
	            }catch (IOException e) {
	            }
	        }       
	    }
	}
		


				
				

	

