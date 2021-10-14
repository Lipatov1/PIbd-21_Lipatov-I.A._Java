import java.awt.*;

public abstract class MilitaryEquipment implements ITransport {
    // Левая и правая координаты отрисовки военной техники
    protected int startPosX;
    protected int startPosY;

    // Ширина и высота окна отрисовки
    protected int pictureWidth;
    protected int pictureHeight;

    // Максимальная скорость военной техники
    protected int maxSpeed;
    public int getMaxSpeed() {
        return maxSpeed;
    }
    protected void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    // Вес военной техники
    protected float weight;
    public float getWeight() {
        return  weight;
    }
    protected void setWeight(float weight) {
        this.weight = weight;
    }

    // Основной цвет военной техники
    protected Color mainColor;
    public Color getMainColor() {
        return mainColor;
    }
    protected void setMainColor(Color mainColor) {
        this.mainColor = mainColor;
    }

    // Установка позиции военной техники
    @Override
    public void setPosition(int x, int y, int width, int height) {
        pictureWidth = width;
        pictureHeight = height;
        startPosX = x;
        startPosY = y;
    }

    // Отрисовка военной техники
    @Override
    public abstract void drawTransport(Graphics g);

    // Изменение направления перемещения
    @Override
    public abstract void moveTransport(Direction direction);
}