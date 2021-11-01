import java.awt.*;

public class TriangularGuns implements AdditionalElems {
    // Закрытое поле от перечисления NumberGuns
    private NumberGuns numberGuns;

    // Открытое числовое свойство, через которое можно в закрытое поле занести значение
    @Override
    public void setNumber(int number) {
        numberGuns = NumberGuns.getNumber(number);
    }

    @Override
    public void draw(Graphics g, Color color, int startPosX, int startPosY) {
        g.setColor(color);
        g.fillPolygon(
                new int[]{startPosX + 145, startPosX + 195, startPosX + 195, startPosX + 145},
                new int[]{startPosY + 5, startPosY + 7, startPosY + 9, startPosY + 12}, 4);
        if (numberGuns != NumberGuns.one) {
            g.fillPolygon(
                    new int[]{startPosX + 65, startPosX + 20, startPosX + 20, startPosX + 65},
                    new int[]{startPosY + 8, startPosY + 11, startPosY + 13, startPosY + 16}, 4);
            if (numberGuns != NumberGuns.two) {
                g.fillPolygon(
                        new int[]{startPosX + 145, startPosX + 210, startPosX + 210, startPosX + 145},
                        new int[]{startPosY + 18, startPosY + 20, startPosY + 22, startPosY + 25}, 4);
            }
        }
    }
}