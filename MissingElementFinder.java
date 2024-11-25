import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.logging.Logger;

public class MissingElementFinder {

    private static final Logger logger = Logger.getLogger(MissingElementFinder.class.getName());

    public static void main(String[] args) {
        Set<Integer> originalNumbers = generateRandomNumbers();
        Set<Integer> copiedNumbers = new HashSet<>(originalNumbers);

        // Rastgele bir sayı seç ve kopya listeden sil
        int randomNumber = new Random().nextInt(100);
        logger.info("Random sayı: " + randomNumber);
        copiedNumbers.remove(randomNumber);

        // Eksik sayıyı bul ve yazdır
        logger.info("Eksik Sayı: " + findMissingElement(originalNumbers, copiedNumbers));
    }

    private static Set<Integer> generateRandomNumbers() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < 100) {
            numbers.add(new Random().nextInt(100) + 1);
        }
        return numbers;
    }

    private static int findMissingElement(Set<Integer> original, Set<Integer> copied) {
        for (int num : original) {
            if (!copied.contains(num)) {
                return num;
            }
        }
        throw new RuntimeException("Eksik sayı bulunamadı!");
    }
}
