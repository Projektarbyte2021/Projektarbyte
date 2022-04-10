// Imports
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.net.URL;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Add_Product extends JFrame {

  private FileFilter filter;
  private JButton close, back, add, show, alldelete, onedelete;
  private JRadioButton donoff;
  private JTextArea nproduct;
  private JTextArea pproduct;
  private JTextArea iproduct;
  private JTextArea inventoryproduct;
  private static JTextArea read;
  private JComboBox c;
  private JScrollPane nproductScrollPane, pproductScrollPane, iproductScrollPane, inventoryScrollPane, readScrollPane;
  private JLabel name, category, price, info, inventory;
  private String zv1, zv2, zv3, zv4, zv5, electronic, mechanic, social, services, error = "non";
  private boolean test1, test2, test3, test4, test5, check = false;
  private Add_Product[] capacity;
  private String mod_deleted;

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

    String[] categoryList = {"Please select a category", "electronic", "mechanic", "social", "services"};
    c = new JComboBox(categoryList);
    c.setBounds(150, 80, 168, 44);
    cp.add(c);

    pproduct = new JTextArea();
    pproductScrollPane = new JScrollPane(pproduct);
    pproductScrollPane.setBounds(150, 137, 168, 44);
    cp.add(pproductScrollPane);

    inventoryproduct = new JTextArea();
    inventoryScrollPane = new JScrollPane(inventoryproduct);
    inventoryScrollPane.setBounds(150, 194, 168, 44);
    cp.add(inventoryScrollPane);

    iproduct = new JTextArea();
    iproductScrollPane = new JScrollPane(iproduct);
    iproductScrollPane.setBounds(150, 258, 168, 44);
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

    price = new JLabel("Price of Product:");
    price.setBounds(16, 150, 150, 20);
    cp.add(price);

    inventory = new JLabel("Inventory of Product: ");
    inventory.setBounds(16, 211, 150, 20);
    cp.add(inventory);

    info = new JLabel("Description of Product: ");
    info.setBounds(16, 271, 150, 20);
    cp.add(info);

    // JButtons
    close = new JButton("Close");
    close.setBounds(200, 500, 200, 50);
    cp.add(close);

    back = new JButton("Back");
    back.setBounds(450, 500, 200, 50);
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
    // ActionListener for JButton
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
          this.zv1 = nproduct.getText();
          bw.write("\n");
          if (error == "non") {
            bw.write(error);
            this.zv2 = error;
          } else if (error == "Category: non") {
            bw.write(error);
            this.zv2 = error;
          }

          if (electronic == "electronic") {
            bw.write(electronic);
            this.zv2 = electronic;
          } else if (electronic == "Category: electronic") {
            bw.write(electronic);
            this.zv2 = electronic;
          }

          if (mechanic == "mechanic") {
            bw.write(mechanic);
            this.zv2 = mechanic;
          } else if (mechanic == "Category: mechanic") {
            bw.write(mechanic);
            this.zv2 = mechanic;
          }

          if (social == "social") {
            bw.write(social);
            this.zv2 = mechanic;
          } else if (social == "Category: social") {
            bw.write(social);
            this.zv2 = mechanic;
          }

          if (services == "services") {
            bw.write(services);
            this.zv2 = services;
          } else if (services == "Category: services") {
            bw.write(services);
            this.zv2 = services;
          }
          bw.write("\n");
          bw.write(pproduct.getText());
          this.zv3 = pproduct.getText();
          bw.write("\n");
          bw.write(inventoryproduct.getText());
          this.zv4 = inventoryproduct.getText();
          bw.write("\n");
          bw.write(iproduct.getText());
          this.zv5 = iproduct.getText();
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

    onedelete.addActionListener(d -> {
      Add_Product[] zwischenvariabel = null;
      int x = JOptionPane.showConfirmDialog(null, "Moechten Sie ein Produkt loeschen?");
      if (x == 0) {
        String input = JOptionPane.showInputDialog("Geben Sie die Kategory ein, die Sie loeschen moechten:");
        try {
          File file;
          JFileChooser fc = new JFileChooser();
          fc.showSaveDialog(null);
          file = fc.getSelectedFile();
          File f = fc.getSelectedFile();
          String filepath = f.getPath();
          boolean neu = true;
          boolean deleted = false;
          if (file.exists()) {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));
            for (Add_Product element : capacity) {
              if (!(mod_deleted.equals(element.getCategory()))) {
                if (!neu) {
                  bw.write("\n");
                } else {
                  neu = false;
                }
              } else {
                deleted = true;
              }
            }
            bw.close();
          } else {
            ErrorDialog error = new ErrorDialog();
            error.setWrongFile();
          }
          if (deleted) {
            ErrorDialog error = new ErrorDialog();
            error.setProductDelete();
          } else {
            ErrorDialog error = new ErrorDialog();
            error.setWrongItemNumber();
          }
          BufferedReader br = new BufferedReader(new FileReader(filepath));
          String s1 = "", s2 = "";
          while ((s1 = br.readLine()) != null) {
            s2 += s1 + "\n";
          }
          read.setText(s2);
          br.close();
        } catch (IOException ioAusnahme) {
          ErrorDialog error = new ErrorDialog();
          error.setOpenError();
        }
      }
    });
  }

  // Methods
  public String getName() {
    return zv1;
  }

  public String getCategory() {
    return zv2;
  }

  public String getPrice() {
    return zv3;
  }

  public String getInventory() {
    return zv4;
  }

  public String getInformation() {
    return zv5;
  }
}