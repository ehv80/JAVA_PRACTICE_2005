/**
 * @File / Archivo: PruebaStatic.java
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
 * ...
 * Lo que en realidad vimos en el ejemplo anterior es una variable con acceso público, 
 * es decir que todos pueden acceder a ella, pero hay cuatro niveles de acceso en Java
 * y todos ellos son válidos para variables y métodos.
 * Los niveles de acceso son los siguientes:
 *
 * 	* public: 	cualquier clase desde cualquier lugar puede acceder a las variables y métodos de instancia públicos
 *
 * 	* protected: 	sólo las subclases de la clase, y nadie más, pueden acceder a las variables y métodos de instancia protegidos
 *
 * 	* private: 	las variables y métodos de instancia privados sólo son accesibles desde dentro de la clase. No son accesibles desde las subclases.
 *
 * 	* friendly:	por default, si no se especifica el control de acceso, las variables y métodos de instancia se declaran friendly (amigables), el
 * 			concepto es el mismo que para protected
 *
 * Setencia Static
 * En algunos casos vamos a necesitar que una variable no cambie de valor para ninguna instancia de la clase, es decir,
 * que exista una única copia de la variable de instancia. Para esto se utiliza la sentencia  static.  Otra vez,
 * vale tanto para variables como para métodos.
 * Cabe aclarar que un método declarado como  static  no podrá acceder a ninguna variable de la clase; ésta es una regla de acceso.
 * Por lo tanto, los métodos estáticos sólo pueden modificar variables estáticas o variables locales. Ahora vamos a usar alguno de
 * los métodos estáticos de la clase Character.
 *
 */

public class PruebaStatic
{
	/*
	 * Variable Global a la Clase visible desde todo el código fuente del programa.
	 * Global variable to Class visible from all source code of the program. 
	 *
	 *static int j = 0;
	 */

	/**
	 * No hay otros atributos en esta Clase            PruebaStatic
	 * There aren't anothers atributes on this Class
	 * */

	/**
	 * No hay otros métodos en esta Clase              PruebaStatic
	 * There aren't anothers methods on this Class   
	 * */

	/*
	 * Constructor
	 */
	public PruebaStatic()
	{
	}

	/**
	 * Método Principal de la Clase    PruebaStatic    que contiene las sentencias que se van a ejecutar
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

		// Declaramos la variable caracter y la inicializamos con `C´
		//char caracter = 'C';
		Character caracter = new Character('C');

		// Método estático isLetter
		If(Character.isLetter(caracter))
		{
			System.out.println("Es una Letra !!! " );
		}
		// Método estático toLowerCase
		System.out.println("Convertido a minúscula es: " + Character.toLowerCase(caracter));
	}
}
