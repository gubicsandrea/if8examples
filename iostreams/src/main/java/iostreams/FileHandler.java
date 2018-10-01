package iostreams;

import java.io.*;

public class FileHandler {

    public String loadFromText(File file) {
        try (InputStream is = new FileInputStream(file);
             InputStreamReader isr = new InputStreamReader(is, "UTF-8");
             BufferedReader reader = new BufferedReader(isr)) {
            String content = "";
            String row;
            while ((row = reader.readLine()) != null) {
                content += row + System.lineSeparator();
            }
            return content;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void writeToText(File file, String content) {
        try (Writer writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content, 0, content.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
