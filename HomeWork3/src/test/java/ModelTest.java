import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ModelTest {

    private static Model testedModel;

    @BeforeEach
    public void run()
    {
        testedModel = new Model();

        testedModel.generateIntInInterval();
    }

    @Test
    void generateIntInDefaultInterval() //In this case random number will be generated in interval [0; 100]
    {
        for (int i = 0; i < 100_000; i++)
        {
            testedModel.generateIntInInterval();

            int randNum = testedModel.getRandInt(); //In each iteration generate new number
            boolean inRange = (randNum >= testedModel.getLowerBorder() && randNum <= testedModel.getUpperBorder()); //Check if generated number belongs to interaval
            Assertions.assertTrue(inRange);
        }
    }

    @Test
    void generateIntInInterval() //In this case random number will be generated in interval [-100; 100]
    {

        testedModel.setLowerBorder(-100);
        testedModel.setUpperBorder(100);

        for (int i = 0; i < 100_000; i++)
        {
            testedModel.generateIntInInterval();

            int randNum = testedModel.getRandInt(); //In each iteration generate new number
            boolean inRange = (randNum >= testedModel.getLowerBorder() && randNum <= testedModel.getUpperBorder()); //Check if generated number belongs to interaval
            Assertions.assertTrue(inRange);
        }
    }

    @Test
    void checkValue()
    {
        int randNum = testedModel.getRandInt();

        for(int i = -1; i <= 101; i++)
        {
            String res = testedModel.checkValue(i);
            boolean lessOrMore = ((i < randNum && res.equals("Less")) || (i > randNum && res.equals("More")) || (i == randNum && res.equals("Equal")));
            Assertions.assertTrue(lessOrMore);
        }
    }
}