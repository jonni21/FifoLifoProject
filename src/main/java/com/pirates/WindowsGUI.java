package com.pirates;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * Created by Wrong on 27.01.2016.
 *
 */
public class WindowsGUI {

    JPanel panel;
    JTextArea area;
    JTextField inputText;
    JScrollPane jScrollPane;

    JRadioButton lifoRadioButton;
    JRadioButton fifoRadioButton;
    ButtonGroup buttonGroupRadio;
    JButton buttonPrint;
    JButton buttonAdd;
    AbstractQueue queue = new LIFO();

    String input;

    void startGUI() {
        JFrame frame = new JFrame("Pirates | FIFO LIFO Structure");
        frame.setSize(300, 450);
        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        //Команда для завершения программы при закрытии окна
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        Font font = new Font("AppleGothic", Font.BOLD, 14);
        Font footerFont = new Font("AppleGothic", Font.ITALIC, 12);


        //Текстовое поле
        inputText = new JTextField(20);

        area = new JTextArea();
        area.setColumns(20);
        area.setRows(10);
        jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(area);

        // Кнопки
        buttonAdd = new JButton("Push");
        buttonAdd.addActionListener(new AddElement());


        JButton buttonPop = new JButton("Pop");
        buttonPop.addActionListener(new PopElement());


        buttonPrint = new JButton("Print");
        buttonPrint.addActionListener(new PrintStack());


        JButton buttonClear = new JButton("Peek");
        buttonClear.addActionListener(new PeekElement());


        //RadioButtons
        lifoRadioButton = new JRadioButton("LIFO", true);
        lifoRadioButton.addActionListener(new LifoRadioButton());
        lifoRadioButton.setFont(font);


        fifoRadioButton = new JRadioButton("FIFO");
        fifoRadioButton.addActionListener(new FifoRadioButton());
        fifoRadioButton.setFont(font);

        buttonGroupRadio = new ButtonGroup();
        buttonGroupRadio.add(lifoRadioButton);
        buttonGroupRadio.add(fifoRadioButton);


        JLabel logo = new JLabel("LIFO | FIFO Structure");
        JLabel logo1 = new JLabel("Group #11 - Pirates of Java Island");
        JLabel footer = new JLabel("Pirates Crew:");
        JLabel footer1 = new JLabel("Evgeniy Zvezdovskiy, Alexander Panadiy");
        JLabel footer2 = new JLabel("Stanislav Simanich, Alexander Volosyk");
        JLabel footer3 = new JLabel("Egor Salenko");
        JLabel mentor = new JLabel("| Mentor: Alexey Slivets");
        footer.setFont(footerFont);
        mentor.setFont(footerFont);
        logo.setFont(font);
        logo1.setFont(font);

        panel.setLayout(new FlowLayout());
        frame.getContentPane().add(panel);
        panel.setFont(font);
        panel.add(logo);
        panel.add(logo1);
        panel.add(lifoRadioButton);
        panel.add(fifoRadioButton);
        panel.add(inputText);
        panel.add(buttonAdd);
        panel.add(buttonPop);
        panel.add(buttonPrint);
        panel.add(buttonClear);
        panel.add(jScrollPane);
        panel.add(footer);
        panel.add(footer1);
        panel.add(footer2);
        panel.add(footer3);
        panel.add(mentor);

    }


    // Реализация классов Listener для установки  команд при использовании эллментов кнопок/переключателей

    private class AddElement implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            input = inputText.getText();
            queue.push(input);
            if(e.getSource() == buttonAdd) {
                inputText.setText(null);
            }
        }
    }

    private class PopElement implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            area.append(queue.pop() + "\n");
        }
    }
    private class PeekElement implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            area.append(queue.peek()+"\n");
        }
    }

    private class PrintStack implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for(String f : queue.arr){
                if(f != null) {
                    area.append(String.valueOf(f) + "\n");
                }else{
                    break;
                }
            }
        }
    }

    private class LifoRadioButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            queue = new LIFO();
            queue.clear();
        }
    }

    private class FifoRadioButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            queue = new FIFO();
            queue.clear();
        }
    }

}


