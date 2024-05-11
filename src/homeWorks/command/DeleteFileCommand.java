package homeWorks.command;

public class DeleteFileCommand implements Command {
    private FileManager fileManager;

    public DeleteFileCommand(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    @Override
    public void execute(String fileName) {
        fileManager.deleteFile(fileName);
    }
}
