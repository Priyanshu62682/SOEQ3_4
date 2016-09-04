/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package selab1q3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Pri_D
 */
public class Table {
    Table(String sub,String code,int t){
        JFrame frame=new JFrame();
        JPanel panel=new JPanel();
        panel.setLayout( new BorderLayout() );
        String r;
        System.out.println(t);
        if(t==3){
            String rollno=code;
            r="select date, "+rollno+" from "+sub+";";
        }
        else if(t==4){
            String rollno=code;
            r="select code, "+rollno+" from "+sub+";";
        }
        else if(t==1)
            r="Select * from "+sub+";";
        else
            r="select * from "+sub+" where code='"+code+"';";
        System.out.println(r);
        Connection con = null;
        Statement st = null;
        String pass=new String();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/SOE","root","root");
            st = con.createStatement();
            
            Object[][] data=new Object[100][100];
            int i=0;
            String[] columns;
            if(t==1)
            columns = new String[]{
                "Date","RIT2014001","RIT2014002","RIT2014003","RIT2014004","RIT2014005","RIT2014006"
            };
            else if(t==2){
                columns = new String[]{
                    "Code","RIT2014001","RIT2014002","RIT2014003","RIT2014004","RIT2014005","RIT2014006"
                };
            }
            else{
                columns = new String[]{
                    "Date",code
                };
            }
            ResultSet rs=st.executeQuery(r);
            if(t==1||t==2){
                i=0;
                while(rs.next()){
                    if(t==1)
                    data[i][0]=rs.getString("date");
                    else data[i][0]=rs.getString("code");
                    data[i][1]=rs.getInt("RIT2014001");
                    data[i][2]=rs.getInt("RIT2014002");
                    data[i][3]=rs.getInt("RIT2014003");
                    data[i][4]=rs.getInt("RIT2014004");
                    data[i][5]=rs.getInt("RIT2014005");
                    data[i][6]=rs.getInt("RIT2014006");
                    i++;
                }
            }
            
            else if(t==3){
                i=0;
                while(rs.next()){
                    data[i][0]=rs.getString("date");
                    data[i][1]=rs.getInt(code);
                    i++;
                }
            }
            else if(t==4){
                i=0;
                while(rs.next()){
                    data[i][0]=rs.getString("code");
                    data[i][1]=rs.getInt(code);
                    i++;
                }
            }
            JTable table = new JTable(data, columns);
            
            if(i==0){
                JPanel panelerr=new JPanel();
                panelerr.setLayout(new FlowLayout());
                JLabel label=new JLabel("No Data exists or invalid Test code",JLabel.CENTER);
                label.setFont(label.getFont().deriveFont(32f));
                panelerr.add(label);
                JButton button=new JButton("PREVIOUS PAGE");
                button.setBounds(50,50,50,50);
                panelerr.add(button);
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        information_page back= new information_page(sub);
                    }
                });
                panel.add(panelerr);
            }
            
        //add the table to the frame
            if(i!=0)
            panel.add(new JScrollPane(table), BorderLayout.CENTER );
         
 //       this.setTitle("Table Example");
            System.out.println(i);
            }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Invalid Subject Code");
            information_page ob=new information_page(sub);
        }
        frame.add(panel);
        frame.setSize(800,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    /*    String str="soe_test",date="SOE1";
        Table table=new Table(str,date,2);*/
    }
    
}
