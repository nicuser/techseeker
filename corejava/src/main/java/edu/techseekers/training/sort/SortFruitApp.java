/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.techseekers.training.sort;
import java.util.Arrays;
/**
 *
 * @author myhome
 */
public class SortFruitApp {

    public static void main(String args[]) {

        Fruit[] fruits = new Fruit[4];

        Fruit pineappale = new Fruit("Pineapple", "Pineapple description", 70);
        Fruit apple = new Fruit("Apple", "Apple description", 100);
        Fruit orange = new Fruit("Orange", "Orange description", 80);
        Fruit banana = new Fruit("Banana", "Banana description", 90);

        fruits[0] = pineappale;
        fruits[1] = apple;
        fruits[2] = orange;
        fruits[3] = banana;

        Arrays.sort(fruits);

        int i = 0;
        for (Fruit temp : fruits) {
            System.out.println("fruits " + ++i + " : " + temp.getFruitName()
                    + ", Quantity : " + temp.getQuantity());
        }

    }
}
