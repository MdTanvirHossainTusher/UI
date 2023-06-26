package framework.utils;

import aquality.selenium.core.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import testing.utils.FileManager;

import java.io.FileReader;

public class ConfigUtils {
    private JSONObject jsonData;

    public ConfigUtils() {
        try {
            JSONParser parser = new JSONParser();
            String path = FileManager.getConfigDataFilePath();
            FileReader fileReader = new FileReader(path);
            Object obj = parser.parse(fileReader);
            this.jsonData = (JSONObject) obj;
            fileReader.close();
        } catch (Exception e) {
            Logger.getInstance().warn(e.getMessage());
        }
    }

    public String getUrl() {
        return (String) ((JSONObject) this.jsonData.get("url")).get("main");
    }
}
