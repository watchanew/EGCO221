package Ex4_6413112;


import java.util.ArrayDeque;
import java.util.Comparator;
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
    public int getID()
    {
        return ID;
    };
    public int priority()
    {
        return priority;
    };
    public int seats()
    {
        return seats;
    };
    public void print() {
        System.out.printf("%d  %d %d \n", ID, priority, seats);
    }
}

class Restaurant {
    private int maxSeats, maxTime; // from user input
    public  PriorityQueue<Customer> waitingQueue = new PriorityQueue<Customer>(); // sorted by priority, then by ID
    private ArrayDeque<Customer> diningQueue;
    public int seatreq,reqseat;
    Random rand = new Random();
 
    public void simulation(int maxSeats,int maxTime) { 
        /* implement restaurant simulation */ 
        
        for (int t = 1; t <= maxTime ; t++) //change it to MaxTime
        {
            //create a new Customer with random priority & random seats (1-10). put new customer in waitingQueue
                int Random_p = rand.nextInt(3) + 1; //random priority 
                int Random_s = rand.nextInt(10) + 1; //random seat 
                waitingQueue.add(new Customer(t, t, Random_s));
                System.out.printf("[Customer %d, normal, books  %d seats]\n",waitingQueue);

        }

        //System.out.println("New arrival >> ");
        //System.out.printf("\nSize 2 = %d \n", waitingQueue.size());
        for (int j = 1; j <= 2; j++)
        {   
            //System.out.println("Customer to dine %d >> ");
            //System.out.printf("[Customer %d, normal, books  %d seats]\n",waitingQueue);

        }
    }
}

class SortByPriority implements Comparator<Customer>
{

    @Override
    public int compare(Customer o1, Customer o2) {
        // TODO Auto-generated method stub
        return 0;
    }

}

public class Process
{
    public static void main(String[] args)
    {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Restaurant r = new Restaurant();

        System.out.println("Enter max seats = ");
        int maxSeats = sc1.nextInt();
        System.out.println("Enter max time = ");
        int maxTime = sc2.nextInt();
        System.out.println("=== Customers already in queue ===");
        System.out.println("=== Simulation ===");
        r.simulation(maxSeats,maxTime);
 
    }
}

