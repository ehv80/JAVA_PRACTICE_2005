/**
 * @File / Archivo: Declaracion.java
 *
 * @Date : 27 de Mayo de 2021 / 27 of May of 2021
 * 
 * @Author : Ezequiel Hernán Villanueva 
 *
 * Primer ejemplo de uso de variables en JAVA.
 * First example with the use of variables.
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

public class Declaracion
{
	/**
	 * No hay otros atributos en esta Clase            Declaracion 
	 * There aren't anothers atributes on this Class
	 * */

	/**
	 * No hay otros métodos en esta Clase              Declaracion
	 * There aren't anothers methods on this Class   
	 * */

	/**
	 * Método Principal de la Clase    Declaracion      que contiene las sentencias que se van a ejecutar
	 * Principal Method od The Class                    that contain the statements that will be executed
	 * 
	 * Similar a la función principal      main(int argc, char * argv[])   del Lenguaje de Programación C
	 * Similar to the principal function                                   of The C Language Programming
	 */
	public static void main(String argv[])
	{
		/**
		 * Declaracion de la variable    i   con tipo de dato   long
		 * Declaration of the variable       with datatype 
		 * */
		long i;

		 /**
                 * Declaracion de la variable    j   con tipo de dato   int   e inicialización con valor    0
                 * Declaration of the variable       with datatype            and initialization with the        value
                 * */
		int j = 0;
		/**
		 * Muestra en pantalla la variable    j
		 * Print on the Display Monitor the       variable
		 * */
		System.out.println("La variable    j   tiene tipo de dato   int   y su valor es: " + j);
		System.out.println("The variable   j   have datatype        int   and have the value:  " + j);
                
	       	/**
                 * Declaracion de la variable    k   con tipo de dato   double   e inicialización con valor    4
                 * Declaration of the variable       with datatype               and initialization with the        value
                 * */
		double k = 4.5;
                /**
                 * Muestra en pantalla la variable    k
                 * Print on the Display Monitor the       variable
                 * */
                System.out.println("La variable    k   tiene tipo de dato   double   y su valor es: " + k);
                System.out.println("The variable   k   have datatype        double   and have the value:  " + k);

	}	
}

