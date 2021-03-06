package DiscreteStructuresLab;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private int n1 = 9, n2 = 4, n3 = 2, n4 = 2, lab = 5;
    private boolean directed = false;
    private Dimension d = new Dimension(1500, 1000);
    private final Font FONT = new Font("Arial", Font.BOLD, 16);
    private JComboBox<Integer> labBox;

    Window(String title) {
        super(title);
        this.setLayout(null);
        this.setPreferredSize(d);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationByPlatform(true);
        this.init();
    }

    public void init() {
        this
                .drawLabSelectButton()
                .drawDirectedButton()
                .createGraph();
    }

    private void createGraph() {
        int[][] matrix = Matrix.generateMatrix(this.n1, this.n2, this.n3, this.n4, this.lab, !this.directed);
        int[][] weightMatrix = Matrix.generateWeightMatrix(this.n1, this.n2, this.n3, this.n4, this.lab);
        this
                .drawDegreesButton(matrix)
                .drawPathsButton(matrix)
                .drawReachabilityButton(matrix)
                .drawConnectedButton(matrix)
                .drawCondensedButton(matrix)
                .drawDFSButton(matrix)
                .drawMSTButton(matrix, weightMatrix)
                .drawDijkstraButton(matrix, weightMatrix)
                .drawMatrix(matrix)
                .drawGraph(matrix);
    }
    public void drawGraph(int[][] matrix) {
        Graph graph = new Graph(matrix, directed);
        graph.draw(this);
    }
    public void changeOrientation() { this.directed = !this.directed; }
    public void redraw() {
        this.getContentPane().removeAll();
        this.init();
        this.revalidate();
        this.repaint();
    }
    public Window drawLabSelectButton() {
        JLabel label = new JLabel("Граф лаб. роботи №");
        label.setBounds(1100, 65, d.width, 30);
        label.setFont(this.FONT);
        this.add(label);
        Integer[] labs = new Integer[]{1, 2, 3, 4, 5};
        this.labBox = new JComboBox<>(labs);
        labBox.setBounds(1300, 65, 40, 30);
        labBox.setFont(this.FONT);
        labBox.setBackground(Color.WHITE);
        DefaultListCellRenderer listRenderer = new DefaultListCellRenderer();
        listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
        labBox.setRenderer(listRenderer);
        labBox.setFocusable(false);
        labBox.setMaximumRowCount(5);
        labBox.setSelectedIndex(lab - 1);
        this.add(labBox);
        JButton b = new JButton("Вибрати");
        b.setBounds(1340, 65, 110, 30);
        b.setFont(this.FONT);
        b.setBackground(Color.WHITE);
        b.setFocusPainted(false);
        b.setActionCommand("Select lab");
        b.addActionListener(new ButtonListener(this));
        this.add(b);
        return this;
    }
    public Window drawDirectedButton() {
        String text;
        if (directed) text = "Граф напрямлений";
        else text = "Граф ненапрямлений";
        JLabel label = new JLabel(text);
        label.setBounds(1100, 95, d.width, 30);
        label.setFont(this.FONT);
        this.add(label);
        JButton b = new JButton("Змінити");
        b.setBounds(1300, 95, 150, 30);
        b.setFont(this.FONT);
        b.setBackground(Color.WHITE);
        b.setFocusPainted(false);
        b.setActionCommand("Change Orientation");
        b.addActionListener(new ButtonListener(this));
        this.add(b);
        return this;
    }
    public Window drawDegreesButton(int[][] matrix) {
        JLabel label = new JLabel("Степені вершин");
        label.setBounds(1100, 125, d.width, 30);
        label.setFont(this.FONT);
        this.add(label);
        JButton b = new JButton("Показати");
        b.setBounds(1300, 125, 150, 30);
        b.setFont(this.FONT);
        b.setBackground(Color.WHITE);
        b.setFocusPainted(false);
        b.setActionCommand("Show Degrees Window");
        b.addActionListener(new ButtonListener(matrix, directed));
        this.add(b);
        return this;
    }
    public Window drawPathsButton(int[][] matrix) {
        JLabel label = new JLabel("Шляхи довжиною 2 і 3");
        label.setBounds(1100, 155, d.width, 30);
        label.setFont(this.FONT);
        this.add(label);
        JButton b = new JButton("Показати");
        b.setBounds(1300, 155, 150, 30);
        b.setFont(this.FONT);
        b.setBackground(Color.WHITE);
        b.setFocusPainted(false);
        b.setActionCommand("Show Paths Window");
        b.addActionListener(new ButtonListener(matrix, directed));
        this.add(b);
        return this;
    }
    public Window drawReachabilityButton(int[][] matrix) {
        JLabel label = new JLabel("Матриця досяжності");
        label.setBounds(1100, 185, d.width, 30);
        label.setFont(this.FONT);
        this.add(label);
        JButton b = new JButton("Показати");
        b.setBounds(1300, 185, 150, 30);
        b.setFont(this.FONT);
        b.setBackground(Color.WHITE);
        b.setFocusPainted(false);
        b.setActionCommand("Show Reachability Window");
        b.addActionListener(new ButtonListener(matrix, directed));
        this.add(b);
        return this;
    }
    public Window drawConnectedButton(int[][] matrix) {
        JLabel label = new JLabel("Матриця зв'язності");
        label.setBounds(1100, 215, d.width, 30);
        label.setFont(this.FONT);
        this.add(label);
        JButton b = new JButton("Показати");
        b.setBounds(1300, 215, 150, 30);
        b.setFont(this.FONT);
        b.setBackground(Color.WHITE);
        b.setFocusPainted(false);
        b.setActionCommand("Show Connected Window");
        b.addActionListener(new ButtonListener(matrix, directed));
        this.add(b);
        return this;
    }
    public Window drawCondensedButton(int[][] matrix) {
        JLabel label = new JLabel("Граф конденсації");
        label.setBounds(1100, 245, d.width, 30);
        label.setFont(this.FONT);
        this.add(label);
        JButton b = new JButton("Показати");
        b.setBounds(1300, 245, 150, 30);
        b.setFont(this.FONT);
        b.setBackground(Color.WHITE);
        b.setFocusPainted(false);
        b.setActionCommand("Show Condensed Window");
        b.addActionListener(new ButtonListener(matrix, directed));
        this.add(b);
        return this;
    }
    public Window drawDFSButton(int[][] matrix) {
        JLabel label = new JLabel("Обхід в глибину");
        label.setBounds(1100, 275, d.width, 30);
        label.setFont(this.FONT);
        this.add(label);
        JButton b = new JButton("Обійти");
        b.setBounds(1300, 275, 150, 30);
        b.setFont(this.FONT);
        b.setBackground(Color.WHITE);
        b.setFocusPainted(false);
        b.setActionCommand("Show DFS Window");
        b.addActionListener(new ButtonListener(matrix, directed));
        this.add(b);
        return this;
    }
    public Window drawMSTButton(int[][] matrix, int[][] weightMatrix) {
        JLabel label = new JLabel("Мінімальний кістяк");
        label.setBounds(1100, 305, d.width, 30);
        label.setFont(this.FONT);
        this.add(label);
        JButton b = new JButton("Знайти");
        b.setBounds(1300, 305, 150, 30);
        b.setFont(this.FONT);
        b.setBackground(Color.WHITE);
        b.setFocusPainted(false);
        b.setActionCommand("Show MST Window");
        b.addActionListener(new ButtonListener(matrix, weightMatrix, directed));
        if (directed) b.setEnabled(false);
        this.add(b);
        return this;
    }
    public Window drawDijkstraButton(int[][] matrix, int[][] weightMatrix) {
        JLabel label = new JLabel("Найкоротший шлях");
        label.setBounds(1100, 335, d.width, 30);
        label.setFont(this.FONT);
        this.add(label);
        JButton b = new JButton("Знайти");
        b.setBounds(1300, 335, 150, 30);
        b.setFont(this.FONT);
        b.setBackground(Color.WHITE);
        b.setFocusPainted(false);
        b.setActionCommand("Show Dijkstra Window");
        b.addActionListener(new ButtonListener(matrix, weightMatrix, directed));
        if (directed) b.setEnabled(false);
        this.add(b);
        return this;
    }
    public Window drawMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            String mat = "";
            for (int j = 0; j < matrix[i].length; j++) {
                mat = mat.concat("  " + matrix[i][j]);
            }
            mat = mat.trim();
            JLabel matrixLabel = new JLabel(mat);
            matrixLabel.setBounds(1100, 395 + 20 * i, d.width, 20);
            matrixLabel.setFont(this.FONT);
            this.add(matrixLabel);
        }
        return this;
    }
    public void changeLab(int lab) { this.lab = lab; }
    public JComboBox<Integer> getComboBox() { return this.labBox; }
}
