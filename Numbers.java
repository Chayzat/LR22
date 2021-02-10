package sample;

import javafx.beans.property.SimpleStringProperty;

public class Numbers {
    private SimpleStringProperty n1;
    private SimpleStringProperty n2;
    private SimpleStringProperty n3;
    private SimpleStringProperty n4;
    private SimpleStringProperty n5;

    public Numbers (String n1, String n2, String n3, String n4, String n5) {
        this.n1 = new SimpleStringProperty(n1);
        this.n2 = new SimpleStringProperty(n2);
        this.n3 = new SimpleStringProperty(n3);
        this.n4 = new SimpleStringProperty(n4);
        this.n5 = new SimpleStringProperty(n5);
    }

    public Numbers () {
        this.n1 = new SimpleStringProperty("-1");
        this.n2 = new SimpleStringProperty("-5.0");
        this.n3 = new SimpleStringProperty("-8.0");
        this.n4 = new SimpleStringProperty("-10.0");
        this.n5 = new SimpleStringProperty("-9.0");
    }

    public String getN1() {
        return n1.get();
    }

    public void setN1(String n1) {
        this.n1.set(n1);
    }

    public String getN2() {
        return n2.get();
    }

    public void setN2(String n2) {
        this.n2.set(n2);
    }

    public String getN3() {
        return n3.get();
    }

    public void setN3(String n3) {
        this.n3.set(n3);
    }

    public String getN4() {
        return n4.get();
    }

    public void setN4(String n4) {
        this.n4.set(n4);
    }

    public String getN5() {
        return n5.get();
    }

    public void setN5(String n5) {
        this.n5.set(n5);
    }
}
