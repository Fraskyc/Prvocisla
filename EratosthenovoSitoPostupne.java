import java.util.Arrays;
import java.util.Scanner;
import java.time.Duration;
import java.time.Instant;


public class EratosthenovoSitoPostupne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Zadejte číslo N: ");
        int N = scanner.nextInt();
        
        
        boolean[] jePrvocislo = new boolean[N + 1];
        Arrays.fill(jePrvocislo, true);
        Instant start = Instant.now();
       
        System.out.println("Všechna čísla od 2 do " + N + ":");
        for (int i = 2; i <= N; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
        
        
        jePrvocislo[0] = false;
        jePrvocislo[1] = false;
        
      
        for (int i = 2; i * i <= N; i++) {
            if (jePrvocislo[i]) {
                System.out.println("Násobky čísla " + i + ":");
                for (int j = i * i; j <= N; j += i) {
                    if (jePrvocislo[j]) {
                        System.out.print(j + " ");
                        jePrvocislo[j] = false;
                    }
                }
                System.out.println("\n");
            }
        }
        
       
        System.out.println("Prvočísla od 2 do " + N + " jsou:");
        for (int i = 2; i <= N; i++) {
            if (jePrvocislo[i]) {
                System.out.print(i + " ");
            }
        }
        Instant end = Instant.now();
        System.out.println("\nRychlost algoritmu: " + Duration.between(start, end).toMillis() + " ms");
    }
}
