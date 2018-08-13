package pos;

import java.math.BigDecimal;
import java.util.Set;

class ProductReportCreator {

    String createReportForSingleProduct(Product product) {
        return "Nazwa produktu: " + product.getName() + " cena: " + product.getPrice();
    }

    String createReportForALlScannedProducts(Set<Product> productList, BigDecimal totalPrice) {

        StringBuilder sb = new StringBuilder();

        productList.forEach(s -> {

            sb.append(createReportForSingleProduct(s));
            sb.append("\n");
        });

        sb.append("Całkowita kwota do zapłaty: " + totalPrice);
        return sb.toString();

    }
}
