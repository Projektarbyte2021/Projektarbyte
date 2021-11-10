import javax.swing.*;

public class Main extends JFrame {
	
	private JButton cancel, aproduct, dproduct, sproduct, simulation;
	
	public Main() {
		// add Main Frame
		super("Verwaltungsprogramm - Main");
		this.setBounds(400, 100, 800, 600);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		
		// add JButton for Cancel
		cancel = new JButton("Cancel");
		cancel.setBounds(300, 500, 200, 50);
		
		// add JButton for Add Product
		aproduct = new JButton("Add Product");
		aproduct.setBounds(200, 150, 200, 50);
		
		// add JButton for Delete Product
		dproduct = new JButton("Delete Product");
		dproduct.setBounds(450, 150, 200, 50);
		
		// add JButton for Show Button
		sproduct = new JButton("Show Product");
		sproduct.setBounds(200, 250, 200, 50);
		
		// add JButton for Simulation
		simulation = new JButton("Simulation");
		simulation.setBounds(450, 250, 200, 50);
		
		// add ActionListener
		cancel.addActionListener(a -> {System.exit(0);});
		aproduct.addActionListener(b -> {this.dispose(); new Add_Product();});
		dproduct.addActionListener(c -> {});
		sproduct.addActionListener(d -> {});
		simulation.addActionListener(e -> {});
		
		// add Items to JFrame
		this.add(cancel);
		this.add(aproduct);
		this.add(dproduct);
		this.add(sproduct);
		this.add(simulation);
	} 
	
	public static void main (String[] args) {
		new Main();
	}
}

