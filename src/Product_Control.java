// Imports
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Product_Control extends JFrame implements ActionListener {
  // Anfang Attribute
  private FileFilter filter;
  public Locale locale;
  public static ResourceBundle bundle;
  private JButton close, add, show, alldelete;
  private JRadioButton donoff;
  private JTextArea nproduct, pproduct, iproduct, inventoryproduct, read, productnumber;
  private JComboBox c;
  private JScrollPane nproductScrollPane, pproductScrollPane, iproductScrollPane, inventoryScrollPane, readScrollPane, productnumberScrollPane;
  private JLabel name, category, price, info, inventory, number;
  private String electronic, mechanic, social, services, error = "non";
  private boolean test1, test2, test3, test4, test5, check = false;
  private JMenu filemenu, helpmenu;
  private JMenuItem exit, save, open, infomenu;
  // Ende Attribute
  
  public Product_Control(Locale StartLanguage) {
    this.locale = StartLanguage;
    this.bundle = ResourceBundle.getBundle("Bundle_" + locale, locale);
    this.setTitle(bundle.getString("title"));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    Container cp = getContentPane();
    cp.setLayout(null);
    
    // Initilizing JMenu
    JMenuBar mb =  new JMenuBar();
    JSeparator sep = new JSeparator();
    filemenu = new JMenu(bundle.getString("filemenu"));
    open = new JMenuItem(bundle.getString("open"));
    save = new JMenuItem(bundle.getString("save"));
    exit = new JMenuItem(bundle.getString("exit"));
    filemenu.add(open);
    filemenu.add(save);
    filemenu.add(sep);
    filemenu.add(exit);
    
    helpmenu = new JMenu(bundle.getString("helpmenu"));
    infomenu = new JMenuItem("Info");
    helpmenu.add(infomenu);
    
    mb.add(filemenu);
    mb.add(helpmenu);
    this.setJMenuBar(mb);
    open.addActionListener(this);
    save.addActionListener(this);
    exit.addActionListener(this);
    infomenu.addActionListener(this);
    
    // Initilizing JTextAreas and JScrollPanes
    nproduct = new JTextArea();
    nproductScrollPane = new JScrollPane(nproduct);
    nproductScrollPane.setBounds(200, 27, 168, 44);
    cp.add(nproductScrollPane);
    
    String[] categoryList = {bundle.getString("select"), bundle.getString("el"), bundle.getString("me"), bundle.getString("so"), bundle.getString("se")};
    c = new JComboBox(categoryList);
    c.setBounds(200, 80, 168, 44);
    cp.add(c);
    
    productnumber = new JTextArea();
    productnumberScrollPane = new JScrollPane(productnumber);
    productnumberScrollPane.setBounds(200, 137, 168, 44);
    cp.add(productnumberScrollPane);
    
    pproduct = new JTextArea();
    pproductScrollPane = new JScrollPane(pproduct);
    pproductScrollPane.setBounds(200, 194, 168, 44);
    cp.add(pproductScrollPane);
    
    inventoryproduct = new JTextArea();
    inventoryScrollPane = new JScrollPane(inventoryproduct);
    inventoryScrollPane.setBounds(200, 258, 168, 44);
    cp.add(inventoryScrollPane);
    
    iproduct = new JTextArea();
    iproductScrollPane = new JScrollPane(iproduct);
    iproductScrollPane.setBounds(200, 340, 168, 44);
    cp.add(iproductScrollPane);
    
    read = new JTextArea();
    read.setEditable(false);
    readScrollPane = new JScrollPane(read);
    readScrollPane.setBounds(680, 27, 600, 600);
    cp.add(readScrollPane);
    
    // Initilizing JLabels
    name = new JLabel(bundle.getString("name"));
    name.setBounds(16, 34, 150, 20);
    cp.add(name);
    
    category = new JLabel(bundle.getString("category"));
    category.setBounds(16, 90, 150, 20);
    cp.add(category);
    
    number = new JLabel(bundle.getString("number"));
    number.setBounds(16, 150, 150, 20);
    cp.add(number);
    
    inventory = new JLabel(bundle.getString("inventory"));
    inventory.setBounds(16, 271, 150, 20);
    cp.add(inventory);
    
    price = new JLabel(bundle.getString("price"));
    price.setBounds(16, 211, 150, 20);
    cp.add(price);
    
    info = new JLabel(bundle.getString("info"));
    info.setBounds(16, 350, 150, 20);
    cp.add(info);
    
    // JButtons
    close = new JButton(bundle.getString("close"));
    close.setBounds(250, 400, 200, 50);
    cp.add(close);
    
    add = new JButton(bundle.getString("add"));
    add.setBounds(420, 100, 200, 50);
    cp.add(add);
    
    URL iconURL1 = getClass().getResource("Open.png");
    // iconURL is null when not found
    ImageIcon icon1 = new ImageIcon(iconURL1);
    show = new JButton(icon1);
    show.setBounds(420, 200, 200, 50);
    cp.add(show);
    
    alldelete = new JButton(bundle.getString("dall"));
    alldelete.setBounds(420, 300, 200, 50);
    this.add(alldelete);
    
    // Initilizing JRadioButton
    donoff = new JRadioButton(bundle.getString("doff"));
    donoff.setBounds(420, 50, 200, 20);
    cp.add(donoff);
    
    // Initilizing ActionListener for JRadioButton
    donoff.addActionListener(d -> {
      
      if (check == false) { // If the security variable check is false, the caption on.
        donoff.setText(bundle.getString("don"));
        nproduct.setText(bundle.getString("name"));
        test1 = true; // The variables test ... are further safety variables
        test2 = true;
        test3 = true;
        test4 = true;
        test5 = true;
        productnumber.setText(bundle.getString("number"));
        pproduct.setText(bundle.getString("price"));
        inventoryproduct.setText(bundle.getString("inventory"));
        iproduct.setText(bundle.getString("info"));
        check = true;
      } else if (check == true) { // If the security variable check is true, the caption is off
          donoff.setText(bundle.getString("doff"));
          nproduct.setText(" ");
          test1 = false;
          test2 = false;
          test3 = false;
          test4 = false;
          test5 = false;
          productnumber.setText(" ");
          pproduct.setText(" ");
          inventoryproduct.setText(" ");
          iproduct.setText(" ");
          check = false;
        } else {
          ErrorDialog error = new ErrorDialog();
          error.setLabelError();
        }
      
    });
    
    // ItemListener
    c.addItemListener(ia -> {
      
      if (c.getSelectedItem().equals(bundle.getString("select"))) {
        if (test1 == true) { // If the security variable is true, the caption is written in to file
          error = bundle.getString("error1");
          electronic = "";
          mechanic = "";
          social = "";
          services = "";
        } // end of if
        
        if (test1 == false) { // If the security variable is false, the caption is not written in to file
          error = bundle.getString("error2");
          electronic = "";
          mechanic = "";
          social = "";
          services = "";
        } // end of if
      }
      
      if (c.getSelectedItem().equals(bundle.getString("el"))) {
        if (test2 == true) {
          error = "";
          electronic = bundle.getString("cel");
          mechanic = "";
          social = "";
          services = "";
        } // end of if
        
        if (test2 == false) {
          error = "";
          electronic = bundle.getString("el");
          mechanic = "";
          social = "";
          services = "";
        } // end of if
      }
      
      if (c.getSelectedItem().equals(bundle.getString("me"))) {
        if (test3 == true) {
          error = "";
          electronic = "";
          mechanic = bundle.getString("cme");
          social = "";
          services = "";
        } // end of if
        
        if (test3 == false) {
          error = "";
          electronic = "";
          mechanic = bundle.getString("me");
          social = "";
          services = "";
        } // end of if
      }
      
      if (c.getSelectedItem().equals(bundle.getString("so"))) {
        if (test4 == true) {
          error = "";
          electronic = "";
          mechanic = "";
          social = bundle.getString("cso");
          services = "";
        } // end of if
        
        if (test4 == false) {
          error = "";
          electronic = "";
          mechanic = "";
          social = bundle.getString("so");
          services = "";
        } // end of if
      }
      
      if (c.getSelectedItem().equals(bundle.getString("se"))) {
        if (test5 == true) {
          error = "";
          electronic = "";
          mechanic = "";
          social = "";
          services = bundle.getString("cse");
        } // end of if
        
        if (test5 == false) {
          error = "";
          electronic = "";
          mechanic = "";
          social = "";
          services = bundle.getString("se");
        } // end of if
      }
    });
    // ActionListeners
    close.addActionListener(a -> {
      System.exit(0);
    });
    
    add.addActionListener(c -> {
      JFileChooser fc = new JFileChooser(); // Declaration FileChooser
      filter = new FileNameExtensionFilter(bundle.getString("file"), "txt"); // Initializing filenamefilter
      fc.addChoosableFileFilter(filter);
      int i = fc.showSaveDialog(null); // show Save Dialog
      if (i == JFileChooser.APPROVE_OPTION) {
        try {
          boolean neu = false;
          File file;
          file = fc.getSelectedFile();
          if (!file.exists()) { // If File not existing it will be created new and set neu = true
            file.createNewFile();
            neu = true;
          }
          BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
          if (!neu) { // If File not new it will be written Paragraphs to file
            bw.write("\n");
            bw.write("\n");
          } // end of if
          bw.write("");
          bw.write(nproduct.getText()); // with command bw.write it will be write datas of TextAreas
          bw.write("\n");
          if (error == bundle.getString("error2")) {
            bw.write(error);
          } else if (error == bundle.getString("error1")) {
              bw.write(error);
            }
          
          if (electronic == bundle.getString("el")) {
            bw.write(electronic);
          } else if (electronic == bundle.getString("cel")) {
              bw.write(electronic);
            }
          
          if (mechanic == bundle.getString("me")) {
            bw.write(mechanic);
          } else if (mechanic == bundle.getString("cme")) {
              bw.write(mechanic);
            }
          
          if (social == bundle.getString("so")) {
            bw.write(social);
          } else if (social == bundle.getString("cso")) {
              bw.write(social);
            }
          
          if (services == bundle.getString("se")) {
            bw.write(services);
          } else if (services == bundle.getString("cse")) {
              bw.write(services);
            }
          bw.write("\n");
          bw.write(productnumber.getText());
          bw.write("\n");
          bw.write(pproduct.getText());
          bw.write("\n");
          bw.write(inventoryproduct.getText());
          bw.write("\n");
          bw.write(iproduct.getText());
          bw.flush();
          if (i == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            String filepath = f.getPath();
            try {
              BufferedReader br = new BufferedReader(new FileReader(filepath));
              String s1 = "", s2 = "";
              while ((s1 = br.readLine()) != null) { // The system checks which lines have been written and then moves on to the next line.
                s2 += s1 + "\n";
              }
              read.setText(s2);
              br.close();
            } catch (Exception e) { //
              // e.printStackTrace();
              ErrorDialog error = new ErrorDialog();
              error.setOpenError(); // If an error occurs, an error dialog is displayed
            }
          }
        } catch (IOException e) {
          // e.printStackTrace();
          ErrorDialog error = new ErrorDialog();
          error.setWriteError();
        }
      }
      /*ErrorDialog sucessfully = new ErrorDialog();
      sucessfully.setSucessfully();*/
    });
    
    show.addActionListener(d -> {
      filter = new FileNameExtensionFilter(bundle.getString("file"), "txt");
      JFileChooser fc = new JFileChooser();
      fc.addChoosableFileFilter(filter);
      fc.showOpenDialog(this);
      
      File f = fc.getSelectedFile();
      String filepath = f.getPath();
      try { // Each line in the file is read individually and written to the TextArea one after the other.
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        String s1 = "", s2 = "";
        while ((s1 = br.readLine()) != null) {
          s2 += s1 + "\n";
        }
        read.setText(s2);
        br.close();
      } catch (Exception e) {
        // e.printStackTrace();
        ErrorDialog error = new ErrorDialog();
        error.setOpenError();
      }
      
    });
    
    alldelete.addActionListener(e -> {
      try {
        File file;
        JFileChooser fc = new JFileChooser();
        fc.showSaveDialog(null);
        file = fc.getSelectedFile();
        File f = fc.getSelectedFile();
        String filepath = f.getPath();
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(""); // The whole file is overwritten with leeward characters
        bw.flush();
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        String s1 = "", s2 = "";
        while ((s1 = br.readLine()) != null) {
          s2 += s1 + "\n";
        }
        read.setText(s2);
        br.close();
        
      } catch (Exception ex) {
        // e.printStackTrace();
        /*ErrorDialog error = new ErrorDialog();
        error.setWriteError();*/
      }
    });
    
    setVisible(true);
  }
    // Anfang Komponenten
    // Ende Komponenten
  // Anfang Methoden


  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == exit)
      System.exit(0);
    if (e.getSource() == save) {
      JFileChooser fc = new JFileChooser();
      filter = new FileNameExtensionFilter(bundle.getString("file"), "txt");
      fc.addChoosableFileFilter(filter);
      int i = fc.showSaveDialog(null);
      if (i == JFileChooser.APPROVE_OPTION) {
        try {
          boolean neu = false;
          File file;
          file = fc.getSelectedFile();
          if (!file.exists()) {
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
          if (error == bundle.getString("error2")) {
            bw.write(error);
          } else if (error == bundle.getString("error1")) {
              bw.write(error);
            }
          
          if (electronic == bundle.getString("el")) {
            bw.write(electronic);
          } else if (electronic == bundle.getString("cel")) {
              bw.write(electronic);
            }
          
          if (mechanic == bundle.getString("me")) {
            bw.write(mechanic);
          } else if (mechanic == bundle.getString("cme")) {
              bw.write(mechanic);
            }
          
          if (social == bundle.getString("so")) {
            bw.write(social);
          } else if (social == bundle.getString("cso")) {
              bw.write(social);
            }
          
          if (services == bundle.getString("se")) {
            bw.write(services);
          } else if (services == bundle.getString("cse")) {
              bw.write(services);
            }
          bw.write("\n");
          bw.write(productnumber.getText());
          bw.write("\n");
          bw.write(pproduct.getText());
          bw.write("\n");
          bw.write(inventoryproduct.getText());
          bw.write("\n");
          bw.write(iproduct.getText());
          bw.flush();
          if (i == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            String filepath = f.getPath();
            try {
              BufferedReader br = new BufferedReader(new FileReader(filepath));
              String s1 = "", s2 = "";
              while ((s1 = br.readLine()) != null) {
                s2 += s1 + "\n";
              }
              read.setText(s2);
              br.close();
            } catch (Exception ex) {
              // e.printStackTrace();
              ErrorDialog error = new ErrorDialog();
              error.setOpenError();
            }
          }
        } catch (IOException ex) {
          // e.printStackTrace();
          ErrorDialog error = new ErrorDialog();
          error.setWriteError();
        }
      }
    }
    if (e.getSource() == open) {
      filter = new FileNameExtensionFilter(bundle.getString("file"), "txt");
      JFileChooser fc = new JFileChooser();
      fc.addChoosableFileFilter(filter);
      int i = fc.showOpenDialog(this);
      
      if (i == JFileChooser.APPROVE_OPTION) {
        File f = fc.getSelectedFile();
        String filepath = f.getPath();
        try {
          BufferedReader br = new BufferedReader(new FileReader(filepath));
          String s1 = "", s2 = "";
          while ((s1 = br.readLine()) != null) {
            s2 += s1 + "\n";
          }
          read.setText(s2);
          br.close();
        } catch (Exception ex) {
          // e.printStackTrace();
          ErrorDialog error = new ErrorDialog();
          error.setOpenError();
        }
      }
    }
    
    if (e.getSource() == infomenu) {
      String aboutText = bundle.getString("about");
      String username = System.getProperty("user.name");
      String osversion = System.getProperty("os.name");
      String jdkversion = System.getProperty("java.version");
      String processor = String.valueOf(Runtime.getRuntime().availableProcessors());
      aboutText = aboutText.replace("$USER_NAME$", username);
      aboutText = aboutText.replace("$OS_NAME$", osversion);
      aboutText = aboutText.replace("$JDK_VERSION$", jdkversion);
      aboutText = aboutText.replace("$PROCESSOR_CORES$", processor);
      JOptionPane.showMessageDialog(Product_Control.this, aboutText, bundle.getString("abouttitle"), JOptionPane.INFORMATION_MESSAGE);
    }
  }

  public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch(Exception ex) {
      UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
    }
    new Splash().showSplash();
    try {
      new Product_Control(Locale.getDefault());
    } catch(Exception ex) {
      new Product_Control(Locale.ENGLISH);
    }
  }
}