import packages.YamlUtils.ReadYaml;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class PasteString {
    public static void writeString(String phoneNumber, String password) throws AWTException, InterruptedException {
        String string1 = phoneNumber;
        String string2 = password;

        // 获取默认剪贴板并清除内容
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(new StringSelection(""), null);

        // 将第一个字符串设置到剪贴板中
        StringSelection selection1 = new StringSelection(string1);
        clipboard.setContents(selection1, null);

        // 等待一段时间以确保第一个字符串已经被设置到剪贴板中
        Thread.sleep(500);

        Robot robot = new Robot();
        robot.setAutoDelay(250); // 设置事件间隔时间为1秒

        // 模拟按下并释放CTRL+V组合键以粘贴第一个字符串
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        Thread.sleep(500);
        // 切换到下一个位置
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        // 将第二个字符串设置到剪贴板中
        StringSelection selection2 = new StringSelection(string2);
        clipboard.setContents(selection2, null);

        // 等待一段时间以确保第二个字符串已经被设置到剪贴板中
        // Thread.sleep(500);

        // 模拟按下并释放CTRL+V组合键以粘贴第二个字符串
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    public static void main(String[] args) throws IOException, InterruptedException, AWTException {
        ReadYaml genshinConfig = new ReadYaml("C:\\Users\\Nahida\\Desktop\\git\\java_genshin_autologin\\untitled\\src\\user.yaml");
        genshinConfig.getPhoneNumberPosition();
        writeString(genshinConfig.getUserAccount(1), genshinConfig.getUserPassword(1));
    }
}
