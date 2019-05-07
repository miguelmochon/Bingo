package jframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.SwingConstants;

public class CartonesBingo extends JFrame {

	private JPanel contentPane;
	private JLabel lblNumeros;
	private Border border = LineBorder.createBlackLineBorder();
	public static ArrayList<JLabel> listaEtiquetas = new ArrayList<>();
	
	public CartonesBingo() {
		definirVentana();
		definirEventos();
		
	}
	
	public void definirVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 9, 0, 0));
		contentPane.setBackground(Color.white);
		
		
		
		
		Integer[][] cart = creaCarton();
		
		for(int p=0; p<3;p++) {
			
			for(int s=0; s<9;s++) {	
				lblNumeros = new JLabel("numeros");
				contentPane.add(lblNumeros);
				lblNumeros.setText(cart[s][p].toString());
				lblNumeros.setHorizontalAlignment(SwingConstants.CENTER);
				lblNumeros.setForeground(Color.black);
				lblNumeros.setBorder(border);
				repaint();
				
				if(cart[s][p]==-1) {
					lblNumeros.setIcon(new ImageIcon(getClass().getResource("/img/betisMini.jpg")));
				}
				listaEtiquetas.add(lblNumeros);
			}
		}	
			 
			
	}
	public static Integer[][] creaCarton() {
		Integer[][] cart = CartonBingov2.devuelveArray();
		
		return cart;
	}
	
	public static ArrayList<JLabel> devuelveLista() {
		return listaEtiquetas;
	}
	public void definirEventos() {
		
	}
	

}
