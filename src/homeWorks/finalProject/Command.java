package homeWorks.finalProject;

import homeWorks.finalProject.baseUnit.Unit;

public interface Command {
    void execute(Unit unit);
    void undo();
}
