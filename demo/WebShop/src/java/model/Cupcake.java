package model;

import java.util.Objects;

public class Cupcake {
    private int id;
    private String name;
    private String base;
    private String top;
    private double price;

    public Cupcake(int id, String name, String base, String top, double price) {
        this.id = id;
        this.name = name;
        this.base = base;
        this.top = top;
        this.price = price;
    }

    public Cupcake() { }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBase() { return base; }
    public void setBase(String base) { this.base = base; }

    public String getTop() { return top; }
    public void setTop(String top) { this.top = top; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return "CupCake{" + "id=" + id + ", name=" + name + ", base=" + base + ", top=" + top + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cupcake other = (Cupcake) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    
}
