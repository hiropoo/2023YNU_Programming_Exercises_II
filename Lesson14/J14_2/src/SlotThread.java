import javax.swing.JTextField;

public class SlotThread extends Thread {
    /* インスタンス変数 */
    private JTextField slotField;       // 0 ~ 9 の数字が回転する部分
    private boolean isActive = true;    // スロットが回転しているかどうか 

    // isActive のゲッター
    public boolean isActive() {
        return isActive;
    }

    // isActive のセッター
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    // コンストラクタ
    public SlotThread(JTextField slotField) {
        this.slotField = slotField;
    }

    // スレッド処理
    // 数字を回転させる
    @Override
    public void run() {
        int i = Integer.parseInt(slotField.getText());

        while (true) {
            // isActive が true の間は回転
            // そうでなければ数字は固定（更新しない）
            if (isActive) {
                i++;
                if (i > 9)
                    i = 0;
                slotField.setText(Integer.toString(i));
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }

        }
    }
}
