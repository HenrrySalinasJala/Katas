import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Henrry Salinas on 7/25/2016.
 */
public class SearchEngine {
    public static int find(String midnight, String haystack) {
        int index=-1;
            Matcher matcher= Pattern.compile(midnight.contains("_")?"\\b"+midnight.replace("_",".")+"\\b":midnight).matcher(haystack);
            while (matcher.find()){
                    index=matcher.start();
            }
        return index;
    }
}
