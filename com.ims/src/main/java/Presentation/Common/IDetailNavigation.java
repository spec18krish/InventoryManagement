/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Common;

/**
 *
 * @author Vidhya Mohan
 */
public interface IDetailNavigation<T> {
    
    void save();
    void update();
    void delete();
    void add();
    void setValues(T Model);
    T getUserSelectedValues();
    void load(T model);
    void setDefaultValues();    
      
}
