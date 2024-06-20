import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class J14_1 extends JFrame implements ChangeListener {
    /* インスタンス変数 */
    private MyCanvas canvas;        // Canvas
    private JSlider radiusSlider;   // 円運動の半径を決めるスライダー
    private JSlider speedSlider;    // 円運動する物体の速度を決めるスライダー
    private JLabel radiusLabel;     // 円運動の半径を表示するラベル
    private JLabel speedLabel;      // 円運動する物体のスピードを表示するラベル
    private int speed = 27;         // 物体のスピード（再描画の頻度）


    public static void main(String[] args) {
        new J14_1("円運動");
    }

    // フレームの描画処理
    public J14_1(String title) {
        // Canvas部分
        JPanel canvasPanel = getCanvasPanel();

        // スライダー部分
        JPanel sliderPanel = getSliderPanel();


        // フレームに追加
        add(canvasPanel, BorderLayout.NORTH);
        add(sliderPanel, BorderLayout.CENTER);

        // フレームの設定
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 450);
        setLocationRelativeTo(null);
        setVisible(true);


        // 一定間隔ごとに Canvas 内の物体を動かし再描画を行う
        drawAnimation();

    }


    // Canvas部分のパネルを生成
    private JPanel getCanvasPanel() {
        canvas = new MyCanvas();
        canvas.setSize(290, 290);
        JPanel canvasPanel = new JPanel();
        canvasPanel.add(canvas);
        return canvasPanel;
    }
    
    
    // スライダー部分のパネルを生成
    private JPanel getSliderPanel() {
        radiusSlider = new JSlider();
        speedSlider = new JSlider();
        
        // スライダーの値を表示するラベル
        radiusLabel = new JLabel("半径 50");   
        speedLabel = new JLabel("速度 50");
        
        JPanel radiusPanel = new JPanel();  // ラベルを中央揃え
        radiusPanel.add(radiusLabel);
        JPanel speedPanel = new JPanel();
        speedPanel.add(speedLabel);
        
        // リスナーの追加
        radiusSlider.addChangeListener(this);
        speedSlider.addChangeListener(this);
        
        // 全体を縦に並べるパネル
        JPanel sliderPanel = new JPanel();
        sliderPanel.setLayout(new BoxLayout(sliderPanel, BoxLayout.PAGE_AXIS));
        sliderPanel.add(radiusSlider);
        sliderPanel.add(radiusPanel);
        sliderPanel.add(speedSlider);
        sliderPanel.add(speedPanel);
        
        return sliderPanel;
    }
    
    
    // 一定間隔ごとに Canvas 内の物体を動かし再描画を行うメソッド
    private void drawAnimation() {
        // Canvasの初期設定
        canvas.init();

        // 一定の間隔ごとにCanvasを描画
        while (true) {
            if(speed != 0) {
                try {
                    // 描画する速度を変更
                    Thread.sleep(300/speed);
                } catch (InterruptedException e) {
                }
                canvas.increaseDegree();    // 物体の角度を1度動かす
                canvas.changeColor();       // 物体が動くたびにCanvasの背景色を変更
                canvas.repaint();   // Canvasの再描画
            } 
            // スピードが0の場合は 100ms 停止
            else {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }
            }
            
        }
    }


    // スライダーの変化ごとに発生させるイベント処理
    @Override
    public void stateChanged(ChangeEvent e) {
        // 変更されたスライダーを取得
        JSlider selectedSlider = (JSlider)e.getSource();

        // 円運動の半径が変更された場合
        if (selectedSlider == radiusSlider) {
            // Canvasにて半径の変更を反映
            canvas.setRadius(selectedSlider.getValue());
            
            // 半径の値の表示を更新
            radiusLabel.setText("半径 " + String.valueOf(radiusSlider.getValue())); 
        } 
        // 円運動の速度が変更された場合
        else if(selectedSlider == speedSlider) {
            // 物体の速度（描画の頻度）の変更を反映
            speed = speedSlider.getValue();
            
            // 速度の値の表示を更新
            speedLabel.setText("速度 " + String.valueOf(speedSlider.getValue()));
        } else {
            System.err.println("Unexpected Error at stateChanged() : " + e.getSource());
        }
        
    }

}