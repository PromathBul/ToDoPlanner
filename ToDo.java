import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Function;

/**
 * Класс, отвечающий за создание списка задача, добавления в него новых задач
 */
public class ToDo{

    private String[] data;

    ToDo(String[] info) {
        this.data = info;
    }

    ToDo() {

    }

    /**
     * Метод создания массива уникальных номеров
     */
    // Function<Integer, Integer[]> getListID = size -> {
    //     Integer[] list = new Integer[size];
    //     Integer id = 1;

    //     for (int i = 0; i < list.length; i++)
    //         list[i] = id++;

    //     return list;
    // };

    // Integer[] listID = getListID.apply(1000);

    /**
     * Получение из массива целых чисел уникального id
     */
    // Function<Integer[], String> getID = list -> {
    //     Integer id = -1;

    //     for (int i = 0; i < list.length; i++)
    //         if (list[i] != -1) {
    //             id = list[i];
    //             list[i] = -1;
    //             break;
    //         }

    //     return Integer.toString(id);
    // };

    /**
     * Метод создания массива строк и заполнения его данными о задачи; 
     * текущая дата, время заполняются автоматически с помощью экземпляров классов Date и SimpleDateFormat; 
     * уникальный номер получается с помощью метода apply через интерфейс Function; 
     * расчет количества оставшихся дней происходит путем получения разницы результатов методов getTime().
     */
    public static String[] getData() {
        String[] info = new String[7];
        for (int i = 0; i < 4; i++) {
            String txt = "Введите ";
            if (i == 0)
                txt += "id: ";
            if (i == 1)
                txt += txt += "дедлайн задачи: в формате dd.MM.yyyy: ";
            else if (i == 2)
                txt += "имя автора: ";
            else if (i == 3)
                txt += "описание задачи: ";
            System.out.print(txt);
            Scanner in = new Scanner(System.in, "cp866");
            info[i] = in.nextLine();
        }

        // ToDo obj = new ToDo();
        Date date = new Date();
        SimpleDateFormat dateWithoutTime = new SimpleDateFormat("HH:mm");
        info[4] = dateWithoutTime.format(date);

        SimpleDateFormat time = new SimpleDateFormat("dd.MM.yyyy");
        info[5] = time.format(date);

        info[info.length - 1] = getPriority(info[1]);
        return info;
    }

    /**
     * Метод расчета оставшегося количества дней до дейдлайна
     * @param deadLine - дата дедлайна в строковом представлении
     * @return - возвращает строку с информацией о количестве оставшихся дней
     */
    public static String getPriority(String deadLine) {

        SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        String currentDate = formater.format(date);
        System.out.println(currentDate);

        Date endDate = null;
        try {
            endDate = formater.parse(deadLine);
        } catch (Exception e) {
            e.printStackTrace();
        }

        long diff = endDate.getTime() - date.getTime();
        Integer days = (int) (diff / (1000 * 60 * 60 * 24));

        return String.format("до истечения срока осталось %d дней", days);
    }

    /**
     * Метод добавления в список нового массива строк
     * @param info - массив строк с полной информацией о задаче
     * @param total - список, содержащий массив строк
     */
    public void addInfo(String[] info, ArrayList<String[]> total) {
        total.add(info);
    }

}