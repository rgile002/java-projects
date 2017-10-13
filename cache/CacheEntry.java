/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cache;

public class CacheEntry {

    public CacheEntry(int size) {
        valid = false;
        tag = makeBlankTag(size);
    }
    public boolean valid;
    public String tag;

    private String makeBlankTag(int size) {
        String theTag = "";
        int numbits = 32 - Cache.log2(size);
        for (int i = 0; i < numbits; i++) {
            theTag += "0";
        }
        return theTag;
    }
}
