/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package set.intersection.java;

import java.util.Arrays;
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
//        time.start();
//        byte a[] = createArray(1000000000, "sorted");
//        byte b[] = createArray(1000000000, "sorted");
//        time.end();

//        time.start();
//        Intersection c = getIntersection(a,b);
//        time.end();

//        a=null;
//        b=null;
        HashSet h = new HashSet();
        HashSet g = new HashSet();
        time.start();
        fillHashSet(h,1000000000);
        fillHashSet(g,1000000000);
        time.end();
        
        time.start();
        getIntersection(h,g);
        time.end();
        
    }
    
    public static void fillHashSet(HashSet h,int size){
        Random rand = new Random();
        for(int i=0; i<size; i++){
            h.add((byte)rand.nextInt(256));
        }
    }
    
    public static byte[] createArray(int size, String s){
        byte a[] = new byte[size];
        Random rand = new Random();
        for(int i=0; i<size; i++){
            a[i] = (byte)(rand.nextInt(256));
        }
        if(s != null && s.equals("sorted")) Arrays.sort(a);
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
    public static class Intersection{
        byte[] a;
        int capacity;
        
        Intersection(int size){
            a = new byte[size];
            capacity=0;
        }
        
        public void addTo(int n){
            a[capacity]=(byte)n;
            capacity++;
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
        
        public void end(){
            s = System.nanoTime() - s;
            System.out.println("Elapsed Time: " + s +"ns");
        }
    }
}

