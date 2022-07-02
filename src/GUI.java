// Imports
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.*;
import javax.swing.*;

public class GUI extends JFrame implements ActionListener {
  public JLabel name, category, price, info, inventory, number;
  public Locale locale;
  public static ResourceBundle bundle;
  public JButton close, add, show, alldelete;
  public JRadioButton donoff;
  public JTextArea nproduct, pproduct, iproduct, inventoryproduct, read, productnumber;
  public JComboBox c;
  public JScrollPane nproductScrollPane, pproductScrollPane, iproductScrollPane, inventoryScrollPane, readScrollPane, productnumberScrollPane;
  public String electronic, mechanic, social, services, error = "non";
  public boolean test1, test2, test3, test4, test5, check = false;
  public JMenu filemenu, helpmenu;
  public JMenuItem exit, save, open, infomenu;
  public JMenuBar mb;
  public JFileChooser fc;
  public GUI(Locale StartLanguage) {
    // Initialisierung
    close = new JButton();
    add = new JButton();
    show = new JButton();
    alldelete = new JButton();
    donoff = new JRadioButton();
    nproduct = new JTextArea();
    pproduct = new JTextArea();
    iproduct = new JTextArea();
    inventoryproduct = new JTextArea();
    read = new JTextArea();
    fc = new JFileChooser();
    productnumber = new JTextArea();
    nproductScrollPane = new JScrollPane(nproduct);
    pproductScrollPane = new JScrollPane(pproduct);
    iproductScrollPane = new JScrollPane(iproduct);
    inventoryScrollPane = new JScrollPane(inventoryproduct);
    productnumberScrollPane = new JScrollPane(productnumber);
    readScrollPane = new JScrollPane(read);
    name = new JLabel();
    category = new JLabel();
    price = new JLabel();
    info = new JLabel();
    inventory = new JLabel();
    number = new JLabel();
    mb =  new JMenuBar();
    // Ende Initialisierung
    this.locale = StartLanguage;
    this.bundle = ResourceBundle.getBundle("Bundle_" + locale, locale); // Sucht nach Bundles die mit Bundle_ und wählt als Locale die Startsprache aus
    setTitle(bundle.getString("title")); // Setzt den Titel des Fensters und sucht im Bundle den Schlüssel 'title' und verwendet den dahinterstehenden Text 
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // aktiviert das Schließen über das Kreuz
    setExtendedState(JFrame.MAXIMIZED_BOTH); // Öffnet Fenster im Vollbildmodus
    Container cp = getContentPane(); // Erstellt ein Container auf dem alle Elemente angezeigt werden 
    cp.setLayout(null); // Setzt Container auf Null
    
    JSeparator sep = new JSeparator(); // Erstellt ein Trenner
    // Initilizing JMenu
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
    // ActionListener zu JMenu hinzufügen
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
      
      if (check == false) { // Wenn check false ist ist der Radiobutton deaktiviert
        donoff.setText(bundle.getString("don")); 
        nproduct.setText(bundle.getString("name")); // JTextArea bekommt neuen Wert
        test1 = true; // test Variebalen werden auf True gesetzt
        test2 = true;
        test3 = true;
        test4 = true;
        test5 = true;
        productnumber.setText(bundle.getString("number"));
        pproduct.setText(bundle.getString("price"));
        inventoryproduct.setText(bundle.getString("inventory"));
        iproduct.setText(bundle.getString("info"));
        check = true; // Check wird auf True gesetzt, da Beschriftung aktiviert
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
          // Wenn etwas nicht Funktioniert hat erscheint ein Fehlerdialog
          ErrorDialog error = new ErrorDialog();
          error.setLabelError();
        }
      
    });
    
    // ItemListener
    c.addItemListener(ia -> {
      
      if (c.getSelectedItem().equals(bundle.getString("select"))) {
        if (test1 == true) { // Wenn Test Variable auf true dann werden die Beschriftungen in die Datei geschrieben
          error = bundle.getString("error1");
          electronic = "";
          mechanic = "";
          social = "";
          services = "";
        } // end of if
        
        if (test1 == false) { // Wenn Test Variable false ist wird keine Beschriftung in die Datei geschrieben
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
      System.exit(0); // Schließt das Fenster
    });
    
    add.addActionListener(c -> {
      String name = nproduct.getText(); // Text wird aus JTextArea ausgelesen und in Variable gespeichert, die dann mit OOP in die Klasse OOP versendet wird
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
      String aboutText = bundle.getString("about"); // Setzt Text
      String username = System.getProperty("user.name"); // Zeigt den Benutzername an
      String osversion = System.getProperty("os.name"); // Zeigt das Betriebssystem an
      String jdkversion = System.getProperty("java.version"); // Zeigt die Java-Version an
      String processor = String.valueOf(Runtime.getRuntime().availableProcessors()); // Zeigt wie viele Prozessorkerne vorhanden sind
      aboutText = aboutText.replace("$USER_NAME$", username); // Erstzt den Text im Bundle
      aboutText = aboutText.replace("$OS_NAME$", osversion); // Erstzt den Text im Bundle
      aboutText = aboutText.replace("$JDK_VERSION$", jdkversion); // Erstzt den Text im Bundle
      aboutText = aboutText.replace("$PROCESSOR_CORES$", processor); // Erstzt den Text im Bundle
      JOptionPane.showMessageDialog(GUI.this, aboutText, bundle.getString("abouttitle"), JOptionPane.INFORMATION_MESSAGE); // Erstellt Dialog und setzt den Text
    }
  }

  public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // Benutzt Systemthema
    } catch(Exception ex) {
      UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel"); // Falls Systemthema nicht ermittelt werden kann wird Standard Java Thema verwendet
    }
    new Splash().showSplash(); // Stellt Verbindung zu Splashscrenn her
    try {
      new GUI(Locale.getDefault()); // Verwendet Systemsprache
    } catch(Exception ex) {
      new GUI(Locale.ENGLISH); // Kann Systemsprache nicht ermittelt werden wird Englisch verwendet
    }
  }
  
}