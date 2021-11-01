import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelMilitaryEquipment extends JPanel {
    private ITransport militaryEquipment;

    public void paintComponent(Graphics g) {
        if (militaryEquipment != null) {
            militaryEquipment.drawTransport(g);
        }
    }

    public void initMilitaryEquipment(ITransport militaryEquipment) {
        this.militaryEquipment = militaryEquipment;
    }

    public ITransport getMilitaryEquipment() {
        return militaryEquipment;
    }
}