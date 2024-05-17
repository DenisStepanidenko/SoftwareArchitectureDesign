package homeWorks.template;

class TextDocumentProcessor extends DocumentProcessor {
    @Override
    protected void openDocument() {
        System.out.println("Открытие текстового документа");
    }

    @Override
    protected void extractContent() {
        System.out.println("Извлечение текста из текстового документа");
    }

    @Override
    protected void manipulateContent() {
        System.out.println("Обработка текста");
    }

    @Override
    protected void saveDocument() {
        System.out.println("Сохранение текстового документа");
    }
}
