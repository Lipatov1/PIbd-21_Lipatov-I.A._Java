import java.awt.*;
import java.util.Iterator;
import java.util.Random;

public class SelfPropArtilleryInstal extends ArmoredCar implements Iterator<Object>, Iterable<Object>, Comparable<ArmoredCar> {
    // Закрытое поле от ИнтерДоп
    private AdditionalElems additionalElems;

    // Дополнительный цвет cамоходной артиллерийской установки
    public Color dopColor;
    public  void setDopColor(Color dopColor) {
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

    public void setAdditionalElems(AdditionalElems additionalElems) {
        this.additionalElems = additionalElems;
    }

    // Конструктор
    public SelfPropArtilleryInstal(int maxSpeed, float weight, Color mainColor, Color dopColor, boolean camouflage, boolean star, boolean caterpillar) {
        super(maxSpeed, weight, mainColor);
        this.dopColor = dopColor;
        this.camouflage = camouflage;
        this.star = star;
        this.caterpillar = caterpillar;
        listConfig.add(dopColor);
        listConfig.add(isCamouflage());
        listConfig.add(isStar());
        listConfig.add(isCaterpillar());
    }

    public SelfPropArtilleryInstal(String info) {
        super(info);
        String[] args = info.split(separator);
        if (args.length == 8) {
            maxSpeed = Integer.parseInt(args[0]);
            weight = Float.parseFloat(args[1]);
            mainColor = new Color(Integer.parseInt(args[2]));
            dopColor = new Color(Integer.parseInt(args[3]));
            camouflage = Boolean.parseBoolean(args[4]);
            star = Boolean.parseBoolean(args[5]);
            caterpillar = Boolean.parseBoolean(args[6]);
            if (args[7].contains("null")) {
                additionalElems = null;
            } else {
                switch (args[7].split("\\.")[0]) {
                    case "RectangleGuns":
                        additionalElems = new RectangleGuns();
                        break;
                    case "RoundedGuns":
                        additionalElems = new RoundedGuns();
                        break;
                    case "TriangularGuns":
                        additionalElems = new TriangularGuns();
                        break;
                }
                additionalElems.setNumber(Integer.parseInt(args[7].split("\\.")[1]));
            }
            listConfig.add(maxSpeed);
            listConfig.add(weight);
            listConfig.add(mainColor);
            listConfig.add(dopColor);
            listConfig.add(isCamouflage());
            listConfig.add(isStar());
            listConfig.add(isCaterpillar());
            listConfig.add(additionalElems);
            listConfig.add(args[7].split("\\.")[0]);
            listConfig.add(args[7].split("\\.")[1]);
        }
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
        if (additionalElems != null) {
            additionalElems.draw(g, mainColor, startPosX, startPosY);
        }
    }

    public String toString() {
        return maxSpeed + separator + weight + separator + mainColor.getRGB() + separator +
                dopColor.getRGB() + separator + camouflage + separator + star + separator +
                caterpillar + separator + additionalElems;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof SelfPropArtilleryInstal selfPropArtilleryInstalObject)) {
            return false;
        }
        return equals(selfPropArtilleryInstalObject);
    }

    public boolean equals(SelfPropArtilleryInstal other) {
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
        if (dopColor.getRGB() != other.dopColor.getRGB()) {
            return false;
        }
        if (camouflage != other.camouflage) {
            return false;
        }
        if (star != other.star) {
            return false;
        }
        if (caterpillar != other.caterpillar) {
            return false;
        }
        if (additionalElems != null && other.additionalElems != null && !(additionalElems.toString().equals(other.additionalElems.toString()))) {
            return false;
        }
        if ((additionalElems == null && other.additionalElems != null) || (additionalElems != null && other.additionalElems == null)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(ArmoredCar armoredCar) {
        SelfPropArtilleryInstal selfPropArtilleryInstal = (SelfPropArtilleryInstal) armoredCar;

        if (dopColor.getRGB() != selfPropArtilleryInstal.dopColor.getRGB()) {
            return Integer.compare(dopColor.getRGB(), selfPropArtilleryInstal.dopColor.getRGB());
        }
        if (camouflage != selfPropArtilleryInstal.camouflage) {
            return Boolean.compare(camouflage, selfPropArtilleryInstal.camouflage);
        }
        if (star != selfPropArtilleryInstal.star) {
            return Boolean.compare(star, selfPropArtilleryInstal.star);
        }
        if (caterpillar != selfPropArtilleryInstal.caterpillar) {
            return Boolean.compare(caterpillar, selfPropArtilleryInstal.caterpillar);
        }
        if (additionalElems == null && selfPropArtilleryInstal.additionalElems != null) {
            return 1;
        }
        if (additionalElems != null && selfPropArtilleryInstal.additionalElems == null) {
            return -1;
        }
        return 0;
    }

    public AdditionalElems getAdditionalElems() {
        return  additionalElems;
    }
}