/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Exceptions;

/**
 * Exception when element is not found
 *
 * @param String str
 */
public class ElementNotFoundException extends Exception {

    public ElementNotFoundException(String str) {
        super(str);
    }
}
