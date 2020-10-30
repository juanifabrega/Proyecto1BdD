package parquimetros;

import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import quick.dbtable.DBTable;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class VentanaInspector extends JInternalFrame {

	
	private static final long serialVersionUID = 1L;
	private BDD bdd;
	private DBTable tabla;
	private LinkedList<String> listaPatentes;
	private JPanel panel;
	private static JComboBox comboBox;
	private int legajo;
	private JComboBox comboBox_2;
	private JComboBox comboBox_1;
	
	
	public VentanaInspector() {
		 super("", false, // resizable
	               true,  // closable
	               false, // maximizable
	               false); // iconifiable
		 setVisible(false);
		 bdd = new BDD();
		 try {
			bdd.conectar("inspector", "inspector");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 listaPatentes = new LinkedList<String>();
		 
		 addInternalFrameListener(new InternalFrameAdapter() {
		 	@Override
		 	public void internalFrameClosing(InternalFrameEvent e) {
		 		dispose();
		 		try {
		 			bdd.desconectar();
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null,
		                    "No se pudo desconectar de la base de datos.\n" + ex.getMessage(),
		                     "Error", JOptionPane.ERROR_MESSAGE);
			        System.out.println("SQLException: " + ex.getMessage());
			        System.out.println("SQLState: " + ex.getSQLState());
			        System.out.println("VendorError: " + ex.getErrorCode());
				}
		 	}
		 });		 

		setBounds(100, 100, 853, 521);
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setLocation(0, -12);
        
        JButton btnAgregarPatente = new JButton("Agregar patente");
        btnAgregarPatente.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		listaPatentes.add(JOptionPane.showInputDialog("Agregar patente:"));
        	    System.out.println("Patente agregada: " + listaPatentes.getLast());        		
        	}
        });
        getContentPane().setLayout(new BorderLayout(0, 0));
        getContentPane().add(btnAgregarPatente, BorderLayout.NORTH);
        
        panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        
        comboBox = new JComboBox();
        comboBox.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		comboBox_1.removeAllItems();
        		comboBox_2.removeAllItems();
        		String calle=(String) comboBox.getItemAt(comboBox.getSelectedIndex());
        		actualizarCombobox1(calle);
        	}
        });
        panel.add(comboBox);
        
        comboBox_1 = new JComboBox();
        comboBox_1.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		comboBox_2.removeAllItems();
        		String calle=(String) comboBox.getItemAt(comboBox.getSelectedIndex());
        		String altura=(String) comboBox_1.getItemAt(comboBox_1.getSelectedIndex());
        		actualizarCombobox2(calle,altura);
        	}
        });
        panel.add(comboBox_1);
        
        
        comboBox_2 = new JComboBox();
        panel.add(comboBox_2);
        
        
        
        
	}
	
	private void actualizarComboBox() {
		String sql = "SELECT calle " +
					 "FROM ubicaciones;";
		try {
			ResultSet rs = bdd.ejecutarSentencia(sql);
			System.out.println("Columnas "+rs.getMetaData().getColumnCount());			
			while(rs.next()) {
				comboBox.addItem(rs.getString("calle"));
			}
			bdd.limpiarSentencia();	
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	private void actualizarCombobox1(String calle) {
		String sql = "SELECT altura " +
				     "FROM ubicaciones "+
				     "WHERE calle='" +calle+"';";
		try {
			ResultSet rs = bdd.ejecutarSentencia(sql);
				
			while(rs.next()) {
				
				comboBox_1.addItem(rs.getInt("altura")+"");
			}
			bdd.limpiarSentencia();	
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	private void actualizarCombobox2(String calle, String altura){
		System.out.println(calle+altura);
		String sql="SELECT id_parq " +
				   "FROM parquimetros " +
				   "WHERE calle='" + calle + "' AND altura=" + altura + ";" ;
		try {
			ResultSet rs = bdd.ejecutarSentencia(sql);
			while(rs.next()) {
				comboBox_2.addItem(rs.getInt("id_parq"));
			}
			bdd.limpiarSentencia();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public boolean loguear(int leg, String clave) throws SQLException, ClassNotFoundException {
		boolean exito;	
		legajo = leg;
		bdd.conectar("inspector", "inspector");	
		
		String consultaSql = "SELECT legajo, password " +
				"FROM inspectores " +
				"WHERE legajo=" + leg + " AND " +
				"password=md5('" + clave + "');";
		
		ResultSet rs = bdd.ejecutarSentencia(consultaSql);
		exito = rs.next();		
		bdd.limpiarSentencia();
		
		try { // �sto es para mostrar la ventana cuando los datos son correctos
	    	if(exito) {
	    		System.out.println("aparece ventana");
	    		setVisible(true);
	    		setMaximum(true);
	            actualizarComboBox();
	    	}
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}		
		return exito;
	}
	
	
	

}