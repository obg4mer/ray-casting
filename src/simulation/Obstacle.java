package simulation;

import util.Vector2;

import java.awt.*;

public interface Obstacle {

    void paint(Graphics2D g2d);

    Vector2 intersect(Vector2 origin, Vector2 direction);

}
