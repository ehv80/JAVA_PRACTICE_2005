public class UsoClaseRuntime {

    public UsoClaseRuntime() {
        Runtime rt = Runtime.getRuntime();
        try {
            /* A través del método exec() ejecutamos notepad de Windows */
            rt.exec("C:\\Windows\\NOTEPAD.EXE");
        } catch (Exception ex) {
            System.out.println("Ocurrió una Excepción en tiempo de ejecución :" + ex.toString());
        }
    }

    public static void main(String[] args) {
        new UsoClaseRuntime();
    }
}