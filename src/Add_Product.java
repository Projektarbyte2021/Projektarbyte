import javax.swing.*;
import java.io.*;

public class Add_Product extends JFrame  {
    JButton close, back, add;
    JTextArea nproduct, cproduct, pproduct, iproduct;
    JLabel name, category, price, info;
    public Add_Product() {
    super("Verwaltungsprogramm - Add Product");
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(null);
    this.setVisible(true);
    
    // add JButton for Cancel
    close = new JButton("Close");
    close.setBounds(200, 500, 200, 50);
    
    // add JButton for Back
    back = new JButton("Back");
    back.setBounds(450, 500, 200, 50);
    
    // add JButton for Add
    add = new JButton("Add");
    add.setBounds(450, 100, 200, 50);
    
    // add JLabel for Name of Product
    name = new JLabel("Name of Product:");
    name.setBounds(100, 50, 100, 10);
    
    // add JTextArea for Name of product
    nproduct = new JTextArea("Name: ");
    nproduct.setBounds(210, 47, 100, 20);
    
    // add JLabel for Category of Product
    category = new JLabel("Category of Product:");
    category.setBounds(100, 87, 100, 10);
    
    // add JTextArea for Category of product
    cproduct = new JTextArea("Category: ");
    cproduct.setBounds(210, 90, 100, 20);
    
    // add JLabel for Price of Product
    price = new JLabel("Price of Product:");
    price.setBounds(100, 150, 100, 10);
    
    // add JTextArea for Price of Product
    pproduct = new JTextArea("Price: ");
    pproduct.setBounds(210, 150, 100, 20);
    
    // add JLabel for Information of Product
    info = new JLabel("Information of Product:");
    info.setBounds(100, 200, 200, 10);
    
    // add JTextArea for Information of product
    iproduct = new JTextArea("Information of Product: ");
    iproduct.setBounds(210, 200, 200, 50);
    
    /*JComboBox cproduct = new JComboBox(windowList);
        cproduct.setBounds(550,225, 200,50);*/
    
    // add Actionlisteners
    close.addActionListener(a -> {System.exit(0);});
    back.addActionListener(b -> {this.dispose(); new Main();});
    add.addActionListener(c -> {
      try {
            File file = new File("");
            JFileChooser fc = new JFileChooser();
            fc.showSaveDialog(null); 
            file = fc.getSelectedFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(nproduct.getText());
            bw.write("\n");
            bw.write(cproduct.getText());
            bw.write("\n");
            bw.write(pproduct.getText());
            bw.write("\n");
            bw.write(iproduct.getText());
            bw.flush();
      }catch (IOException e) {e.printStackTrace();}
  });
    
    // add JButtons to JFrame
    this.add(close);
    this.add(back);
    this.add(add);
    this.add(name);
    this.add(info);
    this.add(price);
    this.add(category);
    this.add(nproduct);
    this.add(cproduct);
    this.add(pproduct);
    this.add(iproduct);
  }
}
  


