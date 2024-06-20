public class j6_3 {
    public static void main(String[] args) throws Exception {
        // オブジェクトを生成
        Facility[] fac = {
            new Zoo("ズーラシア"),
            new Aquarium("エノスイ"),
            new Zoo("野毛山動物園"),
            new Zoo("金沢動物園"),
            new Aquarium("カワスイ"),
            new Aquarium("シーパラ"),
        };

        // 動物園のみ出力
        for (Facility facility : fac) {
            if(facility instanceof Zoo) 
                facility.print();
        }

        // 水族館のみ出力
        for (Facility facility : fac) {
            if(facility instanceof Aquarium) 
                facility.print();
        }

    }
}
