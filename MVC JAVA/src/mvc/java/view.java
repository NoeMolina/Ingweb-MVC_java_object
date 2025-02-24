/*
NOMBRE: MOLINA LEON NOE MARCELINO
N.CONTROL: 20170752
MATERIA: INGENIERIA WEB
TEMA: MVC CON PERSISTENCIA DE OBJETOS
FECHA: 23/02/2025
DOCENTE: DR.CLEMENTE GARCIA GERARDO
*/
package mvc.java;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class view extends JFrame {

    private JLabel lblResultado;
    private JTextField txtNumero;
    private JButton btnFactorial, btnFibonacci, btnAckerman, btnLimpiar;

    public view() {
        super("Calculador metodos Numericos");
        MakeView();
    }

    private void MakeView() {
        setLayout(new GridLayout(0, 2));
        setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        UIManager.put("Label.font", new FontUIResource(new Font("Dialog", Font.PLAIN, 16)));
        UIManager.put("Button.font", new FontUIResource(new Font("Dialog", Font.BOLD, 16)));
        UIManager.put("TextField.font", new FontUIResource(new Font("Dialog", Font.PLAIN, 16)));
        
        add(new JLabel("Número", JLabel.CENTER));
        txtNumero = new JTextField();
        add(txtNumero);
        add(new JLabel("Importe", JLabel.CENTER));
        lblResultado = new JLabel("", JLabel.CENTER);
        add(lblResultado);
        btnFactorial = new JButton("Factorial");
        add(getBtnFactorial());
        btnFibonacci = new JButton("Fibonacci");
        add(getBtnFibonacci());
        btnAckerman = new JButton("Ackerman");
        add(getBtnAckerman());
        btnLimpiar = new JButton("Limpiar");
        add(getBtnLimpiar());

        setVisible(true);
    }

    public int getNumero() {
        int numero = 0;
        try {
            numero = Integer.parseInt(txtNumero.getText());
        } catch (Exception e) {
            System.out.println("mvc.java.view.getNumero()" + e);
        }

        return numero;
    }

    public void showOperation(double Resultado) {
        lblResultado.setText(Resultado + "");
    }

    public void setListenners(controller c) {
        getBtnFactorial().addActionListener(c);
        getBtnFibonacci().addActionListener(c);
        getBtnAckerman().addActionListener(c);
        getBtnLimpiar().addActionListener(c);
    }
    
    public void Limpiar(){
        txtNumero.setText("");
        lblResultado.setText("");
    }
    
    public JButton getBtnFactorial() {
        return btnFactorial;
    }

    public JButton getBtnFibonacci() {
        return btnFibonacci;
    }

    public JButton getBtnAckerman() {
        return btnAckerman;
    }

    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }

}
