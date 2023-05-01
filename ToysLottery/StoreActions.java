import java.util.Scanner;

public class StoreActions {

    public Store addNewStore(Scanner scanner){
        //System.out.println("Добавление нового магазина: ");
        System.out.print("Введите наименование магазина: ");
        String name = scanner.nextLine();
        System.out.print("Введите адрес магазина: ");
        String address = scanner.nextLine();
        System.out.print("Введите сферу деятельности магазина: ");
        String sphere = scanner.nextLine();
        Store newStore = new Store(name, address, sphere);
        System.out.println("Новый магазин создан.");
        return newStore;
    }

    public void addNewToy(Scanner scanner, Store newStore){
        System.out.println("\nДобавление новой игрушки: ");
        System.out.print("Введите наименование игрушки: ");
        String Toyname = scanner.nextLine();
        System.out.print("Введите производителя игрушки: ");
        String brand = scanner.nextLine();
        System.out.print("Введите цвет игрушки: ");
        String color = scanner.nextLine();
        System.out.print("Введите ограничение по возрасту: ");
        Integer ageLimit = scanner.nextInt();
        System.out.print("Введите частоту выпадания игрушки: ");
        Integer weight = scanner.nextInt();
        System.out.print("Введите количество игрушки: ");
        Integer count = scanner.nextInt();
        Toys newToy = new Toys(Toyname, brand, color, ageLimit, weight);
        newStore.setRangeOfToys(newToy, count);
        System.out.println("\nИгрушка добавлена");
    }

    public void showListOfToys(Store newStore){
        if (newStore.getRangeOfToys().size() == 0){
            System.out.println("\nВ списке пока нет игрушек!");
        }
        else{
            System.out.println("\nТекущий список игрушек: ");
            newStore.getRangeOfToys().forEach((k, v) -> System.out.println("\nИгрушка: " + k + "\nКоличество: " + v));
        }
    }

    public void changeCountOfToy(Scanner scanner, Store newStore){
        showListOfToys(newStore);
        System.out.print("\nВведите наименование игрушки, по которой хотите изменить количество: ");
        String choise = scanner.nextLine();
        int val = 0;
        for (Toys toy : newStore.getRangeOfToys().keySet()) {
            if (toy.getName().equals(choise)){
                System.out.print("Введите новое количество: ");
                Integer newCount = scanner.nextInt();
                newStore.setRangeOfToys(toy, newCount);
                val += 1;
            }
        }
        if (val == 0){
            System.out.println("Игрушка с таким названием не найдена!");
        }
        else{
            System.out.println("Количеесвто игрушек изменено.");
        }
    }

    public void changeWeightOfToy(Scanner scanner, Store newStore){
        showListOfToys(newStore);
        System.out.print("\nВведите наименование игрушки, по которой хотите изменить частоту выпадания: ");
        String toyChoise = scanner.nextLine();
        int val = 0;
        for (Toys toy : newStore.getRangeOfToys().keySet()) {
            if (toy.getName().equals(toyChoise)){
                    System.out.print("Введите новую частоту выпадания: ");
                    Integer newWeight = scanner.nextInt();
                    toy.setWeight(newWeight);
                    val += 1;
                }           
        }
        if (val == 0){
            System.out.println("Игрушка с таким названием не найдена!");
        }
        else{
            System.out.println("Частота выпадания игрушки изменена.");
        }
    }
}
