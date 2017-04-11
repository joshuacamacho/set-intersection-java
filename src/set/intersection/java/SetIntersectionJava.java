/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package set.intersection.java;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author Josh
 */

public class SetIntersectionJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {    
        Timer time = new Timer();
        int size= 1000000000;
        //Create arrays
        byte a[] = createArray(size);
        byte b[] = createArray(size);
        
        System.out.println("For size of "+ size);
        
        BitSet q = fillBitSet(a);
        BitSet p = fillBitSet(a);
        BitSet w = new BitSet(a.length);
        time.start();
        
        w.or(q);
        w.and(p);
        System.out.print("\nBitSet Intersection ");
        time.end();
        
        //Hash Set Test Area
        HashSet h = new HashSet();
        HashSet g = new HashSet();
        time.start();
        fillHashSet(h,a);
        fillHashSet(g,b);
        System.out.print("\nHashSet fill ");
        time.end();
        
        //HashSet Intersection
        time.start();
        getIntersection(h,g);
        System.out.print("\nHashSet Intersection ");
        time.end();
        
        //Sort the Arrays
        time.start();
        Arrays.sort(a);
        Arrays.sort(b);
        System.out.print("\nSorting ");
        long s = time.end();

        //Get Intersection from two sorted arrays
        time.start();
        Intersection c = getIntersection(a,b);
        System.out.print("\nSorted Array Intersection normal algorithm ");
        long r = time.end();
        System.out.print("\n");
        
        
    }
    
    public static BitSet fillBitSet(byte[] a){
        BitSet b = new BitSet(a.length);
        for(int i=0; i<a.length; i++){
            b.set(a[i]);
        }
        return b;
    }
    
    public static BitSet fillBitSet(int[] a){
        BitSet b = new BitSet(a.length);
        for(int i=0; i<a.length; i++){
            b.set(a[i]);
        }
        return b;
    }
    
    public static void fillHashSet(HashSet h, byte[] a){
        Random rand = new Random();
        for(int i=0; i<a.length; i++){
            h.add(a[i]);
        }
    }
    
    public static void fillHashSet(HashSet h, int[] a){
        Random rand = new Random();
        for(int i=0; i<a.length; i++){
            h.add(a[i]);
        }
    }
    
    public static byte[] createArray(int size){
        byte a[] = new byte[size];
        Random rand = new Random();
        for(int i=0; i<size; i++){
            a[i] = (byte)(rand.nextInt(127));
        }
        
        return a;
    }
    
    public static int[] createIntArray(int size){
        int a[] = new int[size];
        Random rand = new Random();
        for(int i=0; i<size; i++){
            a[i] = rand.nextInt(Integer.MAX_VALUE);
        }
        
        return a;
    }
    
    public static void printArray(int[] a){
        for(int i=0; i<a.length; i++){
           System.out.print(a[i] +" ");
        }
        System.out.print("\n");
    }
    
    public static HashSet getIntersection(HashSet a, HashSet b){
        HashSet c = new HashSet();
        // create an iterator
        Iterator iterator = c.iterator(); 
      
        // check values
        while (iterator.hasNext()){
            System.out.println(c.add(iterator.next()));  
        }
        return c;
    }
    
    public static Intersection getIntersection(byte[] a, byte[] b){
        Intersection c = new Intersection(a.length);
        int i=0;
        int j=0;
        while(i < a.length && j < b.length){
            if(a[i]<b[j]) i++;
            if(a[i]>b[j]) j++;
            if(a[i]==b[j]){
                c.addTo(a[i]);
                i++;
                j++;
            }
        }
        
        
        return c;
    }
    
    public static Intersection getIntersection(int[] a, int[] b){
        Intersection c = new Intersection(a.length,"int");
        int i=0;
        int j=0;
        while(i < a.length && j < b.length){
            if(( i<a.length && j<b.length) && a[i]<b[j]) i++;
            
            if(( i<a.length && j<b.length) && a[i]>b[j]) j++;
            if(( i<a.length && j<b.length) && a[i]==b[j]){
                c.addTo(a[i],"int");
                i++;
                j++;
            }
        }
        
        
        return c;
    }
    
    public static class Intersection{
        byte[] a;
        int capacity;
        int[] b;
        Intersection(int size){
            a = new byte[size];
            capacity=0;
        }
        
        Intersection(int size, String form){
            if(form.equals("int")){
                b = new int[size];
                capacity=0;
            }
        }
        
        public void addTo(int n){
            a[capacity]=(byte)n;
            capacity++;
        }
        public void addTo(int n, String form){
            if(form.equals("int")){
                b[capacity]=n;
                capacity++;
            }
        }
        public void print(){
            for(int i=0; i<capacity; i++){
                System.out.print(a[i]+" ");
            }
            System.out.println("");
        }
    }
    
    public static class Timer{
        long s;
        
        Timer(){
            s=0;
        }
        public void start(){
            s = System.nanoTime();
        }
        
        public long end(){
            s = System.nanoTime() - s;
            System.out.print("Elapsed Time: " + s +"ns");
            return s;
        }
    }
}

