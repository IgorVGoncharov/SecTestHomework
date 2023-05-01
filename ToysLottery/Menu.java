import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public void menu(Scanner scanner, Store newStore, ArrayList<Toys> ListForDrow, ArrayList<Toys> WinList){
        try {
            StoreActions action = new StoreActions();
            Drow newDrow = new Drow();
            System.out.println("\nМеню: ");
            System.out.println("1. Создать новую игрушку.");
            System.out.println("2. Изменить частоту выпадания игрушки.");
            System.out.println("3. Изменить количество игрушек.");
            System.out.println("4. Показать список игрушек.");
            System.out.println("5. Начать розыгрыш.");
            System.out.println("6. Получить призовую игрушку.");
            System.out.println("7. Выйти из приложения.");
            System.out.print("Введите значение: ");
            int newCount = scanner.nextInt();
            scanner.nextLine();
            if (newCount == 1){
                action.addNewToy(scanner, newStore);
                menu(scanner, newStore, ListForDrow, WinList );
            }
            else if (newCount == 2){
                action.changeWeightOfToy(scanner, newStore);
                menu(scanner, newStore, ListForDrow, WinList);
            }
            else if (newCount == 3){
                action.changeCountOfToy(scanner, newStore);
                menu(scanner, newStore, ListForDrow, WinList);
            }
            else if (newCount == 4){
                action.showListOfToys(newStore);
                menu(scanner, newStore, ListForDrow, WinList);
            }
            else if (newCount == 5){
                newDrow.drow(newStore, ListForDrow, WinList);
                menu(scanner, newStore, ListForDrow, WinList);
            }
            else if (newCount == 6){
                newDrow.takePrize(ListForDrow, WinList, newStore);
                menu(scanner, newStore, ListForDrow, WinList);
            }
            else if (newCount == 7){
                System.out.println("\nДо скорых втреч!");
            }
            else{
                System.out.println("\nВведено не верное значение!");
                menu(scanner, newStore, ListForDrow, WinList);
            }
        } catch (Exception exception) {
            scanner.nextLine();
            System.out.println("\nВведено не число!");
            menu(scanner, newStore, ListForDrow, WinList);
        }
    }
}
