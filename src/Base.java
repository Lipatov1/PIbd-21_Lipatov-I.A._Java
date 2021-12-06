import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Base<T extends ITransport, H extends AdditionalElems> {
    private final List<T> places;
    private final int maxCount;

    // Ширина и высота окна отрисовки
    private final int pictureWidth;
    private final int pictureHeight;

    // Ширина и высота парковочного места
    private final int placeSizeWidth = 460;
    private final int placeSizeHeight = 105;

    public Base(int pictureWidth, int pictureHeight) {
        int columnsNumber = pictureWidth / placeSizeWidth;
        int rowsNumber = pictureHeight / placeSizeHeight;
        maxCount = columnsNumber * rowsNumber;
        places = new ArrayList<>();
        this.pictureWidth = pictureWidth;
        this.pictureHeight = pictureHeight;
    }

    // Перегрузка оператора сложения
    public int add(T transport) throws BaseOverflowException {
        if (places.size() >= maxCount) {
            throw new BaseOverflowException();
        }
        places.add(transport);
        return 1;
    }

    // Перегрузка оператора вычитания
    public T remove(int index) throws BasePlaceNotFoundException {
        if (index < 0 || index >= places.size()) {
            throw new BasePlaceNotFoundException(index);
        }
        T militaryEquipment = places.get(index);
        places.remove(index);
        return militaryEquipment;
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
        int columnNumber = pictureWidth / placeSizeWidth;
        for (int i = 0; i < places.size(); i++) {
            places.get(i).setPosition(10 + placeSizeWidth * (i % columnNumber), 10 + placeSizeHeight * (i / columnNumber), pictureWidth, pictureHeight);
            places.get(i).drawTransport(g);
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

    // Индексатор для получения элементов из списка
    public T get(int index) {
        if (index >= 0 && index < places.size()) {
            return places.get(index);
        }
        return null;
    }

    public void clear() {
        places.clear();
    }
}