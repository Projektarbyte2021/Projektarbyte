// Imports
import javax.swing.*;

public class Gui {
  
  public JButton close, aproduct;
  public JFrame f;

  public Gui() {
    
    // JFrame
    f = new JFrame("Easy to Manage - Gui");
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
    
    // ActionListeners
    close.addActionListener(a -> {
      System.exit(0);
    });

    aproduct.addActionListener(b -> {
      f.dispose();
      new Product_Control();
    });
  } 
  
  public static void main (String[] args) {
    new Splash().showSplash();
    new Gui();
  }
  
}