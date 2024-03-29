package homeWorks.builder;

public abstract class TrainingProgrammBuilder {
    TrainingProgramm trainingProgramm;

    void createTrainingProgramm() {
        trainingProgramm = new TrainingProgramm();
    }

    abstract void buildType();

    abstract void buildDuration();

    abstract void buildDifficulty();

    TrainingProgramm getTrainingProgramm() {
        return trainingProgramm;
    }

}
