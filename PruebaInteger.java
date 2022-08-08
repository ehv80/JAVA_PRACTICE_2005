/**
 * @File / Archivo: PruebaInteger.java
 *
 * @Date / Fecha : Lunes 08 de Agosto del 2022 / Monday August 08, 2022
 * 
 * @Author : Ezequiel Hernán Villanueva 
 *
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
 * Capítulo 3: Clases
 *
 * REFERENCIAR VARIABLES DE UN OBJETO
 * En ocaciones, las variables que están dentro del objeto son públicas, es decir,
 * que no están encapsuladas. En estos casos las podemos referenciar sin la necesidad
 * de crear un objeto desde cualquier parte de nuestra aplicación. Para ejemplificar esto,
 * veamos las variables   MAX_VALUE  y  MIN_VALUE  de la Clase Integer 
 *
 *
 */

public class PruebaInteger
{
	/*
	 * Variable Global a la Clase visible desde todo el código fuente del programa.
	 * Global variable to Class visible from all source code of the program. 
	 *
	 *static int j = 0;
	 */

	/**
	 * No hay otros atributos en esta Clase            PruebaInteger 
	 * There aren't anothers atributes on this Class
	 * */

	/**
	 * No hay otros métodos en esta Clase              PruebaInteger
	 * There aren't anothers methods on this Class   
	 * */

	/*
	 * Constructor
	 */
	public PruebaInteger()
	{
	}

	/**
	 * Método Principal de la Clase    PruebaInteger    que contiene las sentencias que se van a ejecutar
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

		// Muestro las variables públicas de la Clase Integer
		System.out.println("Máximo entero : " + Integer.MAX_VALUE);
		System.out.println("Mínimo entero : " + Integer.MIN_VALUE);
		
		// Declaro una instancia de c entero
		Integer c = new Integer("0");

		// Muestro las variables públicas de la instancia c
		System.out.println("Máximo entero : " + c.MAX_VALUE);
		System.out.println("Mínimo entero : " + c.MIN_VALUE); 

	}	
}
