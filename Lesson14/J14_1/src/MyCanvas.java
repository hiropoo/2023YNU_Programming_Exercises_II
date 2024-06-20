import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

public class MyCanvas extends Canvas {
    /* インスタンス変数 */
    private Dimension size;                       // Canvasのサイズを取得
    private Image back;                           // ダブルバッファリング用のバッファイメージ
    private Graphics buffer;                      // ダブルバッファリング用のGraphicsオブジェクト
    private int c = 150;                          // Canvasの背景色のカラーコード
    private int radius = 50;                      // 円運動の半径
    private Point point = new Point(0, 0);    // 円運動する物体の座標
    private int degree = 0;                       // 円運動する物体の角度（度）


    // 円運動の半径のセッター
    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    
    // 物体の角度を1増やすメソッド
    public void increaseDegree() {
        this.degree++;
        if(degree == 360) {
            degree = 0;
        }
    }
    
    // 背景の色を変更するメソッド
    // 背景の色を一周で次のように変化させる
    // Color(0 , 0, 0) => Color(255, 255, 255) => Color(0 ,0 , 0) 
    public void changeColor() {
        if(degree >= 0 && degree < 180) {
            c = degree * 225 / 180;
        } else if (degree >= 180 && degree < 360) {
            c = 225 - ((degree - 180) * 225 / 180);
        } else {
            System.err.println("Unexpected Error at changeColor() :  degree =  " + degree);
        }
    }

    // Canvasの初期設定（ダブルバッファリングの設定）
    public void init() {
        size = getSize();
        back = createImage(size.width, size.height);
        buffer = back.getGraphics();
    }

    // 背景は paint() で塗りつぶしが行われるため
    // オーバーライドし、g.clearRect(0, 0, width, height);　を呼ばせないようにして
    // 無駄な画面のクリアをしない
    public void update(Graphics g) {
        paint(g);
    }

    // Canvasの描画処理
    public void paint(Graphics g) {
        // 背景をRGB(c, c, c)で描画
        buffer.setColor(new Color(c, c, c));
        for (int i = 0; i < size.width; i++) {
            buffer.drawLine(i, 0, i, size.height - 1);
        }

        // 円運動の軌跡を表示
        buffer.setColor(Color.RED); 
        buffer.drawOval(size.width/2 - radius, size.height/2 - radius, radius*2, radius*2);

        // 円運動する物体を表示
        updatePoint();
        buffer.setColor(Color.BLUE);
        buffer.fillOval(point.x-10, point.y-10, 20, 20);

        // 円運動する物体の座標を表示
        buffer.drawString("x = " + point.x + "  y = " + point.y, 30, size.height-5);

        g.drawImage(back, 0, 0, this);  // イメージ領域をまとめて描画
    }

    // 物体の座標を更新するメソッド
    private void updatePoint() {
        double rad = Math.toRadians(degree); // 弧度法からラジアンに変換
        point.x = (int)(radius * Math.cos(rad)) + size.width/2;  // 物体のx座標
        point.y = (int)(radius * Math.sin(rad)) + size.height/2;  // 物体のy座標
    }
  
}