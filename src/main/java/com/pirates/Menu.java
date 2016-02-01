package com.pirates;

import java.util.Scanner;

public class Menu {

    private Scanner input = new Scanner(System.in);

    public void start() {

        showMenu(0);
        mainMenu:
        while (true) {
            String userInput = getUserInput(1, 4);
            switch (userInput) {
                case "1":
                    showMenu(1);
                    WindowsGUI gui = new WindowsGUI();
                    gui.startGUI();
                    break;
                case "2":
                    FIFO myFifo = new FIFO();
                    showMenu(2);
                    fifoMenu:
                    while (true) {
                        userInput = getUserInput(1, 5);
                        switch (userInput) {
                            case "1":
                                Scanner input = new Scanner(System.in);
                                System.out.println("Enter your message:");
                                String message = input.nextLine();
                                myFifo.push(message);
                                System.out.println("Your message was added to the queue");
                                break;
                            case "2":
                                System.out.println(myFifo.pop());
                                break;
                            case "3":
                                System.out.println(myFifo.peek());
                                break;
                            case "4":
                                myFifo.print();
                                break;
                            case "5":
                                showMenu(0);
                                break fifoMenu;
                        }
                    }
                    break;
                case "3":
                    LIFO myLifo = new LIFO();
                    showMenu(3);
                    lifoMenu:
                    while (true) {
                        userInput = getUserInput(1, 5);
                        switch (userInput) {
                            case "1":
                                Scanner input = new Scanner(System.in);
                                System.out.println("Enter your message:");
                                String message = input.nextLine();
                                myLifo.push(message);
                                System.out.println("Your message was added to the queue");
                                break;
                            case "2":
                                System.out.println(myLifo.pop());
                                break;
                            case "3":
                                System.out.println(myLifo.peek());
                                break;
                            case "4":
                                myLifo.print();
                                break;
                            case "5":
                                showMenu(0);
                                break lifoMenu;
                        }
                    }
                    break;
                case "4":
                    break mainMenu;
            }
        }
    }

    private void showMenu(int level) {
        switch (level) {
            case 0:
                System.out.println("Main menu:");
                System.out.println("1. Start GUI");
                System.out.println("2. Use FIFO");
                System.out.println("3. Use LIFO");
                System.out.println("4. Exit");
                break;
            case 1:
                System.out.println("Starting GUI...");
                break;
            case 2:
                System.out.println("FIFO:");
                System.out.println("1. Push");
                System.out.println("2. Pop");
                System.out.println("3. Peek");
                System.out.println("4. Print");
                System.out.println("5. Main Menu");
                break;
            case 3:
                System.out.println("LIFO:");
                System.out.println("1. Push");
                System.out.println("2. Pop");
                System.out.println("3. Peek");
                System.out.println("4. Print");
                System.out.println("5. Main Menu");
                break;
        }
    }

    private String getUserInput(int firstMenuNumber, int lastMenuNumber) {
        String userInput = input.nextLine();
        StringBuilder regexp = new StringBuilder();
        regexp.append("[");
        regexp.append(firstMenuNumber);
        regexp.append("-");
        regexp.append(lastMenuNumber);
        regexp.append("]");
        while (!userInput.matches(regexp.toString())) {
            System.out.println("Пожалуйста, используйте цифры от " + firstMenuNumber + " до " + lastMenuNumber + "!");
            userInput = input.nextLine();
        }
        return userInput;
    }
}
