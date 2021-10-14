import java.awt.*;
import java.util.Random;

public class SelfPropArtilleryInstal {
    // Поле от классаДоп.
    private Guns guns;

    // Левая и правая координаты отрисовки cамоходной артиллерийской установки
    private int startPosX;
    private int startPosY;

    // Ширина и высота окна отрисовки
    private int pictureWidth;
    private int pictureHeight;

    // Ширина и высота отрисовки cамоходной артиллерийской установки
    private final int selfPropArtilleryInstalWidth = 210;
    private final int selfPropArtilleryInstalHeight = 85;

    // Максимальная скорость cамоходной артиллерийской установки
    public int maxSpeed;
    private void setMaxSpeed(int maxSpeed) { this.maxSpeed = maxSpeed; }
    public int getMaxSpeed() { return maxSpeed; }

    // Максимальный вес cамоходной артиллерийской установки
    public float weight;
    private void setWeight(float weight) {
        this.weight = weight;
    }
    public float getWeight() {
        return weight;
    }

    // Основной цвет cамоходной артиллерийской установки
    public Color mainColor;
    private void setMainColor(Color mainColor) {
        this.mainColor = mainColor;
    }
    public Color getMainColor() {
        return mainColor;
    }

    // Дополнительный цвет cамоходной артиллерийской установки
    public Color dopColor;
    private void setDopColor(Color dopColor) {
        this.dopColor = dopColor;
    }
    public Color getDopColor() {
        return dopColor;
    }

    // Признак наличия камуфляжа
    public boolean camouflage;
    private void setCamouflage(boolean camouflage) {
        this.camouflage = camouflage;
    }
    public boolean isCamouflage() {
        return camouflage;
    }

    // Признак наличия звезды
    public boolean star;
    private void setStar(boolean star) {
        this.star = star;
    }
    public boolean isStar() {
        return star;
    }

    // Конструктор
    public SelfPropArtilleryInstal(int maxSpeed, float weight, Color mainColor, Color dopColor, boolean camouflage, boolean star) {
        this.maxSpeed = maxSpeed;
        this.weight = weight;
        this.mainColor = mainColor;
        this.dopColor = dopColor;
        this.camouflage = camouflage;
        this.star = star;
        guns = new Guns();
        Random rnd = new Random();
        guns.setNumberGuns(rnd.nextInt(4));
    }

    // Установка позиции cамоходной артиллерийской установки
    public void setPosition(int x, int y, int width, int height) {
        startPosX = x;
        startPosY = y;
        pictureHeight = height;
        pictureWidth = width;
    }

    // Изменение направления перемещения
    public void moveTransport(Direction direction) {
        float step = maxSpeed * 100 / weight;
        switch (direction) {
            case Right:
                if (startPosX + step < pictureWidth - selfPropArtilleryInstalWidth) {
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
                if (startPosY + step < pictureHeight - selfPropArtilleryInstalHeight)	{
                    startPosY += step;
                }
                break;
        }
    }

    // Отрисовка cамоходной артиллерийской установки
    public void drawTransport(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        // Отрисовываем гусеницу
        g2.setColor(Color.decode("#35391f"));
        g2.fillRoundRect(startPosX, startPosY + 40, 210, 45, 40, 50);

        // Отрисовывем колеса гусеницы
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2));
        g2.drawOval(startPosX + 5, startPosY + 45, 35, 35);
        g2.drawOval(startPosX + 170, startPosY + 45, 35, 35);
        g2.drawOval(startPosX + 50, startPosY + 62, 20, 20);
        g2.drawOval(startPosX + 80, startPosY + 62, 20, 20);
        g2.drawOval(startPosX + 110, startPosY + 62, 20, 20);
        g2.drawOval(startPosX + 140, startPosY + 62, 20, 20);
        g2.fillOval(startPosX + 70, startPosY + 45, 10, 10);
        g2.fillOval(startPosX + 100, startPosY + 45, 10, 10);
        g2.fillOval(startPosX + 130, startPosY + 45, 10, 10);

        // Отрисовываем башню
        g2.setColor(mainColor);
        g.fillRect(startPosX + 7, startPosY + 30, 198, 20);
        g.fillRect(startPosX + 60, startPosY, 90, 30);

        // Отрисовываем камуфляж
        g2.setColor(Color.decode("#595677"));
        if (camouflage) {
            g.fillOval(startPosX + 12, startPosY + 34, 25, 12);
            g.fillOval(startPosX + 70, startPosY + 32, 12, 12);
            g.fillOval(startPosX + 70, startPosY + 8, 10, 10);
            g.fillOval(startPosX + 70, startPosY + 3, 15, 10);
            g.fillOval(startPosX + 130, startPosY + 3, 15, 15);
            g.fillOval(startPosX + 130, startPosY + 33, 20, 13);
            g.fillOval(startPosX + 180, startPosY + 33, 13, 13);
        }

        // Отрисовываем звезду
        g2.setColor(dopColor);
        if (star) {
            g2.fillPolygon(
                    new int[]{startPosX + 105, startPosX + 111, startPosX + 124, startPosX + 113, startPosX + 117, startPosX + 105, startPosX + 93, startPosX + 97, startPosX + 86, startPosX + 99},
                    new int[]{startPosY + 2, startPosY + 17, startPosY + 17, startPosY + 24, startPosY + 38, startPosY + 30, startPosY + 38, startPosY + 24, startPosY + 17, startPosY + 17}, 10);
        }

        // Метод отрисовки классаДоп
        guns.drawGuns(g2, mainColor, startPosX, startPosY);
    }
}