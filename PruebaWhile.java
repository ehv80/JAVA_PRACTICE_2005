/**
 * @File / Archivo: PruebaWhile.java
 *
 * @Date / Fecha : Martes 26 de Julio del 2022 / Tuesday July 26, 2022
 * 
 * @Author : Ezequiel Hernán Villanueva 
 *
 * Ejemplo de uso de sentencias de Bucle: While.
 * Example of use of source code execution Bucle statements, While statement
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
 * Sentencias de Bucle
 * Cada sentencia en un programa se ejecuta solo una vez. Sin embargo, en ocaciones
 * necesitamos que una instrcción o un conjunto de instrucciones se ejecuten varias veces.
 * La cantidad de veces que deberán ser ejecutadas dichas instrucciones estará dada por una condición.
 *
 * While y Do-While
 * Este ciclo se interpreta de la siguiente manera: 
 * Mientras sea Verdadera una condición, ejecutar el Bloque.
 * La sintaxis es la siguiente
 *    
 * 	while( condición)
 * 	{
 * 		// Bloque que se ejecutará
 *		// mientras la condición sea verdadera
 * 	} 
 *
 * Supongamos que queremos mostrar por pantalla todos los números pares que hay hasta el 10.
 * El programa sería el siguiente
 */

public class PruebaWhile
{
	/*
	 * Variable Global a la Clase visible desde todo el código fuente del programa.
	 * Global variable to Class visible from all source code of the program. 
	 *
	 *static int j = 0;
	 */

	/**
	 * No hay otros atributos en esta Clase            PruebaCondicionalIfElseIf 
	 * There aren't anothers atributes on this Class
	 * */

	/**
	 * No hay otros métodos en esta Clase              PruebaCondicionalIfElseIf
	 * There aren't anothers methods on this Class   
	 * */

	/**
	 * Método Principal de la Clase    PruebaWhile    que contiene las sentencias que se van a ejecutar
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
		int a = 0;
		while( a < 10 )
		{
			System.out.println(a);
			a = a + 2;
		}
		System.out.println("El valor de a quedó en " + a);	
	}	
}
