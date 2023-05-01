import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Drow {
    //private ArrayList<Toys> ListForDrow;
    //private ArrayList<Toys> WinList;
       
    //public Drow() {
    //    this.ListForDrow = new ArrayList<Toys>();
    //    this.WinList = new ArrayList<Toys>();
    //}

    //public ArrayList<Toys> getListForDrow() {
    //    return this.ListForDrow;
    //}

    //public ArrayList<Toys> getWinList() {
    //    return this.WinList;
    //}

    public void drow(Store newStore, ArrayList<Toys> ListForDrow, ArrayList<Toys> WinList){
        if (newStore.getRangeOfToys().size() == 0){
            System.out.println("\nРозыгрыша не будет. Игрушек нет!");
        }
        else{
            System.out.println("\nРозыгрыш начат!");
            try {
                for (int i = 0; i < 20; i++) {
                    System.out.print("#");
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
            }
            
            for (Toys toy : newStore.getRangeOfToys().keySet()) {
                ListForDrow.add(toy);
            }
            int sum = 0;
            for (int i = 0; i < ListForDrow.size(); i++) {
                sum += ListForDrow.get(i).getWeight();
            }
            Random random = new Random();
            int randChoise = random.nextInt(sum);
            int resWeight = 0;
            for (int i = 0; i < ListForDrow.size(); i++) {
                int val = resWeight + ListForDrow.get(i).getWeight();
                if (randChoise > resWeight && randChoise < val){
                    System.out.println("\nРезультат розыгрыша:\nПризовая игрушка: \n");
                    System.out.println(ListForDrow.get(i));
                    WinList.add(ListForDrow.get(i));
                }
                resWeight = val;
            }
            if (WinList.size() == 0){
                System.out.println("\nПризовыз игрушек нет.");
            }

        }
        
    }

    public void takePrize(ArrayList<Toys> ListForDrow, ArrayList<Toys> WinList, Store newStore){
        if (WinList.size() == 0){
            System.out.println("\nПризовых игрушек пока нет. Забирать нечего!");
        }
        else{
            Toys takenToy = WinList.get(0);
            for (Toys toy : newStore.getRangeOfToys().keySet()) {
                    if (takenToy.getName().equals(toy.getName())){
                        Integer newCount = newStore.getRangeOfToys().get(takenToy) - 1; 
                        if (newCount == 0){
                            newStore.delToyFromRangeOfToys(takenToy);
                        }
                        else{
                            newStore.setRangeOfToys(takenToy, newCount);
                        }
                    }
            }
            try {
                FileWriter writer = new FileWriter("takenPrizes.txt", true);
                writer.write(takenToy.toString() + "\n");
                writer.close();
            } catch (IOException var4) {
                System.out.println("Ошибка записи в файл.");
            }
            WinList.remove(0);
            System.out.println("\nИгрушку забрали!\nДанные об игрушке записаны в файл.");
        }
    }
}
