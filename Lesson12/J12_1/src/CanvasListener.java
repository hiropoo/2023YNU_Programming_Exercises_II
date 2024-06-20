import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CanvasListener implements ActionListener{
    /* インスタンス変数 */ 
    private String cmd = "";        // コマンド名
    private NewCanvas canvas;       // Canvas

    public CanvasListener(NewCanvas canvas) {
        this.canvas = canvas;
    }

    // ボタンが押された時のイベントを作成
    @Override
    public void actionPerformed(ActionEvent e) {
        // コマンドを取得
        cmd = e.getActionCommand();
        
        // コマンドに応じて円の位置を ずらす/元に戻す  
        // （ translatePosition(x, y) / initPosition() ）
        switch (cmd) {
            case "↑":
                canvas.translatePosition(0, -5);
                break;
            case "↓":
                canvas.translatePosition(0, 5);
                break;
            case "←":
                canvas.translatePosition(-5, 0);
                break;
            case "→":
                canvas.translatePosition(5, 0);
                break;
            case "Center":
                canvas.initPosition();
                break;

            case "Blue":
                canvas.setCircleColor(Color.BLUE);
                break;
            case "Red":
                canvas.setCircleColor(Color.RED);
                break;
        
            default:
                break;
        }

        canvas.repaint();   // canvasの再描画
    }
}
