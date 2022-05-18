import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilesDownloader {
    Scanner console = new Scanner(System.in);
    StringBuilder b = new StringBuilder();
    Encrypt encrypt = new Encrypt();


   public List<String> encryptFile() throws IOException {
       Path path = Path.of(console.nextLine());
       List<String> textLines = Files.readAllLines(path);
       List<String> encryptedText = new ArrayList<>();

       for (String str : textLines) {
           encrypt.encrypt(str);


       }

       return encryptedText;
   }


       public File encryptedFile(List<String> encryptedText) {

      return null;

   }




}
