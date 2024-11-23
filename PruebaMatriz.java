class PruebaMatriz {
    public PruebaMatriz() {

    }

    public static void main(String[] args) {
        /*
         * Declaro las variables i y j que me servirán de índices para recorrer la
         * matríz
         */
        int i = 0;
        int j = 0;
        // La variable totalVenta guarda el total de ventas
        float totalVenta = 0;
        // Guarda el total del vendedor uno
        float ventaDelVendedorUno = 0;
        // Declaro la matríz
        float matriz[][] = new float[5][10];
        /*
         * Cargo ventas del vendedor 0
         * $100 del artículo 6
         * y $25 del artículo 4
         */
        matriz[0][6] = 100f;
        matriz[0][4] = 25f;
        /*
         * Cargo ventas del vendedor 1
         * $110 del artículo 2
         */
        matriz[1][2] = 110f;
        /*
         * Cargo ventas del vendedor 3
         * $1 del artículo 3
         * $250 del artículo 4 y
         * $25 del artículo 6
         */
        matriz[3][3] = 1f;
        matriz[3][4] = 250f;
        matriz[3][6] = 25f;
        /*
         * Para recorrer la matriz, necesito ahora dos for, uno para filas y otro para
         * columnas.
         * Entonces, recorro la matriz completa y calculo el total de ventas.
         */
        for (i = 0; i < 5; i++)
            for (j = 0; j < 10; j++)
                totalVenta = totalVenta + matriz[i][j];
        System.out.println("El total de ventas es: " + totalVenta);
        /*
         * Ahora recorro la matriz dejando fija la fila 0 ya que esta corresponde al
         * primer vendedor
         */
        for (j = 0; j < 10; j++)
            ventaDelVendedorUno = ventaDelVendedorUno + matriz[0][j];
        System.out.println("El total de ventas del vendedor uno es: " + ventaDelVendedorUno);
    }
}