package testing.utils;

public class FileManager {
    private static final String CONFIG_DATA_FILE_PATH = "src/test/resources/testdata/ConfigData.json";
    private static final String TEST_DATA_FILE_PATH = "src/test/resources/testdata/TestData.json";

    public static String getConfigDataFilePath() {
        return CONFIG_DATA_FILE_PATH;
    }
    public static String getTestDataFilePath() {
        return TEST_DATA_FILE_PATH;
    }
}
