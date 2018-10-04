package DAO;

import java.io.*;

public class FileDao implements DAO<String, Void> {

    protected String    path;

    public FileDao(String path) {
        this.path = path;
    }

    @Override
    public Void write(String content) {

        try (PrintStream out = new PrintStream(new FileOutputStream(path))) {
            out.print(content);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String read(Void lala) {
        String buffer;
        StringBuilder content = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while ((buffer = br.readLine()) != null) {
                content.append(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

}
