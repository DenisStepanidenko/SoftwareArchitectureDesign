package homeWorks.proxy;

import java.io.IOException;
import java.util.List;

public class FileProxy implements File{
    private final List<String> userPermissions;
    private final RealFile realFile;
    private final String READ = "read";
    private final String WRITE = "write";

    public FileProxy(String pathToFile , List<String> userPermissions){
        this.userPermissions = userPermissions;
        this.realFile = new RealFile(pathToFile);
    }


    @Override
    public void open() throws IOException {
        if(checkAccessForOpen()){
            realFile.open();
        }
        else{
            System.out.println("Вам запрещен доступ к чтению файла");
        }
    }

    private boolean checkAccessForOpen() {
        return userPermissions.contains(READ);
    }
    private boolean checkAccessForWrite() {
        return userPermissions.contains(WRITE);
    }

    @Override
    public void write(String lineToWrite) throws IOException {
        if(checkAccessForWrite()){
            realFile.write(lineToWrite);
        }
        else{
            System.out.println("Вам запрещён доступ к записи в файл");
        }
    }
}
