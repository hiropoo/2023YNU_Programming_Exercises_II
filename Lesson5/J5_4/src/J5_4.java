public class J5_4 {
    public static void main(String[] args) throws Exception {
        // Computerクラスのインスタンスを3つ作成
        Computer[] computers = {
            new Computer('①'),
            new Computer('②'),
            new Computer('③')
        };

        // 3x3のボードの初期化
        Board.clear();

        int index = 0;  // 配列computersのindexに使用

        // 3つのComputerクラスのインスタンスが交互にBoardのマスに自身のシンボルを置くようにする
        while(computers[index].put()) {
            Board.print();
            // indexが0 ~ 2をループするようにインクリメント
            index = (index == 2) ? 0 : index+1;
        }
    }
}
