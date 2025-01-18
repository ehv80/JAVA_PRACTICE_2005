/* 
 * A continuación veremos un ejemplo de uso de HttpSession;
 * para ello crearemos una clase Usuario. Ésta tendrá
 * nombre de usuario y contraseña.
 */
//package servlets; // comentado para evitar error en tiempo
// de ejecución paquete y clase no encontrados 
public class Usuario {
    /* Atributos de la clase Usuario */
    private String nombreDeUsuario = new String();
    private String contraseña = new String();

    /* Constructor con parámetros */
    public Usuario(String n, String c) {
        this.nombreDeUsuario = n;
        this.contraseña = c;
    }

    /* Métodos de la clase Usuario */
    public void setNombreUsuario(String n) {
        this.nombreDeUsuario = n;
    }

    public String getNombreUsuario() {
        return this.nombreDeUsuario;
    }

    public void setContraseña(String c) {
        this.contraseña = c;
    }

    public String getContraseña() {
        return this.contraseña;
    }

}
/*
 * Ahora crearemos una página web HTML que pida nombre de Usuario
 * y contraseña, y establesca el atributo en una nueva sesión
 * (Nota ver el archivo: Login.jsp)
 */