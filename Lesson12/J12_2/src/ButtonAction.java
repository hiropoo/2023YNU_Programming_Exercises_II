import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ButtonAction implements ActionListener{
    /* インスタンス変数 */
    JLabel resultLabel;                     // 入力を表示するラベル
    String pressedButton = "";              // 今回押されたボタン
    Boolean plusButtonIsPressed = false;    // "+" ボタンが押されているか判断
    String displayedValue = "";             // 現在表示されている値
    String prevDisplayedValue = "";         // "+" ボタンが押される前に表示されていた値

    // コンストラクタでラベルを設定
    public ButtonAction(JLabel resultLabel) {
        this.resultLabel = resultLabel;
    }

    // ボタンを押した時のイベントを作成
    @Override
    public void actionPerformed(ActionEvent e) {
        pressedButton = e.getActionCommand();

        switch (pressedButton) {
            // "+" ボタンが押された場合
            case "+":
                plusButtonIsPressed = true;
                break;
                
            // "=" ボタンが押された場合
            case "=":
                // 前回入力した値と今回入力した値が両方存在する場合
                if(!prevDisplayedValue.equals("") && !displayedValue.equals("")) {
                    long result = Long.parseLong(prevDisplayedValue) + Long.parseLong(displayedValue);
                    resultLabel.setText(Long.toString(result));
                    prevDisplayedValue = displayedValue;
                    displayedValue = "";
                }
                break;
        
            // 数字のボタンが押された場合
            default:
                // "+" ボタンが押されていた場合
                // ボタンが押されるまでに表示されていた値を保存 & 画面をリセット
                if(plusButtonIsPressed) {
                    prevDisplayedValue = displayedValue;
                    displayedValue = "";
                    plusButtonIsPressed = false;
                }
                
                // 押された数字を追加して表示
                // ただし、0のみが表示されていた場合は押された数字を置換
                if(displayedValue.equals("0")) {
                    resultLabel.setText(pressedButton);
                } else {
                    resultLabel.setText(displayedValue + pressedButton);
                }
                
                displayedValue = resultLabel.getText();
                break;
        }

    }
}
