/* Este archivo PruebaJNI.h debería ser generado por el comando javah PruebaJNI.java
 * pero en JDK23 ya no existe más:
 * "javah" no se reconoce como un comando interno o externo,
 * programa o archivo por lotes ejecutable
 * Se edita el archivo manualmente para poder continuar con el ejemplo de PruebaJNI.java
 */

/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for Class PruebaJNI */
#ifndef _Included_PruebaJNI
#define _Included_PruebaJNI
#ifdef __cplusplus
extern "C"
{
#endif
    /*
     * Class:       PruebaJNI
     * Method:      getMensaje
     * Signature:   ()V
     */
    JNIEXPORT void JNICALL Java_PruebaJNI_mostrarMensaje(JNIEnv *, jobject);
    JNIEXPORT jfloat JNICALL Java_PruebaJNI_multiplicar(JNIEnv *, jobject, jfloat, jint);
#ifdef __cplusplus
}
#endif
#endif

/* El nombre de la función C que implementa el método nativo deriva del nombre del paquete,
 * el nombre de la clase y el nombre del método nativo. Así el método nativo
 * dentro de la Clase PruebaJNI es Java_PruebaJNI_mostrarMensaje() (Figura 4).
 * La función C acepta dos parámetros, aunque el método nativo definido en la Clase Java no acepte ninguno.
 * Estos dos parámetros sirven a la interfaz para comunicarse, de modo que debemos respetarlos.
 *
 * Prefijo ------------ Nombre de la Clase ------------ Nombre del método nativo
 * [ Java ] + [ _ ] + [ PruebaJNI ]      +     [ _ ] + [ mostrarMensaje() ]
 *
 * Figura 4. Estructura del nombre de los métodos nativos en Lenguaje de Programación C.
 *
 * Una vez obtenido el archivo de cabeceras vamos a volver a utilizar javah
 * para generar el archivo de stubs; éste es simplemente el archivo que contiene todas
 * las declaraciones de métodos, con sus llamadas y argumentos pero con extensión C.
 * En este archivo es donde vamos a poner el código que necesitemos.
 * javah -stubs PruebaJNI
 *
 * Nota: recordar que en JDK23 ya no existe javah
 * Crearemos a mano el archivo de stusbs llamándolo Java_PruebaJNI_mostrarMensaje.c
 */