import java.io.File;
import java.util.ArrayList;

public class Start {

    public static void main(String[] args) {
        unlockPdf("PATH_TO_DIR_WITH_PDF", "PASSWORD");
    }

    private static void unlockPdf(String dirPath, String pass) {
        ArrayList<File> fileList = Utils.getAllFilesInDir(dirPath);
        String unlockDirPath = dirPath + "/unlockPdf";
        (new File(unlockDirPath)).mkdir();
        for (File file : fileList) {
            Utils.readAndSavePdf(file.getPath(), pass, unlockDirPath);
        }
    }
}
