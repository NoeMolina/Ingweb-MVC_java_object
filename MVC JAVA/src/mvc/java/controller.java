/*
NOMBRE: MOLINA LEON NOE MARCELINO
N.CONTROL: 20170752
MATERIA: INGENIERIA WEB
TEMA: MVC CON PERSISTENCIA DE OBJETOS
FECHA: 23/02/2025
DOCENTE: DR.CLEMENTE GARCIA GERARDO
*/
package mvc.java;

import java.awt.event.*;
import objetos.Operacion;

public class controller implements ActionListener {

    private view vista;
    private model modelo;

    public controller(view vista, model modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double resultado = 0;
        if (e.getSource() == vista.getBtnFactorial()) {
            resultado = modelo.calcula(new Operacion("Factorial", vista.getNumero()));
            System.out.println("mvc.java.controller.actionPerformed() Resultado: " + resultado);
            vista.showOperation(resultado);
            return;
        }
        if (e.getSource() == vista.getBtnFibonacci()) {
            resultado = modelo.calcula(new Operacion("Fibonacci", vista.getNumero()));
            vista.showOperation(resultado);
            return;
        }
        if (e.getSource() == vista.getBtnAckerman()) {
            resultado = modelo.calcula(new Operacion("Ackerman", vista.getNumero()));
            vista.showOperation(resultado);
            return;
        }
        if (e.getSource() == vista.getBtnLimpiar()) {
            vista.Limpiar();
            return;
        }

    }
}
