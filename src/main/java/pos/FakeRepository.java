package pos;

import java.util.Optional;

public interface FakeRepository {

    Product save(Product product);

    Optional<Product> get(Barcode barcode);

}
