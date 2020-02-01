/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customcontrols;

import Helper.UIHelper;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;


/**
 *
 * @author Vidhya Mohan
 */
public class PictureBox extends JPanel {
    
  String path = "";
  int imgHeight = this.getSize().height;
  int imgWidth = this.getSize().width;
  Image img;
  
  private UIHelper helper = new UIHelper();
  
  public PictureBox() {
      super();
  }
  
   public PictureBox(Image img) {
      super();
      this.img = img;
  }
   
  public void setPicture(Image img) {
      this.img = img;
      this.setPictureSize(this.getWidth(), this.getHeight());
  }
  
  public void setPicture(Image img, int width, int height) {
      this.img = img;
      this.setPictureSize(width, height);
  }
  
  
  public void setPictureSize(int width, int height) {
      this.imgHeight = height;
      this.imgWidth = width;
  }
  
   public void setPicture(String path, int width, int height) {
      this.imgHeight = height;
      this.imgWidth = width;
      this.path = path;
  }
   
   public void setImageForeColor(Color color) {
       this.setForeground(color);
   }  
  
  public void paintComponent(Graphics g) {                   
            g.drawImage(img, 0, 0, imgWidth, imgHeight, this);  
  }
    
}
