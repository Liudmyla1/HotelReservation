package entities;

public class Invoice {
    private int id;
    private int requestId;
    private int totalCost;
    private boolean isPayed;

    public Invoice() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public boolean isPayed() {
        return isPayed;
    }

    public void setPayed(boolean payed) {
        isPayed = payed;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", requestId=" + requestId +
                ", totalCost=" + totalCost +
                ", isPayed=" + isPayed +
                '}';
    }
}
