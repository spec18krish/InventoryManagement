/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prsentation.Dealers;

import Enums.NavigationAction;
import EventObject.TabChangeEventObj;
import Presentation.Common.TabNavigationPanel;
import customcontrols.GridViewPanel;
import customcontrols.TableModel;
import domainModels.DealerModel;
import domainModels.ProductModel;
import interfaces.TabChangeRequestHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import net.miginfocom.swing.MigLayout;
import repository.DealerRepository;
import repository.ProductRepository;

/**
 *
 * @author Vidhya Mohan
 */
public class BrowseDealer extends TabNavigationPanel {
    
   GridViewPanel<DealerModel> grd;
   
   public BrowseDealer() {
        super();
        this.setLayout(new MigLayout());  
        initializeBrowseDealer();
        this.add(grd, "span, grow, push");
        tabChangeHandlers = new ArrayList<TabChangeRequestHandler>();
        this.setPreferredSize(skin.frameDimension);
   }
    
    public void initializeBrowseDealer() {
       grd = new GridViewPanel<DealerModel>();       
       loadGrid();
       grd.addDoubleClickHandler(e -> gridViewRowDoubleClicked((DealerModel) e));
       grd.addClickHandler(e -> gridViewClicked((DealerModel)e));
    }
    

    
        public void loadGrid() {
        ArrayList<DealerModel> modelList = new ArrayList<DealerModel>();
        HashMap<String, String> columnsKeyVal = new LinkedHashMap<String, String>();    
   
        columnsKeyVal.put("companyName", "Company");
        columnsKeyVal.put("user-firstName", "Contact First Name");
        columnsKeyVal.put("user-lastName", "Contact Last Name");
        columnsKeyVal.put("user-email", "Email");
        columnsKeyVal.put("user-mobileNumber", "Mobile");
        columnsKeyVal.put("user-suburb", "Suburb");
        columnsKeyVal.put("user-city", "City");
          
        
        DealerRepository repo = new DealerRepository();
        modelList= repo.getAll();
    
       TableModel<DealerModel> tblModel = new TableModel<DealerModel>(modelList, columnsKeyVal);
       grd.setModel(tblModel);
       
       //TableCellRenderer tableRenderer = grd.getGridView().getDefaultRenderer(Button.class);
       
       //grd.getGridView().setDefaultRenderer(Button.class, new GridCellRenderer(tableRenderer));
       //grd.getGridView().getColumn("Add To Order").setCellRenderer(new GridCellRenderer(tableRenderer, Button.class));
       
       grd.addGridButtonClickHandler(e -> gridButtonClicked(e));
    }
    
    public void gridViewClicked(DealerModel model) {
        this.fireDataNavigationChanged(model);
    }

    public void gridViewRowDoubleClicked(DealerModel model) {
       this.fireTabChangeRequest(new TabChangeEventObj(1, model, NavigationAction.Update));
    }
    
    public void gridButtonClicked(DealerModel model) {
        int h = 0;
    }
    
    
    
}
