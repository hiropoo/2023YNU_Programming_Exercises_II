import java.awt.*;
import javax.swing.*;


public class NewJ12_3 extends JFrame {

    public static void main(String[] args) throws Exception {
        NewJ12_3 frame = new NewJ12_3("課題3 改良ver");
        frame.setVisible(true);
    }

    public NewJ12_3(String title) {
        // 初期設定
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(550, 550));
        setLocationRelativeTo(null);
        
        // JTextAreaの作成
        JTextArea textArea = new JTextArea(30, 30);
        textArea.setLineWrap(true);         // 折り返し
        textArea.setWrapStyleWord(true);    // 英単語は単語単位で折り返し

        // JTextAreaにスクロールの実装
        JScrollPane textAreaScrollPane = new JScrollPane(textArea);

        // JTextAreaを表示するパネル
        JPanel textareaPanel = new JPanel();
        textareaPanel.add(textAreaScrollPane);
        
        // メニューバーの作成
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("ファイル");
        JMenuItem open = new JMenuItem("開く");
        JMenuItem save = new JMenuItem("保存する");
        JMenuItem quit = new JMenuItem("終了");

        menuBar.add(fileMenu);
        fileMenu.add(open);
        fileMenu.add(save);
        fileMenu.add(quit);
        
        // ActionListenerを設定
        NewFileAction actionListener = new NewFileAction(this, textArea);
        open.addActionListener(actionListener);
        save.addActionListener(actionListener);
        quit.addActionListener(actionListener);


        // コンポーネントをフレームに追加
        setJMenuBar(menuBar);
        add(textareaPanel, BorderLayout.CENTER);
    }
}
