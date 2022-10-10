import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    MyFrame(){
        this.setTitle("learner");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(420,420);
        this.setVisible(true);

        ImageIcon image=new ImageIcon("OIP.jfif");
        this.setIconImage(image.getImage());
        //frame.getContentPane().setBackground(Color.BLUE);
        this.getContentPane().setBackground(new Color(123,50,250));



    }

}
