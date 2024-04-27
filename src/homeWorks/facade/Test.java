package homeWorks.facade;

public class Test {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output(new FileManagementFacade(), input);

        while (true) {
            int answer = input.getChoice();
            output.doOperation(answer);
        }
    }
}
