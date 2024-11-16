import java.util.*;

public class UsoClaseRandom {
    public UsoClaseRandom()
    {
        Random r = new Random();
        System.out.println("\nFlotantes pseudoaleatorios");
        for(int i=0; i<5; i++)
        {
            System.out.print(r.nextFloat() + " ");
        }
        System.out.println("\nEnteros pseudoaleatorios");
        for(int i=0; i<5; i++)
        {
            System.out.print(r.nextInt() + " ");
        }
        System.out.println("\nEnteros pseudoaleatorios entre 0 y 50");
        for(int i=0; i<5; i++)
        {
            System.out.print(r.nextInt(50) + " ");
        }
        public static void main(String[] args)
        {
            new UsoClaseRandom();
        }
    }
}