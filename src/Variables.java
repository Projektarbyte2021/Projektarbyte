import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.filechooser.FileFilter;

public class Variables extends JFrame { 
        
public JLabel infoLabel, label, name, category, price, info, inventory, number;
public JWindow window;
public Container container;
public JPanel panel;
public ImageIcon logo;
public JProgressBar progress;
public FileFilter filter;
public Locale locale;
public static ResourceBundle bundle;
public JButton close, add, show, alldelete;
public JRadioButton donoff;
public JTextArea nproduct, pproduct, iproduct, inventoryproduct, read, productnumber;
public JComboBox c;
public JScrollPane nproductScrollPane, pproductScrollPane, iproductScrollPane, inventoryScrollPane, readScrollPane, productnumberScrollPane;
public String electronic, mechanic, social, services, error = "non";
public boolean test1, test2, test3, test4, test5, check = false, zv1, zv2, zv3, zv4, zv5, zv6;
public JMenu filemenu, helpmenu;
public JMenuItem exit, save, open, infomenu;
public JMenuBar mb;
public JFileChooser fc;

public Variables() {
        // Atributes for Splash
        logo = new ImageIcon();
        infoLabel = new JLabel();  
        label = new JLabel();
        window = new JWindow(); 
        container = new Container();
        panel = new JPanel(new BorderLayout());
        progress = new JProgressBar(0, 100); // The second value specifies how fast the processbar should run through
        // Attributes for Product_Control
        close = new JButton();
        add = new JButton();
        show = new JButton();
        alldelete = new JButton();
        donoff = new JRadioButton();
        nproduct = new JTextArea();
        pproduct = new JTextArea();
        iproduct = new JTextArea();
        inventoryproduct = new JTextArea();
        read = new JTextArea();
        fc = new JFileChooser();
        productnumber = new JTextArea();
        nproductScrollPane = new JScrollPane(nproduct);
        pproductScrollPane = new JScrollPane(pproduct);
        iproductScrollPane = new JScrollPane(iproduct);
        inventoryScrollPane = new JScrollPane(inventoryproduct);
        productnumberScrollPane = new JScrollPane(productnumber);
        readScrollPane = new JScrollPane(read);
        name = new JLabel();
        category = new JLabel();
        price = new JLabel();
        info = new JLabel();
        inventory = new JLabel();
        number = new JLabel();
        mb =  new JMenuBar();
}
        
        

}
