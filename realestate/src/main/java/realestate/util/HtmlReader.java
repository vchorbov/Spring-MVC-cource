package realestate.util;

import java.io.*;

public class HtmlReader {

    public String readerHtmlFile(String pathToFile) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream((pathToFile))));

        StringBuilder htmlBuilder = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null){
            htmlBuilder.append(line).append(System.lineSeparator());
        }
        reader.close();

        return htmlBuilder.toString();
    }
}
