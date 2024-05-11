package homeWorks.command;

public class User {
    private final CreateFileCommand createFileCommand;
    private final DeleteFileCommand deleteFileCommand;

    public User(CreateFileCommand createFileCommand, DeleteFileCommand deleteFileCommand) {
        this.createFileCommand = createFileCommand;
        this.deleteFileCommand = deleteFileCommand;
    }

    public void createFile(String fileName){
        createFileCommand.execute(fileName);
    }
    public void deleteFile(String fileName){
        deleteFileCommand.execute(fileName);
    }
}
