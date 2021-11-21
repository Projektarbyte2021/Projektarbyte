// Imports
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Show_Product {
	 JFrame f;
     JButton close, back, show;
     JTextArea read;
     JToolBar tbar;
    public Show_Product() {
	f = new JFrame("Verwaltungsprogramm - Show Product");
    f.setExtendedState(JFrame.MAXIMIZED_BOTH);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
    
    // add JButton for Cancel
    close = new JButton("Close");
    
    // add JButton for Back
    back = new JButton("Back");
    
    // add JButton for Show
    show = new JButton("Show");
    
    // add JTextArea for Reading
    read = new JTextArea();
    read.setSize(1350, 670);
    read.setEditable(false);
    
    // add JToolBar for Buttons
    tbar = new JToolBar();
    tbar.setSize(1350, 700);
    tbar.addSeparator();
    tbar.setFloatable(false);
    
    // add Actionlisteners
    close.addActionListener(a -> {System.exit(0);});
    back.addActionListener(b -> {f.dispose(); new Main();});
    show.addActionListener(c -> { 
            JFileChooser fc = new JFileChooser();
            int i = fc.showOpenDialog(f);
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
    tbar.add(close);
    tbar.add(back);
    tbar.add(show);
    f.add(new JScrollPane(read));
    f.add(tbar, BorderLayout.NORTH);
  } 

} 

