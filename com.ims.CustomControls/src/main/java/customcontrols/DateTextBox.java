/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customcontrols;

import Skin.Skin;
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import java.awt.Color;
import java.awt.Dimension;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.Border;
import java.text.DateFormat;
import java.text.ParseException;

/**
 *
 * @author Vidhya Mohan
 */
public class DateTextBox extends DatePicker {
    Skin skin = new Skin();
    DatePickerSettings dateSettings;
    public DateTextBox() {
         super();
         initialize();
         
      
    } 
    
    public DateTextBox(int width, int height) {
         super();
         
         initialize();
        this.setPreferredSize(new Dimension(width, height));
        
    }   
    
    public void initialize() {
        dateSettings = new DatePickerSettings();
        dateSettings.setFormatForDatesCommonEra("dd/MM/yyyy");
        dateSettings.setSizeDatePanelMinimumWidth(300);
        dateSettings.setFontCalendarDateLabels(skin.font20);
        dateSettings.setFontCalendarWeekNumberLabels(skin.font20);
        dateSettings.setFontClearLabel(skin.font20);
        dateSettings.setFontInvalidDate(skin.font20);
        dateSettings.setFontMonthAndYearMenuLabels(skin.font20);
        dateSettings.setFontCalendarWeekdayLabels(skin.font20);
        dateSettings.setFontVetoedDate(skin.font20);
        dateSettings.setFontTodayLabel(skin.font20);    
        dateSettings.setFontValidDate(skin.font20);     
        dateSettings.setColor(DatePickerSettings.DateArea.TextFieldBackgroundInvalidDate, skin.inValidControlColor);
        dateSettings.setColor(DatePickerSettings.DateArea.TextFieldBackgroundValidDate, skin.frameBackgroundColor);
        
        Border bdr = new javax.swing.border.MatteBorder(1, 1, 1, 1, this.skin.lightSteelBlueColor);            
        
        setBorder(bdr);
          setFont(skin.font24); 
        dateSettings.setBorderCalendarPopup(bdr);       
        this.setSettings(dateSettings);
        this.setPreferredSize(new Dimension(300, 40));
        
    }   

    
    @Override
    public void setText(String text) {
        try {
            Date date =  new SimpleDateFormat("yyyy-MM-dd").parse(text);
            String parsedDate = new SimpleDateFormat("dd/MM/yyyy").format(date).toString();
            super.setText(parsedDate);
        } catch (ParseException ex) {
            Logger.getLogger(DateTextBox.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean hasValidValue() {
      String dateValue =  this.getDateStringOrEmptyString();
      if (!dateValue.isEmpty()) { 
          this.setBackground(skin.frameBackgroundColor);
          
          return true;
      }
      this.setBackground(skin.inValidControlColor);
      return false;
    }
    
}
