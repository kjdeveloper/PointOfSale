package pos;

import outputdevices.DeviceType;
import outputdevices.OutputDevice;
import outputdevices.OutputDeviceFactory;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;


public class PointOfSale {

    private final FakeProductRepository fakeProductRepository;
    private final OutputDeviceFactory outputDeviceFactory;
    private final ProductReportCreator productReportCreator;
    private final Set<Product> scannedProduct = new HashSet<>();

    public PointOfSale(FakeProductRepository fakeProductRepository, OutputDeviceFactory outputDeviceFactory, ProductReportCreator productReportCreator) {
        this.fakeProductRepository = fakeProductRepository;
        this.outputDeviceFactory = outputDeviceFactory;
        this.productReportCreator = productReportCreator;
    }

    public void service (){
        String barcode;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Podaj kod produktu: ");
            barcode = sc.nextLine();
            scan(barcode);
        }while (!barcode.equals("exit"));
    }

    private void scan(String barcode) {
        if (isExit(barcode)) {
            exit();
            return;
        }
        Barcode barcode1 = Barcode.of(barcode);
        Optional<Product> product = fakeProductRepository.get(barcode1);
        product
                .map(this::printAndSave)
                .orElseGet(this::printNotFound);
    }

    private BigDecimal totalPrice(Set<Product> productList) {
        return productList
                .stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private String printAndSave (Product product){
        OutputDevice outputDeviceLcd = outputDeviceFactory.create(DeviceType.LCD);
        String reportForSingleProduct = productReportCreator.createReportForSingleProduct(product);
        outputDeviceLcd.print(reportForSingleProduct);
        scannedProduct.add(product);
        return reportForSingleProduct;
    }

    private String printNotFound(){
        OutputDevice outputDevice = outputDeviceFactory.create(DeviceType.LCD);
        String reportForNotFound = "Product not found";
        outputDevice.print(reportForNotFound);
        return reportForNotFound;
    }

    private void exit() {
        OutputDevice outputDevicePrinter = outputDeviceFactory.create(DeviceType.PRINTER);
        OutputDevice outputDeviceLcd = outputDeviceFactory.create(DeviceType.LCD);
        String textForPrinter = productReportCreator.createReportForALlScannedProducts(scannedProduct, totalPrice(scannedProduct));
        outputDevicePrinter.print(textForPrinter);
        outputDeviceLcd.print("Całkowita kwota do zapłaty: " + totalPrice(scannedProduct));
    }

    private boolean isExit(String barcode) {
        return barcode.equals("exit");
    }
}

