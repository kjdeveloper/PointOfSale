package pos;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class FakeProductRepository implements FakeRepository {


    private final Map<Barcode, Product> productMap = new HashMap<>();

    @Override
    public Product save(Product product) {
        return productMap.put(product.getBarcode(), product);
    }

    @Override
    public Optional<Product> get(Barcode barcode) {
        return Optional.ofNullable(productMap.get(barcode));
    }

    @Override
    public String toString() {
        return "" + productMap;
    }
}
