package homeWorks.builder;

public class StrengthTrainingProgramBuilder extends TrainingProgrammBuilder {
    @Override
    void buildType() {
        trainingProgramm.setType("strength");
    }

    @Override
    void buildDuration() {
        trainingProgramm.setDuration(60);
    }

    @Override
    void buildDifficulty() {
        trainingProgramm.setDifficulty("Intermediate");
    }
}
