// Imports
import javax.swing.*;
import java.awt.*;

public class ErrorDialog  {
  private JDialog error;
  private JLabel cwrite;
  
  public void setWriteError() {
    error = new JDialog();
    cwrite = new JLabel("File can't write!!");
    error.setTitle("Error");
    error.setBounds(400, 100, 600, 500);
    error.setResizable(false);
    error.setVisible(true);
    cwrite.setFont(new Font("Calibri", Font.ITALIC, 35));
    cwrite.setBounds(200,100, 500,100);
    cwrite.setSize(500,100);
    error.add(cwrite);  
  }
  
  public void setOpenError() {
    error = new JDialog();
    cwrite = new JLabel("File can't open!!");
    error.setTitle("Error");
    error.setBounds(400, 100, 600, 500);
    error.setResizable(false);
    error.setVisible(true);
    cwrite.setFont(new Font("Calibri", Font.ITALIC, 35));
    cwrite.setBounds(200,100, 500,100);
    cwrite.setSize(500,100);
    error.add(cwrite);
  }

}