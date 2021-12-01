// Imports
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Show_Product {
   JFrame frame;
     JButton show, back, close;
     JTextArea read;
     JToolBar tbar;
     FileFilter filter;
    public Show_Product() {
	frame = new JFrame("Verwaltungsprogramm - Show Product");
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    
    // JButton for show
        URL iconURL1 = getClass().getResource("Open.png");
        // iconURL is null when not found
        ImageIcon icon1 = new ImageIcon(iconURL1);
        show = new JButton(icon1);
        show.setSize(100, 50);
        
        // JButton for back
        URL iconURL2 = getClass().getResource("Back.png");
        // iconURL is null when not found
        ImageIcon icon2 = new ImageIcon(iconURL2);
        back = new JButton(icon2);
        back.setSize(100, 50);
        
        // JButton for Close
        URL iconURL3 = getClass().getResource("Exit.png");
        // iconURL is null when not found
        ImageIcon icon3 = new ImageIcon(iconURL3);
        close = new JButton(icon3);
        close.setSize(100, 50);
    
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
    back.addActionListener(b -> {frame.dispose(); new Main();});
    show.addActionListener(c -> {               ;
            filter = new FileNameExtensionFilter("Textdatei", "txt");
            JFileChooser fc = new JFileChooser();
            fc.addChoosableFileFilter(filter);   
            int i = fc.showOpenDialog(frame);
      
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
    tbar.add(show);
    tbar.add(back);
    tbar.add(close);
    frame.add(new JScrollPane(read));
    frame.add(tbar, BorderLayout.NORTH);
  } 

}
