import java.util.HashMap;
import java.util.Map;

public class Examples {

    public String makeComplement(String dnaSide) {
        String dna = "";
        Map<String, String> dnaSet = new HashMap<String, String>();

        dnaSet.put("A", "T");
        dnaSet.put("T", "A");
        dnaSet.put("G", "C");
        dnaSet.put("C", "G");
        for (String value : dnaSide.split("")) {
            dna += dnaSet.get(value) != null ? dnaSet.get(value) : value;
        }
        return dna;
    }

    public String highAndLow(String values) {
        int hight = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;
        for (String number : values.split("((?!-)\\D)")) {
            int value = Integer.parseInt(number);
            hight = value >= hight ? value : hight;
            low = value <= low ? value : low;
        }
        return String.format("%d %d", hight, low);
    }
}
