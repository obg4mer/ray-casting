package app.window;

import app.App;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class AppMainPanel {

    private JPanel mainPanel;

    private JPanel canvasPanel;

    private JSlider raysSlider;
    private JLabel raysLabel;

    private JSlider repaintsSlider;
    private JLabel repaintsLabel;

    public AppMainPanel() {
        raysSlider.addChangeListener(e -> {
            int value = raysSlider.getValue();
            raysLabel.setText("" + value);
            App.numberOfLightRays = value;
            repaintCanvas();
        });

        raysSlider.setValue(App.numberOfLightRays);

        repaintsSlider.addChangeListener(e -> {
            int value = repaintsSlider.getValue();
            repaintsLabel.setText("" + value);
            App.millisBetweenRepaints = 1000 / value;
            repaintCanvas();
        });

        repaintsSlider.setValue(1000 / App.millisBetweenRepaints);
    }

    //region Class Methods

    public JPanel getPanel() {
        return mainPanel;
    }

    public void repaintCanvas() {
        canvasPanel.repaint();
    }

    //endregion

}
