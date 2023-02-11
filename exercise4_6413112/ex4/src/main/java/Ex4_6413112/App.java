package Ex4_6413112;


import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;
import java.util.random.*;
import java.io.*;
 
class Customer {
    private static int runningID = 1; // for running customer ID
    private int ID;
    private int priority; // 1 = vvip, 2 = vip, 3 = normal 
    private int seats; // booked seats

    //Constructor
    public Customer (int ID, int priority, int seats)
    {
        this.ID = ID;
        this.priority = priority;
        this.seats = seats;
    }
}

class Restaurant {
    private int maxSeats, maxTime; // from user input
    //private PriorityQueue<Customer> waitingQueue; // sorted by priority, then by ID
    //private ArrayDeque<Customer> diningQueue;
    public void simulation() { 
        /* implement restaurant simulation */ 


        
    }
}

public class App 
{
    public static void main( String[] args )
    {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Enter max seats = ");
        int maxSeats = sc1.nextInt();
        System.out.println("Enter max time = ");
        int maxTime = sc2.nextInt();

        System.out.println("=== Customers already in queue ===");
        
        //create a new Customer with random priority & random seats (1-10). put new customer in waitingQueue
        for (int i = 1; i <=5 ; i++)
        {
            int Random = rand.nextInt(10) + 1;
            System.out.printf("[Customer %d, normal, books  %d seats]\n",i,Random);

        }

        System.out.println("=== Simulation ===");
        //System.out.println("New arrival >> ");
        
       
        
        
    }
}
