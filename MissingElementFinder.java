import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MissingElementFinder {

    public static void main(String[] args) {
        // Rastgele 100 adet sayı üretmek için Random sınıfını kullanıyoruz
        Random random = new Random();

        // Orijinal listeyi oluşturuyoruz
        List<Integer> originalList = new ArrayList<>();
        while (originalList.size() < 100) {
            int randomNumber = random.nextInt(100) + 1; // 1 ile 100 arasında rastgele sayı üret
            if (!originalList.contains(randomNumber)) {
                originalList.add(randomNumber);
            }
        }

        // Orijinal listenin bir kopyasını oluşturuyoruz
        List<Integer> copyList = new ArrayList<>(originalList);

        // 0 ile 100 arasında rastgele bir sayı üretip kopya listeden siliniyor
        int randomIndex = random.nextInt(100);
        copyList.remove(randomIndex);

        // Eksik elemanı bulan metodu çağırıyoruz
        int missingElement = findMissingElement(originalList, copyList);

        // Eksik elemanı ekrana yazdırıyoruz
        System.out.println("Eksik Eleman: " + missingElement);
    }

    // Eksik elemanı bulan metot
    public static int findMissingElement(List<Integer> originalList, List<Integer> copyList) {
        // Orijinal listede olup kopya listede olmayan sayıyı buluyoruz
        for (int number : originalList) {
            if (!copyList.contains(number)) {
                return number; // Eksik sayıyı döndürüyoruz
            }
        }
        return -1; // Eğer eksik bir sayı yoksa -1 döndürüyoruz
    }
}
