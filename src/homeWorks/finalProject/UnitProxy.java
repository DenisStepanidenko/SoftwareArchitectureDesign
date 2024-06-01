package homeWorks.finalProject;

public class UnitProxy {
    private final Logger logger;
    private int permission;

    public UnitProxy(Logger logger, int permission) {
        this.logger = logger;
        this.permission = permission;
    }

    public void logAction(String action) {
        System.out.println(action);
        if (permission == 1) {
            logger.logAction(action);
        }
    }
}
