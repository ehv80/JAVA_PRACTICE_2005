/**
 * @File / Archivo: AlcanzeVariable.java
 *
 * @Date : 27 de Mayo de 2021 / May 27, 2021
 * 
 * @Author : Ezequiel Hernán Villanueva 
 *
 * Ejemplo de uso de bloques de sentencias de código fuente JAVA delimitada por llaves.
 * Example of using blocks of JAVA source code statements delimited by braces.
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

public class AlcanzeVariable
{
	/**
	 * Variable Global a la Clase visible desde todo el código fuente del programa.
	 * Global variable to Class visible from all source code of the program. 
	 */
	static int j = 0;

	/**
	 * No hay otros atributos en esta Clase            AlcanzeVariable 
	 * There aren't anothers atributes on this Class
	 * */

	/**
	 * No hay otros métodos en esta Clase              AlcanzeVariable
	 * There aren't anothers methods on this Class   
	 * */

	/**
	 * Método Principal de la Clase    AlcanzeVariable       que contiene las sentencias que se van a ejecutar
	 * Principal Method od The Class                         that contain the statements that will be executed
	 * 
	 * Similar a la función principal      main(int argc, char * argv[])   del Lenguaje de Programación C
	 * Similar to the principal function                                   of The C Language Programming
	 */

	public static void main(String argv[])
	{
		/**
		 * Declaración de un Bloque de Código Fuente.
		 * Abriendo llave define un bloque de ejecución.
		 *
		 * Declaration of a Source Code Block.
   		 * Opening brace defines an execution block.
		 */
		{
			int a = 0; 
			a = a + 1;
			/**
                 	* Muestra en pantalla la variable    a
                 	* Print on the Display Monitor the       variable
                 	* */
                	System.out.println("La variable    a   tiene tipo de dato   int   y su valor es: " + a);
                	System.out.println("The variable   a   have datatype        int   and have the value:  " + a);
		}
		/**
		 * Cerrando la llave finaliza el bloque de ejecución.
		 * Closing the key ends the execution block.
		 */

		/**
                 * Declaración de un Segundo Bloque de Código Fuente.
                 * Abriendo llave define un bloque de ejecución.
                 *
                 * Declaration of a Second Source Code Block.
                 * Opening brace defines an execution block.
                 */
                {
                        int c = 2;
                        c = c + j;
			
			/**
			 * Instrucción inválida, la variable a no existe más en este segundo bloque de ejecución.
			 * Invalid instruction, variable a no longer exists in this second execution block.
			 */
			c = c + a; 
                        
			/**
                        * Muestra en pantalla la variable    a
                        * Print on the Display Monitor the       variable
                        * */
                        System.out.println("La variable    c   tiene tipo de dato   int   y su valor es: " + c);
                        System.out.println("The variable   c   have datatype        int   and have the value:  " + c);
                }
                /**
                 * Cerrando la llave finaliza el Segundo bloque de ejecución.
                 * Closing the key ends the Second execution block.
                 */

	}	
}

