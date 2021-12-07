package lambda02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda02 {
    public static void main(String[] args) {

  // Method Reference'da bizim oluşturduğumuz metodları  veya Java metodlarını kullanırız.
 // Method Reference Syntax ı ==> ClassName::MethodName  System.out.println();  ==  System.out::println;
        List<Integer>l=new ArrayList<>(Arrays.asList(15,14,9,13,4,9,2,4,14));
        elemanYazdir(l);
        System.out.println();
        ciftSayiYazdir(l);
        System.out.println();
        tekSayiKAre(l);
        System.out.println();
        farkliTekSayiKup(l);
        System.out.println();
        farkliCifsayitoplam(l);
        farkliCiftSayiKup(l);
        System.out.println();
        System.out.println(farkliTersSirala(l));
        System.out.println();
        maxDeger(l);


    }




    //1)List in elemanlarını aralarında boşluk bırakarak yanyana yazdır.(Method Reference- kendi metodumuz)
    public static void elemanYazdir(List<Integer> l) {
        l.stream().forEach(MethodLambda2::bosluklaYazdir);//15 14 9 13 4 9 2 4 14
    }

    //2)List in elemanlarından çift olanları aralarında boşluk bırakarak yanyana yazdır..(Method Reference)
    public static void ciftSayiYazdir(List<Integer> l) {
        l.stream().filter(MethodLambda2::ciftMi).forEach(MethodLambda2::bosluklaYazdir);//14 4 2 4 14
    }
    //3)List teki tek sayıların karelerini alıp aralarında boşluk bırakarak yanyana yazdır
    private static void tekSayiKAre(List<Integer> l) {
        l.stream().filter(MethodLambda2::tekMi).map(MethodLambda2::kareAl).forEach(MethodLambda2::bosluklaYazdir);//225 81 169 81


    }
    //4)List teki tekrarlı olanları silip tek sayıların küplerini alıp aralarında boşluk bırakarak yanyana yazdır.
    private static void farkliTekSayiKup(List<Integer> l) {
        l.stream().distinct().filter(MethodLambda2::tekMi).map(MethodLambda2::kupAl).forEach(MethodLambda2::bosluklaYazdir);//3375 729 2197
        
    }
    //5)Farklı çift sayıların karelerinin toplamını yazdır (Use Method Reference)
    private static void farkliCifsayitoplam(List<Integer> l) {
        int a=l.stream().distinct().filter(MethodLambda2::ciftMi).map(MethodLambda2::kareAl).reduce(0,Math::addExact);
        System.out.println(a);//216
    }
    //6)Farklı çift sayıların küplerinin çarpımını yazdır .(Use Method Reference)

    private static void farkliCiftSayiKup(List<Integer> l) {
        l.stream().distinct().filter(MethodLambda2::ciftMi).map(MethodLambda2::kupAl).reduce(1,Math::multiplyExact);

    }
    //7)List teki farklı ve 5 ten büyük ve cift  elemanlarının yarısını alıp ters sıralayarak list olarak yazdır.(Use Me
    private static List farkliTersSirala(List<Integer> l) {
      return  l.stream().distinct().filter(t->t>5 && t%2==0).map(t->t/2).sorted(Comparator.reverseOrder()).collect(Collectors.toList());//[7]

    }

//8)List teki en büyük elemanı bul.(Use Method Reference)
    private static void maxDeger(List<Integer> l) {
     int a= l.stream().reduce(Integer.MAX_VALUE,Math::min)  ;
        System.out.println("Listteki en kucuk sayi :  " +a);//Listteki en kucuk sayi :  2

     int b= l.stream().reduce(Integer.MIN_VALUE,Math::max);
        System.out.println("Listteki en buyuk sayi : " +b);//Listteki en buyuk sayi : 15


     l.stream().sorted(Comparator.reverseOrder()).limit(1).forEach(MethodLambda2::bosluklaYazdir);//15
        System.out.println();
       l.stream().sorted().limit(1).forEach(MethodLambda2::bosluklaYazdir);//2



    }





}
