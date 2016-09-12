package model;

import java.util.ArrayList;

public class Invoice {
    private int id;
    private User customer;
    private ArrayList<LineItem> items = new ArrayList<>();
    private double total = 0;

    public Invoice( int id, User customer, ArrayList<LineItem> items, double total ) {
        this.id = id;
        this.customer = customer;
        this.items = items;
        this.total = total;
    }

    public Invoice() {
    }

    public int getId() {
        return id;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer( User customer ) {
        this.customer = customer;
    }

    public ArrayList<LineItem> getItems() {
        return items;
    }

    public void setItems( ArrayList<LineItem> items ) {
        this.items = items;
    }
    
    public double getTotal(){
        return total;
    }

    @Override
    public String toString() {
        return "Invoice{" + "id=" + id + ", customer=" + customer + ", items=" + items + ", total=" + total + '}';
    }

    @Override
    public boolean equals( Object obj ) {
        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass() ) {
            return false;
        }
        final Invoice other = (Invoice) obj;
        if ( this.id != other.id ) {
            return false;
        }
        return true;
    }


}
