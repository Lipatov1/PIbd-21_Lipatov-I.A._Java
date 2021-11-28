import java.awt.*;

public interface ITransport {
    // Установка позиции военной техники
    void setPosition(int x, int y, int width, int height);

    // Изменение направления перемещения
    void moveTransport(Direction direction);

    // Отрисовка военной техники
    void drawTransport(Graphics g);

    // Смена основного цвета
    void setMainColor(Color color);
}