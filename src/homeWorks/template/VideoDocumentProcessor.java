package homeWorks.template;

class VideoDocumentProcessor extends DocumentProcessor {
    @Override
    protected void openDocument() {
        System.out.println("Открытие видео");
    }

    @Override
    protected void extractContent() {
        System.out.println("Извлечение видео");
    }

    @Override
    protected void manipulateContent() {
        System.out.println("Конвертация видео в другой формат");
    }

    @Override
    protected void saveDocument() {
        System.out.println("Сохранение видео");
    }
}
