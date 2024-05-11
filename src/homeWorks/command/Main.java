package homeWorks.command;

public class Main {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        CreateFileCommand createFileCommand = new CreateFileCommand(fileManager);
        DeleteFileCommand deleteFileCommand = new DeleteFileCommand(fileManager);
        User user = new User(createFileCommand, deleteFileCommand);
        Input input = new Input();

        while(true){
            int answer = input.getChoice();
            if(answer == 3){
                break;
            }
            String fileName = input.getFileName();

            switch (answer){
                case 1:
                    user.createFile(fileName);
                    break;
                case 2:
                    user.deleteFile(fileName);
            }
        }
    }
}
