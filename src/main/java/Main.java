import java.io.File;
import java.text.ParseException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ParseException {

        StringTokensAndDirectory tokens = new StringTokensAndDirectory();

         final File file = new File("/home/futurum/Downloads/TemporaryDirectory");
         final String[] arrayOfStrings = file.list();

        String[] arrayOfClearContents = tokens.getSplitArray(arrayOfStrings);
        String[] strings = tokens.trimFileName(arrayOfStrings);
        String[] patientNameAndTimestamp = tokens.getPatientNameAndTimestamp(strings);
        String[] tokensArray = tokens.getTokensArray(Arrays.toString(patientNameAndTimestamp), ",. []/");


        tokens.removeIdsFromReportsDetails(tokensArray);
        tokens.createDateFromTimestamp(tokensArray);
        String[] strings1 = tokens.removeNullAndBlankSpaces(tokensArray);

        System.out.println(Arrays.toString(strings1));
        String[] allMatches = tokens.getAllMatches(strings1);
        System.out.println(Arrays.toString(allMatches));


    }
}
