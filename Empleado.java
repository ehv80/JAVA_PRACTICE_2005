/**
 * @File / Archivo: Empleado.java
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
 * NUESTRO PRIMER OBJETO JAVA
 * En este caso, lo que deseamos es mantener la información de empleados, para lo cuál vamos a crear la clase Empleado
 *
 *
 */

public class Empleado
{
	/*
	 * Variable Global a la Clase visible desde todo el código fuente del programa.
	 * Global variable to Class visible from all source code of the program. 
	 *
	 *static int j = 0;
	 */
	public static float SUELDO_BASICO = 300.0f;

	/**
	 * No hay otros atributos en esta Clase            Empleado
	 * There aren't anothers atributes on this Class
	 * */
	private int legajo;
	private String nombre;
	private float sueldo;

	/**
	 * No hay otros métodos en esta Clase              Empleado
	 * There aren't anothers methods on this Class   
	 * */

	/*
	 * Método getSueldo nos va a devolver el sueldo del empleado
	 * */
	public float getSueldo()
	{
		return (this.sueldo);
	}

	/* 
	 * Método setSueldo sirve para modificar el sueldo del empleado
	 */
	public void setSueldo(float sueldo)
	{
		this.sueldo = sueldo;
	}

	/*
	 * Constructor
	 */
	public Empleado()
	{
		this.legajo = 0;
		this.nombre = new String();
		this.sueldo = 0.0f;
	}

	/* 
	 * En el Constructor parametrizado vamos a inicializar las variables con los parámetros que correspondan
	 */
	public Empleado(int legajo, String nombre, float sueldo)
	{
		this.legajo = legajo;
		this.nombre = nombre;
		this.sueldo = sueldo;
	}

	/**
	 * Método Principal de la Clase    Empleado    que contiene las sentencias que se van a ejecutar
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

		Empleado e1 = new Empleado();
		Empleado e2 = new Empleado(20, "Pedro", 1200f);
		// Mostrados los sueldos de e1 y e2 
		System.out.println("Sueldo de e1 : " + e1.getSueldo() );
		System.out.println("Sueldo de e2 : " + e2.getSueldo() );
		System.out.println("Sueldo Básico : " + e1.SUELDO_BASICO );
	}
}
