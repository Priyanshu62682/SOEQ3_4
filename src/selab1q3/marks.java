/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package selab1q3;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Pri_D
 */
public class marks {
    JFrame frame;
    JPanel panel1;
    JLabel student_name;
    public int[] at=new int[10];
    public int k=0;
    String sub=null;
    marks(String subject){
       subject=subject+"_test";
       sub=subject;
       frame=new JFrame("Marks");
       frame.setSize(600,600);
       frame.setLayout(new GridLayout(10,1));
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       JLabel header=new JLabel("Enter Marks",JLabel.CENTER);
       header.setFont(header.getFont().deriveFont(32f));
       
       
       JPanel panel0=new JPanel();
       panel0.setLayout(new FlowLayout());
       
       JLabel date=new JLabel("Enter Test Code: ");
       date.setFont(date.getFont().deriveFont(12f));
       JTextField datefield=new JTextField(10);
       panel0.add(date);
       panel0.add(datefield);
       
       /////// new line
       
       JPanel panel=new JPanel();
       panel.setLayout(new FlowLayout());
       
       JLabel name1=new JLabel("RIT2014001       ",JLabel.CENTER);
       name1.setFont(name1.getFont().deriveFont(15f));
       JTextField box1=new JTextField(10);
       panel.add(name1);
       panel.add(box1);
       
       /////// new line
       
       JPanel panel2=new JPanel();
       panel2.setLayout(new FlowLayout());
       
       JLabel name2=new JLabel("RIT2014002       ",JLabel.CENTER);
       name2.setFont(name1.getFont().deriveFont(15f));
       JTextField box2=new JTextField(10);
       panel2.add(name2);
       panel2.add(box2);
       
       JPanel panel3=new JPanel();
       panel3.setLayout(new FlowLayout());
       
       JLabel name3=new JLabel("RIT2014003       ",JLabel.CENTER);
       name3.setFont(name1.getFont().deriveFont(15f));
       panel3.add(name3);
       JTextField box3=new JTextField(10);
       panel3.add(box3);
       
       JPanel panel4=new JPanel();
       panel4.setLayout(new FlowLayout());
       
       JLabel name4=new JLabel("RIT2014004       ",JLabel.CENTER);
       name4.setFont(name1.getFont().deriveFont(15f));
       panel4.add(name4);
       JTextField box4=new JTextField(10);
       panel4.add(box4);
       
       JPanel panel5=new JPanel();
       panel5.setLayout(new FlowLayout());
       
       JLabel name5=new JLabel("RIT2014005       ",JLabel.CENTER);
       name5.setFont(name1.getFont().deriveFont(15f));
       panel5.add(name5);
       JTextField box5=new JTextField(10);
       panel5.add(box5);
       
       JPanel panel6=new JPanel();
       panel6.setLayout(new FlowLayout());
       
       JLabel name6=new JLabel("RIT2014006       ",JLabel.CENTER);
       name6.setFont(name1.getFont().deriveFont(15f));
       panel6.add(name6);
       JTextField box6=new JTextField(10);
       panel6.add(box6);
       
        JPanel panelbutton=new JPanel();
        panelbutton.setLayout(new FlowLayout());
        JButton button=new JButton("Submit");
        button.setBounds(100,100,100,100);
        panelbutton.add(button);
        button.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                String query="insert into "+sub+" values('"+datefield.getText()+"',"+box1.getText()+
                        ","+box2.getText()+","+box3.getText()+","+box4.getText()+","+box5.getText()+","+box6.getText()+");";
                System.out.println(query);
                for(int i=0;i<k;i++)
                    System.out.println(at[i]);
                Connection con = null;
                Statement st = null;
                try{
                    Class.forName("com.mysql.jdbc.Driver");
          
                    con = DriverManager.getConnection("jdbc:mysql://localhost/soe","root","root");
                    st = con.createStatement();
                    st.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Recorded");
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
                information_page ob=new information_page(sub);
            }
        });
       
       frame.add(header);
       frame.add(panel0);
       frame.add(panel);
       frame.add(panel2);
       frame.add(panel3);
       frame.add(panel4);
       frame.add(panel5);
       frame.add(panel6);
       frame.add(panelbutton);
       


       
       frame.setVisible(true);
       
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        marks ob=new marks(sub);
    }
    
}
