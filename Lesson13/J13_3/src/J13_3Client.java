import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class J13_3Client extends JFrame implements ActionListener {
    /* クラス変数, インスタンス変数 */
    private static int port;
    private static String serverName;
    private JTextField inputField;
    private JTextField outputField;

    public static void main(String[] args) throws Exception {
        // ポートとホスト名を保存
        port = Integer.parseInt(args[0]);
        serverName = args[1];

        // フレームを表示
        J13_3Client frame = new J13_3Client("課題3");
        frame.setVisible(true);
    }

    // フレームの描画
    public J13_3Client(String title) {
        // 初期設定
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(160, 160));
        setLocationRelativeTo(null);

        // キーを入力するテキストフィールドとその結果を表示するテキストフィールド
        inputField = new JTextField("");
        outputField = new JTextField("");
        inputField.setHorizontalAlignment(JTextField.CENTER); // 入力の中央揃え
        outputField.setHorizontalAlignment(JTextField.CENTER);
        outputField.setEditable(false); // 出力用は編集不可
        inputField.setToolTipText("キーを入力してください");

        // 入出力するエリアのパネル
        JPanel textFieldPanel = new JPanel();
        textFieldPanel.setLayout(new BoxLayout(textFieldPanel, BoxLayout.PAGE_AXIS));
        textFieldPanel.add(inputField);
        textFieldPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        textFieldPanel.add(outputField);

        // 数字をサーバーに送信するボタン
        JButton submitButton = new JButton("送信");
        submitButton.addActionListener(this); // アクションを追加

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitButton);

        // フレームにコンポーネントを追加
        add(textFieldPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    // 送信ボタンが押された時のイベント処理
    // 入力されたキーをサーバーに送り対応する値を出力用のテキストフィールドに表示する
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // ソケットを作成
            Socket socket = new Socket(serverName, port);

            // サーバーに書き込むためのストリームを作成
            OutputStream os = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);

            // サーバーに入力したキーを送信
            oos.writeUTF(inputField.getText());
            oos.flush(); // 即座に送信

            // 送信したkeyをコンソールに出力
            System.out.println("----- Client -----");
            System.out.println(inputField.getText());

            // サーバーから読み取るためのストリームを作成
            InputStream is = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);

            // サーバーから受け取った値を出力用のテキストフィールドに出力
            String result = ois.readObject().toString();
            outputField.setText(result);

            // サーバーから受け取った値をコンソールに出力
            System.out.println(result + "\n");

            socket.close(); // 切断

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
