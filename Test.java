package library_app;

public class Test {
    public static void main(String[] args){
        Book bookList = new Book(
            new String[]{"ハリーポッター", "ロード・オブ・ザリング", "ダレン・シャン", "デモナータ"}, 
            new String[]{"J･K･ローリング","J･R･R･トールキン", "ダレン・シャン", "ダレン・シャン"}, 
            new int[]{400,600,350,400},
            new boolean[]{false,false,false,false}
            );
                                   
            // System.out.println("登録されてる書籍のすべてをリスト表示");
            // bookList.dispAllBook();

            // User user = new User(new String[]{"勇次"}, new String[]{"坂上"}, new String[]{"y.sakaue"}, new String[]{"Yuuji"});

            // user.getUserInfo("Yuuji", "y.sakaue");
           
            // bookList.searchByTitleVer2("ロード");
            bookList.dispAllBook();
    }
}