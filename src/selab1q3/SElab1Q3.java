/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package selab1q3;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
public class SElab1Q3 extends JFrame{
    JFrame frame;
    JPanel panel1;
    JPanel panel2;
    JPanel panel21;
    JPanel panel22;
    JPanel panel23;
    JLabel password;
    JTextField username;
    JLabel name;
    JTextField pass;
    int flag=0;
    public void login(){
       frame=new JFrame("LOGIN");
       frame.setSize(600,500);
       frame.setLayout(new GridLayout(3,1));
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       panel1=new JPanel();
       panel1.setLayout(new GridLayout());
       
       JLabel header=new JLabel("LOGIN",JLabel.CENTER);
       header.setFont(header.getFont().deriveFont(32f));
       panel1.add(header);
       
       panel2=new JPanel();
//       panel2.setBackground(Color.magenta);
       panel2.setLayout(new GridLayout(4,1));
       panel2.setBorder(BorderFactory.createRaisedBevelBorder());
       
       panel21=new JPanel();
       name=new JLabel("UserName :");
       panel21.add(name);
       username = new JTextField(10);
       panel21.add(username);
       
       panel22=new JPanel();
       password=new JLabel("Password :");
       panel22.add(password);
       pass = new JTextField(10);
       panel22.add(pass);
       
       JRadioButton faculty = new JRadioButton("Faculty");
        JRadioButton student = new JRadioButton("Student");
        JRadioButton admin = new JRadioButton("Admin");

        faculty.setMnemonic(KeyEvent.VK_M);
        student.setMnemonic(KeyEvent.VK_P);
        admin.setMnemonic(KeyEvent.VK_A);
        
        faculty.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent e) {         
            flag=1;
//            System.out.println("here:"+flag);
            }           
        });

        student.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {             
                flag=2;
            }           
        });
        
        admin.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent e) {         
            flag=3;
//            System.out.println("here:"+flag);
            }           
        });
//        System.out.println(flag);
        ButtonGroup group = new ButtonGroup();
        group.add(faculty);
        group.add(student);
        group.add(admin);
       
        JPanel idtype=new JPanel();
        idtype.setLayout(new FlowLayout());
        idtype.add(faculty);
        idtype.add(student);
        idtype.add(admin);
       
       JPanel panel23=new JPanel();
       JButton button=new JButton("SUBMIT");
       button.setBounds(50,50,50,50);
       button.addActionListener(new CustomActionListener());
       panel23.add(button);
    
       
       panel2.add(panel21);
       panel2.add(panel22);
       panel2.add(idtype);
       panel2.add(panel23);
       frame.add(panel1);
       frame.add(panel2);
       
       frame.setVisible(true);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        SElab1Q3 ob=new SElab1Q3();
        ob.login();
    } 
    class CustomActionListener implements ActionListener{
      public void actionPerformed(ActionEvent e) {
          String query=null;
          System.out.println(flag);
          if(flag==1||flag==3)
          query=("SELECT password FROM login where name = '"+username.getText()+"' ");
          else if(flag==2)
              query=("SELECT password FROM login_student where name = '"+username.getText()+"' ");
          String p_word=getvalue(query,0);
          String subject=null;
          if(flag==1||flag==3){
              query=("SELECT subject FROM login where name = '"+username.getText()+"' ");
              subject=getvalue(query,1);
          }
           System.out.println(subject); 
          if(p_word.equals(pass.getText())){
                if(flag==1||flag==3)
                    new information_page(subject);
                else if(flag==2)
                    new student(username.getText());
          }
          else JOptionPane.showMessageDialog(null,"Invalid Username or Password");
          username.setText("");
          pass.setText("");
      }
   }
    public String getvalue(String r,int n){
      Connection con = null;
      Statement st = null;
      String subject=null;
      String pass=new String();
      try{
          Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection("jdbc:mysql://localhost/SOE","root","root");
          st = con.createStatement();
          ResultSet rs=st.executeQuery(r);
          if(n==0)
            if(rs.next())
              pass=rs.getString("password");
          if(n==1)
              if(rs.next())
                subject=rs.getString("subject");
      }catch(Exception ex){
          JOptionPane.showMessageDialog(null,"Invalid Username or Password");
      }
      if(n==1)
          return subject;
      return pass;
    }
}
