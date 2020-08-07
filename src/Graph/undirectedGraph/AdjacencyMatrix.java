/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph.undirectedGraph;

import Interface.GraphInterface;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Tanya
 */
public class AdjacencyMatrix implements GraphInterface{
    
    int[][] matrix;

    public AdjacencyMatrix(int vertices) {
        matrix = new int[vertices][vertices];
    }
    
    @Override
    public void addEdge(int source, int destination){
        if(source > matrix.length || destination > matrix.length || source < 1 || destination < 1){
            System.out.println("Invalid Vertex ");
            return; 
        }
        matrix[source - 1][destination - 1] = 1;
        matrix[destination - 1][source - 1] = 1;
    }

    @Override
    public void deleteEdge(int source, int destination) {
        if(source > matrix.length || destination > matrix.length || source < 1 || destination < 1){
            System.out.println("Invalid Vertex ");
            return; 
        }
        matrix[source - 1][destination - 1] = 0;
        matrix[destination - 1][source - 1] = 0;
    }

    @Override
    public void printBFSGraph() {
        System.out.println("BFS");
        Queue<Integer> pending = new LinkedList<>();
        pending.add(1);
        boolean[] visited = new boolean[matrix.length];
        while(!pending.isEmpty()){
            int vertex = pending.remove() - 1;
            if(visited[vertex]){
                continue;
            }
            visited[vertex] = true;
            System.out.print("Vertex " + (vertex + 1)+" has edges ");
            for(int i = 0; i < matrix.length; i++){
                if(matrix[vertex][i] == 1){
                    System.out.print((i + 1) + ", ");
                    pending.add(i + 1);
                }
            }
            System.out.println();
        }
    }
    
    private void dfsHelper(int startVertex, boolean[] visited){
        if(visited[startVertex]){
            return;
        }
        visited[startVertex] = true;
        System.out.print((startVertex + 1)+" -> ");
        for(int i = 0; i < matrix.length; i++){
            if(matrix[startVertex][i] == 1){
                dfsHelper(i, visited);
            }
        }
        //System.out.println();
    }
    
    @Override
    public void printDFSGraph() {
        System.out.println("DFS");
        dfsHelper(3, new boolean[matrix.length]);
    }
    
    public void printGraph(){
        System.out.println("BFS + DFS");
        Queue<Integer> pending = new LinkedList<>();
        pending.add(1);
        boolean[] visited = new boolean[matrix.length];
        while(!pending.isEmpty()){
            int vertex = pending.remove() - 1;
            if(visited[vertex]){
                continue;
            }
            visited[vertex] = true;
            System.out.print("Vertex " + (vertex + 1)+" has edges ");
            for(int i = 0; i < matrix.length; i++){
                if(matrix[vertex][i] == 1){
                    pending.add(i + 1);
                }
            }
            dfsHelper(vertex, new boolean[matrix.length]);
            System.out.println();
        }
    }
}
