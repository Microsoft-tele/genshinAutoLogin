package packages.YamlUtils;

import org.yaml.snakeyaml.Yaml;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class ReadYaml {
    private Yaml yamlFile = new Yaml();
    private Map<String, Object> data = null;
    public ReadYaml(String path) throws IOException {
        // 创建一个InputStream对象
        InputStream input = new FileInputStream(path);

        // 读取YAML文件
        this.data = (Map<String, Object>) this.yamlFile.load(input);

        // 关闭InputStream对象
        input.close();
    }
    public String getUserAccount(int id){
        ArrayList<Map<String, Object>> list = (ArrayList<Map<String, Object>>) this.data.get("User");
        Map<String, Object> phoneNumber = list.get(id - 1);
        return phoneNumber.get("phoneNumber").toString();
    }
    public String getUserPassword(int id){
        ArrayList<Map<String, Object>> list = (ArrayList<Map<String, Object>>) this.data.get("User");
        Map<String, Object> password = list.get(id - 1);
        return password.get("password").toString();
    }
    public String getUserIntro(int id){
        ArrayList<Map<String, Object>> list = (ArrayList<Map<String, Object>>) this.data.get("User");
        Map<String, Object> intro = list.get(id - 1);
        return intro.get("intro").toString();
    }
    public String getBottomIconPath(){
        String path = (String) this.data.get("bottomIconPath");
        return path;
    }
    public String getPythonScriptPath(){
        String path = (String) this.data.get("pythonScript");
        return path;
    }
    public Map<String, Integer> getPhoneNumberPosition(){
        Map<String, Integer> position = (Map<String, Integer>) this.data.get("phoneNumberPosition");
        return position;
    }
    public Map<String, Integer> getAdmitPosition(){
        Map<String, Integer> position = (Map<String, Integer>) this.data.get("admitPosition");
        return position;
    }

    public void showIntro(){
        ArrayList<Map<String, Object>> list = (ArrayList<Map<String, Object>>) this.data.get("User");
        for (int i = 0; i < list.size(); i++){
            System.out.println((i+1) + ":" + list.get(i).get("intro").toString());
        }
    }

    public static void main(String[] args) throws IOException {
        ReadYaml myYaml = new ReadYaml("C:\\Users\\Nahida\\Desktop\\git\\java_genshin_autologin\\untitled\\src\\user.yaml");
//        System.out.println(myYaml.data);
//        System.out.println(myYaml.getUserIntro(1));
//        System.out.println(myYaml.getUserAccount(1));
//        System.out.println(myYaml.getUserPassword(1));
//        System.out.println(myYaml.getBottomIconPath());
//        System.out.println(myYaml.getPhoneNumberPosition().toString());
//        System.out.println(myYaml.getPythonScriptPath());
//        System.out.println(myYaml.getAdmitPosition());
        myYaml.showIntro();
    }
}
