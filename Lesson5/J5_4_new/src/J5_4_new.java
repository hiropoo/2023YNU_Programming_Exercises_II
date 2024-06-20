public class J5_4_new {
    public static void main(String[] args) throws Exception {
        // Computerクラスのインスタンスを3つ作成
        Computer_new[] computers = {
            new Computer_new('①'),
            new Computer_new('②'),
            new Computer_new('③')
        };

        // 3x3のボードの初期化
        Board_new.clear();

        int index = 0;  // 配列computersのindexに使用

        // 3つのComputerクラスのインスタンスが交互にBoardのマスに自身のシンボルを置くようにする
        while(computers[index].put()) {
            Board_new.print();
            // indexが0 ~ 2をループするようにインクリメント
            index = (index == 2) ? 0 : index+1;
        }
    }
}
