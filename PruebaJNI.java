/*
 * NUESTRA PRIMERA CLASE CON MÉTODOS NATIVOS
 * Lo que hacemos a través de la interfaz JNI es llamar a un método nativo desde
 * nuestra clase para que entienda
 * que es un método que está escrito fuera del programa y en otro lenguaje de
 * programación.
 * Para entender este tema es necesario poseer un conocimiento, mínimo, de C.
 * La estructura general del programa es la que se ve en la Figura 1
 * 
 * -----------------------|-------------[ Rutinas en Assembler integradas en C ]
 * -----------------------|-------------[ Rutinas C ]
 * [ Programa Java ]------|-------------[ Clases en C++ ]
 * -----------------------|-------------[ Debugger C ]
 * -----------------------|-------------[ Manejador de excepciones C ]
 * 
 * Figura 1. Estructura del programa con interfaz JNI de Java a C.
 * 
 * De igual manera, podemos aprovechar la interfaz JNI para acceder desde C a
 * Java
 * como lo muestra la Figura 2.
 * 
 * ---------------------------|-------------[ Bibliotecas Java ]
 * [ Programa C ]-------------|-------------[ Clases y Métodos Java ]
 * ---------------------------|-------------[ Máquina Virtual de Java ]
 * 
 * Figura 2. Estructura del programa con interfaz JNI de C a Java.
 * 
 * Entonces resumiendo, una aplicación que usa la interfaz JNI se puede
 * interpretar como lo
 * muestra la Figura 3.
 * C/C++ ----------------------------------------------- Java
 * [ Funciones ] ----------------------------------- [ Excepciones ]
 * [ Clases ] ------------ [ Interfaz JNI ]--------- [ Clases ]
 * [ Bibliotecas ] --------------------------------- [ Máquina Virtual ]
 * 
 * Figura 3. Estructura de la aplicación.
 * Lo primero que vamos a hacer es escribir el código de nuestra clase, la cual, 
 * va a declarar un método nativo a través de la palabra reservada native.
 */

//package prueba; // comentado para evitar error en tiempo de ejecución paquete y clase no encontrado

public class PruebaJNI {
    /* Constructor por defecto. Carga la biblioteca dinámica pruebabiblioteca */
    public PruebaJNI() {
        System.loadLibrary("pruebabiblioteca");
    }

    /*
     * Al estar declarado como native sabemos que no está implementado en código
     * Java, sinó en otro Lenguaje de Programación: C
     */
    public native void mostrarMensaje();

    /*
     * PARÁMETROS
     * Ahora compliquemos un poco más las cosas creando otro método nativo, pero en
     * este caso, que reciba dos parámetros y
     * devuelva un resultado en PruebaJNI.java
     * El método que vamos a agregar será el siguiente:
     */
    public native float multiplicar(float a, int b);

    /*
     * En el ejemplo vemos que está presente sólo la declaración del método nativo y
     * que el código está escrito en otro Lenguaje de Programación fuera de nuestras
     * fuentes Java.
     */
    /*
     * Para terminar con la clase vamos a llamar desde el método main al método
     * nativo, es decir, vamos a usarlo. Entonces nuestra clase quedará:
     */
    public static void main(String[] args) {
        /* Creamos la instancia de PruebaJNI */
        PruebaJNI p = new PruebaJNI();
        /* Llamamos al método nativo mostrarMensaje() */
        p.mostrarMensaje();
        p.multiplicar(45, 3);
    }
}
/*
 * El código C que implementa el método debe ser compilado en una biblioteca
 * dinámica y cargado en la clase Java que lo necesite. Esta carga mapea la
 * implementación del método nativo sobre su definición.
 * Veamos, a partir de este momento, el código correspondiente a la carga de la
 * biblioteca dinámica; en este caso particular, la biblioteca recibe el nombre
 * de pruebabiblioteca.
 * Lo que hará el sistema Java será ejecutar un bloque de código estático de la
 * Clase cuando la cargue:
 * System.LoadLibrary("pruebabiblioteca");
 * Como vemos, para la clase es igual que cualquier otro método. Una vez
 * terminada la clase, lo que debemos hacer es compilarla para obtener el class,
 * o sea el
 * bytecode, ejecutando el comando: javac PruebaJNI.java
 * Si ahora probamos a ejecutar la clase, con el comando: java PruebaJNI,
 * nos arroja el siguiente error:
 *
 * java.lang.UnsatisfiedLinkError: no pruebabiblioteca in java.library.path
 * 
 * Es decir que no podemos cargar la biblioteca dinámica de nombre
 * pruebabiblioteca
 * porque no está en el java.library.path. El concepto es similar al de
 * classpath, solo que este camino no es el de las clases, sino el de las
 * bibliotecas.
 */
/*
 * CREAR LA BIBLIOTECA
 * Lo que debemos hacer ahora es usar el comando javah para obtener
 * el archivo de cabeceras, comúnmente llamado headers,
 * del Lenguaje de Programación C. Este archivo nos dará los lineamientos
 * de cómo debemos escribir el código en el Lenguaje C. Una vez ejecutado
 * el comando javah quedará generado el archivo PruebaJNI.h
 * que se verá de la siguiente manera:
 * 
 * Nota:
 * ¿javah PruebaJNI.java?
 * En JDK23 no existe javah: no se reconoce como un comando interno o externo,
 * programa o archivo por lotes ejecutable
 * Se crea el archivo manualmente: PruebaJNI.h en el mismo directorio
 */