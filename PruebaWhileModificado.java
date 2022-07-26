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
 *  Veamos que pasa ahora si modificamos el ejemplo y queda de la siguiente manera.
 *  Lo que pasa ahora es que, tomando a el valor 0, cuando verifica por primera vez la condición del while,
 *  0 no es mayor que 10
 *  o sea que es falso.
 *  De esta manera no se ejecutó el bloque de iteración ni siquiera una vez, 
 *  y la variable a quedó con su valor origrinal
 *
 */

public class PruebaWhileModificado
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
	 * Método Principal de la Clase    PruebaWhileModificado    que contiene las sentencias que se van a ejecutar
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
		while( a > 10 )
		{
			System.out.println(a);
			a = a + 2;
		}
		System.out.println("El valor de a quedó en " + a);	
	}	
}
