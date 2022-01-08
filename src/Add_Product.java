// Imports
import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Add_Product extends JFrame {
                                 
  private FileFilter filter;
  private JButton close, back, add;
  private JRadioButton don, doff;
  private JTextArea nproduct, /*cproduct,*/ pproduct, iproduct;  
  private JComboBox c;
  private JScrollPane nproductScrollPane, cproductScrollPane, pproductScrollPane, iproductScrollPane;
  private JLabel name, category, price, info;
  private String zv1, zv2, zv3, zv4, electronic, mechanic, social, services, error;
  private boolean test1, test2, test3, test4, test5;
  
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
    
    /*cproduct = new JTextArea();
    cproductScrollPane = new JScrollPane(cproduct);
    cproductScrollPane.setBounds(150, 80, 168, 44);
    cp.add(cproductScrollPane);*/ 
    String[] categoryList = {"Please select a category", "electronic", "mechanic", "social", "services"};
    c = new JComboBox(categoryList);
    c.setBounds(150, 80, 168, 44);
    cp.add(c);
    
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
    
    don.addActionListener(d -> {
      nproduct.setText("Name: ");
      // cproduct.setText("Category: ");
      test1 = true;
      test2 = true;
      test3 = true;
      test4 = true;
      test5 = true;
      pproduct.setText("Price: ");
      iproduct.setText("Description: ");
    });
    
    doff.addActionListener(e -> {
      nproduct.setText(" ");
      // cproduct.setText(" ");
      test1 = false;
      test2 = false;
      test3 = false;
      test4 = false;
      test5 = false;
      pproduct.setText(" ");
      iproduct.setText(" ");
    });
    
    // ItemListener
    c.addItemListener(ia -> {;
      if (c.getSelectedItem().equals("Please select a category")) {
        if (test1 == true) {
          error = "Category: non";
          electronic = "";
          mechanic = "";
          social = "";
          services = "";
        } // end of if
        
        if (test1 == false) {
          error = "non";
          electronic = "";
          mechanic = "";
          social = "";
          services = "";
        } // end of if
      } 
      
      if (c.getSelectedItem().equals("electronic")) {
        if (test2 == true) {
          error = "";
          electronic = "Category: electronic";
          mechanic = "";
          social = "";
          services = "";
        } // end of if
        
        if (test2 == false) {
          error = "";
          electronic = "electronic";
          mechanic = "";
          social = "";
          services = "";
        } // end of if
      } 
      
      if (c.getSelectedItem().equals("mechanic")) {
        if (test3 == true) {
          error = "";
          electronic = "";
          mechanic = "Category: mechanic";
          social = "";
          services = "";
        } // end of if
        
        if (test3 == false) {
          error = "";
          electronic = "";
          mechanic = "mechanic";
          social = "";
          services = "";
        } // end of if
      } 
      
      if (c.getSelectedItem().equals("social")) {
        if (test4 == true) {
          error = "";
          electronic = "";
          mechanic = "";
          social = "Category: social";
          services = "";
        } // end of if
        
        if (test4 == false) {
          error = "";
          electronic = "";
          mechanic = "";
          social = "social";
          services = "";
        } // end of if
      } 
      
      if (c.getSelectedItem().equals("services")) {
        if (test5 == true) {
          error = "";
          electronic = "";
          mechanic = "";
          social = "";
          services = "Category: services";
        } // end of if
        
        if (test5 == false) {
          error = "";
          electronic = "";
          mechanic = "";
          social = "";
          services = "services";
        } // end of if
      } 
    });
    // ActionListeners 
    close.addActionListener(a -> {
      System.exit(0);
    });
     
    back.addActionListener(b -> {
      this.dispose();
      new Main();
    });
    
    add.addActionListener(c -> {;
      JFileChooser fc = new JFileChooser();
      filter = new FileNameExtensionFilter("Textdatei", "txt");
      fc.addChoosableFileFilter(filter);   
      int i = fc.showSaveDialog(null);
      if(i == JFileChooser.APPROVE_OPTION) {
        try {
          boolean neu = false;
          File file;
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
          this.zv1 = nproduct.getText();
          bw.write("\n");
          /*bw.write(cproduct.getText());
          this.zv2 = cproduct.getText();*/
          if (error == "non") {
            bw.write(error);
          } else if (error == "Category: non") {
            bw.write(error);  
          }
          
          if (electronic == "electronic") {
            bw.write(electronic);
          } else if (electronic == "Category: electronic") {
            bw.write(electronic);  
          } 
            
          if (mechanic == "mechanic") {
            bw.write(mechanic);
          } else if (mechanic == "Category: mechanic") {
            bw.write(mechanic);  
          }
           
          if (social == "social") {
            bw.write(social);
          } else if (social == "Category: social") {
            bw.write(social);  
          }
           
          if (services == "services") {
            bw.write(services);
          } else if (services == "Category: services") {
            bw.write(services);  
          }
          bw.write("\n");
          bw.write(pproduct.getText());
          this.zv3 = pproduct.getText();
          bw.write("\n");
          bw.write(iproduct.getText());
          this.zv4 = iproduct.getText();
          bw.flush(); 
        }catch (IOException e) {
          // e.printStackTrace();
          ErrorDialog error = new ErrorDialog();
          error.setWriteError();
        }
      }
    });
    
  } 
  
  public String getName() {
    return zv1;   
  }
  
  public String getCategory() {
    return zv2;
  }
  
  public String getPrice() {
    return zv3;
  }
  
  public String getInformation() {
    return zv4;
  }


}