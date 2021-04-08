package library_app;


import java.util.Scanner;

public class User {
    private String[] passWord;
    String[] userId;
    private String[] userFirstName;
    private String[] userLastName;

    //本の貸し出し状況
    public int[] rentNum = new int[]{0};
    
    

//空のコンストラクタ
public User(){}


//ユーザーの情報を登録するためのコンストラクタ
//実装したい内容：ユーザー氏名, ID, PW,の登録　+ rentNum(貸出中の本数)の値の初期化(0を代入)
    public User(String[] _userFirstName, String[] _userLastName, String[] _userId ,String[] _passWord){
        this.userFirstName = _userFirstName;
        this.userLastName = _userLastName;
        this.userId = _userId;
        this.passWord = _passWord;
        
        setRentNum(userId.length);
    }
    //コンストラクタから配列の引数が渡された後に呼び出されるメソッド
    //フィールド内の一つのフィールドの配列の要素数をパラメータに設定し
    //要素数の分だけrentNumのインスタンスを作成してインスタンスの中に0をデフォルト値として代入する
    private void setRentNum(int length){
        for(int i = 0; i < length; i++){
            this.rentNum = new int[length];
            this.rentNum[i]=0;
        }
    }

    public int getUserRentNum(int userIndex){
        int result = rentNum[userIndex];
        return result;
    }

    public void setRentNum(int newRentNum, int index){
        this.rentNum[index]= newRentNum;
    }
    //ユーザーIDとパスワードが一致するユーザーのインデックスを取得
    public int getUserIndex(){
        int result = 0;        
        int i=0;

        Scanner obj = new Scanner(System.in);
        System.out.print("ユーザーID：");
        String id = obj.nextLine();

        System.out.print("パスワード：");
        String pass = obj.nextLine();  
        obj.close();     

        for(; i < userFirstName.length; i++){
            if(userId[i].equals(id)&& passWord[i].equals(pass)){
                result = i;
            }
        }        
        return result;
    }


    
    // ユーザー情報をプリントする
    public void printUserInfo(){
        int i=0;
        boolean idAndPassMatch = false;

        Scanner sc = new Scanner(System.in);
        System.out.print("ユーザーIDを入力：");
        String id= sc.next();

        System.out.print("パスワードを入力：");
        String pass= sc.next();
        sc.close();
                
            for(; i < this.userId.length; i++){                
                if(this.userId[i].equals(id) && this.passWord[i].equals(pass) ){
                    System.out.println("名前：" + userLastName[i] + " " + userFirstName[i] +
                                        "\n貸出中の本の数：" + getRentNum(i)+
                                        "\n貸出可能な本の数：" + canRentNum(i));
                    idAndPassMatch=true;
                                        break;              
                }
            }
            if(!idAndPassMatch){
                System.out.println("ユーザーIDまたはパスワードが正しくありません。");
            }                    
    }


    public String getUserInfo(String _passWord, String _userId){
            String result="";
            int i = 0;
        try{
            for(; i < passWord.length; i++){
                if(userId[i] == _userId && passWord[i] == _passWord){
                    result = userLastName[i] + " " + userFirstName[i];
                    break;
                }
            }            
        }catch(IndexOutOfBoundsException e){
            result ="パスワード、またはIDが正しくありません。";
        }
        return result;
    }

//貸出中の本の数を取得
    private int getRentNum(int index){
        return rentNum[index];
    }
//貸出可能な本の数を取得
    private int canRentNum(int index){
        int result = 5 - rentNum[index];
        if(rentNum[index] >= 5){
            result=0;
        }
        return result;
    }
}

