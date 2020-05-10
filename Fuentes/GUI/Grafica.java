package GUI;

import TDAPila.*;
import TDALista.*;
import Logica.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import TDAMapeo.InvalidKeyException;

import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

/**
 * Clase Grafica
 * Extiende JFrame
  * @author Fabio Campetti
 * @author Javier Cifuentes
 *
 */
@SuppressWarnings("serial")
public class Grafica extends JFrame {

	private Programa P;
	private JPanel contentPane;
	private JTextField Expresion;
	private JTextField Posfija;
	private JTextField Variable;
	private JTextField Valor;
	private JTextField Infija;
	private JTextField Altura;
	private JTextField Prefija;
	private JTextField Hojas;
	private JTextField Nodos;
	private JTextField NodosInt;
	private JTextArea Variables;
	private JButton Simplificar;
	private JTextField ResultadoRec;
	private JTextField ResultadoPila;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grafica frame = new Grafica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Grafica() {
		P=new Programa();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{283, 23, 82, 63, 0};
		gbl_contentPane.rowHeights = new int[]{42, 0, 0, 24, 0, 0, 29, 32, 84, 31, 209, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel label_1 = new JLabel("INGRESAR EXPRESION INFIJA");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.fill = GridBagConstraints.BOTH;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 0;
		contentPane.add(label_1, gbc_label_1);
		
		JLabel label = new JLabel("CREAR VARIABLE");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.VERTICAL;
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 3;
		gbc_label.gridy = 0;
		contentPane.add(label, gbc_label);
		
		Expresion = new JTextField();
		GridBagConstraints gbc_Hojas = new GridBagConstraints();
		gbc_Hojas.fill = GridBagConstraints.BOTH;
		gbc_Hojas.insets = new Insets(0, 0, 5, 5);
		gbc_Hojas.gridx = 0;
		gbc_Hojas.gridy = 1;
		contentPane.add(Expresion, gbc_Hojas);
		
		JLabel lblVaribale = new JLabel("VARIBALE");
		GridBagConstraints gbc_lblVaribale = new GridBagConstraints();
		gbc_lblVaribale.anchor = GridBagConstraints.EAST;
		gbc_lblVaribale.fill = GridBagConstraints.VERTICAL;
		gbc_lblVaribale.insets = new Insets(0, 0, 5, 5);
		gbc_lblVaribale.gridx = 2;
		gbc_lblVaribale.gridy = 1;
		contentPane.add(lblVaribale, gbc_lblVaribale);
		
		Variable = new JTextField();
		GridBagConstraints gbc_ResultadoPila = new GridBagConstraints();
		gbc_ResultadoPila.insets = new Insets(0, 0, 5, 0);
		gbc_ResultadoPila.fill = GridBagConstraints.HORIZONTAL;
		gbc_ResultadoPila.gridx = 3;
		gbc_ResultadoPila.gridy = 1;
		contentPane.add(Variable, gbc_ResultadoPila);
		Variable.setColumns(10);
		
		JLabel lblFormaPrefija = new JLabel("FORMA PREFIJA");
		GridBagConstraints gbc_lblFormaPrefija = new GridBagConstraints();
		gbc_lblFormaPrefija.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFormaPrefija.insets = new Insets(0, 0, 5, 5);
		gbc_lblFormaPrefija.gridx = 0;
		gbc_lblFormaPrefija.gridy = 2;
		contentPane.add(lblFormaPrefija, gbc_lblFormaPrefija);
		
		JLabel lblValor = new JLabel("VALOR");
		GridBagConstraints gbc_lblValor = new GridBagConstraints();
		gbc_lblValor.anchor = GridBagConstraints.EAST;
		gbc_lblValor.fill = GridBagConstraints.VERTICAL;
		gbc_lblValor.insets = new Insets(0, 0, 5, 5);
		gbc_lblValor.gridx = 2;
		gbc_lblValor.gridy = 2;
		contentPane.add(lblValor, gbc_lblValor);
		
		Valor = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 3;
		gbc_textField_2.gridy = 2;
		contentPane.add(Valor, gbc_textField_2);
		Valor.setColumns(10);
		
		Prefija = new JTextField();
		Prefija.setEditable(false);
		Prefija.setForeground(new Color(0, 0, 0));
		Prefija.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_textField1 = new GridBagConstraints();
		gbc_textField1.insets = new Insets(0, 0, 5, 5);
		gbc_textField1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField1.gridx = 0;
		gbc_textField1.gridy = 3;
		contentPane.add(Prefija, gbc_textField1);
		Prefija.setColumns(10);
		
		JButton Crear = new JButton("CREAR");
		Crear.setForeground(new Color(0, 0, 0));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 3;
		contentPane.add(Crear, gbc_btnNewButton);
		Crear.addActionListener(new OyenteBotonCrear());
		
		JLabel lblFormaPrefija_1 = new JLabel("FORMA POSFIJA");
		GridBagConstraints gbc_lblFormaPrefija_1 = new GridBagConstraints();
		gbc_lblFormaPrefija_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFormaPrefija_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblFormaPrefija_1.gridx = 0;
		gbc_lblFormaPrefija_1.gridy = 4;
		contentPane.add(lblFormaPrefija_1, gbc_lblFormaPrefija_1);
		
		Posfija = new JTextField();
		Posfija.setEditable(false);
		Posfija.setForeground(new Color(0, 0, 0));
		Posfija.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.gridx = 0;
		gbc_textField_4.gridy = 5;
		contentPane.add(Posfija, gbc_textField_4);
		Posfija.setColumns(10);
		
		JLabel lblResultado = new JLabel("FORMA INFIJA:");
		GridBagConstraints gbc_lblResultado = new GridBagConstraints();
		gbc_lblResultado.anchor = GridBagConstraints.WEST;
		gbc_lblResultado.insets = new Insets(0, 0, 5, 5);
		gbc_lblResultado.gridx = 0;
		gbc_lblResultado.gridy = 6;
		contentPane.add(lblResultado, gbc_lblResultado);
		
		JButton Resolver = new JButton("RESOLVER");
		GridBagConstraints gbc_btnResolver = new GridBagConstraints();
		gbc_btnResolver.insets = new Insets(0, 0, 5, 5);
		gbc_btnResolver.gridx = 2;
		gbc_btnResolver.gridy = 6;
		contentPane.add(Resolver, gbc_btnResolver);
		Resolver.addActionListener(new OyenteBotonResolver());
		
		Infija = new JTextField();
		Infija.setEditable(false);
		Infija.setForeground(new Color(0, 0, 0));
		Infija.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 0;
		gbc_textField_5.gridy = 7;
		contentPane.add(Infija, gbc_textField_5);
		Infija.setColumns(10);
		
		Simplificar = new JButton("SIMPLIFICAR");
		GridBagConstraints gbc_btnSimplificar = new GridBagConstraints();
		gbc_btnSimplificar.insets = new Insets(0, 0, 5, 5);
		gbc_btnSimplificar.gridx = 2;
		gbc_btnSimplificar.gridy = 7;
		contentPane.add(Simplificar, gbc_btnSimplificar);
		Simplificar.setEnabled(false);
		Simplificar.addActionListener(new OyenteBotonSimplificar());
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 8;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 136, 18, 136, 0};
		gbl_panel_1.rowHeights = new int[]{41, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblResultadoRec = new JLabel("RESULTADO Rec");
		GridBagConstraints gbc_lblResultadoRec = new GridBagConstraints();
		gbc_lblResultadoRec.insets = new Insets(0, 0, 5, 5);
		gbc_lblResultadoRec.gridx = 1;
		gbc_lblResultadoRec.gridy = 0;
		panel_1.add(lblResultadoRec, gbc_lblResultadoRec);
		
		JLabel lblResultadoPila = new JLabel("RESULTADO Pila");
		GridBagConstraints gbc_lblResultadoPila = new GridBagConstraints();
		gbc_lblResultadoPila.insets = new Insets(0, 0, 5, 0);
		gbc_lblResultadoPila.gridx = 3;
		gbc_lblResultadoPila.gridy = 0;
		panel_1.add(lblResultadoPila, gbc_lblResultadoPila);
		
		ResultadoRec = new JTextField();
		ResultadoRec.setEditable(false);
		ResultadoRec.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_ResultadoRec = new GridBagConstraints();
		gbc_ResultadoRec.insets = new Insets(0, 0, 0, 5);
		gbc_ResultadoRec.fill = GridBagConstraints.HORIZONTAL;
		gbc_ResultadoRec.gridx = 1;
		gbc_ResultadoRec.gridy = 1;
		panel_1.add(ResultadoRec, gbc_ResultadoRec);
		ResultadoRec.setColumns(10);
		
		ResultadoPila = new JTextField();
		ResultadoPila.setEditable(false);
		ResultadoPila.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_ResultadoPila1 = new GridBagConstraints();
		gbc_ResultadoPila1.fill = GridBagConstraints.HORIZONTAL;
		gbc_ResultadoPila1.gridx = 3;
		gbc_ResultadoPila1.gridy = 1;
		panel_1.add(ResultadoPila, gbc_ResultadoPila1);
		ResultadoPila.setColumns(10);
		
		JLabel lblArbol = new JLabel("ARBOL");
		GridBagConstraints gbc_lblArbol = new GridBagConstraints();
		gbc_lblArbol.insets = new Insets(0, 0, 5, 5);
		gbc_lblArbol.gridx = 0;
		gbc_lblArbol.gridy = 9;
		contentPane.add(lblArbol, gbc_lblArbol);
		
		JLabel lblVariables = new JLabel("VARIABLES:");
		GridBagConstraints gbc_lblVariables = new GridBagConstraints();
		gbc_lblVariables.insets = new Insets(0, 0, 5, 0);
		gbc_lblVariables.gridx = 3;
		gbc_lblVariables.gridy = 9;
		contentPane.add(lblVariables, gbc_lblVariables);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 10;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{71, 36, 86, 46, 0};
		gbl_panel.rowHeights = new int[]{20, 0, 0, 32, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel ALTURA = new JLabel("ALTURA");
		GridBagConstraints gbc_ALTURA = new GridBagConstraints();
		gbc_ALTURA.anchor = GridBagConstraints.EAST;
		gbc_ALTURA.insets = new Insets(0, 0, 5, 5);
		gbc_ALTURA.gridx = 0;
		gbc_ALTURA.gridy = 0;
		panel.add(ALTURA, gbc_ALTURA);
		
		Altura = new JTextField();
		Altura.setEditable(false);
		Altura.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_Altura = new GridBagConstraints();
		gbc_Altura.fill = GridBagConstraints.HORIZONTAL;
		gbc_Altura.insets = new Insets(0, 0, 5, 5);
		gbc_Altura.gridx = 1;
		gbc_Altura.gridy = 0;
		panel.add(Altura, gbc_Altura);
		Altura.setColumns(10);
		
		JLabel NODOS = new JLabel("NODOS");
		GridBagConstraints gbc_NODOS = new GridBagConstraints();
		
		gbc_NODOS.insets = new Insets(0, 0, 5, 5);
		gbc_NODOS.anchor = GridBagConstraints.EAST;
		gbc_NODOS.gridx = 2;
		gbc_NODOS.gridy = 0;
		panel.add(NODOS, gbc_NODOS);
		
		Nodos = new JTextField();
		Nodos.setEditable(false);
		Nodos.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_Nodos = new GridBagConstraints();
		gbc_Nodos.insets = new Insets(0, 0, 5, 0);
		gbc_Nodos.fill = GridBagConstraints.HORIZONTAL;
		gbc_Nodos.gridx = 3;
		gbc_Nodos.gridy = 0;
		panel.add(Nodos, gbc_Nodos);
		Nodos.setColumns(10);
		
		JLabel HOJAS = new JLabel("HOJAS");
		GridBagConstraints gbc_HOJAS = new GridBagConstraints();
		gbc_HOJAS.anchor = GridBagConstraints.EAST;
		gbc_HOJAS.insets = new Insets(0, 0, 5, 5);
		gbc_HOJAS.gridx = 0;
		gbc_HOJAS.gridy = 1;
		panel.add(HOJAS, gbc_HOJAS);
		
		Hojas = new JTextField();
		Hojas.setEditable(false);
		Hojas.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_Hojas1 = new GridBagConstraints();
		gbc_Hojas1.insets = new Insets(0, 0, 5, 5);
		gbc_Hojas1.fill = GridBagConstraints.HORIZONTAL;
		gbc_Hojas1.gridx = 1;
		gbc_Hojas1.gridy = 1;
		panel.add(Hojas, gbc_Hojas1);
		Hojas.setColumns(10);
		
		JLabel NODOSInt = new JLabel("NODOS Int");
		GridBagConstraints gbc_NODOSInt = new GridBagConstraints();
		gbc_NODOSInt.anchor = GridBagConstraints.EAST;
		gbc_NODOSInt.insets = new Insets(0, 0, 5, 5);
		gbc_NODOSInt.gridx = 2;
		gbc_NODOSInt.gridy = 1;
		panel.add(NODOSInt, gbc_NODOSInt);
		
		NodosInt = new JTextField();
		NodosInt.setEditable(false);
		NodosInt.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_NodosInt = new GridBagConstraints();
		gbc_NodosInt.insets = new Insets(0, 0, 5, 0);
		gbc_NodosInt.fill = GridBagConstraints.HORIZONTAL;
		gbc_NodosInt.gridx = 3;
		gbc_NodosInt.gridy = 1;
		panel.add(NodosInt, gbc_NodosInt);
		NodosInt.setColumns(10);
		
		Variables = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 3;
		gbc_textArea.gridy = 10;
		contentPane.add(Variables, gbc_textArea);
	}
	
	private class OyenteBotonCrear implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String var=Variable.getText().trim();
			String val=Valor.getText().trim();
			if(var.equals("") || val.equals(""))
				JOptionPane.showMessageDialog(new JFrame(),"Variable o Valor vacios", "Error", JOptionPane.INFORMATION_MESSAGE);
			else {
				try {
			Double nro=Double.parseDouble(val);
			P.nuevaVariable(var,nro);
			Variable.setText("");
			Valor.setText("");
			Variables.setText(P.mostrarVariables());
			}catch(Exception w) {
				JOptionPane.showMessageDialog(new JFrame(),w.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	}
		
	private class OyenteBotonResolver implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
			if(P.esInfija(Expresion.getText())) {
				P.crearArbol(Expresion.getText());
			Prefija.setText(P.prefija());
			Posfija.setText(P.postfija());
			Infija.setText(P.infija());
			ResultadoRec.setText(""+P.resolverRec());
			ResultadoPila.setText(P.resolver(Expresion.getText()));
			Altura.setText(""+P.altura());
			Hojas.setText(""+P.hojas());
			Nodos.setText(""+P.nodos());
			NodosInt.setText(""+P.nodosInt());
			if(P.nodos()>3)
				Simplificar.setEnabled(true);}
			else
				JOptionPane.showMessageDialog(new JFrame(),"Expresion en forma no Infija", "Error", JOptionPane.INFORMATION_MESSAGE);
			}catch(InvalidKeyException w) {
				JOptionPane.showMessageDialog(new JFrame(),"Expresion con variables no creadas", "Error", JOptionPane.INFORMATION_MESSAGE);
			}
			catch(CeroException r) {
				JOptionPane.showMessageDialog(new JFrame(),"No se puede dividir por cero", "Error", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	private class OyenteBotonSimplificar implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {	
			PilaEnlazada<Position<String>> pila=P.simplificar();
				while(!pila.isEmpty()) {
					Position<String> operador=pila.pop();
					String op1=P.variableIzq(operador);
					String op2=P.variableDer(operador);
					String sig=P.variable(operador);
				String var=JOptionPane.showInputDialog(new JFrame(),"Ingrese nueva variable para: ("+op1+""+sig+""+op2+")","Nueva Variable",JOptionPane.INFORMATION_MESSAGE);
				P.subexpresion(operador,var);}
				Variables.setText(P.mostrarVariables());
				Prefija.setText(P.prefija());
				Posfija.setText(P.postfija());
				Infija.setText(P.infija());
				ResultadoRec.setText(""+P.resolverRec());
				ResultadoPila.setText(P.resolver(Expresion.getText()));
				Altura.setText(""+P.altura());
				Hojas.setText(""+P.hojas());
				Nodos.setText(""+P.nodos());
				NodosInt.setText(""+P.nodosInt());
				if(P.nodos()==3)
					Simplificar.setEnabled(false);
			}catch(EmptyStackException | InvalidKeyException w) {}
			catch(CeroException r) {
				JOptionPane.showMessageDialog(new JFrame(),"No se puede dividir por cero", "Error", JOptionPane.INFORMATION_MESSAGE);
			}
			}
		}
}
