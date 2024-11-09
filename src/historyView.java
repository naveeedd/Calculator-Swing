import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;
import java.util.Objects;


public class historyView extends JFrame {


    private JPanel Calculator;
    private JTextField txtDisplay;
    private JButton a5Button;
    private JButton a4Button;
    private JButton a3Button;
    private JButton a2Button;
    private JButton a1Button;
    private JButton divbutton;
    private JButton percentbutton;
    private JButton multiplybutton;
    private JButton a1XButton;
    private JButton button14;
    private JButton a9Button;
    private JButton a6Button;
    private JButton a0Button;
    private JButton a7Button;
    private JButton a8Button;
    private JButton decbutton;
    private JButton addbutton;
    private JButton equalbutton;
    private JButton rootbutton;
    private JButton idkbutton2;
    private JButton cButton;
    private JButton CEButton;
    private JButton backbutton;
    private JButton mcButton;
    private JButton MRButton;
    private JButton MSButton;
    private JButton mButton;
    private JButton mButton1;
    private JTextArea historyDisplay;
    private StringBuilder currentExpression = new StringBuilder();

    public JMenuBar MenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu viewMenu = new JMenu("View");

        JRadioButtonMenuItem standardMode = new JRadioButtonMenuItem("Standard");
        JRadioButtonMenuItem scientificMode = new JRadioButtonMenuItem("Scientific");
        JRadioButtonMenuItem programmerMode = new JRadioButtonMenuItem("Programmer");
        JRadioButtonMenuItem statisticsMode = new JRadioButtonMenuItem("Statistics");

        ButtonGroup group = new ButtonGroup();
        group.add(standardMode);
        group.add(scientificMode);
        group.add(programmerMode);
        group.add(statisticsMode);
        standardMode.addActionListener(e -> {
            openNewPage("calculator");
        });

        scientificMode.addActionListener(e -> {
            openNewPage("Scientific");
        });

        programmerMode.addActionListener(e -> {
            openNewPage("programmer");

        });

        statisticsMode.addActionListener(e -> {
            openNewPage("statistics");

        });


        JMenuItem history = new JMenuItem("History");
        history.addActionListener(e -> {
            openNewPage("history");

        });

        JMenuItem digitGrouping = new JMenuItem("Digit grouping");
        digitGrouping.addActionListener(e -> {
            openNewPage("calculator");

        });

        JMenuItem basicWorksheet = new JMenuItem("Basic");
        basicWorksheet.addActionListener(e -> {
            openNewPage("calculator");
        });

        JMenuItem unitConversion = new JMenuItem("Unit conversion");
        unitConversion.addActionListener(e -> {
            openNewPage("unit");
        });

        JMenuItem dateCalculation = new JMenuItem("Date calculation");
        dateCalculation.addActionListener(e -> {
            openNewPage("date");
        });

        JRadioButtonMenuItem mortgage = new JRadioButtonMenuItem("Mortgage");
        dateCalculation.addActionListener(e -> {
            openNewPage("mortgage");
        });

        JRadioButtonMenuItem lease = new JRadioButtonMenuItem("Vehicle Lease");
        dateCalculation.addActionListener(e -> {
            openNewPage("lease");
        });

        JRadioButtonMenuItem mpg = new JRadioButtonMenuItem("Fuel economy (mpg)");
        dateCalculation.addActionListener(e -> {
            openNewPage("mpg");
        });

        JRadioButtonMenuItem km = new JRadioButtonMenuItem("Fuel economy (L/100 lm)");
        dateCalculation.addActionListener(e -> {
            openNewPage("km");
        });

        JMenu worksheetsMenu = new JMenu("Worksheets");

        worksheetsMenu.add(mortgage);
        worksheetsMenu.add(lease);
        worksheetsMenu.add(mpg);
        worksheetsMenu.add(km);


        viewMenu.add(standardMode);
        viewMenu.add(scientificMode);
        viewMenu.add(programmerMode);
        viewMenu.add(statisticsMode);
        viewMenu.addSeparator();
        viewMenu.add(history);
        viewMenu.add(digitGrouping);
        viewMenu.addSeparator();
        viewMenu.add(worksheetsMenu);

        JMenu editMenu = new JMenu("Edit");

        JMenuItem copyItem = new JMenuItem("Copy");
        copyItem.addActionListener(e -> {
            openNewPage("calculator");


        });

        JMenuItem pasteItem = new JMenuItem("Paste");
        pasteItem.addActionListener(e -> {
            openNewPage("calculator");


        });

        JMenuItem editHistoryItem = new JMenuItem("History");
        editHistoryItem.addActionListener(e -> {
            openNewPage("history");

        });


        editMenu.add(copyItem);
        editMenu.add(pasteItem);
        editMenu.addSeparator();
        editMenu.add(editHistoryItem);

        JMenu helpMenu = new JMenu("Help");

        JMenuItem viewHelpItem = new JMenuItem("View Help");
        viewHelpItem.addActionListener(e -> {
            openNewPage("calculator");


        });

        JMenuItem aboutCalculatorItem = new JMenuItem("About Calculator");
        aboutCalculatorItem.addActionListener(e -> {
            openNewPage("calculator");


        });


        helpMenu.add(viewHelpItem);
        helpMenu.addSeparator();
        helpMenu.add(aboutCalculatorItem);

        menuBar.add(viewMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        return menuBar;
    }

    private void openNewPage(String pageTitle) {

        switch (pageTitle) {
            case "Scientific" -> {
                new scientificView();
                dispose();
            }
            case "programmer" -> {
                new programmerView();
                dispose();
            }
            case "statistics" -> {
                new statisticView();
                dispose();
            }
            case "history" -> {
                HistoryManager historyManager = HistoryManager.getInstance();
                String historyText = String.join("\n", historyManager.getHistory());
                historyDisplay.setText(historyText);
            }
            case "calculator" -> {
                new Calculator();
                dispose();
            }
            case "unit" -> {
                new Unitview();
                dispose();
            }
            case "date" -> {
                new dateView();
                dispose();
            }
            case "mortgage" ->{
                new mortgageView();
                dispose();
            }
            case "lease" -> {
                new leaseView();
                dispose();
            }
            case "mpg" ->{
                new fuelmpgView();
                dispose();
            }
            case "km" -> {
                new fuelkmView();
                dispose();
            }

            default -> dispose();
        }

    }


    double a,b,result , value;
    String op;
    StringBuilder history = new StringBuilder();
    public historyView() {
        historyDisplay.setText(HistoryManager.getInstance().getHistory());
        setTitle("Calculator");
        setJMenuBar(MenuBar());
        setContentPane(Calculator);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        CEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText("");
            }
        });
        a0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText(txtDisplay.getText() + a0Button.getText());
            }
        });
        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText(txtDisplay.getText() + a1Button.getText());
            }
        });
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText(txtDisplay.getText() + a2Button.getText());
            }
        });
        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText(txtDisplay.getText() + a3Button.getText());
            }
        });
        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText(txtDisplay.getText() + a4Button.getText());
            }
        });
        a5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText(txtDisplay.getText() + a5Button.getText());
            }
        });
        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText(txtDisplay.getText() + a6Button.getText());
            }
        });
        a7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText(txtDisplay.getText() + a7Button.getText());
            }
        });
        a8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText(txtDisplay.getText() + a8Button.getText());
            }
        });
        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtDisplay.setText(txtDisplay.getText() + a9Button.getText());
            }
        });
        idkbutton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtDisplay.getText().contains(".")) {
                    double pm = Double.parseDouble(txtDisplay.getText());
                    pm = pm * -1;
                    txtDisplay.setText(String.valueOf(pm));
                }
                else {
                    long PM = Long.parseLong(txtDisplay.getText());
                    PM=PM*-1;
                    txtDisplay.setText(String.valueOf(PM));
                }
            }
        });
        decbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!txtDisplay.getText().contains(".")){
                    currentExpression.append(txtDisplay.getText()).append(" . ");
                    txtDisplay.setText(txtDisplay.getText()+ decbutton.getText());
                }
            }
        });
        addbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a = Double.parseDouble(txtDisplay.getText());
                op="+";
                currentExpression.append(a).append(" + ");
                txtDisplay.setText("");
            }
        });
        button14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a = Double.parseDouble(txtDisplay.getText());
                op="-";
                currentExpression.append(a).append(" - ");
                System.out.println(HistoryManager.getInstance().getHistory());
                txtDisplay.setText("");
            }
        });
        divbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a = Double.parseDouble(txtDisplay.getText());
                op="/";
                currentExpression.append(a).append(" / ");
                txtDisplay.setText("");
            }
        });
        multiplybutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a = Double.parseDouble(txtDisplay.getText());
                op="*";
                currentExpression.append(a).append(" * ");
                txtDisplay.setText("");
            }
        });
        backbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String backspace = null;
                if (!txtDisplay.getText().isEmpty()){
                    StringBuilder strb= new StringBuilder(txtDisplay.getText());
                    strb.deleteCharAt(txtDisplay.getText().length() - 1);
                    backspace = String.valueOf(strb);
                    txtDisplay.setText(backspace);
                }
            }
        });
        equalbutton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                b= Double.parseDouble(txtDisplay.getText());
                if (Objects.equals(op, "+")){
                    result=a+b;
                    currentExpression.append(b).append(" = ").append(result);
                    txtDisplay.setText(String.valueOf(result));
                } else if (Objects.equals(op, "-")) {
                    result=a-b;
                    currentExpression.append(b).append(" = ").append(result);
                    txtDisplay.setText(String.valueOf(result));
                }else if (Objects.equals(op, "*")) {
                    result=a*b;
                    currentExpression.append(b).append(" = ").append(result);
                    txtDisplay.setText(String.valueOf(result));
                }else if (Objects.equals(op, "/")) {
                    if (b==0){
                        txtDisplay.setText("Error");
                    }
                    result=a/b;
                    currentExpression.append(b).append(" = ").append(result);
                    txtDisplay.setText(String.valueOf(result));
                }
                HistoryManager.getInstance().addToHistory(currentExpression.toString());
                currentExpression.setLength(0);
            }
        });
        percentbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value = Double.parseDouble(txtDisplay.getText());
                txtDisplay.setText(String.valueOf(value / 100));
            }
        });
        cButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a = 0;
                b = 0;
                txtDisplay.setText("");
            }
        });
        rootbutton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                value = Double.parseDouble(txtDisplay.getText());
                txtDisplay.setText(String.valueOf(Math.sqrt(value)));
            }
        });
        a1XButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                value = Double.parseDouble(txtDisplay.getText());
                txtDisplay.setText(String.valueOf(1 / value));
            }
        });
    }

    public static void main(String[] args) {
        historyView cal = new historyView();

    }
}