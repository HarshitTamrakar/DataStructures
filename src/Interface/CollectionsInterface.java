/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author hp 630
 */
public interface CollectionsInterface<datatype> {

    public void add(datatype data);

    public boolean isEmpty();

    public datatype remove() throws Exception;

    public void print() throws Exception;

    public int size();

}
