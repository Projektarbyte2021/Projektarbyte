import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Show_Product extends JFrame {
     JButton close, back, show;
     JScrollPane pane;
     JTextArea read;
    public Show_Product() {
    super("Verwaltungsprogramm - Show Product");
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(null);
    this.setVisible(true);
    
    // add JButton for Cancel
    close = new JButton("Close");
    close.setBounds(200, 500, 200, 50);
    
    // add JButton for Cancel
    back = new JButton("Back");
    back.setBounds(450, 500, 200, 50);
    
    // add JButton for Show
    show = new JButton("Show");
    show.setBounds(400, 200, 100, 50);
    
    // add JTextArea for Reading
    read = new JTextArea();
    read.setBounds(0, 0, 500, 500);
    
    // add JScrollPane
    this.add(new JScrollPane(read), BorderLayout.EAST);
    
    // add Actionlisteners
    close.addActionListener(a -> {System.exit(0);});
    back.addActionListener(b -> {this.dispose(); new Main();});
    show.addActionListener(c -> { 
            JFileChooser fc = new JFileChooser();
            int i = fc.showOpenDialog(this);
            if(i == JFileChooser.APPROVE_OPTION) {
                File f = fc.getSelectedFile();
                String filepath = f.getPath();
                try {
                    BufferedReader br = new BufferedReader(new FileReader(filepath));
                    String s1 = "",s2 = "";
                    while((s1 = br.readLine()) != null){
                        s2+=s1+"\n";
                    }
                    read.setText(s2);
                    br.close();
                }catch (Exception ex) {ex.printStackTrace();}
			}
	});
    
    // add JButtons to JFrame
    this.add(close);
    this.add(back);
    this.add(show);
    this.add(read);
  } // end of main

} // end of class Show_Product

