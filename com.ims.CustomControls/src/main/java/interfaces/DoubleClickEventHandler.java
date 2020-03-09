/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author Vidhya Mohan
 */
@FunctionalInterface
public interface DoubleClickEventHandler<T> {
    
    void onDoubleClick(T eventArgs);
}
