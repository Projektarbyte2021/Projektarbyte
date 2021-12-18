// Imports
import javax.swing.*;
import java.io.*;

public class Delete_Product extends JFrame {
    private JButton close, back, alldelete;
    private JDialog dialog;
  
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
        File file = new File("");
            JFileChooser fc = new JFileChooser();
            fc.showSaveDialog(null);
            file = fc.getSelectedFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write("");
            bw.flush();
      } catch(Exception e) {
        e.printStackTrace();
      } 
    });
    
  } 

} 

