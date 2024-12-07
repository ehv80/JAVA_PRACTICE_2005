
/* Supongamos que estamos desarrollando una aplicación para abrir archivos con código fuente Java,
 * por lo tanto, queremos que se mustren sólo los archivos con extención .java. A tal efecto, haremos
 * primero la clase Filtro. Por otra parte, debemos tener en cuenta que, para que un archivo sea aceptado,
 * se llama al método accept() del filtro, el cuál devuelve true cuando es aceptado, o false cuando no lo es.
 * Entonces el código de la clase Filtro es:
 */
import java.io.File;
import javax.swing.filechooser.FileFilter;

public class Filtro extends FileFilter {
    /* FileFilter es Abstract y nos obliga a implementar los siguientes métodos */
    public String getDescription() {
        return ("Filtro de archivos de java (*.java)");
    }

    public boolean accept(File f) {
        /*
         * Si es un directorio lo aceptamos para que éstos siempre sean mostrados;
         * de lo contrario, el usuario no podrá navegar entre los subdirectorios
         */
        if (f.isDirectory()) {
            return (true);
        }
        /* Tomamos el nombre del archivo */
        String s = f.getName();
        /* Preguntamos dónde está el último punto */
        int i = s.lastIndexOf('.');
        if (i > 0 && i < (s.length() - 1)) {
            String extension = s.substring(i + 1).toLowerCase();
            if (extension.compareTo("java") == 0) {
                return true;
            }
        }
        return false;
    }
}