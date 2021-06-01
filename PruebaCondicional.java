/**
 * @File / Archivo: PruebaCondicional.java
 *
 * @Date / Fecha : Martes 01 de Junio del 2021 / Tuesday June 27, 2021
 * 
 * @Author : Ezequiel Hernán Villanueva 
 *
 * Ejemplo de uso de sentencias de control de flujo de ejecución del código fuente, sentencia if-else.
 * Example of use of source code execution flow control statements, if-else statement.
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

public class PruebaCondicional
{
	/*
	 * Variable Global a la Clase visible desde todo el código fuente del programa.
	 * Global variable to Class visible from all source code of the program. 
	 *
	 *static int j = 0;
	 */

	/**
	 * No hay otros atributos en esta Clase            PruebaCondicional 
	 * There aren't anothers atributes on this Class
	 * */

	/**
	 * No hay otros métodos en esta Clase              PruebaCondicional
	 * There aren't anothers methods on this Class   
	 * */

	/**
	 * Método Principal de la Clase    PruebaCondicional       que contiene las sentencias que se van a ejecutar
	 * Principal Method od The Class                           that contain the statements that will be executed
	 * 
	 * Similar a la función principal      main(int argc, char * argv[])   del Lenguaje de Programación C
	 * Similar to the principal function                                   of The C Language Programming
	 */

	public static void main(String argv[])
	{
		/** 
		 *  Declaration de variables locales del Método Principal Main
		 *  Declaration of local variables of Main Method
		 */
		int i = 5;
		
		if( i == 4 )
		{
			/** 
			 * Bloque de Código Fuente para el caso en que la Condición es VERDADERA, TRUE, 1.
			 * Source Code Block for the case in which the Condition is TRUE, 1.
			 *
			 * Muestra en pantalla la variable    i
                         * Print on the Display Monitor the       variable
                         */
			System.out.println("Bloque de Código Fuente para el caso en que la Condición es VERDADERA ");
			System.out.println("Source Code Block for the case in which the Condition is TRUE ");
                        System.out.println("La variable    i   tiene tipo de dato   integer   y su valor es: " + i);
                        System.out.println("The variable   i   have datatype        integer   and have the value:  " + i);

		}
		else
		{
			/** 
                         * Bloque de Código Fuente para el caso en que la Condición es FALSA, FALSE, 0.
                         * Source Code Block for the case in which the Condition is FALSE, 0.
                         *
                         * Muestra en pantalla la variable    i
                         * Print on the Display Monitor the       variable
                         */
                        System.out.println("Bloque de Código Fuente para el caso en que la Condición es FALSA ");
                        System.out.println("Source Code Block for the case in which the Condition is FALSE ");
                        System.out.println("La variable    i   tiene tipo de dato   integer   y su valor es: " + i);
                        System.out.println("The variable   i   have datatype        integer   and have the value:  " + i);
		}
	}	
}
