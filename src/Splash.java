import java.awt.*;
import java.net.URL;
import javax.swing.*;

public class Splash extends Variables{

  public Splash() {
    infoLabel.setText("Easy to Manage 1.0.0");
    URL iconurl = getClass().getResource("Pencil.png");
    logo = new ImageIcon(iconurl);
    container = window.getContentPane();
    container.setLayout(new BorderLayout());
    label = new JLabel(logo);

    panel.setBorder(BorderFactory.createLineBorder(Color.black));
    
    panel.add(label, BorderLayout.CENTER);
    panel.add(infoLabel, BorderLayout.SOUTH);
    
    container.add(panel);
    
    
    window.setBounds(30, 80, 486, 486);
    window.setLocationRelativeTo(null);
    window.setVisible(true);
    
    progress.setSize(486, 20);
    
    progress.setValue(0);
    
    progress.setStringPainted(true);
    
    panel.add(progress);
    
    container.add(panel);
    
    for (int i = 0; i <= progress.getMaximum(); i++) { // The for loop runs until the end of the progressbar
      progress.setValue(i);
      try {
        Thread.sleep(15);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      
    }
  }

  public void showSplash() {
    window.setVisible(true);
    window.dispose();
  }

  public void updateInfoLabel(String info) {
    infoLabel.setText(info);
  }

}