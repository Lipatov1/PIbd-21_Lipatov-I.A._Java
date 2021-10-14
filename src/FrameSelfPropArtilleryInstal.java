import java.util.Random;
import javax.swing.*;
import java.awt.*;

public class FrameSelfPropArtilleryInstal extends JFrame {
    private PanelSelfPropArtilleryInstal panelSelfPropArtilleryInstal;

    public FrameSelfPropArtilleryInstal() {
        setTitle("Самоходная артиллерийская установка");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 500);
        setLocation(400, 300);
        setResizable(false);
        setVisible(true);
        setLayout(null);

        // Создание, размещение, назначения действия и добавление кнопки "Создать"
        JButton buttonCreate = new JButton("Создать");
        buttonCreate.setBounds(new Rectangle(12, 12, 85, 25));
        buttonCreate.addActionListener(e -> initSelfPropArtilleryInstal());
        add(buttonCreate);

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
                panelSelfPropArtilleryInstal.getSelfPropArtilleryInstal().moveTransport(Direction.Up);
                break;
            case "down":
                panelSelfPropArtilleryInstal.getSelfPropArtilleryInstal().moveTransport(Direction.Down);
                break;
            case "right":
                panelSelfPropArtilleryInstal.getSelfPropArtilleryInstal().moveTransport(Direction.Right);
                break;
            case "left":
                panelSelfPropArtilleryInstal.getSelfPropArtilleryInstal().moveTransport(Direction.Left);
                break;
        }
        repaint();
    }

    public void addPanelSelfPropArtilleryInstal(PanelSelfPropArtilleryInstal panel) {
        panelSelfPropArtilleryInstal = panel;
        add(panelSelfPropArtilleryInstal);
        panelSelfPropArtilleryInstal.setBounds(0, 0, 886, 463);
        repaint();
    }

    private void initSelfPropArtilleryInstal() {
        Random random = new Random();
        panelSelfPropArtilleryInstal.initSelfPropArtilleryInstal(new SelfPropArtilleryInstal(random.nextInt(200) + 100, random.nextInt(1000) + 1000, Color.decode("#424724"), Color.RED, true, true));
        panelSelfPropArtilleryInstal.getSelfPropArtilleryInstal().setPosition(random.nextInt(90) + 10, random.nextInt(90) + 10, panelSelfPropArtilleryInstal.getWidth(), panelSelfPropArtilleryInstal.getHeight());
        repaint();
    }
}