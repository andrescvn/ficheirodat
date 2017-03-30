/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exeproxecto;

import javax.swing.JOptionPane;

/**
 *
 * @author acomesanavila
 */
public class Exeproxecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Metodos metod= new Metodos();
        int select;
        do{
          select = Integer.parseInt(JOptionPane.showInputDialog("1. Escribir \n 2. Leer \n 3. Ordear \n 0. Sair"));
          switch(select){
              
              case 1:metod.engadir("suspensos.dat", "aprobados.dat");
              break;
              case 2:metod.lerObxetos("suspensos.dat","aprobados.dat");
              break;
              case 3:metod.ordenar();
                      
              
          }  
            
        }while(select!=0);

    }
    
}
