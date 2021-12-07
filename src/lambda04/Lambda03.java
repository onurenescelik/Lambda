package lambda04;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Lambda03 {
    public static void main(String[] args) {
        //functional programming kullanarak bir dosya nasıl okunur
        try {
            Files.lines(Paths.get("C:\\Users\\ONURENESCELIK\\IdeaProjects\\Lambda\\src\\lambda04\\ebik")).forEach(t-> System.out.println(t));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Tüm karakterleri büyük harfe dönüştürün ve okuyun
        try {
            Files.lines(Paths.get("C:\\Users\\ONURENESCELIK\\IdeaProjects\\Lambda\\src\\lambda04\\ebik")).map(String::toUpperCase).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //metindeki farklı kelimeleri yazdır
        try {
            Files.lines(Paths.get("C:\\Users\\ONURENESCELIK\\IdeaProjects\\Lambda\\src\\lambda04\\ebik")).map(t->t.split(" ")).
                    flatMap(Arrays::stream).map(t->t.replaceAll("\\W","")).distinct().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // metinde "e" içeren tüm kelimeleri yazdırın. (sayısınıda yazdırabilirsin)
        try {
        Files.lines(Paths.get("C:\\Users\\ONURENESCELIK\\IdeaProjects\\Lambda\\src\\lambda04\\ebik")).map(t->t.split(" ")).flatMap(Arrays::stream).filter(t->t.contains("e")).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
