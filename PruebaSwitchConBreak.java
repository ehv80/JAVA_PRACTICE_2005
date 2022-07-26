/**
 * @File / Archivo: PruebaSwitchConBreak.java
 *
 * @Date / Fecha : Martes 26 de Julio del 2022 / Tuesday July 26, 2022
 * 
 * @Author : Ezequiel Hernán Villanueva 
 *
 * Ejemplo de uso de sentencias de control de flujo de ejecución del código fuente, sentencia Switch.
 * Example of use of source code execution flow control statements, Switch statement
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
 * Si deseamos que el switch ejecute de forma excluyente el caso que cumpla con el valor de la variable
 * sin ejecutar todos los posteriores, debemos agregar al final de cada línea una instrucción de corte.
 * Dicha instrucción de corte o ruptura es el break;
 * 
 * Note que el caso por defult no tiene break; esto es porque no lo necesita, ya que es el último caso y,
 * si se ejecuta no habrá nningún caso posterior.
 * De todas maneras agregarlo o no quedará a gusto del programador. Tenga en cuenta, sin embargo, 
 * que es una instrucción más que el programa deberá ejecutar sin necesitarla, y la idea general
 * a la hora de programar es hacer aplicaciones eficientes.
 */

public class PruebaSwitchConBreak
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
	 * Método Principal de la Clase    PruebaSwitchConBreak    que contiene las sentencias que se van a ejecutar
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
		int a = 2;
		
		switch( a )
		{
			case 1:  System.out.println("Entró al Primer Caso.");
				 break;
			case 2:  System.out.println("Entró al Segundo Caso.");
				 break;
			case 3:  System.out.println("Entró al Tercer Caso.");
				 break;
			default: System.out.println("Caso no Contemplado.");
		}
	}	
}
