import java.util.HashMap;

public class Prefecture {
    // Hashする値
    public String[][] str = {
            { "東京都", "神奈川県", "埼玉県", "千葉県", "茨城県", "栃木県", "群馬県" },
            { "新宿区", "横浜市", "さいたま市", "千葉市", "水戸市", "宇都宮市", "前橋市" }
    };

    // Hashのキー
    public String[] strkey = { "tokyo", "kanagawa", "saitama", "chiba", "ibaraki", "tochigi", "gunma" };

    // HashMapの作成
    public HashMap<String, String> map = new HashMap<>();
    {
        for (int i = 0; i < strkey.length; i++) {
            map.put(strkey[i], (str[0][i] + " , " + str[1][i]));
        }
    }
    

    // toStringをオーバーライド
    // 戻り値が key : 都道府県名 , 県庁所在地名 ... となるように設定
    @Override
    public String toString() {
        String retStr = "";   // 戻り値

        // key : 都道府県名 , 県庁所在地名 
        for (int i = 0; i < strkey.length; i++) {
            retStr += strkey[i] + " : " + str[0][i] + " , " + str[1][i] + "\n";
        }

        return retStr;
    }
}
