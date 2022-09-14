import java.util.Random;

public class Item {
    private String name;
    private Integer price;
    private final Boolean isLast;

    public Item(Boolean isLast) {
        this.name = "";
        this.price = 0;
        this.isLast = isLast;
    }

    public Item(String name, Integer price, Boolean isLast) {
        this.name = name;
        this.price = price;
        this.isLast = isLast;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Boolean isLast() {
        return isLast;
    }

    public void randomFill(Integer nameTag, Integer minPrice, Integer maxPrice) {
        name = "Item" + nameTag;
        Random rand = new Random();
        price = minPrice + rand.nextInt(maxPrice - minPrice + 1);
    }
}
