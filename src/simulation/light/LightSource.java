package simulation.light;

import app.App;
import util.Vector2;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LightSource {

    public Vector2 position;

    private final List<LightRay> rays;

    //private List<Line>

    public LightSource(Vector2 position) {
        this.position = position;
        rays = new ArrayList<>();
    }

    //region Class methods

    public void castLight(Graphics2D g2d) {
        rays.clear();

        float angleDelta = 2 * (float) Math.PI / (float) App.numberOfLightRays;
        float angle = 0;

        for (int i = 0; i < App.numberOfLightRays; i++, angle += angleDelta) {
            Vector2 direction = Vector2.fromAngle(angle, App.height + App.width);
            LightRay ray = LightRay.cast(position, direction);
            if (ray != null) rays.add(ray);
        }

        rays.forEach(r -> r.paint(g2d));
    }

    //endregion

}
