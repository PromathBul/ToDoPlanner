
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TXT implements I_WorkWithFiles {

    @Override
    public void writeFile(ArrayList<String[]> list, String nameFile) {
        try (FileWriter fw = new FileWriter(nameFile, false)) {
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.get(i).length; j++)
                    fw.write(list.get(i)[j] + ";");
                fw.append('\n');
            }
            fw.flush();
            fw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void readFile(ArrayList<String[]> list, String nameFile) {

        try {
            FileReader fr = new FileReader(nameFile);
            BufferedReader br = new BufferedReader(fr);
            String str;
            String txt = "id: ";
            Integer count = 0;
            while ((str = br.readLine()) != null) {
                System.out.print(txt);
                for (int i = 0; i < str.length(); i++) {
                    if(count == 0)
                        txt = "дедлайн: ";
                    else if(count == 1)
                        txt = "автор записи: ";
                    else if(count == 2)
                        txt = "описание задачи: ";
                    else if(count == 3)
                        txt = "время записи: ";
                    else if(count == 4)
                        txt = "дата записи: ";
                    else if(count == 5)
                        txt = "Оставшееся количество дней: ";
                    else 
                        txt = "";
                    System.out.print(str.charAt(i));
                    if(str.charAt(i) == ';') {
                        System.out.print(" " + txt);
                        count++;
                    }
                }
                System.out.print("\n");
            }
            br.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void fromFile(ArrayList<String[]> list, String nameFile) {
        try {
            FileReader fr = new FileReader(nameFile);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while (((line = br.readLine()) != null)) {
                String[] arrayLine = line.split("; ", 0);
                String days = ToDo.getPriority(arrayLine[1]);
                arrayLine[arrayLine.length - 1] = String.format("%s", days);
                list.add(arrayLine);
            }
            br.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
