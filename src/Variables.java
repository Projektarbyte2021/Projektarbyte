import javax.swing.*;
import java.awt.*;

public class Variables { 
        
public JLabel infoLabel, label;
public JWindow window;
public Container container;
public JPanel panel;
public ImageIcon logo;
public JProgressBar progress;

public Variables() {
        logo = new ImageIcon();
        infoLabel = new JLabel();  
        label = new JLabel();
        window = new JWindow(); 
        container = new Container();
        panel = new JPanel(new BorderLayout());
        progress = new JProgressBar(0, 100); // The second value specifies how fast the processbar should run through
}
        
        

}
