package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda01 {
    public static void main(String[] args) {

        List<Integer>l=new ArrayList<>(Arrays.asList(14,9,13,4,9,2,4,14,15));
        yazdirJava(l);
        System.out.println();
        yazdirLambda(l);
        System.out.println();
        ciftSayiJava(l);
        System.out.println();
        ciftSayiLambda(l);
        System.out.println();
        tekSayiKare(l);
        System.out.println();
        farkliTekKup(l);
        System.out.println();
        ciftSayiKareToplamJava(l);
        ciftSayiKareToplam(l);
        System.out.println();
        



    }




    //1)List'in elemanlarini yanyana yazdir(Java-Structured)
    public static void yazdirJava(List<Integer> l) {
        for (Integer w : l) {
            System.out.print(w + " ");
        }
    }
        //Lambda (functional)

        public static void yazdirLambda(List<Integer>l){

        l.stream().forEach(t-> System.out.print(t+" "));//14 9 13 4 9 2 4 14 15

        }

        //2)List in elemanlarından ÇİFT olanları aralarında boşluk bırakarak yazdıran metod oluştur(Structured)
        public static void ciftSayiJava(List<Integer> l) {
            for (Integer w:l) {
                if (w%2==0){
                    System.out.print(w+" ");
                }
                
            }
        }
        //lambda (functional)
        private static void ciftSayiLambda(List<Integer> l) {
                       //lambda expression(-> arrow function)
        l.stream().filter(t->t%2==0).forEach(t-> System.out.print(t+" "));//14 4 2 4 14
        }

    //3)List'teki tek sayilarin karelerini yazdiran method olusturun.

    public static void tekSayiKare(List<Integer> l) {
        l.stream().filter(t->t%2==1).map(t->t*t).forEach(t-> System.out.print(t+" "));

        //veya
        //l.stream().filter(t->t%2==1).forEach(t-> System.out.print(t*t+" "));


    }
    //4)Listedeki tekrarlı elemanları silip tek sayı olanların küplerini yazdıran metod oluştur
    public static void farkliTekKup(List<Integer> l) {
        l.stream().distinct().filter(t->t%2==1).map(t->t*t*t).forEach(t-> System.out.print(t+" "));
    }
    //5)Listedeki tekrarli elemanlari silip cift sayi olanlarin karelerinin toplamini yazdiran method olusturun
    private static void ciftSayiKareToplamJava(List<Integer> l) {
        List<Integer> yeni = new ArrayList<>();
        for (Integer w:l) {if (!yeni.contains(w)&&w%2==0)
            yeni.add(w);  //*************
        } int toplam = 0;
        for (Integer w:yeni) {
            toplam=toplam+w*w;
        }
        System.out.println("uzun yol: "+toplam);

    }
    private static void ciftSayiKareToplam(List<Integer> l) {
        System.out.println(l.stream().distinct().filter(t -> t % 2 == 0).map(t -> t * t).reduce(0, (x, y) -> x + y));
    }



}
