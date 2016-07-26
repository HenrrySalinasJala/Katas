import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Henrry Salinas on 7/25/2016.
 */
public class SearchEngine {
    public static int find(String needle, String haystack) {
        int index = -1;
        String x = Pattern.quote(needle).replace("_", "\\E.\\Q");
        Matcher matcher = Pattern.compile(x).matcher(haystack);
        while (matcher.find()) {
            index = matcher.start();
            break;
        }
        return index;
    }
}
