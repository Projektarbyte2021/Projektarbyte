// Imports
import javax.swing.*;
import java.awt.*;

public class ErrorDialog  {
  private JDialog error;
  private JLabel cwrite;
  private JButton ok, cancel;
  
  public void setWriteError() {
    error = new JDialog();
    cwrite = new JLabel("Selected file can't write!!");
    error.setTitle("An error");
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
    cwrite = new JLabel("Selected file can't open!!");
    error.setTitle("An error");
    error.setBounds(400, 100, 600, 500);
    error.setResizable(false);
    error.setVisible(true);
    cwrite.setFont(new Font("Calibri", Font.ITALIC, 35));
    cwrite.setBounds(200,100, 500,100);
    cwrite.setSize(500,100);
    error.add(cwrite);
  }
  
  public void setLabelError() {
    error = new JDialog();
    cwrite = new JLabel("JLabel cannot be changed!!");
    error.setTitle("An error");
    error.setBounds(400, 100, 600, 500);
    error.setResizable(false);
    error.setVisible(true);
    cwrite.setFont(new Font("Calibri", Font.ITALIC, 35));
    cwrite.setBounds(200,100, 500,100);
    cwrite.setSize(500,100);
    error.add(cwrite);
  }
  
  public void setWrongFile() {
    error = new JDialog();
    cwrite = new JLabel("Selected file not found!!");
    error.setTitle("An error");
    error.setBounds(400, 100, 600, 500);
    error.setResizable(false);
    error.setVisible(true);
    cwrite.setFont(new Font("Calibri", Font.ITALIC, 35));
    cwrite.setBounds(200,100, 500,100);                                          
    cwrite.setSize(500,100);
    error.add(cwrite);
  }
  
  public void setProductDelete() {
    error = new JDialog();
    cwrite = new JLabel("The selected product was deleted");
    error.setTitle("Product deleted");
    error.setBounds(400, 100, 600, 500);
    error.setResizable(false);
    error.setVisible(true);
    cwrite.setFont(new Font("Calibri", Font.ITALIC, 35));
    cwrite.setBounds(200,100, 500,100);                                          
    cwrite.setSize(500,100);
    error.add(cwrite);
  }
  
  public void setWrongItemNumber() {
    error = new JDialog();
    cwrite = new JLabel("Item number was not found!!");
    error.setTitle("Wrong item number");
    error.setBounds(400, 100, 600, 500);
    error.setResizable(false);
    error.setVisible(true);
    cwrite.setFont(new Font("Calibri", Font.ITALIC, 35));
    cwrite.setBounds(200,100, 500,100);                                          
    cwrite.setSize(500,100);
    error.add(cwrite);
  }

  public void setSucessfully() {
    error = new JDialog();
    cwrite = new JLabel("File was saved successfully!!");
    error.setTitle("Sucessfully");
    error.setBounds(400, 100, 600, 500);
    error.setResizable(false);
    error.setVisible(true);
    cwrite.setFont(new Font("Calibri", Font.ITALIC, 35));
    cwrite.setBounds(150, 100, 500, 100);
    cwrite.setSize(500, 100);
    error.add(cwrite);
    ok = new JButton("OK");
    ok.setBounds(300, 400, 100, 50);
    error.add(ok);
    ok.addActionListener(a -> {
      error.dispose();
    });
  }

}