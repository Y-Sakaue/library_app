package library_app;

public class User {
    private String[] passWord;
    private String[] userId;
    private String[] userFirstName;
    private String[] userLastName;

    //本の貸し出し状況
    private int[] rentNum;
    private int[] rentBookIndex;

//空のコンストラクタ
public User(){

}
    
//ユーザーの情報を登録するためのコンストラクタ(ユーザー氏名, ID, PW, rentNum(貸出中の本数)の値の初期化)
    public User(String[] _userFirstName, String[] _userLastName, String[] _userId ,String[] _passWord){
        this.userFirstName = _userFirstName;
        this.userLastName = _userLastName;
        this.userId = _userId;
        this.passWord = _passWord;

        for(int i = 0; i < userId.length; i++){
            this.rentNum = new int[]{0};
        }
    }

    // ユーザー情報をプリントする
    public void printUserInfo(String _passWord, String _userId){
        try{
            for(int i = 0; i <passWord.length; i++){
            
                if(userId[i] == _userId && passWord[i]==_passWord){
                    System.out.println("名前：" + userLastName[i] + " " + userFirstName[i] +
                                        "\n貸出中の本の数：" + getRentNum(i)+
                                        "\n貸出可能な本の数：" + canRentNum(i));                
                }
            }
        }catch(IndexOutOfBoundsException e){
            System.out.println("パスワード、又はIDが正しくありません。");
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
        if(rentNum[index] <= 0){
            result=0;
        }
        return result;
    }


}
