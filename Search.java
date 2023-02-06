import java.util.ArrayList;

public class Search<R> {
    private R seek;

    Search(R seek) {
        this.seek = seek;
    }

    public Boolean searchUrgent(ArrayList<String[]> list) {
        Boolean check = true;
        for (int i = 0; i < list.size(); i++) {
            String[] el = list.get(i);
            check = check & el[el.length - 1].contains(String.valueOf(seek));
        }
        return check;
    }
}

class Urgent {

    public static void main(String[] args) {
        Search<Integer> newOb = new Search<>(0);

        Boolean urgent = newOb.searchUrgent(Menu.list);

        System.out.println(urgent);
    }
}