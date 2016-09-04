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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Pri_D
 */
public class information_page {

    JFrame frame;
    JPanel panel1;
    JPanel panel2;
    JPanel controlpanel;
    JTextField subtext;
    JTextField subtext2;
    JLabel password;
    JTextField username;
    JLabel name;
    JTextField pass;
    JTextField inputdate;
    JTextField testcode;
    int flag = 1;
    information_page(String sub) {
        frame = new JFrame();
        frame.setSize(600, 550);
        frame.setLayout(new GridLayout(4,1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlpanel = new JPanel();
        GridLayout layout=new GridLayout(5,1);
        controlpanel.setLayout(new FlowLayout());
 //       controlpanel.setBackground(Color.darkGray);
 //       panel1.setLayout(new FlowLayout());
        
        
        JRadioButton assign = new JRadioButton("Assignment",true);
        JRadioButton test = new JRadioButton("Marks Information");

        assign.setMnemonic(KeyEvent.VK_M);
        test.setMnemonic(KeyEvent.VK_P);

        
        assign.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent e) {         
            flag=1;
//            System.out.println("here:"+flag);
            }           
        });

        test.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {             
                flag=2;
            }           
        });
//        System.out.println(flag);
        ButtonGroup group = new ButtonGroup();
        group.add(assign);
        group.add(test);
        
        
        JLabel header = new JLabel("GET INFORMATION", JLabel.CENTER);
        header.setFont(header.getFont().deriveFont(25f));
        frame.add(header);
        
        panel1=new JPanel();
        panel1.setLayout(layout);
//        panel1.setBorder(BorderFactory.createRaisedBevelBorder());
        panel1.add(assign);
        JPanel panel11=new JPanel();
        panel11.setLayout(new FlowLayout());
        JLabel subject=new JLabel("Subject :");
        panel11.add(subject);
        subtext=new JTextField(10);
        panel11.add(subtext);
        JLabel date=new JLabel("Enter date (DD/MM/YYYY) :");
        inputdate=new JTextField(10);
        panel1.add(panel11);
        panel1.add(date);
        panel1.add(inputdate);
        
        panel2 = new JPanel();
        panel2.setLayout(layout); 
//        panel2.setBorder(BorderFactory.createRaisedBevelBorder());
        panel2.add(test);
        JPanel panel21=new JPanel();
        panel21.setLayout(new FlowLayout());
        JLabel subject2=new JLabel("Subject :");
        panel21.add(subject2);
        subtext2=new JTextField(10);
        panel21.add(subtext2);
        JPanel panel22=new JPanel();
        panel22.setLayout(new FlowLayout());
        JLabel number=new JLabel("Test Code :");
        panel22.add(number);
        testcode=new JTextField(10);
        panel22.add(testcode);
        panel2.add(panel21);
        panel2.add(panel22);
        
        JPanel panel4=new JPanel();
        panel4.setLayout(new FlowLayout());
        JButton button_attend=new JButton("Record Attendence");
        button_attend.setBounds(100,100,100,100);
        button_attend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(sub==null){
                    JOptionPane.showMessageDialog(null,"You are not authorised for this action");
                }
                else
                    new attendence(sub);
            }
        });
        panel4.add(button_attend);
        JButton button_test=new JButton("Record Marks");
        button_test.setBounds(100,100,100,100);
        button_test.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(sub==null){
                    JOptionPane.showMessageDialog(null,"You are not authorised for this action");
                }
                else
                    new marks(sub);
            }
        });
        panel4.add(button_test);
        
        JPanel panel3=new JPanel();
        panel3.setLayout(new FlowLayout());
        panel3.setBorder(new EmptyBorder(50, 10, 10, 10));
        JButton button=new JButton("SEARCH");
        button.setBounds(100,100,100,100);
        panel3.add(button);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(sub == null){
                    if(flag==1){
                        Table table=new Table(subtext.getText()+"_attend",inputdate.getText(),1);
                    }
                    else if(flag==2){
                        Table table=new Table(subtext2.getText()+"_test",testcode.getText(),2);
                    }
                }
                else if(sub.equals(subtext.getText())||sub.equals(subtext2.getText())){
                    if(flag==1){
                        Table table=new Table(subtext.getText()+"_attend",inputdate.getText(),1);
                    }
                    else if(flag==2){
                        Table table=new Table(subtext2.getText()+"_test",testcode.getText(),2);
                    }
                }
                else JOptionPane.showMessageDialog(null,"You are not authorised for this subject");
            }
        });
        
        controlpanel.add(panel1);
        controlpanel.add(panel2);
        frame.add(controlpanel);
        frame.add(panel3);
        frame.add(panel4);
        frame.setVisible(true);
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        information_page ob = new information_page();
    }

}
