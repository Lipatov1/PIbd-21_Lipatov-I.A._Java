import java.awt.*;

public class Base<T extends ITransport, H extends AdditionalElems> {
    // Массив объектов, которые храним
    private final Object[] places;

    // Ширина и высота окна отрисовки
    private final int pictureWidth;
    private final int pictureHeight;

    // Ширина и высота парковочного места
    private final int placeSizeWidth = 460;
    private final int placeSizeHeight = 105;

    public Base(int pictureWidth, int pictureHeight) {
        int columnsNumber = pictureWidth / placeSizeWidth;
        int rowsNumber = pictureHeight / placeSizeHeight;
        places = new Object[columnsNumber * rowsNumber];
        this.pictureWidth = pictureWidth;
        this.pictureHeight = pictureHeight;
    }

    // Перегрузка оператора сложения
    public int add(T transport) {
        int columnNumber = pictureWidth / placeSizeWidth;
        for (int i = 0; i < places.length; i++) {
            if (places[i] == null) {
                transport.setPosition(10 + placeSizeWidth * (i % columnNumber), 10 + placeSizeHeight * (i / columnNumber), pictureWidth, pictureHeight);
                places[i] = transport;
                return i;
            }
        }
        return -1;
    }

    // Перегрузка оператора вычитания
    public T remove(int index) {
        if (index >= 0 && index < places.length && places[index] != null) {
            Object temp = places[index];
            places[index] = null;
            return (T) (temp);
        } else {
            return null;
        }
    }

    // Подсчет занятых мест
    public int countOccupiedPlaces() {
        int placesNumber = 0;
        for (Object object : places) {
            if (object != null) {
                placesNumber++;
            }
        }
        return placesNumber;
    }

    // Перегрузка оператора вычитания "=="
    public boolean equal(int number) {
        return countOccupiedPlaces() == number;
    }

    // Перегрузка оператора "!="
    public boolean unequal(int number) {
        return countOccupiedPlaces() != number;
    }

    // Метод отрисовки парковки
    public void drawBase(Graphics2D g) {
        drawMarking(g);
        for (Object place : places) {
            if (place != null) {
                T placeT = (T) place;
                placeT.drawTransport(g);
            }
        }
    }

    // Метод отрисовки разметки парковочных мест
    public void drawMarking(Graphics2D g) {
        g.setStroke(new BasicStroke(3));
        for (int i = 0; i < pictureWidth / placeSizeWidth; i++) {
            for (int j = 0; j < pictureHeight / placeSizeHeight + 1; j++) {
                g.drawLine(i * placeSizeWidth, j * placeSizeHeight, i * placeSizeWidth + placeSizeWidth / 2, j * placeSizeHeight);
            }
            g.drawLine(i * placeSizeWidth, 0, i * placeSizeWidth, (pictureHeight / placeSizeHeight) * placeSizeHeight);
        }
    }
}