/*
NOMBRE: MOLINA LEON NOE MARCELINO
N.CONTROL: 20170752
MATERIA: INGENIERIA WEB
TEMA: MVC CON PERSISTENCIA DE OBJETOS
FECHA: 23/02/2025
DOCENTE: DR.CLEMENTE GARCIA GERARDO
*/
package objetos;

import java.io.Serializable;

public class Operacion implements Serializable{
    private String operacion;
    private int valor;
    private double resultado;
    
    
    public Operacion(String operacion, int valor){
        this.operacion = operacion;
        this.valor = valor;
    }
    
    public void setResultado(double resultado){
        this.resultado = resultado;
    }
    /**
     * @return the operacion
     */
    public String getOperacion() {
        return operacion;
    }

    /**
     * @return the valor
     */
    public int getValor() {
        return valor;
    }

    /**
     * @return the resultado
     */
    public double getResultado() {
        return resultado;
    }

    @Override
    public String toString() {
        return ("Numero: " +valor+" Operacion: "+operacion+" Resultado: "+resultado);
    }
    
    
    
}
