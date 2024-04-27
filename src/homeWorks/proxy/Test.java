package homeWorks.proxy;

import homeWorks.proxy.utility.LoadingPathes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();

        List<String> userPermissions = List.of("read" , "write");
        Map<Integer , String> allPathes = new HashMap<>();
        LoadingPathes.loadPathes(allPathes);

        while(true){
            int answerForFile = input.getChoiceForFile(allPathes);
            int answerForOperation = input.getChoiceForOperation();
            FileProxy fileProxy = new FileProxy(allPathes.get(answerForFile) , userPermissions);
            output.doOperation(fileProxy , answerForOperation);
        }

    }
}
