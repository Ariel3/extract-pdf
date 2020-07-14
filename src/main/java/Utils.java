import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Utils {

    public static void readAndSavePdf(String pdfPath, String pass, String unlockDirPath) {
        File input = new File(pdfPath);
        try (PDDocument pd = PDDocument.load(input, pass)) {
            pd.setAllSecurityToBeRemoved(true);
            File file = new File(unlockDirPath + "/" + input.getName());
            pd.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<File> getAllFilesInDir(String path) {
        ArrayList<File> files = new ArrayList<>();
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().endsWith("pdf")) {
                    files.add(file);
                    System.out.println("found file " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("found directory " + file.getName());
                }
            }
        } else {
            System.out.println("dir is empty");
        }

        return files;
    }
}
