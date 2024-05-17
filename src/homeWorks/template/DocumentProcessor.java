package homeWorks.template;

abstract class DocumentProcessor {
    // Шаблонный метод для обработки документа
    public void processDocument() {
        openDocument();
        extractContent();
        manipulateContent();
        saveDocument();
    }

    // Абстрактные методы, которые должны быть реализованы в подклассах
    protected abstract void openDocument();
    protected abstract void extractContent();
    protected abstract void manipulateContent();
    protected abstract void saveDocument();
}