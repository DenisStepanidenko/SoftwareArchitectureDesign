package homeWorks.builder;

public class TrainingProgramm {
    private String type;
    private int duration;
    private String difficulty;

    public void setType(String type) {
        this.type = type;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "TrainingProgramm{" +
                "type='" + type + '\'' +
                ", duration=" + duration +
                ", difficulty='" + difficulty + '\'' +
                '}';
    }
}
