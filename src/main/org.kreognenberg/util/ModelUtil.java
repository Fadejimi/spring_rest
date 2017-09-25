package util;

import java.util.Arrays;
import java.util.List;

public class ModelUtil {
    public static List<String> computeInterests(String st) {
        List<String> items = Arrays.asList(st.split("\\s*,\\s*"));
        return items;
    }

    public static String delimitInterests(List<String> list) {
        StringBuilder stBuilder = new StringBuilder();

        for(String st : list){
            stBuilder.append(st);
            stBuilder.append(",");
        }

        String output = stBuilder.toString();

        //Remove last comma
        output = output.substring(0, output.length() - 1);

        //System.out.println(csv);
        return output;
    }
}
