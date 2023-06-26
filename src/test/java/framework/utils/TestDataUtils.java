package framework.utils;

import aquality.selenium.core.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import testing.utils.FileManager;

import java.io.FileReader;

public class TestDataUtils {
    private JSONObject jsonData;

    public TestDataUtils() {
        try {
            JSONParser parser = new JSONParser();
            String path = FileManager.getTestDataFilePath();
            FileReader fileReader = new FileReader(path);
            Object obj = parser.parse(fileReader);
            this.jsonData = (JSONObject) obj;
            fileReader.close();
        } catch (Exception e) {
            Logger.getInstance().warn(e.getMessage());
        }
    }

    public String getStringValueByKey(String name, String key) {
        return (String) ((JSONObject) this.jsonData.get(name)).get(key);
    }

    public long getIntValueByKey(String name, String key) {
        return (long) ((JSONObject) this.jsonData.get(name)).get(key);
    }
}
