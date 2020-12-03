/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clarktribegames;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author admingec
 */
public class Converters {
    
    public List<String> resourcefileToList(String resFile) throws IOException {
        String convertedString;
        InputStream stream = null;
        ByteArrayOutputStream resStreamOut = null;
        try {
            stream = ChecksBalances.class.getResourceAsStream(resFile);
            if(stream == null) {
                logFile("severe","Resource to List.  Dir:  " + resFile);
            }
            int readBytes;
            byte[] buffer = new byte[4096];
            resStreamOut = new ByteArrayOutputStream();
            while ((readBytes = stream.read(buffer)) > 0) {
                resStreamOut.write(buffer, 0, readBytes);
            }
        } catch (IOException ex) {
            logFile("severe","Resource to List.  IOEx: " + ex.toString());
        } finally {
            convertedString = new String(resStreamOut.toByteArray());
            stream.close();
            resStreamOut.close();
        }
        List<String> convertedList = Stream.of(convertedString.split(",", -1)).
                collect(Collectors.toList());
        return convertedList;
    }
    
    public List<String> filelistToList(String ogFile, String delim) throws 
            IOException {
        File file = new File(ogFile);
        Scanner input = new Scanner(file);
        List<String> filetoList = new ArrayList<>();
        while(input.hasNextLine()) {
            filetoList.add(input.nextLine());
        }
        return filetoList;
    }
    
    public String capFirstLetter(String tobeconvertedtoCap) {
        char ch = tobeconvertedtoCap.charAt(0);
        String convertedString = String.valueOf(ch).toUpperCase() + 
                tobeconvertedtoCap.substring(1, tobeconvertedtoCap.length());
        return convertedString;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Log File Method">
    private static void logFile (String type, String loginfo) throws IOException {
        try {
            new LogWriter().writeLog(type,loginfo);
        } catch(IOException ioex) {
            logFile("severe","logFile cannot fine log file (infinite loop)!");
        }
    }
    //</editor-fold>
}
