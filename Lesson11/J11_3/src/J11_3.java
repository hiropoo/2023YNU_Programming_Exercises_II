import java.awt.*;
import javax.swing.*;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class J11_3 extends JFrame implements ChangeListener {
    /* インスタンス変数 */

    // Canvas (指定されたRGBカラーを表示)
    Canvas myCanvas;

    // スライダー   (rgbを設定)
    JSlider rSlider;
    JSlider gSlider;
    JSlider bSlider;

    // ラベル   (rgbの各値を表示)
    JLabel rValue;
    JLabel gValue;
    JLabel bValue;

    /* インスタンス変数ここまで */


    public static void main(String[] args) throws Exception {
        // フレームの作成
        J11_3 frame = new J11_3("カラーパレット");
        frame.setVisible(true);
    }

    // フレームの作成
    public J11_3(String title) {
        // 初期設定
        setTitle(title);
        setSize(300, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 画面の中央に設置
        // setResizable(false);    // サイズ固定

        // Canvasの作成
        myCanvas = new Canvas();
        myCanvas.setBackground(new Color(127, 127, 127));
        myCanvas.setMaximumSize(new Dimension(280, 280));

        // スライダーの作成
        rSlider = new JSlider(0, 255);
        gSlider = new JSlider(0, 255);
        bSlider = new JSlider(0, 255);

        // スライダーにChangeListenerを設定
        rSlider.addChangeListener(this);
        gSlider.addChangeListener(this);
        bSlider.addChangeListener(this);

        // スライダーの値を表示するラベルの作成
        rValue = new JLabel("R " + rSlider.getValue());
        gValue = new JLabel("G " + gSlider.getValue());
        bValue = new JLabel("B " + bSlider.getValue());

        // 中央揃えに設定
        rValue.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        gValue.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        bValue.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        // 全体のパネル ( Columnパネル )
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBorder(new EmptyBorder(new Insets(10, 10, 20, 10)));   // marginを設定

        panel.add(myCanvas);
        panel.add(rSlider);
        panel.add(rValue);
        panel.add(gSlider);
        panel.add(gValue);
        panel.add(bSlider);
        panel.add(bValue);

        // contentPaneに追加
        getContentPane().add(panel);
    }


    @Override
    public void stateChanged(ChangeEvent e) {
        // スライダーの変更があればラベルに表示する値を更新
        rValue.setText("R " + rSlider.getValue());
        gValue.setText("G " + gSlider.getValue());
        bValue.setText("B " + bSlider.getValue());

        // 決まったRGBにCanvasのカラーを変更
        myCanvas.setBackground(new Color(rSlider.getValue(), gSlider.getValue(), bSlider.getValue()));
    }
   
}