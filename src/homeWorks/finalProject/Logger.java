package homeWorks.finalProject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Logger {
    private Path path = Path.of("src/homeWorks/finalProject/log/log.txt");
    private String directory = "src/homeWorks/finalProject/log";

    public void logAction(String action) {
        try{
            Files.createDirectory(Path.of(directory));
        } catch (IOException ignored) {
        }

        try{
            Files.createFile(path);
        } catch (IOException ignored) {
        }


        try {
            Files.write(path , action.getBytes() , StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
