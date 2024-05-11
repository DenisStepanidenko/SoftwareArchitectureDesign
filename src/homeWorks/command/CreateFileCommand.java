package homeWorks.command;

public class CreateFileCommand implements Command{
    private FileManager fileManager;

    public CreateFileCommand(FileManager fileManager){
        this.fileManager = fileManager;
    }

    @Override
    public void execute(String fileName) {
        fileManager.createFile(fileName);
    }
}
