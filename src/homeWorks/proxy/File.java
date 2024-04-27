package homeWorks.proxy;

import java.io.IOException;

public interface File {
     void open() throws IOException;
     void write(String lineToWrite) throws IOException;
}
