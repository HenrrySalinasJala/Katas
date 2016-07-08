import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Bank {


    String regexZero = "( \\_ \\| \\|\\|\\_\\|)";

    String regexOne = "(     \\|  \\|)";

    String regexTwo = "( \\_  \\_\\|\\|\\_ )";

    String regexThree = "( \\_  \\_\\| \\_\\|)";

    String regexFour = "(   \\|\\_\\|  \\|)";

    String regexFive = "( \\_ \\|\\_  \\_\\|)";

    String regexSix = "( \\_ \\|\\_ \\|\\_\\|)";

    String regexSeven = "( \\_   \\|  \\|)";

    String regexEight = "( \\_ \\|\\_\\|\\|\\_\\|)";

    String regexNine = "( \\_ \\|\\_\\| \\_\\|)";

    Map<String, Integer> listRegex = new HashMap<String, Integer>();

    private static final int NUMBER_SIZE = 3;

    public static final int ENTRY_ROWS = 4;

    private static final int ENTRY_SIZE = 27;

    public Bank() {
        listRegex.put(regexZero, 0);
        listRegex.put(regexOne, 1);
        listRegex.put(regexTwo, 2);
        listRegex.put(regexThree, 3);
        listRegex.put(regexFour, 4);
        listRegex.put(regexFive, 5);
        listRegex.put(regexSix, 6);
        listRegex.put(regexSeven, 7);
        listRegex.put(regexEight, 8);
        listRegex.put(regexNine, 9);
    }

    public String readEntry(String entry) {
        String[][] matrixNumbers = new String[ENTRY_ROWS][ENTRY_SIZE];
        String[] arrayEntry = entry.split("");
        int row = 0;
        int col = 0;
        for (int arrayIndex = 0; arrayIndex < entry.length(); arrayIndex++) {
            if (arrayIndex % ENTRY_SIZE == 0 && arrayIndex > 0) {
                row++;
                col = 0;
            }
            matrixNumbers[row][col] = arrayEntry[arrayIndex];
            col++;
        }
        return readEntryNumbers(matrixNumbers);
    }

    public String readEntryNumbers(String[][] matrixNumbers) {
        String result = "";
        for (int i = 1; i <= ENTRY_SIZE / NUMBER_SIZE; i++) {
            result += parseStringToNumber(parseMatrixNumberToString(i, matrixNumbers));
        }
        return result;//replace ? intead of -1
    }
    public String formatAccountNumbers(String accountNumber){
        String result = "";
        if(accountNumber.contains("?")){
            result=String.format("%s %s",accountNumber,"ILL");
        }else if(!isValidAccount(Integer.parseInt(accountNumber))){
            result=String.format("%s %s",accountNumber,"ERR");
        }
        return result;
    }
    public String parseMatrixNumberToString(int numWanted, String[][] matrixNumbers) {
        String stringNumber = "";
        int end = numWanted > 0 ? numWanted * NUMBER_SIZE : NUMBER_SIZE;
        int start = end - NUMBER_SIZE;
        for (int i = 0; i < NUMBER_SIZE; i++) {
            for (int j = start; j < end; j++) {
                stringNumber = stringNumber + matrixNumbers[i][j];
            }
        }
        return stringNumber;
    }

    public String parseStringToNumber(String stringNumber) {
        String value = "?";//replace with ? for story three
        for (String pattern : listRegex.keySet()) {
            if (Pattern.compile(pattern).matcher(stringNumber).find()) {
                return listRegex.get(pattern).toString();
            }
        }
        return value;
    }

    public boolean isValidAccount(int account) {

        int remainNumber = account / 10;
        int lastNumber = account % 10;
        int index = 2;
        int checksum = lastNumber;
        while (remainNumber >= 1) {
            lastNumber = remainNumber % 10;
            remainNumber = remainNumber / 10;
            checksum += (lastNumber * index);
            index++;
        }
        return checksum % 11 == 0 ? true : false;
    }
}
