import javax.swing.*;

public class Add_Product extends JFrame {
		
	private JButton back, cancel;
	private JTextArea nproduct;
		
	public Add_Product() {
		// add Main Frame
		super("Verwaltungsprogramm - Add Product");
		this.setBounds(400, 100, 800, 600);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		
		// add Back Button
		back = new JButton("Back");
		back.setBounds(200, 500, 200, 50);

		// add JButton for Cancel
		cancel = new JButton("Cancel");
		cancel.setBounds(450, 500, 200, 50);
		
		// add JTextArea for Name of Product
		nproduct = new JTextArea();
		nproduct.setBounds(200, 150, 100, 50);
		
		// add ActionListener
		back.addActionListener(a -> {this.dispose(); new Main();});
		cancel.addActionListener(a -> {System.exit(0);});

		// add Items to JFrame
		this.add(cancel);
		this.add(back);
		this.add(nproduct);
	}
}

