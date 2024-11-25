import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MissingElementFinder {
    
    // 100 adet rastgele sayıyı listeye ekleyen metot
    public static List<Integer> generateRandomList(int size) {
        List<Integer> list = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt(101)); // 0 ile 100 arasında rastgele sayılar
        }
        return list;
    }

    public static void main(String[] args) {
        // Adım 1: Rastgele sayılarla bir liste oluşturuyoruz
        List<Integer> randomList = generateRandomList(100);
        
        // Adım 2: Listeyi yazdırıyoruz
        System.out.println("Rastgele Sayılar Listesi: " + randomList);
    }
}
