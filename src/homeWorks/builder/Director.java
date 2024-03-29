package homeWorks.builder;

public class Director {
    TrainingProgrammBuilder builder;

    public void setBuilder(TrainingProgrammBuilder builder) {
        this.builder = builder;
    }
    TrainingProgramm buildTrainingProgramm(){
        builder.createTrainingProgramm();
        builder.buildDifficulty();
        builder.buildDuration();
        builder.buildType();
        return builder.getTrainingProgramm();
    }
}
