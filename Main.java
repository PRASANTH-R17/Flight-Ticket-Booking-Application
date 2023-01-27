import java.util.ArrayList;
import java.util.Scanner;

class Dataentry{
    int flightid=0;
    int tickets; //ticket available
    int price;  // current cost of the ticket
    ArrayList<String> passenger_name; //passenger_name
    ArrayList<Integer> amount; //how Passengers paid for a ticket
    ArrayList<Integer> ticket_count; //each person buy how many tickets
    
    public Dataentry(){ //constructer for dataentry
        tickets=50;
        price=5000;
        passenger_name=new ArrayList<String>();
        amount=new ArrayList<Integer>();
        ticket_count=new ArrayList<Integer>();
    }
    
    public void flightsummary(){  //flight current details
        System.out.println("--- Current Flight Details ---");
        System.out.println("FlightID -> "+flightid+" , Remaining Tickets->"+tickets+ " , Current ticket price-> "+price+"\n");
        return ;
        
    }
    public void book(String passenger,int t){
        System.out.println("--- Successfully Booked ---");
        System.out.println("Passenger Details->"+ passenger+" , Number of tickers booked-> "+t+" , Total Cost-> "+(price+(t*200))+"\n");
        passenger_name.add(passenger); // add passenger details
        amount.add(price+(t*200)); // add total amount
        ticket_count.add(t); // no of ticket booked
        tickets=tickets-t;   // minus a ticket count
        price=price+(200*t); //increase ticket price
        

    }
    public void cancelTicket(int passenger_index){
        price=price-(ticket_count.get(passenger_index)*200);
        tickets=tickets+ticket_count.get(passenger_index);
        passenger_name.remove(passenger_index);
        amount.remove(passenger_index);
        ticket_count.remove(passenger_index);
        System.out.println("Successfully Canelled\n");
    }
    
    public void passenger_details(){
        System.out.println("................Flight "+flightid+" Details................");
        for(int i=0;i<passenger_name.size();i++)
            System.out.println("Passenger_name : "+passenger_name.get(i)+", Ticket count : "+ticket_count.get(i)+", amount paid : "+amount.get(i));
        }
 
        
 
    
    
    
}

public class Main
{
	public static void main(String[] args) {
	    
	    Scanner sc=new Scanner(System.in); // create object 
	    ArrayList<Dataentry> flights=new ArrayList<Dataentry>();
	    for(int i=1;i<3;i++){
	        flights.add(new Dataentry());
	    }
	    int count=1; //assign flightID
	    
	    for(Dataentry f: flights){
	        f.flightid=count;
	        count=count+1;
	        System.out.println(f.flightid);
	    }
	    
	    
	    while(true){
	        System.out.println("1.Book 2.Cancel 3.Print");
	        int choice=sc.nextInt();
	        switch(choice)
	        {
	            case 1:
	           {  //booking
	                System.out.println("Enter flightID : ");
	                int fid=sc.nextInt();
	                
	                if(fid>flights.size()){
	                    System.out.println("Invalid FlightID");
	                    
	                   }
	                
	                Dataentry currentflight=null; //current flight 
	                for(Dataentry f: flights)
	                {   
	                    if(f.flightid==fid)
	                    {   
	                        currentflight=f;
	                        f.flightsummary();
	                        break;
	                    }
	                }
	                sc.nextLine();
	                System.out.println("Enter Passenger Name : ");
	                String passenger=sc.nextLine(); //passenger details
	                
	                System.out.println("Enter Number of Tickets : ");
	                int t=sc.nextInt();   //no of tickets
	            
	                if(t>currentflight.tickets){
	                    System.out.println("Not Enough Tickets");
	                    break;}
	                    
	                currentflight.book(passenger,t);
	                currentflight.flightsummary();
	                break;
	                        
	            }
	            case 2:{
	               
	                System.out.println("Enter Flight ID : "); //get flightid
	                int fid=sc.nextInt();
	                
	                if(fid>flights.size()){ // check flightID
	                    System.out.println("Invalid Flight Details");
	                    break;}
	                    
	            Dataentry currentflight=null;  //current flight     
	            
	            for(Dataentry f:flights){ 
	                if(f.flightid==fid)
	                    currentflight=f;
	                    break;
	            }   sc.nextLine();
	                System.out.println("Enter Passenger Name : ");
	                String passenger=sc.nextLine();
	                

	                int passenger_index;
	                passenger_index=currentflight.passenger_name.indexOf(passenger);
	                
	                if(passenger_index==-1){
	                    System.out.println("Invalid Passenger Details");
	                    break;}
	                    
	                currentflight.cancelTicket(passenger_index);
	                currentflight.flightsummary();

	                
	            }
	            
	            case 3:
	           {
	                for(Dataentry f:flights)
	                {
	                    f.passenger_details();
	                    f.flightsummary();
	                }
	            }
	                        
	                        
	                
	                
	        }
	        
	        
	        
	        
	        
	        
	        
	    }
	    
		
	}
}
