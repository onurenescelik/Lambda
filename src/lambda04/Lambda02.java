package lambda04;

import lambda02.MethodLambda2;

import javax.xml.stream.events.Comment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda02 {
    public static void main(String[] args) {
        //1)Tüm ortalama puanların (91)'den büyük olup olmadığını kontrol etmek için bir yöntem oluşturun

        Universite edebiyatBolum=new Universite("FenEdebiyat","Edebiyat",97,123);
        Universite iktisatBolum = new Universite("IIBF", "Iktisat", 98, 134);
        Universite matematikBolum = new Universite("FenEdebiyat", "Matematik", 95, 142);
        Universite ingilizceBolum = new Universite("IngilizDili", "Ingilizce", 93, 154);

        List<Universite>uniList=new ArrayList<>(Arrays.asList(edebiyatBolum,iktisatBolum,matematikBolum,ingilizceBolum));

        System.out.println(uniList.stream().allMatch(t -> t.getNotOrtalamasi() > 91));//true

        //2)Ders adlarından en az birinin "Matematik" kelimesini içerip içermediğini kontrol etmek için bir yöntem oluşturun
        System.out.println(uniList.stream().anyMatch(t -> t.getBolum().equalsIgnoreCase("matematik")));
        //veya
        System.out.println(uniList.stream().anyMatch(t -> t.getBolum().contains("Matem")));//true
        //3)Ortalama puanı en yüksek olan kursu yazdırmak için bir yöntem oluşturun
        System.out.println(uniList.stream().sorted(Comparator.comparing(Universite::getNotOrtalamasi).reversed()).findFirst());//Optional[Universite{fakulte='IIBF', bolum='Iktisat', notOrtalamasi=98, ogrenciNo=134}]

        //4)Not ortalamasına göre artan sıralama yapıp ilk elemanı atla ve list olarak yazdır

        System.out.println(uniList.stream().sorted(Comparator.comparing(Universite::getNotOrtalamasi)).skip(1).collect(Collectors.toList()));//[Universite{fakulte='FenEdebiyat', bolum='Matematik', notOrtalamasi=95, ogrenciNo=142}, Universite{fakulte='FenEdebiyat', bolum='Edebiyat', notOrtalamasi=97, ogrenciNo=123}, Universite{fakulte='IIBF', bolum='Iktisat', notOrtalamasi=98, ogrenciNo=134}]


    }
}
