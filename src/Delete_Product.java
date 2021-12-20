// Imports
import javax.swing.*;
import java.io.*;

public class Delete_Product extends JFrame {
    private JButton close, back, alldelete, onedelete;
  
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
    alldelete.setBounds(800, 500, 200, 50);
    this.add(alldelete);
    
    onedelete = new JButton("Delete one Product");
    onedelete.setBounds(500, 700, 200, 50);
    this.add(onedelete);
    
    // add Actionlisteners
    close.addActionListener(a -> {
      System.exit(0);
    });
    
    back.addActionListener(b -> {
      this.dispose();
      new Main();
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

    onedelete.addActionListener(d -> {
        try {
            File file;
            JFileChooser fc =  new JFileChooser();
            fc.showSaveDialog(null);
            file = fc.getSelectedFile();
            boolean neu = true;
            boolean gelöscht = false;
            if(file.exists()) {
                BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));
            }
        } catch(IOException e) {
            ErrorDialog error = new ErrorDialog();
            error.setWriteError();
        }
    });
    
  } 

} 

