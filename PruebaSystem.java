/**
 * @File / Archivo: PruebaSystem.java
 *
 * @Date / Fecha : Martes 26 de Julio del 2022 / Tuesday July 26, 2022
 * 
 * @Author : Ezequiel Hernán Villanueva 
 *
 * Ejemplo de uso de sentencias de manejo de excepciones se verán en el Capítulo 7.
 * Example of use of source code execution management statements, it will be show to you on the chapter 7.
 *
 *
 * Some source code files with examples from The Book
 * "JAVA LA GUÍA TOTAL DEL PROGRAMADOR"
 * a Compiled and Interpreted by a Java Virtual Machine Programming Language
 * with the slogan "Write Once, Run Everywhere"
 * and The Paradigm of Object Oriented Programming Language
 * for various GNU\Linux based Operative Systems, Microsoft Windows, Mac of Apple and much others.
 * Thanks and Writted by: Sergio Alejandro Dos Santos @ REDUSERS
 * 
 * Edited by Me a little time ago!
 *
 * You can Copy / Edit / Change / Distribute
 * GNU/GPL License Software Version 3.0
 * 
 * For Educational Purpose.
 *
 */

/*
 * CLASE SYSTEM
 * A lo largo del libro hemos usado la Clase System para imprimir valores por pantalla, pero esta clase
 * representa varios recursos del sistema. 
 * Para entender primero esta clase, vamos a conocer su Filosofía. 
 * Para empezar la Clase System no se puede inicializar, todas sus variables y métodos están declarados como static,
 * y en todo momento habrá solo una instancia de esta clase en el sistema.
 * Para usar sus variables o métodos, sólo debemos invocarlos. 
 * Por ejemplo, para usar la variable out, lo hacemos de la siguiente manera:
 * 	System.out
 * 
 * De igual forma actuamos para usar println de la instancia out
 *	System.out.println("Hola Mundo!!!");
 *
 * Esto se conoce como Standard I/O por input/output (en castellano entrada/salida)
 * Este concepto es similar al que se utiliza en C.
 *
 * 	System.in	entrada estandar (Standard input)  Se usa para leer una entrada de datos del usuario.
 *
 * 	System.out	salida estandar  (Standard output) Como vimos se usa para mostrarle información al usuario
 *
 * 	System.err	error estandar   (Standard Error)  Se usa para mostrar mensajes de error al usuario.
 *
 * Otro método útil de la Clase System es   getProperty()   el cual nos brinda valiosa información acerca del sistema.
 * Demos un ejemplo para dejar en claro lo dicho anteriormente. 
 * Con la siguiente línea obtenemos el nombre de usuario del sistema:
 *	System.getProperty("user.name");
 *
 * La siguiente tabla muestra todas las propiedades que podemos pasarle como parámetro al método getProperty() 
 * y que obtenemos en cada caso 
 *
 * 	PROPIEDAD			DESCRIPCIÓN
 * 	-------------------		--------------------------------------------------------------
 * 	"file.separator"		Separador de archivos
 * 	"java.class.path"		Classpath de Java
 * 	"java.class.version"		Versión del Árbol de Clases de Java
 *	"java.home"			Directorio de instalación de Java
 *	"java.vendor"			Nombre del Distribuidor de Java
 *	"java.vendor.url"		Dirección de Internet del Distribuidor de Java
 *	"java.version"			Versión de Java
 *	"line.separator"		Separador de línea
 *	"os.arch"			Arquitectura del Sistema Operativo
 *	"os.name"			Nombre del Sistema Operativo
 *	"os.version"			Versión del Sistema Operativo
 *	"path separator"		Separador de Caminos
 *	"user.dir"			Directorio actual de trabajo
 *	"user.home"			Directorio home del usuario
 *	"user.name"			Nombre del Usuario
 *
 *
 * A través de System podemos forzar la ejecución del recolector de basura
 * El procedimiento es simple solo hay que seguir las instrucciones:
 * 	System.gc();
 *
 * A continuación veremos un ejemplo con varios usos de la clase System
 */	

public class PruebaSystem
{
	/*
	 * Variable Global a la Clase visible desde todo el código fuente del programa.
	 * Global variable to Class visible from all source code of the program. 
	 *
	 *static int j = 0;
	 */

	/**
	 * No hay otros atributos en esta Clase            PruebaSystem
	 * There aren't anothers atributes on this Class
	 * */

	/**
	 * No hay otros métodos en esta Clase              PruebaSystem
	 * There aren't anothers methods on this Class   
	 * */

	/**
	 * Método Principal de la Clase    PruebaSystem    que contiene las sentencias que se van a ejecutar
	 * Principal Method od The Class                           	that contain the statements that will be executed
	 * 
	 * Similar a la función principal      main(int argc, char * argv[])   del Lenguaje de Programación C
	 * Similar to the principal function                                   of The C Language Programming
	 */

	public static void main(String argv[])
	{
		/** 
		 *  Declaracion e inicialización de variables locales del Método Principal Main
		 *  Declaration and initialization of local variables of Main Method
		 */
		System.out.println("Prueba de la Clase System");
		System.out.print("Otro tipo");
		System.out.print("de Salida... \n");
		System.err.println("Esto provoca una salida por error...");
		// El Método currentTimeMillis() nos da la Fecha y hora en milisegundos
		long time = System.currentTimeMillis();
	}	
}
