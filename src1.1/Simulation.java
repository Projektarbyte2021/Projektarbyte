// Imports
import javax.swing.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.net.URL;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
public class Simulation {
  
  Random r = new Random();
  
  public JFrame f;
  
  private String name, category, description; 
  private int stock=0, production=1; 
  private double money=0, price;
  
  JLabel des,nam,categor,pric,inventory;
  JButton close, back;
  public Simulation() {   
    f = new JFrame("Verwaltungsprogramm - Gui");
    f.setExtendedState(JFrame.MAXIMIZED_BOTH);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setLayout(null);
    f.setVisible(true);
    
    simulation();
  }
  
  private void simulation() { 
    close = new JButton("Close");
    close.setBounds(200, 500, 200, 50);
    f.add(close);
    
    back = new JButton("Back");
    back.setBounds(450, 500, 200, 50);
    f.add(back);
    
    
    money=r.nextInt(100)+100;
     
    showPerks();
  
    close.addActionListener(a -> {System.exit(0);});
    back.addActionListener(b -> {this.dispose();new Gui();});
  } 
  
  private void showPerks() {
    nam = new JLabel("Name of Product:");
    nam.setBounds(16, 34, 150, 20);
    f.add(nam);
    
    categor = new JLabel("Category of Product:");
    categor.setBounds(16, 90, 150, 20);
    f.add(categor);
    
    pric = new JLabel("Price of Product:");
    pric.setBounds(16, 150, 150, 20);
    f.add(pric);
                                                                    
    inventory = new JLabel("In Stock: ");
    inventory.setBounds(16, 211, 150, 20);
    f.add(inventory);
    
    des = new JLabel("Description of Product: ");
    des.setBounds(16, 271, 150, 20);
    f.add(des);
  }
  
                                                                  
  
  
  

  
}
