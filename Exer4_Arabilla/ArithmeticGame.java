import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Random;

public class ArithmeticGame extends JFrame {

    private String name; 

    private JLabel num1, op, num2, eq;
    private JTextField ansField;
    private JButton subBtn;
    private JLabel correctLabel, incorrectLabel;
    private ButtonGroup opGroup, lvlGroup; 
    private JPanel mainP; 

    private int currentN1, currentN2, correctAns;
    private char currentOp;
    private int correctC = 0;
    private int incorrectC = 0;
    private int qAnswered = 0;
    private int totalQ = 10; 
    private Random rand = new Random();
    private Color lightG = new Color(220, 255, 220); 
    private Color darkT = Color.BLACK; 

    public ArithmeticGame() {
        super("Arithmetic Game"); 

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 450); 
        setLocationRelativeTo(null); 

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        getNameInput();
        if (name == null || name.trim().isEmpty()) {
            name = "Guest"; 
        }
        setTitle("Arithmetic Game - Player: " + name); 

        mainP = new JPanel(new BorderLayout(15, 15)); 
        mainP.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 
        mainP.setBackground(lightG); 

        JPanel probP = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10)); 
        probP.setBorder(BorderFactory.createTitledBorder("Solve This!"));
        probP.setBackground(lightG); 

        Font probFont = new Font("SansSerif", Font.BOLD, 48); 
        num1 = new JLabel("?");
        num1.setFont(probFont);
        num1.setForeground(darkT); 
        op = new JLabel("+");
        op.setFont(probFont);
        op.setForeground(darkT); 
        num2 = new JLabel("?");
        num2.setFont(probFont);
        num2.setForeground(darkT); 
        eq = new JLabel("=");
        eq.setFont(probFont);
        eq.setForeground(darkT); 

        ansField = new JTextField(5); 
        ansField.setFont(probFont);
        ansField.setHorizontalAlignment(JTextField.CENTER);
        ansField.addActionListener(e -> handleSubmit());

        probP.add(num1);
        probP.add(op);
        probP.add(num2);
        probP.add(eq);
        probP.add(ansField);

        mainP.add(probP, BorderLayout.NORTH);

        JPanel centerP = new JPanel(new GridLayout(1, 2, 20, 0)); 
        centerP.setBackground(lightG);
        
        JPanel opP = new JPanel(new GridLayout(5, 1, 0, 5)); 
        opP.setBorder(BorderFactory.createTitledBorder("Operations"));
        opP.setBackground(lightG);
        
        Font btnFont = new Font("SansSerif", Font.PLAIN, 14);
        
        opGroup = new ButtonGroup(); 
        JRadioButton addBtn = new JRadioButton("Addition", true); 
        JRadioButton subRB = new JRadioButton("Subtraction");
        JRadioButton mulBtn = new JRadioButton("Multiplication");
        JRadioButton divBtn = new JRadioButton("Division");
        JRadioButton modBtn = new JRadioButton("Modulo");
        
        ActionListener controlL = e -> {
            resetGame();
            newQ();
        };
        JRadioButton[] opBtns = {addBtn, subRB, mulBtn, divBtn, modBtn};
        for (JRadioButton btn : opBtns) {
            btn.addActionListener(controlL);
            btn.setBackground(lightG);
            btn.setForeground(darkT);
            btn.setFont(btnFont);
            opGroup.add(btn);
            opP.add(btn);
        }

        JPanel lvlP = new JPanel(new GridLayout(4, 1, 0, 5)); 
        lvlP.setBorder(BorderFactory.createTitledBorder("Difficulty Level"));
        lvlP.setBackground(lightG);
        lvlGroup = new ButtonGroup();
        
        JRadioButton lvl1 = new JRadioButton("Level 1 (1-10)", true); 
        JRadioButton lvl2 = new JRadioButton("Level 2 (11-100)");
        JRadioButton lvl3 = new JRadioButton("Level 3 (101-500)");

        JRadioButton[] lvlBtns = {lvl1, lvl2, lvl3};
        for (JRadioButton btn : lvlBtns) {
            btn.addActionListener(controlL);
            btn.setBackground(lightG);
            btn.setForeground(darkT);
            btn.setFont(btnFont);
            lvlGroup.add(btn);
            lvlP.add(btn);
        }

        centerP.add(opP);
        centerP.add(lvlP);
        
        mainP.add(centerP, BorderLayout.CENTER);

        JPanel rightP = new JPanel(new BorderLayout(0, 10)); 
        rightP.setBackground(lightG);

        subBtn = new JButton("Submit");
        subBtn.setFont(new Font("SansSerif", Font.BOLD, 18));
        subBtn.addActionListener(e -> handleSubmit()); 
        
        JPanel btnWrap = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnWrap.setBackground(lightG);
        btnWrap.add(subBtn);

        JPanel scoreP = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5)); 
        scoreP.setBorder(BorderFactory.createTitledBorder("Score"));
        scoreP.setBackground(lightG);
        
        Font scoreFont = new Font("SansSerif", Font.PLAIN, 16);
        
        JLabel corLabel = new JLabel("Correct: ");
        corLabel.setForeground(darkT);
        scoreP.add(corLabel);
        
        correctLabel = new JLabel("0");
        correctLabel.setFont(scoreFont);
        correctLabel.setForeground(new Color(34, 139, 34)); 
        scoreP.add(correctLabel);

        scoreP.add(Box.createHorizontalStrut(20)); 

        JLabel incorLabel = new JLabel("Incorrect: ");
        incorLabel.setForeground(darkT);
        scoreP.add(incorLabel);
        
        incorrectLabel = new JLabel("0");
        incorrectLabel.setFont(scoreFont);
        incorrectLabel.setForeground(new Color(220, 20, 60)); 
        scoreP.add(incorrectLabel);

        rightP.add(btnWrap, BorderLayout.NORTH);
        rightP.add(scoreP, BorderLayout.CENTER);

        mainP.add(rightP, BorderLayout.EAST);

        add(mainP);

        resetGame();
        newQ();

        setVisible(true);
    }

    private String getSelBtnTxt(ButtonGroup group) {
        for (Enumeration<AbstractButton> btns = group.getElements(); btns.hasMoreElements();) {
            AbstractButton btn = btns.nextElement();
            if (btn.isSelected()) {
                return btn.getText();
            }
        }
        return ""; 
    }

    private JPanel makeCustomPanel(Object content) {
        JPanel p = new JPanel(new BorderLayout(10, 10));
        p.setBackground(lightG);
        p.add(new JLabel(" "), BorderLayout.NORTH); 
        p.add(new JLabel(" "), BorderLayout.SOUTH); 
        p.add(new JLabel("  "), BorderLayout.WEST); 
        p.add(new JLabel("  "), BorderLayout.EAST); 

        JPanel contP = new JPanel(new BorderLayout());
        contP.setBackground(lightG);

        if (content instanceof String) {
            JLabel msg = new JLabel("<html><body style='width: 250px;'>"+(String)content+"</body></html>", SwingConstants.CENTER);
            msg.setForeground(darkT);
            msg.setFont(new Font("SansSerif", Font.PLAIN, 14));
            contP.add(msg, BorderLayout.CENTER);
        } else if (content instanceof JComponent) {
            contP.add((JComponent) content, BorderLayout.CENTER);
        }
        
        p.add(contP, BorderLayout.CENTER);
        return p;
    }

    private void getNameInput() {
        JTextField nameF = new JTextField(15);
        nameF.setFont(new Font("SansSerif", Font.PLAIN, 18));
        
        JLabel msgL = new JLabel("Welcome to Arithmetic Game! Please enter your name:");
        msgL.setForeground(darkT);
        msgL.setBackground(lightG);
        
        JPanel inputP = new JPanel(new GridLayout(2, 1, 0, 10));
        inputP.setBackground(lightG);
        inputP.add(msgL);
        inputP.add(nameF);

        int result = JOptionPane.showConfirmDialog(this, 
                                                 makeCustomPanel(inputP), 
                                                 "Name", 
                                                 JOptionPane.OK_CANCEL_OPTION, 
                                                 JOptionPane.PLAIN_MESSAGE); 

        if (result == JOptionPane.OK_OPTION) {
            name = nameF.getText();
        } else {
            name = "Guest";
        }
    }
    
    private void resetGame() {
        correctC = 0;
        incorrectC = 0;
        qAnswered = 0;
        correctLabel.setText("0");
        incorrectLabel.setText("0");

        String lvlT = getSelBtnTxt(lvlGroup);
        if (lvlT.contains("1-10")) {
            totalQ = 10;
        } else if (lvlT.contains("11-100")) {
            totalQ = 100;
        } else if (lvlT.contains("101-500")) {
            totalQ = 500;
        }
        
        subBtn.setEnabled(true); 
    }

    private void newQ() {
        String opT = getSelBtnTxt(opGroup); 
        String lvlT = getSelBtnTxt(lvlGroup); 

        int min, max; 
        
        if (lvlT.contains("1-10")) {
            min = 1; max = 10;
        } else if (lvlT.contains("11-100")) {
            min = 11; max = 100; 
        } else if (lvlT.contains("101-500")) {
            min = 101; max = 500; 
        } else {
             min = 1; max = 10; 
        }
        
        currentN1 = rand.nextInt(max - min + 1) + min;
        currentN2 = rand.nextInt(max - min + 1) + min;

        if (opT.equals("Division") || opT.equals("Modulo")) {
            if (currentN2 == 0) currentN2 = 1; 
            
            if (opT.equals("Division")) {
                int divisor = currentN2;
                int maxQ = max / divisor;
                int minQ = 1; 
                
                if (maxQ < min) { 
                    minQ = 1; maxQ = max;
                } else if (min > 1) {
                    minQ = min;
                }

                int quotient = rand.nextInt(maxQ - minQ + 1) + minQ;
                currentN1 = divisor * quotient; 
                currentN2 = divisor;
            }
        } else if (opT.equals("Subtraction")) {
            if (currentN1 < currentN2) {
                int temp = currentN1;
                currentN1 = currentN2;
                currentN2 = temp;
            }
        }

        switch (opT) {
            case "Addition":
                currentOp = '+';
                correctAns = currentN1 + currentN2;
                break;
            case "Subtraction":
                currentOp = '-';
                correctAns = currentN1 - currentN2;
                break;
            case "Multiplication":
                currentOp = 'x';
                correctAns = currentN1 * currentN2;
                break;
            case "Division":
                currentOp = '÷';
                if (currentN2 == 0) currentN2 = 1; 
                correctAns = currentN1 / currentN2;
                break;
            case "Modulo":
                currentOp = '%';
                if (currentN2 == 0) currentN2 = 1; 
                correctAns = currentN1 % currentN2;
                break;
        }

        num1.setText(String.valueOf(currentN1));
        op.setText(String.valueOf(currentOp));
        num2.setText(String.valueOf(currentN2));
        ansField.setText(""); 
        ansField.requestFocusInWindow(); 
    }

    private void handleSubmit() {
        if (qAnswered >= totalQ) {
             JOptionPane.showMessageDialog(this, makeCustomPanel("The quiz is complete! Please select a new level or operation to restart."), "Quiz Complete", JOptionPane.INFORMATION_MESSAGE);
             return;
        }

        String ansT = ansField.getText();
        if (ansT.isEmpty()) {
            JOptionPane.showMessageDialog(this, makeCustomPanel("Please enter an answer!"), "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int userAns = Integer.parseInt(ansT);
            qAnswered++;

            if (userAns == correctAns) {
                correctC++;
                correctLabel.setText(String.valueOf(correctC));
                JOptionPane.showMessageDialog(this, makeCustomPanel("Your answer is correct!"), "Correct!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                incorrectC++;
                incorrectLabel.setText(String.valueOf(incorrectC));
                String wrongMsg = "Wrong! The correct answer is " + correctAns;
                JOptionPane.showMessageDialog(this, makeCustomPanel(wrongMsg), "Incorrect", JOptionPane.ERROR_MESSAGE);
            }
            
            if (qAnswered >= totalQ) {
                showScore();
            } else {
                newQ(); 
            }
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, makeCustomPanel("Please enter a valid number."), "Input Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void showScore() {
        String msg = String.format(
            "Quiz finished, %s. Your total score is: %d/%d",
            name, correctC, totalQ
        );
        
        JOptionPane.showMessageDialog(this, makeCustomPanel(msg), "Overall Score", JOptionPane.INFORMATION_MESSAGE);
        
        subBtn.setEnabled(false); 
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ArithmeticGame());
    }
}