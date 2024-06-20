import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class J11_2 extends JFrame implements ActionListener {
    // インスタンス変数
    private JLabel resultJLabel; // 計算結果を表示するラベル
    private JTextField textField; // 計算の引数を入力するテキストフィールド
    ButtonGroup buttonGroup;


    public static void main(String[] args) throws Exception {
        // フレームを作成
        J11_2 frame = new J11_2("Computer");
        frame.setVisible(true);
    }

    public J11_2(String title) {
        // 初期設定
        setTitle(title);
        setBounds(300, 300, 300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // 計算結果を表示するラベルとそれを囲うパネル
        resultJLabel = new JLabel(" ");
        resultJLabel.setPreferredSize(new Dimension(100, 50));
        resultJLabel.setFont(new Font(Font.DIALOG, Font.PLAIN, 15)); // フォントの設定;
        JPanel resultPanel = new JPanel();
        resultPanel.add(resultJLabel);

        // 計算のための引数を入力するテキストフィールドとそれを囲うパネル
        textField = new JTextField(20);
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setToolTipText("関数の引数の値を入力してください");
        JPanel textPanel = new JPanel();
        textPanel.add(textField);


        // ラジオボタンを生成
        JRadioButton[] radioButtons = {
            new JRadioButton("Sin", true),
            new JRadioButton("Cos"),
            new JRadioButton("Tan"),
        };

        // ラジオボタンにActionCommandを追加
        radioButtons[0].setActionCommand("Sin");
        radioButtons[1].setActionCommand("Cos");
        radioButtons[2].setActionCommand("Tan");

        // ラジオボタンのパネル
        JPanel radioButtonPanel = new JPanel();

        // ボタングループ
        buttonGroup = new ButtonGroup();
        
        // ラジオボタンをパネルに追加 & ボタングループに追加 
        for (int i = 0; i < radioButtons.length; i++) {
            radioButtonPanel.add(radioButtons[i]);
            buttonGroup.add(radioButtons[i]);
        }

        // 計算開始するボタンとそれを囲うパネル
        JButton completeButton = new JButton("Complete");
        completeButton.addActionListener(this); // ActionListenerを追加
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(completeButton);
   

        // 全体のレイアウト: Columnレイアウト
        JPanel overallPanel = new JPanel();
        BoxLayout colLayout = new BoxLayout(overallPanel, BoxLayout.PAGE_AXIS);
        overallPanel.setLayout(colLayout);

        // コンポーネントとパネルを配置 (上から順に配置)
        overallPanel.add(resultPanel);
        overallPanel.add(textPanel);
        overallPanel.add(radioButtonPanel);
        overallPanel.add(buttonPanel);

       
        getContentPane().add(overallPanel);
    }


    // ボタンのイベント
    @Override
    public void actionPerformed(ActionEvent e) {
        // 選択された関数名を取得
        String functionName = buttonGroup.getSelection().getActionCommand();

        // 入力された引数の値を取得
        double arg = Double.valueOf(textField.getText());
        double radian = Math.toRadians(arg); // 弧度法をラジアンに変換
        double result = 0;
        
        switch (functionName) {
            case "Sin":
                result = Math.sin(radian);
                break;
            case "Cos":
                result = Math.cos(radian);
                break;
            case "Tan":
                result = Math.tan(radian);
                break;

            default:
                break;
        }
        
        // 計算結果を結果を表すラベルにセット
        resultJLabel.setText(String.format("%.9f", result));
    }
}
