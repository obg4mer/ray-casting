package simulation.light;

import app.App;
import simulation.Obstacle;
import util.Vector2;

import java.awt.*;

public class LightRay {

    public final Vector2 point1;
    public final Vector2 point2;

    private LightRay(Vector2 from, Vector2 to) {
        point1 = from;
        point2 = to;
    }

    //region Class Methods

    public void paint(Graphics2D g2d) {
        g2d.setColor(App.colorLight);
        g2d.setStroke(new BasicStroke(App.lightWidth));
        g2d.drawLine(Math.round(point1.x), Math.round(point1.y), Math.round(point2.x), Math.round(point2.y));
    }

    //endregion

    //region Static Methods

    public static LightRay cast(Vector2 origin, Vector2 direction) {
        Vector2 rayEnd = origin.clone().add(direction);
        Vector2 minIntersection = null;
        float minDistance = Float.MAX_VALUE;


        for (Obstacle obstacle : App.obstacles) {
            Vector2 intersection = obstacle.intersect(origin, rayEnd);
            if (intersection != null) {
                float distance = origin.distance(intersection);
                if (distance < minDistance) {
                    minIntersection = intersection;
                    minDistance = distance;
                }
            }
        }

        if (minIntersection != null) return new LightRay(origin, minIntersection);
        else return null;
    }

    //endregion

}
