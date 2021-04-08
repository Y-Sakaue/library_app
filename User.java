package library_app;


import java.util.Scanner;

public class User {
    private String[] passWord;
    private String[] userId;
    private String[] userFirstName;
    private String[] userLastName;
    //本の貸し出し状況
    private int[] rentNum = new int[]{0};   

//空のコンストラクタ
public User(){}
//コンストラクタ：ユーザー氏名, ID, PW,の登録　+ rentNum(貸出中の本数)の値の初期化(0を代入)
    public User(String[] _userFirstName, String[] _userLastName, String[] _userId ,String[] _passWord){
        this.userFirstName = _userFirstName;
        this.userLastName = _userLastName;
        this.userId = _userId;
        this.passWord = _passWord;
        
        setRentNum(userId.length);
    }
    //要素数の分だけrentNumのインスタンスを作成してインスタンスの中に0をデフォルト値として代入する
    private void setRentNum(int length){
        for(int i = 0; i < length; i++){
            this.rentNum = new int[length];
            this.rentNum[i]=0;
        }
    }

    //ユーザーの貸出本数を+1するメソッド
    public int incrementUserRentNum(int userIndex){        
        this.rentNum[userIndex] =+ getRentNum(userIndex);
        return this.rentNum[userIndex];
    }     
    // ユーザー情報を出力するメソッド
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
    //貸出中の本の数を取得メソッド
    private int getRentNum(int index){
        return rentNum[index];
    }
    //貸出可能な本の数を取得するメソッド
    private int canRentNum(int index){
        int result = 5 - rentNum[index];
        if(rentNum[index] >= 5){result=0;}
        return result;
    }
}

