import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelMilitaryEquipment extends JPanel {
    private MilitaryEquipment militaryEquipment;

    public void paintComponent(Graphics g) {
        if (militaryEquipment != null) {
            militaryEquipment.drawTransport(g);
        }
    }

    public void initMilitaryEquipment(MilitaryEquipment militaryEquipment) {
        this.militaryEquipment = militaryEquipment;
    }

    public MilitaryEquipment getMilitaryEquipment() {
        return militaryEquipment;
    }
}