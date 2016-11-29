package cl.minsal.semantikos.kernel.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by root on 11-07-16.
 */
public class StringUtils {

    public static String underScoreToCamelCaseJSON(String json){

        Pattern p = Pattern.compile( "_([a-zA-Z])" );
        Matcher m = p.matcher( json );
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, m.group(1).toUpperCase());
        }
        return m.appendTail(sb).toString();
    }

    public static String camelCaseToUnderScore(String json){

        Pattern p = Pattern.compile( "([A-Z])" );
        Matcher m = p.matcher( json );
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, "_"+m.group(1).toLowerCase());
        }
        return m.appendTail(sb).toString();
    }

    public static String[] camelCaseToUnderScore(String[] jsons){
        List<String> underScores = new ArrayList<>();

        for (String s : Arrays.asList(jsons)) {
           underScores.add(camelCaseToUnderScore(s));
        }

        String[] array = new String[underScores.size()];
        return underScores.toArray(array);
    }

}
