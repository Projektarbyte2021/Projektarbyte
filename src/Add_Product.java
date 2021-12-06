import javax.swing.*;  
import java.awt.*;  
import java.io.*;

public class Add_Product extends JFrame  {  
    JPanel panel;
    JButton close, back, add;
    JRadioButton don, doff;
    JTextArea nproduct, cproduct, pproduct, iproduct;
    JLabel name, category, price, info; 
  public Add_Product() {             
    super("Verwaltungsprogramm - Add Product");
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    
    // add JCheckBox for Description on
    don = new JRadioButton("Description on");
    
    // add JCheckBox for Description off
    doff = new JRadioButton("Description off");
    
    panel = new JPanel(); 
    panel.setBackground(Color.gray);
    
    // add JLabel for Name of Product
    name = new JLabel("Name of Product:");
    name.setBounds(100, 50, 100, 10);
    
    // add JTextArea for Name of product
    nproduct = new JTextArea("Name: ");
    nproduct.setBounds(220, 47, 100, 20);
    
    // add JLabel for Category of Product
    category = new JLabel("Category of Product:");
    category.setBounds(100, 87, 200, 20);
    
    // add JTextArea for Category of product
    cproduct = new JTextArea("Category: ");
    cproduct.setBounds(220, 90, 100, 20);
    
    // add JLabel for Price of Product
    price = new JLabel("Price of Product:");
    price.setBounds(100, 150, 100, 10);
    
    // add JTextArea for Price of Product
    pproduct = new JTextArea("Price: ");
    pproduct.setBounds(220, 150, 100, 20);
    
    // add JLabel for Information of Product
    info = new JLabel("Information of Product:");
    info.setBounds(100, 200, 200, 10);
    
    // add JTextArea for Information of product
    iproduct = new JTextArea("Information of Product: ");
    iproduct.setBounds(220, 200, 200, 50);
    
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
    this.add(panel);
    panel.add(close);
    panel.add(back);
    panel.add(add);
    panel.add(don);
    panel.add(doff);   
    panel.add(name);
    panel.add(info);
    panel.add(price);
    panel.add(category);
    panel.add(nproduct);
    panel.add(cproduct);
    panel.add(iproduct);
  }
}
  


