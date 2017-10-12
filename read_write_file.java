/*
 * read names (fn ln ) from an input file (.txt) 
 * output all the names
 * output the name and the count of first name,
 * last name, all unic name 
 * write the output with proper format in a out file 
 */
package assignment.pkg3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Rolf Kinder Gilet
 * @author Eysler Paz
 */
public class Assignment3 {

    public static void getName(ArrayList<String> fn, ArrayList<String> ln) throws IOException {

        Scanner kb = new Scanner(System.in);

        String inpFileName = kb.next();
        File inpFile = new File(inpFileName);

        Scanner in = new Scanner(inpFile);

        while (in.hasNext()) {

            fn.add(in.next());

            ln.add(in.next());

        }

    }

    public static void capitalize(ArrayList<String> names) {
        for (int i = 0; i < names.size(); i = i + 1) {
            String a = names.get(i);
            String f = (a.substring(0, 1).toUpperCase() + a.substring(1).toLowerCase());

            names.set(i, f);
        }
    }

    public static void sort(ArrayList<String> names) {

        int k = names.size();
        String temp = new String();
        String name[] = new String[k + 1];
        for (int i = 0; i < k; i++) {
            name[i] = names.get(i);
        }
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < k; j++) {
                if (name[i].compareTo(name[j]) > 0) {
                    temp = name[j];
                    name[j] = name[i];
                    name[i] = temp;
                }
            }
        }

        for (int i = 0; i < k; i++) {

            names.set(i, name[i]);
        }
    }

    public static void display(ArrayList<String> names) {

        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));

        }
        System.out.println();

    }

    public static String properSpace(ArrayList<String> ln, int i) {
        int dd = 20 - (ln.get(i).length());
        

        String Space = new String();
        for (int ff = 1; ff < dd; ff += 1) {
            Space += " ";
        }
        return Space;
    }

    public static void writeToFile(ArrayList<String> names) throws IOException {
        String fileName = "output.txt";
        PrintWriter outFile = new PrintWriter(fileName);
        for (int i = 0; i < names.size(); i++) {
            outFile.println(names.get(i));

        }

        outFile.close();
    }

    public static void Count(ArrayList<String> name, int type) {
        ArrayList<String> nameCount = new ArrayList<String>();
        int count = 1;
        for (int q = 0; q < name.size(); q++) {

            for (int p = 0; p < name.size(); p++) {
                if (name.get(q).equals(name.get(p))) {
                    count += 1;
                }
            }
            count -= 1;
            String properSpace = properSpace(name, q);
            switch (type) {
                case 0:
                    if ( find (nameCount, name.get(q) + properSpace + Integer.toString(count))==-1 ) {
                        nameCount.add(name.get(q) + properSpace + Integer.toString(count));
                    }
                    count = 1;
                    break;
                case 1:
                    if (find(nameCount, name.get(q)) == -1) {

                        nameCount.add(name.get(q));

                    }
                    count = 1;
                    break;
                case 2:
                    if (find(nameCount, name.get(q) + "\t" + Integer.toString(count)) ==-1) {
                        nameCount.add(name.get(q) + "\t" + Integer.toString(count));
                    }
                    count = 1;

            }

        }

        sort(nameCount);
       
       name.clear();
        
        for (int i = 0; i < nameCount.size(); i++) {
            

            name.add(nameCount.get(i));

        }
    }
    public static int find(ArrayList<String> name, String s){
    for(int qw=0; qw<name.size(); qw++){
    if (name.get(qw).equals(s))
        return qw;
    }
    return -1;
    
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here

        System.out.println("please enter the name of the Input file with extention");

        ArrayList<String> fn = new ArrayList<String>();
        ArrayList<String> ln = new ArrayList<String>();
        ArrayList<String> name = new ArrayList<String>();
        ArrayList<String> allNamesCount = new ArrayList<String>();
        ArrayList<String> allUniqueNames = new ArrayList<String>();
        ArrayList<String> finale = new ArrayList<String>();
        getName(fn, ln);
        capitalize(fn);
        capitalize(ln);

        for (int i = 0; i < fn.size(); i++) {
            String properSpace = properSpace(ln, i);

            name.add(ln.get(i) + "," + properSpace + fn.get(i));

        }
        System.out.println("******* All Names *********");
        sort(name);
        display(name);
        for (int i = 0; i < name.size(); i++) {

            allNamesCount.add(name.get(i));

        }
        for (int i = 0; i < name.size(); i++) {

            allUniqueNames.add(name.get(i));

        }

        System.out.println("***** First Names Count ****");
        sort(fn);
        Count(fn, 0);
        display(fn);

        System.out.println("***** Last Names Count ****");
        sort(ln);
        Count(ln, 0);
        display(ln);

        System.out.println("***** All names Count ****");
        sort(allNamesCount);
        Count(allNamesCount, 2);
        display(allNamesCount);

        System.out.println("***** All unique names ****");
        sort(allUniqueNames);
        Count(allUniqueNames, 1);
        display(allUniqueNames);

        finale.add("******* All Names *********");
        for (int i = 0; i < name.size(); i++) {
            finale.add(name.get(i));
        }
        finale.add("");
        finale.add("******* First Names Count *********");
        for (int i = 0; i < fn.size(); i++) {
            finale.add(fn.get(i));
        }
        finale.add("");
        finale.add("******* Last Names Count *********");
        for (int i = 0; i < ln.size(); i++) {
            finale.add(ln.get(i));
        }
        finale.add("");
        finale.add("******* All names Count *********");
        for (int i = 0; i < allNamesCount.size(); i++) {
            finale.add(allNamesCount.get(i));
        }
        finale.add("");
        finale.add("******* All unique names *********");
        for (int i = 0; i < allUniqueNames.size(); i++) {
            finale.add(allUniqueNames.get(i));
        }
        writeToFile(finale);
    }    
}

/* input 
colette Sapienza
gretta Beumer
EMManuel Mossman
Colette Sapienza
marcia Jones
Shawanda Hutt
Adriana monTILla
adriana montilla
Adriana Montilla
Colette Jones
Colette Hutt
Marcia Stanfill
NeVa shover
tijuana Means
Adriana Montilla
gerri KoeNig
Kirsten beres
Kirsten Beres
*/ 

/* output 
******* All Names *********
Beres,              Kirsten
Beres,              Kirsten
Beumer,             Gretta
Hutt,               Colette
Hutt,               Shawanda
Jones,              Colette
Jones,              Marcia
Koenig,             Gerri
Means,              Tijuana
Montilla,           Adriana
Montilla,           Adriana
Montilla,           Adriana
Montilla,           Adriana
Mossman,            Emmanuel
Sapienza,           Colette
Sapienza,           Colette
Shover,             Neva
Stanfill,           Marcia

******* First Names Count *********
Adriana            4
Colette            4
Emmanuel           1
Gerri              1
Gretta             1
Kirsten            2
Marcia             2
Neva               1
Shawanda           1
Tijuana            1

******* Last Names Count *********
Beres              2
Beumer             1
Hutt               2
Jones              2
Koenig             1
Means              1
Montilla           4
Mossman            1
Sapienza           2
Shover             1
Stanfill           1

******* All names Count *********
Beres,              Kirsten	2
Beumer,             Gretta	1
Hutt,               Colette	1
Hutt,               Shawanda	1
Jones,              Colette	1
Jones,              Marcia	1
Koenig,             Gerri	1
Means,              Tijuana	1
Montilla,           Adriana	4
Mossman,            Emmanuel	1
Sapienza,           Colette	2
Shover,             Neva	1
Stanfill,           Marcia	1

******* All unique names *********
Beres,              Kirsten
Beumer,             Gretta
Hutt,               Colette
Hutt,               Shawanda
Jones,              Colette
Jones,              Marcia
Koenig,             Gerri
Means,              Tijuana
Montilla,           Adriana
Mossman,            Emmanuel
Sapienza,           Colette
Shover,             Neva
Stanfill,           Marcia
*/
