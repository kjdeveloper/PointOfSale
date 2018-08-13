package pos;

import java.math.BigDecimal;

class Product {

    Product(String name, BigDecimal price, Barcode barcode) {
        this.name = name;
        this.price = price;
        this.barcode = barcode;
    }

    private final String name;
    private final BigDecimal price;
    private final Barcode barcode;

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Barcode getBarcode() {
        return barcode;
    }

    @Override
    public String toString() {
        return " Product: " + name +
                ", price: " + price + ".\n";
    }
}
