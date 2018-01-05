package mypackage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class FoodOrders {

	
	
		public static void main(String[] args) throws Exception, InterruptedException 
		{
			
			 
			int num,num1 ;
			num = Integer.parseInt(args[0]);
			num1 = Integer.parseInt(args[2]);
				ServerSocket listener = new ServerSocket(num);
				
		        try {
		        	
		        		while (true) 
		        		{
		        			new CalculateTotalCost(listener.accept(),args[1],num1).start();
		            	}
		        		
		            } finally
		        		{
		        			listener.close();
		        		}

		}
		
	    private static class CalculateTotalCost extends Thread {
	        private Socket socket;
			BufferedReader inFromDB;
		    PrintWriter outToDB;
		    double total_cost;
			private String hostname;
			private int port;
		
			
		
		    
	        public CalculateTotalCost(Socket socket,String hostname,int port) {
	            this.socket = socket;
	            this.hostname=hostname;
	            this.port=port;
	        }
	        
	      

			public void run () {
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
	                   //internal-database-ELB-1104686917.eu-west-1.elb.amazonaws.com 
	        		    
	        		    
						Socket socketDB = new Socket(hostname,port);
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
		


				
				

	

