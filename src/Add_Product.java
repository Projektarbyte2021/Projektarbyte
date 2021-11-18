import javax.swing.*;
import java.io.*;

public class Add_Product extends JFrame  {
    JButton close, back, add;
    JTextArea nproduct, cproduct;
    JLabel name;
    public Add_Product() {
    super("Verwaltungsprogramm - Add Product");
    this.setBounds(400, 100, 800, 600);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(null);
    this.setVisible(true);
    
    // add JButton for Cancel
    close = new JButton("Close");
    close.setBounds(200, 500, 200, 50);
    
    // add JButton for Back
    back = new JButton("Back");
    back.setBounds(450, 500, 200, 50);
    
    // add JButton for Add
    add = new JButton("Add");
    add.setBounds(450, 100, 200, 50);
    
    // add JLabel for Name of Product
    name = new JLabel("Name of Product:");
    name.setBounds(100, 50, 100, 10);
    
    // add JTextArea for Name of product
    nproduct = new JTextArea("Name: ");
    nproduct.setBounds(210, 47, 100, 20);
    
    // add Actionlisteners
    close.addActionListener(a -> {System.exit(0);});
    back.addActionListener(b -> {this.dispose(); new Main();});
    add.addActionListener(c -> {
		try{File file = new File("");
            JFileChooser fc = new JFileChooser();
            fc.showSaveDialog(null);
            file = fc.getSelectedFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(nproduct.getText());
            bw.flush();
		}catch (IOException e) {System.out.println("Datei kann nicht erstellt werden");}
	});
    
    // add JButtons to JFrame
    this.add(close);
    this.add(back);
    this.add(add);
    this.add(name);
    this.add(nproduct);
  }
}
  


