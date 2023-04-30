package org.practice.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GraphUtils {

    // Limited and shit
    public static int[][] takeInput()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vertices need to be consecutive");
        System.out.print("Enter number of vertices: ");
        int vertices = scanner.nextInt();
        int[][] adjacencyMatrix = new int[vertices][vertices];
        System.out.print("Enter number of edges: ");
        int edges = scanner.nextInt();
        for(int i = 0; i < edges; i++){
            System.out.print("Enter edge number "+ (i+1)+" : " );
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            adjacencyMatrix[v1][v2] = 1;
            adjacencyMatrix[v2][v1] = 1;
        }

        return adjacencyMatrix;
    }

    public static List<Integer> depthFirstSearch(int[][] input){
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[input.length];
        depthFirstSearch(input,visited,0,result);
        return result;
    }

    private static void depthFirstSearch(int[][] input,boolean[] visited, int vertex, List<Integer> result){

        result.add(vertex);
        visited[vertex] = true;

        for(int i = 0; i < input.length; i++){
            int n = input[vertex][i];
            if(n == 1 && !visited[i]){
                depthFirstSearch(input,visited,i,result);
            }
        }


    }
}
