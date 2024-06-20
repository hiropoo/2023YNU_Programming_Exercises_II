public class J5_3 {
    public static void main(String[] args) throws Exception {
        // 改行コードを取得
        final String BR = System.getProperty("line.separator");

        // Circle, Sphere, Cylinder, Cone の各クラスのインスタンスを作成
        Circle circle = new Circle(4.0);
        Sphere sphere = new Sphere(4.0);
        Cylinder cylinder = new Cylinder(4.0, 3.5);
        Cone cone = new Cone(4.0, 3.5);

        // 円の半径と面積を出力
        System.out.println("円の半径: " + circle.getRadius());
        System.out.println("円の面積: " + String.format("%6.3f", circle.getArea()) + BR);
        
        // 球の半径と体積zzzzzzzzzzzzzzzzzzzzzzzzzzを出力
        System.out.println("球の半径: " + sphere.getRadius());
        System.out.println("球の体積: " + String.format("%6.3f", sphere.getVol()) + BR);
        
        // 円柱の半径と面積を出力
        System.out.println("円柱の半径: " + cylinder.getRadius());
        System.out.println("円柱の高さ: " + cylinder.getHeight());
        System.out.println("円柱の体積: " + String.format("%6.3f", cylinder.getVol()) + BR);

        // 円錐の半径と面積を出力
        System.out.println("円錐の半径: " + cone.getRadius());
        System.out.println("円錐の高さ: " + cone.getHeight());
        System.out.println("円柱の体積: " + String.format("%6.3f", cone.getVol()));
        
    }
}
