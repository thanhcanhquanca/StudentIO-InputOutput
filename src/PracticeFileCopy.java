import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class PracticeFileCopy {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        System.out.printf("Enter source file:");
        String sourcePath = in.nextLine();
        System.out.printf("Enter destination file:");
        String destPath = in.nextLine();

        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        //thay đổi lần lượt 2 method để thấy kết quả
//        copyFile7Files(sourceFile, destFile);
        copyFileUsingStream(sourceFile, destFile);
        System.out.printf("Copy completed");
    }


    private static void copyFile7Files(File source, File dest) {
        try {
            Files.copy(source.toPath(),dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;

        try {
            is = new FileInputStream(source);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;

          while (true){
              try {
                  if (!((length = is.read(buffer))>0)) break;
              } catch (IOException e) {
                  throw new RuntimeException(e);
              }
              try {
                  os.write(buffer,0,length);
              } catch (IOException e) {
                  throw new RuntimeException(e);
              }
          }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            os.close();
            is.close();

        }

    }
}
