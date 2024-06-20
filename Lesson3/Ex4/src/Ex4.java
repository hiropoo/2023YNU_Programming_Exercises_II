public class Ex4 {
    public static void main(String[] args) {
        
        // 2次元配列a(2x2), b(4x6)を定義
        int[][] a = {{11,12}, 
                     {21,22}};
        int[][] b = new int[4][6];      // bは初期値を与えない = 全要素が0

        // aをbにコピー
        cpyArray(a, b);

        // 配列を出力
        System.out.println("a[][]");
        printArray(a);
        System.out.println("b[][]");
        printArray(b);
        
    }


    // ２次元配列aを2次元配列bに次のようにコピーする静的メソッド
    public static void cpyArray(int [][] a, int [][] b) {
        System.arraycopy(a[0], 0, b[1], 2, 2);
        System.arraycopy(a[1], 0, b[2], 2, 2);
    }


    // 2次元配列arrを出力する静的メソッド
    public static void printArray(int [][] arr) {

        // 行数分の繰り返し処理 <i>
        for(int i = 0; i < arr.length; i++) {

            // 列数分の繰り返し処理 <j>
            for(int j = 0; j < arr[i].length; j++) {
                System.out.printf(" %2d", arr[i][j]);
            }

            System.out.println();   // 改行
        }
    }

}
