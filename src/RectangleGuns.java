import java.awt.*;

public class RectangleGuns implements AdditionalElems {
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
        if (numberGuns != null) {
            g.fillRect(startPosX + 145, startPosY + 5, 50, 7);
            if (numberGuns != NumberGuns.one) {
                g.fillRect(startPosX + 20, startPosY + 8, 45, 8);
                if (numberGuns != NumberGuns.two) {
                    g.fillRect(startPosX + 145, startPosY + 18, 65, 7);
                }
            }
        }
    }
}