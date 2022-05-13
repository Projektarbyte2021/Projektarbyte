// Imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Locale;

public class Gui extends JFrame{
  
  private JButton close;

  private JComboBox c;

  public Gui() {

    setTitle("Easy to Manage - GUI");
    JLabel l = new JLabel("Welcome to Easy to Manage");
    l.setFont(new Font("Serif", Font.ITALIC, 35));
    l.setBounds(500, 50, 500, 100);
    l.setSize(1000, 100);

    // choose language button
    JButton b = new JButton("Choose Language");
    b.setBounds(550, 300, 200, 50);

    // cancel button
    JButton a = new JButton("Cancel");
    a.setBounds(550, 375, 200, 50);

    // Menu
    String[] languagesList = {"English", "Deutsch"};


    JComboBox c = new JComboBox(languagesList);
    c.setBounds(550, 150, 200, 50);

    add(l);
    add(a);
    add(b);
    add(c);

    setSize(650, 600);

    setLayout(null);
    setVisible(true);

    setExtendedState(JFrame.MAXIMIZED_BOTH);

    c.addItemListener(ie -> {
      if (c.getSelectedItem().equals("Deutsch")) {
        l.setText("Willkommen in Easy to Manage");
        setTitle("Easy to Manage - GUI");
        b.setText("Sprache ausw\u00E4hlen");
        a.setText("Abbrechen");
      }
      if (c.getSelectedItem().equals("English")) {
        l.setText("Welcome to Easy to Manage");
        setTitle("Easy to Manage - GUI");
        b.setText("Choose Language");
        a.setText("Cancel");
      }
    });

    b.addActionListener(e -> {
      if (c.getSelectedItem().equals("Deutsch")) {
          new Product_Control(Locale.GERMAN);
      }
      if (c.getSelectedItem().equals("English")) {
          new Product_Control(Locale.ENGLISH);
        }
      dispose();
    });

    a.addActionListener((ActionEvent actionEvent) -> {
      System.exit(0);
    });
  }
  
  public static void main (String[] args) {
    new Splash().showSplash();
    new Gui();
  }
  
}