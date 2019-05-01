import java.util.ArrayList;
import java.util.Scanner;

public class Loader {

    private static ArrayList<String> list;

    public static void main(String[] args) {
        list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("\nType command (to view available commands type \"HELP\"):");
            String command = scanner.nextLine().trim();
            if (command.equals("EXIT")) {
                break;
            } else if (command.equals("HELP")) {
                printCommands();
            } else if (command.startsWith("ADD")) {
                String[] strings = command.split("\\s+");
                if (strings[1].matches("\\d+")) {
                    addByIndex(command);
                } else {
                    add(command);
                }
            } else if (command.startsWith("EDIT")) {
                edit(command);
            } else if (command.startsWith("DELETE")) {
                delete(command);
            } else if (command.startsWith("PRINT")) {
                printList();
            } else {
                System.out.println("Wrong command, try again!");
            }
        } while (true);
    }

    private static void printCommands() {
        System.out.println("Type \"ADD Do Anything\" to add entry to the end of the list.");
        System.out.println("Type \"ADD {position} Do Anything\" to add entry to the specified position of the list.");
        System.out.println("Type \"EDIT {position} New entry\" to edit the entry.");
        System.out.println("Type \"DELETE {position}\" to delete the entry.");
        System.out.println("Type \"PRINT \" to print the list.");
        System.out.println("Type \"HELP\" to view available commands.");
        System.out.println("Type \"EXIT\" for exit.");
    }

    private static void add(String toDo) {
        toDo = toDo.replaceFirst("ADD", "").trim();
        list.add(toDo);
        System.out.println("Entry added");
    }

    private static void addByIndex(String toDo) {
        toDo = toDo.replaceFirst("ADD", "").trim();
        int index = Integer.parseInt(toDo.substring(0, toDo.indexOf(' ')));
        list.add(index, toDo.substring(toDo.indexOf(' ') + 1));
        System.out.println("Entry added to the " + index + " position");
    }

    private static void edit(String toDo) {
        toDo = toDo.replaceFirst("EDIT", "").trim();
        int index = Integer.parseInt(toDo.substring(0, toDo.indexOf(' ')));
        list.set(index, toDo.substring(toDo.indexOf(' ') + 1));
        System.out.println("Entry changed");

    }

    private static void delete(String toDo) {
        toDo = toDo.replaceFirst("DELETE", "").trim();
        int index = Integer.parseInt(toDo);
        list.remove(index);
        System.out.println("Entry deleted");
    }

    private static void printList() {
        System.out.println("TODO List: ");
        for (int i = 1; i <= list.size(); i++) {
            System.out.println(i + ". " + list.get(i - 1));
        }
    }
}


/*
* Разработать список дел, которым можно управлять командами в консоли.
* Команды LIST, ADD, EDIT, DELETE. LIST должен выводить дела с их порядковыми номерами.
* ADD - добавлять дело в конец списка или дело на определённое место, сдвигая остальные дела вперёд, если указать номер.
* EDIT - заменять дело с указанным номером.
* DELETE - удалять. Примеры команд:



    LIST

    ADD Какое-то дело

    ADD 4 Какое-то дело на четвёртом месте

    EDIT 3 Новое название дела

    DELETE 7*/
