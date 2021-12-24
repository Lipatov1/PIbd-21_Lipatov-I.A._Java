import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class ArmoredCar extends Vehicle implements Iterator<Object>, Iterable<Object>, Comparable<ArmoredCar>  {
    // Ширина и высота отрисовки бронированной машины
    protected int armoredCarWidth = 210;
    protected int armoredCarHeight = 85;

    // Разделитель для записи информации по объекту в файл
    protected String separator = ";";

    protected LinkedList<Object> listConfig = new LinkedList<>();
    protected int currentIndex = -1;

    // Конструктор
    public ArmoredCar(int maxSpeed, float weight, Color mainColor) {
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.mainColor = mainColor;
        listConfig.add(maxSpeed);
        listConfig.add(weight);
        listConfig.add(mainColor);
    }

    // Конструктор с изменением размеров бронированной машины
    protected ArmoredCar(int maxSpeed, float weight, Color mainColor, int armoredCarHeight, int armoredCarWidth) {
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.mainColor = mainColor;
        this.armoredCarHeight = armoredCarHeight;
        this.armoredCarWidth = armoredCarWidth;
    }

    // Конструктор для загрузки с файла
    public ArmoredCar(String info) {
        String[] args = info.split(separator);
        if (args.length == 3) {
            maxSpeed = Integer.parseInt(args[0]);
            weight = Float.parseFloat(args[1]);
            mainColor = new Color(Integer.parseInt(args[2]));
            listConfig.add(maxSpeed);
            listConfig.add(weight);
            listConfig.add(mainColor);
        }
    }

    // Изменение направления перемещения
    @Override
    public void moveTransport(Direction direction) {
        float step = maxSpeed * 100 / weight;
        switch (direction) {
            case Right:
                if (startPosX + step < pictureWidth - armoredCarWidth) {
                    startPosX += step;
                }
                break;

            case Left:
                if (startPosX - step > 0) {
                    startPosX -= step;
                }
                break;

            case Up:
                if (startPosY - step > 0) {
                    startPosY -= step;
                }
                break;

            case Down:
                if (startPosY + step < pictureHeight - armoredCarHeight) {
                    startPosY += step;
                }
                break;
        }
    }

    // Отрисовка бронированной машины
    @Override
    public void drawTransport(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        // Отрисовываем колеса
        g2.setColor(Color.decode("#35391f"));
        g2.fillOval(startPosX, startPosY + 40, 45, 45);
        g2.fillOval(startPosX + 165, startPosY + 40, 45, 45);
        g2.fillRect(startPosX + 25, startPosY + 40, 160, 25);
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2));
        g2.drawOval(startPosX + 5, startPosY + 45, 35, 35);
        g2.drawOval(startPosX + 170, startPosY + 45, 35, 35);

        // Отрисовываем крышу
        g2.setColor(mainColor);
        g.fillRect(startPosX + 7, startPosY + 30, 198, 20);
        g.fillRect(startPosX + 60, startPosY, 90, 30);
    }

    public String toString() {
        return maxSpeed + separator + weight + separator + mainColor.getRGB();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ArmoredCar militaryEquipmentObject)) {
            return false;
        }
        return equals(militaryEquipmentObject);
    }

    public boolean equals(ArmoredCar other) {
        if (other == null) {
            return false;
        }
        if (!this.getClass().getSimpleName().equals(other.getClass().getSimpleName())) {
            return false;
        }
        if (maxSpeed != other.maxSpeed) {
            return false;
        }
        if (weight != other.weight) {
            return false;
        }
        if (mainColor.getRGB() != other.mainColor.getRGB()) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(ArmoredCar armoredCar) {
        if (maxSpeed != armoredCar.maxSpeed) {
            return Integer.compare(maxSpeed, armoredCar.maxSpeed);
        }
        if (weight != armoredCar.weight) {
            return Float.compare(weight, armoredCar.weight);
        }
        if (mainColor.getRGB() != armoredCar.mainColor.getRGB()) {
            return Integer.compare(mainColor.getRGB(), armoredCar.getMainColor().getRGB());
        }
        return 0;
    }

    @Override
    public Iterator<Object> iterator() {
        currentIndex = -1;
        return listConfig.iterator();
    }

    @Override
    public boolean hasNext() {
        return (currentIndex + 1 < listConfig.size());
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        currentIndex++;
        return listConfig.get(currentIndex);
    }
}