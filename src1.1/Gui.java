// Imports
import javax.swing.*;

public class Gui {
  
  public JButton close, aproduct, simulation;
  public JFrame f;

  public Gui() {
    
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch(Exception e) {
      System.out.println("Setting Look and Feel Failed");  
    }
    
    // JFrame
    f = new JFrame("Verwaltungsprogramm - Gui");
    f.setExtendedState(JFrame.MAXIMIZED_BOTH);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setLayout(null);
    f.setVisible(true);
    
    
    // JButtons
    close = new JButton("Close");
    close.setBounds(300, 500, 200, 50);
    f.add(close);
    
    aproduct = new JButton("Add Product");
    aproduct.setBounds(200, 150, 200, 50);
    f.add(aproduct);
    
    simulation = new JButton("Simulation");
    simulation.setBounds(450, 250, 200, 50);
    f.add(simulation);
    
    // ActionListeners
    close.addActionListener(a -> {
      System.exit(0);
    });

    aproduct.addActionListener(b -> {
      f.dispose();
      new Add_Product();
    });

    simulation.addActionListener(e -> {
      f.dispose();
      new Simulation();
    });
  } 
  
  public static void main (String[] args) {
    new Splash().showSplash();
    new Gui();
  }
  
}
