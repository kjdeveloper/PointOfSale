package outputdevices;

class Lcd implements OutputDevice {

    public void print(String text) {
        System.out.println("Lcd: \n" + text);
    }
}
