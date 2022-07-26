/**
 * @File / Archivo: PruebaWhileFor1.java
 *
 * @Date / Fecha : Martes 26 de Julio del 2022 / Tuesday July 26, 2022
 * 
 * @Author : Ezequiel Hernán Villanueva 
 *
 * Ejemplo de uso de sentencias de Bucle: For.
 * Example of use of source code execution Bucle statements, For statement
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
 * La decisión de usar for o while dependerá exclusivamente de cuán claro quede
 * representado el problema por resolver, ya que en cualquier caso se puede usar while y for
 * para resolver el mismo problema.
 * En el siguiente programa vamos a imprimir los números que son divisibles por 5 que hay del 0 al 20 
 * Usando la sentencia for sería: 
 */

public class PruebaWhileFor1
{
	/*
	 * Variable Global a la Clase visible desde todo el código fuente del programa.
	 * Global variable to Class visible from all source code of the program. 
	 *
	 *static int j = 0;
	 */

	/**
	 * No hay otros atributos en esta Clase            PruebaWhileFor1
	 * There aren't anothers atributes on this Class
	 * */

	/**
	 * No hay otros métodos en esta Clase              PruebaWhileFor1
	 * There aren't anothers methods on this Class   
	 * */

	/**
	 * Método Principal de la Clase    PruebaWhileFor1    que contiene las sentencias que se van a ejecutar
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
		int i;
		for( i=0 ; i < 20 ; i++ )
		{
			// si el resto de la divisón de i por 5 es 0 entonces lo muestro en pantalla
			if( i%5 == 0 )
			{
				System.out.println(i);
			}
		}
		//System.out.println("El valor de a quedó en " + a);	
	}	
}
