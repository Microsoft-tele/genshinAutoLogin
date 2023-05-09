package packages.ShellUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import packages.YamlUtils.ReadYaml;

public class PowershellRunner {
    public static void main(String[] args) throws IOException {
        ReadYaml config = new ReadYaml("C:\\Users\\Nahida\\Desktop\\git\\java_genshin_autologin\\untitled\\src\\user.yaml");
        String pythonScriptPath = config.getPythonScriptPath();
        System.out.println(getListFromShell("python " + pythonScriptPath).get(0));
    }
    public static ArrayList<String> getListFromShell(String cmd) throws IOException {
        ArrayList<String> ret = new ArrayList<String>();

        try {
            // 使用PowerShell命令获取当前目录下的文件列表
            String command = cmd;

            // 启动PowerShell进程
            Process powerShellProcess = Runtime.getRuntime().exec(command);

            // 读取PowerShell进程的输出
            InputStream inputStream = powerShellProcess.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // System.out.println(line);
                ret.add(line);
            }

            // 关闭输入流
            inputStream.close();
            inputStreamReader.close();
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
