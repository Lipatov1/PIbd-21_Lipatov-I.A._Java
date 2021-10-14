import java.awt.*;

public class ArmoredCar extends MilitaryEquipment {
    // Ширина и высота отрисовки бронированной машины
    protected int armoredCarWidth = 210;
    protected int armoredCarHeight = 85;

    // Конструктор
    public ArmoredCar(int maxSpeed, float weight, Color mainColor) {
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.mainColor = mainColor;
    }

    // Конструктор с изменением размеров бронированной машины
    protected ArmoredCar(int maxSpeed, float weight, Color mainColor, int armoredCarHeight, int armoredCarWidth) {
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.mainColor = mainColor;
        this.armoredCarHeight = armoredCarHeight;
        this.armoredCarWidth = armoredCarWidth;
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
}