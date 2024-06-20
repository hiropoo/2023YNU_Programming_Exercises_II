import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.*;

public class J11_4 extends JFrame implements ActionListener {
    // インスタンス変数
    private JPasswordField passwordField;
    private JTextField inputTextField;
    private JLabel resultLabel;
    JTextArea resultArea;
    private int count = 0;

    // ランダムな 0 ~ 9 の重複しないlistを作成
    ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        J11_4 frame = new J11_4("Numer0n");
        frame.setVisible(true);
    }

    // フレーム処理
    public J11_4(String title) {
        // 初期設定
        setTitle(title);
        setSize(new Dimension(200, 300));
        setLocationRelativeTo(null); // 画面中央に設置
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        // 結果を表示するラベル
        resultLabel = new JLabel("RESULT");

        // 当てるパスワードを表示するパスワードフィールド
        passwordField = new JPasswordField();
        passwordField.setEnabled(false); // コピーや入力の禁止
        passwordField.setMaximumSize(new Dimension((int) (getWidth() * 0.7), 8));
        passwordField.setHorizontalAlignment(JPasswordField.CENTER); // 文字を中央に配置

        passwordField.setText(setNum()); // パスワードをランダムに設定

        // 予想を入力するテキストフィールド
        inputTextField = new JTextField(20);
        inputTextField.setMaximumSize(new Dimension((int) (getWidth() * 0.7), 8));
        inputTextField.setHorizontalAlignment(JPasswordField.CENTER); // 文字を中央に配置
        inputTextField.setToolTipText("4桁の数字を予想して入力しよう!");
        ((AbstractDocument) inputTextField.getDocument()).setDocumentFilter(new DocumentSizeFilter(4)); // ４桁の数字のみ入力を受け付け
        // テキストを全選択
        inputTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                ((JTextComponent) e.getComponent()).selectAll();
            }
        });

        // Guessボタン ( 予想を送信 )
        JButton guessButton = new JButton("Guess");
        guessButton.addActionListener(this);

        // 今までの結果を保存するパネル
        JScrollPane resultScrollPane = new JScrollPane();
        resultArea = new JTextArea();
        resultArea.setMargin(new Insets(10, 40, 10, 10));
        resultArea.setEditable(false);
        resultScrollPane.setBorder(new LineBorder(new Color(200, 225, 220)));
        resultScrollPane.setViewportView(resultArea);

        // 全体のレイアウトパネル
        // レイアウト: column
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        // コンポーネントを中央ぞろえ
        resultLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        passwordField.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        inputTextField.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        guessButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        resultScrollPane.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        // コンポーネントを追加
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // gap
        panel.add(resultLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 7))); // gap
        panel.add(passwordField);
        panel.add(Box.createRigidArea(new Dimension(0, 7))); // gap
        panel.add(inputTextField);
        panel.add(Box.createRigidArea(new Dimension(0, 7))); // gap
        panel.add(guessButton);
        panel.add(Box.createRigidArea(new Dimension(0, 7))); // gap
        panel.add(resultScrollPane);
        panel.add(Box.createRigidArea(new Dimension(0, 7))); // gap

        // ContentPaneにパネルを追加
        getContentPane().add(panel);
    }

    // パスワードをランダムに生成するメソッド
    private String setNum() {
        list.clear(); // リストの初期化

        // ランダムで重複しない0 ~ 9のlistを作成
        for (int i = 0; i < 10; i++) {
            list.add(Integer.toString(i));
        }
        Collections.shuffle(list);

        // listから最初の４つの数字とパスワードとする
        String password = "";
        for (int i = 0; i < 4; i++) {
            password += list.get(i);
        }
        return password; 
    }

    // ボタンが押された時の処理
    @Override
    public void actionPerformed(ActionEvent e) {
        // 文字数が４でなかったらなにもしない
        if (inputTextField.getText().length() != 4)
            return;

        count++; // 当てた回数を保存

        // eat（数字と桁があっている数）と bite（桁があっていないが同じ数字が含まれる数）を保存
        int eat = 0;
        int bite = 0;

        // パスワードと入力された値を取得
        String pass = new String(passwordField.getPassword());
        String input = inputTextField.getText();

        for (int i = 0; i < 4; i++) {
            char passNum = pass.charAt(i); // パスワードのi桁目
            Boolean match = (passNum == input.charAt(i)); // パスワードのi桁目と一致するかどうか
            Boolean isContained = input.contains(String.valueOf(passNum)); // パスワードのi桁目を含むかどうか

            // パスワードのi桁目の数字が、予想したものでも同じi桁目にあるとき
            if (match) {
                eat++;
            }
            // パスワードのi桁目の数字が、予想したものでは同じ桁にはないが別の箇所に存在するとき
            else if (isContained) {
                bite++;
            }
        }

        // 結果を表示
        resultLabel.setText(eat + " eat " + bite + " bite");

        // 結果を埋め込み
        resultArea.append(input + ": " + eat + " eat " + bite + " bite\n");

        // 完全に当てられた場合の処理
        if (eat == 4) {
            makeNewGame(pass, input);
        }
        System.out.println(pass);
    }

    // 当てられた時の処理。OptionPaneの表示ともういちど遊べるように設定
    private void makeNewGame(String pass, String input) {
        // 正解したと分かるようにOptionPaneを表示
        JLabel msg1 = new JLabel("正解！");
        msg1.setForeground(Color.RED);
        JLabel msg2 = new JLabel("正解の値: " + pass);
        JLabel msg3 = new JLabel("手数: " + count);
        JPanel msgPanel = new JPanel();
        msgPanel.setLayout(new BoxLayout(msgPanel, BoxLayout.PAGE_AXIS));
        msgPanel.add(msg1);
        msgPanel.add(msg2);
        msgPanel.add(msg3);

        JOptionPane.showMessageDialog(this, msgPanel, "正解おめでとう!", JOptionPane.INFORMATION_MESSAGE);
        // OptionPaneここまで

        // 新たなパスワードを設定
        passwordField.setText(setNum());
        // カウンターとeat, biteのリセット
        count = 0;
        // 結果と入力を表示するラベルのリセット
        resultLabel.setText("RESULT");
        inputTextField.setText("");
        resultArea.setText("");
    }

}

// 文字数を制限する DocumentFilter
class DocumentSizeFilter extends DocumentFilter {
    private int maxCharacters;

    public DocumentSizeFilter(int maxChars) {
        maxCharacters = maxChars;
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        int newLength = fb.getDocument().getLength() - length + text.length();
        if (newLength <= maxCharacters && text.matches("\\d*")) {
            super.replace(fb, offset, length, text, attrs);
        }
    }
}