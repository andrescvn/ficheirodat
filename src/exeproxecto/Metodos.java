/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exeproxecto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author acomesanavila
 */
public class Metodos {

    Scanner sc;
    ArrayList<Alumno> apro = new ArrayList();
    PrintWriter engado;
    FileWriter fich;

    public void lerObxetos() {
        String[] aux;
        try {
            sc = new Scanner(new File("archivo.dat"));
            while (sc.hasNextLine()) {
                aux = sc.nextLine().split(",");
                Alumno al = new Alumno(aux[0], Integer.parseInt(aux[1]));
                System.out.println(al);
                if (al.getNota() >= 5) {
                    apro.add(al);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
            sc.close();
        }
    }

    public void engadir() {
        try {
            engado = new PrintWriter(new FileWriter("aprobados.dat", true));
            for (int i = 0; i < apro.size(); i++) {
                engado.println(apro.get(i).getNome()+","+apro.get(i).getNota());
            }
        } catch (IOException ex) {
            System.out.println("erro:" + ex.getMessage());
        } finally {
            engado.close();
        }
    }
    public void ordenar(){
        Collections.sort(apro);
    }

}
