import java.io.File;
import java.text.ParseException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ParseException {

        StringTokensAndDirectory tokens = new StringTokensAndDirectory();

         final File file = new File("/home/futurum/Downloads/TemporaryDirectory");
         final String[] arrayOfStrings = file.list();

        String[] arrayOfClearContents = tokens.getArrayOfClearContents(arrayOfStrings);
        String[] strings = tokens.trimFileName(arrayOfStrings);
        String[] patientNameAndTimestamp = tokens.getPatientNameAndTimestamp(strings);
        String[] tokensArray = tokens.getTokensArray(Arrays.toString(patientNameAndTimestamp), ",. []/");


        tokens.removeIdsFromReportsDetails(tokensArray);
        tokens.createDateFromTimestamp(tokensArray);
        System.out.println(Arrays.toString(tokensArray));
        tokens.createDirectory(tokensArray);






    }
}
