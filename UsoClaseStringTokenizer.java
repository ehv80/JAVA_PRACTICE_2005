import java.util.*;

public class UsoClaseStringTokenizer {
    String cadena = "Diego|27|011-4486-5863|Amabay 258|1754";

    public UsoClaseStringTokenizer() {
        /* Creamos el objeto con la cadena y el delimitador */
        StringTokenizer stk = new StringTokenizer(cadena, "|");
        System.out.println("Cantidad de tokens: " + stk.countTokens());
        /* Mientras haya más tokens */
        while (stk.hasMoreTokens()) {
            /* Tomo el siguiente y lo muestro */
            System.out.println(stk.nextElement());
        }
        System.out.println("Cantidad de tokens: " + stk.countTokens());
    }

    public static void main(String[] args) {
        new UsoClaseStringTokenizer();
    }
}