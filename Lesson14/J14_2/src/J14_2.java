import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class J14_2 extends JFrame implements ActionListener {
    /* インスタンス変数 */
    private SlotThread[] slotThreads;   // スロットのスレッド
    private JButton[] stopButtons;  // ストップボタン
    private JButton startButton;    // スタートボタン
    private boolean isFirstPress = true;    // スタートボタンが初めて押されたかどうか

    public static void main(String[] args) throws Exception {
        J14_2 frame = new J14_2("スロットマシン");
        frame.setVisible(true);
    }

    public J14_2(String title) {
        // 初期設定
        setTitle(title);
        setSize(new Dimension(300, 250));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // スロットの数字が回転する部分を担うテキストフィールド
        JTextField[] slotNumbers = new JTextField[3];
        for (int i = 0; i < slotNumbers.length; i++) {
            slotNumbers[i] = new JTextField("0");
            slotNumbers[i].setEditable(false); // スロットの数字は編集不可
            slotNumbers[i].setFont(new Font("SanSerif", Font.ITALIC, 75));
            slotNumbers[i].setPreferredSize(new Dimension(90, 100));
            slotNumbers[i].setHorizontalAlignment(JTextField.CENTER); // 数字を中央揃え
        }

        // スロットのスレッドを生成
        slotThreads = new SlotThread[3];
        for (int i = 0; i < slotThreads.length; i++) {
            slotThreads[i] = new SlotThread(slotNumbers[i]);
        }

        // スロットを停止させるボタンの作成
        stopButtons = new JButton[3];
        for (int i = 0; i < stopButtons.length; i++) {
            stopButtons[i] = new JButton("stop" + i);
            stopButtons[i].setEnabled(false);         // 初期状態では無効
            stopButtons[i].setPreferredSize(new Dimension(90, 40));
            stopButtons[i].addActionListener(this);     // イベントリスナーを設定
        }

        // スロットの回転を開始するボタン
        startButton = new JButton("Start");
        startButton.setPreferredSize(new Dimension(200, 40));
        startButton.addActionListener(this);    // イベントリスナーを設定
        JPanel startButtonPanel = new JPanel();
        startButtonPanel.add(startButton);


        // グリッドバッグレイアウトのパネルを生成しコンポーネントを配置
        JPanel gridBagPanel = getGbPanel(slotNumbers);


        // フレームにコンポーネントを追加
        add(gridBagPanel);

    }

    // グリッドバッグレイアウトのパネルを生成しコンポーネントを配置するメソッド
    private JPanel getGbPanel(JTextField[] slotNumbers) {
        JPanel gridBagPanel = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagPanel.setLayout(gridBagLayout);
        GridBagConstraints gbc = new GridBagConstraints();

        // スロットをパネルに追加
        for (int i = 0; i < slotNumbers.length; i++) {
            gbc.gridx = i;
            gbc.gridy = 0;

            gridBagLayout.setConstraints(slotNumbers[i], gbc);
            gridBagPanel.add(slotNumbers[i]);
        }

        // ストップボタンをパネルに追加
        for (int i = 0; i < stopButtons.length; i++) {
            gbc.gridx = i;
            gbc.gridy = 1;

            gridBagLayout.setConstraints(stopButtons[i], gbc);
            gridBagPanel.add(stopButtons[i]);
        }

        // スタートボタンをパネルに追加
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3; // 幅3column分使う
        gridBagLayout.setConstraints(startButton, gbc);
        gridBagPanel.add(startButton);
        return gridBagPanel;
    }

    // ボタンが押された時の処理
    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedCommand = e.getActionCommand(); // 押されたボタンの名前

        switch (selectedCommand) {
            // スタートボタンが押された場合
            case "Start":
                startSlots();
                break;

            // stop0 ボタンが押された場合
            case "stop0":
                stopSlots(0);
                break;

            // stop1 ボタンが押された場合
            case "stop1":
                stopSlots(1);
                break;

            // stop2 ボタンが押された場合
            case "stop2":
                stopSlots(2);
                break;

            default:
                break;
        }

    }

    // 3つのスロットを開始するメソッド
    private void startSlots() {
        // スロットを active に設定
        for (int i = 0; i < slotThreads.length; i++) {
            slotThreads[i].setActive(true);
        }

        // 最初に呼ばれたときのみスレッドを開始
        if (isFirstPress) {
            // 3つのスロットを回転
            for (int i = 0; i < slotThreads.length; i++) {
                slotThreads[i].start();
            }
            isFirstPress = false;
        }

        // スタートボタンを無効化
        startButton.setEnabled(false);

        // ストップボタンを有効化
        for (int i = 0; i < stopButtons.length; i++) {
            stopButtons[i].setEnabled(true);
        }
    }


    // i番目のスロットを停止するメソッド
    private void stopSlots(int i) {
        slotThreads[i].setActive(false); // 回転を停止
        stopButtons[i].setEnabled(false);

        // ストップボタンが全て無効（現在有効なストップボタンがない）の場合はスタートボタンを有効化
        if (allStopButtonsAreDisabled()) {
            startButton.setEnabled(true);
        }
    }

    // ストップボタンが全て無効かどうか判断するメソッド
    private boolean allStopButtonsAreDisabled() {
        if(!slotThreads[0].isActive() && 
           !slotThreads[1].isActive() &&
           !slotThreads[2].isActive()
        ) {
            return true;
        } else {
            return false;
        }
    }

}