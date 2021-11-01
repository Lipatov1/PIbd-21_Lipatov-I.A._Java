import java.awt.*;
import java.util.Random;

public class SelfPropArtilleryInstal extends ArmoredCar {
    // Закрытое поле от ИнтерДоп
    private AdditionalElems additionalElems;

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

    // Признак наличия гусеницы
    public boolean caterpillar;
    private void setCaterpillar(boolean caterpillar) {
        this.caterpillar = caterpillar;
    }
    public boolean isCaterpillar() {
        return caterpillar;
    }

    // Конструктор
    public SelfPropArtilleryInstal(int maxSpeed, float weight, Color mainColor, Color dopColor, boolean camouflage, boolean star, boolean caterpillar) {
        super(maxSpeed, weight, mainColor);
        this.dopColor = dopColor;
        this.camouflage = camouflage;
        this.star = star;
        this.caterpillar = caterpillar;
        Random rnd = new Random();
        // Инициализация поля от ИнтерДоп
        switch (rnd.nextInt(3)) {
            case 0:
                additionalElems = new RectangleGuns();
                break;
            case 1:
                additionalElems = new TriangularGuns();
                break;
            case 2:
                additionalElems = new RoundedGuns();
        }
        additionalElems.setNumber(rnd.nextInt(3));
    }

    @Override
    // Отрисовка cамоходной артиллерийской установки
    public void drawTransport(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.drawTransport(g2);

        // Отрисовываем гусеницу
        if (caterpillar) {
            g2.setColor(Color.decode("#35391f"));
            g.fillRect(startPosX + 25, startPosY + 50, 160, 35);
            g2.setColor(Color.BLACK);
            g.drawOval(startPosX + 5, startPosY + 45, 35, 35);
            g.drawOval(startPosX + 170, startPosY + 45, 35, 35);
            g.drawOval(startPosX + 50, startPosY + 62, 20, 20);
            g.drawOval(startPosX + 80, startPosY + 62, 20, 20);
            g.drawOval(startPosX + 110, startPosY + 62, 20, 20);
            g.drawOval(startPosX + 140, startPosY + 62, 20, 20);
            g.fillOval(startPosX + 70, startPosY + 45, 10, 10);
            g.fillOval(startPosX + 100, startPosY + 45, 10, 10);
            g.fillOval(startPosX + 130, startPosY + 45, 10, 10);
            g2.setColor(mainColor);
            g.fillRect(startPosX + 7, startPosY + 30, 198, 20);
        }

        // Отрисовываем камуфляж
        if (camouflage) {
            g2.setColor(Color.decode("#595677"));
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

        // Отрисовка дополнительных элементов (форма орудий)
        additionalElems.draw(g, mainColor, startPosX, startPosY);
    }
}