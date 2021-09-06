import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    public void processUser(){
        Scanner sc = new Scanner(System.in);

        view.printMessage(View.INPUT_HELLO_WORLD);

        model.setWord1(inputWord1ValueWithScanner(sc));
        model.setWord2(inputWord2ValueWithScanner(sc));

        view.printMessageAndString(View.OUR_INPUT, model.getWord1(), model.getWord2());
    }

    public String inputWord1ValueWithScanner(Scanner sc) {
        String w1 = sc.next();
        while( ! w1.equals("Hello")) {
            view.printMessage(View.WRONG_WORD1);
            w1 = sc.next();
        }
        return w1;
    }

    public String inputWord2ValueWithScanner(Scanner sc) {
        String w2 = sc.next();
        while( ! w2.equals("world!")) {
            view.printMessage(View.WRONG_WORD2);
            w2 = sc.next();
        }
        return w2;
    }
}