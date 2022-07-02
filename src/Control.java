import java.awt.*;
import java.io.*;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Control {

    String error, electronic, mechanic, social ,services, name, number, price, inventory, information, s3;
    public FileFilter filter;
    public JFileChooser fc;

    public void Transfer1(String error, String electronic, String mechanic, String social, String services, String name, String number, String price, String inventory, String information) {
      // Werte die von der GUI gesendet wurden werden über Parameter empfangen und in Variablen gespeichert  
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
        fc = new JFileChooser();
      filter = new FileNameExtensionFilter(GUI.bundle.getString("file"), "txt"); // filenamefilter initialisieren
      fc.addChoosableFileFilter(filter); // Filter wird zum FileChooser hinzugefügt
      fc.showSaveDialog(null); // Save Dialog wird angezeigt
        try {
          boolean neu = false;
          File file;
          file = fc.getSelectedFile();
          if (!file.exists()) { // Existiert die Datei noch nicht so wird die Datei erstellt und die Variable neu auf true gesetzt
            file.createNewFile();
            neu = true;
          }
          BufferedWriter bw = new BufferedWriter(new FileWriter(file, true)); // BufferedWriter wird deklariert
          if (!neu) { // Ist die Datei nicht neu so wird ein Zeilenumbruch reingeschrieben
            bw.write("\n");
            bw.write("\n");
          } // end of if
          bw.write("");
          bw.write(name); // Mit dem Befehl bw.write(Parameter von JTextArea) wird der Inhalt von JTextArea reingeschrieben
          bw.write("\n");
          if (error == GUI.bundle.getString("error2")) { // Es wird abgefragt ob die Beschriftung ausgewählt wurde oder nicht
            bw.write(error);
          } else if (error == GUI.bundle.getString("error1")) {
              bw.write(error);
            }
          
          if (electronic == GUI.bundle.getString("el")) {
            bw.write(electronic);
          } else if (electronic == GUI.bundle.getString("cel")) {
              bw.write(electronic);
            }
          
          if (mechanic == GUI.bundle.getString("me")) {
            bw.write(mechanic);
          } else if (mechanic == GUI.bundle.getString("cme")) {
              bw.write(mechanic);
            }
          
          if (social == GUI.bundle.getString("so")) {
            bw.write(social);
          } else if (social == GUI.bundle.getString("cso")) {
              bw.write(social);
            }
          
          if (services == GUI.bundle.getString("se")) {
            bw.write(services);
          } else if (services == GUI.bundle.getString("cse")) {
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
            File f = fc.getSelectedFile(); // Es wird ein Attribut f vom Typ File erstellt und den Wert vom FileChooser zugewiesen
            String filepath = f.getPath(); // Es wird ein Attribut filepath vom Typ String erstellt den Pfad der Datei zugewiesen
            try {
              BufferedReader br = new BufferedReader(new FileReader(filepath)); // Ein BufferedReader wird erstellt, diesem wird ein FileReader hinzugefügt der den Dateipfad bekommt um herauszufinden um welche Datei es sich handelt 
              String s1 = "", s2 = ""; // Es werden zwei Variablen s1 und s2 erstellt
              while ((s1 = br.readLine()) != null) { // s1 wird der BufferedReader zugewisen, solange dieser nicht null ist erhält s2 den Wert von s1 und bekommt nach jeder Zeile ein Zeilenumbruch
                s2 += s1 + "\n";
              }
              s3 = s2; // Der Wert von s2 wird in s3 geschrieben um diese später an die GUI zurückzuversenden
              br.close(); // Beendet den BufferedReader
            } catch (Exception e) { 
              // e.printStackTrace();
              ErrorDialog error = new ErrorDialog();
              error.setOpenError(); // Wenn ein Fehler auftritt wird ein Fehler Dialog geöffnet
            }
          
        } catch (IOException e) {
          // e.printStackTrace();
          ErrorDialog error = new ErrorDialog();
          error.setWriteError();
        }
      }
    
      
    public void ShowProduct() {
        fc = new JFileChooser();
      filter = new FileNameExtensionFilter(GUI.bundle.getString("file"), "txt"); // Der Dateifilter wird deklariert und initialisiert
      fc.addChoosableFileFilter(filter); // Dem JFileChooser wird der Filter hinzugefügt
      fc.showOpenDialog(null); // Erstellt Open Dialog

      File f = fc.getSelectedFile();
      String filepath = f.getPath();
      try { 
        BufferedReader br = new BufferedReader(new FileReader(filepath));// Ein BufferedReader wird erstellt, diesem wird ein FileReader hinzugefügt der den Dateipfad bekommt um herauszufinden um welche Datei es sich handelt 
        String s1 = "", s2 = ""; // Es werden zwei Variablen s1 und s2 erstellt
        while ((s1 = br.readLine()) != null) { // s1 wird der BufferedReader zugewisen, solange dieser nicht null ist 
          s2 += s1 + "\n"; // erhält s2 den Wert von s1 und bekommt nach jeder Zeile ein Zeilenumbruch
        }
        s3 = s2; // Der Wert von s2 wird in s3 geschrieben uum diese später an die GUI zurückzuversenden
        br.close(); // Beendet den BufferedReader
      } catch (Exception e) {
        // e.printStackTrace();
        ErrorDialog error = new ErrorDialog();
        error.setOpenError();
      }
    }

    public void All_Delete() {
        try {
            fc = new JFileChooser();
            File file; // Erstellt Attribut file vom Typ File
            fc.showSaveDialog(null); // Erstellt Save Dialog
            file = fc.getSelectedFile(); // file bekommt Wert von JFileChooser
            String filepath = file.getPath(); // Attribut vom Typ String wird erstellt und den Pfad von file zugewiesen
            BufferedWriter bw = new BufferedWriter(new FileWriter(file)); // BufferedWriter wird erstellt und erhält einen FileWriter der den Wert von file bekommt
            bw.write(""); // Die gesamte Datei wird mit Leerzeichen überschrieben
            bw.flush(); // Inhalt von Puffer wird in Ausgabestrom geleert
            // Siehe Kommentare von Show Product
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
        return s3; // s3 wird an GUI zurückgesendet
    }
    
}
