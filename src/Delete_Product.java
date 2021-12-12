// Imports
import javax.swing.*;
import java.io.*;
import javax.swing.JLabel;

public class Delete_Product extends JFrame {
    JButton close, back, alldelete;
    JDialog dialog;
    JLabel successful;
    public Delete_Product() {
    super("Verwaltungsprogramm - Delete Product");
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(null);
    this.setVisible(true);
    
    // add JButton for Cancel
    close = new JButton("Close");
    close.setBounds(200, 500, 200, 50);
    
    // add JButton for Back
    back = new JButton("Back");
    back.setBounds(450, 500, 200, 50);
    
     // add JButton for All Delete
    alldelete = new JButton("Delete all Products");
    alldelete.setBounds(800, 500, 200, 50);
    
    // add Actionlisteners
    close.addActionListener(a -> {System.exit(0);});
    back.addActionListener(b -> {this.dispose(); new Main();});
    alldelete.addActionListener(c -> {try{
      File file = new File("");
            JFileChooser fc = new JFileChooser();
            fc.showSaveDialog(null);
            file = fc.getSelectedFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write("");
            bw.flush();
    }catch (IOException e) {e.printStackTrace();}});
    
    // add JButtons to JFrame
    this.add(close);
    this.add(back);
    this.add(alldelete);
  } 

} 

