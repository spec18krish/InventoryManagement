/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import EventObject.TabChangeEventObj;

/**
 *
 * @author Vidhya Mohan
 */
public interface TabChangeRequestHandler {
    void changeTab(TabChangeEventObj eventObj);
}
