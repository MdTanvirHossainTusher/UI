package testing.utils;

import framework.utils.TestDataUtils;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomUtils {
    private static String pass;
    public static String generateRandomPassword() {
        String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";
        String allChars = capitalLetters + digits;
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        password.append(capitalLetters.charAt(random.nextInt(capitalLetters.length())));
        TestDataUtils testDataUtils = new TestDataUtils();
        long iteration = testDataUtils.getIntValueByKey("lengths","pwdLength");

        for (int i = 1; i < iteration; i++) {
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }
        pass = password.toString();
        return pass;
    }
    public static String generateEmail(String password) {
        StringBuilder email = new StringBuilder();
        String inputString = password;
        char[] chars = inputString.toCharArray();
        for (char c : chars) {
            boolean isLetter = Character.isLetter(c);
            if (isLetter) {
                email.append(c);
                break;
            }
        }
        email.append("abc");
        return email.toString();
    }
    public static int getRandomDomainValue(){
        Random random = new Random();
        int value = random.nextInt(11) + 1;
        return value;
    }
    public static Set<Integer> getRandomInterestsValues(){
        Random random = new Random();
        Set<Integer> uniqueValues = new HashSet<>();
        TestDataUtils testDataUtils = new TestDataUtils();
        long noOfInterests = testDataUtils.getIntValueByKey("selectInterests","noOfInterests");

        while (uniqueValues.size() < noOfInterests) {
            int value = random.nextInt(21) + 1;
            if(value != 21) uniqueValues.add(value);
        }
        return uniqueValues;
    }
}
