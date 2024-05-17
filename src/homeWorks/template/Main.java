package homeWorks.template;

public class Main {
    public static void main(String[] args) {
        DocumentProcessor textProcessor = new TextDocumentProcessor();
        textProcessor.processDocument();

        DocumentProcessor imageProcessor = new ImageDocumentProcessor();
        imageProcessor.processDocument();

        DocumentProcessor videoProcessor = new VideoDocumentProcessor();
        videoProcessor.processDocument();
    }
}
