import javax.swing.*;
import java.awt.*;

public class PanelBase extends JPanel {
    private final Base<ArmoredCar, AdditionalElems> base;

    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (base != null) {
            base.drawBase(g2);
        }
    }

    public Base<ArmoredCar, AdditionalElems> getBase() {
        return base;
    }

    public PanelBase(Base<ArmoredCar, AdditionalElems> base) {
        this.base = base;
    }
}