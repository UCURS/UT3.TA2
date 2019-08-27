/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut3.ta2;

/**
 *
 * @author Rowinns
 */
public class Nodo<E> implements INodo<E>{
    private final Comparable etiqueta;
    private E dato;
    private INodo<E> siguiente;

    public Nodo(Comparable etiqueta, E dato) {
        this.etiqueta = etiqueta;
        this.dato = dato;
    }

    @Override
    public E getDato() {
        return dato;
    }

    @Override
    public void setDato(E dato) {
        this.dato = dato;
    }

    @Override
    public INodo<E> getSiguiente() {
        return siguiente;
    }
    
    @Override
    public void setSiguiente(INodo<E> siguiente) {
        this.siguiente = siguiente;
    }
    
    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }
    
    @Override
    public void imprimir() {
        System.out.println(dato.toString());
    }
    
    @Override
    public void imprimirEtiqueta() {
        System.out.println(this.etiqueta);
    }
    
    public Nodo<E> clonar() {
        return new Nodo<>(this.etiqueta, this.dato);
    }
    
    @Override
    public boolean equals(INodo<E> unNodo) {
        return this.dato.equals(unNodo.getDato());
    }

    @Override
    public int compareTo(Comparable etiqueta) {
        return this.getEtiqueta().compareTo(etiqueta);    
    }
}
