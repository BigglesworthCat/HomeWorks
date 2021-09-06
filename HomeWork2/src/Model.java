import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Model {
    private int lowerBorder;
    private int upperBorder;
    private int randInt;
    private int count;
    List<Integer> history = new LinkedList<>();


    Model()
    {
        lowerBorder = 0;
        upperBorder = 100;
        count = 0;
    }

    public int getLowerBorder() { return lowerBorder; }

    public int getUpperBorder() { return upperBorder; }

    public int getRandInt() { return randInt; }

    public int getCount() { return count; }

    public List<Integer> getHistory() { return history; }

    public void setLowerBorder(int lowerBorder)
    {
        this.lowerBorder = lowerBorder;
    }

    public void setUpperBorder(int upperBorder) { this.upperBorder = upperBorder; }

    public void generateIntInInterval()
    {
        randInt = (lowerBorder + (int) (Math.random()*(upperBorder - lowerBorder + 1)));
    }

    public String checkValue(int userInt)
    {
        //Checking input value
        if(userInt > randInt)
        {
            if(userInt < upperBorder)
            {
                //Shifting borders for guessing
                upperBorder = userInt;
            }
            return "More";
        }
        else if(userInt < randInt)
        {
            if(userInt > lowerBorder)
            {
                //Shifting borders for guessing
                lowerBorder = userInt;
            }
            return "Less";
        }
        return "Equal";
    }

    public void addToHistory(int number)
    {
        count++;
        history.add(number);
    }
}