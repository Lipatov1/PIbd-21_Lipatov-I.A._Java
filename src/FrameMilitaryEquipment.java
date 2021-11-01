import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class FrameMilitaryEquipment extends JFrame {
    private PanelMilitaryEquipment panelMilitaryEquipment;

    public FrameMilitaryEquipment() {
        setTitle("Военная техника");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 500);
        setLocation(400, 300);
        setResizable(false);
        setVisible(true);
        setLayout(null);

        // Создание, размещение, назначения действия и добавление кнопки "Создать бронированный автомобиль"
        JButton buttonCreateArmoredCar = new JButton("Создать бронированный автомобиль");
        buttonCreateArmoredCar.setBounds(new Rectangle(12, 12, 255, 25));
        buttonCreateArmoredCar.addActionListener(e -> initArmoredCar());
        add(buttonCreateArmoredCar);

        // Создание, размещение, назначения действия и добавление кнопки "Создать cамоходную артиллерийскую установку"
        JButton buttonCreateSelfPropArtilleryInstal = new JButton("Создать cамоходную артиллерийскую установку");
        buttonCreateSelfPropArtilleryInstal.setBounds(new Rectangle(279, 12, 325, 25));
        buttonCreateSelfPropArtilleryInstal.addActionListener(e -> initSelfPropArtilleryInstal());
        add(buttonCreateSelfPropArtilleryInstal);

        // Создание, размещение, добавление и установка названия для кнопки вправо
        JButton buttonRight = new JButton(new ImageIcon("resources/right.png"));
        buttonRight.setBounds(new Rectangle(842, 419, 30, 30));
        buttonRight.setName("right");
        buttonRight.addActionListener(e -> buttonMove_Click(buttonRight));
        add(buttonRight);

        // Создание, размещение, добавление и установка названия для кнопки вниз
        JButton buttonDown = new JButton(new ImageIcon("resources/down.png"));
        buttonDown.setBounds(new Rectangle(806, 419, 30, 30));
        buttonDown.setName("down");
        buttonDown.addActionListener(e -> buttonMove_Click(buttonDown));
        add(buttonDown);

        // Создание, размещение, добавление и установка названия для кнопки влево
        JButton buttonLeft = new JButton(new ImageIcon("resources/left.png"));
        buttonLeft.setBounds(new Rectangle(770, 419, 30, 30));
        buttonLeft.setName("left");
        buttonLeft.addActionListener(e -> buttonMove_Click(buttonLeft));
        add(buttonLeft);

        // Создание, размещение, добавление и установка названия для кнопки вверх
        JButton buttonUp = new JButton(new ImageIcon("resources/up.png"));
        buttonUp.setBounds(new Rectangle(806, 383, 30, 30));
        buttonUp.setName("up");
        buttonUp.addActionListener(e -> buttonMove_Click(buttonUp));
        add(buttonUp);
    }

    private void buttonMove_Click(JButton button) {
        String name = button.getName();
        switch (name) {
            case "up":
                panelMilitaryEquipment.getMilitaryEquipment().moveTransport(Direction.Up);
                break;
            case "down":
                panelMilitaryEquipment.getMilitaryEquipment().moveTransport(Direction.Down);
                break;
            case "right":
                panelMilitaryEquipment.getMilitaryEquipment().moveTransport(Direction.Right);
                break;
            case "left":
                panelMilitaryEquipment.getMilitaryEquipment().moveTransport(Direction.Left);
                break;
        }
        repaint();
    }

    public void addPanelSelfPropArtilleryInstal(PanelMilitaryEquipment panel) {
        panelMilitaryEquipment = panel;
        add(panelMilitaryEquipment);
        panelMilitaryEquipment.setBounds(0, 0, 886, 463);
        repaint();
    }

    private void initArmoredCar() {
        Random random = new Random();
        panelMilitaryEquipment.initMilitaryEquipment(new ArmoredCar(random.nextInt(200) + 100, random.nextInt(1000) + 1000, Color.decode("#424724")));
        panelMilitaryEquipment.getMilitaryEquipment().setPosition(random.nextInt(90) + 10, random.nextInt(90) + 10, panelMilitaryEquipment.getWidth(), panelMilitaryEquipment.getHeight());
        repaint();
    }

    private void initSelfPropArtilleryInstal() {
        Random random = new Random();
        panelMilitaryEquipment.initMilitaryEquipment(new SelfPropArtilleryInstal(random.nextInt(200) + 100, random.nextInt(1000) + 1000, Color.decode("#424724"), Color.red, true, true, true));
        panelMilitaryEquipment.getMilitaryEquipment().setPosition(random.nextInt(90) + 10, random.nextInt(90) + 10, panelMilitaryEquipment.getWidth(), panelMilitaryEquipment.getHeight());
        repaint();
    }
}