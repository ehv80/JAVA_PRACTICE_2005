/* Este archivo debería ser generado por el comando
 * javah -stubs PruebaJNI
 * pero en JDK23 javah ya no existe más!
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