/**
 * @File / Archivo: PruebaSwitch.java
 *
 * @Date / Fecha : Lunes 25 de Julio del 2022 / Monday July 25, 2022
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
 * Switch 
 *
 * Esta sentencia es útil cuando analizamos una variable que puede tomar varios valores y,
 * según dichos valores, el programa seguirá varios caminos diferentes.
 *
 * La sintaxis de la sentencia switch es la siguiente:
 *
 * 	switch(variable)
 * 	{
 * 		case valor1: // Instucciones para valor1 
 * 		case valor2: // Instucciones para valor2
 * 		.
 * 		.
 * 		.
 * 		case valorN: // Instucciones para valorN
 * 		default: // Instrucciones por Defecto 
 * 	}
 * 
 * Lo primero que se observa en la sintaxis, después de la línea del switch
 * es la palabra reservada case; estos definen los caminos posibles según el valor de la variable.
 * Al final del switch nos encontramos con la instrucción default; este bloque se ejecutará 
 * si el valor de la variable no fue contemplado en alguno de los casos anteriores.
 * Una de las restricciones que tiene JAVA es que en el switch sólo analizará variables de tipo char, byte, short o int
 * o expresiones que devuelvan resultados de los tipos mencionados.
 *
 */

public class PruebaSwitch
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
		int a = 2;
		
		switch( a )
		{
			case 1:  System.out.println("Entró al Primer Caso.");
			case 2:  System.out.println("Entró al Segundo Caso.");
			case 3:  System.out.println("Entró al Tercer Caso.");
			default: System.out.println("Caso no Contemplado.");
		}
	}	
}
