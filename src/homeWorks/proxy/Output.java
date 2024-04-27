package homeWorks.proxy;

import java.io.IOException;
import java.util.Scanner;

public class Output {
    private final Input input = new Input();
    public void doOperation(FileProxy fileProxy , int answerForOperation){
        try{
            if(answerForOperation == 1){
                fileProxy.open();
            }
            else{
                String lineToWrite = input.getLineToRead();
                fileProxy.write(lineToWrite);
            }
        } catch (IOException e) {
            System.out.println("Проблема при работе с файлом");
        }
    }
}
