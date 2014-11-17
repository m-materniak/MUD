package com.mud.client;

	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.Dimension;
	import java.awt.FlowLayout;
	import java.awt.Font;
	import java.awt.Rectangle;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.FocusEvent;
	import java.awt.event.FocusListener;
	import java.awt.event.KeyEvent;
	import java.awt.event.KeyListener;
	import java.io.FilterOutputStream;
	import java.io.IOException;
	import java.io.InputStream;
	import java.io.OutputStream;
	import java.io.PrintStream;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	import javax.swing.JPasswordField;
	import javax.swing.JScrollPane;
	import javax.swing.JTextArea;
	import javax.swing.JTextField;
	import javax.swing.text.BadLocationException;

	import org.apache.commons.net.telnet.TelnetClient;

	public class SwingTelnetClient extends JFrame {
	    private static final long serialVersionUID = 1L;
	    JLabel lblServer = new JLabel();
	    JLabel lblUserId = new JLabel();
	    JLabel lblPassword = new JLabel();
	    JButton btnConnect = new JButton();
	    JButton btnDisconnect = new JButton();
	    JTextField txtServer = new JTextField();
	    JTextField txtUserId = new JTextField();
	    JPasswordField txtPassword = new JPasswordField();
	    JLabel lblCommand = new JLabel();
	    JTextArea txtConsole = new JTextArea();
	    JTextField txtCommand = new JTextField();
	    JScrollPane scrollPane = new JScrollPane();

	    PrintStream consolePrintStream = null;
	    MyTelnetClient client;

	    public SwingTelnetClient() {
	        setTitle("Simple Telnet Client");

	        JPanel panel = createMainPanel();
	        addListeners();
	        this.setPreferredSize(new Dimension(800, 400));
	        this.getContentPane().add(panel);
	    }

	    private JPanel createMainPanel() {

	        JPanel panel = new JPanel();
	        panel.setLayout(new BorderLayout());

	        panel.add(createTopPanel(), BorderLayout.NORTH);

	        txtConsole.setColumns(50);
	        txtConsole.setSize(300, 300);
	        txtConsole.setBackground(Color.black);
	        txtConsole.setForeground(Color.green);
	        txtConsole.setFont(new Font("Terminal", 0, 16));
	        txtConsole.setFocusable(false);
	        scrollPane.getViewport().add(txtConsole);

	        panel.add(scrollPane, BorderLayout.CENTER);
	        panel.add(createBottomPanel(), BorderLayout.SOUTH);

	        return panel;
	    }

	    private void addListeners() {
	        btnConnect.addActionListener(new ActionListener() {

	            public void actionPerformed(ActionEvent e) {
	                client = new MyTelnetClient(txtServer.getText());

	                consolePrintStream = new PrintStream(new FilteredStream(client.getOut()));
	                System.setErr(consolePrintStream);
	                System.setOut(consolePrintStream);

	                client.connect(txtUserId.getText(), txtPassword.getText());

	                txtCommand.requestFocus();

	            }
	        });

	        btnDisconnect.addActionListener(new ActionListener() {

	            public void actionPerformed(ActionEvent e) {
	                client.disconnect();
	                txtConsole.setText("Disconnected");
	                txtUserId.requestFocus();

	            }
	        });

	        txtPassword.addKeyListener(new KeyListener() {

	            public void keyTyped(KeyEvent e) {
	            }

	            public void keyReleased(KeyEvent e) {
	                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	                    btnConnect.doClick();
	                }
	            }

	            public void keyPressed(KeyEvent e) {
	            }
	        });

	        txtCommand.addKeyListener(new KeyListener() {

	            public void keyTyped(KeyEvent e) {
	            }

	            public void keyReleased(KeyEvent e) {
	                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	                    String command = txtCommand.getText().trim();

	                    if (command.equals("exit")) {
	                        client.disconnect();
	                        txtConsole.setText("Disconnected");
	                        txtUserId.requestFocus();
	                    } else if (command.equals("clear")) {
	                        txtConsole.setText("");
	                    } else {
	                        client.sendCommand(command);
	                    }

	                    txtCommand.setText("");
	                }
	            }

	            public void keyPressed(KeyEvent e) {
	            }
	        });

	        txtServer.addFocusListener(new SelectAllFocusListener(txtServer));
	        txtUserId.addFocusListener(new SelectAllFocusListener(txtUserId));
	        txtPassword.addFocusListener(new SelectAllFocusListener(txtPassword));
	    }

	    private JPanel createTopPanel() {
	        JPanel panel = new JPanel();
	        panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
	        panel.setPreferredSize(new Dimension(300, 70));

	        lblServer.setText("Server");
	        lblUserId.setText("User Id");
	        lblPassword.setText("Password");

	        txtServer.setText("localhost");
	        txtUserId.setText("");
	        txtPassword.setText("");
	        btnConnect.setText("Connect");
	        btnConnect.setSize(30, 25);
	        btnDisconnect.setText("Disconnect");
	        btnDisconnect.setSize(30, 25);

	        txtServer.setColumns(20);
	        txtUserId.setColumns(15);
	        txtPassword.setColumns(15);

	        panel.add(lblServer);
	        panel.add(txtServer);
	        //panel.add(lblUserId);
	        //panel.add(txtUserId);
	        //panel.add(lblPassword);
	        //panel.add(txtPassword);
	        panel.add(btnConnect);
	        panel.add(btnDisconnect);

	        return panel;
	    }

	    private JPanel createBottomPanel() {
	        JPanel panel = new JPanel();
	        panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

	        lblCommand.setText("Execute Command");

	        txtCommand.setColumns(50);

	        panel.add(lblCommand);
	        panel.add(txtCommand);

	        return panel;
	    }

	    public static void main(String[] args) {
	        SwingTelnetClient main = new SwingTelnetClient();
	        main.pack();
	        main.show();
	    }

	    private void scrollToBottom() {
	        javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    int endPosition = txtConsole.getDocument().getLength();
	                    Rectangle bottom = txtConsole.modelToView(endPosition);
	                    txtConsole.scrollRectToVisible(bottom);
	                } catch (BadLocationException e) {
	                    System.err.println("Could not scroll to " + e);
	                }
	            }
	        });
	    }

	    class SelectAllFocusListener implements FocusListener {
	        JTextField textField;

	        public SelectAllFocusListener(JTextField textField) {
	            this.textField = textField;
	        }

	        public void focusLost(FocusEvent e) {
	        }

	        public void focusGained(FocusEvent e) {
	            textField.selectAll();
	        }
	    }

	    class FilteredStream extends FilterOutputStream {
	        public FilteredStream(OutputStream aStream) {
	            super(aStream);
	        }

	        public void write(byte b[]) throws IOException {
	            String aString = new String(b);
	            txtConsole.append(aString);
	        }

	        public void write(byte b[], int off, int len) throws IOException {
	            String aString = new String(b, off, len);
	            txtConsole.append(aString);
	            scrollToBottom();
	        }
	    }

	    class MyTelnetClient {

	        private static final String ENCODING = "ISO-8859-1";

	        private TelnetClient telnet = new TelnetClient();

	        private InputStream in;

	        private PrintStream out;

	        private String prompt = "$";

	        ReaderThread readerThread;

	        public MyTelnetClient(String server) {

	            try {

	                // Connect to the specified server

	                telnet.connect(server, 8511);

	                in = telnet.getInputStream();

	                out = new PrintStream(telnet.getOutputStream());

	            } catch (Exception e) {
	                e.printStackTrace();
	            }

	        }

	        public void connect(String user, String password) {
	            try {

	             /*   readUntil("login:");
	                write(user);
	                readUntil("Password:");
	                write(password);*/
	                startReading();

	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }

	        public String readUntilPrompt() {
	            return readUntil(prompt + " ");
	        }

	        public void startReading() {
	            readerThread = new ReaderThread("reader", in);
	            readerThread.start();
	        }

	        public String readUntil(String pattern) {

	            try {

	                char lastChar = pattern.charAt(pattern.length() - 1);
	                StringBuffer sb = new StringBuffer();
	                char ch = (char) in.read();

	                while (true) {

	                    System.out.print(ch);
	                    sb.append(ch);

	                    if (ch == lastChar) {
	                        if (sb.toString().endsWith(pattern)) {
	                            return sb.toString();
	                        }
	                    }

	                    ch = (char) in.read();
	                }

	            } catch (Exception e) {
	                e.printStackTrace();
	            }

	            return null;

	        }

	        public void disconnect() {

	            try {
	                telnet.disconnect();
	            } catch (Exception e) {
	            }
	        }

	        public String sendCommand(String command) {

	            try {
	                write(command);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }

	            return null;
	        }

	        private void write(String value) {

	            try {
	                out.println(value);
	                out.flush();
	                System.out.println(value);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }

	        public InputStream getIn() {
	            return in;
	        }

	        public PrintStream getOut() {
	            return out;
	        }

	        class ReaderThread extends Thread {
	            InputStream is;
	            boolean keepRunning = true;

	            public ReaderThread(String str, InputStream is) {
	                super(str);
	                this.is = is;
	            }

	            public void run() {

	                while (true) {

	                    try {
	                        char ch = (char) in.read();
	                        System.out.print(ch);
	                    } catch (IOException e) {

	                    }
	                }

	            }
	        }

	    }
}
