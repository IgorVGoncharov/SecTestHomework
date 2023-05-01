import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в приложение 'Магазин игрушек'!\n\nДля начала, давайте создадим новый магазин:");
        Scanner scanner = new Scanner(System.in, "CP866");
        Store newStore = new StoreActions().addNewStore(scanner);
        ArrayList<Toys> ListForDrow = new ArrayList<Toys>();
        ArrayList<Toys> WinList = new ArrayList<Toys>();
        
        new Menu().menu(scanner, newStore, ListForDrow, WinList);
        
    }

    
}
