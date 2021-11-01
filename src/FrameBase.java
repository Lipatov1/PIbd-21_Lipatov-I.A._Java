import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class FrameBase extends JFrame {
    private final Base<ArmoredCar, AdditionalElems> base;
    private final JTextField textFieldPlaceNumber;

    public FrameBase() {
        setTitle("База");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1080, 500);
        setLocation(400, 300);
        setResizable(false);
        setVisible(true);
        setLayout(null);

        base = new Base<>(920, 450);

        PanelBase panelBase = new PanelBase(base);
        panelBase.setBounds(0, 0, 920, 450);
        add(panelBase);

        // Создание, размещение, назначения действия и добавление кнопки "Припарковать бронированный автомобиль"
        JButton buttonSetArmoredCar = new JButton("<html><center>" + "Припарковать" + "<br>" + "бронированный" + "<br>" + "автомобиль" + "</center></html>");
        buttonSetArmoredCar.setBounds(new Rectangle(915, 12, 135, 60));
        buttonSetArmoredCar.addActionListener(e -> setArmoredCar());
        add(buttonSetArmoredCar);

        // Создание, размещение, назначения действия и добавление кнопки "Припарковать cамоходную артиллерийскую установку"
        JButton buttonSetArtillery = new JButton("<html><center>" + "Припарковать" + "<br>" + "cамоходную" + "<br>" + "артиллерийскую" + "<br>" + "установку" + "</center></html>");
        buttonSetArtillery.setBounds(new Rectangle(915, 78, 135, 73));
        buttonSetArtillery.addActionListener(e -> setSelfPropArtilleryInstal());
        add(buttonSetArtillery);

        // Создание JPanel, добавление рамки с заголовком и размещение
        JPanel groupBoxTakeTechnic = new JPanel();
        Border centerBorder = BorderFactory.createTitledBorder("Забрать технику:");
        groupBoxTakeTechnic.setBorder(centerBorder);
        groupBoxTakeTechnic.setBounds(new Rectangle(915, 157, 135, 87));

        // Создание, размещение и добавление "Место:" на JPanel
        JLabel labelPlace = new JLabel("Место:");
        labelPlace.setBounds(22, 18, 50, 30);
        groupBoxTakeTechnic.add(labelPlace);

        // Создание, размещение и добавление текстового поля на JPanel
        textFieldPlaceNumber = new JFormattedTextField();
        textFieldPlaceNumber.setBounds(67, 25, 45, 20);
        groupBoxTakeTechnic.add(textFieldPlaceNumber);

        // Создание, размещение, назначения действия и добавление кнопки "Забрать" на JPanel
        JButton buttonTakeTechnic = new JButton("Забрать");
        buttonTakeTechnic.setBounds(22, 50, 90, 25);
        buttonTakeTechnic.addActionListener(e -> takeMilitaryEquipment());
        groupBoxTakeTechnic.add(buttonTakeTechnic);
        add(groupBoxTakeTechnic);

        repaint();
    }

    private void setArmoredCar() {
        JColorChooser colorDialog = new JColorChooser();
        JOptionPane.showMessageDialog(this, colorDialog);
        if (colorDialog.getColor() != null) {
            var armoredCar = new ArmoredCar(100, 1000, colorDialog.getColor());
            if (base.add(armoredCar) != -1) {
                repaint();
            } else {
                JOptionPane.showMessageDialog(this, "База переполнена");
            }
        }
    }

    private void setSelfPropArtilleryInstal() {
        JColorChooser colorDialog = new JColorChooser();
        JOptionPane.showMessageDialog(this, colorDialog);
        if (colorDialog.getColor() != null) {
            JColorChooser additionalColorDialog = new JColorChooser();
            JOptionPane.showMessageDialog(this, additionalColorDialog);
            if (additionalColorDialog.getColor() != null) {
                var armoredCar = new SelfPropArtilleryInstal(100, 1000, colorDialog.getColor(), additionalColorDialog.getColor(), true, true, true);
                if (base.add(armoredCar) != -1) {
                    repaint();
                } else {
                    JOptionPane.showMessageDialog(this, "База переполнена");
                }
            }
        }
    }

    private void takeMilitaryEquipment() {
        if (!textFieldPlaceNumber.getText().equals("")) {
            try {
                var militaryEquipment = base.remove(Integer.parseInt(textFieldPlaceNumber.getText()));
                if (militaryEquipment != null) {
                    FrameMilitaryEquipment frameMilitaryEquipment = new FrameMilitaryEquipment();
                    frameMilitaryEquipment.setTransport(militaryEquipment);
                    repaint();
                } else {
                    JOptionPane.showMessageDialog(this, "На этом месте нет техники");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "На этом месте нет техники");
            }
        }
    }
}