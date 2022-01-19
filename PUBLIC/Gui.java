// Imports
import javax.swing.*;

public class Gui {
   
  public JButton close, aproduct, dproduct, simulation;
  public JFrame f;
  public JComboBox menu;
  public String[] menupoints = {"Menu","Add Product","Delete Produkt"};
                               
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
    
    dproduct = new JButton("Delete Product");
    dproduct.setBounds(450, 150, 200, 50);
    f.add(dproduct);
    
    simulation = new JButton("Simulation");
    simulation.setBounds(450, 250, 200, 50);
    f.add(simulation);
    
    menu = new JComboBox(menupoints);
    menu.setBounds(10, 10, 100, 50);
    f.add(menu);
    
    // ActionListeners
    close.addActionListener(a -> {
      System.exit(0);
    });

    aproduct.addActionListener(b -> {
      f.dispose();
      new Add_Product();
    });

    dproduct.addActionListener(c -> {
      f.dispose();
      new Delete_Product();
    });

    simulation.addActionListener(d -> {
      f.dispose();
      new Simulation();
    });
    
    menu.addActionListener(e -> {;
      if (menu.getSelectedIndex()==1) {
        f.dispose();
        new Add_Product();
      } 
      if (menu.getSelectedIndex()==2) {
        f.dispose();
        new Delete_Product();
      } 
    });
    
    
    
    
    
    
    
    
  } 
  
  public static void main (String[] args) {
    new Splash().showSplash();
    new Gui();
  }
  
}
