/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exeproxecto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author acomesanavila
 */
public class Metodos {

    Scanner sc;
    ArrayList<Alumno> apro = new ArrayList();
    PrintWriter engado;
    FileWriter fich;

    public void lerObxetos(String nomeFich, String nomeFichA) {
        ObjectInputStream leer = null;
        ObjectInputStream leerA = null;
        Alumno aux = null;
        Alumno auxA = null;
        try {
            leer = new ObjectInputStream(new FileInputStream(nomeFich));
            leerA = new ObjectInputStream(new FileInputStream(nomeFichA));
            aux = (Alumno) leer.readObject();
            auxA = (Alumno) leerA.readObject();
            while (aux != null && auxA != null) {
                apro.add(aux);
                System.out.println(auxA.toString());
                System.out.println(aux.toString());
                aux = (Alumno) leer.readObject();
                auxA = (Alumno) leerA.readObject();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (leer != null && leerA != null) {
                try {
                    leerA.close();
                    leer.close();
                } catch (IOException ex) {
                    Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

    public void engadir(String nomeFich, String nomeFichA) {
        ObjectOutputStream fichero = null;
        ObjectOutputStream fich = null;
        try {
            fich = new ObjectOutputStream(new FileOutputStream(nomeFichA));
            fichero = new ObjectOutputStream(new FileOutputStream(nomeFich));
            for (int i = 0; i < 3; i++) {
                Alumno al = new Alumno(JOptionPane.showInputDialog(null, "Introduce o nome"), Integer.parseInt(JOptionPane.showInputDialog("introduce as notas")));
                if (al.getNota() >= 5) {
                    Alumno alc = new Alumno(JOptionPane.showInputDialog(null, "Introduce o nome"), Integer.parseInt(JOptionPane.showInputDialog("introduce as notas")));
                    fich.writeObject(alc);
                }
                fichero.writeObject(al);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fich != null && fichero != null) {
                try {
                    fichero.close();
                    fich.close();
                } catch (IOException ex) {
                    Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void ordenar() {
        Collections.sort(apro);
    }

}
