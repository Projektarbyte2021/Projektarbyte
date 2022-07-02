import java.awt.*;
import java.net.URL;
import javax.swing.*;

public class Splash extends JWindow {
  public JLabel infoLabel, label;
  public JWindow window;
  public Container container;
  public JPanel panel;
  public ImageIcon logo;
  public JProgressBar progress;
  public Splash() {
    // Initialisierung
    logo = new ImageIcon();
    infoLabel = new JLabel();
    label = new JLabel();
    window = new JWindow();
    container = new Container();
    panel = new JPanel(new BorderLayout());
    // Ende von Initialisierung

    progress = new JProgressBar(0, 100); // The second value specifies how fast the processbar should run through
    infoLabel.setText("Easy to Manage 1.0.0"); // Dem Attribut infoLabel vom Typ JLabel wird ein Text zugewiesen
    URL iconurl = getClass().getResource("Pencil.png"); // Das Attribut iconurl vom Typ URL bekommt das Bild Pencil.png 
    logo = new ImageIcon(iconurl); // Dem Attribut logo vom Typ ImageIcon wird das Bild aus iconurl zugewiesen
    container = window.getContentPane(); 
    container.setLayout(new BorderLayout());
    label = new JLabel(logo); // Das Bild wird zum JLabel label hinzugefügt
    
    panel.add(label, BorderLayout.CENTER); // Das JLabel label wird damit in der Mitte vom JPanel panel angezeigt
    panel.add(infoLabel, BorderLayout.SOUTH); // Das JLabel infoLabel wir damit auf der unteren Seite vom JPanel panel angezeigt
    
    container.add(panel); // Dem Container wird das JPanel panel zugewiesen
    
    
    window.setBounds(30, 80, 486, 486); // Das JWindow window bekommt damit die Position und die Größe des Fensters
    window.setLocationRelativeTo(null); // Legt die Position des Fensters relativ zur angegebenen Komponente fest 
    window.setVisible(true); // Mit diesem Befehl wird das JWindow angezeigt 
    
    progress.setSize(486, 20); // Die JProgressBar progress bekommt die Länge des JWindows und die Höhe 20
    
    progress.setValue(0); // progress bekommt den Anfagnswert 0
    
    progress.setStringPainted(true); // Erlaubt progress den Wert als Text anzuzeigen und zu ändern
    
    panel.add(progress); // progress wird panel hinzugefügt
    
    for (int i = 0; i <= progress.getMaximum(); i++) { // Die Schleife läuft solange bis der MaximaleWert von progress erreicht wurde
      progress.setValue(i); // progress bekommt immer den Wert von i
      try {
        Thread.sleep(15); // Dient zur Geschwindigkeit von progress
      } catch (InterruptedException e) {
        e.printStackTrace(); // Falls ein Fehler auftritt wird dieser in der Konsole ausgegeben
      }
      
    }
  }

  public void showSplash() {
    window.dispose(); // Schließt das JWindow wieder aber beendet nicht das Programm
  }

}