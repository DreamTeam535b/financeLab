import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class SwingGUI {

    private JButton createAccountButton, loginButton, transactionButton;
    private JButton submitTransaction, receiveTransaction;
    private JLabel accountStatusLabel;
    private UsersAccounts usersAccounts;
    private User logUser;
    private JFrame frame1;
    public SwingGUI(UsersAccounts usersAccounts) {
        this.usersAccounts = usersAccounts;
        logUser = null;
    }

    public void AccountManagementGUI() {

        frame1 = new JFrame("Financial operations");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(400, 200);
        frame1.setLayout(new GridLayout(4, 1));

        createAccountButton = new JButton("Create Account");
        loginButton = new JButton("Login");
        transactionButton = new JButton("Perform Transaction");
        accountStatusLabel = new JLabel("Status: Not logged in");

        // Добавление панели на первое окно
        createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openCreateAccountWindow();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openLogInWindow();
            }
        });

        transactionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openTransactionWindow();
            }
        });

        frame1.add(createAccountButton);
        frame1.add(loginButton);
        frame1.add(transactionButton);
        frame1.add(accountStatusLabel);
        frame1.pack();
        frame1.setVisible(true);
    }

    private void disableMainButtons() {
        createAccountButton.setEnabled(false);
        loginButton.setEnabled(false);
        transactionButton.setEnabled(false);
    }

    private void enableMainButtons() {
        createAccountButton.setEnabled(true);
        loginButton.setEnabled(true);
        transactionButton.setEnabled(true);
    }

    private void disableTransactionsButtons() {
        submitTransaction.setEnabled(false);
        receiveTransaction.setEnabled(false);
    }

    private void enableTransactionsButtons() {
        submitTransaction.setEnabled(true);
        receiveTransaction.setEnabled(true);
    }

    private void openLogInWindow() {
        disableMainButtons();

        JFrame frameLogIn = new JFrame("LogIn");
        frameLogIn.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameLogIn.setLayout(new GridLayout(6, 1));

        frameLogIn.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                enableMainButtons();
            }
        });

        JLabel userNameLabel = new JLabel("User name: ");
        JTextField userNameField = new JTextField("");
        JLabel passwordLabel = new JLabel("Password: ");
        JPasswordField passwordField = new JPasswordField();
        JLabel infoAboutLogIn = new JLabel("");
        JButton logInButton = new JButton("Log in");

        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (new String(passwordField.getPassword()).equals("") || userNameLabel.getText().equals("")) {
                    infoAboutLogIn.setText("Error! Incorrect data!");
                    infoAboutLogIn.setForeground(Color.RED);
                    frameLogIn.pack();
                    return;
                } else {
                    try {
                        logUser = usersAccounts.getUser(userNameField.getText(), new String(passwordField.getPassword()));
                        infoAboutLogIn.setText("LogIn successfully! ");
                        frameLogIn.pack();
                        accountStatusLabel.setText("Status: Logged in. Username: " + logUser.getUserName());
                        frame1.pack();
                        infoAboutLogIn.setForeground(Color.GREEN);
                    } catch (Exception exception) {
                        infoAboutLogIn.setText("Error!" + exception.getMessage() + " ");
                        infoAboutLogIn.setForeground(Color.RED);
                        frameLogIn.pack();
                        return;
                    }
                }
            }
        });

        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                passwordLabel.setText("Password: ");
                passwordLabel.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (new String(passwordField.getPassword()).equals("")) {
                    passwordLabel.setText("Password: Empty password! ");
                    passwordLabel.setForeground(Color.RED);
                    frameLogIn.pack();
                }
            }
        });

        userNameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                userNameLabel.setText("User name: ");
                userNameLabel.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (userNameField.getText().equals("")) {
                    userNameLabel.setText("User name: Empty user name!");
                    userNameLabel.setForeground(Color.RED);
                    frameLogIn.pack();
                }
            }
        });

        frameLogIn.add(userNameLabel);
        frameLogIn.add(userNameField);
        frameLogIn.add(passwordLabel);
        frameLogIn.add(passwordField);
        frameLogIn.add(infoAboutLogIn);
        frameLogIn.add(logInButton);

        frameLogIn.pack();
        frameLogIn.setVisible(true);
    }


    private void openCreateAccountWindow() {
        disableMainButtons();

        JFrame frameCreateAccount = new JFrame("Create new account");
        frameCreateAccount.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameCreateAccount.setLayout(new GridLayout(6, 1));

        frameCreateAccount.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                enableMainButtons();
            }
        });

        JLabel userNameLabel = new JLabel("User name: ");
        JTextField userNameField = new JTextField("");
        JLabel passwordLabel = new JLabel("Password: ");
        JPasswordField passwordField = new JPasswordField();
        JLabel infoAboutLogIn = new JLabel("");
        JButton logInButton = new JButton("Create account ");

        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (new String(passwordField.getPassword()).equals("") || userNameLabel.getText().equals("")) {
                    infoAboutLogIn.setText("Error! Incorrect data!");
                    infoAboutLogIn.setForeground(Color.RED);
                    frameCreateAccount.pack();
                    return;
                } else {
                    try {
                        usersAccounts.createUser(userNameField.getText(), new String(passwordField.getPassword()));
                        infoAboutLogIn.setText("Account successfully created! ");
                        infoAboutLogIn.setForeground(Color.GREEN);
                        frameCreateAccount.pack();
                    } catch (Exception exception) {
                        infoAboutLogIn.setText("Error!" + exception.getMessage() + " ");
                        infoAboutLogIn.setForeground(Color.RED);
                        frameCreateAccount.pack();
                        return;
                    }
                }
            }
        });

        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                passwordLabel.setText("Password: ");
                passwordLabel.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (new String(passwordField.getPassword()).equals("")) {
                    passwordLabel.setText("Password: Empty password! ");
                    passwordLabel.setForeground(Color.RED);
                    frameCreateAccount.pack();
                }
            }
        });

        userNameField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                userNameLabel.setText("User name: ");
                userNameLabel.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (userNameField.getText().equals("")) {
                    userNameLabel.setText("User name: Empty user name!");
                    userNameLabel.setForeground(Color.RED);
                    frameCreateAccount.pack();
                }
            }
        });

        frameCreateAccount.add(userNameLabel);
        frameCreateAccount.add(userNameField);
        frameCreateAccount.add(passwordLabel);
        frameCreateAccount.add(passwordField);
        frameCreateAccount.add(infoAboutLogIn);
        frameCreateAccount.add(logInButton);

        frameCreateAccount.pack();
        frameCreateAccount.setVisible(true);
    }

    // Метод для открытия второго окна
    private void openTransactionWindow() {
        disableMainButtons();

        JFrame frameTransaction = new JFrame("Transaction");
        frameTransaction.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameTransaction.setSize(600, 600);
        frameTransaction.setLayout(new GridLayout(3, 1));

        frameTransaction.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                enableMainButtons();
            }
        });

        JLabel transactionText = new JLabel("Select type of transaction");
        submitTransaction = new JButton("submit");
        receiveTransaction = new JButton("receive");

        frameTransaction.add(transactionText);
        frameTransaction.add(submitTransaction);
        frameTransaction.add(receiveTransaction);

        submitTransaction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openSubmitWindow();
            }
        });

        receiveTransaction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openReceiveWindow();
            }
        });

        frameTransaction.pack();
        frameTransaction.setVisible(true);
    }

    private void openReceiveWindow() {
        disableTransactionsButtons();

        JFrame receiveFrame = new JFrame("receive transaction");
        receiveFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        receiveFrame.setSize(600, 600);
        receiveFrame.setLayout(new GridLayout(4, 2));

        receiveFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                enableTransactionsButtons();
            }
        });


        JLabel amountLabel = new JLabel("Amount: ");
        JTextField amountField = new JTextField();
        JLabel descriptionLabel = new JLabel("description: ");
        JTextField descriptionField = new JTextField();
        JLabel sourceLabel = new JLabel("source: ");
        JTextField sourceField = new JTextField();
        JLabel receiveLabel = new JLabel("Click to complete ");
        JButton receiveButton = new JButton("Enter ");

        sourceField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                sourceLabel.setText("source: ");
                sourceLabel.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (sourceField.getText().equals("")) {
                    sourceLabel.setText("source: Incorrect! ");
                    sourceLabel.setForeground(Color.RED);
                    receiveFrame.pack();
                }
            }

        });

        descriptionField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                descriptionLabel.setText("description: ");
                descriptionLabel.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (descriptionField.getText().equals("")) {
                    descriptionLabel.setText("description: Incorrect! ");
                    receiveFrame.pack();
                    descriptionLabel.setForeground(Color.RED);
                }


            }

        });

        amountField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                amountLabel.setText("Amount: ");
                amountLabel.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                try {
                    Double.parseDouble(amountField.getText());
                } catch (Exception exception) {
                    amountLabel.setText("Amount: Incorrect! ");
                    receiveFrame.pack();
                    amountLabel.setForeground(Color.RED);

                }
            }
        });

        receiveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount;
                String description;
                String source;

                try {
                    amount = Double.parseDouble(amountField.getText());

                    if (!descriptionField.getText().equals("")) description = descriptionField.getText();
                    else throw new Exception();

                    if (!sourceField.getText().equals("")) source = sourceField.getText();
                    else throw new Exception();

                    logUser.receiveTransaction(amount, description, source);

                    receiveLabel.setForeground(Color.GREEN);
                    receiveLabel.setText("Success! ");
                    amountField.setText("");
                    descriptionField.setText("");
                    sourceField.setText("");
                    receiveFrame.pack();

                } catch (NullPointerException Exception) {
                    receiveLabel.setForeground(Color.RED);
                    receiveLabel.setText("you are not logged in! ");
                    receiveFrame.pack();
                } catch (Exception exception) {
                    receiveLabel.setForeground(Color.RED);
                    receiveLabel.setText("Incorrect data! ");
                    receiveFrame.pack();
                }


            }
        });

        receiveFrame.add(amountLabel);
        receiveFrame.add(amountField);
        receiveFrame.add(descriptionLabel);
        receiveFrame.add(descriptionField);
        receiveFrame.add(sourceLabel);
        receiveFrame.add(sourceField);
        receiveFrame.add(receiveLabel);
        receiveFrame.add(receiveButton);


        receiveFrame.pack();
        receiveFrame.setVisible(true);
    }

    private void openSubmitWindow() {
        disableTransactionsButtons();

        JFrame submitFrame = new JFrame("submit transaction");
        submitFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        submitFrame.setSize(600, 600);
        submitFrame.setLayout(new GridLayout(4, 2));

        submitFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                enableTransactionsButtons();
            }
        });

        JLabel amountLabel = new JLabel("Amount: ");
        JTextField amountField = new JTextField();
        JLabel descriptionLabel = new JLabel("description: ");
        JTextField descriptionField = new JTextField();
        JLabel destinationLabel = new JLabel("destination: ");
        JTextField destinationField = new JTextField();
        JLabel submitLabel = new JLabel("Click to complete ");
        JButton submitButton = new JButton("Enter ");

        destinationField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                destinationLabel.setText("destination: ");
                destinationLabel.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (destinationField.getText().equals("")) {
                    destinationLabel.setText("destination: Incorrect! ");
                    destinationLabel.setForeground(Color.RED);
                    submitFrame.pack();
                }
            }

        });

        descriptionField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                descriptionLabel.setText("description: ");
                descriptionLabel.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (descriptionField.getText().equals("")) {
                    descriptionLabel.setText("description: Incorrect! ");
                    submitFrame.pack();
                    descriptionLabel.setForeground(Color.RED);
                }


            }

        });

        amountField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                amountLabel.setText("Amount: ");
                amountLabel.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                try {
                    Double.parseDouble(amountField.getText());
                } catch (Exception exception) {
                    amountLabel.setText("Amount: Incorrect! ");
                    submitFrame.pack();
                    amountLabel.setForeground(Color.RED);

                }
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount;
                String description;
                String destination;

                try {
                    amount = Double.parseDouble(amountField.getText());

                    if (!descriptionField.getText().equals("")) description = descriptionField.getText();
                    else throw new Exception();

                    if (!destinationField.getText().equals("")) destination = destinationField.getText();
                    else throw new Exception();

                    logUser.submitTransaction(amount, description, destination);

                    submitLabel.setForeground(Color.GREEN);
                    submitLabel.setText("Success! ");
                    amountField.setText("");
                    descriptionField.setText("");
                    destinationField.setText("");
                    submitFrame.pack();

                } catch (NullPointerException Exception) {
                    submitLabel.setForeground(Color.RED);
                    submitLabel.setText("you are not logged in! ");
                    submitFrame.pack();
                } catch (Exception exception) {
                    submitLabel.setForeground(Color.RED);
                    submitLabel.setText("Incorrect data! ");
                    submitFrame.pack();
                }


            }
        });

        submitFrame.add(amountLabel);
        submitFrame.add(amountField);
        submitFrame.add(descriptionLabel);
        submitFrame.add(descriptionField);
        submitFrame.add(destinationLabel);
        submitFrame.add(destinationField);
        submitFrame.add(submitLabel);
        submitFrame.add(submitButton);

        submitFrame.pack();
        submitFrame.setVisible(true);
    }
}
