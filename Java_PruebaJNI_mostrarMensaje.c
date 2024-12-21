/*
 * Este archivo debería ser generado por el comando
 * javah -stubs PruebaJNI
 * pero en JDK23 javah ya no existe más!
 */
/*
 * Este archivo puede ser llamado: PruebaJNI.c
 */
/* Si tenemos algún problema al generar el archivo, lo que podemos hacer es
 * simplemente tomar el archivo de cabecera PruebaJNI.h y convertirlo nosotros mismos.
 * El archivo Java_PruebaJNI_mostrarMensaje.c entonces debe verse así:
 */

/* Incluímos el archivo de cabecera generado PruebaJNI.h */
#include <PruebaJNI.h>
JNIEXPORT void JNICALL Java_PruebaJNI_mostrarMensaje(JNIEnv *env, jobject obj)
{
    /* Modificamos la función Java_PruebaJNI_mostrarMensaje() y le agregamos
     *  nuestro código C, por lo que quedará:
     */
    print("Este es nuestro primer método nativo con la interfaz JNI!!!\n");
}
/* Lo que sigue es ver cómo se genera la biblioteca en los dos sistemas operativos más populares: Windows y Linux/Unix
 *
 * En Unix:
 * El comando será:
 *
 * #> cc -G Java_PruebaJNI_mostrarMensaje.c -o pruebabiblioteca.so
 *
 * En caso de que el compilador no encuentre los ficheros de cabecera, se puede utilizar el flag -I para indicarle el camino de búsqueda,
 * por ejemplo:
 *
 * #> cc -G -I$JAVA_HOME/include Java_PruebaJNI_mostrarMensaje.c -o pruebabiblioteca.so
 *
 * Aquí $JAVA_HOME es el directorio donde se ha instalado Java Development Kit
 *
 * En Windows:
 * El comando es el siguiente:
 *
 * #> cl Java_PruebaJNI_mostrarMensaje.c -Fpruebabiblioteca.dll -MD -LD javai.lib
 *
 * Este comando funciona con Microsoft Visual C++ 2.x y posteriores. Si queremos indicarle al compilador dónde se
 * encuentran los ficheros de cabecera y las bibliotecas, tendremos que fijar dos variables de entorno:
 *
 * #> SET INCLUDE=%JAVAHOME%\include;%INCLUDE%
 * #> SET LIB=%JAVAHOME%\lib;%LIB%
 *
 * Aquí %JAVAHOME% es el directorio donde se ha instalado Java Development Kit
 *
 *
 * Ahora sí estamos listos para ejecutar nuestro programa. Si de la ejecución resultan errores como UnsatisfiedLinkError, es porque
 * tenemos mal el camino de nuestra biblioteca dinámica.
 *
 * Cada sistema operativo maneja diferentes bibliotecas. Las extensiones más populares según el sistema operativo son:
 * Sistema Operativo ________ Extensión
 * Linux/Unix _______________ .so
 * Windows __________________ .dll
 * Mac OS ___________________ .dylib
 * Tabla 1. Extensiones de las bibliotecas según el sistema operativo
 *
 * Por otra parte, cada sistema operativo establece una política para buscar la biblioteca
 * en tiempo de ejecución, es decir, para establecer el enlace dinámico.
 * A grandes rasgos, las políticas son
 * Sistema Operativo ____________ Reglas de Búsqueda de bibliotecas
 * Linux/Unix ___________________ Busca primero en el subdirectorio donde está la aplicación. Si no lo encuentra allí, busca en el
 * ______________________________ subdirectorio que está establecido en la variable de entorno DYLD_LIBRARY_PATH
 * Windows ______________________ Busca primero en el subdirectorio donde está la aplicación. Si no lo encuentra allí, busca en el
 * ______________________________ subdirectorio que está establecido en la variable de entorno PATH
 * Mac OS _______________________ Busca en el subdirectorio que está establecido en la variable de entorno LD_LIBRARY_PATH
 * Tabla 2. Reglas de búsqueda de las bibliotecas según el sistema operativo
 *
 * Por otra parte, el nombre de la biblioteca de enlace dinámico varía según el sistema operativo.
 * Por ejemplo, para nuestro caso la biblioteca será:
 * Sistema Operativo _____________ Nombre de la biblioteca de enlace dinámico
 * Linux/Unix ____________________ libpruebabiblioteca.jnilib
 * Windows _______________________ pruebabiblioteca.dll
 * Mac OS ________________________ libpruebabiblioteca.so
 * Tabla 3. Nombre de la biblioteca según el sistema operativo
 *
 * En todos los casos, en el loadLibrary cargaremos "pruebabiblioteca".
 * Si salió todo bien deberíamos verla:
 * Este es nuestro primer método con JNI!!!
 *
 * Entonces, los pasos por seguir son los que se muestran en la Figura 5.
 * [ Escribir el programa Java ] <----------------------> [ PruebaJNI.java ]
 * [ Generar el bytecode ] <----------------------------> [ PruebaJNI.class ] <-------> [ Comando: #> javac PruebaJNI.java ]
 * [ Generar el archivo de header usando javah ] <------> [ PruebaJNI.h ] <-----------> [ Comando: #> javah PruebaJNI.java ]
 * Nota: Ya no existe en JDK23, se escribió manualmente
 * [ Escribir el programa C respetando el header ]<------>[ Java_PruebaJNI_mostrarMensaje.c ]
 * [ Compilar el programa C y generar la biblioteca ]<--->[ pruebabiblioteca.dll ]
 *      <--> [ Comando: #> cl Java_PruebaJNI_mostrarMensaje.c -Fpruebabiblioteca.dll -MD -LD javai.lib ]
 * [ Ejecutar el programa Java ] <----------------------->[ PruebaJNI.class] <--------> [ Comando: #> java PruebaJNI ]
 *
 */
/*
 * PARÁMETROS
 * Ahora compliquemos un poco más las cosas creando otro método nativo, pero en este caso, que reciba dos parámetros y
 * devuelva un resultado en PruebaJNI.java
 * El método que vamos a agregar será el siguiente:
 * public native float multiplicar(float a, int b);
 *
 * Si repetimos los pasos anteriores, es decir, compilar y crear el archivo de cabecera, vemos ahora que la función de C
 * queda definida como:
 * JNIEXPORT jfloat JNICALL Java_PruebaJNI_multiplicar(JNIEnv *, jobject, jfloat, jint);
 *
 */
JNIEXPORT jfloat JNICALL Java_PruebaJNI_multiplicar(JNIEnv *env, jobject obj, jfloat a, jint b)
{
    jfloat resultado = a * (jfloat)b;
    print("Este es nuestro segundo método nativo con la interfaz JNI con 2 parámetros\n");
    print("a vale: %f\n", a);
    print("b vale: %d\n", b);
    print("La multiplicación a*b vale: %f\n", resultado);
}
/*
 * Analizando un poco la definición, notamos que la interfaz JNI define variables para establecer una relación
 * entre las variables de C y las de Java. Esta relación no puede ser directa, porque C define el tamaño de sus
 * variables según el sistema operativo, y Java lo hace según la máquina virtual. A continuación vemos la tabla de
 * relación entre los tipos de datos Java y su tipo de dato nativo equivalente.
 * Tipo de Dato Java _________ Tipo de Dato Nativo __________ Tamaño en bits
 * boolean ___________________ jboolean _____________________ 8
 * unsigned byte _____________ jbyte ________________________ 8
 * char ______________________ jchar ________________________ 16
 * unsigned short ____________ jshort _______________________ 16
 * int _______________________ jint _________________________ 32
 * long ______________________ jlong ________________________ 64
 * float _____________________ jfloat _______________________ 32
 * double ____________________ jdouble ______________________ 64
 * void ______________________ void
 * Tabla 4. Tabla de relación de tipos de datos.
 * La relación que existe entre la declaración del método en Java con respecto al método nativo se ve en la figura 7.
 *   public native float multiplicar( float a, int b);
 *   JNIEXPORT jfloat JNICALL Java_PruebaJNI_multiplicar(JNIEnv * env, jobject obj, jfloat a, jint b)
 * Finalmente compilamos el programa C para crear la biblioteca, y estamos listos para probar nuestro programa Java.
 */