/**
 * @File / Archivo: PruebaFor.java
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
 * For
 * En ciertas ocasiones sabemos por anticipado cuál es el número de iteraciones que deseamos ejecutar.
 * Por ejemplo, si deseamos imprimir los números desde el cero hasta el nueve, tenemos la certeza
 * de que vamos a necesitar diez iteraciones.
 * Para esto existe la sentencia for, y su sintaxis es la siguiente
 *
 * 	for( inicio, condición, incremento u otra iteración )
 * 	{
 * 		// bloque de ejecución
 * 	}
 * Supongamos ahora que deseamos resolver el ejemplo, es decir, imprimir los números desde el cero
 * hasta el nueve. Analizando un poco los datos que tenemos para resolver el problema, vemos en primer lugar
 * que debemos empezar desde el 0; por otra parte sabemos que serán 10 iteraciones, 
 * y finalmente, que debemos saltar de uno en uno.
 *
 */

public class PruebaFor
{
	/*
	 * Variable Global a la Clase visible desde todo el código fuente del programa.
	 * Global variable to Class visible from all source code of the program. 
	 *
	 *static int j = 0;
	 */

	/**
	 * No hay otros atributos en esta Clase            PruebaFor
	 * There aren't anothers atributes on this Class
	 * */

	/**
	 * No hay otros métodos en esta Clase              PruebaFor
	 * There aren't anothers methods on this Class   
	 * */

	/**
	 * Método Principal de la Clase    PruebaFor    que contiene las sentencias que se van a ejecutar
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
		for( i=0 ; i < 10 ; i++ )
		{
			System.out.println(i);
		}
		//System.out.println("El valor de a quedó en " + a);	
	}	
}
