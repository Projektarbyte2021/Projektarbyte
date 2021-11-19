import javax.swing.*;

public class Delete_Product extends JFrame {
    JButton close, back;
    public Delete_Product() {
    super("Verwaltungsprogramm - Delete Produkt");
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(null);
    this.setVisible(true);
    
    // add JButton for Cancel
    close = new JButton("Close");
    close.setBounds(200, 500, 200, 50);
    
    // add JButton for Cancel
    back = new JButton("Back");
    back.setBounds(450, 500, 200, 50);
    
    // add Actionlisteners
    close.addActionListener(a -> {System.exit(0);});
    back.addActionListener(b -> {this.dispose(); new Main();});
    
    // add JButtons to JFrame
    this.add(close);
    this.add(back);
  } // end of main

} // end of class Delete_Product

