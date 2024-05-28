package homeWorks.finalProject;

import homeWorks.finalProject.util.InitializeProfile;
import homeWorks.finalProject.util.Input;

import java.util.Stack;

public class Game {
    private final User firstUser = new User("", 100, new Stack<>());
    private final User secondUser = new User("", 100, new Stack<>());
    private final InitializeProfile initializeProfile = new InitializeProfile(new Input());

    public void start() {
        /**
         * Сначала нужно инициализировать всех персонажей
         */
        initializeProfile.loadData(firstUser);
        System.out.println(firstUser.getName());

    }

}
