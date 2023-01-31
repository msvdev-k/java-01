package com.geekbrains.less08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp extends JFrame {

    private final ISimpleCalculatorModel calcModel;


    public CalculatorApp(ISimpleCalculatorModel model) {

        calcModel = model;

        setBounds(500, 500, 240, 320);
        setTitle("Калькулятор");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        initUI();
        setVisible(true);
    }


    /**
     * Инициализация интерфейса пользователя.
     */
    private void initUI() {

        Font font = new Font("Arial", Font.BOLD, 32);

        // =================================================================
        // Создание элементов управления, и определение действий пользователя

        JLabel display = new JLabel();
        display.setFont(font);
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setText("0");

        JButton[] digits = new JButton[10];
        for (int i = 0; i < 10; i++) {
            digits[i] = new JButton(String.valueOf(i));
            digits[i].setFont(font);
            digits[i].addActionListener(new InsertDigitAction(i, display));
        }

        JButton btnPoint = new JButton(".");
        btnPoint.setFont(font);
        btnPoint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcModel.addPoint();
                display.setText(calcModel.getDisplayText());
            }
        });

        JButton btnClear = new JButton("C");
        btnClear.setFont(font);
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcModel.clear();
                display.setText(calcModel.getDisplayText());
            }
        });

        JButton btnMult = new JButton("*");
        btnMult.setFont(font);
        btnMult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcModel.multiplication();
                display.setText(calcModel.getDisplayText());
            }
        });

        JButton btnDiv = new JButton("/");
        btnDiv.setFont(font);
        btnDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcModel.division();
                display.setText(calcModel.getDisplayText());
            }
        });

        JButton btnAdd = new JButton("+");
        btnAdd.setFont(font);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcModel.addition();
                display.setText(calcModel.getDisplayText());
            }
        });

        JButton btnSub = new JButton("-");
        btnSub.setFont(font);
        btnSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcModel.subtraction();
                display.setText(calcModel.getDisplayText());
            }
        });

        JButton btnCalc = new JButton("=");
        btnCalc.setFont(font);
        btnCalc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcModel.calculation();
                display.setText(calcModel.getDisplayText());
            }
        });


        // =========================================
        // Расстановка элементов управления по сетке

        setLayout(new GridBagLayout());

        GridBagConstraints cons = new GridBagConstraints();

        cons.fill = GridBagConstraints.BOTH;

        cons.gridwidth = 4;
        cons.gridx     = 0;
        cons.gridy     = 0;
        add(display, cons);

        cons.gridwidth = 1;
        cons.gridy     = 1;

        cons.gridx     = 0;
        add(btnClear, cons);

        cons.gridx     = 1;
        add(btnDiv, cons);

        cons.gridx     = 2;
        add(btnMult, cons);

        cons.gridx     = 3;
        add(btnSub, cons);


        cons.gridy     = 2;

        cons.gridx     = 0;
        add(digits[7], cons);

        cons.gridx     = 1;
        add(digits[8], cons);

        cons.gridx     = 2;
        add(digits[9], cons);


        cons.gridy     = 3;

        cons.gridx     = 0;
        add(digits[4], cons);

        cons.gridx     = 1;
        add(digits[5], cons);

        cons.gridx     = 2;
        add(digits[6], cons);


        cons.gridy     = 4;

        cons.gridx     = 0;
        add(digits[1], cons);

        cons.gridx     = 1;
        add(digits[2], cons);

        cons.gridx     = 2;
        add(digits[3], cons);


        cons.gridheight = 2;
        cons.gridx      = 3;
        cons.gridy      = 2;
        add(btnAdd, cons);

        cons.gridx      = 3;
        cons.gridy      = 4;
        add(btnCalc, cons);


        cons.gridwidth  = 2;
        cons.gridheight = 1;
        cons.gridx      = 0;
        cons.gridy      = 5;
        add(digits[0], cons);


        cons.gridwidth  = 1;
        cons.gridheight = 1;
        cons.gridx      = 2;
        cons.gridy      = 5;
        add(btnPoint, cons);

    }

    /**+
     * Обработка события ввода цифры.
     */
    private class InsertDigitAction implements ActionListener {

        private final int digit;
        JLabel display;

        public InsertDigitAction(int digit, JLabel display) {
            this.digit = digit;
            this.display = display;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            calcModel.addDigit(digit);
            display.setText(calcModel.getDisplayText());
        }
    }

}
