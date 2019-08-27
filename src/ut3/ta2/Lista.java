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
public class Lista<E> implements ILista<E> {
    
    protected INodo<E> primero;

    public Lista() {
        primero = null;
    }
        
    @Override
    public void insertar(INodo nodo) {
         if (esVacia()) {
            primero = nodo;
        } else {
            INodo<E> aux = primero;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nodo);
        }
    }

    @Override
    public INodo buscar(Comparable clave) {
        if (esVacia()) {
            return null;
        } else {
            INodo<E> aux = primero;
            while (aux != null) {
                if (aux.getEtiqueta().equals(clave)) {
                    return aux;
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if (esVacia()) {
            return false;
        }
        if (primero.getSiguiente() == null) {
            if (primero.getEtiqueta().equals(clave)) {
                primero = null;
                return true;
            }
        }
        INodo<E> aux = primero;
        if (aux.getEtiqueta().compareTo(clave) == 0) {
            //Eliminamos el primer elemento
            INodo<E> temp = aux.getSiguiente();
            primero = temp;
            return true;
        }
        while (aux.getSiguiente() != null) {
            if (aux.getSiguiente().getEtiqueta().equals(clave)) {
                INodo<E> temp = aux.getSiguiente();
                aux.setSiguiente(temp.getSiguiente());
                return true;

            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    @Override
    public String imprimir() {
         String aux = "";
        if (!esVacia()) {
            INodo<E> temp = primero;
            while (temp != null) {
                temp.imprimirEtiqueta();
                temp = temp.getSiguiente();
            }
        }
        return aux;
    }

    @Override
    public String imprimir(String separador) {
        String aux = "";
        if (esVacia()) {
            return "";
        } else {
            INodo<E> temp = primero;
            aux = "" + temp.getEtiqueta();
            while (temp.getSiguiente() != null) {
                aux = aux + separador + temp.getSiguiente().getEtiqueta();
                temp = temp.getSiguiente();
            }
        }
        return aux;
    }

    @Override
    public int cantElementos() {
        int contador = 0;
        if (esVacia()) {
            System.out.println("Cantidad de elementos 0.");
            return 0;
        } else {
            INodo aux = primero;
            while (aux != null) {
                contador++;
                aux = aux.getSiguiente();
            }
        }
        return contador;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }

    @Override
    public INodo getPrimero() {
        return primero;
    }

        public INodo<E> quitar(Comparable clave) {
        if (esVacia()) {
            return null;
        }
        if (primero.getSiguiente() == null) {
            if (primero.getEtiqueta().equals(clave)) {
                Nodo<E> aDevolver = new Nodo (primero.getEtiqueta(),primero.getDato());
                aDevolver.setSiguiente(null);
                primero = null;
                return aDevolver ;
            }
        }
        INodo<E> aux = primero;
        if (aux.getEtiqueta().compareTo(clave) == 0) {
            //Eliminamos el primer elemento
            INodo<E> temp = aux.getSiguiente();
            
            primero = temp;
            temp.setSiguiente(null);
            return temp ;
        }
        while (aux.getSiguiente() != null) {
            if (aux.getSiguiente().getEtiqueta().equals(clave)) {
                INodo<E> temp = aux.getSiguiente();
                aux.setSiguiente(temp.getSiguiente());
                temp.setSiguiente(null);

                return temp;

            }
            aux = aux.getSiguiente();
        }
        return null;
    }
    
    
    
}
