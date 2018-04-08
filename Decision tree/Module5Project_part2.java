
package module5project_part2;

/**
 * @author Rolf Kinder Gilet
 * @Panther_ID 5734407
 * @date Saturday, April 7th, 2018
 * @Team_Member Rafael Fernandez Jr
 * @Panther_ID 1684819
 */
import java.io.*;
import java.util.*;

public class Module5Project_part2 {
    // fields
    int numAttributes;
    String[] attributeNames;
    Vector[] domains;

    // represent a data point consisting of numAttributes values
    class DataPoint {
        public int[] attributes;
        public DataPoint(int numattributes) {
            attributes = new int[numattributes];
        }
    };

    // data structure to represent the nodes of the tree
    class TreeNode {

        public double entropy;
        public Vector data;
        public int decompositionAttribute;
        public int decompositionValue;
        public TreeNode[] children;
        public TreeNode parent;
        public TreeNode() {
            data = new Vector();
        }
    };

    TreeNode root = new TreeNode();
    
    // helper method
    public int getSymbolValue(int attribute, String symbol) {
        int index = domains[attribute].indexOf(symbol);
        if (index < 0) {
            domains[attribute].addElement(symbol);
            return domains[attribute].size() - 1;
        }
        return index;

    }
    // get the values, put them in an array and return the array  
    public int[] getAllValues(Vector data, int attribute) {
        Vector values = new Vector();
        int num = data.size();

        for (int i = 0; i < num; i++) {
            DataPoint point = (DataPoint) data.elementAt(i);
            String symbol = (String) domains[attribute].elementAt(point.attributes[attribute]);
            int index = values.indexOf(symbol);
            if (index < 0) {
                values.addElement(symbol);
            }
        }
        int[] array = new int[values.size()];
        for (int i = 0; i < array.length; i++) {
            String symbol = (String) values.elementAt(i);
            array[i] = domains[attribute].indexOf(symbol);
        }
        values = null;
        return array;
    }
    // get the partition subset 
    public Vector getSubset(Vector data, int attribute, int value) {

        Vector subset = new Vector();
        int num = data.size();

        for (int i = 0; i < num; i++) {
            DataPoint point = (DataPoint) data.elementAt(i);
            if (point.attributes[attribute] == value) {
                subset.addElement(point);
            }
        }
        return subset;

    }
    // calculate information gain using equation 8.2 
    public double calculateEntropy(Vector data) {

        int numdata = data.size();
        if (numdata == 0) {
            return 0;
        }
        int attribute = numAttributes - 1;
        int numvalues = domains[attribute].size();
        double sum = 0;

        for (int i = 0; i < numvalues; i++) {
            int count = 0;
            for (int j = 0; j < numdata; j++) {
                DataPoint point = (DataPoint) data.elementAt(j);
                if (point.attributes[attribute] == i) {
                    count++;
                }
            }
            // equation 8.2 to calculate information gain
            double probability = 1. * count / numdata;
            if (count > 0) {
                sum += -probability * Math.log(probability);
            }
        }
        return sum;

    }
    // helper method for decompose node 
    public boolean alreadyUsedToDecompose(TreeNode node, int attribute) {

        if (node.children != null) {
            if (node.decompositionAttribute == attribute) {
                return true;
            }
        }
        if (node.parent == null) {
            return false;
        }
        return alreadyUsedToDecompose(node.parent, attribute);

    }
    // split the nodes or patition the data base on gain 
    public void decomposeNode(TreeNode node) {

        double bestEntropy = 0;
        boolean selected = false;
        int selectedAttribute = 0;
        int numdata = node.data.size();
        int numinputattributes = numAttributes - 1;
        node.entropy = calculateEntropy(node.data);
        if (node.entropy == 0) {
            return;
        }

        for (int i = 0; i < numinputattributes; i++) {
            int numvalues = domains.length;
            if (alreadyUsedToDecompose(node, i)) {
                continue;
            }
            double averageentropy = 0;
            for (int j = 0; j < numvalues; j++) {
                Vector subset = getSubset(node.data, i, j);
                if (subset.size() == 0) {
                    continue;
                }
                double subentropy = calculateEntropy(subset);
                averageentropy += subentropy
                        * subset.size();
            }
            averageentropy = averageentropy / numdata; 
            if (selected == false) {
                selected = true;
                bestEntropy = averageentropy;
                selectedAttribute = i;
            } else {
                if (averageentropy < bestEntropy) {
                    selected = true;
                    bestEntropy = averageentropy;
                    selectedAttribute = i;
                }
            }
        }

        if (selected == false) {
            return;
        }

        int numvalues = domains[selectedAttribute].size();
        node.decompositionAttribute = selectedAttribute;
        node.children = new TreeNode[numvalues];

        for (int j = 0; j < numvalues; j++) {
            node.children[j] = new TreeNode();
            node.children[j].parent = node;
            node.children[j].data = getSubset(node.data,
                    selectedAttribute, j);
            node.children[j].decompositionValue = j;

        }

        for (int j = 0; j < numvalues; j++) {
            decomposeNode(node.children[j]);
        }
        node.data = null;

    }
    
    // read the data from our input file and add the conctent to our data point 
    public int readData(String filename) throws Exception {
        FileInputStream in = null;
        // try to open the file
        try {
            File inputFile = new File(filename);
            in = new FileInputStream(inputFile);
        } catch (Exception e) {
            System.err.println("Unable to open data file: " + filename + "\n" + e);
            return 0;
        }
        // create buffer reader to iterate throught the file 
        BufferedReader bin = new BufferedReader(new InputStreamReader(in));
        String input;
        
        // read the file and capture the string names
        while (true) {
            input = bin.readLine();
            if (input == null) {
                System.err.println("No data found in the data file: " + filename + "\n");
                return 0;
            }
            // skip comment lines 
            if (input.startsWith("//")) {
                continue;
            }
            if (input.equals("")) {
                continue;
            }
            break;
        }
        // tokenized the line to get individual string values
        StringTokenizer tokenizer = new StringTokenizer(input);
        numAttributes = tokenizer.countTokens();
        if (numAttributes <= 1) {
            System.err.println("Read line: " + input);
            System.err.println("Could not obtain the names of attributes in the line");
            System.err.println("Expecting at least one input attribute and one output attribute");
            return 0;
        }
        // create array of vector to hold the data
        domains = new Vector[numAttributes];
        for (int i = 0; i < numAttributes; i++) {
            domains[i] = new Vector();
        }
        // add the string data to our array
        attributeNames = new String[numAttributes];
        for (int i = 0; i < numAttributes; i++) {
            attributeNames[i] = tokenizer.nextToken();
        }
        // reade file again and skip comment lines 
        // create data point
        while (true) {
            input = bin.readLine();
            if (input == null) {
                break;
            }
            if (input.startsWith("//")) {
                continue;
            }
            if (input.equals("")) {
                continue;
            }
            tokenizer = new StringTokenizer(input);
            int numtokens = tokenizer.countTokens();
            if (numtokens != numAttributes) {
                System.err.println("Read " + root.data.size() + " data");
                System.err.println("Last line read: " + input);
                System.err.println("Expecting " + numAttributes + " attributes");
                return 0;
            }
            // create data point
            DataPoint point = new DataPoint(numAttributes);
            for (int i = 0; i < numAttributes; i++) {
                point.attributes[i] = getSymbolValue(i, tokenizer.nextToken());
            }
            root.data.addElement(point);
        }
        // close file
        bin.close();
        // return 1 so show sucess 
        return 1;
    }
    // print the content of the decision tree 
    public void printTree(TreeNode node, String tab) {
        // base case of the recursion
        // check if we at the leaf, print and backtrack or rollback
        int outputattr = numAttributes - 1;
        if (node.children == null) {
            int[] values = getAllValues(node.data, outputattr);
            if (values.length == 1) {
                System.out.println(tab + "\t" + attributeNames[outputattr] + " = \"" + domains[outputattr].elementAt(values[0]) + "\";");
                return;
            }
            System.out.print(tab + "\t" + attributeNames[outputattr] + " = {");
            for (int i = 0; i < values.length; i++) {
                System.out.print("\"" + domains[outputattr].elementAt(values[i]) + "\" ");
                if (i != values.length - 1) {
                    System.out.print(" , ");
                }
            }
            System.out.println(" };");
            return;
        }
        // general casse of the recursion 
        // get the number of branches for one element on a level for the printing loop
        int numvalues = node.children.length;
        // printing loop
        for (int i = 0; i < numvalues; i++) {
            // printing format 
            System.out.println(tab + "if( "
                    + attributeNames[node.decompositionAttribute] + " == \""
                    + domains[node.decompositionAttribute].elementAt(i)
                    + "\") {");
            // recursive call
            printTree(node.children[i], tab + "\t");
            // we printed a leaf ot class label 
            // we close the printing format 
            if (i != numvalues - 1) {
                System.out.print(tab + "} else ");
            } else {
                System.out.println(tab + "}");
            }
        }
    }
    // search for a given tuple in the decision tree and print the class label for the tuple if found
    // else print tuple not found 
    public void search(TreeNode node, String s1, String s2) {
        //base case of the recursion
        int outputattr = numAttributes - 1;
        // check if we at the leaf which mean we have the value of the class label 
        if (node.children == null) {
            int[] values = getAllValues(node.data, outputattr);
            if (values.length == 1) {
                // print the class label value 
                System.out.println("The class label for the tuple \"" + s1 + "\" \"" + s2 + "\" is " + "\"" + domains[outputattr].elementAt(values[0]) + "\".");
                return;
            }
        }
        // we get the number of branches for the loop
        int numvalues = node.children.length;
        boolean find = false;
        // recursive search, if at least one element of the tuple is found,
        // we go deaper in the tree, else we print not found.
        for (int i = 0; i < numvalues; i++) {
            // we can use the name string too if we want a larger tuple (4 elements for example )
            //String name = attributeNames[node.decompositionAttribute];
            if (s1.equals(domains[node.decompositionAttribute].elementAt(i))) {
                find = true;
                // recursive call
                search(node.children[i], s1, s2);
            }
            if (s2.equals(domains[node.decompositionAttribute].elementAt(i))) {
                find = true;
                // recursive call
                search(node.children[i], s1, s2);
            }
        }
        // message if we didn't find the tuple 
        if (find == false) {
            System.out.println("Tuple \"" + s1 + "\" \"" + s2 + "\" not found");
        }
    }

    // helper method for main, initiate the print and search tree 
    public void createDecisionTree(String s1, String s2) {
        decomposeNode(root);
        search(root, s1, s2);
        System.out.println("");
        System.out.println("<================ Dessision Tree ================>");
        System.out.println("");
        printTree(root, "");
        
    }

    /* main function */
    public static void main(String[] args) throws Exception {
        // create instance of our class 
        Module5Project_part2 test = new Module5Project_part2();
        // set up input file 
        int status = test.readData("input.txt");
        // check if we sucessfuly read the data
        if (status <= 0) {
            return;
        }
        // set up scanner to get tuple from user 
        Scanner in = new Scanner(System.in);

        // ask an get first tuple element from user
        System.out.println("Enter The first element of the tuple");
        String one = in.next();
        // ask and get second element from user
        System.out.println("Enter The second element of the tuple");
        String two = in.next();
        System.out.println("");
        // generate the tree and do a serch for the given tuple
        test.createDecisionTree(one, two);

    }

}
