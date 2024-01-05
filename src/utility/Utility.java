package utility;


import edusera.ui.misc.RouterJPanel;
import java.awt.CardLayout;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ingale.r
 */
public class Utility {
        
    
    public static void switchPanel(JPanel switchTo, JPanel switchWhere){
        switchWhere.add("switched",switchTo);
        CardLayout layout = (CardLayout) switchWhere.getLayout();
        layout.next(switchWhere);
    }
    
    public static void imageResize(JLabel lbl, String imgPath){
        ImageIcon ii = new ImageIcon(imgPath);
        Image image = ii.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        lbl.setIcon(new ImageIcon(image));
    }
  
    public static void goBack(JPanel switchWhere){
        CardLayout layout = (CardLayout) switchWhere.getLayout();
        layout.previous(switchWhere);
    }
    
    public static void addToComboBox(JComboBox combo, List list){
        for(Object obj: list){
            combo.addItem(obj);
        }
    }
}
