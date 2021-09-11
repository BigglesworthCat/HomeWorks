package Model;


import java.util.HashMap;
import java.util.Map;

//Second task of home work
public final class ImmutableBottle {
    private final String shape;
    private final String color;
    private final double volume;
    private final Map<String, Double> content;

    public ImmutableBottle(String shape, String color, double volume, Map<String, Double> content)
    {
        this.shape = shape;
        this.color = color;
        this.volume = volume;

        this.content = new HashMap<>(content); //Creating copy of map
    }

    public ImmutableBottle setShape(String shape) {
        return new ImmutableBottle(shape, this.color, this.volume, this.content);
    }

    public ImmutableBottle setColor(String color) {
        return new ImmutableBottle(this.shape, color, this.volume, this.content);
    }

    public ImmutableBottle setVolume(double volume) {
        return new ImmutableBottle(this.shape, this.color, volume, this.content);
    }

    public ImmutableBottle setContent(Map<String, Double> content) {
        return new ImmutableBottle(this.shape, this.color, volume, content);
    }

    public void print() {
        System.out.println("Shape: " + this.shape);
        System.out.println("Color: " + this.color);
        System.out.println("Volume: " + this.volume);
        System.out.println("Content: ");
        for (Map.Entry<String, Double> entry : this.content.entrySet())
        {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}