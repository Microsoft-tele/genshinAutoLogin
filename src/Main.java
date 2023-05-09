import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import org.yaml.snakeyaml.Yaml;
import packages.YamlUtils.ReadYaml;

import static packages.ShellUtils.PowershellRunner.getListFromShell;

public class Main {

    public static void main(String[] args) throws AWTException, InterruptedException, IOException {
        ReadYaml config = new ReadYaml("C:\\Users\\Nahida\\Desktop\\git\\java_genshin_autologin\\untitled\\src\\user.yaml");
        String pythonPath = config.getPythonScriptPath();

        String[] bottom_icon_position = getListFromShell("python " + pythonPath).get(0).split(" ");
        int x_bottom_icon = Integer.parseInt(bottom_icon_position[0]);
        int y_bottom_icon = Integer.parseInt(bottom_icon_position[1]);
        Map<String, Integer> phoneNumberPosition = config.getPhoneNumberPosition();
        int x_phone_number_position = phoneNumberPosition.get("x");
        int y_phone_number_position = phoneNumberPosition.get("y");
        Map<String, Integer> admitPosition = config.getAdmitPosition();
        int x_admit_position = admitPosition.get("x");
        int y_admit_position = admitPosition.get("y");

        config.showIntro();
        System.out.print("Please input index:");
        Scanner cin = new Scanner(System.in);
        int choice = cin.nextInt();

        String account = config.getUserAccount(choice);
        String password = config.getUserPassword(choice);
        System.out.println("what input is:" + account + " " + password);

        Robot robot = new Robot();
        robot.mouseMove(x_bottom_icon, y_bottom_icon);
        Thread.sleep(500);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        Thread.sleep(500);
        robot.mouseMove(x_phone_number_position, y_phone_number_position);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(500);

        PasteString.writeString(account, password);

        Thread.sleep(500);
        robot.mouseMove(x_admit_position, y_admit_position);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(200);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}