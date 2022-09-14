public class Item {
    private final String name;
    private final Boolean isLast;

    public Item(Boolean isLast) {
        this.name = "";
        this.isLast = isLast;
    }

    public Item(String name, Boolean isLast) {
        this.name = name;
        this.isLast = isLast;
    }

    public String getName() {
        return name;
    }

    public Boolean isLast() {
        return isLast;
    }
}
