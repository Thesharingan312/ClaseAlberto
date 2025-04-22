import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class InterfazElectrodomesticos extends JFrame {
    // Colores para los temas
    private static final Color COLOR_TEXTO_CLARO = Color.BLACK;
    private static final Color COLOR_FONDO_CLARO = new Color(240, 240, 240);
    private static final Color COLOR_BOTON_CLARO = new Color(220, 220, 220);
    
    private static final Color COLOR_TEXTO_OSCURO = Color.WHITE;
    private static final Color COLOR_FONDO_OSCURO = new Color(50, 50, 50);
    private static final Color COLOR_BOTON_OSCURO = new Color(80, 80, 80);
    
    // Lista de electrodomésticos
    private ArrayList<Electrodomestico> electrodomesticos;
    
    // Componentes de la interfaz
    private JPanel panelPrincipal;
    private JPanel panelForm;
    private JPanel panelBotones;
    private JPanel panelLista;
    
    private JTextField campoModelo;
    private JTextField campoConsumo;
    private JTextField campoTemperatura;
    private JButton botonAgregar;
    private JButton botonCambiarTema;
    private JTextArea areaLista;
    private JScrollPane scrollLista;
    
    // Tema actual
    private TemaInterfaz temaActual;
    
    public InterfazElectrodomesticos() {
        // Inicializar la lista de electrodomésticos
        electrodomesticos = new ArrayList<>();
        
        // Configurar la ventana principal
        setTitle("Gestor de Electrodomésticos");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Cargar icono
        cargarIcono();
        
        // Inicializar componentes
        inicializarComponentes();
        
        // Establecer tema inicial (claro)
        temaActual = TemaInterfaz.CLARO;
        aplicarTema();
        
        // Hacer visible la ventana
        setVisible(true);
    }
    
    private void cargarIcono() {
        try {
            Image icono = ImageIO.read(new File("icono.png"));
            setIconImage(icono);
        } catch (IOException e) {
            System.out.println("No se pudo cargar el icono: " + e.getMessage());
        }
    }
    
    private void inicializarComponentes() {
        // Panel principal con BorderLayout
        panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Panel de formulario
        panelForm = new JPanel(new GridLayout(3, 2, 5, 5));
        panelForm.setBorder(BorderFactory.createTitledBorder("Añadir Frigorífico"));
        
        // Campos de texto
        JLabel lblModelo = new JLabel("Modelo:");
        campoModelo = new JTextField(20);
        
        JLabel lblConsumo = new JLabel("Consumo (kWh):");
        campoConsumo = new JTextField(10);
        
        JLabel lblTemperatura = new JLabel("Temperatura (°C):");
        campoTemperatura = new JTextField(10);
        
        // Añadir componentes al panel de formulario
        panelForm.add(lblModelo);
        panelForm.add(campoModelo);
        panelForm.add(lblConsumo);
        panelForm.add(campoConsumo);
        panelForm.add(lblTemperatura);
        panelForm.add(campoTemperatura);
        
        // Panel de botones
        panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        
        // Botones
        botonAgregar = new JButton("Añadir Frigorífico");
        botonCambiarTema = new JButton("Cambiar Tema");
        
        // Añadir listeners a los botones
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarFrigorifico();
            }
        });
        
        botonCambiarTema.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarTema();
            }
        });
        
        // Añadir botones al panel
        panelBotones.add(botonAgregar);
        panelBotones.add(botonCambiarTema);
        
        // Panel de lista de electrodomésticos
        panelLista = new JPanel(new BorderLayout());
        panelLista.setBorder(BorderFactory.createTitledBorder("Lista de Electrodomésticos"));
        
        // Área de texto para mostrar la lista
        areaLista = new JTextArea(10, 40);
        areaLista.setEditable(false);
        scrollLista = new JScrollPane(areaLista);
        
        // Añadir el área de texto al panel de lista
        panelLista.add(scrollLista, BorderLayout.CENTER);
        
        // Organizar todos los paneles en el panel principal
        panelPrincipal.add(panelForm, BorderLayout.NORTH);
        panelPrincipal.add(panelBotones, BorderLayout.CENTER);
        panelPrincipal.add(panelLista, BorderLayout.SOUTH);
        
        // Añadir el panel principal a la ventana
        add(panelPrincipal);
    }
    
    private void agregarFrigorifico() {
        try {
            // Obtener valores de los campos
            String modelo = campoModelo.getText().trim();
            double consumo = Double.parseDouble(campoConsumo.getText().trim());
            double temperatura = Double.parseDouble(campoTemperatura.getText().trim());
            
            // Validar datos
            if (modelo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El modelo no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Crear nuevo frigorífico
            Frigorifico nuevoFrigorifico = new Frigorifico(consumo, modelo, temperatura);
            
            // Añadir a la lista
            electrodomesticos.add(nuevoFrigorifico);
            
            // Actualizar la lista mostrada
            actualizarListaElectrodomesticos();
            
            // Limpiar campos
            campoModelo.setText("");
            campoConsumo.setText("");
            campoTemperatura.setText("");
            
            JOptionPane.showMessageDialog(this, "Frigorífico añadido correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Formato de números incorrecto. Use puntos para decimales.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void actualizarListaElectrodomesticos() {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < electrodomesticos.size(); i++) {
            Electrodomestico e = electrodomesticos.get(i);
            sb.append(i + 1).append(". ");
            
            if (e instanceof Frigorifico) {
                Frigorifico f = (Frigorifico) e;
                sb.append(f.toString()).append("\n");
                sb.append("   Info: ").append(f.muestra()).append("\n\n");
            } else {
                sb.append(e.toString()).append("\n\n");
            }
        }
        
        areaLista.setText(sb.toString());
    }
    
    private void cambiarTema() {
        // Cambiar al siguiente tema
        temaActual = (temaActual == TemaInterfaz.CLARO) ? TemaInterfaz.OSCURO : TemaInterfaz.CLARO;
        
        // Aplicar el nuevo tema
        aplicarTema();
        
        // Mostrar mensaje
        String nombreTema = (temaActual == TemaInterfaz.CLARO) ? "Claro" : "Oscuro";
        JOptionPane.showMessageDialog(this, "Tema cambiado a: " + nombreTema);
    }
    
    private void aplicarTema() {
        Color colorTexto, colorFondo, colorBoton;
        
        if (temaActual == TemaInterfaz.CLARO) {
            colorTexto = COLOR_TEXTO_CLARO;
            colorFondo = COLOR_FONDO_CLARO;
            colorBoton = COLOR_BOTON_CLARO;
        } else {
            colorTexto = COLOR_TEXTO_OSCURO;
            colorFondo = COLOR_FONDO_OSCURO;
            colorBoton = COLOR_BOTON_OSCURO;
        }
        
        // Aplicar colores a los componentes
        panelPrincipal.setBackground(colorFondo);
        panelForm.setBackground(colorFondo);
        panelForm.setForeground(colorTexto);
        panelBotones.setBackground(colorFondo);
        panelLista.setBackground(colorFondo);
        panelLista.setForeground(colorTexto);
        
        // Componentes individuales
        for (Component comp : panelForm.getComponents()) {
            if (comp instanceof JLabel) {
                comp.setForeground(colorTexto);
                comp.setBackground(colorFondo);
            }
        }
        
        // Botones
        botonAgregar.setBackground(colorBoton);
        botonAgregar.setForeground(colorTexto);
        botonCambiarTema.setBackground(colorBoton);
        botonCambiarTema.setForeground(colorTexto);
        
        // Área de texto
        areaLista.setBackground(colorFondo);
        areaLista.setForeground(colorTexto);
        
        // Actualizar la interfaz
        SwingUtilities.updateComponentTreeUI(this);
    }
    
    public static void main(String[] args) {
        // Asegurar que la interfaz se ejecute en el thread de eventos de Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InterfazElectrodomesticos();
            }
        });
    }
}