/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.Interface;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vidhya Mohan
 */
public interface IRepository<T> {
    
    int createEntity(T model);
    
    int updateEntity(T model);
    
    int deleteEntityById(int id);
    
    ArrayList<T> getAll();
    
    T getById(int id);
}
