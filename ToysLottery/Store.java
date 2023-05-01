import java.util.HashMap;
import java.util.Map;

public class Store {
    private String Name;
    private String Adress;
    private String SphereOfWork;
    private Map<Toys, Integer> rangeOfToys;
    
    public Store(String name, String adress, String sphereOfWork) {
        this.Name = name;
        this.Adress = adress;
        this.SphereOfWork = sphereOfWork;
        this.rangeOfToys = new HashMap<Toys, Integer>();
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getAdress() {
        return this.Adress;
    }

    public void setAdress(String adress) {
        this.Adress = adress;
    }

    public String getSphereOfWork() {
        return this.SphereOfWork;
    }

    public void setSphereOfWork(String sphereOfWork) {
        this.SphereOfWork = sphereOfWork;
    }

    public void setRangeOfToys(Toys toy, Integer count){
        this.rangeOfToys.put(toy, count);
    }

    public Map<Toys, Integer> getRangeOfToys(){
        return this.rangeOfToys;
    }

    public void delToyFromRangeOfToys(Toys toy){
        this.rangeOfToys.remove(toy);
    }

    @Override
    public String toString() {
        return "Название магазина: " + this.Name
        + "Адрес магазина: " + this.Adress
        + "Сфера деятельности: " + this.SphereOfWork;
    }
    
}
