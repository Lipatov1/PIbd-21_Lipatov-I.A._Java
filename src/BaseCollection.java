import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.security.KeyException;
import java.util.Scanner;

public class BaseCollection {
    private final Map<String, Base<Vehicle, AdditionalElems>> baseStages;

    // Возвращение списка названий баз
    public ArrayList<String> keys(){
        return new ArrayList<>(baseStages.keySet());
    }

    // Ширина и высота окна отрисовки
    private final int pictureWidth;
    private final int pictureHeight;

    // Разделитель для записи информации в файл
    private final String separator = ":";

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

    // Сохранение информации по технике на базах в файл
    public void saveData(File saveFile) throws IOException {
        if (saveFile.exists()) {
            saveFile.delete();
        }

        try (FileWriter fileWriter = new FileWriter(saveFile)) {
            fileWriter.write("BaseCollection\n");

            for (Map.Entry<String, Base<Vehicle, AdditionalElems>> level : baseStages.entrySet()) {
                fileWriter.write("Base" + separator + level.getKey() + '\n');

                Vehicle militaryEquipment;
                for (int i = 0; (militaryEquipment = level.getValue().get(i)) != null; i++) {
                    if (militaryEquipment.getClass().getSimpleName().equals("ArmoredCar")) {
                        fileWriter.write("ArmoredCar" + separator);
                    } else if (militaryEquipment.getClass().getSimpleName().equals("SelfPropArtilleryInstal")) {
                        fileWriter.write("SelfPropArtilleryInstal" + separator);
                    }
                    fileWriter.write(militaryEquipment.toString() + '\n');
                }
            }
        }
    }

    // Загрузка информации по техникам на базах из файла
    public void loadData(String filename) throws IllegalArgumentException, IOException, BaseOverflowException {
        if (!(new File(filename).exists())) {
            throw new FileNotFoundException("Файл не найден");
        }

        try (FileReader fileReader = new FileReader(filename)) {
            Scanner scanner = new Scanner(fileReader);
            if (scanner.nextLine().contains("BaseCollection")) {
                baseStages.clear();
            } else {
                throw new IllegalArgumentException("Неверный формат файла");
            }

            Vehicle militaryEquipment = null;
            String key = "";
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("Base")) {
                    key = line.split(separator)[1];
                    baseStages.put(key, new Base<>(pictureWidth, pictureHeight));
                } else if (line.contains(separator)) {
                    if (line.contains("SelfPropArtilleryInstal")) {
                        militaryEquipment = new SelfPropArtilleryInstal(line.split(separator)[1]);
                    } else if (line.contains("ArmoredCar")) {
                        militaryEquipment = new ArmoredCar(line.split(separator)[1]);
                    }
                    if (!(baseStages.get(key).add(militaryEquipment) == 1)) {
                        throw new BaseOverflowException();
                    }
                }
            }
        }
    }

    // Сохранение информации по технике на базе в файл
    public void saveBase(File saveFile, String key) throws IOException, KeyException {
        if (baseStages.containsKey(key)) {
            if (saveFile.exists()) {
                saveFile.delete();
            }

            try (FileWriter fileWriter = new FileWriter(saveFile)) {
                fileWriter.write("Base" + separator + key + '\n');

                Vehicle militaryEquipment;
                for (int i = 0; (militaryEquipment = baseStages.get(key).get(i)) != null; i++) {
                    if (militaryEquipment.getClass().getSimpleName().equals("ArmoredCar")) {
                        fileWriter.write("ArmoredCar" + separator);
                    } else if (militaryEquipment.getClass().getSimpleName().equals("SelfPropArtilleryInstal")) {
                        fileWriter.write("SelfPropArtilleryInstal" + separator);
                    }
                    fileWriter.write(militaryEquipment.toString() + '\n');
                }
            }
        } else throw new KeyException();
    }

    // Загрузка информации по техникам на базе из файла
    public void loadBase(String filename) throws BaseOverflowException, IllegalArgumentException, IOException {
        try (FileReader fileReader = new FileReader(filename)) {
            Scanner scanner = new Scanner(fileReader);
            String line = scanner.nextLine();
            String key;

            if (line.contains("Base:")) {
                key = line.split(separator)[1];
                if (baseStages.containsKey(key)) {
                    baseStages.get(key).clear();
                } else {
                    baseStages.put(key, new Base<>(pictureWidth, pictureHeight));
                }
            } else {
                throw new IllegalArgumentException("Неверный формат файла");
            }

            Vehicle militaryEquipment = null;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (line.contains(separator)) {
                    if (line.contains("SelfPropArtilleryInstal")) {
                        militaryEquipment = new SelfPropArtilleryInstal(line.split(separator)[1]);
                    } else if (line.contains("ArmoredCar")) {
                        militaryEquipment = new ArmoredCar(line.split(separator)[1]);
                    }
                    if (!(baseStages.get(key).add(militaryEquipment) == 1)) {
                        throw new BaseOverflowException();
                    }
                }
            }
        }
    }
}