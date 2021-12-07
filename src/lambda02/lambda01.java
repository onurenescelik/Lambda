package lambda02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
//  sorted(): list i natural order a göre sıralar.
//sorted(Comparator.reverseOrder()):büyükten küçüğe sıralamak istersek, Comparator class ından reverseOrder() metoduyla
//terse çevirip sorted() ile büyükten küçüğe sıralamış oluyoruz
// sorted(Comparator.comparing(t-> t.length())):elemanları kendi istediğimiz bir duruma göre sıralamak istediğimizde
//    örneğin burada elemanların length() ine göre sıralamışız
public class lambda01 {
    public static void main(String[] args) {
        List<Integer> l=new ArrayList<>(Arrays.asList(14,9,13,4,9,2,4,14,15));
        tekrarsizCiftKupCarpimi(l);
        System.out.println();
        tersDuzSira(l);

    }



    //6)listedeki tekrarli elemanlari silip cift olanlarin kuplerinin carpimini yazdiran method olusturun.
    private static void tekrarsizCiftKupCarpimi(List<Integer> l) {

       int a=l.stream().distinct().filter(t -> t % 2 == 0).map(t -> t * t * t).reduce(1, (x, y) -> x * y);
        System.out.println(a);
    }
    //7)Listedeki elemanları sıralayarak ve ters sıralayarak yazdır

    public static void tersDuzSira(List<Integer> l) {
        l.stream().sorted().forEach(t-> System.out.print(t+" "));//2 4 4 9 9 13 14 14 15
        System.out.println();
        l.stream().sorted(Comparator.reverseOrder()).forEach(t-> System.out.print(t+" "));//15 14 14 13 9 9 4 4 2

    }

}
