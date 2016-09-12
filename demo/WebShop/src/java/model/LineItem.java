package model;

public class LineItem {
    private Cupcake cupcake;
    private int qty;

    public LineItem(Cupcake cupcake, int qty) {
        this.cupcake = cupcake;
        this.qty = qty;
    }

    public LineItem(Cupcake cupcake) {
        this.cupcake = cupcake;
    }

    public LineItem() { }

    public Cupcake getCupcake() { return cupcake;}
    public void setCupcake(Cupcake cupcake) { this.cupcake = cupcake; }

    public int getQty() { return qty; }
    public void setQty(int qty) { this.qty = qty; }

    @Override
    public String toString() {
        return "LineItem{" + "cupcake=" + cupcake + ", qty=" + qty + '}';
    }    
}
