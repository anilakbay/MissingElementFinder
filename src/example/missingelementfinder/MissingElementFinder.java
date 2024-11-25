package src.example.missingelementfinder;

import java.util.*;  // 'java.util' paketindeki tüm sınıfları dahil et! (List, ArrayList, Random) 
import java.util.logging.Logger;

public class MissingElementFinder {

    private static final Logger logger = Logger.getLogger(MissingElementFinder.class.getName());
    private static final Random random = new Random();

    public static void main(String[] args) {
        // 1. 100 adet random sayıya sahip bir liste oluştur
        List<Integer> originalList = generateUniqueRandomNumbers(100, 100);

        // 2. Listenin bir kopyasını oluştur
        List<Integer> copiedList = new ArrayList<>(originalList);

        // 3. Kopya listeden rastgele bir eleman sil
        int removedElement = copiedList.remove(random.nextInt(copiedList.size()));

        // 4. Eksik elemanı bul
        int missingElement = findMissingElement(originalList, copiedList);

        // Sonuçları logla
        logger.info(() -> String.format("Orijinal Liste: %s", originalList)); // %s: String için kullanılır
        logger.info(() -> String.format("Kopya Liste: %s", copiedList)); // %s: String için kullanılır
        logger.info(() -> String.format("Silinen Eleman: %d", removedElement)); // %d: Tam sayı (decimal) için kullanılır
        logger.info(() -> String.format("Bulunan Eksik Eleman: %d", missingElement)); // %d: Tam sayı (decimal) için kullanılır
    }

    /**
     * 0 ile belirli bir aralıkta benzersiz random sayı üreten metot.
     * @param count Üretilecek sayı adedi.
     * @param range Aralık (0 ile range arasında).
     * @return Benzersiz rastgele sayılardan oluşan bir liste.
     */
    private static List<Integer> generateUniqueRandomNumbers(int count, int range) {
        Set<Integer> numbers = new LinkedHashSet<>();
        while (numbers.size() < count) {
            numbers.add(random.nextInt(range + 1)); // 0-range arasında sayı
        }
        return new ArrayList<>(numbers);
    }

    /**
     * Orijinal liste ile kopya liste arasındaki farkı bularak eksik elemanı döndüren metot.
     * @param original Orijinal liste.
     * @param copied Kopya liste.
     * @return Eksik eleman.
     */
    private static int findMissingElement(List<Integer> original, List<Integer> copied) {
        Set<Integer> copiedSet = new HashSet<>(copied);
        return original.stream()
                .filter(num -> !copiedSet.contains(num))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Eksik eleman bulunamadı."));
    }
}
