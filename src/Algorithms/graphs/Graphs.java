/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Tanya
 */
public class Graphs {
    
    public static void dfs(boolean[][] graph, int start, int end, boolean[] visited){
        if(start == end){
            return;
        }
        System.out.print(start + " -> ");
        visited[start] = true;
        for(int i = 0; i < graph.length; i++){
            if(graph[start][i] && !visited[i]){
                visited[i] = true;
                dfs(graph, i, end, visited);
            }
        }
    }
    
    public static void bfs(boolean[][] graph, int start, int end, boolean[] visited){
        Queue<Integer> pending = new LinkedList<>();
        pending.add(start);
        visited[start] = true;
        while(!pending.isEmpty()){
            int size = pending.size();
            for(int i = 0; i < size; i++){
                int current = pending.remove();
                System.out.print(current + " -> ");
                for(int child = 0; child < graph.length; child++){
                    if(graph[current][child] && !visited[child]){
                        pending.add(child);
                        visited[child] = true;
                    }
                }
            }
        }
    }
    
    //When certain order has to be followed while visiting the nodes, we can use topological sort 
    //to get the order of the nodes to be visited APPLICABLE TO DIRECTED ACYCLIC GRAPH ONLY
    public static int[] topSort(int[][] graph){
        boolean[] visited = new boolean[graph.length];
        int[] ordering = new int[graph.length];
        int index = graph.length - 1;
        for(int i = 0; i < graph.length; i++){
            if(!visited[i]){
                index = topSortDFS(graph, i, visited, ordering, index);
            }
        }
        return ordering;
    }
    
    public static int topSortDFS(int[][] graph, int start, boolean[] visited, int[] ordering, int index){
        visited[start] = true;
        for(int i = 0; i < graph.length; i++){
            if(graph[start][i] != 0 && !visited[i]){
                index = topSortDFS(graph, i, visited, ordering, index);
            }
        }
        ordering[index] = start;
        return index - 1;
    }
    
    public static void dfsSSSP(int[][] graph, int start, int[] ans, boolean[] visited){
        visited[start] = true;
        for(int i = 0; i < graph.length; i++){
            if(graph[start][i] != 0 && !visited[i]){
                visited[i] = true;
                int cost = ans[start] + graph[start][i];
                ans[i] = Math.min(ans[i], cost);
            }
        }
    }
    
    public static void SingleSourceShortestPath(int[][] graph){
        int vertices = graph.length;
        int[] ordering = topSort(graph);
//        for(int i : ordering){
//            System.out.print(i + " ");
//        }
//        System.out.println("");
        int[] ans = new int[vertices];
        for(int i = 0; i < vertices; i++){
            ans[i] = Integer.MAX_VALUE;
        }
        ans[0] = 0;
        for(int i : ordering){
            dfsSSSP(graph, i, ans, new boolean[vertices]);
        }
        for(int i : ans){
            System.out.print(i + " ");
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int edges = sc.nextInt();
//        boolean[][] graph = new boolean[vertices][vertices];      // FOR UNWEIGHTED GRAPH
//        while(--edges >= 0){
//            int start = sc.nextInt();
//            int end = sc.nextInt();
//            graph[start][end] = true;
//            //graph[end][start] = true;     //IF UNDIRECTED
//        }

        int[][] graph = new int[vertices][vertices];
        while(--edges >= 0){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            graph[start][end] = weight;
//            graph[end][start] = weight;       //IF UNDIRECTED
        }
        SingleSourceShortestPath(graph);
    }
    
}

// SAMPLE INPUT FOR SSSP
/*
    8 13
0 1 3 
0 2 6 
1 2 4 
1 4 11 
1 3 4 
2 3 8 
2 6 11 
3 4 -4 
3 5 5 
3 6 2 
4 7 9 
5 7 1 
6 7 2 
*/