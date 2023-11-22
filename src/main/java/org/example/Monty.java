package org.example;

import java.util.HashMap;
import java.util.Random;

public class Monty {
    static Random random = new Random();
    static final int door = 3;
    public static void main(String[] args) {
        int count = 0;
        int iterations=1000;
        HashMap<Integer, Integer> result = new HashMap<>();
        while (count < iterations) {
            int prize = random.nextInt(door) + 1;
            int playerChoice = random.nextInt(door) + 1;
            int doorOpen = openDoorAndsecondChoice(prize, playerChoice);
            playerChoice = openDoorAndsecondChoice(playerChoice, doorOpen);
            if (prize == playerChoice) {
                result.put(count++, 1);
            } else {
                result.put(count++, 0);
            }
        }
        int sum = result.values().stream().mapToInt(Integer::valueOf).sum();

        System.out.println("Сыграно игр: " + result.size());
        System.out.println("Игрок победил " + sum + " раз");
        System.out.println("Процент побед составляет " + (double) sum / (double) result.size() * 100);
    }

    public static int openDoorAndsecondChoice(int prize, int playerChoice){
        int doorOpen;
        do {
            doorOpen = random.nextInt(door) + 1;
        } while (doorOpen == prize || doorOpen == playerChoice);
        return doorOpen;
    }
}