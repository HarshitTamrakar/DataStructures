/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author Tanya
 */
public interface GraphInterface {
    
    public void addEdge(int source, int destination);
    
    public void deleteEdge(int source, int destination);
    
    public void printBFSGraph();
    
    public void printDFSGraph();
    
}
