import javax.swing.*;
import java.awt.*;

public class J12_1 extends JFrame {
    public static void main(String[] args) throws Exception {
        J12_1 frame = new J12_1("課題1");
        frame.setVisible(true);
    }

    // フレームの描画
    public J12_1(String title) {
        // 初期設定
        setTitle(title);
        setBounds(1000, 200, 300, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // canvas
        NewCanvas newCanvas = new NewCanvas();
        newCanvas.setSize(new Dimension(300, 300));
        JPanel canvasPanel = new JPanel();
        canvasPanel.add(newCanvas);


        // Centerに配置するボタン
        JButton upButton = new JButton("↑");
        JButton downButton = new JButton("↓");
        JButton leftButton = new JButton("←");
        JButton rightButton = new JButton("→");
        JButton centerButton = new JButton("Center");
        // ボタンにActionListenerを追加
        CanvasListener canvasListener = new CanvasListener(newCanvas);
        upButton.addActionListener(canvasListener); 
        downButton.addActionListener(canvasListener); 
        leftButton.addActionListener(canvasListener);
        rightButton.addActionListener(canvasListener); 
        centerButton.addActionListener(canvasListener);
        
        // Centerに配置するボタンのパネル（BorderLayout）
        JPanel centerButtonPanel = new JPanel(new BorderLayout());
        centerButtonPanel.add(upButton, BorderLayout.NORTH);
        centerButtonPanel.add(downButton, BorderLayout.SOUTH);
        centerButtonPanel.add(leftButton, BorderLayout.WEST);
        centerButtonPanel.add(rightButton, BorderLayout.EAST);
        centerButtonPanel.add(centerButton, BorderLayout.CENTER);


        // Bottomに配置するボタン
        JButton blueButton = new JButton("Blue");
        JButton redButton = new JButton("Red");
        // ボタンにActionListenerを追加
        blueButton.addActionListener(canvasListener);
        redButton.addActionListener(canvasListener);

        // Bottomに配置するボタンのパネル（GridLayout）
        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));
        bottomPanel.add(blueButton);
        bottomPanel.add(redButton);
        
        
        // フレームにコンポーネントを追加
        add(canvasPanel, BorderLayout.NORTH);
        add(centerButtonPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }
}
