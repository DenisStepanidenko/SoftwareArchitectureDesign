package homeWorks.decorator;

public class PlainText implements TextFormat{
    @Override
    public String applyFormat() {
        return "Plain text";
    }
}
