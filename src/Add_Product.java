// Imports
import java.awt.*;
import javax.swing.*;
import java.io.*;

public class Add_Product extends JFrame {
                                 
  private JButton close, back, add;
  private JRadioButton don, doff;
  private JTextArea nproduct, cproduct, pproduct, iproduct;  
  private JScrollPane nproductScrollPane, cproductScrollPane, pproductScrollPane, iproductScrollPane;
  private JLabel name, category, price, info;
  
  public Add_Product() { 
    super("Verwaltungsprogramm - Add Product");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setVisible(true);
    Container cp = getContentPane();
    cp.setLayout(null);
    
    // JTextAreas and JScrollPanes
    nproduct = new JTextArea();
    nproductScrollPane = new JScrollPane(nproduct);
    nproductScrollPane.setBounds(150, 27, 168, 44);
    cp.add(nproductScrollPane);
    
    cproduct = new JTextArea();
    cproductScrollPane = new JScrollPane(cproduct);
    cproductScrollPane.setBounds(150, 80, 168, 44);
    cp.add(cproductScrollPane);
    
    pproduct = new JTextArea();
    pproductScrollPane = new JScrollPane(pproduct);
    pproductScrollPane.setBounds(150, 137, 168, 44);
    cp.add(pproductScrollPane);
    
    
    iproduct = new JTextArea();
    iproductScrollPane = new JScrollPane(iproduct);
    iproductScrollPane.setBounds(150, 194, 168, 44);
    cp.add(iproductScrollPane);
    
    // JLabels
    name = new JLabel("Name of Product:");
    name.setBounds(16, 34, 150, 20);
    cp.add(name);
    
    category = new JLabel("Category of Product:");
    category.setBounds(16, 90, 150, 20);
    cp.add(category);
    
    price = new JLabel("Price of Product:");
    price.setBounds(16, 150, 150, 20);
    cp.add(price);
    
    info = new JLabel("Description of Product: ");
    info.setBounds(16, 211, 150, 20);
    cp.add(info);
    
    // JButtons
    close = new JButton("Close");
    close.setBounds(200, 500, 200, 50);
    cp.add(close);
    
    back = new JButton("Back");
    back.setBounds(450, 500, 200, 50);
    cp.add(back);
    
    add = new JButton("Add");
    add.setBounds(450, 100, 200, 50);
    cp.add(add);
    
    don = new JRadioButton("Label on");
    don.setBounds(420, 38, 100, 20);
    cp.add(don);
    
    doff = new JRadioButton("Label off");
    doff.setBounds(420, 73, 100, 20);
    cp.add(doff);
    
    // ActionListeners 
    close.addActionListener(a -> {
      System.exit(0);
    });
     
    back.addActionListener(a -> {
      this.dispose();
      new Main();
    });
    
    add.addActionListener(a -> {
      try {
        boolean neu = false;
        File file = new File("");
        JFileChooser fc = new JFileChooser();
        fc.showSaveDialog(null); 
        file = fc.getSelectedFile();
        if(!file.exists()) {
          file.createNewFile();
          neu = true;
        }      
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
        if (!neu) {
          bw.write("\n");
          bw.write("\n");
        } // end of if
        bw.write("");
        bw.write(nproduct.getText());
        bw.write("\n");
        bw.write(cproduct.getText());
        bw.write("\n");
        bw.write(pproduct.getText());
        bw.write("\n");
        bw.write(iproduct.getText());
        bw.flush(); 
      }catch (IOException e) {
        // e.printStackTrace();
        ErrorDialog error = new ErrorDialog();
        error.setWriteError();
      }
    });
    
    don.addActionListener(a -> {
      nproduct.setText("Name: ");
      cproduct.setText("Category: ");
      pproduct.setText("Price: ");
      iproduct.setText("Description: ");
    });
    
    doff.addActionListener(a -> {
      nproduct.setText(" ");
      cproduct.setText(" ");
      pproduct.setText(" ");
      iproduct.setText(" ");
    });
    
  } 
  
}
  
 