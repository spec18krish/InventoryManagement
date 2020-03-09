/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EventObject;

import Enums.NavigationAction;

/**
 *
 * @author Vidhya Mohan
 */
public class TabChangeEventObj {
    
    public int tabIndex;
    public Object model;
    public NavigationAction navAction;
    
    public TabChangeEventObj() {
        
    }
    
    public TabChangeEventObj(int tabIndex, Object model){
        this.tabIndex = tabIndex;
        this.model = model;
    }
    
     public TabChangeEventObj(int tabIndex, Object model, NavigationAction action){
        this.tabIndex = tabIndex;
        this.model = model;
        this.navAction = action;
    }
}
