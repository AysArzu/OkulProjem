import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Ogretmen {
    static Scanner scan = new Scanner(System.in);

    static Map<String, String> ogretmenlerMap = new HashMap<>();

    public static void ogretmenEkle() {
        ogretmenlerMap.put("12345896475", "Ebubekir, Battal, 1979, Fizik");
        ogretmenlerMap.put("15412547545", "Ayse, Arzu, 181, Matematik");
        ogretmenlerMap.put("43212486556", "Ebrar, Azra, 2000, Sosyal");
        ogretmenlerMap.put("45601258988", "Zeynep, Pelit, 1987, Fen");
        ogretmenlerMap.put("31203792587", "Alptekin, Tok, 1972, Turkce");

    }

    public static void ogretmenMenu() throws InterruptedException {
        String select;
        do {
            System.out.println("========= ARZU KOLEJI =========\n" +
                    "\n=======OGRETMEN MENU=======\n" +
                    "\t 1-Ogretmen Listesi Yazdir\n" +
                    "\t 2-Soyisimden Ogretmen Bulma\n" +
                    "\t 3-Branstan Ogretmen Bulma\n" +
                    "\t 4-Bilgilerini Girerek Ogretmen Eklemek\n" +
                    "\t 5-Kimlik No Ile Kayit Silme\n" +
                    "\t A-Ana Menu\n" +
                    "\t Q-Cikis");
            System.out.println("Seciminiz : ");
            select = scan.nextLine();
            switch (select) {
                case "1":
                    ogretmenListesiYazdir();
                    break;
                case "2":
                    soyismindenOgretmenBulma();
                    break;
                case "3":
                    branstanOgretmenBulma();
                    break;
                case "4":
                    ogretmenEkleme();
                    break;
                case "5":
                    kimlikNoIleKayitSilme();
                    break;
                case "A":
                case "a":
                    Depo.start();
                    break;
                case "q":
                case "Q":

                    break;
                default:
                    System.out.println("Seciminiz yanlistir. Yeniden deneyiniz");
            }


        } while (!select.equalsIgnoreCase("q"));
        Depo.projeDurdur();


    }

    private static void kimlikNoIleKayitSilme() {
        System.out.println("Silmek istediginiz ogretmenin kimlik nosunu siliniz");
      String silinecekOgretmen=  scan.nextLine();
      String silinecekValue=ogretmenlerMap.get(silinecekOgretmen);
     String sonucValue= ogretmenlerMap.remove(silinecekOgretmen);
     try{
         boolean sonuc=sonucValue.equals(silinecekValue);
     }catch (Exception e){
         System.out.println("Istediginiz tc numarasi ile ogretmen bulunamadi");
     }
    }

    private static void ogretmenEkleme() {
        System.out.println("Tc no ");
        String tcNo = scan.nextLine();
        System.out.println("Isim ");
        String isim = scan.nextLine();
        System.out.println("Soyisim ");
        String soyisim = scan.nextLine();
        System.out.println("Dogum yili ");
        String dYili = scan.nextLine();
        System.out.println("Brans ");
        String brans = scan.nextLine();

        String eklenecekValue = isim + ", " + soyisim + ", " + dYili + ", " + brans;
        ogretmenlerMap.put(tcNo, eklenecekValue);

    }

    private static void branstanOgretmenBulma() throws InterruptedException {
        System.out.println("========= ARZU KOLEJI =========\n" +
                "\n=======BRANS ILE OGRETMEN ARAMA =======\n" +
                "TcNo    isim     Soyisim   D.Yili   Brans ");
        System.out.println("Aradiginiz ogretmenin bransini giriniz");
        String arananBrans = scan.nextLine();
        Set<Map.Entry<String, String>> ogretmenEntrySet = ogretmenlerMap.entrySet();
        for (Map.Entry<String, String> each : ogretmenEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();
            String[] eachValueArr = eachValue.split(", ");
            if (arananBrans.equalsIgnoreCase(eachValueArr[3])) {
                System.out.printf("%-12s %-8s %-8s %4s %-10s\n", eachKey, eachValueArr[0], eachValueArr[1], eachValueArr[2], eachValueArr[3]);
            }
        }
        Thread.sleep(5000);
    }

    public static void soyismindenOgretmenBulma() throws InterruptedException {
        System.out.println("Aradiginiz ogretmenin soyismini giriniz");
        String arananSoyisim = scan.nextLine();
        System.out.println("========= ARZU KOLEJI =========\n" +
                "\n=======SOYISIMLE OGRETMEN ARAMA  =======\n" +
                "TcNO    isim     Soyisim   D.Yili   Brans ");

        Set<Map.Entry<String, String>> ogretmenEntrySet = ogretmenlerMap.entrySet();
        for (Map.Entry<String, String> each : ogretmenEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();
            String[] eachValueArr = eachValue.split(", ");
            if (arananSoyisim.equalsIgnoreCase(eachValueArr[1])) {
                System.out.printf("%-12s %-8s %-8s %4s %-10s\n", eachKey, eachValueArr[0], eachValueArr[1], eachValueArr[2], eachValueArr[3]);

            }

        }
        Thread.sleep(5000);
    }


    public static void ogretmenListesiYazdir() throws InterruptedException {
        System.out.println("========= ARZU KOLEJI =========\n" +
                "\n======= OGRETMEN LISTESI =======\n" +
                "TcNO    isim     Soyisim   D.Yili   Brans ");

        Set<Map.Entry<String, String>> ogretmenEntrySet = ogretmenlerMap.entrySet();
        for (Map.Entry<String, String> each : ogretmenEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();
            String[] eachValueArr = eachValue.split(", ");
            System.out.printf("%-12s %-8s %-8s %4s %-10s\n", eachKey, eachValueArr[0], eachValueArr[1], eachValueArr[2], eachValueArr[3]);

        }
        Thread.sleep(5000);
    }


}
