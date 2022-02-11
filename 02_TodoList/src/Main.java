import java.util.Scanner;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите команду и дело для работы с ArrayList, \"0\" - для выхода ");
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            } else if (input.isBlank()){
                System.out.println("Введена пустая строка");
            } else {
                commander(input);
            }
        }
        scanner.close();
    }

    public static void commander(String commandString){
        String command = "";
        String toDo = "";
        int endCommand = commandString.indexOf(' ', 0);     // командное слова = с начала строки и до 1го пробела
        if (endCommand < 0){                            //если нет ни одного пробела, то может быть только команда LIST
            command = commandString;
        } else {
            command = commandString.substring(0, endCommand).trim();
            if (commandString.length() > command.length()) {          // если длина строки больше длины команды
                toDo = commandString.substring(endCommand).trim();    // присваеваем toDo остаток строки
            }
        }

        switch (command){
            case "ADD" :
                int space = toDo.indexOf(' ', 0);
                if (space < 0){         // если пробел не найден
                    todoList.add(toDo); // добавление в конец списка
                } else if (isDigit(toDo.substring(0,space).trim())){    //если пробел найден, проверяем на число часть строки
                    int index = Integer.parseInt(toDo.substring(0,space).trim());
                    todoList.add(index, toDo.substring(space).trim());
                } else {
                    todoList.add(toDo); // если не число добавляем в конец строки
                }
                break;
            case "LIST" :
                for (int i = 0; i < todoList.getTodos().size(); i++){
                    System.out.println(i + " - " + todoList.getTodos().get(i));
                }
                break;
            case "EDIT" :
                int lastSpace = toDo.lastIndexOf(' ');      //ищем последний пробел во фразе toDo
                if (lastSpace > 0 && isDigit(toDo.substring(lastSpace).trim())){
                    int index = Integer.parseInt(toDo.substring(lastSpace).trim());     // символ после последнего пробела до конца строки (индекс редактируемого элемента)
                    todoList.edit(toDo.substring(0,lastSpace), index);
                } else {
                    System.out.println("после команды нужно ввести новое дело и индекс по которому его необходимо заменить");
                }
                break;
            case "DELETE" :
                if (isDigit(toDo) && !toDo.isEmpty()){
                    todoList.delete(Integer.parseInt(toDo));
                } else {
                    System.out.println("Введите индекс по которому нужно удалить дело после команы - DELETE");
                }
                break;
            default:
                System.out.println("не корректная команда");
        }

    }

    public static boolean isDigit(String index){
        for(int i = 0; i < index.length(); i++){
            char symbol = index.charAt(i);
            if (!Character.isDigit(symbol)){
                return false;
            }
        }
        return true;
    }
}
