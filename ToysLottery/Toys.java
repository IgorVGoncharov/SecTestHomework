import java.util.UUID;

public class Toys {
    private UUID ID;
    private String Name; 
    private String Brand; 
    private String Color; 
    private Integer AgeLimit; 
    private Integer Weight;
    
    public Toys(String name, String brand, String color, Integer ageLimit, Integer weight) {
        this.ID = UUID.randomUUID();
        this.Name = name;
        this.Brand = brand;
        this.Color = color;
        this.AgeLimit = ageLimit;
        this.Weight = weight;
    }

    public UUID getID() {
        return this.ID;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getBrand() {
        return this.Brand;
    }

    public String getColor() {
        return this.Color;
    }

    public Integer getAgeLimit() {
        return this.AgeLimit;
    }

    public void setAgeLimit(Integer ageLimit) {
        this.AgeLimit = ageLimit;
    }

    public Integer getWeight() {
        return this.Weight;
    }

    public void setWeight(Integer weight) {
        this.Weight = weight;
    }

    @Override
    public String toString() {
        return "ID: " + this.ID 
        + "\nНазвание: " + this.Name 
        + "\nПроизводитель: " + this.Brand 
        + "\nЦвет: " + this.Color
        + "\nОграничение по возрасту: " + this.AgeLimit
        + "\nЧастота выпадания: " + this.Weight;
    }

}
