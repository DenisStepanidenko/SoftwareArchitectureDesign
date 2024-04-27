package homeWorks.proxy;

import java.io.*;

public class RealFile implements File {
    private final String pathToFile;

    public RealFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    @Override
    public void open() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
            String line;
            System.out.println("----------");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("----------");
        }
    }

    @Override
    public void write(String lineToWrite) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathToFile, true))) {
            writer.write(lineToWrite + '\n');
            System.out.println("Ваши данные записаны");
            System.out.println("----------");
        }
    }
}
