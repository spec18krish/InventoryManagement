/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ims.businesslogics;

import com.ims.dataAccess.tables.pojos.Product;
import com.ims.dataAccess.tables.pojos.Productcategory;
import repository.test;

/**
 *
 * @author Vidhya Mohan
 */
public class Test {
    
    public void create() {
        Productcategory pc = new Productcategory();
        pc.setName("thamara");
        test t = new test();
        t.create(pc);
        
    }
    
}
