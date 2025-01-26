package JAVA101;
import java.util.Scanner;
public class Game {
    public static void main(String[] args) {
        System.out.println("oyunun kuralları:");
        System.out.println(" 1. açılmamış kutular 0 şeklinde gözükür.\n 2.açılan kutunun komşusunda veya kendisinde mayın yoksa 1 yazar. \n 3. açılan kutunun tek komşusu mayınlıysa -1 yazar");
        System.out.println(" 4. açılan kutunun 2 komşusu mayınlıysa -2 yazar. \n 5. açılan kutunun 3 komşusu mayınlıysa -3 yazar \n 6. açılan kutunun 4 komşusu mayınlıysa -4 yazar.");
        System.out.println(" bu liste böyle devam ediyor , mayına basılırsa oyun biter.Başarılar;)");
        Mine_Sweeper mine = new Mine_Sweeper(3,3);
        mine.run();
    }
}

