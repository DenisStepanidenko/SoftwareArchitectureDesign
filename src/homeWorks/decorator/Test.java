package homeWorks.decorator;

public class Test {
    public static void main(String[] args) {
        TextFormat textFormat = new ItalicTextFormat(new BoldTextFormat(new PlainText()));
        System.out.println(textFormat.applyFormat());

    }
}
