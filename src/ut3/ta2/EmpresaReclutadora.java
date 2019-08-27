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
public class EmpresaReclutadora implements IEmpresaReclutadora{
    
    String direccion;
    String telefono;
    String nombre;
    Lista listaPersonas;
    Lista listaPersonasEliminadas;
    
    public EmpresaReclutadora(){
        listaPersonas = new Lista();
        listaPersonasEliminadas = new Lista();
    }

    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String getTelefono() {
        return telefono;
    }

    @Override
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public ILista getListaPersonas(){
        return listaPersonas;
    }

    @Override
    public void insertarPersona(IPersona unaPersona) {
        INodo<Persona> oNodo = new Nodo(unaPersona.getDocumento(),unaPersona);
        this.listaPersonas.insertar(oNodo);
    }

    @Override
    public boolean eliminar(String documento) {
         return this.listaPersonas.eliminar(documento);
    }

    @Override
    public String imprimirPersonas() {
        return this.listaPersonas.imprimir();
    }

    @Override
    public String imprimirSeparador(String separador) {
        return this.listaPersonas.imprimir(separador);
    }

    @Override
    public Boolean modificarSueldo(String clave, Double sueldo) {
        INodo <Persona> persona1 = this.listaPersonas.buscar(clave);
        if (persona1!= null){
            persona1.getDato().setSueldoMinimo(sueldo);
            return true; }
        else
            return false;
    }

    @Override
    public Integer contratarPersona(String clave) {
        INodo <Persona> persona1 = this.listaPersonas.buscar(clave);
        if (persona1!= null){
            persona1.getDato().setContratado(Boolean.TRUE);
            return 1; }
        else
            return 0;
    }

    @Override
    public IPersona buscarPorCodigo(String documento) {
        INodo<Persona> oPersona = this.listaPersonas.buscar(documento);
        return oPersona.getDato();
    }

    @Override
    public void listarOrdenadoPorNombreYApellido() {
        ILista<IPersona> newlist = new ListaOrdenada<>();
        INodo<IPersona> aux = listaPersonas.getPrimero();
        while (aux != null) {
            if (aux.getDato().getPrimerNombre().equals(nombre)) {
                INodo<IPersona> aux2 = new Nodo<>(aux.getDato().getPrimerNombre() + 
                        aux.getDato().getPrimerApellido(), aux.getDato());
                newlist.insertar(aux2);
            }
            aux = aux.getSiguiente();
        }
    }

    @Override
    public IPersona buscarPorNombre(String nombre) {
         if (listaPersonas.esVacia()) {
            return null;
        } else {
            INodo<IPersona> aux = listaPersonas.getPrimero();
            while (aux != null) {
                if (aux.getDato().getPrimerNombre().equals(nombre)) {
                    return aux.getDato();
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }

@Override
    public Double calcularCostoTotalDeRRHH() {
        double cont = 0;
        if (!listaPersonas.esVacia()) {
            INodo<IPersona> aux = listaPersonas.getPrimero();
            while (aux != null) {
                if(aux.getDato().getContratado()){
                    cont+=aux.getDato().getSueldoMinimo();
                    aux = aux.getSiguiente();
                }else{
                aux = aux.getSiguiente();
                }
            }
        }
        return cont;
    }

    @Override
    public ILista getListaPersonasConTrabajo() {
        ILista<IPersona> listaContratados = new Lista<>();
        if (!listaPersonas.esVacia()) {
            INodo<IPersona> aux = listaPersonas.getPrimero();
            while (aux != null) {
                if (aux.getDato().getContratado()) {
                    listaContratados.insertar(aux);
                }
                aux = aux.getSiguiente();
            }
        }
        return listaContratados;
    }
    
    public void eliminarDeEmpresa(Comparable clave){
        listaPersonasEliminadas.insertar(this.listaPersonas.quitar(clave));
    }

    public double valorEconomicoPersonasEliminadas (){
        double cont = 0;
        if (!listaPersonasEliminadas.esVacia()) {
            INodo<IPersona> aux = listaPersonasEliminadas.getPrimero();
            while (aux != null) {
                if(aux.getDato().getContratado()){
                    cont+=aux.getDato().getSueldoMinimo();
                    aux = aux.getSiguiente();
                }else{
                aux = aux.getSiguiente();
                }
            }
        }
        return cont;
    }
    
}
