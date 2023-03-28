//6413112 
//6413110
//update 17.25 28/03/23

package ex8_6413112;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class FlagFeatureMap {
    // Key = feature, Value = set of countries
    private TreeMap<String, LinkedHashSet<String>> workingMap; // String,Integer
    private LinkedHashSet<String> allCountries;
    private ArrayList<String> A;
    private List<String> L;

    public FlagFeatureMap() // constructor
    {
        workingMap = new TreeMap<String, LinkedHashSet<String>>();
        allCountries = new LinkedHashSet<String>();
        A = new ArrayList<String>();
        L = new ArrayList<String>();
    }

    public void addCountry(String aCT) {
        allCountries.add(aCT);
    }

    public void addFlag(String aCT, ArrayList<String> A) {
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
        System.out.printf("\n");
        ArrayList<String> countryList = new ArrayList<String>();
        if (wantedFeatures.isEmpty()) {
            System.out.printf("{}\n");
            for (LinkedHashSet<String> s : workingMap.values()) {
                if (s != null) {
                    for (String country : s) {
                        if (!countryList.contains(country)) {
                            countryList.add(country);
                        }
                    }
                }
            }
        } else {
            for (String feature : wantedFeatures) {
                LinkedHashSet<String> s = workingMap.get(feature);
                if (s != null) {
                    System.out.printf("+%s  ", feature);
                    ArrayList<String> tempCountryList = new ArrayList<String>();
                    for (String country : s) {
                        if (countryList.contains(country)) {
                            tempCountryList.add(country);
                        } else {
                            countryList.add(country);
                        }
                    }
                    if (!tempCountryList.isEmpty()) {
                        countryList = tempCountryList;
                    }
                }
            }
        }
        Collections.sort(countryList);
        for (int i = 0; i < countryList.size(); i++) {
            if (i % 7 == 0) {
                System.out.printf("\n                  ");
            }
            System.out.printf("%-15s  ", countryList.get(i));
        }
        System.out.printf("\n");
    }

    public void excludeCountries(ArrayList<String> wantedFeatures, ArrayList<String> unwantedFeatures) {
        // Get set of countries using each unwanted feature as a key
        // Use set operations to exclude countries whose flags have unwanted features
        System.out.printf("\n");
        ArrayList<String> T = new ArrayList<String>();
        if (wantedFeatures == null) {
            System.out.printf("{}\n");
            printData();
        } else {
            for (String key : wantedFeatures) {
                T.clear();
                if (workingMap.containsKey(key)) {
                    System.out.printf("+%s  ", key);
                }
            }
        }
        System.out.printf("BUT  ");
        if (unwantedFeatures.isEmpty()) {
            System.out.printf("{}\n");
            int i = 0;
            Collections.sort(A);
            for (String CT : A) {
                if (i % 7 == 0) {
                    System.out.printf("\n                  ");
                }
                System.out.printf("%-15s  ", CT);
                i++;
            }
            System.out.printf("\n");
        } else {
            for (String key : unwantedFeatures) {
                if (workingMap.containsKey(key)) {
                    System.out.printf("-%s  ", key);
                    LinkedHashSet<String> s = workingMap.get(key);
                    for (String CT : s) {
                        int b = 0;
                        for (String C : A) {
                            if (C.equals(CT)) {
                                b = 1;
                            }
                        }
                        if (b == 1) {
                            A.remove(CT);
                        }
                    }
                }
                int i = 0;
                Collections.sort(A);
                for (String CT : A) {
                    if (i % 7 == 0) {
                        System.out.printf("\n                  ");
                    }
                    System.out.printf("%-15s  ", CT);
                    i++;
                }
                System.out.printf("\n");
            }
        }
    }

    public void printData() {
        System.out.printf("Total Countries = %d\n", allCountries.size());
        System.out.printf("Total Features = %d\n", workingMap.size());

        for (Map.Entry<String, LinkedHashSet<String>> entry : workingMap.entrySet()) {
            String feature = entry.getKey();
            LinkedHashSet<String> countries = entry.getValue();
            if (countries != null) {
                System.out.printf("%12s  >>  ", feature);
                int i = 0;
                ArrayList<String> sortedCountries = new ArrayList<>(countries);
                Collections.sort(sortedCountries);
                for (String country : sortedCountries) {
                    if (i % 7 == 0 && i != 0) {
                        System.out.printf("\n                  ");
                    }
                    System.out.printf("%-15s  ", country);
                    i++;
                }
            }
            System.out.println("\n\n");
        }
    }

    public void start() {
        printData();
        ArrayList<String> want = new ArrayList<>();
        ArrayList<String> unwant = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("===================================================================================");
            System.out.println("Enter features with prefix + or - (wanted or unwanted), separated by comma =");
            String[] buf = scan.nextLine().split(",");

            for (String s : buf) {
                ArrayList<String> list = s.trim().startsWith("+") ? want : unwant;
                list.add(s.trim().substring(1));
            }
            includeCountries(want);
            excludeCountries(want, unwant);
            A.clear();
            System.out.println("\nEnter Y/y to continue = ");
            if (!scan.nextLine().equalsIgnoreCase("Y")) {
                break;
            }
        }
    }
}

public class exercise8_short {
    // Write a main class to do the following:
    // 2.1 Read data from flags.txt into workingMap and allCountries.
    public static void main(String[] args) {
        FlagFeatureMap F = new FlagFeatureMap();
        ArrayList<String> A = new ArrayList<String>();

        String filename = "flags.txt";

        try {
            TreeSet<String> allFlag = new TreeSet<String>();
            LinkedHashSet<String> flag = new LinkedHashSet<String>();

            Scanner filescan = new Scanner(new File(filename));
            // String line = file.nextLine();
            while (filescan.hasNextLine()) {
                String buf[] = filescan.nextLine().split(",");
                String last = buf[buf.length - 1];
                F.addCountry(buf[0].trim());
                // System.out.println(last); //show colour,flag
                // System.out.println(buf[0].trim()); //show Countries
                // System.out.println(filescan.nextLine()); //printall
                for (int i = 1; i < buf.length; i++) {
                    A.add(buf[i].trim());
                    // System.out.println(buf[i].trim()); //flag,country
                    // allFlag.add(buf[i]);
                    // flag.add(buf[i]);
                }
                F.addFlag(buf[0].trim(), A);
                A.clear();
            }
            filescan.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        F.start();
    }
}
/*
    public void includeCountries(ArrayList<String> wantedFeatures) {
        System.out.printf("\n");
        ArrayList<String> T = new ArrayList<String>();
        if (wantedFeatures.isEmpty()) {
            System.out.printf("{}\n");
            int i = 0;
            for (String key : workingMap.keySet()) {
                LinkedHashSet<String> s = workingMap.get(key);
                if (s != null) {
                    for (String CT : s) {
                        if (!A.contains(CT)) {
                            A.add(CT);
                        }
                    }
                }
            }
            Collections.sort(A);
            for (String CT : A) {
                if (i % 7 == 0) {
                    System.out.printf("\n                  ");
                }
                System.out.printf("%-15s  ", CT);
                i++;
            }
            System.out.printf("\n");
        } else {
            int a = 0;
            for (String key : wantedFeatures) {
                T.clear();
                if (workingMap.containsKey(key)) {
                    System.out.printf("+%s  ", key);
                    LinkedHashSet<String> s = workingMap.get(key);

                    for (String CT : s) {
                        if (a != 0) {
                            for (String C : A) {
                                if (C.equals(CT)) {
                                    T.add(C);
                                }
                            }
                        } else {
                            A.add(CT);
                        }
                    }
                    if (a == 0) {
                        a = 1;
                    } else {
                        A = T;
                    }
                }
            }
            int i = 0;
            Collections.sort(A);
            for (String CT : A) {
                if (i % 7 == 0) {
                    System.out.printf("\n                  ");
                }
                System.out.printf("%-15s  ", CT);
                i++;
            }
            System.out.printf("\n");
        }
    }
*/
