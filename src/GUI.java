// Imports
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUI extends Variables implements ActionListener {
  
  public GUI(Locale StartLanguage) {
    this.locale = StartLanguage;
    this.bundle = ResourceBundle.getBundle("Bundle_" + locale, locale);
    setTitle(bundle.getString("title"));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    Container cp = getContentPane();
    cp.setLayout(null);
    
    // Initilizing JMenu
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
    nproductScrollPane = new JScrollPane(nproduct);
    nproductScrollPane.setBounds(200, 27, 168, 44);
    this.add(nproductScrollPane);
    
    String[] categoryList = {bundle.getString("select"), bundle.getString("el"), bundle.getString("me"), bundle.getString("so"), bundle.getString("se")};
    c = new JComboBox(categoryList);
    c.setBounds(200, 80, 168, 44);
    this.add(c);
    
    productnumberScrollPane.setBounds(200, 137, 168, 44);
    this.add(productnumberScrollPane);
    
    pproductScrollPane.setBounds(200, 194, 168, 44);
    this.add(pproductScrollPane);
    
    inventoryScrollPane.setBounds(200, 258, 168, 44);
    this.add(inventoryScrollPane);
    
    iproductScrollPane.setBounds(200, 340, 168, 44);
    this.add(iproductScrollPane);
    
    read.setEditable(false);
    readScrollPane.setBounds(680, 27, 600, 600);
    this.add(readScrollPane);
    
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
    cp.add(alldelete);
    
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
      String name = nproduct.getText();
      String number = productnumber.getText();
      String price = pproduct.getText();
      String inventory = inventoryproduct.getText();
      String information = iproduct.getText();
      Control obj = new Control();
      obj.Transfer1(error, electronic, mechanic, social, services, name, number, price, inventory, information);
      obj.Add_Product();
      read.setText(obj.Back());
    });
    
    show.addActionListener(d -> {
      Control obj = new Control();
      obj.ShowProduct();
      read.setText(obj.Back());
    });
    
    alldelete.addActionListener(e -> {
      Control obj = new Control();
      obj.All_Delete();
      read.setText(obj.Back());
    });
    
    setVisible(true);
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == exit)
      System.exit(0);
    if (e.getSource() == save) {
      String name = nproduct.getText();
      String number = productnumber.getText();
      String price = pproduct.getText();
      String inventory = inventoryproduct.getText();
      String information = iproduct.getText();
      Control obj = new Control();
      obj.Transfer1(error, electronic, mechanic, social, services, name, number, price, inventory, information);
      obj.Add_Product();
      read.setText(obj.Back());
      }

    if (e.getSource() == open) {
      Control obj = new Control();
      obj.ShowProduct();
      read.setText(obj.Back());
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
      JOptionPane.showMessageDialog(GUI.this, aboutText, bundle.getString("abouttitle"), JOptionPane.INFORMATION_MESSAGE);
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
      new GUI(Locale.getDefault());
    } catch(Exception ex) {
      new GUI(Locale.ENGLISH);
    }
  }
  
}