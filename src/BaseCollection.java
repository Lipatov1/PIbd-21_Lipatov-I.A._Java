import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BaseCollection {
    private final Map<String, Base<Vehicle, AdditionalElems>> baseStages;

    // Возвращение списка названий баз
    public ArrayList<String> keys(){
        return new ArrayList<>(baseStages.keySet());
    }

    // Ширина и высота окна отрисовки
    private final int pictureWidth;
    private final int pictureHeight;

    // Конструктор
    public BaseCollection(int pictureWidth, int pictureHeight) {
        baseStages = new HashMap<>();
        this.pictureWidth = pictureWidth;
        this.pictureHeight = pictureHeight;
    }

    // Добавление базы
    public void addBase(String name) {
        if (!baseStages.containsKey(name)) {
            baseStages.put(name, new Base<>(pictureWidth, pictureHeight));
        }
    }

    // Удаление базы
    public void delBase(String name) {
        if (baseStages.containsKey(name)){
            baseStages.remove(name);
        }
    }

    // Доступ к базе
    public Base<Vehicle, AdditionalElems> get(String name) {
        if (baseStages.containsKey(name)) {
            return baseStages.get(name);
        }
        return null;
    }

    // Метод как замена индексатора с двумя параметрами, первый выбирает элемент из словаря, второй из списка параметризованного класса
    public Vehicle get(String name, int index) {
        if (baseStages.containsKey(name)) {
            return baseStages.get(name).get(index);
        }
        return null;
    }
}