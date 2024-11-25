import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.logging.Logger;

public class MissingElementFinder {

    private static final Logger logger = Logger.getLogger(MissingElementFinder.class.getName());

    public static void main(String[] args) {
        // 100 farklı sayıyı üret
        Set<Integer> originalNumbers = generateRandomNumbers();
        
        // Kopya listeyi oluştur ve rastgele bir sayı sil
        Set<Integer> copiedNumbers = new HashSet<>(originalNumbers);
        int missingNumber = removeRandomNumberAndGet(originalNumbers, copiedNumbers);
        
        // Eksik sayıyı bul ve yazdır
        logger.info("Eksik Sayı: " + missingNumber);
    }

    // Rastgele 100 farklı sayı üretir
    private static Set<Integer> generateRandomNumbers() {
        Set<Integer> numbers = new HashSet<>();
        Random random = new Random();
        
        // 1 ile 100 arasında 100 farklı sayı üret
        while (numbers.size() < 100) {
            numbers.add(random.nextInt(100) + 1);
        }
        return numbers;
    }

    // Rastgele bir sayıyı kopya listeden siler ve eksik sayıyı döndürür
    private static int removeRandomNumberAndGet(Set<Integer> original, Set<Integer> copied) {
        int randomNumber = new Random().nextInt(100) + 1;
        logger.info("Random sayı: " + randomNumber);
        copied.remove(randomNumber);
        return findMissingElement(original, copied);
    }

    // Eksik sayıyı bulur
    private static int findMissingElement(Set<Integer> original, Set<Integer> copied) {
        for (int num : original) {
            if (!copied.contains(num)) {
                return num;  // Eksik sayıyı döndür
            }
        }
        throw new MissingElementException("Eksik sayı bulunamadı!"); // Hata durumunda özel istisna fırlat
    }
}

// Eksik sayıyı bulamadığında fırlatılacak özel istisna
class MissingElementException extends RuntimeException {
    public MissingElementException(String message) {
        super(message);
    }
}
