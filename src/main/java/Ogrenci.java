import java.util.*;

public class Ogrenci {
    static Scanner scan = new Scanner(System.in);


    static Map<String, String> ogrenciMap = new HashMap<>();

    public static void ogrenciEkleme() {
        ogrenciMap.put("34532156789", "Ayse, Battal, 2008, 432, 12, A");
        ogrenciMap.put("12654943295", "Seda, Kaya, 2008, 321, 12, B");
        ogrenciMap.put("64325673235", "Nalan, Kaya, 2007, 672, 12, A");
        ogrenciMap.put("64378645432", "Kemal, Demir, 2009, 552, 12, B");
        ogrenciMap.put("53257890341", "Yasemin, Kaya, 2009, 112, 12, A");
        ogrenciMap.put("54327865109", "Erdem, Demir, 2009, 368, 12, B");
        ogrenciMap.put("11213556098", "Ahmet, Bulut, 2009, 651, 12, A");


    }


    public static void ogrenciMenu() throws InterruptedException {
        String select;
        do {
            System.out.println("========= ARZU KOLEJI =========\n" +
                    "\n=======OGRENCI MENU=======\n" +
                    "\t 1-Ogrenci Listesi Yazdir\n" +
                    "\t 2-Soyisimden Ogrenci Bulma\n" +
                    "\t 3-Sinif ve Sube ile Ogrenci Bulma\n" +
                    "\t 4-Bilgilerini Girerek Ogrenci Eklemek\n" +
                    "\t 5-Kimlik No Ile Kayit Silme\n" +
                    "\t A-Ana Menu\n" +
                    "\t Q-Cikis");
            System.out.println("Seciminiz : ");
            select = scan.nextLine().toUpperCase();
            switch (select) {

                case "1":
                    //ogrenci listesi yazdir
                    ogrenciListesiYazdir();
                    break;
                case "2":
                    //soyisminden ogrenci bulma
                    soyismindenOgrenciBulma();
                    break;
                case "3":
                    //sinif ve sube ile ogrenci bulma
                    sinifVeSubeIleOgrenciBulma();
                    break;
                case "4":
                    //ogrenci ekleme
                    ogrenciEkle();
                    break;
                case "5":
                    tcNoIleOgrenciSilme();
                    break;
                case "A":
                    Depo.start();
                    break;
                case "Q":
                    Depo.projeDurdur();
                    break;
                default:
                    System.out.println("Yanlis secim yaptiniz. Bir daha deneyiniz.");
            }

        } while (!select.equalsIgnoreCase("q"));
        Depo.projeDurdur();
    }

    private static void tcNoIleOgrenciSilme() {
        Set<Map.Entry<String, String>> myEntrySet = ogrenciMap.entrySet();
        System.out.println("Silmek istediginiz ogrencinin Tc kimlik nosunu giriniz.");
        String tc = scan.nextLine();
        String silinecekValue = ogrenciMap.get(tc);
        String sonucValue = ogrenciMap.remove(tc);
        try {
            boolean sonuc = sonucValue.equals(silinecekValue);
        } catch (Exception e) {
            System.out.println("Istediginiz Tc numarasi ile ogrenci bulunamadi.");
        }

    }

    private static void ogrenciEkle() {
        Set<Map.Entry<String, String>> myEntrySet = ogrenciMap.entrySet();


        System.out.println("Eklemek istediginiz ogrencinin bilgilerini giriniz");
        System.out.println("Ogrencinin Tc kimlik numarasi :");
        String tcNo = scan.nextLine();
        System.out.println("Ogrencinin adi :");
        String ad = scan.nextLine();
        System.out.println("Ogrencinin soyadi :");
        String soyad = scan.nextLine();
        System.out.println("Ogrencinin dogum yili :");
        String dYili = scan.nextLine();
        System.out.println("Ogrencinin okul numarasi :");
        String no = scan.nextLine();
        System.out.println("Ogrencinin sinifi :");
        String sinif = scan.nextLine();
        System.out.println("Ogrencinin subesi :");
        String sube = scan.nextLine();
        String key = tcNo;
        String value = ad + ", " + soyad + ", " + dYili + ", " + no + ", " + sinif + ", " + sube;
        ogrenciMap.put(key, value);

    }

    private static void sinifVeSubeIleOgrenciBulma() throws InterruptedException {
        Set<Map.Entry<String, String>> myEntrySet = ogrenciMap.entrySet();
        System.out.println("Istenilen ogrencinin sinifini yaziniz");
        String sinif = scan.nextLine();
        System.out.println("ogrenci sinifini  subesini yaziniz");
        String sube = scan.nextLine();
        System.out.println("========= ARZU KOLEJI =========\n" +
                "\n======= OGRENCI LISTESI =======\n" +
                "     Tc No   Isim    Soyisim   D.Yili  Okul No Sinif Sube");
        System.out.println("Aradiginin ogrencinin soyadini giriniz.");
        for (Map.Entry<String, String> each : myEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();
            String[] eachValueArr = eachValue.split(", ");
            if (sinif.equalsIgnoreCase(eachValueArr[4]) && sube.equalsIgnoreCase(eachValueArr[5])) {
                System.out.printf("%12s %-8s %-9s %-8s %-6s %-6s %-2s\n", eachKey, eachValueArr[0], eachValueArr[1],
                        eachValueArr[2], eachValueArr[3], eachValueArr[4], eachValueArr[5]);
            }

        }
        Thread.sleep(3000);
    }

    private static void soyismindenOgrenciBulma() throws InterruptedException {
        Set<Map.Entry<String, String>> myEntrySet = ogrenciMap.entrySet();

        System.out.println("========= ARZU KOLEJI =========\n" +
                "\n======= OGRENCI LISTESI =======\n" +
                "     Tc No   Isim    Soyisim   D.Yili  Okul No Sinif Sube");
        System.out.println("Aradiginin ogrencinin soyadini giriniz.");
        String arananSoyisim = scan.nextLine();
        for (Map.Entry<String, String> each : myEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();
            String[] eachValueArr = eachValue.split(", ");
            if (arananSoyisim.equalsIgnoreCase(eachValueArr[1])) {
                System.out.printf("%12s %-8s %-9s %-8s %-6s %-6s %-2s\n", eachKey, eachValueArr[0], eachValueArr[1],
                        eachValueArr[2], eachValueArr[3], eachValueArr[4], eachValueArr[5]);
            }

        }

        Thread.sleep(3000);
    }

    public static void ogrenciListesiYazdir() throws InterruptedException {
        System.out.println("========= ARZU KOLEJI =========\n" +
                "\n======= OGRENCI LISTESI =======\n" +
                "     Tc No   Isim    Soyisim   D.Yili  Okul No Sinif Sube");
        Set<Map.Entry<String, String>> myEntrySet = ogrenciMap.entrySet();

        for (Map.Entry<String, String> each : myEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();
            String eachValueArr[] = eachValue.split(", ");
            System.out.printf("%12s %-8s %-9s %-8s %-6s %-6s %-2s\n", eachKey, eachValueArr[0], eachValueArr[1], eachValueArr[2], eachValueArr[3], eachValueArr[4], eachValueArr[5]);
        }
        Thread.sleep(3000);

    }

}
