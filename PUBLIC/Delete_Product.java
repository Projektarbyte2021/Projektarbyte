// Imports
import javax.swing.*;
import java.io.*;

public class Delete_Product extends JFrame {
  
    private JButton close, back, alldelete, onedelete;
    public JComboBox menu;
    public String[] menupoints = {"Delete Produkt","Menu","Add Product"};
  
    public Delete_Product() {
    super("Verwaltungsprogramm - Delete Product");
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(null);
    this.setVisible(true);
    
    // JButtons
    close = new JButton("Close");
    close.setBounds(200, 500, 200, 50);
    this.add(close);
    
    back = new JButton("Back");
    back.setBounds(450, 500, 200, 50);
    this.add(back);
    
    alldelete = new JButton("Delete all Products");
    alldelete.setBounds(950, 500, 200, 50);
    this.add(alldelete);
    
    onedelete = new JButton("Delete one Product");
    onedelete.setBounds(700, 500, 200, 50);
    this.add(onedelete);
    
    menu = new JComboBox(menupoints);
    menu.setBounds(10, 10, 100, 50);
    this.add(menu);
    
    // add Actionlisteners
    menu.addActionListener(e -> {;
      if (menu.getSelectedIndex()==1) {
        this.dispose();
        new Gui();
      } 
      if (menu.getSelectedIndex()==2) {
        this.dispose();
        new Add_Product();
      } 
    });
    
    close.addActionListener(a -> {
      System.exit(0);
    });
    
    back.addActionListener(b -> {
      this.dispose();
      new Gui();
    });

    alldelete.addActionListener(c -> {
      try {
          File file;
            JFileChooser fc = new JFileChooser();
            fc.showSaveDialog(null);
            file = fc.getSelectedFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write("");
            bw.flush();
      } catch(Exception e) {
        // e.printStackTrace();
        ErrorDialog error = new ErrorDialog();
        error.setWriteError();
      } 
    });

    onedelete.addActionListener(d -> {;
    Add_Product[] zwischenvariabel = null;
      int x = JOptionPane.showConfirmDialog(null, "M?chten Sie ein Produkt loeschen?");
      if (x == 0){
        String input = JOptionPane.showInputDialog("Geben Sie die Artikelnummer ein, das Sie loeschen moechten:");
        delete(zwischenvariabel, input);
      } 
    });
    
  } 
  public static void delete (Add_Product[] capacity, String mod_deleted){
    try{
      File file;
      JFileChooser fc = new JFileChooser();
      fc.showSaveDialog(null);
      file = fc.getSelectedFile();
      boolean neu = true;
      boolean deleted = false;
      if(file.exists()){
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));
        for (Add_Product element : capacity){
          if (!(mod_deleted.equals(element.getCategory()))){
            if(!neu){
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
      if (deleted){
        ErrorDialog error = new ErrorDialog();
        error.setProductDelete();
      } else{
        ErrorDialog error = new ErrorDialog();
        error.setWrongItemNumber();
      }
    } catch(IOException ioAusnahme){
      ErrorDialog error = new ErrorDialog();
      error.setOpenError();
    }
  }

} 
