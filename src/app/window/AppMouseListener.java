package app.window;

import app.App;
import simulation.Line;
import util.Vector2;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class AppMouseListener implements MouseListener, MouseMotionListener {

    private boolean dragging = false;
    private long lastDragRepaint = 0;

    private Vector2 position1 = null;
    private Vector2 position2 = null;

    @Override
    public void mousePressed(MouseEvent e) {
        Vector2 position = new Vector2(e.getX(), e.getY());

        // Left Button
        if (SwingUtilities.isLeftMouseButton(e)) {
            if (position.distance(App.lightSource.position) < 25) dragging = true;
        }

        // Right Button
        else if (SwingUtilities.isRightMouseButton(e)) {
            position1 = position;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        // Left Button
        if (SwingUtilities.isLeftMouseButton(e)) {
            dragging = false;
        }

        // Right Button
        else if (SwingUtilities.isRightMouseButton(e)) {
            position2 = new Vector2(e.getX(), e.getY());;
            if (!position1.equals(position2))  drawLine();
            clear();
        }


    }

    @Override
    public void mouseDragged(MouseEvent e) {

        // Left Button
        if (dragging && SwingUtilities.isLeftMouseButton(e)) {
            long time = System.currentTimeMillis();
            if (time > lastDragRepaint + App.millisBetweenRepaints) {
                App.lightSource.position = new Vector2(e.getX(), e.getY());
                App.appWindow.repaintCanvas();
                lastDragRepaint = time;
            }
        }
    }

    //region Class Methods

    public void drawLine() {
        App.obstacles.add(new Line(position1, position2));
        App.appWindow.repaintCanvas();
    }

    public void clear() {
        position1 = null;
        position2 = null;
    }

    //endregion

    //region Unused Methods

    @Override
    public void mouseClicked(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }

    @Override
    public void mouseMoved(MouseEvent e) { }

    //endregion

}
