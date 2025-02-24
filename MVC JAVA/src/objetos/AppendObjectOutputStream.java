/*
NOMBRE: MOLINA LEON NOE MARCELINO
N.CONTROL: 20170752
MATERIA: INGENIERIA WEB
TEMA: MVC CON PERSISTENCIA DE OBJETOS
FECHA: 23/02/2025
DOCENTE: DR.CLEMENTE GARCIA GERARDO
*/
package objetos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author soule
 */
public class AppendObjectOutputStream extends ObjectOutputStream 
{
    public AppendObjectOutputStream(FileOutputStream arg0) throws IOException 
    {
        super(arg0);
        // TODO Auto-generated constructor stub
    }
    //This is a function that is default in ObjectOutputStream. It just writes the 
    //header to the file, by default. Here, we are just going to reset the 
    //ObjectOutputStream
    @Override
    public void writeStreamHeader() throws IOException
    {
        reset();
    }
}
