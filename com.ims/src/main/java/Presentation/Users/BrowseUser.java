/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Users;

import Enums.NavigationAction;
import EventObject.TabChangeEventObj;
import Presentation.Common.TabNavigationPanel;
import customcontrols.GridViewPanel;
import customcontrols.TableModel;
import domainModels.DealerModel;
import domainModels.UserModel;
import interfaces.TabChangeRequestHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import net.miginfocom.swing.MigLayout;
import repository.DealerRepository;
import repository.UserRepository;

/**
 *
 * @author Vidhya Mohan
 */
public class BrowseUser extends TabNavigationPanel {
       GridViewPanel<UserModel> grd;
   
   public BrowseUser() {
        super();
        this.setLayout(new MigLayout());  
        initializeBrowseUser();
        this.add(grd, "span, grow, push");
        tabChangeHandlers = new ArrayList<TabChangeRequestHandler>();
        this.setPreferredSize(skin.frameDimension);
   }
    
    public void initializeBrowseUser() {
       grd = new GridViewPanel<UserModel>();       
       setGrid();
       grd.addDoubleClickHandler(e -> gridViewRowDoubleClicked((UserModel) e));
       grd.addClickHandler(e -> gridViewClicked((UserModel)e));
       
    }
    
       public void setGrid() {
         ArrayList<UserModel> modelList = new ArrayList<UserModel>();
                   
         UserRepository repo = new UserRepository();
         modelList = repo.getAll();
         loadGrid(modelList);
       }
    
        public void loadGrid(List<UserModel> modelList) {
        
        HashMap<String, String> columnsKeyVal = new LinkedHashMap<String, String>();    
   
        columnsKeyVal.put("userId", "User Id");        
        columnsKeyVal.put("firstName", "Contact First Name");
        columnsKeyVal.put("lastName", "Contact Last Name");
        columnsKeyVal.put("email", "Email");
        columnsKeyVal.put("mobileNumber", "Mobile");
        columnsKeyVal.put("suburb", "Suburb");
        columnsKeyVal.put("city", "City");
        columnsKeyVal.put("userType-userTypeName", "User Type");
          

    
       TableModel<UserModel> tblModel = new TableModel<UserModel>(new ArrayList<UserModel>(modelList), columnsKeyVal);
       grd.setModel(tblModel);
       
       //TableCellRenderer tableRenderer = grd.getGridView().getDefaultRenderer(Button.class);
       
       //grd.getGridView().setDefaultRenderer(Button.class, new GridCellRenderer(tableRenderer));
       //grd.getGridView().getColumn("Add To Order").setCellRenderer(new GridCellRenderer(tableRenderer, Button.class));
       
       grd.addGridButtonClickHandler(e -> gridButtonClicked(e));
    }
    
    public void gridViewClicked(UserModel model) {
        this.fireDataNavigationChanged(model);
    }

    public void gridViewRowDoubleClicked(UserModel model) {
       this.fireTabChangeRequest(new TabChangeEventObj(1, model, NavigationAction.Update));
    }
    
    public void gridButtonClicked(UserModel model) {
        int h = 0;
    }
    
    
}
