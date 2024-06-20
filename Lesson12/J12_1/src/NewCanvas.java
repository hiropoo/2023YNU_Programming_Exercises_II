import java.awt.*;


public class NewCanvas extends Canvas {
    /* インスタンス変数 */
    private Point circlePoint = new Point(150, 150);    // 円の座標
    private Color circleColor = Color.BLUE;                 // 円の色

    // 円の色のセッター
    public void setCircleColor(Color circleColor) {
        this.circleColor = circleColor;
    }

    // 円の座標を (x, y) だけずらすメソッド
    public void translatePosition(int x, int y) {
        circlePoint.translate(x, y);
    }

    // 円の座標を初期状態に戻すメソッド
    public void initPosition() {
        circlePoint.setLocation(getWidth()/2, getWidth()/2);
    }


    // Canvasに描画するものを記述
    @Override
    public void paint(Graphics g) {
        // 正方形を描画
        g.setColor(new Color(255, 160, 160));
        g.fillRect(10, 10, 280, 280);

        // 球を描画
        g.setColor(circleColor);
        g.fillOval((int)circlePoint.getX()-10, (int)circlePoint.getY()-10, 20, 20);
    }
}
