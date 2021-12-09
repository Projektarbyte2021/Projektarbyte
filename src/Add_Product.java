import java.awt.*;
import javax.swing.*;
import java.io.*;

/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 09.12.2021
 * @author 
 */

public class Add_Product extends JFrame {
  // Anfang Attribute
  private JButton close = new JButton();
  private JButton back = new JButton();
  private JButton add = new JButton();
  private JRadioButton don = new JRadioButton("Description on");
  private JRadioButton doff = new JRadioButton("Description off");
  private JTextArea nproduct = new JTextArea("");
  private JScrollPane nproductScrollPane = new JScrollPane(nproduct);
  private JTextArea cproduct = new JTextArea("");
  private JScrollPane cproductScrollPane = new JScrollPane(cproduct);
  private JLabel name = new JLabel();
  private JLabel category = new JLabel();
  private JTextArea pproduct = new JTextArea("");
  private JScrollPane pproductScrollPane = new JScrollPane(pproduct);
  private JLabel price = new JLabel();
  private JTextArea iproduct = new JTextArea("");
    private JScrollPane iproductScrollPane = new JScrollPane(iproduct);
  private JLabel info = new JLabel();
  // Ende Attribute
  
  public Add_Product() { 
    // Frame-Initialisierung
    super("Verwaltungsprogramm - Add Product");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setVisible(true);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    close.setBounds(200, 500, 200, 50);
    close.setText("Close");
    close.addActionListener(a -> {
      System.exit(0);
    });
    cp.add(close);
    back.setBounds(450, 500, 200, 50);
    back.setText("Back");
    back.addActionListener(a -> {;
      this.dispose();
      new Main();
    });
    cp.add(back);
    add.setBounds(450, 100, 200, 50);
    add.setText("Add");
    add.addActionListener(a -> {
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
    don.addActionListener(a -> {;
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
    
    cp.add(add);
    don.setBounds(420, 38, 100, 20);
    cp.add(don);
    doff.setBounds(420, 73, 100, 20);
    cp.add(doff);
    nproductScrollPane.setBounds(130, 27, 168, 44);
    cp.add(nproductScrollPane);
    cproductScrollPane.setBounds(130, 80, 168, 44);
    cp.add(cproductScrollPane);
    name.setBounds(16, 34, 110, 20);
    name.setText("Name of Product:");
    cp.add(name);
    category.setBounds(13, 90, 110, 20);
    category.setText("Category of Product:");
    cp.add(category);
    pproductScrollPane.setBounds(130, 137, 168, 44);
    cp.add(pproductScrollPane);
    price.setBounds(12, 150, 110, 20);
    price.setText("Price of Product:");
    cp.add(price);
    iproductScrollPane.setBounds(129, 194, 168, 44);
    cp.add(iproductScrollPane);
    info.setBounds(9, 211, 110, 20);
    info.setText("Description of Product: ");
    cp.add(info);
    // Ende Komponenten
  } 
  
}
  
 