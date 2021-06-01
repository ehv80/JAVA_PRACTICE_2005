/**
 * @File / Archivo: PruebaCondicionalIfElseIf.java
 *
 * @Date / Fecha : Martes 01 de Junio del 2021 / Tuesday June 01, 2021
 * 
 * @Author : Ezequiel Hernán Villanueva 
 *
 * Ejemplo de uso de sentencias de control de flujo de ejecución del código fuente, sentencia if-else-if.
 * Example of use of source code execution flow control statements, if-else-if statement
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

public class PruebaCondicionalIfElseIf
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
	 * Método Principal de la Clase    PruebaCondicionalIfElseIf    que contiene las sentencias que se van a ejecutar
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
		int i = 2;
		
		if( i == 1 )
		{
			/**     
                 	* Bloque de Código Fuente para el caso en que la Condición es VERDADERA, TRUE, 1.
                 	* Source Code Block for the case in which the Condition is TRUE, 1.
			* i igual a 1
			* i equal to 1
			*/
			i = i + 10 + 20;
			i = i / 2;
		}
		else if ( i == 2 )
		{
			/**     
                        * Bloque de Código Fuente para el caso en que la Condición es VERDADERA, TRUE, 1.
                        * Source Code Block for the case in which the Condition is TRUE, 1.
			* i igual 2
			* i equal to 2
                        */
                        i = i + 25 + 35;
                        i = i / 2;
		}
		else if ( i == 3 )
		{
			/**     
                        * Bloque de Código Fuente para el caso en que la Condición es VERDADERA, TRUE, 1.
                        * Source Code Block for the case in which the Condition is TRUE, 1.
			* i igual a 3
			* i equal 3
                        */
                        i = i + 38 + 48;
                        i = i / 2;

		}
		else
                {
                        /**     
                        * Bloque de Código Fuente para todos los otros casos: i no vale 1, ni 2, ni 3 
                        * Source Code Block for all other cases: i is not worth 1, nor 2, nor 3
                        */
                        i = i - 4;
			i = i * 2;
                }
		/**
		* Finalmente Muestra en pantalla la variable    i
                * Finally Print on the Display Monitor the       	variable
                */
                System.out.println("La variable    i   tiene tipo de dato   integer   y su valor es: " + i);
                System.out.println("The variable   i   have datatype        integer   and have the value:  " + i);	
	}	
}
