package co.com.grupomas.moviva.listview.model;

import java.util.ArrayList;
import java.util.List;

public class ListViewUseCase {

    private static List<String> list;

    public static List<String> getListNames() {
        list = new ArrayList<String>(){};
        list.add("Eduar");
        list.add("Alexis");
        list.add("Angie");
        list.add("Dante");
        list.add("Dino");
        list.add("Lorenzo");
        list.add("Enzo");
        list.add("Arlex");
        list.add("Sonia");
        list.add("Alberto");
        list.add("Ansizar");
        list.add("Beto");
        list.add("Tulio");
        list.add("Marcela");
        list.add("Lorena");
        list.add("Diego");
        list.add("Maria");
        list.add("Janathan");
        return list;
    }

    public static List<String> searchNameInList(String name) {
        List<String> list2 = new ArrayList<String>(){};
        if (name.equals("")){
            return list;
        } else {
            for (String iter: list) {
                if (iter.equals(name)) {
                    list2.add(name);
                    break;
                }
            }
            return list2;
        }
    }
}
