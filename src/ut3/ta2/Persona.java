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
public class Persona implements IPersona{
    
    String documento;
    String primerNombre;
    String segundoNombre;
    String primerApellido;
    String segundoApellido;
    Double sueldoMinimo;
    Boolean contratado;
    
    public Persona(String pDocumento, String pPrimerNombre, String pSegundoNombre, String pPrimerApellido, String pSegundoApellido, Double pSueldoMinimo, Boolean pContratado){
        setDocumento(pDocumento);
        setPrimerNombre(pPrimerNombre);
        setSegundoNombre(pSegundoNombre);
        setPrimerApellido(pPrimerApellido);
        setSegundoApellido(pSegundoApellido);
        setSueldoMinimo(pSueldoMinimo);
        setContratado(pContratado);
    }
    
    public Persona(){}

    @Override
    public String getDocumento() {
        return documento;
    }

    @Override
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    @Override
    public String getPrimerNombre() {
        return primerNombre;
    }

    @Override
    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    @Override
    public String getSegundoNombre() {
        return segundoNombre;
    }

    @Override
    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    @Override
    public String getPrimerApellido() {
        return primerApellido;
    }

    @Override
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    @Override
    public String getSegundoApellido() {
        return segundoApellido;
    }

    @Override
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    @Override
    public Double getSueldoMinimo() {
       return sueldoMinimo;
    }

    @Override
    public void setSueldoMinimo(Double sueldo) {
        this.sueldoMinimo = sueldo;
    }

    @Override
    public Boolean getContratado() {
        return contratado;
    }

    @Override
    public void setContratado(Boolean contratado) {
        this.contratado = contratado;
    }
    
}
