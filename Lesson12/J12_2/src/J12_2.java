import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class J12_2 extends JFrame {
    public static void main(String[] args) throws Exception {
        J12_2 frame = new J12_2("課題2");
        frame.setVisible(true);
    }

    public J12_2(String title) {
        // 初期設定
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(200, 200));
        setLocationRelativeTo(null);

        // 入力や計算結果を表示するラベル
        JLabel resultLabel = new JLabel("0");
        resultLabel.setHorizontalAlignment(JLabel.CENTER);  // 表示される文字列を中央揃え
        
        // 結果を表示するパネル
        JPanel resultPanel = new JPanel();
        resultPanel.add(resultLabel);

        
        // ボタンの作成とアクションリスナーの追加
        JButton[] numButtons = new JButton[10];
        ButtonAction actionListener = new ButtonAction(resultLabel);

        JButton plusButton = new JButton("+");
        JButton eqButton = new JButton("=");
        plusButton.addActionListener(actionListener);
        eqButton.addActionListener(actionListener);
        for (int i = 0; i < 10; i++) {
            numButtons[i] = new JButton(Integer.toString(i));
            numButtons[i].addActionListener(actionListener);
        }
        
        // ボタンをを表示するパネル
        JPanel buttonPanel = new JPanel(new GridLayout(4, 3));
        for (int i = 0; i < numButtons.length; i++) {
            buttonPanel.add(numButtons[i]);
        }
        buttonPanel.add(plusButton);
        buttonPanel.add(eqButton);


        add(resultPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }
}
