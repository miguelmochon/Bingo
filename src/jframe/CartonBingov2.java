package jframe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartonBingov2 {

	public static void main(String[] args) {
		Integer[][] carton = devuelveArray();
	
	}
	
	private static boolean compruebaBingo(Integer[][] carton) {
		boolean res = true;
			for (int h = 0; h<9;h++) {			
			int v = 0;
			int primero = carton [h][v];
			int segundo = carton [h][v+1];
			int tercero = carton [h][v+2];
			
				if(primero==segundo && segundo==tercero && tercero ==-1) {
				res = false;
				}
			}
		
		return res;
	}

	public static List<Integer> generaCartonBingo() {
		Integer[][] carton = new Integer[9][3];
		Integer inf = 1;
		Integer sup = 9;
		Integer aleatorio = 0;
		List<Integer> lista = new ArrayList<>();
		for(int p=0; p<9;p++) {
			
			for(int s=0; s<3;s++) {		
				
				do {
				aleatorio = generaAleatorio(inf, sup);
				} while(lista.contains(aleatorio));
				lista.add(aleatorio);
				carton[p][s]=aleatorio;
			}
		
			if(p==0) {
			inf=inf+9;
			sup=sup+10;
		
			} else if(p>0 && p<7) {
				inf=inf+10;
				sup=sup+10;
			} else if (p==7){
			inf = inf+10;
			sup = sup + 11;
		
			}
		
		}
		
		return lista;
	}

	private static Integer generaAleatorio (Integer inferior, Integer superior) {
		Integer aleatorio;
		aleatorio=(int)Math.floor(Math.random()*(superior-inferior+1)+inferior);
		return aleatorio;
	}
	
	public static Integer[][] devuelveArray(){
		Integer[][] carton = new Integer[9][3];
		
		do {
		List<Integer> numeros = generaCartonBingo();
		numeros.sort(null);
		Integer contador=0;
		
		Integer cero = 0;
		for(int x=0; x<9;x++) {
			
			for(int y=0;y<3;y++) {
				carton[x][y]=numeros.get(contador);
				contador++;
			}
		}
		
		List<Integer> listaCero = new ArrayList<>();
		for(int o = 0; o<3;o++) {
			for(int l = 0; l<4; l++) {
				do {
				cero = generaAleatorio(0,8);
				} while(listaCero.contains(cero));
				listaCero.add(cero);
			carton[cero][o] = -1;	
			}
		listaCero.clear();
		}
		
		} while(compruebaBingo(carton)==false);
	
		return  carton;
	}
}
