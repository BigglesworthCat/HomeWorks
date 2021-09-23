package Controller;

import Model.Model;
import Model.Part1.*;
import Model.Part2.MyArrayList.MyArrayList;
import Model.Part2.MyArrayList.MyArrayListInterface;
import Model.Part2.MyLinkedList.MyLinkedList;
import View.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Controller {
    private final Model model;
    private final View view;

    public Controller(Model model, View view)
    {
        this.model = model;
        this.view = view;
    }

    //The Work method
    public void processUser() {
        view.printMessage("--===Part 1===--\n");

        HashMap<Integer, Integer> uniqElemCounter = ElementsCounter.countElements(new ArrayList<>(Arrays.asList(4, 5, -6, 4, 5, 3, 4, 2, 4, 5, 7)));
        view.printMap(uniqElemCounter);

        view.printMessage("--===Part 2 (MyArrayList)===--\n");

        MyArrayListInterface<String> arrayList = new MyArrayList<>();

        arrayList.add("Hello, ");
        arrayList.add("world!\n");
        arrayList.add("My name is Dima!");
        arrayList.delete(0); //Method is empty!

        for(String str: arrayList)
        {
            view.printMessage(str);
        }

        view.printMessage("--===Part 2 (MyLinkedList)===--\n");

        MyLinkedList<String> linkedList = new MyLinkedList<>();

        linkedList.addFirst("4");
        linkedList.addLast("8");
        linkedList.addLast("15");
        linkedList.addLast("16");
        linkedList.addLast("23");
        linkedList.addLast("42");

        for (String str: linkedList)
        {
            view.printMessage(str + " ");
        }
    }
}