import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelSelfPropArtilleryInstal extends JPanel {
    private SelfPropArtilleryInstal selfPropArtilleryInstal;

    public void paintComponent(Graphics g) {
        if (selfPropArtilleryInstal != null) {
            selfPropArtilleryInstal.DrawTransport(g);
        }
    }

    public void initSelfPropArtilleryInstal(SelfPropArtilleryInstal selfPropArtilleryInstal) {
        this.selfPropArtilleryInstal = selfPropArtilleryInstal;
    }

    public SelfPropArtilleryInstal getSelfPropArtilleryInstal() {
        return selfPropArtilleryInstal;
    }
}