package entities;

public class Room {
    private int number;
    private int capacity;
    private String category;
    private int cost;
    private boolean isFree;

    public Room() {
    }

    public Room(int number, int capacity, String category, int cost, boolean isFree) {
        this.number = number;
        this.capacity = capacity;
        this.category = category;
        this.cost = cost;
        this.isFree = isFree;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    @Override
    public String toString() {
        return "Room{" +
                "number=" + number +
                ", capacity=" + capacity +
                ", category='" + category + '\'' +
                ", cost=" + cost +
                ", isFree=" + isFree +
                '}';
    }
}
