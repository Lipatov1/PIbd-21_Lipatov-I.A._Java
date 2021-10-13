import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class FrameSelfPropArtilleryInstal extends JFrame {
    private PanelSelfPropArtilleryInstal panelSelfPropArtilleryInstal;

    public FrameSelfPropArtilleryInstal() {
        // Настройки фрейма
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
        buttonCreate.addActionListener(e -> InitSelfPropArtilleryInstal());
        add(buttonCreate);

        // Создание, размещение, добавление, установка команды для кнопки вправо
        JButton buttonRight = new JButton(new ImageIcon("resources/right.png"));
        buttonRight.setBounds(new Rectangle(842, 419, 30, 30));
        buttonRight.setActionCommand("right");
        buttonRight.addActionListener(new ClickListener());
        add(buttonRight);

        // Создание, размещение, добавление, установка команды для кнопки вниз
        JButton buttonDown = new JButton(new ImageIcon("resources/down.png"));
        buttonDown.setBounds(new Rectangle(806, 419, 30, 30));
        buttonDown.setActionCommand("down");
        buttonDown.addActionListener(new ClickListener());
        add(buttonDown);

        // Создание, размещение, добавление, установка команды для кнопки влево
        JButton buttonLeft = new JButton(new ImageIcon("resources/left.png"));
        buttonLeft.setBounds(new Rectangle(770, 419, 30, 30));
        buttonLeft.setActionCommand("left");
        buttonLeft.addActionListener(new ClickListener());
        add(buttonLeft);

        // Создание, размещение, добавление, установка команды для кнопки вверх
        JButton buttonUp = new JButton(new ImageIcon("resources/up.png"));
        buttonUp.setBounds(new Rectangle(806, 383, 30, 30));
        buttonUp.setActionCommand("up");
        buttonUp.addActionListener(new ClickListener());
        add(buttonUp);
    }

    public class ClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            String actionCommand = event.getActionCommand();
            switch (actionCommand){
                case "up":
                    panelSelfPropArtilleryInstal.getSelfPropArtilleryInstal().MoveTransport(Direction.Up);
                    break;
                case "down":
                    panelSelfPropArtilleryInstal.getSelfPropArtilleryInstal().MoveTransport(Direction.Down);
                    break;
                case "left":
                    panelSelfPropArtilleryInstal.getSelfPropArtilleryInstal().MoveTransport(Direction.Left);
                    break;
                case "right":
                    panelSelfPropArtilleryInstal.getSelfPropArtilleryInstal().MoveTransport(Direction.Right);
                    break;
            }
            repaint();
        }
    }

    public void AddPanelSelfPropArtilleryInstal(PanelSelfPropArtilleryInstal panel) {
        panelSelfPropArtilleryInstal = panel;
        add(panelSelfPropArtilleryInstal);
        panelSelfPropArtilleryInstal.setBounds(0, 0, 886, 463);
        repaint();
    }

    private void InitSelfPropArtilleryInstal() {
        Random random = new Random();
        panelSelfPropArtilleryInstal.initSelfPropArtilleryInstal(new SelfPropArtilleryInstal(random.nextInt(200) + 100, random.nextInt(1000) + 1000, Color.decode("#424724"), Color.RED, true, true));
        panelSelfPropArtilleryInstal.getSelfPropArtilleryInstal().SetPosition(random.nextInt(90) + 10, random.nextInt(90) + 10, panelSelfPropArtilleryInstal.getWidth(), panelSelfPropArtilleryInstal.getHeight());
        repaint();
    }
}