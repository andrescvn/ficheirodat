/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exeproxecto;

import java.io.Serializable;

/**
 *
 * @author acomesanavila
 */
public class Alumno implements Serializable,Comparable{
    private String nome;
    private int nota;

    public Alumno() {
    }

    public Alumno(String nome, int nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nome=" + nome + ", nota=" + nota + '}';
    }

    @Override
    public int compareTo(Object o) {
                Alumno al = (Alumno) o;
        if (this.nome.compareToIgnoreCase(al.getNome()) == 0) {
            return 0;
        } else if (this.nome.compareToIgnoreCase(al.getNome()) > 0) {
            return 1;
        } else {
            return -1;
        }
    }

    
}
