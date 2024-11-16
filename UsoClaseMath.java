import java.lang.*;

public class UsoClaseMath {
    public UsoClaseMath() {
        System.out.println("El valor de PI es                       : " + Math.PI);
        System.out.println("La raíz cuadrada de 25 es               : " + Math.sqrt(25));
        System.out.println("5 elevado al cuadrado es                : " + Math.pow(5, 2));
        System.out.println("El coseno de 60 es                      : " + Math.cos(60));
        System.out.println("El seno de 60 es                        : " + Math.sin(60));
        System.out.println("La tangente de 60 es                    : " + Math.tan(60));
        System.out.println("El valor absoluto de -10 es             : " + Math.abs(-10));
        System.out.println("El mínimo entre 2 y 8 es                : " + Math.min(2, 8));
        System.out.println("eL máximo entre 2 y 8 es                : " + Math.max(2, 8));
    }

    public void main(String argv[]) {
        new UsoClaseMath();
    }
}