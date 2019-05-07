package jframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Bingo extends JFrame {
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblBingo;
	private JLabel[][] array;
	private JLabel lblNumeros;
	private JButton btnEjecutar;
	private JButton btnGenerar;
	private JLabel lblAleatorio;
	private List<Integer> listaTodosNumeros = new ArrayList<Integer>();
	private List<Integer> listaCartones = new ArrayList<Integer>();
	private List<JLabel> listaTodasLabel = new ArrayList<JLabel>();
	private List<Integer> listaNumerosGenerados;
	private List<Integer> listaAles;
	private JButton btnJugar;
	private List<Integer> listaAleatorios;
	public Bingo() {
		definirVentana();
		definirEventos();
	}
	
	public void definirVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 548, 801);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 0, 0), new Color(255, 0, 0), new Color(220, 20, 60), new Color(139, 0, 0)));
		panel.setBackground(new Color(152, 251, 152));
		panel.setBounds(10, 11, 512, 740);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblBingo = new JLabel("El Bingo");
		lblBingo.setBounds(179, 7, 121, 41);
		lblBingo.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD | Font.ITALIC, 30));
		panel.add(lblBingo);
		
		btnEjecutar = new JButton("Ejecutar");
		btnEjecutar.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		btnEjecutar.setBounds(353, 648, 89, 23);
		panel.add(btnEjecutar);
		
		btnGenerar = new JButton("Generar Carton");
		btnGenerar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGenerar.setBounds(320, 682, 163, 23);
		panel.add(btnGenerar);
		
		btnJugar = new JButton("JUGAR");
		btnJugar.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		btnJugar.setBounds(134, 684, 89, 23);
		panel.add(btnJugar);
		
		
	}
	
	public void definirEventos() {
	
	btnEjecutar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int lado = 27;
				int alt = 134;
				Integer contador = 1;
					for(int y = 0; y<10;y++) {
					lado = 27;
						for(int x = 0; x<9;x++) {
							lblNumeros = new JLabel(contador.toString());
							lblNumeros.setFont(new Font("DejaVu Sans", Font.PLAIN, 23));
							lblNumeros.setBounds(lado, alt, 43, 41);
							panel.add(lblNumeros);
						contador++;
						lado= lado + 50;
						listaTodosNumeros.add(contador);
						listaTodasLabel.add(lblNumeros);
						}
					alt = alt + 45;
					}
					repaint();
			}
		
	});	
	
	btnGenerar.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			CartonesBingo frame = new CartonesBingo();
			frame.setVisible(true);
			Integer[][] carton = CartonesBingo.creaCarton();
		}

		
	});
	btnJugar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			ArrayList<JLabel> etiquetaCarton = CartonesBingo.devuelveLista();
			Integer aleatorio = 0;
			listaAleatorios = new ArrayList<>();
			do {
				aleatorio =(int)Math.floor(Math.random()*(90+1-1)+1);
				listaAleatorios.add(aleatorio);
			} while(!listaAleatorios.contains(aleatorio) || listaAleatorios.size()<90 );
			
			for(int i=0; i<90; i++) {
				for (int x=0; x<27; x++) {
		
					if(listaAleatorios.get(i)==Integer.parseInt(etiquetaCarton.get(x).getText())) {
						etiquetaCarton.get(x).setForeground(Color.green);
					}
				}
			}
			for(int d=0; d<90; d++) {
				
				for(int q = 0; q<90; q++) {
					if(listaAleatorios.get(d)==Integer.parseInt(listaTodasLabel.get(q).getText())) {
						listaTodasLabel.get(q).setForeground(Color.red);
					}
				}
			}
		}
		
	});
	
	
	}
	public String generaAleatorio() {
		Integer aleatorio = 0;
		do {
		aleatorio=(int)Math.floor(Math.random()*(90+1-1)+1);
		}while(sinRepeticion(aleatorio));
		String cad = aleatorio.toString();
		return cad;
	}
	public List<Integer> generaAleatorio2() {
		Integer aleatorio = 0;
		List<Integer> lista = new ArrayList<>();
		do {
		aleatorio=(int)Math.floor(Math.random()*(90+1-1)+1);
		lista.add(aleatorio);
		
		}while(lista.size()==90 || sinRepeticion2(aleatorio));
		
		return lista;
	}
	public boolean sinRepeticion2(int aleatorio) {
		List<Integer> lista = new ArrayList<>();
		Boolean res = true;
		if(lista.contains(aleatorio)) {
			res = false;
		}
		
		return res;

	}

	public boolean sinRepeticion(int aleatorio) {
		List<Integer> lista = new ArrayList<>();
		Boolean res = true;
		if(lista.contains(aleatorio)) {
			res = false;
		}
		
		return res;

	}
	
}



