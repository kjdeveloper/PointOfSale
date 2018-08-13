package pos;

import outputdevices.OutputDeviceFactory;
import java.math.BigDecimal;


public class Main {
    public static void main(String[] args) {

        FakeProductRepository productRepository = new FakeProductRepository();
        productRepository.save(new Product("Kurtka", BigDecimal.valueOf(200), Barcode.of("1234")));
        productRepository.save(new Product("Bluza", BigDecimal.valueOf(333), Barcode.of("1235")));
        productRepository.save(new Product("Buty", BigDecimal.valueOf(456), Barcode.of("1236")));
        productRepository.save(new Product("Spodnie", BigDecimal.valueOf(270), Barcode.of("1237")));

        ProductReportCreator productReportCreator = new ProductReportCreator();
        OutputDeviceFactory outputDeviceFactory = new OutputDeviceFactory();

        PointOfSale pointOfSale = new PointOfSale(productRepository, outputDeviceFactory, productReportCreator);

        pointOfSale.service();

    }
}
