import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class J13_2Client extends JFrame implements ActionListener{
    /* クラス変数, インスタンス変数 */
    private static int port;
    private static String serverName;
    private JTextField num1Field;
    private JTextField num2Field;
    private JLabel resultLabel;

    public static void main(String[] args) throws Exception {
        port = Integer.parseInt(args[0]);
        serverName = args[1];

        // フレームを表示
        J13_2Client frame = new J13_2Client("課題2");
        frame.setVisible(true);
    }


    // フレームの描画
    public J13_2Client(String title) {
        // 初期設定
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(160, 160));
        setLocationRelativeTo(null);


        // 数字を入力するテキストフィールド
        num1Field = new JTextField("");
        num2Field = new JTextField("");
        num1Field.setHorizontalAlignment(JTextField.CENTER);
        num2Field.setHorizontalAlignment(JTextField.CENTER);

        // 数字を入力するエリアのパネル
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.PAGE_AXIS));
        inputPanel.add(num1Field);
        inputPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        inputPanel.add(num2Field);
        
        // サーバーから受け取った結果を表示するラベル
        resultLabel = new JLabel(" ");
        resultLabel.setAlignmentX(CENTER_ALIGNMENT);
        JPanel resultPanel = new JPanel();
        resultPanel.add(resultLabel);

        // 数字をサーバーに送信するボタン
        JButton submitButton = new JButton("送信");
        submitButton.addActionListener(this);           // アクションを追加

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);


        // フレームにコンポーネントを追加
        add(inputPanel, BorderLayout.NORTH);
        add(resultPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }


    // 送信ボタンが押された時のイベント処理
    // サーバーに入力された二つの数字を送りその和をラベルに表示する
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // ソケットを作成
            Socket socket = new Socket(serverName, port);

            // サーバーに書き込むためのストリームを作成
            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);

            // サーバーに入力した数字を送信
            dos.writeInt(Integer.parseInt(num1Field.getText()));
            dos.writeInt(Integer.parseInt(num2Field.getText()));

            // サーバーから読み取るためのストリームを作成
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);

            // サーバーから受け取った値をラベルに出力
            resultLabel.setText(Integer.toString(dis.readInt()));

            socket.close();     // 切断

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
