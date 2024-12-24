/*
 * La tabla Notas en la Base de Datos InterBase llamada Escuela
 * tendrá los siguientes campos:
 * 
 * NOMBRE DEL CAMPO ________________ TIPO DE DATO
 * COD_ALUMNO ______________________ Numeric
 * PRIMER_NOTA _____________________ Float
 * SEGUNDA_NOTA ____________________ Float
 * PROMEDIO ________________________ Float
 * Tabla 4. Campos de la Tabla Notas en la Base de Datos InterBase Escuela
 * 
 * Surge el objeto de la clase Notas, que será el siguiente: 
 */
public class Notas {
    private Float primerNota;
    private Float segundaNota;
    private Float promedio;

    /* Constructor por defecto */
    public Notas() {

    }
}
/*
 * Note que el campo COD_ALUMNO no lo representamos en el objeto de la clase
 * Notas,
 * ya que lo va a contener un objeto de la clase Alumno
 * que ya tiene representado éste código.
 * Por otra parte, se puede quitar el dato miembro promedio, ya que es un dato
 * calculado, pero no estaría representando a la base de datos.
 */