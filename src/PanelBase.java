import javax.swing.*;
import java.awt.*;

public class PanelBase extends JPanel {
    private final BaseCollection baseCollection;
    private String selectedItem = null;

    protected void paintComponent(Graphics g) {
        if (selectedItem != null) {
            Graphics2D g2 = (Graphics2D) g;
            if (baseCollection != null) {
                baseCollection.get(selectedItem).drawBase(g2);
            }
        }
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }

    public PanelBase(BaseCollection baseCollection) {
        this.baseCollection = baseCollection;
    }
}