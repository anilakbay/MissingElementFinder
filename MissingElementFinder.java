import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MissingElementFinder {

    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();

        // 100 adet rastgele sayı üretimi
        while (numbers.size() < 100) {
            int randomNumber = random.nextInt(100) + 1;
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        // Orijinal listenin kopyasını oluşturma
        List<Integer> numbersCopy = new ArrayList<>(numbers);

        // Kopya listeden rastgele bir sayıyı silme
        int randomIndex = random.nextInt(numbersCopy.size());
        int removedElement = numbersCopy.remove(randomIndex);

        System.out.println("Orijinal Sayılar Listesi: " + numbers);
        System.out.println("Kopya Sayılar Listesi (Silinen: " + removedElement + "): " + numbersCopy);

        // Eksik elemanı bulan metot çağrılıyor
        int missingElement = findMissingElement(numbers, numbersCopy);
        System.out.println("Eksik Eleman: " + missingElement);
    }

    // Eksik elemanı bulan metot
    public static int findMissingElement(List<Integer> original, List<Integer> copy) {
        // Orijinal listede olup kopya listede bulunmayan sayıyı arıyoruz
        for (int num : original) {
            if (!copy.contains(num)) {
                return num;  // Eksik olan sayıyı döndürüyoruz
            }
        }
        return -1;  // Eğer eksik eleman bulunmazsa, -1 döndür
    }
}
