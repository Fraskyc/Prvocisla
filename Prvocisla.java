import java.time.Instant;
import java.time.Duration; 
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prvocisla {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Zadejte číslo N: ");
        int N;
        
        try {
            N = Integer.parseInt(scanner.nextLine());
            if (N < 2) {
                System.out.println("Zadejte číslo větší nebo rovno 2.");
                return;
            }
            
            List<Integer> prvocisla = najdiPrvocisla(N);
            System.out.println("Prvočísla od 2 do " + N + ": " + prvocisla);
            
        } catch (NumberFormatException e) {
            System.out.println("Zadejte prosím platné celé číslo.");
        } finally {
            scanner.close();
        }
    }

    private static List<Integer> najdiPrvocisla(int N) {
        List<Integer> prvocisla = new ArrayList<>();
        Instant start = Instant.now();
        
        for (int cislo = 2; cislo <= N; cislo++) {
            boolean jePrvocislo = true;
            
            for (int delitel = 2; delitel <= Math.sqrt(cislo); delitel++) {
                if (cislo % delitel == 0) {
                    jePrvocislo = false;
                    break;
                }
            }
            
            if (jePrvocislo) {
                prvocisla.add(cislo);
            }
        }
        
        Instant end = Instant.now();
        System.out.println("Rychlost algoritmu " + Duration.between(start, end).toMillis() + " ms");
        return prvocisla;
        
    }
}
