import java.util.ArrayList;

/**
 * Интерфейс, определяющий методы записи или чтения файлов
 */

public interface I_WorkWithFiles {
    /**
     * Метод записи задач в файл из списка массивов строк
     * @param list - основной список, где хранится информация о задачах в массивах строк
     * @param nameFile - имя файла с расширением и относительным путем.
     */
    public void writeFile(ArrayList<String[]> list, String nameFile);

    /**
     * Метод считывающий отформатированную информацию в консоль
     * @param list - список, содержащий массивы строк с информацией о каждой задаче
     * @param nameFile - имя файла с расширением и относительныйм путем
     */
    public void readFile(ArrayList<String[]> list, String nameFile);

    /**
     * Метод записывающий в список массивов строк информацию о задачах из файла txt
     * @param list - список, содержащий массивы строк с информацией о каждой задаче
     * @param nameFile - имя файла с расширением и относительныйм путем
     */
    public void fromFile(ArrayList<String[]> list, String nameFile);
}
