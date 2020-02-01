/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customcontrols;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 *
 * @author Vidhya Mohan
 */
public class GridBagLayoutPanel extends Panel {
    
    private ArrayList<JComponent> components;
    private int noOfColumns = 4;
    private int noOfRows = 4;    
    private int currentRow = 0;
    private int currentCol = 0;
    private int weightX = 0;
    private int weighty = 0;
    private Insets insets = new Insets(20, 20, 0, 0);
    
    public static enum Position {
        inline,
        block        
    }
    
    public static enum Align {
        top,
        first,
        center,
        last,
        bottom
    }
    
    public static enum Fill {
        none,
        remaining,
        nextLine
    }
    
    public GridBagLayoutPanel(int columns, int rows) {
        noOfColumns = columns; 
        noOfRows = rows;
        initializeLayout();
    }
    
    public GridBagLayoutPanel(int columns, int rows, Insets insets) {
        noOfColumns = columns;       
        noOfRows = rows;
        this.insets = insets;
        initializeLayout();
    }
    
     public void initializeLayout(){
        setLayout(new GridBagLayout());    
    }
    
     public void addControl(JComponent item) {   
         this.addControl(item, Position.inline, 1, insets, Fill.none, Align.first);       
    }
    
     public void addControl(JComponent item, Position pos) {   
         this.addControl(item, pos, 1, insets , Fill.none, Align.first);       
    }
    
     public void addControl(JComponent item, Position pos, Insets inset) {
         this.addControl(item, pos, 1, inset, Fill.none, Align.first);
     }
     
     public void addControl(JComponent item, Fill fill) {
         int columnWidth = 1;
         Position pos = null;
         if(fill == Fill.remaining) {
             columnWidth = this.noOfColumns - this.currentCol;   
               pos = Position.inline;
         } else if(fill == Fill.nextLine) {
              columnWidth = this.noOfColumns; 
              pos = Position.block;
         }
         
         this.addControl(item, pos, columnWidth, insets, fill, Align.first);
     }
     
     public void addControl(JComponent item, Fill fill, Insets inset) {
         int columnWidth = 1;
         Position pos = null;
         if(fill == Fill.remaining) {
             columnWidth = this.noOfColumns - this.currentCol;   
               pos = Position.inline;
         } else if(fill == Fill.nextLine) {
              columnWidth = this.noOfColumns; 
              pos = Position.block;
         }
         
         this.addControl(item, pos, columnWidth, inset, fill, Align.first);
     }
     
     public void addControl(JComponent item, Position pos, int columnWidth,  Align align) {
          this.addControl(item, pos, columnWidth, this.insets, Fill.none, align);
     }
     
      public void addControl(JComponent item, int xLocation) {
          this.currentCol = xLocation;
          this.addControl(item, Position.block, 1, this.insets, Fill.none, Align.first);
     }
     
      public void addControl(JComponent item, Align align, int columnWidth, Fill fill) {
       
         Position pos = null;
         if(fill == Fill.remaining) {
             columnWidth = this.noOfColumns - this.currentCol;   
               pos = Position.inline;
         } else if(fill == Fill.nextLine) {
              columnWidth = this.noOfColumns; 
              pos = Position.block;
              
         }
         
         this.addControl(item, pos, columnWidth, this.insets, fill, align);
     }
     
     public void addControl(JComponent item, Position pos, int columnWidth) {
         this.addControl(item, pos, columnWidth, insets, Fill.none, Align.first);
     }
    
     public void addControl(JComponent item, Position pos, int columnWidth, Insets inset, Fill fill, Align align) {
       
        GridBagConstraints gbConstraints = new GridBagConstraints();
        
        gbConstraints = this.getAnchorAlignement(gbConstraints, align);
       
        gbConstraints.gridwidth = columnWidth;
      
        gbConstraints.insets = inset;        
      
        
        
        if(((this.currentCol > this.noOfColumns) || (columnWidth == this.noOfColumns)) && pos != Position.block) {
            this.currentCol = 0;
            this.currentRow += 1;
        } 
        else if (pos == Position.block) 
        {
            this.currentRow += 1;        
            this.currentCol = 0;            
        }
        
           
         if((this.currentCol == this.noOfColumns)) {
            gbConstraints.weightx = 1;
            gbConstraints.weighty = 0.1;
        }        
         else{
             gbConstraints.weightx = 0.1;
             gbConstraints.weighty = 0.1;
         }
        
        if (pos == Position.block) {    
            gbConstraints.gridy = this.currentRow;
            gbConstraints.gridx = this.currentCol;           
            if (fill == Fill.nextLine) {
                this.currentCol = this.noOfColumns;
               gbConstraints.fill = GridBagConstraints.HORIZONTAL;
               gbConstraints.anchor = GridBagConstraints.CENTER;
               gbConstraints.gridwidth = this.noOfColumns + 1;
            }             
        } 
        else if(pos == Position.inline) {
            gbConstraints.gridx = this.currentCol;
            gbConstraints.gridy = this.currentRow;
                    
        }
        
        
        if(align != Align.first) {
//            gbConstraints.weightx = 1;
//            gbConstraints.weighty = 0.1;
//            gbConstraints.gridx = this.noOfColumns;
            gbConstraints.fill = GridBagConstraints.NONE;
        }
        
        this.addControl(item, gbConstraints);    
        
        this.currentCol = this.currentCol + columnWidth;
    }
     
     public void addControlWithPosition(JComponent item, int xLocation) {
         GridBagConstraints gbConstraints = new GridBagConstraints();
         this.currentRow = this.currentRow + 1;
         this.currentCol = xLocation;
         gbConstraints.gridx = this.currentCol;
         gbConstraints.gridy = this.currentRow;  
         gbConstraints.insets = this.insets;
         this.add(item, gbConstraints);
     }
     
     public void addControl(JComponent item, GridBagConstraints gbConstraints) 
     {
         this.add(item, gbConstraints);
     }
     
     
     
     private void checkAlignement(GridBagConstraints gc, Align align) {
         
     }
     
     private GridBagConstraints getAnchorAlignement(GridBagConstraints gc, Align align) {
         
         switch(align) 
         {
             case top:
             gc.anchor = GridBagConstraints.PAGE_START;
             return gc;
                 
             case first:
             gc.anchor = GridBagConstraints.LINE_START;
             gc.gridx = 0;
             return gc;
                 
             case center:
             gc.anchor = GridBagConstraints.CENTER;
             gc.gridx = this.noOfColumns / 2;
             return gc;
             
             case last:
             gc.anchor = GridBagConstraints.LAST_LINE_END;
             gc.gridx = this.noOfColumns;
             gc.weightx = 1;
             gc.weighty = 0.1;             
             return gc;
                 
             case bottom:
             gc.anchor = GridBagConstraints.PAGE_END;
             return gc;   
                 
             default:
             gc.anchor = GridBagConstraints.WEST;
             return gc;   
              
         }
     }

     public int getCurrentRowNum() 
     {
         return this.currentRow;
     }
     
     public int getCurrentColNum() 
     {
         return this.currentCol;
     }
}
