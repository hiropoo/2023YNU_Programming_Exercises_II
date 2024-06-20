import java.io.Serializable;

public class Player implements Serializable {
    private String position;    // ポジション
    private String name;        // 名前
    private int year;           // 誕生年 
    private int month;          // 誕生月
    private int date;           // 誕生日
    
    static final long serialVersionUID = 1L;
    

    // コンストラクタ
    public Player(String position, String name, int year, int month, int date) {
        this.position = position;
        this.name = name;
        this.year = year;
        this.month = month;
        this.date = date;
    }


    // toString()をオーバーライドしてメンバ変数を表示
    @Override
    public String toString() {
        return String.format("%4d年%2d月%2d日 %s %s", year, month, date, position, name);
    }
    
}
