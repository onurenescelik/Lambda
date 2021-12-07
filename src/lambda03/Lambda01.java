package lambda03;

import lambda02.MethodLambda2;

import java.util.*;

public class Lambda01 {
    public static void main(String[] args) {

        List<String> l = new ArrayList<>(Arrays.asList("Ali","Ali","Aysima","Abdurrahman","Mehmet","Mustafa","Bedirhan","Yüksel","Süleyman"));

        yazdirBuyukHarf(l);
        System.out.println();
        uzunluklaraGoreSirala(l);
        System.out.println();
        sonHarfSirala(l);
        System.out.println();
        uzunlukVeIlkKarakterSirala(l);
        System.out.println();
        yazdirAIleBaslayan(l);
        System.out.println();
        aBaslaVeyaiBitir(l);
        System.out.println();
        siralaBuyult(l);
        System.out.println();
        isimUzunlukSirala(l);
        System.out.println();
        karesiniAlSiralaSil(l);
        System.out.println();
        ebikGabik(l);
        System.out.println();
        sondanIkinciSiralaIlk(l);
        terstenSiralaIlkYazdir(l);



    }




    //1)List in elemanlarini buyuk harfle yazdir.
    public static void yazdirBuyukHarf(List<String> l) {
        l.stream().map(t->t.toUpperCase()).forEach(MethodLambda2::bosluklaYazdir);//ALİ ALİ AYSİMA ABDURRAHMAN MEHMET MUSTAFA BEDİRHAN YÜKSEL SÜLEYMAN
        System.out.println();
        l.stream().map(String::toUpperCase).forEach(MethodLambda2::bosluklaYazdir);//-->daha yaygin //ALİ ALİ AYSİMA ABDURRAHMAN MEHMET MUSTAFA BEDİRHAN YÜKSEL SÜLEYMAN
    }

    //2) elemanları uzunluklarına göre sırala ve yazdır
    public static void uzunluklaraGoreSirala(List<String> l) {
        l.stream().sorted(Comparator.comparing(String::length)).forEach(MethodLambda2::bosluklaYazdir);//Ali Ali Aysima Mehmet Yüksel Mustafa Bedirhan Süleyman Abdurrahman
        System.out.println();
        l.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(MethodLambda2::bosluklaYazdir);//Abdurrahman Bedirhan Süleyman Mustafa Aysima Mehmet Yüksel Ali Ali


    }
    //3) farklı elemanlarını son harflerine göre sıralayıp yazdır
    private static void sonHarfSirala(List<String> l) {
        l.stream().distinct().sorted(Comparator.comparing(t->t.substring(t.length()-1))).forEach(MethodLambda2::bosluklaYazdir);//Aysima Mustafa Ali Yüksel Abdurrahman Bedirhan Süleyman Mehmet

    }
    //4) Elemanları uzunluklarına ve ardından (aynı uzunlukta olanları) ilk karakterlerine göre sıralamak için bir yöntem oluşturun
    private static void uzunlukVeIlkKarakterSirala(List<String> l) {
        l.add("Ata");
        l.stream().sorted(Comparator.comparing(String::length).thenComparing(t->t.substring(0,1))).forEach(MethodLambda2::bosluklaYazdir);//Ali Ali Ata Aysima Mehmet Yüksel Mustafa Bedirhan Süleyman Abdurrahman
        System.out.println();
        l.stream().sorted(Comparator.comparing(String::length).thenComparing(t->t.substring(0,1)).thenComparing(t->t.substring(1,2))).forEach(MethodLambda2::bosluklaYazdir);//Ali Ali Ata Aysima Mehmet Yüksel Mustafa Bedirhan Süleyman Abdurrahman


    }


    //5)Büyük harflerle, "A" ile başlayan liste öğelerini yazdırmak için bir yöntem oluşturun
    private static void yazdirAIleBaslayan(List<String> l) {

        l.stream().filter(t->t.startsWith("A")).map(String::toUpperCase).forEach(MethodLambda2::bosluklaYazdir);//ALİ ALİ AYSİMA ABDURRAHMAN ATA
    }


    //6)  Küçük harflerle, "A" ile başlayan veya "i" ile biten liste öğelerini yazdırmak için bir yöntem oluşturun
    private static void aBaslaVeyaiBitir(List<String> l) {
        l.stream().map(t->t.toLowerCase()).filter(t->t.startsWith("a") || t.endsWith("i")).forEach(MethodLambda2::bosluklaYazdir);//ali ali aysima abdurrahman ata
        System.out.println();
        l.stream().map(String::toLowerCase).filter(t-> t.startsWith("a") || t.endsWith("i") ).forEach(MethodLambda2::bosluklaYazdir);//ali ali aysima abdurrahman ata
        //Method reference ile yaparsak komutlarin icine sadece bir islem alabiliriz.arrow (->) function da && || larla istedigimiz kadar islem yapabiliriz
    }

    //7) Öğeleri uzunluklarına göre sıraladıktan sonra büyük harflerle yazdırmak için bir yöntem oluşturun
    private static void siralaBuyult(List<String> l) {
        l.stream().map(String::toUpperCase).sorted(Comparator.comparing(String::length)).forEach(MethodLambda2::bosluklaYazdir);//ALİ ALİ ATA AYSİMA MEHMET YÜKSEL MUSTAFA BEDİRHAN SÜLEYMAN ABDURRAHMAN

    }

    //8) Elemanları uzunluklarına göre sıralayın önce elemanı sonra uzunluğunu yazdırın
    //Ali:3  Aysima:6
    private static void isimUzunlukSirala(List<String> l) {
        l.stream().sorted(Comparator.comparing(String::length)).map(t->t+":"+t.length()).forEach(MethodLambda2::bosluklaYazdir);//Ali:3 Ali:3 Ata:3 Aysima:6 Mehmet:6 Yüksel:6 Mustafa:7 Bedirhan:8 Süleyman:8 Abdurrahman:11

    }

    //9) Her elemanın uzunluğunun karesini alıp tekrarlıları sil, bunların 20'den büyük olanlarını ters sırada  yazdırın
    private static void karesiniAlSiralaSil(List<String> l) {
        l.stream().map(t->t.length()*t.length()).distinct().filter(t->t>20).sorted(Comparator.reverseOrder()).forEach(MethodLambda2::bosluklaYazdir);//121 64 64 49 36 36 36


    }
    //10) Tüm elemanların uzunluklarının 12'den az olup olmadığını kontrol etmek için bir metod oluşturun
    //bütün elemanların "x" ile başlamadığını kontrol etmek için bir yöntem oluşturun
//en az 1 tane "R" ile biten eleman olup olmadığını kontrol etmek için bir metod oluşturun.


    private static void ebikGabik(List<String> l) {

        boolean result=l.stream().allMatch(t->t.length()<12);
        System.out.println("elemanlarin uzunlugu 12 den kucuk mu: "+result);//true

        System.out.println();

        boolean result2=l.stream().noneMatch(t->t.startsWith("X"));
        System.out.println("x ile baslayan OLMADIGI dogru mudur?: "+result2);//true

        System.out.println();

        boolean result3=l.stream().anyMatch(t->t.endsWith("R"));
        System.out.println("elemanlardan herhangi biri R ile bitiyor mu: "+result3);//false







    }
    // elemanları sondan 2. elemanlarına göre sıralayıp ilk elemanı yazdır

    private static void sondanIkinciSiralaIlk(List<String> l) {
        System.out.println(l.stream().sorted(Comparator.comparing(t -> t.charAt(t.length() - 2))).findFirst());//Optional[Abdurrahman]

    }


//12)elemanlari uzunluklarina gore tersten siralayip ilk elemani yazdir
private static void terstenSiralaIlkYazdir(List<String> l) {

    System.out.println(l.stream().sorted(Comparator.comparing(String::length).reversed()).findFirst());//Optional[Abdurrahman]
    System.out.println();

    //Eleman 'A', 'a' ile başlıyor veya 'N', 'n' ile bitiyorsa o elemanı silin
    l.removeIf(t->t.toUpperCase().startsWith("A") || t.toUpperCase().endsWith("N"));
    System.out.println(l);//[Mehmet, Mustafa, Yüksel]
}




    }



