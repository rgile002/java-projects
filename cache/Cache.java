
// By Rolf Kinder Gilet 

package cache;

public class Cache {

    private CacheEntry[] myCache; // The cache
    private int cachesize; // The number of blocks in the cache
    private int numhits;   // The number of hits so far
    private int nummisses; // The number of misses so far

    public Cache(int numblocks) {
        myCache = new CacheEntry[numblocks];

        for (int i = 0; i < numblocks; i++) {
            myCache[i] = new CacheEntry(numblocks);
        }

        cachesize = numblocks;
        numhits = 0;
        nummisses = 0;

    }

    public static int log2(int value) {
        return (int) (Math.log((double) value) / Math.log((double) 2));
    }

    public static int binToDec(String binIndex) {
        double j = 0;
        for (int i = 0; i < binIndex.length(); i++) {
            if (binIndex.charAt(i) == '1') {
                j = j + Math.pow(2, binIndex.length() - 1 - i);
            }

        }
        int index = (int) j;
        return index;
    }
   // Complete this function
    // This should take a memory address (you can assume positive or zero)
    // and convert it to a 32-bit binary string

    private String decToBin32(int address) {
        // Return a 32-bit binary String, representing the integer x
        int valueAsNum = address;

        int quotient, remainder;
        String result = "";

      // 1. Complete this loop.  Repeatedly take the quotient and remainder
        //    when dividing by two, and append a "0" or "1" to the result.
        int bits = 32;
        quotient = valueAsNum;
        do {
            remainder = quotient % 2;
            result = remainder + result;
            quotient = quotient / 2;
            bits--;
        } while (quotient != 0);

        String zeroes = "";
      // 2. Make a string of the appropriate amount of zeroes, so the result
        // has 32 bits.
        for (int i = 0; i < bits; i++) {
            zeroes = 0 + zeroes;
        }

        return zeroes + result;
    }

   // Complete this function.  
    // In summary, the task is to check the cache at the appropriate index
    // assuming we are reading from the passed DRAM memory address.
    // If the address hits in the cache, return true and add one to the hit counter (numhits)
    //    (remember for a hit, the valid bit must be on AND the tag must match
    // If the address misses, return false andd add one to the miss counter (nummisses)
    // but also add that address to the cache
    //    (you'll need to turn the valid bit on AND put its tag in the correct spot
    // You will also call your decToBin32() to convert the address to a 32-bit binary value
    // before you pull out the tag bits.
    private boolean cache(int address) {

     
        int numbits = 32 - Cache.log2(cachesize);
        String binAddress = decToBin32(address);
        String binIndex = binAddress.substring(numbits, 32);
        String tag = binAddress.substring(0, numbits);
        //  int ta = myCache.log2(address);
        int index = binToDec(binIndex);
        //System.out.println(binToDec(binIndex));
        System.out.println(tag);
        // if(tag.compareTo(myCache.)=1){
        if (myCache[index].valid == true && myCache[index].tag.equals(tag)) {
            numhits += 1;
        } else {
            if (myCache[index].valid == false || myCache[index].tag != tag) {
                nummisses += 1;
                myCache[index].tag = tag;
                myCache[index].valid = true;

                return false;

            }
        }
     // } 

        return true;
    }

    // Print the contents of the cache
    private void display() {
        System.out.println("************************************************************");
        System.out.println("V INDEX\tTAG");
        for (int i = 0; i < cachesize; i++) {
            if (myCache[i].valid) {
                System.out.print("1");
            } else {
                System.out.print("0");
            }
            System.out.println(" " + i + "\t" + myCache[i].tag);
        }
        System.out.println("************************************************************");
        System.out.println("Current hit rate: " + hitRate() + "%");
    }

    private double hitRate() {
        return ((double) numhits / (numhits + nummisses)) * 100;
    }

    // Called from main()
    public void checkCache(int address) {
        if (cache(address)) {
            System.out.println("HIT, Data used.");
        } else {
            System.out.println("MISS, Must go to DRAM.");
        }
        display();
    }

}
