package homeWorks.decorator;

public class TextFormatDecorator implements TextFormat {
    TextFormat textFormat;

    public TextFormatDecorator(TextFormat textFormat) {
        this.textFormat = textFormat;
    }

    @Override
    public String applyFormat() {
        return textFormat.applyFormat();
    }
}
