import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.regex.PatternSyntaxException;

public class JDBC_Displays {

    public static void main(String[] args) throws SQLException {
        Connection connection;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            System.out.println("Загрузка драйвера успешна");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/MySQL?useSSL=false&useJDBCComplaintTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true", "root", "5555");
            System.out.println("Подключение установлено");

        } catch (SQLException ex) {
            System.out.println("Не удалось создать соединение");
            return;
        }
        Statement statement = connection.createStatement();

        String va = "select count(*) from disp.displays";
        ResultSet resultSet1 = statement.executeQuery(va);
        resultSet1.next();
        int a = resultSet1.getInt(1);

        Object[][] all = new Object[a+10][6];
        int i=0;

        String vb = "select * from disp.displays";
        ResultSet resultSet = statement.executeQuery(vb);

        while (resultSet.next()) {

            all[i][0] = resultSet.getString(1);
            all[i][1] = resultSet.getString(2);
            all[i][2] = resultSet.getString(3);
            all[i][3] = resultSet.getString(4);
            all[i][4] = resultSet.getString(5);
            all[i][5] = resultSet.getString(6);
            i++;
        }

        Object columns[] = {"display_ID", "display_name", "resolution", "diagonal", "update_frequency", "price"};

        TableModel model = new DefaultTableModel(all, columns) {};

        JFrame frame = new JFrame("JDBC_Displays");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTable table = new JTable(model);
        final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        table.setRowSorter(sorter);
        JScrollPane pane = new JScrollPane(table);
        frame.add(pane, BorderLayout.CENTER);
        JPanel panel = new JPanel(new BorderLayout());
        JPanel panel1 = new JPanel(new FlowLayout());
        JLabel label = new JLabel("Фильтр");
        panel.add(label, BorderLayout.NORTH);
        final JTextField filterText = new JTextField("");
        panel.add(filterText, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.NORTH);
        JButton button = new JButton("Фильтр по введенному значению");
        JButton button1 = new JButton("Добавить строку");
        JButton button2 = new JButton("Удалить строку");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = filterText.getText();
                if (text.length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    try {
                        sorter.setRowFilter(RowFilter.regexFilter(text));
                    } catch (PatternSyntaxException pse) {
                        System.err.println("Bad regex pattern");
                    }
                }
            }
        });

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame add = new JFrame();
                add.setSize(500, 800);

                JButton enter = new JButton("Ввести");
                enter.setBounds(180,550,100,30);
                JLabel label = new JLabel("Название");
                JLabel label1 = new JLabel("Расширение");
                JLabel label2 = new JLabel("Диагональ");
                JLabel label3 = new JLabel("Частота обновления");
                JLabel label4 = new JLabel("Цена");

                label.setBounds(190,30,200,30);
                label1.setBounds(190,120,200,30);
                label2.setBounds(190,210,200,30);
                label3.setBounds(165,290,200,30);
                label4.setBounds(210,370,200,30);
                JTextField enter1 = new JTextField();
                JTextField enter2 = new JTextField();
                JTextField enter3 = new JTextField();
                JTextField enter4 = new JTextField();
                JTextField enter5 = new JTextField();
                enter1.setBounds(180,90,100,30);
                enter2.setBounds(180,170,100,30);
                enter3.setBounds(180,250,100,30);
                enter4.setBounds(180,330,100,30);
                enter5.setBounds(180,410,100,30);

                add.add(enter);
                add.add(label);
                add.add(label1);
                add.add(label2);
                add.add(label3);
                add.add(label4);
                add.add(enter1);
                add.add(enter2);
                add.add(enter3);
                add.add(enter4);
                add.add(enter5);
                add.setResizable(false);
                add.setLayout(null);
                add.setVisible(true);

                enter.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String Name = enter1.getText();
                        String Resolution = enter2.getText();
                        int Diagonal = Integer.parseInt(enter3.getText());
                        String Update_freq = enter4.getText();
                        int Price = Integer.parseInt(enter4.getText());
                      try {
                          String query1 = "insert into disp.displays (display_name, resolution, diagonal, update_frequency, price) values (?,?,?,?,?)";
                          PreparedStatement preparedStatement = connection.prepareStatement(query1);
                          preparedStatement.setString(1, Name);
                          preparedStatement.setString(2, Resolution);
                          preparedStatement.setInt(3, Diagonal);
                          preparedStatement.setString(4, Update_freq);
                          preparedStatement.setInt(5, Price);
                          preparedStatement.executeUpdate();

                      }
                      catch (SQLException ex){}
                      add.dispose();
                        try {
                            String va = "select count(*) from disp.displays";
                            ResultSet resultSet1 = statement.executeQuery(va);
                            resultSet1.next();
                            int a = resultSet1.getInt(1);

                            Object[][] all2 = new Object[a+30][6];
                            int i = 0;

                            String vb = "select * from disp.displays";
                            ResultSet resultSet = statement.executeQuery(vb);

                            while (resultSet.next()) {

                                all2[i][0] = resultSet.getString(1);
                                all2[i][1] = resultSet.getString(2);
                                all2[i][2] = resultSet.getString(3);
                                all2[i][3] = resultSet.getString(4);
                                all2[i][4] = resultSet.getString(5);
                                all2[i][5] = resultSet.getString(6);

                                i++;
                            }

                            TableModel model1 = new DefaultTableModel(all2, columns) {};
                            table.setModel(model1);

                        }
                        catch(SQLException ex){}
                    }
                });
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame delete = new JFrame();
                delete.setSize(500, 500);

                JButton enter = new JButton("Ввести");
                enter.setBounds(180,400,100,30);
                JLabel label = new JLabel("Id нужного монитора");

                label.setBounds(160,50,200,30);
                JTextField enter1 = new JTextField();
                enter1.setBounds(180,90,100,30);

                delete.add(enter);
                delete.add(label);
                delete.add(enter1);
                delete.setResizable(false);
                delete.setLayout(null);
                delete.setVisible(true);

                enter.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        int num = Integer.parseInt(enter1.getText());
                        try {
                            String delete = "delete from disp.displays where Display_ID = ?";
                            PreparedStatement preparedStatement = connection.prepareStatement(delete);
                            preparedStatement.setInt(1, num);
                            preparedStatement.executeUpdate();
                        } catch (SQLException ex){}
                        delete.dispose();

                     try {
                         String va = "select count(*) from disp.displays";
                         ResultSet resultSet1 = statement.executeQuery(va);
                         resultSet1.next();
                         int a = resultSet1.getInt(1);

                         Object[][] all1 = new Object[a+30][6];

                         int i = 0;

                         String vb = "select * from disp.displays";
                         ResultSet resultSet = statement.executeQuery(vb);

                         while (resultSet.next()) {

                             all1[i][0] = resultSet.getString(1);
                             all1[i][1] = resultSet.getString(2);
                             all1[i][2] = resultSet.getString(3);
                             all1[i][3] = resultSet.getString(4);
                             all1[i][4] = resultSet.getString(5);
                             all1[i][5] = resultSet.getString(6);
                             i++;
                         }

                         TableModel model1 = new DefaultTableModel(all1, columns) {};
                        table.setModel(model1);

                     } catch(SQLException ex){}
                    }
                });
            }
        });

        panel1.add(button);
        panel1.add(button1);
        panel1.add(button2);
        frame.add(panel1, BorderLayout.SOUTH);
        frame.setSize(700, 300);
        frame.setLocation(500,300);
        frame.setVisible(true);
        resultSet1.close();
        resultSet.close();
    }
    }



