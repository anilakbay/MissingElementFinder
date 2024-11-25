import java.util.HashSet;
import java.util.Set;
import java.util.Random;

public class MissingElementFinder {
    
    public static void main(String[] args) {
        // Rastgele 100 adet sayı üretmek için Random sınıfını kullanıyoruz
        Random random = new Random();
        
        // Set veri yapısını kullanarak, sayıları tekrarsız bir şekilde saklayacağız
        Set<Integer> numbers = new HashSet<>();
        
        // 100 rastgele sayı üretip bunları set'e ekliyoruz
        while (numbers.size() < 100) {
            int randomNumber = random.nextInt(100) + 1; // 1 ile 100 arasında rastgele sayı üret
            numbers.add(randomNumber); // Set'e ekliyoruz
        }

        // Sayıları ekrana yazdırıyoruz (isteğe bağlı)
        System.out.println("Rastgele Sayılar Listesi: " + numbers);

        // 1'den 100'e kadar olan tüm sayıları kontrol ediyoruz
        // Eksik olan sayıları bulmak için 1 ile 100 arasındaki her sayıyı kontrol ediyoruz
        for (int i = 1; i <= 100; i++) {
            if (!numbers.contains(i)) { // Eğer sayı set'te yoksa
                System.out.println("Eksik Sayı: " + i); // Eksik sayıyı yazdır
            }
        }
    }
}
