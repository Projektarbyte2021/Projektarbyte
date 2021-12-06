import javax.swing.*;
import java.awt.*;

public class Main {
  
  public JButton close, aproduct, dproduct, sproduct, simulation;
  public JFrame f;
                               
  public Main() {
    
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch(Exception e) {
      System.out.println("Setting Look and Feel Failed");  
    }
    
    // add Main Frame
    f = new JFrame("Verwaltungsprogramm - Main");
    f.setExtendedState(JFrame.MAXIMIZED_BOTH);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setLayout(null);
    f.setVisible(true);
    
    // add JButton for Cancel
    close = new JButton("Close");
    close.setBounds(300, 500, 200, 50);
    
    // add JButton for Add Product
    aproduct = new JButton("Add Product");
    aproduct.setBounds(200, 150, 200, 50);
    
    // add JButton for Delete Product
    dproduct = new JButton("Delete Product");
    dproduct.setBounds(450, 150, 200, 50);
    
    // add JButton for Show Button
    sproduct = new JButton("Show Product");
    sproduct.setBounds(200, 250, 200, 50);
    
    // add JButton for Simulation
    simulation = new JButton("Simulation");
    simulation.setBounds(450, 250, 200, 50);
    
    // add ActionListener
    close.addActionListener(a -> {System.exit(0);});
    aproduct.addActionListener(b -> {f.dispose(); new Add_Product();});
    dproduct.addActionListener(c -> {f.dispose(); new Delete_Product();});
    sproduct.addActionListener(d -> {f.dispose(); new Show_Product();});
    simulation.addActionListener(e -> {f.dispose(); new Simulation();});
    
    // add Items to JFrame
    f.add(close);
    f.add(aproduct);
    f.add(dproduct);
    f.add(sproduct);
    f.add(simulation);
  } 
  
  public static void main (String[] args) {
    new Main();
  }
}

