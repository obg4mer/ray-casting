package app;

import app.window.AppWindow;
import simulation.Line;
import simulation.light.LightRay;
import simulation.light.LightSource;
import simulation.Obstacle;
import util.Vector2;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static AppWindow appWindow;

    public static LightSource lightSource;
    public static List<Obstacle> obstacles;

    public static void main(String[] args) {

        lightSource = new LightSource(new Vector2(width/2f, height/2f));
        obstacles = new ArrayList<>();

        Vector2 topLeft = new Vector2(0,0);
        Vector2 topRight = new Vector2(width,0);
        Vector2 bottomLeft = new Vector2(0, height);
        Vector2 bottomRight = new Vector2(width, height);

        obstacles.add(new Line(topLeft, topRight));
        obstacles.add(new Line(bottomLeft, bottomRight));
        obstacles.add(new Line(topLeft, bottomLeft));
        obstacles.add(new Line(topRight, bottomRight));

        appWindow = new AppWindow("Ray Casting");
    }

    //region Config

    //region Size

    public static final int height = 700;
    public static final int width = 700;

    public static final int lightWidth = 1;
    public static final int obstacleWidth = 3;

    //endregion

    //region Colors

    public static final Color colorBackground = new Color(50, 50, 50);
    public static final Color colorObstacles = new Color(156, 156, 156);
    public static final Color colorLight = new Color(255, 244, 213);

    //endregion

    //region Simulation

    public static int numberOfLightRays = 16;
    public static int millisBetweenRepaints = 1000 / 60;

    //endregion

    //endregion

}
