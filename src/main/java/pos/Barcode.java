package pos;

class Barcode {

    private final static String REGEX = "[\\d]{4}";
    private final String barcode;

    Barcode(String barcode) {
        this.barcode = barcode;
    }

    static Barcode of(String code){
        validateCode(code);
        return new Barcode(code);
    }

    private static void validateCode (String code){
        if (!code.matches(REGEX)){
            System.out.println("Invalid barcode");
        }
    }

    @Override
    public String toString() {
        return "Barcode: " + barcode + " ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Barcode barcode1 = (Barcode) o;

        return barcode != null ? barcode.equals(barcode1.barcode) : barcode1.barcode == null;
    }

    @Override
    public int hashCode() {
        return barcode != null ? barcode.hashCode() : 0;
    }
}

