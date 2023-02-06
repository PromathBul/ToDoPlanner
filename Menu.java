import java.util.Random;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    static ArrayList<String[]> list = new ArrayList<>();
    // static String id = "";

    /**
     * Метод возвращает случайное целое число от 0 до значения переданного аргумента
     */
    UnaryOperator<Integer> randomNum = max -> new Random().nextInt(max);

    /**
     * Метод принимает принимает от пользователя целое число и возвращает его
     */
    Function<String, Integer> inputNum = msg -> {
        System.out.print(msg);
        Scanner in = new Scanner(System.in);
        Integer num = in.nextInt();
        return num;
    };

    /**
     * Метод принимает на вход сообщение для информирования пользователя; 
     * возвращает строку, которую ввел пользователь
     */
    UnaryOperator<String> input = msg -> {
        System.out.print(msg);
        Scanner in = new Scanner(System.in, "cp866");
        String out = in.nextLine();
        return out;
    };

    /**
     * Метод, реализующий клиентское меню.
     */
    public void menu() {
        TXT fileTXT = new TXT();

        fileTXT.fromFile(list, "ToDoList.txt");
        fileTXT.writeFile(list, "ToDoList.txt");

        String txt = "";
        while (!txt.equals("да")) {
            System.out.println("Выберите действие.");
            Integer choice = inputNum.apply(
                    "1. Добавить в файл новую задачу.\n2. Вывести на экран список задач со статусом срочности.\n");
            if (choice == 1) {
                String[] newString = ToDo.getData();
                ToDo obj = new ToDo(newString);
                obj.addInfo(newString, list);
                fileTXT.writeFile(list, "ToDoList.txt");
            } else if (choice == 2)
                fileTXT.readFile(list, "ToDoList.txt");
            else
                System.out.println("Неверный ввод.");

            txt = input.apply("Введите 'да', если хотите завершить, иил нажмите ввод, чтобы продолжить... ");
        }

    }
}