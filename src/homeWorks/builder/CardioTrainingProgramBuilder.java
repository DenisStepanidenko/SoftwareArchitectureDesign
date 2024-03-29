package homeWorks.builder;

public class CardioTrainingProgramBuilder extends TrainingProgrammBuilder {
    @Override
    void buildType() {
        trainingProgramm.setType("cardio");
    }

    @Override
    void buildDuration() {
        trainingProgramm.setDuration(30);
    }

    @Override
    void buildDifficulty() {
        trainingProgramm.setDifficulty("Beginner");
    }
}
