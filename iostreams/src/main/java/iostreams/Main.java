package iostreams;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        String s = "newdirectory" + File.separator + "newfiles";
        File file = new File(s);
        file.mkdirs();
        File file2 = new File(file, "vmi.txt");
        String content = "Ez egy új fájl." + System.lineSeparator() + "Árvíztűrő tükörfúrógép";
        FileHandler fileHandler = new FileHandler();
        fileHandler.writeToText(file2, content);
        File file3 = new File("elso/masodik/letezo.txt");
        String otherContent = fileHandler.loadFromText(file3);
        System.out.println(otherContent);
    }
}
