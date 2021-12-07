package lambda04;

import lambda02.MethodLambda2;

import java.util.stream.IntStream;

public class Lambda01 {

    public static void main(String[] args) {
        //1'den 20'ye kadar olan sayilari yazdir.
        IntStream.rangeClosed(1,20).forEach(MethodLambda2::bosluklaYazdir);//baslangic ve bitis degerleri dahil.-->1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20

        System.out.println();

        //2) functional programlamayı kullanarak 3 den ile 98 e kadar olan çift tam sayıların toplamını bulun
        IntStream.rangeClosed(3,98).filter(MethodLambda2::ciftMi).forEach(MethodLambda2::bosluklaYazdir);//4 6 8 10 12 14 16 18 20 22 24 26 28 30 32 34 36 38 40 42 44 46 48 50 52 54 56 58 60 62 64 66 68 70 72 74 76 78 80 82 84 86 88 90 92 94 96 98
        System.out.println();
        System.out.println(IntStream.rangeClosed(3, 98).filter(t -> t % 2 == 0).reduce(0,Math::addExact));

        System.out.println(IntStream.rangeClosed(3,98).filter(t->t%2==0).sum());

        //3) functional programming kullanarak 9! i bul (9!=1*2*3...*9)
        System.out.println(IntStream.rangeClosed(1, 9).reduce(1, Math::multiplyExact));//362880

        // 4) İlk 7 çift sayma sayısının çarpımını bulun (2,4,6,8,10,12,14)
        System.out.println(IntStream.rangeClosed(1, 14).filter(t -> t % 2 == 0).reduce(1, Math::multiplyExact));

        //5)  6'dan büyük ilk 15 tek sayma sayısının toplamını bulun ==> 7, 9, 11, 13, 15, 17, 19
        System.out.println(IntStream.iterate(7, t -> t + 2).limit(150).sum());//23400

        //6) İlk 23 cift sayma sayısının toplamını bulun
        System.out.println(IntStream.iterate(2, t -> t + 2).limit(23).sum());//552

        //5)  (11'den 33 e kadar her tam sayının rakamlarının toplamını hesaplamak için bir metod oluşturun
        IntStream.rangeClosed(11,33).map(MethodLambda2::rakamlarToplami).forEach(MethodLambda2::bosluklaYazdir);//2 3 4 5 6 7 8 9 10 2 3 4 5 6 7 8 9 10 11 3 4 5 6



    }
}
