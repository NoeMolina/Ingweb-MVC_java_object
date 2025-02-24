/*
NOMBRE: MOLINA LEON NOE MARCELINO
N.CONTROL: 20170752
MATERIA: INGENIERIA WEB
TEMA: MVC CON PERSISTENCIA DE OBJETOS
FECHA: 23/02/2025
DOCENTE: DR.CLEMENTE GARCIA GERARDO
*/
package mvc.java;

import objetos.Operacion;

public class model {

    data datos;

    public model(data datos) {
        this.datos = datos;
    }

    public double calcula(Operacion operacion) {
        if (datos.find(operacion)) {
            return datos.getFind().getResultado();
        } else {
            realiza(operacion);
        }
        return operacion.getResultado();
    }

    private void realiza(Operacion operacion) {
        double resultado = 0;
        if (operacion.getOperacion().equals("Factorial")) {
            resultado = CalFactorial(operacion.getValor());

        } else if (operacion.getOperacion().equals("Fibonacci")) {
            resultado = CalFibonacci(operacion.getValor());
        } else if (operacion.getOperacion().equals("Ackerman")) {
            try {
            resultado = CalAckerman(operacion.getValor(), 2);
            } catch (StackOverflowError e) {
                System.out.println("mvc.java.model.realiza(): stack lleno");
                resultado = -1;
            }
        }
        System.out.println("mvc.java.model.realiza() resultado: " + resultado);
        operacion.setResultado(resultado);
        datos.save(operacion);
    }

    private double CalFactorial(int valor) {
        double result = 1;
        for (int i = 1; i < valor; i++) {
            result *= i;
        }
        return result;
    }

    private double CalFibonacci(int valor) {
        if (valor <= 1) {
            return valor;
        } else {

            return CalFibonacci(valor - 2) + CalFibonacci(valor - 1);
        }
    }

    private int CalAckerman(int m, int n) {

        if (m == 0) {
            return n + 1;
        } else if (n == 0) {
            return CalAckerman(m - 1, 1);
        } else {
            return CalAckerman(m - 1, CalAckerman(m, n - 1));
        }

    }
}
