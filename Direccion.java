/* 
 * Para representar las claves foráneas vamos a aplicar 
 * el concepto de jerarquía de composición. Para esto debemos
 * definir primero el objeto de la Clase Dirección, 
 * que representará la siguiente tabla en la base de datos InterBase Escuela:
 * 
 * NOMBRE_DEL_CAMPO _______________ TIPO DE DATO
 * COD_DIRECCION __________________ Numeric
 * CALLE __________________________ Char(25)
 * NUMERO _________________________ Char(25)
 * LOCALIDAD ______________________ Char(25)
 * Tabla 3. Datos contenidos en el Objeto de la clase Direccion
 * 
 * EL objeto de la clase Dirección quedará así:
 */
public class Direccion {
    private Integer ID_Direccion; // Primary Key
    private String calle;
    private Integer numero;
    private String localidad;

    /* Constructor por defecto */
    public Direccion() {

    }
}