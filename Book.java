package library_app;

public class Book {
    //フィールド
    private String[] title;
    private String[] author;
    private int[] pages;
    private boolean[] isRent;

    //デフォルトコンストラクタ
    public Book(){

    }

    //パラメータ有コンストラクタ
    public Book(String[] _title, String[] _author, int[] _pages, boolean[] _isRent){
        this.title = _title;
        this.author = _author;
        this.pages = _pages;
        this.isRent = _isRent;
        
    }
    

    //それぞれのフィールドに格納された引数を返すメソッド
    public String[] getTitle(){return title;}
    public String[] getAuthor(){return author;}
    public int[] getPages(){return pages;}

    //登録されたすべての本の情報を出力するメソッド
    public void dispAllBook(){
        try{
            for(int i =0; true; i++){
                System.out.println("\nタイトル：" + title[i]);
                System.out.println("著者" + author[i]);
                System.out.println("ページ数：" + pages[i]);
                if(isRent[i]){
                    System.out.println("ステータス：貸出中");
                }else{
                    System.out.println("ステータス：貸出可能");
                }
            }
        }catch(IndexOutOfBoundsException e){
            System.out.println("\n...以上");
        }        
    }

    //インデックスの番号と対応する本を出力するメソッド    
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
                if(title[i] == _title){
                    System.out.println(
                    "タイトル：" + title[i]
                    + "\n作者：" + author[i]
                    + "\nページ数" + pages[i]
                    + "\n"
                    );
                    break;
                 }
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("お探しの本が見つかりませんでした。");
             }       
        }
        
        public void getIsRent(int index){
            System.out.println(isRent[index]);
        }

    public void searchByTitleVer2(String _title){
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
                    + "\nページ数" + pages[i]
                    + "\n");
                    break;
                }            
            }  
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("お探しの著者の本は見つかりませんでした。");
        }     
    }


}

