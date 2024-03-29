package homeWorks.decorator;

public class ItalicTextFormat extends TextFormatDecorator{
    public ItalicTextFormat(TextFormat textFormat) {
        super(textFormat);
    }

    public String makeItalic(){
        return ".Making text italic";
    }

    @Override
    public String applyFormat() {
        return super.applyFormat() + makeItalic();
    }
}
