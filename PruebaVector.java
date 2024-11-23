class PruebaVector {
    public PruebaVector() {

    }

    public static void main(String[] args) {
        /* Declaro la variable i que me servirá de índice para recorrer el vector */
        int i = 0;
        // La variable sumatoria guardará el resultado
        int sumatoria = 0;
        // Declaro el vector de 30 elementos de tipo entero
        int vector[] = new int[30];
        // Cargo el vector con los números del 0 al 29
        for (i = 0; i < 30; i++)
            vector[i] = i;
        // Ahora lo recorro y lo voy sumando en la variable sumatoria
        for (i = 0; i < 30; i++)
            sumatoria = sumatoria + vector[i];
        System.out.println("El resultado de la sumatoria de los números del 0 al 29 es: " + sumatoria);
    }
}