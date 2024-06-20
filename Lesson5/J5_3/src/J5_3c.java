public class J5_3c {
    public static void main(String[] args) throws Exception {
        // 改行コードを取得
        final String BR = System.getProperty("line.separator");

        // アップキャストzzzzzzzzz
        // Circle, Sphere, Cylinder, Cone の各クラスのインスタンスを作成
        Circle[] objects = {
            new Circle(4.0),
            new Sphere(4.0),
            new Cylinder(4.0, 3.5),
            new Cone(4.0, 3.5),
        };

        // 円の半径と面積を出力
        System.out.println("円の半径: " + objects[0].getRadius());
        System.out.println("円の面積: " + String.format("%6.3f", objects[0].getArea()) + BR);
        
        // 以下、ダウンキャストを使用
        
        // 球の半径と体積を出力
        System.out.println("球の半径: " + ((Sphere)objects[1]).getRadius());
        System.out.println("球の体積: " + String.format("%6.3f", ((Sphere)objects[1]).getVol()) + BR);
        
        // 円柱の半径と面積を出力
        System.out.println("円柱の半径: " + ((Cylinder)objects[2]).getRadius());
        System.out.println("円柱の高さ: " + ((Cylinder)objects[2]).getHeight());
        System.out.println("円柱の体積: " + String.format("%6.3f", ((Cylinder)objects[2]).getVol()) + BR);

        // 円錐の半径と面積を出力
        System.out.println("円錐の半径: " + ((Cone)objects[3]).getRadius());
        System.out.println("円錐の高さ: " + ((Cone)objects[3]).getHeight());
        System.out.println("円柱の体積: " + String.format("%6.3f", ((Cone)objects[3]).getVol()));
        
    }
}
