import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Stack;

public class Parqueadero extends JFrame implements ActionListener {
    private JTextField placaField, tipoField, horaField;
    private JTextArea tablaArea, dosRuedasArea, cuatroRuedasArea, totalArea;
    private JButton ingresoButton, tablaButton, dosRuedasButton, cuatroRuedasButton, totalButton, eliminarButton, salirButton;
    private ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    private Stack<Vehiculo> dosRuedas = new Stack<Vehiculo>();
    private Stack<Vehiculo> cuatroRuedas = new Stack<Vehiculo>();
    private int tarifaBicicletasCiclomotores = 20;
    private int tarifaMotocicletas = 30;
    private int tarifaCarros = 60;
    
    public Parqueadero() {
        super("Parqueadero");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JPanel ingresoPanel = new JPanel(new GridLayout(4, 2));
        ingresoPanel.setBorder(BorderFactory.createTitledBorder("Ingreso de vehículo"));
        ingresoPanel.add(new JLabel("Placa:"));
        placaField = new JTextField();
        ingresoPanel.add(placaField);
        ingresoPanel.add(new JLabel("Tipo de vehículo:"));
        tipoField = new JTextField();
        ingresoPanel.add(tipoField);
        ingresoPanel.add(new JLabel("Hora de ingreso (hh:mm):"));
        horaField = new JTextField();
        ingresoPanel.add(horaField);
        ingresoButton = new JButton("Ingresar vehículo");
        ingresoButton.addActionListener(this);
        ingresoPanel.add(ingresoButton);
        add(ingresoPanel, BorderLayout.NORTH);
        
        JPanel tablaPanel = new JPanel(new BorderLayout());
        tablaPanel.setBorder(BorderFactory.createTitledBorder("Tabla actualizada"));
        tablaArea = new JTextArea();
        tablaArea.setEditable(false);
        JScrollPane tablaScrollPane = new JScrollPane(tablaArea);
        tablaPanel.add(tablaScrollPane, BorderLayout.CENTER);
        tablaButton = new JButton("Actualizar tabla");
        tablaButton.addActionListener(this);
        tablaPanel.add(tablaButton, BorderLayout.SOUTH);
        add(tablaPanel, BorderLayout.CENTER);
        
        JPanel dosRuedasPanel = new JPanel(new BorderLayout());
        dosRuedasPanel.setBorder(BorderFactory.createTitledBorder("Vehículos de 2 ruedas"));
        dosRuedasArea = new JTextArea();
        dosRuedasArea.setEditable(false);
        JScrollPane dosRuedasScrollPane = new JScrollPane(dosRuedasArea);
        dosRuedasPanel.add(dosRuedasScrollPane, BorderLayout.CENTER);
        dosRuedasButton = new JButton("Calcular valor a pagar");
        dosRuedasButton.addActionListener(this);
        dosRuedasPanel.add(dosRuedasButton, BorderLayout.SOUTH);
        
        JPanel cuatroRuedasPanel = new JPanel(new BorderLayout());
        cuatroRuedasPanel.setBorder(BorderFactory.createTitledBorder("Vehículos de 4 ruedas"));
        cuatroRuedasArea = new JTextArea();
        cuatroRuedasArea.setEditable(false);
        JScrollPane cuatroRuedasScrollPane = new JScrollPane(cuatroRuedasArea);
        cuatroRuedasPanel.add(cuatroRuedasScrollPane, BorderLayout.CENTER);