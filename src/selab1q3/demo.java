/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package selab1q3;

/**
 *
 * @author Pri_D
 */
public class demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Object[][] data = new Object[4][4];
        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                data[i][j]=1;
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<4;j++){
                System.out.println(data[i][j]);
            }
        }
    }
    
}
