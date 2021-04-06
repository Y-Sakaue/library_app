package library_app;

import java.util.Scanner;
public class Test {
    public static void main(String[] args){
        Book bookList = new Book(
            new String[]{"ハリーポッター", "ロード・オブ・ザリング", "ダレン・シャン", "デモナータ"}, 
            new String[]{"J･K･ローリング","J･R･R･トールキン", "ダレン・シャン", "ダレン・シャン"}, 
            new int[]{400,600,350,400}
            );

            bookList.dispAllBook();
                                   
            // System.out.println("登録されてる書籍のすべてをリスト表示");
            // bookList.dispAllBook();

            User user = new User(new String[]{"勇次", "千晴"}, new String[]{"坂上","田中"}, new String[]{"y.sakaue","c.tanaka"}, new String[]{"Yuuji", "Chiharu"});

          
            user.printUserInfo();
             
    }
}