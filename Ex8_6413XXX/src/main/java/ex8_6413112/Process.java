//6413xxx 
//6413xxx 
//update 02.29 27/03/23

package ex8_6413112;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
 

class FlagFeatureMap {
    // Key = feature, Value = set of countries
    TreeMap<String, LinkedHashSet<String>> workingMap; //String,Integer
    private LinkedHashSet<String> allCountries;
    
    public void includeCountries(ArrayList<String> wantedFeatures) {
        // Get set of countries using each wanted feature as a key
        // Use set operations to include countries whose flags have wanted features
    }

    public void excludeCountries(ArrayList<String> unwantedFeatures) {
        // Get set of countries using each unwanted feature as a key
        // Use set operations to exclude countries whose flags have unwanted features
    }
    public FlagFeatureMap() // constructor
    {
        workingMap = new TreeMap<String, LinkedHashSet<String>>();
        allCountries = new LinkedHashSet<String>();
    
    }
}
public class Process
{
    //Write a main class to do the following:
    //2.1 Read data from flags.txt into workingMap and allCountries.
    public static void main (String[] args)
    {
        String filename = "flags.txt";
        //char temp = ',';
            try{
                TreeSet<String> allFlag = new TreeSet<String>();
                Scanner filescan = new Scanner(new File(filename));
                //String line = file.nextLine();
                while(filescan.hasNextLine())
                {
                    LinkedHashSet<String> flag = new LinkedHashSet<String>();
                    String buf[] = filename.split(",");
                    for(int i = 0 ; i < buf.length;i++)
                    {
                        allFlag.add(buf[i]);
                        flag.add(buf[i]);
                    }
                    //String temp = filesc
                    FlagFeatureMap F = new FlagFeatureMap();
                    F.workingMap.put(buf[0],flag);
                    System.out.println(buf[i]);
                }

            }catch(FileNotFoundException e)
            {
                System.out.println(e);
            }

        
    }
    
}