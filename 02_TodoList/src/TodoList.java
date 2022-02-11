import java.util.ArrayList;

public class TodoList {
    ArrayList<String> list = new ArrayList<>();

    public void add(String todo) {      //добавляем дело в конец списка
        list.add(todo);
        System.out.println("Добавлено дело \"" + todo + "\" в конец списка");
    }

    public void add(int index, String todo) {   //добавляем дело на индекс, если возможно
        if(index >= 0 && index < list.size()){
            list.add(index, todo);
            System.out.println("Добавлено дело \"" + todo + "\" по индексу " + index);
        } else {
            list.add(todo);
            System.out.println("Добавлено дело \"" + todo + "\" в конец списка");
        }
    }

    public void edit(String todo, int index) {      //заменяем дело по индексу, если существует
        if (index >= 0 && index < list.size()){
            list.set(index,todo);
            System.out.println("Заменено дело \"" + todo + "\" по индексу " + index);
        } else {
            System.out.println("Ошибка заменены дела - индекс " + index + " не существует");
        }
    }

    public void delete(int index) {         //удаляем дело по переданному индексу, если возможно
        if (index >= 0 && index < list.size()) {
            String deleted = list.get(index);
            list.remove(index);
            System.out.println("Удалено дело \"" + deleted + "\" по индексу " + index);
        } else {
            System.out.println("Дела с индексом " + index + " не существует");
        }
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        return list;
    }
}
