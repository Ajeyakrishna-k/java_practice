package org.practice.graphs;

import java.util.*;
import java.io.*;


public class KruskalsAlgorithm {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



    private static class Edge<V,W> {
        V v1;
        V v2;
        W w;

        public Edge(V value1,
                    V value2,
                    W weight){
            this.v1 = value1;
            this.v2 = value2;
            this.w = weight;
        }

        public String toString(){
            return "{v1 : "+v1+", v2 : "+v2+", w :"+w+"}";
        }
    }
    public static List<Edge<Integer,Integer>> takeInput(int V, int E) throws IOException {
        String[] strNums;
        // strNums = br.readLine().split("\\s");
        // int V = Integer.parseInt(strNums[0]);
        // int E = Integer.parseInt(strNums[1]);

        List<Edge<Integer,Integer>> list = new ArrayList<>();
        for(int i = 0; i < E; i++){
            strNums = br.readLine().split("\\s");
            Edge<Integer,Integer> edge = new Edge<>(Integer.parseInt(strNums[0]),Integer.parseInt(strNums[1]),Integer.parseInt(strNums[2]));
            list.add(edge);
        }
        return list;
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        String[] strNums;
        strNums = br.readLine().split("\\s");
        int V = Integer.parseInt(strNums[0]);
        int E = Integer.parseInt(strNums[1]);
        List<Edge<Integer,Integer>> list = takeInput(V,E);

        Collections.sort(list,(e1,e2) -> e1.w - e2.w);

        int[] parent = new int[V];
        for(int i = 0; i < V; i++){
            parent[i] = i;
        }

        List<Edge<Integer,Integer>> res = new ArrayList<>();

        int count = 0;
        for(int i = 0; i < list.size() && count < V - 1; i++){
            Edge<Integer,Integer> edge = list.get(i);
            int parentV1 = edge.v1;
            int parentV2 =  edge.v2;

            Stack<Integer> stack = new Stack<>();
            while(parentV1 != parent[parentV1]){
                stack.push(parentV1);
                parentV1 = parent[parentV1];
            }

            while(!stack.isEmpty()){
                parent[stack.pop()] = parentV1;
            }

            while(parentV2 != parent[parentV2]){
                stack.push(parentV2);
                parentV2 = parent[parentV2];
            }

            while(!stack.isEmpty()){
                parent[stack.pop()] = parentV2;
            }

            // System.out.println(" v1 "+edge.v1+ " | pv1 "+parentV1+" || v2 "+edge.v2+ " | pv2 "+parentV2 );


            if(parentV1 != parentV2){
                if(parentV1 > parentV2){
                    parent[parentV2] = parentV1;
                }
                else{
                    parent[parentV1] = parentV2;
                }

                res.add(edge);
                count++;
            }



        }

        for(int i = 0; i < res.size(); i++){
            Edge<Integer,Integer> edge = res.get(i);
            int v1 = edge.v1 ;
            int v2 = edge.v2;
            if(v1 < v2){
                System.out.println(v1 + " " + v2+ " "+ edge.w);
            }
            else{
                System.out.println(v2 + " " + v1+ " "+ edge.w);
            }
        }



        // for(int[] i : graphs){
        // System.out.println(list);
        // }

    }




}