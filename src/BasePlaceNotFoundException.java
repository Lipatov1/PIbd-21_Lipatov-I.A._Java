public class BasePlaceNotFoundException extends Exception {
    public BasePlaceNotFoundException(int i) {
        super("Техника по месту " + i +  " не найдена");
    }
}