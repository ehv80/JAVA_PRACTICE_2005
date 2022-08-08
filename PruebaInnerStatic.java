/**
 * @File / Archivo: PruebaInnerStatic.java
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
 * Veamos un ejemplo de una clase que tiene una clase estática y una inner class
 *
 */

public class PruebaInnerStatic
{
	/*
	 * Variable Global a la Clase visible desde todo el código fuente del programa.
	 * Global variable to Class visible from all source code of the program. 
	 *
	 *static int j = 0;
	 */
	//public static float SUELDO_BASICO = 300.0f;
	StaticClass s = new StaticClass();

	/**
	 * No hay otros atributos en esta Clase            PruebaInnerStatic
	 * There aren't anothers atributes on this Class
	 * */
	String dato;
	InnerClass i = new innerClass();
	

	/**
	 * No hay otros métodos en esta Clase              PruebaInnerStatic
	 * There aren't anothers methods on this Class   
	 * */

	/*
	 * Método getSueldo nos va a devolver el sueldo del empleado
	 * */
	/*
	 * public float getSueldo()
	{
		return (this.sueldo);
	}
	*/

	/* 
	 * Método setSueldo sirve para modificar el sueldo del empleado
	 */
	/*
	public void setSueldo(float sueldo)
	{
		this.sueldo = sueldo;
	}
	*/
	
	/*
	 * Método mostrar datos
	 */
	public void mostrarDatos()
	{
		System.out.println(this.dato + " " + i.datoInnerClass + " " + s.datoStaticClass );
	}

	/*
	 * Constructor
	 */
	/*
	public Empleado()
	{
		this.legajo = 0;
		this.nombre = new String();
		this.sueldo = 0.0f;
	}
	*/

	/* 
	 * En el Constructor parametrizado vamos a inicializar las variables con los parámetros que correspondan
	 */
	public PruebaInnerStatic(String dato1, String dato2, String dato3)
	{
		this.dato = dato1;
		i.datoInnerClass = dato2;
		s.datoStaticClass = dato3;
	}


	Class InnerClass
	{
		String datoInnerClass;

		public InnerClass()
		{
		}

	}

	static class StaticClass
	{
		static String datoStaticClass;

		public StaticClass()
		{
		}

	}



	/**
	 * Método Principal de la Clase    PruebaInnerStatic    que contiene las sentencias que se van a ejecutar
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

		PruebaInnerStatic p1 = new PruebaInnerStatic("UNO", "DOS", "TRES");

		PruebaInnerStatic p2 = new PruebaInnerStatic("CUATRO", "CINCO", "SEIS");
		
		// Mostrados los datos de p1 y p2 
		p1.mostrarDatos();
		p2.mostrarDatos();
		//System.out.println("Sueldo Básico : " + e1.SUELDO_BASICO );
	}
}
