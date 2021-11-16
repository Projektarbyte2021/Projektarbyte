import javax.swing.*;

public class Add_Product extends JFrame {
    JButton close, back;
    public Add_Product() {
    super("Verwaltungsprogramm - Add Product");
    this.setBounds(400, 100, 800, 600);
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
  }
  public static void main(String[] args) {
    new Add_Product();
  }
}

