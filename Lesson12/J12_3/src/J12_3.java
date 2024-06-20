import java.awt.*;
import javax.swing.*;


public class J12_3 extends JFrame {

    public static void main(String[] args) throws Exception {
        J12_3 frame = new J12_3("課題3");
        frame.setVisible(true);
    }

    public J12_3(String title) {
        // 初期設定
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(510, 500));
        setLocationRelativeTo(null);
        
        // TextAreaの作成
        TextArea textArea = new TextArea();
        textArea.setPreferredSize(new Dimension(300, 430));

        JPanel textareaPanel = new JPanel();
        textareaPanel.add(textArea);
        
        // メニューバーの作成
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("ファイル");
        JMenuItem open = new JMenuItem("開く");
        JMenuItem save = new JMenuItem("保存する");
        JMenuItem quit = new JMenuIactem("終了");

        menuBar.add(fileMenu);
        fileMenu.add(open);
        fileMenu.add(save);
        fileMenu.add(quit);
        
        // ActionListenerを設定
        FileAction actionListener = new FileAction(this, textArea);
        open.addActionListener(actionListener);
        save.addActionListener(actionListener);
        quit.addActionListener(actionListener);


        // コンポーネントをフレームに追加
        setJMenuBar(menuBar);
        add(textareaPanel, BorderLayout.CENTER);
    }
}
