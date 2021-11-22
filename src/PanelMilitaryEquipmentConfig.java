import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelMilitaryEquipmentConfig extends JDialog {
    private Vehicle militaryEquipment;
    private Color busColor;
    private AdditionalElems additionalElems;
    private boolean applyCheck;
    private final PanelMilitaryEquipment panelMilitaryEquipment;

    public PanelMilitaryEquipmentConfig(Frame owner) {
        super(owner, true);
        setSize(760, 355);
        setLayout(null);
        setTitle("Выбор военной техники");
        setLocationRelativeTo(owner);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Создание, добавление границы с заголовком и размещение JPanel для выбора типа военной техники
        JPanel groupBoxMilitaryEquipmentType = new JPanel();
        groupBoxMilitaryEquipmentType.setLayout(null);
        Border borderMilitaryEquipmentType = BorderFactory.createTitledBorder("Тип военной техники:");
        groupBoxMilitaryEquipmentType.setBorder(borderMilitaryEquipmentType);
        groupBoxMilitaryEquipmentType.setBounds(12, 12, 162, 193);
        add(groupBoxMilitaryEquipmentType);

        // Создание, добавление границы, размещение и добавление текста "Бронированный автомобиль"
        JLabel labelArmoredCar = new JLabel("<html><center>Бронированный автомобиль</center></html>");
        labelArmoredCar.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        labelArmoredCar.setBounds(11, 37, 140, 51);
        groupBoxMilitaryEquipmentType.add(labelArmoredCar);

        // Создание, добавление границы, размещение и добавление текста "Самоходная артиллерийская установка"
        JLabel labelSelfPropArtilleryInstal = new JLabel("<html><center>Самоходная артиллерийская установка</center></html>");
        labelSelfPropArtilleryInstal.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        labelSelfPropArtilleryInstal.setBounds(11, 108, 140, 63);
        groupBoxMilitaryEquipmentType.add(labelSelfPropArtilleryInstal);

        // Панель с военной техникой
        panelMilitaryEquipment = new PanelMilitaryEquipment();
        getContentPane().add(panelMilitaryEquipment);
        panelMilitaryEquipment.setBounds(182, 20, 230, 183);
        panelMilitaryEquipment.setBorder(BorderFactory.createLineBorder(Color.black, 1));

        // Создание, добавление границы с заголовком и размещение JPanel для параметров
        JPanel groupBoxMilitaryEquipmentParams = new JPanel();
        groupBoxMilitaryEquipmentParams.setLayout(null);
        Border borderMilitaryEquipmentParams = BorderFactory.createTitledBorder("Параметры:");
        groupBoxMilitaryEquipmentParams.setBorder(borderMilitaryEquipmentParams);
        groupBoxMilitaryEquipmentParams.setBounds(12, 205, 402, 102);
        add(groupBoxMilitaryEquipmentParams);

        // Создание, размещение и добавление текста "Максимальная скорость:"
        JLabel labelMaxSpeed = new JLabel("Максимальная скорость:");
        labelMaxSpeed.setBounds(16, 30, 147, 15);
        groupBoxMilitaryEquipmentParams.add(labelMaxSpeed);

        // Создание, размещение и добавление JSpinner для скорости
        JSpinner spinnerSpeed = new JSpinner(new SpinnerNumberModel(100, 100, 1000, 1));
        spinnerSpeed.setBounds(167, 27, 60, 23);
        groupBoxMilitaryEquipmentParams.add(spinnerSpeed);

        // Создание, размещение и добавление текста "Вес военной техники:"
        JLabel labelWeight = new JLabel("Вес военной техники:");
        labelWeight.setBounds(37, 62, 147, 15);
        groupBoxMilitaryEquipmentParams.add(labelWeight);

        // Создание, размещение и добавление JSpinner для веса
        JSpinner spinnerWeight = new JSpinner(new SpinnerNumberModel(100, 100, 1000, 1));
        spinnerWeight.setBounds(167, 59, 60, 23);
        groupBoxMilitaryEquipmentParams.add(spinnerWeight);

        // Создание, размещение и добавление CheckBox для "Камуфляж"
        JCheckBox checkBoxCamouflage = new JCheckBox("Камуфляж", false);
        checkBoxCamouflage.setBounds(262, 19, 100, 23);
        groupBoxMilitaryEquipmentParams.add(checkBoxCamouflage);

        // Создание, размещение и добавление CheckBox для "Звезда"
        JCheckBox checkBoxStar = new JCheckBox("Звезда", false);
        checkBoxStar.setBounds(262, 42, 100, 23);
        groupBoxMilitaryEquipmentParams.add(checkBoxStar);

        // Создание, размещение и добавление CheckBox для "Гусеница"
        JCheckBox checkBoxСaterpillar = new JCheckBox("Гусеница", false);
        checkBoxСaterpillar.setBounds(262, 65, 100, 23);
        groupBoxMilitaryEquipmentParams.add(checkBoxСaterpillar);

        // Создание, добавление границы с заголовком и размещение JPanel для выбора цвета
        JPanel groupBoxColors = new JPanel();
        groupBoxColors.setLayout(null);
        Border borderColors = BorderFactory.createTitledBorder("Цвета:");
        groupBoxColors.setBorder(borderColors);
        groupBoxColors.setBounds(420, 12, 315, 193);
        add(groupBoxColors);

        // Создание, добавление границы, размещение и добавление текста "Основной цвет"
        JLabel labelMainColor = new JLabel("Основной цвет");
        labelMainColor.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        labelMainColor.setBounds(12, 19, 125, 38);
        labelMainColor.setHorizontalAlignment(SwingConstants.CENTER);
        groupBoxColors.add(labelMainColor);

        // Создание, добавление границы, размещение и добавление текста "Дополнительный цвет"
        JLabel labelAdditionalColor = new JLabel("Дополнительный цвет");
        labelAdditionalColor.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        labelAdditionalColor.setBounds(145, 19, 158, 38);
        labelAdditionalColor.setHorizontalAlignment(SwingConstants.CENTER);
        groupBoxColors.add(labelAdditionalColor);

        JPanel panelRed = new JPanel();
        panelRed.setBackground(new Color(255, 0, 0, 255));
        panelRed.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panelRed.setBounds(26, 70, 45, 45);
        groupBoxColors.add(panelRed);

        JPanel panelYellow = new JPanel();
        panelYellow.setBackground(new Color(255, 255, 0, 255));
        panelYellow.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panelYellow.setBounds(99, 70, 45, 45);
        groupBoxColors.add(panelYellow);

        JPanel panelBlack = new JPanel();
        panelBlack.setBackground(new Color(0, 0, 0, 255));
        panelBlack.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panelBlack.setBounds(172, 70, 45, 45);
        groupBoxColors.add(panelBlack);

        JPanel panelWhite = new JPanel();
        panelWhite.setBackground(new Color(255, 255, 255, 255));
        panelWhite.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panelWhite.setBounds(245, 70, 45, 45);
        //panelRed.addMouseListener(listenerColor);
        groupBoxColors.add(panelWhite);

        JPanel panelGray = new JPanel();
        panelGray.setBackground(new Color(128, 128, 128, 255));
        panelGray.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panelGray.setBounds(26, 131, 45, 45);
        //panelRed.addMouseListener(listenerColor);
        groupBoxColors.add(panelGray);

        JPanel panelOrange = new JPanel();
        panelOrange.setBackground(new Color(255, 165, 0, 255));
        panelOrange.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panelOrange.setBounds(99, 131, 45, 45);
        //panelRed.addMouseListener(listenerColor);
        groupBoxColors.add(panelOrange);

        JPanel panelGreen = new JPanel();
        panelGreen.setBackground(new Color(0, 128, 0, 255));
        panelGreen.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panelGreen.setBounds(172, 131, 45, 45);
        //panelRed.addMouseListener(listenerColor);
        groupBoxColors.add(panelGreen);

        JPanel panelBlue = new JPanel();
        panelBlue.setBackground(new Color(0, 0, 255, 255));
        panelBlue.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panelBlue.setBounds(245, 131, 45, 45);
        //panelRed.addMouseListener(listenerColor);
        groupBoxColors.add(panelBlue);

        // Создание, добавление границы с заголовком и размещение JPanel для выбора формы и кол-ва орудий
        JPanel groupBoxGunShape = new JPanel();
        groupBoxGunShape.setLayout(null);
        Border borderGunShape = BorderFactory.createTitledBorder("Форма орудий:");
        groupBoxGunShape.setBorder(borderGunShape);
        groupBoxGunShape.setBounds(420, 205, 220, 102);
        add(groupBoxGunShape);

        // Создание, добавление границы, размещение и добавление текста "Прямоугольные"
        JLabel labelRectangularGuns = new JLabel("Прямоугольные");
        labelRectangularGuns.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        labelRectangularGuns.setBounds(10, 18, 120, 20);
        labelRectangularGuns.setHorizontalAlignment(SwingConstants.CENTER);
        groupBoxGunShape.add(labelRectangularGuns);

        // Создание, добавление границы, размещение и добавление текста "Скругленные"
        JLabel labelRoundedGuns = new JLabel("Скругленные");
        labelRoundedGuns.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        labelRoundedGuns.setBounds(10, 44, 120, 20);
        labelRoundedGuns.setHorizontalAlignment(SwingConstants.CENTER);
        groupBoxGunShape.add(labelRoundedGuns);

        // Создание, добавление границы, размещение и добавление текста "Треугольные"
        JLabel labelTriangularGuns = new JLabel("Треугольные");
        labelTriangularGuns.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        labelTriangularGuns.setBounds(10, 70, 120, 20);
        labelTriangularGuns.setHorizontalAlignment(SwingConstants.CENTER);
        groupBoxGunShape.add(labelTriangularGuns);

        // Создание, размещение и добавление текста "Количество орудий:"
        JLabel labelNumberGuns = new JLabel("<html><center>Количество<br>орудий</center></html>");
        labelNumberGuns.setBounds(140, 24, 70, 30);
        groupBoxGunShape.add(labelNumberGuns);

        // Создание, размещение и добавление JSpinner для веса
        JSpinner spinnerNumberGuns = new JSpinner(new SpinnerNumberModel(1, 1, 3, 1));
        spinnerNumberGuns.setBounds(140, 59, 70, 23);
        groupBoxGunShape.add(spinnerNumberGuns);

        // Создание, размещение, назначения действия и добавление кнопки "Добавить"
        JButton buttonOk = new JButton("Добавить");
        buttonOk.setBounds(644, 231, 90, 23);
        add(buttonOk);

        // Создание, размещение, назначения действия и добавление кнопки "Отмена"
        JButton buttonCancel = new JButton("Отмена");
        buttonCancel.setBounds(644, 262, 90, 23);
        add(buttonCancel);

        buttonOk.addActionListener(e -> {
            applyCheck = true;
            dispose();
        });

        buttonCancel.addActionListener(e -> dispose());

        // Выбор типа военной техники
        MouseAdapter listenerType = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                JLabel label = (JLabel) e.getSource();
                switch (label.getText()) {
                    case "<html><center>Бронированный автомобиль</center></html>":
                        militaryEquipment = new ArmoredCar((Integer)spinnerSpeed.getValue(), (Integer)spinnerWeight.getValue(), Color.white);
                        break;
                    case "<html><center>Самоходная артиллерийская установка</center></html>":
                        militaryEquipment = new SelfPropArtilleryInstal((Integer)spinnerSpeed.getValue(), (Integer)spinnerWeight.getValue(), Color.white, Color.black,
                                checkBoxCamouflage.isSelected(), checkBoxStar.isSelected(), checkBoxСaterpillar.isSelected());
                        break;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getX() + ((JComponent) e.getSource()).getX() + groupBoxMilitaryEquipmentType.getX() >= panelMilitaryEquipment.getX() &&
                        e.getX() + ((JComponent) e.getSource()).getX() + groupBoxMilitaryEquipmentType.getX() <= panelMilitaryEquipment.getX() + panelMilitaryEquipment.getWidth() &&
                        e.getY() + ((JComponent) e.getSource()).getY() + groupBoxMilitaryEquipmentType.getY() >= panelMilitaryEquipment.getY() &&
                        e.getY() + ((JComponent) e.getSource()).getY() + groupBoxMilitaryEquipmentType.getY() <= panelMilitaryEquipment.getY() + panelMilitaryEquipment.getHeight()) {
                    militaryEquipment.setPosition(10, 49, panelMilitaryEquipment.getWidth(), panelMilitaryEquipment.getHeight());
                    panelMilitaryEquipment.initMilitaryEquipment(militaryEquipment);
                    repaint();
                }
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                militaryEquipment = null;
            }
        };
        labelArmoredCar.addMouseListener(listenerType);
        labelSelfPropArtilleryInstal.addMouseListener(listenerType);

        // Изменение курсора при переносе на панель с техникой
        MouseListener listenerView = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (militaryEquipment != null || (panelMilitaryEquipment.getMilitaryEquipment() instanceof SelfPropArtilleryInstal && additionalElems != null)) {
                    setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (militaryEquipment != null || additionalElems != null) {
                    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                }
            }
        };
        panelMilitaryEquipment.addMouseListener(listenerView);

        // Выбор цвета
        MouseAdapter listenerColor = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                JPanel panelColor = (JPanel) e.getSource();
                busColor = panelColor.getBackground();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (panelMilitaryEquipment.getMilitaryEquipment() != null) {
                    if (e.getX() + ((JComponent) e.getSource()).getX() >= labelMainColor.getX() &&
                            e.getX() + ((JComponent) e.getSource()).getX() <= labelMainColor.getX() + labelMainColor.getWidth() &&
                            e.getY() + ((JComponent) e.getSource()).getY() >= labelMainColor.getY() &&
                            e.getY() + ((JComponent) e.getSource()).getY() <= labelMainColor.getY() + labelMainColor.getHeight()) {
                        panelMilitaryEquipment.getMilitaryEquipment().setMainColor(busColor);
                        repaint();
                    } else if (e.getX() + ((JComponent) e.getSource()).getX() >= labelAdditionalColor.getX() &&
                            e.getX() + ((JComponent) e.getSource()).getX() <= labelAdditionalColor.getX() + labelAdditionalColor.getWidth() &&
                            e.getY() + ((JComponent) e.getSource()).getY() >= labelAdditionalColor.getY() &&
                            e.getY() + ((JComponent) e.getSource()).getY() <= labelAdditionalColor.getY() + labelAdditionalColor.getHeight() &&
                            panelMilitaryEquipment.getMilitaryEquipment() instanceof SelfPropArtilleryInstal) {
                        SelfPropArtilleryInstal selfPropArtilleryInstal = (SelfPropArtilleryInstal) panelMilitaryEquipment.getMilitaryEquipment();
                        selfPropArtilleryInstal.setDopColor(busColor);
                        repaint();
                    }
                }
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                busColor = null;
            }
        };
        panelRed.addMouseListener(listenerColor);
        panelYellow.addMouseListener(listenerColor);
        panelBlack.addMouseListener(listenerColor);
        panelWhite.addMouseListener(listenerColor);
        panelGray.addMouseListener(listenerColor);
        panelOrange.addMouseListener(listenerColor);
        panelGreen.addMouseListener(listenerColor);
        panelBlue.addMouseListener(listenerColor);

        // Выбор основного или дополнительного цвета
        MouseListener listenerColorLabel = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JLabel labelColor = (JLabel) e.getSource();
                switch (labelColor.getText()) {
                    case "Основной цвет":
                        if (panelMilitaryEquipment.getMilitaryEquipment() != null && busColor != null) {
                            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        }
                        break;
                    case "Доп цвет":
                        if (panelMilitaryEquipment.getMilitaryEquipment() instanceof SelfPropArtilleryInstal && busColor != null) {
                            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        }
                        break;
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (busColor != null) {
                    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                }
            }
        };
        labelMainColor.addMouseListener(listenerColorLabel);
        labelAdditionalColor.addMouseListener(listenerColorLabel);

        MouseAdapter listenerAdditionalElems = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                JLabel labelAdditionalElems = (JLabel) e.getSource();
                switch (labelAdditionalElems.getText()) {
                    case "Прямоугольные":
                        additionalElems = new RectangleGuns();
                        additionalElems.setNumber((Integer)spinnerNumberGuns.getValue() - 1);
                        break;
                    case "Скругленные":
                        additionalElems = new RoundedGuns();
                        additionalElems.setNumber((Integer)spinnerNumberGuns.getValue() - 1);
                        break;
                    case "Треугольные":
                        additionalElems = new TriangularGuns();
                        additionalElems.setNumber((Integer)spinnerNumberGuns.getValue() - 1);
                        break;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (panelMilitaryEquipment.getMilitaryEquipment() != null) {
                    if (e.getX() + ((JComponent) e.getSource()).getX() + groupBoxGunShape.getX() >= panelMilitaryEquipment.getX() &&
                            e.getX() + ((JComponent) e.getSource()).getAlignmentX() + groupBoxGunShape.getX() <= panelMilitaryEquipment.getX() + panelMilitaryEquipment.getWidth() &&
                            e.getY() + ((JComponent) e.getSource()).getY() + groupBoxGunShape.getY() >= panelMilitaryEquipment.getY() &&
                            e.getY() + ((JComponent) e.getSource()).getY() + groupBoxGunShape.getY() <= panelMilitaryEquipment.getY() + panelMilitaryEquipment.getHeight() &&
                            panelMilitaryEquipment.getMilitaryEquipment() instanceof SelfPropArtilleryInstal) {
                        SelfPropArtilleryInstal selfPropArtilleryInstal = (SelfPropArtilleryInstal) panelMilitaryEquipment.getMilitaryEquipment();
                        selfPropArtilleryInstal.setAdditionalElems(additionalElems);
                        repaint();
                    }
                }
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                additionalElems = null;
            }
        };
        labelRectangularGuns.addMouseListener(listenerAdditionalElems);
        labelRoundedGuns.addMouseListener(listenerAdditionalElems);
        labelTriangularGuns.addMouseListener(listenerAdditionalElems);

        setVisible(true);
    }

    public Vehicle getMilitaryEquipment() {
        if (applyCheck) {
            return (Vehicle) panelMilitaryEquipment.getMilitaryEquipment();
        } else {
            return null;
        }
    }
}