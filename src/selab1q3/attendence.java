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
import javax.swing.BorderFactory;
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
public class attendence {
    JFrame frame;
    JPanel panel1;
    JLabel student_name;
    public int[] at=new int[10];
    public int k=0;
    String sub=null;
    attendence(String subject){
        subject=subject+"_test";
       sub=subject;
       String sub="soe_attend";
       frame=new JFrame("New Attendence");
       frame.setSize(600,600);
       frame.setLayout(new GridLayout(10,1));
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       JLabel header=new JLabel("New Attendence",JLabel.CENTER);
       header.setFont(header.getFont().deriveFont(32f));
       
       
       JPanel panel0=new JPanel();
       panel0.setLayout(new FlowLayout());
       
       JLabel date=new JLabel("Enter Date: ");
       date.setFont(date.getFont().deriveFont(12f));
       JTextField datefield=new JTextField(10);
       panel0.add(date);
       panel0.add(datefield);
       
       /////// new line
       
       JPanel panel=new JPanel();
       panel.setLayout(new FlowLayout());
       
       JLabel name1=new JLabel("RIT2014001       ",JLabel.CENTER);
       name1.setFont(name1.getFont().deriveFont(15f));
       JRadioButton present = new JRadioButton("Present");
        JRadioButton absent = new JRadioButton("Absent");

        present.setMnemonic(KeyEvent.VK_M);
        absent.setMnemonic(KeyEvent.VK_P);

        
        present.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent e) {         
            at[k++]=1;
//            System.out.println("here:"+flag);
            }           
        });

        absent.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {             
                at[k++]=0;
            }           
        });
//        System.out.println(flag);
        ButtonGroup group = new ButtonGroup();
        group.add(present);
        group.add(absent);
        panel.add(name1);
        panel.add(present);
        panel.add(absent);
        ///// end panel
       /////// new line
       
       JPanel panel2=new JPanel();
       panel2.setLayout(new FlowLayout());
       
       JLabel name2=new JLabel("RIT2014002       ",JLabel.CENTER);
       name2.setFont(name1.getFont().deriveFont(15f));
       JRadioButton present2 = new JRadioButton("Present");
        JRadioButton absent2 = new JRadioButton("Absent");

        present2.setMnemonic(KeyEvent.VK_M);
        absent2.setMnemonic(KeyEvent.VK_P);

        
        present2.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent e) {         
            at[k++]=1;
//            System.out.println("here:"+flag);
            }           
        });

        absent2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {             
                at[k++]=0;
            }           
        });
//        System.out.println(flag);
        ButtonGroup group2 = new ButtonGroup();
        group2.add(present2);
        group2.add(absent2);
        panel2.add(name2);
        panel2.add(present2);
        panel2.add(absent2);

        ///// end panel/////// new line
       
       JPanel panel3=new JPanel();
       panel3.setLayout(new FlowLayout());
       
       JLabel name3=new JLabel("RIT2014003       ",JLabel.CENTER);
       name3.setFont(name1.getFont().deriveFont(15f));
       JRadioButton present3 = new JRadioButton("Present");
        JRadioButton absent3 = new JRadioButton("Absent");

        present3.setMnemonic(KeyEvent.VK_M);
        absent3.setMnemonic(KeyEvent.VK_P);

        
        present3.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent e) {         
            at[k++]=1;
//            System.out.println("here:"+flag);
            }           
        });

        absent3.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {             
               at[k++]=0; 
            }           
        });
//        System.out.println(flag);
        ButtonGroup group3 = new ButtonGroup();
        group3.add(present3);
        group3.add(absent3);
        panel3.add(name3);
        panel3.add(present3);
        panel3.add(absent3);
 
        ///// end panel/////// new line
       
       JPanel panel4=new JPanel();
       panel4.setLayout(new FlowLayout());
       
       JLabel name4=new JLabel("RIT2014004       ",JLabel.CENTER);
       name4.setFont(name1.getFont().deriveFont(15f));
       JRadioButton present4 = new JRadioButton("Present");
        JRadioButton absent4 = new JRadioButton("Absent");

        present4.setMnemonic(KeyEvent.VK_M);
        absent4.setMnemonic(KeyEvent.VK_P);

        
        present4.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent e) {         
            at[k++]=1;
//            System.out.println("here:"+flag);
            }           
        });

        absent4.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {             
               at[k++]=0; 
            }           
        });
//        System.out.println(flag);
        ButtonGroup group4 = new ButtonGroup();
        group4.add(present4);
        group4.add(absent4);
        panel4.add(name4);
        panel4.add(present4);
        panel4.add(absent4);

        ///// end panel/////// new line
       
       JPanel panel5=new JPanel();
       panel5.setLayout(new FlowLayout());
       
       JLabel name5=new JLabel("RIT2014005       ",JLabel.CENTER);
       name5.setFont(name1.getFont().deriveFont(15f));
       JRadioButton present5 = new JRadioButton("Present");
        JRadioButton absent5 = new JRadioButton("Absent");

        present5.setMnemonic(KeyEvent.VK_M);
        absent5.setMnemonic(KeyEvent.VK_P);

        
        present5.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent e) {         
            at[k++]=1;
//            System.out.println("here:"+flag);
            }           
        });

        absent5.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {             
                at[k++]=0;
            }           
        });
//        System.out.println(flag);
        ButtonGroup group5 = new ButtonGroup();
        group5.add(present5);
        group5.add(absent5);
        panel5.add(name5);
        panel5.add(present5);
        panel5.add(absent5);

        ///// end panel/////// new line
       
       JPanel panel6=new JPanel();
       panel6.setLayout(new FlowLayout());
       
       JLabel name6=new JLabel("RIT2014006       ",JLabel.CENTER);
       name6.setFont(name1.getFont().deriveFont(15f));
       JRadioButton present6 = new JRadioButton("Present");
        JRadioButton absent6 = new JRadioButton("Absent");

        present6.setMnemonic(KeyEvent.VK_M);
        absent6.setMnemonic(KeyEvent.VK_P);

        
        present6.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent e) {         
            at[k++]=1;
//            System.out.println("here:"+flag);
            }           
        });

        absent6.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {             
                at[k++]=0;
                
            }           
        });
//        System.out.println(flag);
        ButtonGroup group6 = new ButtonGroup();
        group6.add(present6);
        group6.add(absent6);
        panel6.add(name6);
        panel6.add(present6);
        panel6.add(absent6);
        
        ///// end panel/////// new line
        JPanel panelbutton=new JPanel();
        panelbutton.setLayout(new FlowLayout());
        JButton button=new JButton("Submit");
        button.setBounds(100,100,100,100);
        panelbutton.add(button);
        button.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                String query="insert into "+sub+" values('"+datefield.getText()+"',"+at[0]+","+at[1]+","+at[2]+","+at[3]+","+at[4]+","+at[5]+");";
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
    /*    String sub="soe_attend";
        attendence ob=new attendence();*/
    }
    
}
