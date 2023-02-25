import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class ImageOperation {

    public static void operate(int key)
    {

        JFileChooser fileChooser=new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file=fileChooser.getSelectedFile();
        //file FileInputStream
        try
        {

            FileInputStream fis=new FileInputStream(file);

            byte []data=new byte[fis.available()];
            fis.read(data);
            int i=0;
            for(byte b:data)
            {
                System.out.println(b);
                data[i]=(byte)(b^key);
                i++;
            }

            FileOutputStream fos=new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Done");

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        
        System.out.println("this is testing");

        JFrame f=new JFrame();
        f.setTitle("File Encryption/Decryption");
        f.setSize(400,400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font=new Font("Roboto",Font.BOLD,25);
        //creating button
        JButton button=new JButton();
        button.setText("Encrypt");
        button.setFont(font);
        //button.setFocusable(false);
        //button.setBounds(10, 100, 500, 500);
        
        JButton but=new JButton();
        but.setText("Decrypt");
        but.setFont(font);
        
        //Creating a Label
        
        JLabel jl = new JLabel("Enter Key First");
        JLabel title = new JLabel("File Encryption/Decryption using Verman Cipher Algoritm");


        //creating text field

        JTextField textField=new JTextField(10);
        textField.setFont(font);

        
        button.addActionListener(e->{
            System.out.println("button clicked");
            String text=textField.getText();
            int temp=Integer.parseInt(text);
            operate(temp);
            button.setEnabled(false); // click only once
        });

        but.addActionListener(e->{
            System.out.println("button clicked");
            String text=textField.getText();
            int temp=Integer.parseInt(text);
            operate(temp);
            but.setEnabled(false); //click only once 
        });
        
        f.setLayout(new FlowLayout());
        f.add(title);
        
        
        
        f.add(jl);
        f.add(textField);

        f.add(button);
        f.add(but);
        
        f.setVisible(true);

    }
}
