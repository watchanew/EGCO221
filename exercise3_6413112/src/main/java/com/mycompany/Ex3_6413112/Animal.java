//MR.SASIT SRIRAT 6413112
package com.mycompany.Ex3_6413112;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
 
public class Animal {
    private String name;
    private int weight, sleep, lifespan, gestation;
    public String getName() {return name;};
    public int getWeight() {return weight;};
    public int getSleep() {return sleep;};
    public int getLifespan() {return lifespan;};
    public int getStation() {return gestation;};
    ArrayList<Animal>A = new ArrayList<Animal>();
    public static void main(String[] args) throws Exception
     {  

        String GetOption;
        List<Animal>cs = new ArrayList<>();
        Scanner g = new Scanner(System.in);
        File file = new File("src/main/java/animals.txt");
        Scanner scanfile = new Scanner(file);
        System.out.println("Sort by >> ");
        while (scanfile.hasNextLine())
        {
            System.out.println(scanfile.nextLine());
        }
        System.out.println(" >> ");
        System.in.getClass();
        GetOption = g.nextLine();
        //System.out.print(GetInput);

        //Each of remaining lines consists of: name, weight (kg), sleep time (hrs/day), maximum lifespan (yrs), and gestation (days)
        System.out.println("Animal\t\t Weight (kg)\tSleep time (hrs/day)\tMaximum lifespan (yrs)\tGestation (days)");
        System.out.println("=======================================================================================");
      
    }
    public void NameSort()
    {
        Collections.sort(A,new SortAnimalByName());
    }
}
 

class SortAnimalByName implements Comparator<Animal>  
{

    @Override
    public int compare(Animal o1, Animal o2) {
        // TODO Auto-generated method stub
        return o1.getName().compareToIgnoreCase(o2.getName());

    }

}
class SortAnimalByWeight implements Comparator<Animal>  
{

    @Override
    public int compare(Animal o1, Animal o2) {
        // TODO Auto-generated method stub
        if (o1.getWeight() > o2.getWeight())
        {
            return -1;
        }
        else if (o1.getWeight() < o2.getWeight())
        {
            return 1;
        }
        else
            return 0;
    }
    
}
 
class SortAnimalBySleep implements Comparator<Animal>
{

    @Override
    public int compare(Animal o1, Animal o2) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
class SortAnimalByLifespan implements Comparator<Animal>
{

    @Override
    public int compare(Animal o1, Animal o2) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}

class SortAnimalByGestation implements Comparator<Animal>  
{

    @Override
    public int compare(Animal o1, Animal o2) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
