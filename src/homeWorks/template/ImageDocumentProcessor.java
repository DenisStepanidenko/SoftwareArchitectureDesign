package homeWorks.template;

class ImageDocumentProcessor extends DocumentProcessor {
    @Override
    protected void openDocument() {
        System.out.println("Открытие изображения");
    }

    @Override
    protected void extractContent() {
        System.out.println("Извлечение изображения");
    }

    @Override
    protected void manipulateContent() {
        System.out.println("Наложение фильтров на изображение");
    }

    @Override
    protected void saveDocument() {
        System.out.println("Сохранение изображения");
    }
}