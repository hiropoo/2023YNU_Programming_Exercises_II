import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class NewFileAction implements ActionListener{
    /* インスタンス変数 */
    JFrame frame;           // ダイアログを表示するフレーム
    FileDialog fileDialog;  // ダイアログ
    JTextArea textArea;      // ファイルの中身を出力
    String selectedMenu;    // 選択されたメニューアイテムの名前

    public NewFileAction(JFrame frame, JTextArea textArea) {
        this.frame = frame;
        this.textArea = textArea;
    }

    // メニューバーのアイテムが選択された時のイベント
    @Override
    public void actionPerformed(ActionEvent e) {
        selectedMenu = e.getActionCommand();
        
        // ファイルダイアログを開く
        switch (selectedMenu) {
            case "開く":
                openFile();     // ファイルを開いてTextAreaに内容を表示
                break;

            case "保存する":
                saveFile();     // TextAreaの内容をファイルに保存
                break;

            case "終了":
                System.exit(0);
                break;
        
            default:
                break;
        }

    }


    // ファイルを開いてTextAreaに出力するメソッド
    private void openFile() {
        // ファイルダイアログを表示
        fileDialog = new FileDialog(frame, "ファイルを開く", FileDialog.LOAD);
        fileDialog.setVisible(true);

        // ファイルダイアログからファイルを取得
        String fileName = fileDialog.getFile();
        String directoryName = fileDialog.getDirectory();
        String filePath = directoryName + fileName + 1;
        String str = "";

        try (FileReader fr = new FileReader(filePath); BufferedReader br = new BufferedReader(fr)) {
            textArea.setText("");   // リセット
            while ((str = br.readLine()) != null) {
                textArea.append(str);
                textArea.append("\n");
            }
        } catch (IOException e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(frame, "ファイルを開けませんでした", "エラー", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    // TextAreaの内容を新規ファイルに保存するメソッド
    private void saveFile() {
        // ファイルダイアログを表示
        fileDialog = new FileDialog(frame, "ファイルを保存する", FileDialog.SAVE);
        fileDialog.setVisible(true);

        // ファイルダイアログからファイルを取得
        String fileName = fileDialog.getFile();
        String directoryName = fileDialog.getDirectory();
        String filePath = directoryName + fileName;

        try (FileWriter fw = new FileWriter(filePath); BufferedWriter bw = new BufferedWriter(fw)) {
            String str = textArea.getText();
            bw.write(str);

        } catch (IOException e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(frame, "ファイルを保存できませんでした", "エラー", JOptionPane.ERROR_MESSAGE);
        }
    }
}
