/* Ahora vamos a implementar una clase de nombre Matriz con tres
 * métodos: uno servirá para sumar un valor numérico que se reciba como parámetro a cada elemento
 * de la matríz; otro, para mostrar la matríz en pantalla; y un tercero sumará la fila que se le
 * indique también como parámetro.
 */
public class Matriz {
    /* Variable matriz global a la clase y privada */
    private int matriz[][] = new int[3][3];

    /* En el constructor por defecto no hacemos nada */
    public Matriz() {

    }

    /* Este método sumará el valor a cada elemento de la matríz */
    public void sumaUnValor(int valor) {
        /* Declaro i y j como locales al método */
        int i = 0;
        int j = 0;
        for (i = 0; i < 3; i++)
            for (j = 0; j < 3; j++)
                matriz[i][j] = matriz[i][j] + valor;
    }

    /* Este método sumará la fila que reciba como parámetro y devolverá el total */
    public float sumaFila(int fila) {
        /* Declaro i y j como locales al método */
        int i = 0;
        int j = 0;
        int total = 0;
        for (j = 0; j < 3; j++)
            total = total + matriz[fila][j];
        return (total);
    }

    /* Este método muestra la matríz de forma entendible para nosotros */
    public void muestraMatriz()
    {
        /* Declaro i y j como locales al método */
        int i = 0;
        int j = 0;
        for(i=0; i<3; i++)
        {
            for(j=0; j<3; j++)
            {
                System.out.print(matriz[i][j])
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Instancio una matriz y la referencio con m
        Matriz m = new Matriz();
        System.out.println("Matríz vacía");
        m.muestraMatriz();
        System.out.println("Le sumo 1");
        m.sumaUnValor(1);
        m.muestraMatriz();
        System.out.println("Le sumo 3");
        m.sumaUnValor(3);
        m.muestraMatriz();
        System.out.println("EL total de la fila 2 es: " + m.sumaFila(2));
    }
}