import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelMilitaryEquipment extends JPanel {
    private Vehicle militaryEquipment;

    public void paintComponent(Graphics g) {
        if (militaryEquipment != null) {
            militaryEquipment.drawTransport(g);
        }
    }

    public void initMilitaryEquipment(Vehicle militaryEquipment) {
        this.militaryEquipment = militaryEquipment;
    }

    public Vehicle getMilitaryEquipment() {
        return militaryEquipment;
    }
}