import java.awt.*;

public class Guns {
    // Закрытое поле от ДопПеречисл
    private NumberGuns numberGuns;

    // Открытое числовое свойство, через которое можно в поле-перечисление занести значение
    public void setNumberGuns(int number) {
        numberGuns = NumberGuns.getNumber(number);
    }

    public void drawGuns(Graphics g, Color color, int startPosX, int startPosY) {
        g.setColor(color);
        if (numberGuns != null) {
            g.fillRoundRect(startPosX + 145, startPosY + 5, 50, 7, 7, 12);
            if (numberGuns != NumberGuns.one) {
                g.fillRoundRect(startPosX + 145, startPosY + 18, 65, 7, 7, 12);
                if (numberGuns != NumberGuns.two) {
                    g.fillRoundRect(startPosX + 20, startPosY + 8, 45, 8, 7, 12);
                }
            }
        }
    }
}