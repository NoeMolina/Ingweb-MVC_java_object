/*
NOMBRE: MOLINA LEON NOE MARCELINO
N.CONTROL: 20170752
MATERIA: INGENIERIA WEB
TEMA: MVC CON PERSISTENCIA DE OBJETOS
FECHA: 23/02/2025
DOCENTE: DR.CLEMENTE GARCIA GERARDO
*/
package mvc.java;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import objetos.AppendObjectOutputStream;
import objetos.Operacion;

public class data {

    private Operacion finded;
    private String filePath = "Operaciones.txt";

    public data() {
    }

    public boolean find(Operacion toSearch) {
        boolean cont = true;
        boolean fileExists = new File(filePath).exists();
        Operacion obj;
        try {
            if (!fileExists) {
                System.out.println("mvc.java.data.find() no existe el archivo");
                return false;
            }
            InputStream reader = new FileInputStream(filePath);
            ObjectInputStream obReader = new ObjectInputStream(reader);
            while (cont) {
                System.out.println("mvc.java.data.find() buscando");
                obj = (Operacion) obReader.readObject();
                cont = (obj != null);
                if (toSearch.getOperacion().equals(obj.getOperacion()) && toSearch.getValor() == obj.getValor()) {
                    finded = obj;
                    System.out.println("mvc.java.data.find() encotrado:" + finded.toString());
                    return true;
                }
            }

        } catch (EOFException e) {
            System.out.println("Se completo la lectura del archivo");
        } catch (Exception e) {
            System.out.println("Error al recuperar el Objeto " + e);
        }
        return false;

    }

    public void save(Object obj) {
        boolean fileExists = new File(filePath).exists();
        try {

            FileOutputStream writer = new FileOutputStream(filePath, true);
            ObjectOutputStream obWriter;
            if (!fileExists) {
                obWriter = new ObjectOutputStream(writer);
            } else {
                obWriter = new AppendObjectOutputStream(writer);
            }
            obWriter.writeObject(obj);

        } catch (Exception e) {
            System.out.println("Error al guardar el Objeto" + e);
        }
    }

    public void readObjet(String filePath) {
        boolean cont = true;
        Object obj;
        try {
            InputStream reader = new FileInputStream(filePath);
            ObjectInputStream obReader = new ObjectInputStream(reader);

            while (cont) {
                obj = obReader.readObject();
                if (obj != null) {
                    System.out.println(obj.toString());
                } else {
                    cont = false;
                }
            }
        } catch (EOFException e) {
            System.out.println("Se completo la lectura del archivo");
        } catch (Exception e) {
            System.out.println("Error al recuperar el Objeto " + e);
        }
    }

    public Operacion getFind() {
        return finded;
    }
}
