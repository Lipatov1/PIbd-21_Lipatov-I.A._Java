import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.*;
import javax.swing.border.Border;
import java.util.LinkedList;
import java.util.Objects;

public class FrameBase extends JFrame {
    private final LinkedList<Vehicle> militaryEquipmentLinkedList;
    private final DefaultListModel<String> baseList;
    private final JTextField textFieldNewLevelName;
    private final JTextField textFieldPlaceNumber;
    private final BaseCollection baseCollection;
    private final JList<String> listBoxBases;
    private final PanelBase panelBase;

    public FrameBase() {
        setTitle("База");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1080, 500);
        setLocation(400, 300);
        setResizable(false);
        setVisible(true);
        setLayout(null);

        baseCollection = new BaseCollection(920, 450);
        militaryEquipmentLinkedList = new LinkedList<>();

        panelBase = new PanelBase(baseCollection);
        panelBase.setBounds(0, 0, 920, 450);
        add(panelBase);

        // Создание JMenuItem "Сохранить" и добавление ему действия
        JMenuItem fileItemSave = new JMenuItem("Сохранить");
        fileItemSave.addActionListener(e -> save());

        // Создание JMenuItem "Загрузить" и добавление ему действия
        JMenuItem fileItemLoad = new JMenuItem("Загрузить");
        fileItemLoad.addActionListener(e -> load());

        // Создание JMenuItem "Сохранить базу" и добавление ему действия
        JMenuItem baseItemSave = new JMenuItem("Сохранить базу");
        baseItemSave.addActionListener(e -> saveBase());

        // Создание JMenuItem "Загрузить базу" и добавление ему действия
        JMenuItem baseItemLoad = new JMenuItem("Загрузить базу");
        baseItemLoad.addActionListener(e -> loadBase());

        // Создание JMenu "Файл" и добавление в него JMenuItem
        JMenu menuFile = new JMenu("Файл");
        menuFile.add(fileItemSave);
        menuFile.add(fileItemLoad);

        // Создание JMenu "База" и добавление в него JMenuItem
        JMenu menuBase = new JMenu("База");
        menuBase.add(baseItemSave);
        menuBase.add(baseItemLoad);

        // Создание JMenuBar, добавление на него JMenu и добавление его на форму
        JMenuBar menu = new JMenuBar();
        menu.add(menuFile);
        menu.add(menuBase);
        setJMenuBar(menu);

        // Создание, размещение и добавление текста "Базы:"
        JLabel labelBases = new JLabel("Базы:");
        labelBases.setBounds(962, 9, 35, 15);
        add(labelBases);

        // Создание, размещение и добавление текстового поля для названия базы
        textFieldNewLevelName = new JTextField();
        textFieldNewLevelName.setBounds(910, 27, 140, 23);
        add(textFieldNewLevelName);

        // Создание, размещение, назначения действия и добавление кнопки "Добавить базу"
        JButton buttonAddBase = new JButton("Добавить базу");
        buttonAddBase.setBounds(910, 54, 140, 23);
        buttonAddBase.addActionListener(e -> addBase());
        add(buttonAddBase);

        // Создание, размещение, назначения действия и добавление JList
        baseList = new DefaultListModel<>();
        listBoxBases = new JList<>(baseList);
        listBoxBases.setBounds(910, 82, 140, 94);
        listBoxBases.addListSelectionListener(e -> listListener());
        add(listBoxBases);

        // Создание, размещение, назначения действия и добавление кнопки "Удалить базу"
        JButton buttonRemoveBase = new JButton("Удалить базу");
        buttonRemoveBase.setBounds(910, 181, 140, 23);
        buttonRemoveBase.addActionListener(e -> delBase());
        add(buttonRemoveBase);

        // Создание, размещение, назначения действия и добавление кнопки "Добавить военную технику"
        JButton buttonSetMilitaryEquipment = new JButton("<html><center>Добавить военную технику</center></html>");
        buttonSetMilitaryEquipment.setBounds(910, 209, 140, 47);
        buttonSetMilitaryEquipment.addActionListener(e -> setMilitaryEquipment());
        add(buttonSetMilitaryEquipment);

        // Создание JPanel, добавление границы с заголовком и размещение
        JPanel groupBoxTakeTechnic = new JPanel();
        groupBoxTakeTechnic.setLayout(null);
        Border centerBorder = BorderFactory.createTitledBorder("Забрать технику:");
        groupBoxTakeTechnic.setBorder(centerBorder);
        groupBoxTakeTechnic.setBounds(908, 260, 144, 105);

        // Создание, размещение и добавление "Место:"
        JLabel labelPlace = new JLabel("Место:");
        labelPlace.setBounds(32, 16, 50, 30);
        groupBoxTakeTechnic.add(labelPlace);

        // Создание, размещение и добавление текстового поля для номера места
        textFieldPlaceNumber = new JFormattedTextField();
        textFieldPlaceNumber.setBounds(75, 23, 45, 20);
        groupBoxTakeTechnic.add(textFieldPlaceNumber);

        // Создание, размещение, назначения действия и добавление кнопки "Добавить в List"
        JButton buttonAddToList = new JButton("Добавить в List");
        buttonAddToList.setBounds(7, 46, 130, 23);
        buttonAddToList.addActionListener(e -> AddToList());
        groupBoxTakeTechnic.add(buttonAddToList);

        // Создание, размещение, назначения действия и добавление кнопки "Получить из List"
        JButton buttonGetFromList = new JButton("Получить из List");
        buttonGetFromList.setBounds(7, 74, 130, 23);
        buttonGetFromList.addActionListener(e -> GetFromList());
        groupBoxTakeTechnic.add(buttonGetFromList);

        add(groupBoxTakeTechnic);

        repaint();
    }

    private void setMilitaryEquipment() {
        if (listBoxBases.getSelectedIndex() >= 0) {
            PanelMilitaryEquipmentConfig panelMilitaryEquipmentConfig = new PanelMilitaryEquipmentConfig(this);

            // Получаем технику из panelMilitaryEquipmentConfig
            Vehicle militaryEquipment = panelMilitaryEquipmentConfig.getMilitaryEquipment();

            if (militaryEquipment == null)
                return;
            if (baseCollection.get(listBoxBases.getSelectedValue()).add(militaryEquipment) != -1) {
                repaint();
            } else {
                JOptionPane.showMessageDialog(this, "База переполнена");
            }
        } else {
            JOptionPane.showMessageDialog(this, "База не выбрана", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void AddToList() {
        if (listBoxBases.getSelectedIndex() >= 0) {
            if (!textFieldPlaceNumber.getText().equals("")) {
                try {
                    var militaryEquipment = baseCollection.get(listBoxBases.getSelectedValue()).remove(Integer.parseInt(textFieldPlaceNumber.getText()));
                    if (militaryEquipment != null) {
                        militaryEquipmentLinkedList.add(militaryEquipment);
                        repaint();
                    } else {
                        JOptionPane.showMessageDialog(this, "Техника с таким индексом отсутствует", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Техника с таким индексом отсутствует", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "База не выбрана", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void GetFromList() {
        if (!militaryEquipmentLinkedList.isEmpty()) {
            FrameMilitaryEquipment frameMilitaryEquipment = new FrameMilitaryEquipment();
            frameMilitaryEquipment.setTransport(Objects.requireNonNull(militaryEquipmentLinkedList.poll()));
            repaint();
        }
    }

    private void reloadLevels() {
        int index = listBoxBases.getSelectedIndex();
        baseList.removeAllElements();

        for (int i = 0; i < baseCollection.keys().size(); i++){
            baseList.addElement(baseCollection.keys().get(i));
        }

        if (baseList.size() > 0 && (index < 0 || index >= baseList.size())) {
            listBoxBases.setSelectedIndex(0);
        } else if (baseList.size() > 0 && index >= 0 && index < baseList.size()) {
            listBoxBases.setSelectedIndex(index);
        }
    }

    private void addBase() {
        if (!textFieldNewLevelName.getText().equals("")) {
            baseCollection.addBase(textFieldNewLevelName.getText());
            reloadLevels();
            repaint();
        } else {
            JOptionPane.showMessageDialog(this, "Введите название базы", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void delBase() {
        if (listBoxBases.getSelectedIndex() >= 0) {
            int result = JOptionPane.showConfirmDialog(this, "Удалить базу " + listBoxBases.getSelectedValue() + "?", "Удаление", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                baseCollection.delBase(listBoxBases.getSelectedValue());
                reloadLevels();
                repaint();
            }
        } else {
            JOptionPane.showMessageDialog(this, "База не выбрана", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listListener() {
        panelBase.setSelectedItem(listBoxBases.getSelectedValue());
        repaint();
    }

    private void save() {
        JFileChooser fileDialog = new JFileChooser();
        fileDialog.setFileFilter(new FileNameExtensionFilter("Текстовый файл", "txt"));
        int result = fileDialog.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            if (baseCollection.saveData(fileDialog.getSelectedFile())) {
                JOptionPane.showMessageDialog(this, "Сохранение прошло успешно");
            }
            else {
                JOptionPane.showMessageDialog(this, "Не удалось сохранить");
            }
        }
    }

    private void load() {
        JFileChooser fileDialog = new JFileChooser();
        fileDialog.setFileFilter(new FileNameExtensionFilter("Текстовый файл", "txt"));
        int result = fileDialog.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            if (baseCollection.loadData(fileDialog.getSelectedFile().getPath())) {
                JOptionPane.showMessageDialog(this, "Загрузка прошла успешно");
                reloadLevels();
                repaint();
            }
            else {
                JOptionPane.showMessageDialog(this,"Не удалось загрузить файл");
            }
        }
    }

    private void saveBase() {
        JFileChooser fileDialog = new JFileChooser();
        fileDialog.setFileFilter(new FileNameExtensionFilter("Текстовый файл", "txt"));
        if (listBoxBases.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "Перед сохранением необходимо выбрать базу");
            return;
        }
        int result = fileDialog.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            if (baseCollection.saveBase(fileDialog.getSelectedFile(), listBoxBases.getSelectedValue())) {
                JOptionPane.showMessageDialog(this, "Сохранение прошло успешно", "Результат", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Не удалось сохранить", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void loadBase() {
        JFileChooser fileDialog = new JFileChooser();
        fileDialog.setFileFilter(new FileNameExtensionFilter("Текстовый файл", "txt"));
        int result = fileDialog.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            if (baseCollection.loadBase(fileDialog.getSelectedFile().getPath())) {
                JOptionPane.showMessageDialog(this, "Загрузка прошла успешно", "Результат", JOptionPane.INFORMATION_MESSAGE);
                reloadLevels();
                repaint();
            } else {
                JOptionPane.showMessageDialog(this, "Не удалось загрузить файл", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}