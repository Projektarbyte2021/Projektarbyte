/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 15.11.2021
 * @author 
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;

public class GUI extends JFrame {   
  public GUI(String t) { 
    super("Verwaltungsprogramm");
    hauptMenue();
  }   
  public static void main(String[] args) { 
    GUI obj = new GUI(" ");
 
    obj.setVisible(true);
    obj.setSize(1920,1160);
    obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    
  } // end of main
  private void hauptMenue() {
    JPanel panel1 = new JPanel();
    
    
    
    getContentPane().add(panel1,BorderLayout.CENTER);
    
    // add JButton for Cancel
    JButton cancel = new JButton("Cancel");
    panel1.add(cancel);
    
    // add JButton for Add Product
    JButton aproduct = new JButton("Add Product");
    panel1.add(aproduct);
    
    // add JButton for Delete Product
    JButton dproduct = new JButton("Delete Product");
    panel1.add(dproduct);
    
    // add JButton for Show Button
    JButton sproduct = new JButton("Show Product");
    panel1.add(sproduct);
    
    // add JButton for Simulation
    JButton simulation = new JButton("Simulation");
    panel1.add(simulation);
    
    aproduct.addActionListener(a -> {  this.dispose(); addProdukt();});
    
    
  }  
  
  private void addProdukt() {
    JFrame frame = new JFrame();
   
    frame.setVisible(true);
    frame.setSize(1920,1160);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JButton cancel = new JButton("Cancel");
    cancel.setBounds(500, 600, 100, 10);
    frame.add(cancel);
    JButton addProdukt = new JButton("Add Product");
    addProdukt.setBounds(500, 600, 100, 10);
    frame.add(addProdukt);
    }
} // end of class GUI

