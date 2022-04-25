// Imports
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.URL;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Product_Control extends JFrame implements ActionListener {

  private FileFilter filter;
  private JButton close, back, add, show, alldelete, onedelete, simulation;
  private JRadioButton donoff;
  private JTextArea nproduct, pproduct, iproduct, inventoryproduct, read, productnumber;
  private JComboBox c;
  private JScrollPane nproductScrollPane, pproductScrollPane, iproductScrollPane, inventoryScrollPane, readScrollPane, productnumberScrollPane;
  private JLabel name, category, price, info, inventory, number;
  private String electronic, mechanic, social, services, error = "non";
  private boolean test1, test2, test3, test4, test5, check = false;
  private JMenu filemenu, helpmenu;
  private JMenuItem exit, save, open, infomenu, license;

  public Product_Control() {
    super("Easy to Manage - Add Product");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    setVisible(true);
    Container cp = getContentPane();
    cp.setLayout(null);

    // JMenu
    JMenuBar mb =  new JMenuBar();
    JSeparator sep = new JSeparator();
    filemenu = new JMenu("File");
    open = new JMenuItem("Open");
    save = new JMenuItem("Save");
    exit = new JMenuItem("Exit");
    filemenu.add(open);
    filemenu.add(save);
    filemenu.add(sep);
    filemenu.add(exit);

    helpmenu = new JMenu("Help");
    infomenu = new JMenuItem("Info");
    license = new JMenuItem("License");
    helpmenu.add(license);
    helpmenu.add(infomenu);

    mb.add(filemenu);
    mb.add(helpmenu);
    this.setJMenuBar(mb);
    open.addActionListener(this);
    save.addActionListener(this);
    exit.addActionListener(this);
    infomenu.addActionListener(this);
    license.addActionListener(this);

    // JTextAreas and JScrollPanes
    nproduct = new JTextArea();
    nproductScrollPane = new JScrollPane(nproduct);
    nproductScrollPane.setBounds(200, 27, 168, 44);
    cp.add(nproductScrollPane);

    String[] categoryList = {"Please select a category", "electronic", "mechanic", "social", "services"};
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

    // JLabels
    name = new JLabel("Name of Product:");
    name.setBounds(16, 34, 150, 20);
    cp.add(name);

    category = new JLabel("Category of Product:");
    category.setBounds(16, 90, 150, 20);
    cp.add(category);

    number = new JLabel("Description of Product: ");
    number.setBounds(16, 271, 150, 20);
    cp.add(number);

    inventory = new JLabel("Inventory of Product:");
    inventory.setBounds(16, 150, 150, 20);
    cp.add(inventory);

    price = new JLabel("Price of Product: ");
    price.setBounds(16, 211, 150, 20);
    cp.add(price);

    info = new JLabel("Description of Product:");
    info.setBounds(16, 350, 150, 20);
    cp.add(info);

    // JButtons
    close = new JButton("Close");
    close.setBounds(200, 600, 200, 50);
    cp.add(close);

    back = new JButton("Back");
    back.setBounds(450, 600, 200, 50);
    cp.add(back);

    add = new JButton("Add");
    add.setBounds(420, 100, 200, 50);
    cp.add(add);

    URL iconURL1 = getClass().getResource("Open.png");
    // iconURL is null when not found
    ImageIcon icon1 = new ImageIcon(iconURL1);
    show = new JButton(icon1);
    show.setBounds(420, 200, 200, 50);
    cp.add(show);

    simulation = new JButton("Simulation");
    simulation.setBounds(420, 500, 200, 50);
    this.add(simulation);

    alldelete = new JButton("Delete all Products");
    alldelete.setBounds(420, 300, 200, 50);
    this.add(alldelete);

    onedelete = new JButton("Delete one Product");
    onedelete.setBounds(420, 400, 200, 50);
    this.add(onedelete);

    // JRadioButton
    donoff = new JRadioButton("Label off");
    donoff.setBounds(420, 50, 100, 20);
    cp.add(donoff);

    // ActionListener for JRadioButton 
    donoff.addActionListener(d -> {
      ;
      if (check == false) {
        donoff.setText("Label on");
        nproduct.setText("Name: ");
        test1 = true;
        test2 = true;
        test3 = true;
        test4 = true;
        test5 = true;
        productnumber.setText("Productnumber: ");
        pproduct.setText("Price: ");
        inventoryproduct.setText("Inventory of Product: ");
        iproduct.setText("Description: ");
        check = true;
      } else if (check == true) {
        donoff.setText("Label off");
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
      ;
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
      new Gui();
    });

    add.addActionListener(c -> {
      JFileChooser fc = new JFileChooser();
      filter = new FileNameExtensionFilter("Textdatei", "txt");
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
            } catch (Exception e) {
              // e.printStackTrace();
              ErrorDialog error = new ErrorDialog();
              error.setOpenError();
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
      filter = new FileNameExtensionFilter("Textdatei", "txt");
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
        } catch (Exception e) {
          // e.printStackTrace();
          ErrorDialog error = new ErrorDialog();
          error.setOpenError();
        }
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
        bw.write("");
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

    simulation.addActionListener(e -> {
      new Simulation();
    });
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == exit)
      System.exit(0);
    if (e.getSource() == save) {
      JFileChooser fc = new JFileChooser();
      filter = new FileNameExtensionFilter("Textdatei", "txt");
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
      filter = new FileNameExtensionFilter("Textdatei", "txt");
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
      final String aboutText= "<html><big>Welcome to ,,Easy to Manage''</big><hr><hr> <p align=right>Developed by Sebastian, Ben and Fynn!<hr><p align=left>The Source Code was compiled with JDK 17.0.2.<br><br><strong>Thanks for using Easy to Manage</strong><br>We hope that you have had a good experience with Easy to Manage<p align=center><hr><a href=\"https://github.com/fantastic-octo-garbanzo\">https://github.com/fantastic-octo-garbanzo</a><hr><hr><html>";
      JOptionPane.showMessageDialog(Product_Control.this, aboutText, "About", JOptionPane.INFORMATION_MESSAGE);
    }

    if(e.getSource() == license) {

    }
  }
}