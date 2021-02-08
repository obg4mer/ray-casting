package simulation;

import app.App;
import util.Vector2;

import java.awt.*;

public class Line implements Obstacle {

    public final Vector2 point1;
    public final Vector2 point2;

    public Line(Vector2 from, Vector2 to) {
        point1 = from;
        point2 = to;
    }

    //region Class Methods

    public Vector2 intersect(Vector2 origin, Vector2 limit) {
        float down = (origin.x - limit.x)*(point1.y - point2.y) - (origin.y - limit.y)*(point1.x - point2.x);
        if (Math.round(down) == 0) return null;

        float aux1 = (origin.x * limit.y - origin.y * limit.x);
        float aux2 = (point1.x * point2.y - point1.y * point2.x);

        float xUp =  aux1 * (point1.x - point2.x) - aux2 * (origin.x - limit.x);
        float x = xUp/down;

        float yUp = aux1 * (point1.y - point2.y) - aux2 * (origin.y - limit.y);
        float y = yUp/down;

        Vector2 intersection = new Vector2(Math.round(x), Math.round(y));

        if (intersection.isBetween(origin, limit) && intersection.isBetween(point1, point2)) return intersection;
        else return null;
    }

    public void paint(Graphics2D g2d) {
        g2d.setColor(App.colorObstacles);
        g2d.setStroke(new BasicStroke(App.obstacleWidth));
        g2d.drawLine(Math.round(point1.x), Math.round(point1.y), Math.round(point2.x), Math.round(point2.y));
    }

    //endregion

}
