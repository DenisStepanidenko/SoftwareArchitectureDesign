package homeWorks.builder;

public class Test {
    public static void main(String[] args) {
        Director director = new Director();
        director.setBuilder(new CardioTrainingProgramBuilder());

        TrainingProgramm trainingProgramm = director.buildTrainingProgramm();
        System.out.println(trainingProgramm);


    }
}
