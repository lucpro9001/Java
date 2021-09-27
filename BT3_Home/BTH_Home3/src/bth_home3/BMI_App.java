/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bth_home3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Admin
 */
public class BMI_App extends Frame {

    final int WIDTH = 1280, HEIGHT = 720;
    final Font fontText = new Font("Courier New", Font.PLAIN, 24);

    Label w = new Label("Cân nặng(kg): "), h = new Label("Chiều cao(m): "), title = new Label("Trợ lý BMI", Label.CENTER);
    TextField weight = new TextField(), height = new TextField();
    TextArea outPut = new TextArea();

    buttonClick pt = new buttonClick("Phân tích");

    public BMI_App(String a) {
        super(a);
        draw();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    class buttonClick extends Button implements ActionListener {

        public buttonClick(String a) {
            super(a);
            addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent arg0) {
            String text = arg0.getActionCommand();
            if (!validInput()) {
                return;
            }
            switch (text) {
                case "Phân tích":
                    PhanTich();
                    break;
            }
        }

        void PhanTich() {

            String w = weight.getText();
            String h = height.getText();
            double weigthNeed = 0;
            double he = Double.parseDouble(h);
            double we = Double.parseDouble(w);
            double BMI = we / (he * 2);
            outPut.setText(String.valueOf(BMI));
            if (BMI < 18.5) {
                weigthNeed = 18.5 * 2 * he - we;
                dangerMess("Loại: Gầy\nCần tăng thêm " + weigthNeed + " Kg nữa để được loại BÌNH THƯỜNG");
            } else if (BMI < 25) {
                succMess("Loại: Bình thường\nCố gắng duy trì thể trạng nhé :3");
            } else if (BMI < 30) {
                weigthNeed = we - 24.9 * 2 * he;
                warnMess("Loại: Tăng cân\nCần giảm thêm " + weigthNeed + " Kg nữa để được loại BÌNH THƯỜNG");
            } else {
                weigthNeed = we - 24.9 * 2 * he;
                dangerMess("Loại: Béo phì\nCần giảm thêm " + weigthNeed + " Kg nữa để được loại BÌNH THƯỜNG");
            }
        }

        boolean validInput() {
            if (emtyField(weight)) {
                return false;
            }
            if (emtyField(height)) {
                return false;
            }
            try {
                String w = weight.getText();
                String h = height.getText();
                double pw = Double.parseDouble(w);
                double ph = Double.parseDouble(h);
            } catch (NumberFormatException e) {
                warnMess("Some fields is not a number!");
                return false;
            }
            return true;
        }

        boolean emtyField(TextField a) {
            String w = a.getText();
            if (w.isEmpty()) {
                a.setCaretPosition(Integer.MAX_VALUE);
                a.requestFocus();
                warnMess("Some fields is emty");
                return true;
            } else {
                outPut.setForeground(Color.BLACK);
                return false;
            }
        }

        void dangerMess(String a) {
            outPut.setForeground(Color.red);
            outPut.setText(a);
        }

        void warnMess(String a) {
            outPut.setForeground(Color.orange);
            outPut.setText(a);
        }

        void succMess(String a) {
            outPut.setForeground(Color.GREEN);
            outPut.setText(a);
        }
    }

    private void draw() {
        // 
        setFont(fontText);
        setVisible(true);
        setBounds(0, 0, WIDTH, HEIGHT);

        // 
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 0, 5, 0);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(w, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(h, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.ipadx = 150;
        gbc.ipady = 5;
        add(weight, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(height, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 50, 0);
        gbc.gridwidth = 2;
        add(title, gbc);

        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.gridx = 0;
        gbc.gridy = 3;
        outPut.setEditable(false);
        add(outPut, gbc);

        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(pt, gbc);
    }

}
