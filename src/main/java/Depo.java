import java.util.Scanner;

public class Depo {
    static Scanner scan = new Scanner(System.in);

    public static void start() throws InterruptedException {
        String select;
        do {

            System.out.println("========= ARZU KOLEJI =========\n" +
                    "=========  ANA MENU  ========\n" +
                    "\n" +
                    "\t  1.Okul Bilgilerini Goruntule\n" +
                    "\t  2.Ogretmen Menu\n" +
                    "\t  3.Ogrenci Menu\n" +
                    "\t  Q.Cikis");
            System.out.println("Lutfen menuden tercihinizi yapiniz");
            select = scan.nextLine();
            switch (select) {
                case "1":
                    //okul bilgileri
                    Depo.okulBilgileriniYazdir();
                    break;
                case "2":
                    //ogretmen menu
                    Ogretmen.ogretmenMenu();
                    break;
                case "3":
                    //ogrenci menu
                    Ogrenci.ogrenciMenu();
                    break;
                case "Q":
                case "q":
                    System.out.println("Iyi gunler dilerim");
                    break;
                default:
                    System.out.println("Gecerli tercih giriniz");
            }
        } while (!select.equalsIgnoreCase("Q"));
        Depo.projeDurdur();

    }

    public static void projeDurdur() {
        System.out.println("Okul projesinden ciktiniz.");
        System.exit(0);// sistemi tamamen durdurur

    }

    public static void okulBilgileriniYazdir() throws InterruptedException {
        System.out.println("========= ARZU KOLEJI =========\n" +
                "\t\t Adres : " + Okul.adres + "\n" +
                "\t\t Telefon : " + Okul.telefon);
        Thread.sleep(3000);
    }
}
