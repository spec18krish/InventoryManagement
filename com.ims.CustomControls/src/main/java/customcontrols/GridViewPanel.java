/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customcontrols;


import interfaces.ClickEventHandler;
import interfaces.DoubleClickEventHandler;

import interfaces.MouseClickHandler;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Vidhya Mohan
 */
public class GridViewPanel<T> extends Panel {

    /**
     * Creates new form GridViewPanel
     */

    List<DoubleClickEventHandler> doubleClicklistners;
    List<ClickEventHandler> clicklistners;
    List<ClickEventHandler> buttonClickListners;
    public GridViewPanel() {  
        initialize();
        doubleClicklistners = new ArrayList<DoubleClickEventHandler>();
        clicklistners = new ArrayList<ClickEventHandler>();
        buttonClickListners = new ArrayList<ClickEventHandler>();
    }
    
    public void setModel(TableModel model) {
        gridview.setModel(model);
    }
    
    public TableModel getModel() {
        return (TableModel) gridview.getModel();
    }
    
    public JTable getGridView(){
        return gridview;
    }
    
    
    public void initialize(){
        this.scrollPane = new javax.swing.JScrollPane();
        this.gridview = new javax.swing.JTable();
        //this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
         this.setLayout(new MigLayout());
        //this.setPreferredSize(new Dimension(500, 500));
        
        this.gridview.setBackground(skin.milkWhiteColor);
        this.gridview.setForeground(skin.darkTextColor);
        this.gridview.setFont(skin.font20);
        this.gridview.getTableHeader().setBackground(skin.skyGreenColor);              
        this.gridview.getTableHeader().setFont(skin.font22);
        this.gridview.getTableHeader().setForeground(skin.milkWhiteColor); 
        
        
        this.gridview.setRowHeight(40);
   
     
        gridview.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollPane.setViewportView(gridview);        
        this.gridview.addMouseListener((MouseClickHandler)e -> onMouseDoubleClick(e));     
        this.gridview.addMouseListener((MouseClickHandler)e -> onMouseClick(e));
        this.gridview.addMouseListener((MouseClickHandler)e -> onButtonClick(e));
        this.add(scrollPane, "span, grow, push");

    }
    
    public void addDoubleClickHandler(DoubleClickEventHandler<T> handler) {
        doubleClicklistners.add(handler);
    }
    
    public void addClickHandler(ClickEventHandler<T> handler) {
        clicklistners.add(handler);
    }
    
    public void addGridButtonClickHandler(ClickEventHandler<T> handler) {
        buttonClickListners.add(handler);
    }
    
    public void onMouseClick(MouseEvent mouseEvent) {
             JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);               
                if (mouseEvent.getClickCount() == 1 && table.getSelectedRow() != -1) {
                   T model =  (T)((TableModel)table.getModel()).getRowByIndex(row);                  
                   for(ClickEventHandler<T> handler : clicklistners) {
                    handler.onClick(model);
                   }
                }
    }
    
    public void onMouseDoubleClick(MouseEvent mouseEvent) {
                JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);               
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                   T model =  (T)((TableModel)table.getModel()).getRowByIndex(row);
                  
                   for(DoubleClickEventHandler handler : doubleClicklistners) {
                    handler.onDoubleClick(model);
                   }
                }
    }
    
    public void onButtonClick(MouseEvent mouseEvent) {
                JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point); 
                int column = table.columnAtPoint(point);
                Class<?> comp = table.getComponentAt(row, column).getClass();                 
                if (comp == Button.class && mouseEvent.getClickCount() == 1 && table.getSelectedRow() != -1) {
                   T model =  (T)((TableModel)table.getModel()).getRowByIndex(row);                  
                   for(ClickEventHandler handler : buttonClickListners) {
                    handler.onClick(model);
                   }
                }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        gridview = new javax.swing.JTable();

        gridview.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollPane.setViewportView(gridview);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 913, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable gridview;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
