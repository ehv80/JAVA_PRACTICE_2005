/*
 * En algunas ocasiones necesitaremos no perder la instancia de un objeto cuando
 * termine el programa;
 * es decir, precisaremos guardar la información contenida en el objeto. Para
 * esto se usan los objetos persistentes.
 * Para programar un objeto persistente debemos implementar la interfaz
 * Serializable del paquete java.io.
 * Simplemente declaramos la clase como:
 * public class ObjetoPersistente implements Serializable
 * Una vez hecho esto, debemos crear un método que se encargue de grabar el
 * objeto a través del método WriteObject()
 * de ObjectOutputStream. Para ejemplificar, implementaremos el código de la
 * clase ObjetoPersistente.
 */

import java.io.*;

public class ObjetoPersistente implements Serializable {
    /* atributos de clase */
    String nombre;
    String apellido;
    int edad;

    /* Ahora lo que haremos será implementar el método guardarObjeto() */
    public void guardarObjeto() {
        try {
            /* Creamos el archivo */
            FileOutputStream archivo = new FileOutputStream(
                    "E:\\Users\\ehv80\\Documentos\\Programacion_en_Lenguaje_Java\\JAVA_PRACTICE_2005\\objeto.ser");
            /* Creamos un Stream de Salida de Objetos */
            ObjectOutputStream out = new ObjectOutputStream(archivo);
            /* Grabamos éste (this) objeto */
            out.writeObject(this);
            out.flush();
            /* Cerramos el Stream de Salida de Objetos */
            out.close();
            /* Cerramos el archivo */
            archivo.close();
        } catch (IOException ex) {
            System.err.println("Error al grabar un Objeto: " + ex.getMessage());
            System.err.println("Detalle de la pila de llamadas: ");
            ex.printStackTrace();
        }
    }

    /* Constructor con parámetros */
    public ObjetoPersistente(String n, String a, int e) {
        this.nombre = n;
        this.apellido = a;
        this.edad = e;
    }

    /*
     * Ahora vamos a crear el método leerObjeto para que pueda leer el objeto
     * grabado desde el
     * archivo
     */
    public void leerObjeto() {
        try {
            FileInputStream archivo = new FileInputStream(
                    "E:\\Users\\ehv80\\Documentos\\Programacion_en_Lenguaje_Java\\JAVA_PRACTICE_2005\\objeto.ser");
            /* Creamos un Stream de Entrada de Objetos */
            ObjectInputStream in = new ObjectInputStream(archivo);
            /*
             * Leemos el objeto y como el método readObject() devuelve un Object, entonces
             * lo convertimos a ObjetoPersistente
             * y lo referenciamos con op
             */
            ObjetoPersistente op = (ObjetoPersistente) in.readObject();
            /* Cerramos el Stream de Entrada de Objetos */
            in.close();
            /* Cerramos el archivo */
            archivo.close();
        } catch (IOException ex) {
            System.err.println("Error al leer el Objeto Persistente desde el archivo: " + ex.getMessage());
            System.err.println("Detalle de la pila de llamadas: ");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.err.println(
                    "Error al leer el Objeto Persistente desde el archivo (Excepción por Clase No Encontrada): "
                            + ex.getMessage());
            System.err.println("Detalle de la pila de llamadas: ");
            ex.printStackTrace();
        }
    }

    /*
     * Antes de modificar el main, haremos la sobrecarga del método toString() para
     * mostrar cómo quedó
     * instanciado el objeto al final de la ejecución del método main
     */
    public String toString() {
        String fraseRetorno = "Instanciado con: " + this.nombre + " " + this.apellido + " de " + this.edad
                + " años de edad.";
        return fraseRetorno;
    }

    /* Para probarlo crearemos el método main */
    public static void main(String[] args) {
        ObjetoPersistente op = new ObjetoPersistente("Alejandro", "Gorosito", 26);
        op.guardarObjeto();
        op.leerObjeto();
        System.out.println(op.toString());
    }
}