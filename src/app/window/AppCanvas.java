package app.window;

import app.App;

import javax.swing.*;
import java.awt.*;

public class AppCanvas extends JPanel {

    public AppCanvas() {
        Dimension dim = new Dimension(App.width, App.height);
        setMinimumSize(dim);
        setMaximumSize(dim);
        setPreferredSize(dim);

        AppMouseListener mouseListener = new AppMouseListener();
        addMouseListener(mouseListener);
        addMouseMotionListener(mouseListener);

        setBackground(App.colorBackground);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        App.lightSource.castLight(g2d);
        App.obstacles.forEach(o -> o.paint(g2d));
    }
}
