/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph.weightedGraph;

import java.util.Scanner;

/**
 *
 * @author Tanya
 */
public class Test {
    //5 7 0 1 1 0 2 7 1 2 5 1 3 4 1 4 3 2 4 6 3 4 2 - kruskal
    //6 11 1 3 1 0 1 2 0 3 3 0 2 4 4 5 5 2 3 6 3 5 7 2 1 8 2 4 9 2 5 10 3 4 11 - kruskal
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        WeightedGraph graphs = new WeightedGraph(vertices);
        int edges = sc.nextInt();
        while(--edges >= 0){
            graphs.addEdge(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        graphs.kruskalsAlgorithm(vertices);
    }
    
}
