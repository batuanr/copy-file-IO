import java.io.*;

public class Main {
    public static void main(String[] args) {
        copyFile("file.txt", "copyfile.txt");
    }
    public static void copyFile(String url1, String url2){
        File file1;
        File file2;
        try {
            file1 = new File(url1);
            if (!file1.exists()){
                throw new FileNotFoundException();
            }
            file2 = new File(url2);
            if (file2.exists()){
                throw new IOException("File đã tồn tại");
            }
            FileReader fr = new FileReader(file1);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(file2);
            BufferedWriter bw = new BufferedWriter(fw);
            int c;
            while ((c = br.read()) != -1){
                bw.write((char)c);
            }

            br.close();

            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
