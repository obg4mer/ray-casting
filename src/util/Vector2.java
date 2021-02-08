package util;

import java.util.Objects;

public class Vector2 {

    public float x;
    public float y;

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2() {
        this(0, 0);
    }

    public static Vector2 fromAngle(float angle, float magnitude) {
        float x = magnitude * (float) Math.cos(angle);
        float y = - magnitude * (float) Math.sin(angle);

        return new Vector2(x, y);
    }

    //region Class Methods

    public Vector2 add(Vector2 vec) {
        this.x += vec.x;
        this.y += vec.y;
        return this;
    }

    public Vector2 subtract(Vector2 vec) {
        this.x -= vec.x;
        this.y -= vec.y;
        return this;
    }

    public Vector2 multiply(float value) {
        this.x *= value;
        this.y *= value;
        return this;
    }

    public Vector2 divide(float value) {
        this.x /= value;
        this.y /= value;
        return this;
    }

    public Vector2 normalize() {
        float magnitude = magnitude();
        divide(magnitude);
        return this;
    }

    public Vector2 setMagnitude(float magnitude) {
        return normalize().multiply(magnitude);
    }

    public float magnitude() {
        return (float) Math.sqrt(sqrMagnitude());
    }

    public float sqrMagnitude() {
        return x*x + y*y;
    }

    public float distance(Vector2 vec) {
        return (float) Math.sqrt(sqrDistance(vec));
    }

    public float sqrDistance(Vector2 vec) {
        return (float) (Math.pow(x - vec.x, 2) + Math.pow(y - vec.y, 2));
    }

    public float angle() {
        return (float) Math.atan2(-y, x);
    }

    public boolean isBetween(Vector2 vec1, Vector2 vec2) {
        float xm = (vec1.x + vec2.x)/2f;
        if(Math.abs(x-xm) > (Math.abs(vec1.x-xm))) return false;
        float ym = (vec1.y + vec2.y)/2f;
        if(Math.abs(y-ym) > (Math.abs(vec1.y-ym))) return false;
        return true;
    }

    //endregion

    //region Default Java Methods

    @Override
    public Vector2 clone() {
        return new Vector2(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2 that = (Vector2) o;
        return this.x == that.x && this.y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "" + x + " // " + y;
    }

    //endregion

}
