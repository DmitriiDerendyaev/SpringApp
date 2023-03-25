package ru.derendyaev.SpringApp.models;

import java.io.IOException;
import java.util.InputMismatchException;

public class Calc {
    private double firstNumber;
    private double secondNumber;
    private String inputString;

    private double result;

    public Calc(String inputString) {
        this.inputString = inputString;
    }

    public String calculate() throws IOException {
        String[] component = inputString.split(" ");
        char[] charInput = inputString.toCharArray();
        Character currentSign = ' ';
        int isCorrectSign = 0;

        if(component.length > 3 || component.length <= 1)
            throw new IOException("Cтрока не является математической операцией");



        for(int i = 0; i < charInput.length; i++){
            if(charInput[i] == '+' || charInput[i] == '-' || charInput[i] == '*' || charInput[i] == '/'){
                currentSign = charInput[i];
                isCorrectSign++;
            }
        }

        if(isCorrectSign != 1){
            throw new IOException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)!");
        }

        if(currentSign == '+'){
            component = inputString.split(" \\+ ");
        } else if (currentSign == '-') {
            component = inputString.split(" - ");
        } else if (currentSign == '*') {
            component = inputString.split(" \\* ");
        } else if (currentSign == '/') {
            component = inputString.split(" / ");
        }

        firstNumber = Integer.parseInt(component[0]);
        secondNumber = Integer.parseInt(component[1]);

        switch (currentSign){
            case ('+') -> {
                result = firstNumber + secondNumber;
            }
            case ('-') -> {
                result = firstNumber - secondNumber;
            }
            case ('*') -> {
                result = firstNumber * secondNumber;
            }
            case ('/') -> {
                try {
                    result = firstNumber / secondNumber;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.err.println("Exception : " + e);
                    System.err.println("Результатом операции могут быть только целые числа!");
                }
            }
        }


        return Double.toString(result);
    }
}
