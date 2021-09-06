import java.util.Scanner;

public class Controller {
    private final Model model;
    private final View view;

    public Controller(Model model, View view)
    {
        this.model  = model;
        this.view = view;
    }

    //The Work method
    public void processUser()
    {
        Scanner sc = new Scanner(System.in);

        view.printMessage(View.BORDERS);

        String res = inputBordersChoice(sc); //Asking user if he wants to set own borders

        if(res.equals("YES")) //If user wants to set own generating borders
        {
            view.printMessage(View.INPUT_BORDERS);

            int lowerBorder = inputInt(sc);
            int upperBorder = inputInt(sc);

            if (lowerBorder > upperBorder) //If borders were put in wrong sequence
            {
                int tmp = upperBorder;
                upperBorder = lowerBorder;
                lowerBorder = tmp;
            }

            model.setLowerBorder(lowerBorder);
            model.setUpperBorder(upperBorder);
        }

        view.printMessage(View.GENERETED_INFO + model.getLowerBorder() + "; "+ model.getUpperBorder() + "]\n");
        view.printMessage(View.INPUT_INT);

        //Generating random int in interval
        model.generateIntInInterval();

        //System.out.println("Generated number is: " + model.getRandInt());

        int userInt;

        do
        {
            userInt = inputInt(sc);
            model.addToHistory(userInt);

            //Checking input value
            switch (model.checkValue(userInt)) {
                case "More" -> view.printWrongMessage(userInt, View.BIGGER_NUMBER, model.getLowerBorder(), model.getUpperBorder());
                case "Less" -> view.printWrongMessage(userInt, View.SMALLER_NUMBER, model.getLowerBorder(), model.getUpperBorder());
            }
        } while(!model.checkValue(userInt).equals("Equal"));

        view.printMessage(View.RESULT1 + model.getCount() + View.RESULT2 + model.getHistory().toString());
    }

    String inputBordersChoice(Scanner sc)
    {
        String res;
        while(true)
        {
            res=sc.next();
            if(res.equalsIgnoreCase("YES")) {
                return "YES";
            }
            else if(res.equalsIgnoreCase("NO"))
            {
                return "NO";
            }
            view.printMessage(View.WRONG_BORDERS);
        }
    }

    int inputInt(Scanner sc)
    {
        while(!sc.hasNextInt()){
            view.printMessage(View.NOT_INT);
            sc.next();
        }
        return sc.nextInt();
    }
}