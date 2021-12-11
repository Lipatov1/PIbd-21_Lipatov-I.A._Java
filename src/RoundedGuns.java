import java.awt.*;

public class RoundedGuns implements AdditionalElems {
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
        g.fillRoundRect(startPosX + 145, startPosY + 5, 50, 7, 20, 20);
        if (numberGuns != NumberGuns.one) {
            g.fillRoundRect(startPosX + 20, startPosY + 8, 45, 8, 20, 20);
            if (numberGuns != NumberGuns.two) {
                g.fillRoundRect(startPosX + 145, startPosY + 18, 65, 7, 20, 20);
            }
        }
    }

    public String toString() {
        return this.getClass().getSimpleName() + '.' + numberGuns.ordinal();
    }
}