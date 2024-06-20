public interface Light {
    // 指示を示す文字列定数配列」
    String[] INSTRUCTION = {"Walk", "Stop", "Caution"};

    // 指示を出力する抽象メソッド
    void print();
}
