import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class J11_1 extends JFrame implements ActionListener {
    // canvasの生成
    MyCanvas canvas = new MyCanvas();
        
    public static void main(String[] args) throws Exception {
        // フレームの生成
        J11_1 frame = new J11_1("三角関数");
        frame.setVisible(true);
    }

    // フレームの作成
    public J11_1(String title) {
        // 初期設定
        setTitle(title);
        setBounds(900, 200, 400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        canvas.setSize(361, 201);        // canvasの大きさを設定

        // 関数描画部分のパネル
        JPanel functionPanel = new JPanel();
        functionPanel.setBackground(Color.GREEN);
        functionPanel.add(canvas);
        


        // ボタンの設定
        JButton sinButton = new JButton("Sin");
        JButton cosButton = new JButton("Cos");
        sinButton.addActionListener(this);
        sinButton.setActionCommand("Sin");  // コマンドの設定: Sin
        cosButton.addActionListener(this);
        cosButton.setActionCommand("Cos");  // コマンドの設定: Cos
        

        // ボタン部分のパネル
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(sinButton);
        buttonPanel.add(cosButton);

        // Columnレイアウト
        JPanel colPanel = new JPanel();
        colPanel.setLayout(new BoxLayout(colPanel, BoxLayout.PAGE_AXIS));
        colPanel.add(functionPanel);
        colPanel.add(buttonPanel);


        // ContentPaneに追加
        getContentPane().add(colPanel, BorderLayout.CENTER);

    }
    

    // ボタンが押された時のイベントを作成
    @Override
    public void actionPerformed(ActionEvent e) {
        // 関数名を Sin / Cos に設定して再描画
        canvas.setFunctionName(e.getActionCommand());
        canvas.repaint();
    }

}

class MyCanvas extends Canvas {
    // 関数名を保存
    private String functionName = "Sin";

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    // CanvasでSin関数描画
    @Override
    public void paint(Graphics g) {

        // Sin曲線
        if (functionName.equals("Sin")) {
            for (int i = 0; i < 360 - 1; i++) {
                double rad1 = i * (Math.PI / 180);
                double rad2 = (i + 1) * (Math.PI / 180);

                int y1 = 100 - (int) (Math.sin(rad1) * 100);
                int y2 = 100 - (int) (Math.sin(rad2) * 100);

                g.drawLine(i, y1, i + 1, y2);
                g.drawString(functionName, getWidth() / 2, getHeight() / 6);
            }
        }
        // Cos曲線
        else if (functionName.equals("Cos")) {
            for (int i = 0; i < 360 - 1; i++) {
                double rad1 = i * (Math.PI / 180);
                double rad2 = (i + 1) * (Math.PI / 180);

                int y1 = 100 - (int) (Math.cos(rad1) * 100);
                int y2 = 100 - (int) (Math.cos(rad2) * 100);

                g.drawLine(i, y1, i + 1, y2);
                g.drawString(functionName, getWidth() / 2, getHeight() / 6);
            }
        }
    }
}