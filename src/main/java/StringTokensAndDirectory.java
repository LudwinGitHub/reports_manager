import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class StringTokensAndDirectory {
    public static final File DIRECTORY = new File("/home/futurum/Downloads/TemporaryDirectory");

    public String[] trimFileName(String[] arrayOfStrings) {
        String[] contents = DIRECTORY.list();
        for (int i = 0; i < contents.length; i++) {

            contents[i] = contents[i].replaceAll(("Procare_Medical_Group"), "");
            contents[i] = contents[i].replaceAll("Mri", "");
            contents[i] = contents[i].replaceAll("Xrays", "");
            contents[i] = contents[i].replaceAll(".doc", "");
            contents[i] = contents[i].replaceAll("Ultrasound", "");
        }
        return contents;
    }


    public String[] getArrayOfClearContents(String[] stringReports) {
        for (int i = 0; i < stringReports.length; i++) {
            stringReports[i] = Arrays.toString(stringReports[i].split("_"));
        }
        return stringReports;
    }

    public String[] getPatientNameAndTimestamp(String[] patient) {
        for (int i = 0; i < patient.length; i++) {
            patient[i] = Arrays.toString(patient[i].split("(_)"));
            patient[i] = patient[i].substring(4).trim();

        }
        return patient;
    }

    public String[] getTokensArray(String strData, String strDelimiters) {

        String[] strTokenArray = null;

        try {
            if (strData == null || strDelimiters == null)
                return strTokenArray;

            StringTokenizer st = new StringTokenizer(strData, strDelimiters);
            strTokenArray = new String[st.countTokens()];

            int count = 0;
            while (st.hasMoreTokens()) {
                strTokenArray[count++] = st.nextToken();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strTokenArray;
    }

    public void createDateFromTimestamp(String[] timestamps) {
        for (int i = 0; i < timestamps.length; i++) {
            if (timestamps[i] != null && timestamps[i].length() == 12 && timestamps[i].matches("\\d+")) {
                Timestamp ts = new Timestamp(Long.parseLong(timestamps[i]));
                String pattern = "yyyy-MM-dd";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                String date = simpleDateFormat.format(ts);
                timestamps[i] = date;
            }
        }
    }

    public void removeIdsFromReportsDetails(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() == 6 && strings[i].matches("\\d+")) {
                strings[i] = null;
            }
        }
    }

    public void createDirectory(String[] stringTokens) {
        File rro_reports = new File("/home/futurum/Downloads/RRO");
        String patient = "";
        String date = "";


        String[] firstArray = Arrays.stream(stringTokens)
                .filter(s -> (s != null && s.length() > 0))
                .toArray(String[]::new);

        System.out.println(Arrays.toString(firstArray));

        List<String> strings = Arrays.asList(firstArray);
        for (String string : strings) {
            if (string.matches("\\d+"));
            date = string;
        } patient = strings.get(1);

        //        for (int i = 0; i < firstArray.length; i++) {
       //          patient = stringTokens[i] + " " + stringTokens[i+ 1] + " " + stringTokens[i+2] + " " + stringTokens[i + 3] + " " + stringTokens[i + 4];
      //         date = stringTokens[i + 5];



        File directory = new File(rro_reports + "/" + patient);
            File dateDirectory = new File(directory + "/" + date);

            if (!rro_reports.exists()) {
                if (rro_reports.mkdir()) {
                    System.out.println("dir created");
                }

                if (!directory.exists()) {
                    if (directory.mkdir()) {
                        System.out.println("subdir created");
                    }

                    if (!dateDirectory.exists()) {
                        if (dateDirectory.mkdir()) {
                            System.out.println("subdir created");
                        }
                    }
                }
            }
        }
    }



//        for (int i = 0; i < firstArray.length; i++) {
//            char ch = firstArray[i].charAt(1);
//            if ((!(ch >= 'A' && ch <= 'Z')) && (!(ch >= 'a' && ch <= 'z'))) {
//                date = firstArray[i];
//            }
//            if (((!(ch <= 'A' && ch >= 'Z')) && (!(ch <= 'a' && ch >= 'z')))) {
//                patient = firstArray[i];
//            }

//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
//                Date date = sdf.parse(stringStamp);
//                return date;



//public void createDirectory(String[] stringTokens) {
//        File rro_reports = new File("/home/futurum/Downloads/RRO");
//        File directoryOne = new File("/home/futurum/Downloads/RRO/" + stringTokens[0] + " " + stringTokens[1]);
//        File directoryTwo = new File(directoryOne + "/" + stringTokens[3]);
//
//
//        if (!rro_reports.exists()) {
//            if (rro_reports.mkdir()) {
//                System.out.println("created");
//            }
//        }
//        if (!directoryOne.exists()) {
//            if (directoryOne.mkdir()) {
//                System.out.println("subdir created");
//            }
//        }
//        if (!directoryTwo.exists()) {
//            if (directoryTwo.mkdir()) {
//                System.out.println("subdir created");
//            }
//        }
//    }



//public void createDir(String[] stringsArray){
//        File rro_reports = new File("/home/futurum/Downloads/RRO");
//        File baseDir = new File("/home/futurum/Downloads/RRO");
//        for (int i = 0; i < stringsArray.length; i++) {
//            for (String s : stringsArray) {
//                File userDir = new File(baseDir + "/" + stringsArray[i] + " " + stringsArray[i + 1]);
//                File dateDir = new File(userDir + "/" + stringsArray[i + 3]);
//
//                if (stringsArray[i] != null) {
//                    if (!rro_reports.exists()) {
//                        if (rro_reports.mkdir()) {
//                            System.out.println("dir created");
//                        }
//
//                        if (!userDir.exists()) {
//                            if (userDir.mkdir()) {
//                                System.out.println("subdir created");
//                            }
//
//                        if (!dateDir.exists()) {
//                            if (dateDir.mkdir()) {
//                                System.out.println("subdir created");
//                            }
//                          }
//                        }
//                    }
//                }
//            }
//        }
//    }

//        for (int i = 0; i <= stringTokens.length; i+=1) {
//            String name = stringTokens[i];
//            for (int i1 = 1; i1 < stringTokens.length; i1 += 2) {
//                String sureName = stringTokens[i1];
//                for (int i2 = 2; i2 < stringTokens.length; i2 += 3) {
//                    String date = stringTokens[i2];