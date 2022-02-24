// Imports
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.io.*;

public class Simulation extends JFrame {
  private String Produkt;
  //Datei muss Produkt heißen!!!
  //Produkt muss der name
    Scanner s = new Scanner("Produkt.txt");
        Random r = new Random();

        private String name, linie , category, description;
        private int stock=0, production=1, zaehler=0;
        private double money=0, price;

        JLabel des,nam,categor,pric,inventory;
        JButton close, back;
        JRadioButton donoff;

        public Simulation() {
          super ("Verwaltungsprogramm - Simulation");
          setExtendedState(JFrame.MAXIMIZED_BOTH);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setLayout(null);
          setVisible(true);

          simulation();
        }

        private void simulation() {
          Container cp = getContentPane();
          cp.setLayout(null);
          close = new JButton("Close");
          close.setBounds(200, 500, 200, 50);
          cp.add(close);

          back = new JButton("Back");
          back.setBounds(450, 500, 200, 50);
          cp.add(back);

          // JRadioButton
          donoff = new JRadioButton("Label off");
          donoff.setBounds(420, 50, 100, 20);
          cp.add(donoff);


          money = r.nextInt(100) + 100;


          variabeln();
          showPerks();

          close.addActionListener(a -> {
            System.exit(0);
          });
          back.addActionListener(b -> {
            this.dispose();
            new Gui();
          });
        }

    private void lesen(File Produkt) {
        try {
            s= new Scanner(Produkt);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private int variable() {
        if (s.hasNext()) {
            int alter= s.nextInt();
            return alter;
        }
    }








        private void showPerks() {
          Container cp = getContentPane();
          cp.setLayout(null);

            nam = new JLabel("Name of Product:");
          nam.setBounds(16, 34, 150, 20);
          cp.add(nam);

          categor = new JLabel("Category of Product:");
          categor.setBounds(16, 90, 150, 20);
          cp.add(categor);

          pric = new JLabel("Price of Product:");
          pric.setBounds(16, 150, 150, 20);
          cp.add(pric);

          inventory = new JLabel("In Stock: ");
          inventory.setBounds(16, 211, 150, 20);
          cp.add(inventory);

          des = new JLabel("Description of Product: ");
          des.setBounds(16, 271, 150, 20);
          cp.add(des);
        }

       /* public void read() {
          try {
            FileInputStream fis = new FileInputStream("Produkt.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            linie = br.readLine();
            while (linie != null) {
              if("".equals(linie)) {
                zaehler++;
              }
              linie = br.readLine();
            }
            br.close();
          } catch(Exception e) {
            e.printStackTrace();
          }
        }*/

}
