package org.practice;

import jdk.jfr.DataAmount;
import org.practice.graphs.GraphUtils;
import org.practice.hashMaps.Map;
import org.practice.miscellaneous.GenericUtils;
import org.practice.miscellaneous.IgnoreMe;
import org.practice.miscellaneous.annotations.RunThis;
import org.practice.miscellaneous.challenges.ElevenPattern;
import org.practice.miscellaneous.inheritance.Child;
import org.practice.miscellaneous.inheritance.Parent;
import org.practice.miscellaneous.interfaceExamples.InterfaceImpl;
import org.practice.miscellaneous.mischief.ItWontBeThatEasy;
import org.practice.multithreading.PetersonsAlgorithm;
import org.practice.sorting.HeapSort;
import org.practice.tries.Trie;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static org.practice.miscellaneous.GenericUtils.*;
import static org.practice.miscellaneous.IgnoreMe.*;

public class UseME {


    private UseME() {
    }

    public static ItWontBeThatEasy illHelpYouGetAnObject() {

        return new ItWontBeThatEasy(new UseME());

    }

    public void overridingStaticMethod() {
        Parent p = new Child();
        Child c = new Child();
        p.overridingStatic();
        c.overridingStatic();
    }

    public void genericArrayTest() {
        // go inside this method
        genericArray(4);

    }

    public void overloadingStaticMethod() {
        overloading(null);
    }

    public void tryDifferentShitWithInterface() {
        InterfaceImpl i = new InterfaceImpl();
        i.interfaceMethod();
        InterfaceImpl.interfaceMethodStatic();
    }

    public void varArgsMethodOverload() {
        stringInput("abc");
        stringInput("abc", "tef");
    }

    public static class MapTester {
        @Override
        public int hashCode() {
            return 1;
        }
    }

    //    @RunThis
    public void testMyMap() {
        Map<MapTester, Integer> myFirstMap = new Map<>();
        MapTester m1 = new MapTester();
        MapTester m2 = new MapTester();
        MapTester m3 = new MapTester();
        myFirstMap.insert(m3, 300);
        System.out.println(myFirstMap.bucket);
        myFirstMap.insert(m1, 1);
        System.out.println(myFirstMap.bucket);
        myFirstMap.insert(m2, 2);
        System.out.println(myFirstMap.bucket);
        System.out.println(myFirstMap.get(m2));
        myFirstMap.insert(m1, 3);
        System.out.println(myFirstMap.get(m1));
        System.out.println(myFirstMap.get(m3));
        System.out.println(myFirstMap.bucket);
        System.out.println(myFirstMap.delete(m1));
        System.out.println(myFirstMap.delete(m3));
        System.out.println(myFirstMap.delete(m2));
        System.out.println(myFirstMap.bucket);
    }

    public void priorityQueueTester() {
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        pq.add(10, 10);
//        pq.add(20, 20);
//        pq.add(40, 40);
//        pq.add(80, 80);
//        pq.add(25, 25);
//        pq.add(45, 45);
//        pq.add(50, 50);
//        pq.print();
//        pq.add(5, 5);
//        pq.print();
//        pq.removeMin();
//        pq.print();
//        System.out.println(pq.getMin());
    }

    //    @RunThis()
    public void TrieTest() {
        Trie trie = new Trie();
        trie.add("hell9");
        trie.add("hell");
        trie.add("hell9inh");
        trie.add("pus");
        trie.print();
        System.out.println(trie.remove("hell9inh"));
        System.out.println(trie.search("hell9inh"));

        System.out.println("-------");
        trie.print();
//        trie.add("hell10");
//        System.out.println(trie.search("hell9"));
    }


    //    @RunThis(value = 200, runOnLoop = 2)
    public void heapSortTc() {
        int[] arr = GenericUtils.randomArray(10, 50);
        System.out.println(Arrays.toString(arr));
        System.out.println(GenericUtils.isArraySorted(arr));
        HeapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(GenericUtils.isArraySorted(arr));
    }

    @RunThis(2)
    public void subsequenceTester() {
        String[] result = subsequence("abc");


//        String[] sample = new String[]{"a", "ap", "al", "ae", "app", "apl", "ape", "ale", "appl", "appe", "aple", "apple", "p", "pp", "pl", "pe", "ppl", "ppe", "ple", "pple", "l", "le", "e", ""};
//        Arrays.sort(sample);
//        Arrays.sort(result);
        System.out.println(Arrays.toString(result));
        printSubsequence("abc", "");
//        System.out.println(Arrays.toString(sample));
//
//        System.out.println(Arrays.equals(result,sample));
//        System.out.println(result.length);
    }

    @RunThis(3)
    public void ascii_binary() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String s = StringToASCIIToBinary(scanner.nextLine());
        System.out.println(s);
        System.out.print("Enter binary: ");
        System.out.println(ASCIIBinaryToString(scanner.next()));
    }

    @RunThis(4)
    public void justRun() {
        for (int i = 1, j = 2; i >= 0 && j >= 0; i--, j--) {
            System.out.print("I: " + i + " j : " + j + " b: ");
        }
    }

    @RunThis(5)
    public void graphShit() {
//       int[][] am = GraphUtils.takeInput();
//       for(int[] i : am){
//           System.out.println(Arrays.toString(i));
//       }
        int[][] am =  {{0, 0, 1, 1, 1, 0, 0},
                        {0, 0, 1, 0, 0, 1, 0},
                        {1, 1, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 0, 0, 1},
                        {1, 0, 0, 0, 0, 1, 0},
                        {0, 1, 0, 0, 1, 0, 0},
                        {0, 0, 0, 1, 0, 0, 0}};

        System.out.println("-----------------");
        List<Integer> list = GraphUtils.depthFirstSearch(am);
        System.out.println(list);

        for(int[] i : am){
            System.out.println(Arrays.toString(i));
        }
    }

    @RunThis(6)
    public void whateever(){
//            List<Integer> lsit = new ArrayList<>();
//            for( int i = 0 ; i < 100000 ; i++){
//                lsit.add(8);
//            }
//        System.out.println(lsit);

        List<String> list = new ArrayList<>();
        Collections.sort(list,(l1,l2) -> l1.compareTo(l2));
    }

    @RunThis(7)
    public void testCase1(){
        ElevenPattern pattern  = new ElevenPattern();
        pattern.print(20);
    }

    @RunThis(8)
    public void superEasyWayToIterate(){
        int a = 9, b = 4, c = 7, d = 1, e = 3;
         while((a = 1) == 1 && (b = 2) == 3 && (c = 3)== 3 || (d = 4) == 4 || (e = 5) == 7){
            System.out.println(a +" "+b +" "+c + " " +d + " "+e);
            break;
        }
        int[] arr = randomArray(20,100);
        System.out.println(IgnoreMe.getList(arr));
    }

    @RunThis(9)
    public void something23423(int[] nums2){
        listAsArray(new int[][]{{32,32},{2,3}});
        List<Integer> result = new ArrayList<>();
        int[] map = new int[1001];

        for(int i : nums2){
            if(map[i] > 0){
                map[i]--;
                result.add(i);
            }
        }
    }

    @RunThis(value = 10,runOnlyThis = false)
    public void ASasd(){
        System.out.println(Arrays.toString(randomArray(10000,Integer.MAX_VALUE)));
    }

    public record Something(int hello , String bye){ }

    public record Nothing(int hahah , String bye){ }


    @RunThis(value =11)
    public void dontRun() {
        Something something = new Something(2,"dsh");
        System.out.println(map(something,Nothing.class));
    }

    @RunThis(value = 12)
    public void petersons(){
//        PetersonsAlgorithm.execute();

            int[] a = new int[100000];
                 for(int i = 0; i< 100000; i++){
                     a[i] = Integer.MAX_VALUE;
                 }
        System.out.println(findPrefixScore(a)[a.length -1 ] < Long.MAX_VALUE);

        System.out.println();

    }
    public long[] findPrefixScore(int[] nums) {

        long sum = 0, max = 0;
        long[] res = new long[nums.length];
        for(int i = 0; i < nums.length; i++){
            max = Math.max(nums[i],max);
            sum += (max + nums[i]);
            res[i] = sum;
        }
        return res;

    }

}
