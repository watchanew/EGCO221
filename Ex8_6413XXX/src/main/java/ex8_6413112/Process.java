//6413xxx 
//6413xxx 
//update 02.29 27/03/23

package ex8_6413112;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
 

class FlagFeatureMap {
    // Key = feature, Value = set of countries
    private TreeMap<String, LinkedHashSet<String>> workingMap; //String,Integer
    private LinkedHashSet<String> allCountries;
    private ArrayList<String> A ;
    
    public FlagFeatureMap() // constructor
    {
        workingMap = new TreeMap<String, LinkedHashSet<String>>();
        allCountries = new LinkedHashSet<String>();
    }
    public void addCountry(String aCT)
    {
        allCountries.add(aCT);
    }
    public void addFlag(String aCT, ArrayList<String> A)
    {
        for (String i : A) {
            if (workingMap.containsKey(i)) {
                workingMap.get(i).add(aCT);
            } else {
                workingMap.put(i, new LinkedHashSet<String>());
                workingMap.get(i).add(aCT);
            }
        }
    }
    public void includeCountries(ArrayList<String> wantedFeatures) {
        // Get set of countries using each wanted feature as a key
        // Use set operations to include countries whose flags have wanted features

        ArrayList<String> A = new ArrayList<>();
        if(wantedFeatures.isEmpty())
        {
            System.out.print("{}");
            for (String w:workingMap.keySet()) allCountries.add(w);
            A.add("{}");
        }
        else
            {
                for (int i = 0; i < wantedFeatures.size(); i++)
                {
                    //for (String a : allFeature)
                }
            }
    }

    public void excludeCountries(ArrayList<String> unwantedFeatures) {
        // Get set of countries using each unwanted feature as a key
        // Use set operations to exclude countries whose flags have unwanted features
    }

    public void printData()
    {
        System.out.println("Total Countries = " + allCountries.size());
        System.out.println("Total Features = " + workingMap.size());
        Set<String> OutKey = workingMap.keySet();
        for(String key : OutKey)
        {
            LinkedHashSet<String> s = workingMap.get(key);
            if (s != null) {
                System.out.printf("%12s  >>  ", key);
                int i = 0;
                ArrayList<String> list = new ArrayList<String>();
                for (String CT : s) {
                    list.add(CT);
                }
                Collections.sort(list);
                for (String CT : list) {
                    if (i % 7 == 0 && i != 0) {
                        System.out.printf("\n                  ");
                    }
                    System.out.printf("%-15s  ", CT);
                    i++;
                }
            }
            System.out.printf("\n\n\n");

        }
    }
}
public class Process
{
    //Write a main class to do the following:
    //2.1 Read data from flags.txt into workingMap and allCountries.
    public static void main (String[] args)
    {
        FlagFeatureMap F = new FlagFeatureMap();
        ArrayList<String> A = new ArrayList<String>();

        String filename = "flags.txt";

            try{
                TreeSet<String> allFlag = new TreeSet<String>();
                LinkedHashSet<String> flag = new LinkedHashSet<String>();

                Scanner filescan = new Scanner(new File(filename));
                //String line = file.nextLine();
                while(filescan.hasNextLine())
                {
                    String buf[] = filescan.nextLine().split(",");
                    String last = buf[buf.length - 1];
                    F.addCountry(buf[0].trim());
                    //System.out.println(last); //show colour,flag
                    //System.out.println(buf[0].trim()); //show Countries
                    //System.out.println(filescan.nextLine()); //printall
                    for(int i = 1 ; i < buf.length;i++)
                    {
                        A.add(buf[i].trim());
                        //System.out.println(buf[i].trim()); //flag,country
                        //allFlag.add(buf[i]);
                        //flag.add(buf[i]);
                    }
                    F.addFlag(buf[0].trim(),A);
                    A.clear();
                }
            }catch(FileNotFoundException e)
            {
                System.out.println(e);
            }
            F.printData();
    }
    
}
