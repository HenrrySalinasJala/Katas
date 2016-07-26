/**
 * Created by Henrry Salinas on 7/25/2016.
 */
public class EANValidator {

    private static final int ODD_MULTIPLE = 1;

    private static final int EVEN_MULTIPLE = 3;

    public static boolean validate(String eanCode) {
        int sum=0;
        int position=1;
        for (String number:eanCode.substring(0,eanCode.length()-1).split("")){
            int value=Integer.parseInt(number);
            sum += position % 2 != 0 ?  (value * ODD_MULTIPLE): (value * EVEN_MULTIPLE);
            position++;
        }
        return ( sum%10 == 0 ? 0 : 10 - (sum % 10))==Integer.parseInt(eanCode.substring((eanCode.length()-1),eanCode.length()));
    }
}
