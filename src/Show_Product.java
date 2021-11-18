import javax.swing.*;
import java.io.*;

public class Show_Product extends JFrame {
     JButton close, back, show;
     JTextArea read;
    public Show_Product() {
    super("Verwaltungsprogramm - Show Product");
    this.setBounds(400, 100, 800, 600);
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
    read.setBounds(0, 0, 500, 800);
    
    // add Actionlisteners
    close.addActionListener(a -> {System.exit(0);});
    back.addActionListener(b -> {this.dispose(); new Main();});
    show.addActionListener(c -> { 
		try {
				String textLine;
				FileReader fr = new FileReader("");
				JFileChooser fc = new JFileChooser();
				BufferedReader reader = new BufferedReader(fr);
			while((textLine=reader.readLine()) != null){
				textLine = reader.readLine();
				read.read(reader, "File");
			}
				reader.close();

		}catch(IOException e){
			e.printStackTrace();
		}
	});
    
    // add JButtons to JFrame
    this.add(close);
    this.add(back);
    this.add(show);
    this.add(read);
  } // end of main

} // end of class Show_Product

