package homeWorks.decorator;

public class BoldTextFormat extends TextFormatDecorator{
    public BoldTextFormat(TextFormat textFormat) {
        super(textFormat);
    }

    public String makeBold(){
        return ".Making text bold";
    }

    @Override
    public String applyFormat() {
        return super.applyFormat() + makeBold();
    }
}
