import java.util.Date;
import java.util.GregorianCalendar;

public class J9_1 {
    // 誕生日を表す変数
    static final int year = 2003;
    static final int month = 5;
    static final int date = 19;

    public static void main(String[] args) throws Exception {
        // 誕生日のカレンダーを表すGregorianCalendarオブジェクト
        GregorianCalendar birthdayCalendar = new GregorianCalendar(year, month-1, date);

        // 誕生日を表すDateオブジェクト
        Date birthday = birthdayCalendar.getTime();

        // 現在時刻を表すDateオブジェクト
        Date currentDate = new Date();

        // 誕生日と現在時刻との差(s)を保存
        long diffOfSeconds = (currentDate.getTime() - birthday.getTime()) / 1000;
        
        // 誕生日と現在時刻との差(日)を計算し保存
        long diffOfDates = diffOfSeconds / (60 * 60 * 24);

        // 誕生日と経過日数を出力
        System.out.printf("誕生日: %d年%d月%d日\n", year, month, date);
        System.out.printf("経過日数: %d日\n", diffOfDates);
    }
}
