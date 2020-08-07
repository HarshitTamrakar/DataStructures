/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph.weightedGraph;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 * @author Tanya
 */
public class WeightedGraph {

    PriorityQueue<Edge> graph;
    int vertices;

    public WeightedGraph(int vertex) {
        graph = new PriorityQueue<Edge>();
        this.vertices = vertex;
    }

    public void addEdge(int startVertex, int endVertex, int weight) {
        Edge edge = new Edge(startVertex, endVertex, weight);
        graph.add(edge);
    }

    public int getParent(int[] parent, int child) {
        if(parent[child] == child){
            return child;
        }
        return getParent(parent, parent[child]);
    }

    public void kruskalsAlgorithm(int vertices){
        int[] parent = new int[vertices];
        for(int i = 0; i < vertices; i++){
            parent[i] = i;
        }
        
        ArrayList<Edge> output = new ArrayList<>();
        int count = 1;
        while(count < vertices){
            Edge current = graph.remove();
            int startParent = getParent(parent, current.startVertex);
            int endParent = getParent(parent, current.endVertex);
            if(startParent != endParent){
                count++;
                output.add(current);
                parent[current.endVertex] = getParent(parent, current.startVertex);
            }
        }
        for(Edge edge : output){
            System.out.println(edge.startVertex + " -> "+ edge.endVertex + " (" + edge.weight + ")");
        }
    }
}
