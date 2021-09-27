/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculating;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.Stack;

/**
 *
 * @author Admin
 */
public class Main {

    final int fSize = 18;
    final Font font = new Font("Courier New", Font.PLAIN, fSize);
    final String[] numDisplay
            = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                //10   11   12   13   14   15   16   17      18  
                "+", "-", "x", "/", "(", ")", ".", "sin(", "cos(", "tan(",};

    final char[] operaterList = {'+', '-', 'x', '/', '(', ')'};

    Frame main = new Frame();
    TextField userInput = new TextField();

    Label outPut = new Label("", Label.CENTER);
    Button[] numBtn = new Button[numDisplay.length];
    Button btnEqual, btnAC, btnDEL;
    Panel numPanel = new Panel(), alpPanel = new Panel();

    int first(char a) {
        switch (a) {
            case '+':
            case '-':
                return 1;
            case 'x':
            case '/':
                return 2;
        }
        return 0;
    }

    private int indexOfEle(char[] a, char x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                return i;
            }
        }
        return -1;
    }

    String add(String a, String b) {
        double s = Double.parseDouble(a) + Double.parseDouble(b);
        return String.valueOf(s);
    }

    String minus(String a, String b) {
        double s = Double.parseDouble(b) - Double.parseDouble(a);
        return String.valueOf(s);
    }

    String mul(String a, String b) {
        double s = Double.parseDouble(b) * Double.parseDouble(a);
        return String.valueOf(s);
    }

    String div(String a, String b) {
        double s = Double.parseDouble(b) / Double.parseDouble(a);
        return String.valueOf(s);
    }

    String natureNumberHandle(char e, String a, String b) {
        String res = "";
        switch (indexOfEle(operaterList, e)) {
            case 0:
                res = add(a, b);
                break;
            case 1:
                res = minus(a, b);
                break;
            case 2:
                res = mul(a, b);
                break;
            case 3:
                res = div(a, b);
                break;
        }
        return res;
    }

    String operHandle(String a) {
        if (a.isEmpty()) {
            return "";
        }
        int s = 0;
        for (var e : a.toCharArray()) {
            if (e == '-') {
                s++;
            }
        }
        return s % 2 == 0 ? "+" : "-";
    }

    String stringHandle(String a) {

        String _a = a, res = "";
        _a = _a.trim();
        char[] oper = {'+', '-'};

        char[] charArr = _a.toCharArray();
        String handle = "";
        int i = 0, l = charArr.length;

        //3x----4x(---4) = 3x-4x(-4)
        while (i < l) {
            if (indexOfEle(oper, charArr[i]) != -1) {
                handle += charArr[i];
                i++;
            } else {
                res += operHandle(handle);
                res += charArr[i];
                i++;
                handle = "";
            }
        }
        // 5x(+4) = 5x(4)
        res = res.replaceAll("\\(\\+", "(");
        // 5/+5 = 5/5
        res = res.replaceAll("/\\+", "/");
        // 5x+5 = 5x5
        res = res.replaceAll("x\\+", "x");

        char oper1[] = {'+', '-', 'x', '/'};

        String num = "", res1 = "";
        int index, last, last2, len = res.length();
        char[] b = res.toCharArray();
        index = last = last2 = 0;

        //6x-6+7x-8+9-10 = 6x(-6)+7x(-8)+9-10
        while (index < len) {
            index = res.indexOf("x-", index);
            if (index == -1) {
                res1 = res1 + res.substring(last2);
                break;
            }
            res1 = res1 + res.substring(last, index + 1);
            last = index + 2;
            for (int j = index + 2; j < len; j++) {
                if (indexOfEle(oper1, b[j]) != -1 || j == len) {
                    break;
                } else {
                    num += b[j];
                    last++;
                }
            }
            res1 = res1 + "(-" + num + ")";
            num = "";
            index = last;
            last2 = last;
        }

        // /-
        num = "";
        res = "";
        len = res1.length();
        b = res1.toCharArray();
        index = last = last2 = 0;

        //6/-6+7/-8+9-10 = 6/(-6)+7/(-8)+9-10
        while (index < len) {
            index = res1.indexOf("/-", index);
            if (index == -1) {
                res = res + res1.substring(last2);
                break;
            }
            res = res + res1.substring(last, index + 1);
            last = index + 2;
            for (int j = index + 2; j < len; j++) {
                if (indexOfEle(oper1, b[j]) != -1 || j == len) {
                    break;
                } else {
                    num += b[j];
                    last++;
                }
            }
            res = res + "(-" + num + ")";
            num = "";
            index = last;
            last2 = last;
        }

        //5(6) = 5x(6)
//        res1 = "";
//        index = last = last2 = 0;
//        b = res.toCharArray();
//        len = res.length();
//        while(index < len) {
//            index = res.indexOf("(", index);
//            if(index == -1) {
//                res1 = res1 + res.substring(last);
//                break;
//            }
//            if(indexOfEle(oper1, b[index-1]) == -1) {
//                res1 = res1 + res.substring(last,index);
//                res1 += "x";
//                last = res.indexOf("(", index);
//                res1 += res.substring(index, last);
//                index = last-1;
//            }
//        }
        return res1;
    }

    private boolean validInput(String a) {
        if (a.isEmpty()) {
            return false;
        }
        String _a = a.replaceAll("\\s+", "");
        _a = " ".concat(_a);

        if (_a.matches("(.)*([\\+|\\-][x|/])(.)*")) {
            return false;
        }
        if (_a.matches("(.)*([x|/]){2,}(.)*")) {
            return false;
        }
        if (_a.matches(".*(x/|/x).*")) {
            return false;
        }

        if (_a.matches("( )[x|/]\\d+(.)*")) {
            return false;
        }
        if (_a.matches(".*(\\+|-|x|/|\\()$")) {
            return false;
        }
        if (_a.matches(".*\\(\\).*")) {
            return false;
        }

        if (_a.matches(".*\\((x|/).*")) {
            return false;
        }
        if (_a.matches(".*(x|/|\\+|-)\\).*")) {
            return false;
        }
        if (_a.matches(".*\\d+\\(.*")) {
            return false;
        }
        return true;
    }

    private String userInputHandle(String input) {

        Stack numStack = new Stack(), operatorStack = new Stack();
        boolean inBrack = false, isBrackDiff = false;
        String curStr = "";
        for (var e : input.toCharArray()) {
            if (indexOfEle(operaterList, e) == -1) {
                curStr += e;
            } else {
                if (!curStr.isEmpty()) {
                    if (isBrackDiff) {
                        curStr = "-".concat(curStr);
                        isBrackDiff = false;
                    }
                    numStack.push(curStr);
                    curStr = "";
                }
                if (e == '(') {
                    numStack.push("(");
                    inBrack = true;
                } else {
                    if (e == ')') {
                        while (true) {
                            String a = (String) numStack.pop();
                            String b = (String) numStack.pop();
                            if (b.equals("(")) {
                                numStack.push(a);
                                break;
                            }
                            char operTemp = (char) operatorStack.pop();
                            String res = natureNumberHandle(operTemp, a, b);
                            numStack.push(res);
                        }
                    } else {
                        if (operatorStack.empty() || inBrack) {
                            if (inBrack) {
                                var temp = numStack.peek();
                                if (e == '-' && temp.equals("(")) {
                                    isBrackDiff = true;
                                    continue;
                                }
                            }
                            operatorStack.push(e);
                            inBrack = false;
                        } else {
                            var curOper = (char) operatorStack.peek();
                            if (first(e) > first(curOper)) {
                                operatorStack.push(e);
                            } else {
                                operatorStack.pop();
                                String a = (String) numStack.pop();
                                if (numStack.isEmpty()) {
                                    a = curOper + a;
                                    numStack.push(a);
                                    operatorStack.push(e);
                                    continue;
                                }
                                String b = (String) numStack.pop();
                                String res = natureNumberHandle(curOper, a, b);
                                numStack.push(res);
                                operatorStack.push(e);
                            }
                        }
                    }
                }
            }
        }
        if (!curStr.isEmpty()) {
            numStack.push(curStr);
        }

        while (numStack.size() != 1) {
            String a = (String) numStack.pop();
            String b = (String) numStack.pop();
            char operTemp = (char) operatorStack.pop();
            String res = natureNumberHandle(operTemp, a, b);
            numStack.push(res);
        }
        var res = String.valueOf(numStack.get(0));
        if (!operatorStack.empty()) {
            res = String.valueOf(operatorStack.peek()) + res;
        }
        return res;
    }

    private void draw() {
        // add user input text field
        Font fontText = new Font("Courier New", Font.PLAIN, 24);
        userInput.setSize(300, 60);
        userInput.setBounds(20, 40, 300, 60);
        userInput.setFont(fontText);

        // add output lable
        outPut.setLocation(20, 140);
        outPut.setSize(300, 30);

        // add buttons
        // GridBagLayout btns 
        GridBagLayout numLayout = new GridBagLayout();
        numPanel.setSize(320, 220);
        numPanel.setLocation(10, 220);
        numPanel.setLayout(numLayout);

//        GridBagLayout alpLayout = new GridBagLayout();
//        alpPanel.setSize(320, 220);
//        alpPanel.setLocation(50, 100);
//        alpPanel.setLayout(alpLayout);
        GridBagConstraints gbc = new GridBagConstraints();
        // set num button
        // margin: 5
        gbc.insets = new Insets(5, 5, 5, 5);
        // padding: 20
        gbc.ipadx = 20;

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        numBtn[7] = new Button("7");
        numPanel.add(numBtn[7], gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        numBtn[8] = new Button("8");
        numPanel.add(numBtn[8], gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        numBtn[9] = new Button("9");
        numPanel.add(numBtn[9], gbc);

        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.ipadx = 0;
        btnDEL = new Button("DEL");
        numPanel.add(btnDEL, gbc);

        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.ipadx = 10;
        btnAC = new Button("AC");
        numPanel.add(btnAC, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        numBtn[4] = new Button("4");
        numPanel.add(numBtn[4], gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        numBtn[5] = new Button("5");
        numPanel.add(numBtn[5], gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        numBtn[6] = new Button("6");
        numPanel.add(numBtn[6], gbc);

        gbc.gridx = 4;
        gbc.gridy = 1;
        numBtn[12] = new Button("x");
        numPanel.add(numBtn[12], gbc);

        gbc.gridx = 5;
        gbc.gridy = 1;
        numBtn[13] = new Button("/");
        numPanel.add(numBtn[13], gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        numBtn[1] = new Button("1");
        numPanel.add(numBtn[1], gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        numBtn[2] = new Button("2");
        numPanel.add(numBtn[2], gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        numBtn[3] = new Button("3");
        numPanel.add(numBtn[3], gbc);

        gbc.gridx = 4;
        gbc.gridy = 2;
        numBtn[10] = new Button("+");
        numPanel.add(numBtn[10], gbc);

        gbc.gridx = 5;
        gbc.gridy = 2;
        numBtn[11] = new Button("-");
        numPanel.add(numBtn[11], gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        numBtn[0] = new Button("0");
        numPanel.add(numBtn[0], gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        numBtn[16] = new Button(".");
        numPanel.add(numBtn[16], gbc);
//        gbc.gridx = 3;
//        gbc.gridy = 3;
//        gbc.ipadx = 0;
//        numPanel.add(new Button("10x"), gbc);
//        gbc.gridx = 4;
//        gbc.gridy = 3;
//        numPanel.add(new Button("Ans"), gbc);
        gbc.gridx = 5;
        gbc.gridy = 3;
        btnEqual = new Button("=");
        numPanel.add(btnEqual, gbc);

        // add alphabet btns
//        gbc.insets = new Insets(2, 2, 2, 2);
//        gbc.ipadx = 0;
//        gbc.gridx = 3;
//        gbc.gridy = 2;
//        alpPanel.add(numBtn[16], gbc);
//        
//        gbc.gridx = 4;
//        gbc.gridy = 2;
//        alpPanel.add(numBtn[17], gbc);
//        
//        gbc.gridx = 5;
//        gbc.gridy = 2;
//        alpPanel.add(numBtn[18], gbc);
        gbc.gridx = 3;
        gbc.gridy = 3;
        numBtn[14] = new Button("(");
        numPanel.add(numBtn[14], gbc);

        gbc.gridx = 4;
        gbc.gridy = 3;
        numBtn[15] = new Button(")");
        numPanel.add(numBtn[15], gbc);
    }

    private void userEvents() {
        // displayed btn
        for (int i = 0; i <= 16; i++) {
            numBtn[i].addActionListener(new BtnDisplay(i) {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String a = userInput.getText() + numDisplay[index];
                    userInput.setText(a);
                    userInput.setCaretPosition(Integer.MAX_VALUE);
                    userInput.requestFocus();
                }
            });
        }
        //6(4-4)
        btnEqual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = userInput.getText();
                if (!validInput(a)) {
                    outPut.setText("Syntax Error");
                    return;
                }
                String _a = stringHandle(a);
                String output = userInputHandle(_a);
                outPut.setText(output);
            }
        });

        btnAC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInput.setText("");
            }
        });

        btnDEL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = userInput.getText();
                int l = a.length();
                if (l < 1) {
                    return;
                }
                a = a.substring(0, l - 1);
                userInput.setText(a);
            }
        });
    }

    public Main() {

        draw();
        // main setting
        main.setFont(font);
        main.setSize(340, 450);
        main.setLayout(null);
        main.setVisible(true);
        main.setResizable(false);

        // main add components
        main.add(userInput);
        main.add(outPut);
        main.add(numPanel);

        // main user events
        main.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        // btns user events
        userInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String a = userInput.getText();
                    if (!validInput(a)) {
                        outPut.setText("Syntax Error");
                        return;
                    }
                    String _a = stringHandle(a);
                    String output = userInputHandle(_a);
                    outPut.setText(output);
                }
            }
        });
        userEvents();

    }
}
