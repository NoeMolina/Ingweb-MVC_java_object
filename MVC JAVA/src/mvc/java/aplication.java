/*
NOMBRE: MOLINA LEON NOE MARCELINO
N.CONTROL: 20170752
MATERIA: INGENIERIA WEB
TEMA: MVC CON PERSISTENCIA DE OBJETOS
FECHA: 23/02/2025
DOCENTE: DR.CLEMENTE GARCIA GERARDO
*/
package mvc.java;

public class aplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        data datos =  new data();
        model modelo = new model(datos);
        view vista = new view();
        controller controlador = new controller(vista, modelo);
        vista.setListenners(controlador);
    }
    
}
