import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Control extends Variables{

    String error, electronic, mechanic, social ,services, name, number, price, inventory, information, s3;

    public void Transfer1(String error, String electronic, String mechanic, String social, String services, String name, String number, String price, String inventory, String information) {
        this.error = error;
        this.electronic = electronic;
        this.mechanic = mechanic;
        this.social = social;
        this.services = services;
        this.name = name;
        this.number = number;
        this.price = price;
        this.inventory = inventory;
        this.information = information;
    }

    public void Add_Product() {
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
          bw.write(name); // with command bw.write it will be write datas of TextAreas
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
          bw.write(number);
          bw.write("\n");
          bw.write(price);
          bw.write("\n");
          bw.write(inventory);
          bw.write("\n");
          bw.write(information);
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
              s3 = s2;
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
    
    }

    public void ShowProduct() {
        filter = new FileNameExtensionFilter(bundle.getString("file"), "txt");
      fc.addChoosableFileFilter(filter);
      fc.showOpenDialog(null);

      File f = fc.getSelectedFile();
      String filepath = f.getPath();
      try { // Each line in the file is read individually and written to the TextArea one after the other.
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        String s1 = "", s2 = "";
        while ((s1 = br.readLine()) != null) {
          s2 += s1 + "\n";
        }
        s3 = s2;
        br.close();
      } catch (Exception e) {
        // e.printStackTrace();
        ErrorDialog error = new ErrorDialog();
        error.setOpenError();
      }
    }

    public void All_Delete() {
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
            s3 = s2;
            br.close();
            
          } catch (Exception ex) {
            // e.printStackTrace();
            /*ErrorDialog error = new ErrorDialog();
            error.setWriteError();*/
          }
    }

    public String Back() {
        return s3;
    }
    
}
