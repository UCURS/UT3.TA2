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
public class UT3TA2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        Persona oPer1 = new Persona("55555","Juan","Jose","Rodriguez","Perez",9000.0,true);
//        Persona oPer2 = new Persona("44444","Maria","Antonia","Gonzalez","Hills",15000.0,true);
//        Persona oPer3 = new Persona("33333","Jose","Gervasio","Artigas","Thimss",30000.0,false);
//        Persona oPer4 = new Persona("22222","Lucia","Lulu","Pepe","Gits",50000.0,true);
//        Persona oPer5 = new Persona("11111","Pedro","Tito","Toro","Riff",12000.0,false);
//        // TODO code application logic here
//        Lista list = new Lista();
//        INodo nod1 = new Nodo(1, oPer1);
//        INodo nod2 = new Nodo(2, oPer2);
//        INodo nod3 = new Nodo(3, oPer3);
//        INodo nod4 = new Nodo(4, oPer4);
//        INodo nod5 = new Nodo(5, oPer5);
//        list.insertar(nod4);
//        list.insertar(nod1);
//        list.insertar(nod2);
//        list.insertar(nod5);
//        list.insertar(nod3);
//        list.imprimir();

        EmpresaReclutadora empresa = new EmpresaReclutadora();
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/altas.txt");
        String[] linea = new String[5];
        for (int i = 0; i < lineas.length; i++) {
            linea = lineas[i].split(",", -1);
            Persona unaPersona = new Persona(linea[0], linea[1], linea[2], linea[3], linea[4], Double.parseDouble(linea[5]), "1".equals(linea[6]));
            INodo<Persona> unNodo = new Nodo(unaPersona.documento, unaPersona);
            empresa.insertarPersona(unaPersona);

        }
        System.out.println("Sueldos" + empresa.calcularCostoTotalDeRRHH()); //615056.3899999999

        INodo<IPersona> aux;
        ManejadorArchivosGenerico ma = new ManejadorArchivosGenerico();
        lineas = ManejadorArchivosGenerico.leerArchivo("src/contratos.txt");
        for (int i = 0; i < lineas.length; i++) {
            aux = empresa.getListaPersonas().buscar(lineas[i]);
            aux.getDato().setContratado(true);
        }
        System.out.println("Sueldos:" + empresa.calcularCostoTotalDeRRHH()); //615056.3899999999
        empresa.imprimirPersonas();
//        EmpresaReclutadora 
//        ILista<IPersona> lista = new Lista<>();
//        INodo<IPersona> aux;
//        ManejadorArchivosGenerico ma = new ManejadorArchivosGenerico();
//        String[] lineas = ManejadorArchivosGenerico.leerArchivo("contratos.txt");
//        for (int i = 0; i < lineas.length; i++) {
//            aux = lista.buscar(lineas[i]);
//            aux.getDato().setContratado(true);
//        }
        System.out.println("Elimino a la persona cedula:830741");
        empresa.eliminarDeEmpresa("830741");
        System.out.println("Los eliminados tenian de sueldo:" +empresa.valorEconomicoPersonasEliminadas());
    }

}
