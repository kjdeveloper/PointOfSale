package outputdevices;

class Printer implements OutputDevice {

    public void print(String text) {
        System.out.println("Printer: \n" + text);
    }
}
