package library_app;

import java.util.Scanner;

public class Book {
    //フィールド
    private String[] title;
    private String[] author;
    private int[] pages;
    private boolean[] isRent= new boolean[]{false};

    //デフォルトコンストラクタ
    public Book(){}

    //パラメータ有コンストラクタ
    public Book(String[] _title, String[] _author, int[] _pages){
        this.title = _title;
        this.author = _author;
        this.pages = _pages;       
        
        setDefaultisRent(title.length);
    }
    private void setDefaultisRent(int length){
        for(int i = 0 ; i < length; i++){
            this.isRent = new boolean[length];
            this.isRent[i]=false;
        }
    }
    //本を検索し結果を出力するメソッド
    public int searchByTitle(){
        int i=0;

        Scanner sc = new Scanner(System.in);
        System.out.print("本を検索：");
        String search = sc.nextLine();
        sc.close();
        //TODO Scannerのnextメソッドがアルファベット以外に対応していないため日本語を入力すると文字化けする
        try{
            for(; i < title.length; i++){
                if(this.title[i].contains(search)){
                    System.out.println(
                    "タイトル：" + title[i]
                    + "|| 作者：" + author[i]
                    + "|| ページ数" + pages[i]
                    + "\n");
                    if(isRent[i]){
                        System.out.println("ステータス：貸出中");
                    }else{
                        System.out.println("ステータス：貸出可能");
                    }                  
                }else{System.out.println("search!=title[i]");}
            }
        }catch(IndexOutOfBoundsException e){System.out.println("お探しの本は見つかりませんでした。");}
        return i;
    }

    //登録されたすべての本の情報を出力するメソッド
    public void dispAllBook(){
        try{
            for(int i =0; i < title.length; i++){
                System.out.println("タイトル：" + title[i]);
                System.out.println("著者" + author[i]);
                System.out.println("ページ数：" + pages[i]);
                if(isRent[i]){
                    System.out.println("ステータス：貸出中");
                }else{
                    System.out.println("ステータス：貸出可能");
                }
                System.out.println("");
            }
        }catch(IndexOutOfBoundsException e){
            System.out.println("\n...以上");
        }        
    }

    //本を出力するメソッド    
    public void searchByIndex(int index){
        System.out.println(
            "タイトル：" + title[index]
            + "\n作者：" + author[index]
            + "\nページ数" + pages[index]
            + "\n"
              );
    }
    public void searchByTitle(String _title){
        try{
            for(int i = 0; true; i++){
                if(title[i].contains(_title)){
                    System.out.println(
                    "タイトル：" + title[i]
                    + "\n作者：" + author[i]
                    + "\nページ数" + pages[i]
                    + "\n");
                    if(isRent[i]){
                        System.out.println("ステータス：貸出中");
                    }else{
                        System.out.println("ステータス：貸出可能");
                    }                    
                    break;
                }
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("お探しのタイトルの本は見つかりませんでした。");
        }                
    }            
    public void searchByAuthor(String _author){      
        try{
            for(int i = 0; true; i++){
                if(author[i].contains(_author)){
                    System.out.println(
                    "タイトル：" + title[i]
                    + "\n作者：" + author[i]
                    + "\nページ数：" + pages[i]
                    + "\nステータス：" + isRent[i]);
                    break;
                }            
            }  
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("お探しの著者の本は見つかりませんでした。");
        }     
    }
}

