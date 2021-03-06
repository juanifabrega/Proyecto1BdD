package parquimetros;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class VentanaPrincipal {

	private JFrame frame;
	private JMenuBar menu ;
	private static JMenuItem botonAdmin;
	private static JMenuItem botonInspector;
	private static JMenuItem botonEstacionar;
	private VentanaConsultas ventanaConsultas;
	private VentanaLoginAdmin ventanaLoginAdmin;
	private VentanaInspector ventanaInspector;
	private VentanaLoginInspector ventanaLoginInspector;
	private VentanaEstacionar ventanaEstacionar;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPrincipal() {
		initialize();

        ventanaConsultas = new VentanaConsultas();
        ventanaConsultas.setVisible(false);
        frame.getContentPane().add(ventanaConsultas);
		
        ventanaInspector = new VentanaInspector();
        frame.getContentPane().add(ventanaInspector);
        
        ventanaEstacionar = new VentanaEstacionar();
        frame.getContentPane().add(ventanaEstacionar);
	}
	
	

	private void initialize() {
		frame = new JFrame("Parqu�metros");
		frame.setBounds(100, 100, 853, 521);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getRootPane().setBorder(BorderFactory.createMatteBorder(0, 3, 3, 3, Color.BLACK));
		
		menu = new JMenuBar();
		frame.setJMenuBar(menu);
		
		botonAdmin = new JMenuItem("Admin");
		Border borde = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.DARK_GRAY);
		botonAdmin.setBorder(borde);
		botonAdmin.setAlignmentY(SwingConstants.CENTER);
		menu.add(botonAdmin);
		botonAdmin.addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(botonAdmin.isEnabled()) {
					Color c = botonAdmin.getBackground();
					Color newColor = new Color(c.getRed()-40,c.getGreen()-40,c.getBlue()-40);
					botonAdmin.setBackground(newColor);
					
					Border borde = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK);
					botonAdmin.setBorder(borde);				
				}
			}
		    @Override
		    public void mouseExited(MouseEvent e) {
				if(botonAdmin.isEnabled()) {
			        botonAdmin.setBackground(null);
					Border borde = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.DARK_GRAY);
					botonAdmin.setBorder(borde);
				}
		    }
			
		});		
		
		botonAdmin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	if(ventanaConsultas.isVisible() || ventanaInspector.isVisible() || ventanaEstacionar.isVisible())
        			JOptionPane.showMessageDialog(null,
                            "Ya hay una conexi�n activa.\nCierre para iniciar otra..",
                             "Error", JOptionPane.ERROR_MESSAGE);
            	else {
            		ventanaLoginAdmin = new VentanaLoginAdmin(ventanaConsultas);
            	    ventanaLoginAdmin.setVisible(true);
            	}
            }
        });		
	
		
		botonInspector = new JMenuItem("Inspector");
		botonInspector.setBorder(borde);
		menu.add(botonInspector);
		botonInspector.addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(botonAdmin.isEnabled()) {
					Color c = botonAdmin.getBackground();
					Color newColor = new Color(c.getRed()-40,c.getGreen()-40,c.getBlue()-40);
					botonInspector.setBackground(newColor);
					
					Border borde = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK);
					botonInspector.setBorder(borde);		
				}
			}
		    @Override
		    public void mouseExited(MouseEvent e) {
		        botonInspector.setBackground(null);
				Border borde = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.DARK_GRAY);
				botonInspector.setBorder(borde);
		    }
			
		});			
		
		
		botonInspector.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	if(ventanaConsultas.isVisible() || ventanaInspector.isVisible() || ventanaEstacionar.isVisible())
        			JOptionPane.showMessageDialog(null,
                            "Ya hay una conexi�n activa.\nCierre para iniciar otra..",
                             "Error", JOptionPane.ERROR_MESSAGE);
            	else {
            		ventanaLoginInspector = new VentanaLoginInspector(ventanaInspector);
            	    ventanaLoginInspector.setVisible(true);           		
            	}
             }
        });
		
		

		botonEstacionar = new JMenuItem("Estacionar");
		botonEstacionar.setBorder(borde);
		menu.add(botonEstacionar);
		botonEstacionar.addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(botonAdmin.isEnabled()) {
					Color c = botonAdmin.getBackground();
					Color newColor = new Color(c.getRed()-40,c.getGreen()-40,c.getBlue()-40);
					botonEstacionar.setBackground(newColor);
					
					Border borde = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK);
					botonEstacionar.setBorder(borde);		
				}
			}
		    @Override
		    public void mouseExited(MouseEvent e) {
		        botonEstacionar.setBackground(null);
				Border borde = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.DARK_GRAY);
				botonEstacionar.setBorder(borde);
		    }
			
		});			
		
		
		botonEstacionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	if(ventanaConsultas.isVisible() || ventanaInspector.isVisible())
        			JOptionPane.showMessageDialog(null,
                            "Ya hay una conexi�n activa.\nCierre para iniciar otra..",
                             "Error", JOptionPane.ERROR_MESSAGE);
            	else {
                    ventanaEstacionar = new VentanaEstacionar();
                    frame.getContentPane().add(ventanaEstacionar);
                    ventanaEstacionar.setVisible(true);
    	    		try {
						ventanaEstacionar.setMaximum(true);
					} catch (PropertyVetoException e) {
						e.printStackTrace();
					}
            	}
             }
        });
		
	}
		
}
