package Codigos;

import java.util.Random;

public class CodigosUteis {

	public static void main(String[] args) {
	}

	public String gerarNomes() {
		String[] consoantes = {"B", "C", "D", "F", "G","H","J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "V", "W", "X","Y", "Z"};
		String[] vogais = {"A", "E", "I", "O", "U"};

		Random random = new Random();

		StringBuilder teste = new StringBuilder("Teste");

		for (int i = 0; i < 5; i++) {
			int posicaoAleatoria = random.nextInt(consoantes.length);
			int posicaoAleatoria2 = random.nextInt(vogais.length);
			teste.append(consoantes[posicaoAleatoria]);
			teste.append(vogais[posicaoAleatoria2]);
		}
		return teste.toString();
	}

	public String gerarCPF() {
		int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

		Random random = new Random();
		StringBuilder teste = new StringBuilder("");

		for (int j = 0; j < 9; j++) {
			int posicaoAleatoria = random.nextInt(numeros.length);
			teste.append(numeros[posicaoAleatoria]);
		}		
		String n1 = teste.substring(0, 1);
		String n2 = teste.substring(1, 2);
		String n3 = teste.substring(2, 3);
		String n4 = teste.substring(3, 4);
		String n5 = teste.substring(4, 5);
		String n6 = teste.substring(5, 6);
		String n7 = teste.substring(6, 7);
		String n8 = teste.substring(7, 8);
		String n9 = teste.substring(8, 9);

		//converter para int cada um deles aqui
		
		int n11 = Integer.parseInt(n1);
		int resultn11 = n11 *10; 
		
		int n22 = Integer.parseInt(n2);
		int resultn22 = n22 *9; 

		int n33 = Integer.parseInt(n3); 
		int resultn33 = n33 *8; 

		int n44 = Integer.parseInt(n4);
		int resultn44 = n44 *7; 

		int n55 = Integer.parseInt(n5);
		int resultn55 = n55 *6; 

		int n66 = Integer.parseInt(n6); 
		int resultn66 = n66 *5; 

		int n77 = Integer.parseInt(n7); 
		int resultn77 = n77 *4; 

		int n88 = Integer.parseInt(n8); 
		int resultn88 = n88 *3; 

		int n99 = Integer.parseInt(n9); 
		int resultn99 = n99 *2; 
		
		int n100;
		int n111;
		
		int soma = resultn11 + resultn22 + resultn33+resultn44+resultn55+resultn66+resultn77+resultn88+resultn99;
		int resto = soma % 11;
		
		if(resto == 0 || resto == 1) {
			n100 = 0;
		}else {
			n100 = 11 - resto;
		}
		int resultn111 = n11 *11; 
		int resultn222 = n22 *10; 
		int resultn333 = n33 *9; 
		int resultn444 = n44 *8; 
		int resultn555 = n55 *7; 
		int resultn666 = n66 *6; 
		int resultn777 = n77 *5; 
		int resultn888 = n88 *4;
		int resultn999 = n99 *3; 
		int resultn1000 = n100 *2; 
		
		int soma2 = resultn111 + resultn222 + resultn333+resultn444+resultn555+resultn666+resultn777+resultn888+resultn999+resultn1000;
		int resto2 = soma2 % 11;
		
		if(resto2 == 1 || resto2 == 0) {
			n111 = 0;
		}else {
			n111 = 11 - resto2;
		}
		
		String cpf = (""+n11+""+n22+""+n33+""+n44+""+n55+""+n66+""+n77+""+n88+""+n99+""+n100+""+n111);
		return cpf;
	}
	
	public String gerarTelefone() {
		String[] numeros = {"1","2","3","4","5","6","7","8","9"};
		
		StringBuilder teste = new StringBuilder("51");
		Random random = new Random();
		
		for(int i = 0; i<8;i++) {
			int posicaoAleatoria = random.nextInt(numeros.length);
			teste.append(numeros[posicaoAleatoria]);
		}
		return teste.toString();
	}
	
	public String gerarCelular() {
		String[] numeros = {"1","2","3","4","5","6","7","8","9"};
		
		StringBuilder teste = new StringBuilder("519");
		Random random = new Random();
		
		for(int i = 0; i<8;i++) {
			int posicaoAleatoria = random.nextInt(numeros.length);
			teste.append(numeros[posicaoAleatoria]);
		}
		return teste.toString();
	}
	
	public String gerarEmail() {
		String[] consoantes = {"B", "C", "D", "F", "G","H","J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "V", "W", "X","Y", "Z"};
		String[] vogais = {"A", "E", "I", "O", "U"};
		
		StringBuilder teste = new StringBuilder("Teste_");
		Random random = new Random();
		for(int i = 0; i < 3;i++) {
			int posicaoAleatoria = random.nextInt(consoantes.length);
			int posicaoAleatoria2 = random.nextInt(vogais.length);
			teste.append(consoantes[posicaoAleatoria]);
			teste.append(vogais[posicaoAleatoria2]);
		}
		String finall = (teste.toString()+"@testing.com");
		return finall;
	}
	
	public String gerarCoren() {
		String[] numeros = {"1", "2", "3", "4", "5","6","7", "8", "9"};
		
		StringBuilder teste = new StringBuilder("");
		Random random = new Random();
		for(int i = 0; i < 6;i++) {
			int posicaoAleatoria = random.nextInt(numeros.length);
			teste.append(numeros[posicaoAleatoria]);
		}
		return teste.toString();
	}
	
	public String gerarCNPJ() {
		int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

		Random random = new Random();
		StringBuilder teste = new StringBuilder("");

		for (int j = 0; j < 12; j++) {
			int posicaoAleatoria = random.nextInt(numeros.length);
			teste.append(numeros[posicaoAleatoria]);
		}		
		String n1 = teste.substring(0, 1);
		String n2 = teste.substring(1, 2);
		String n3 = teste.substring(2, 3);
		String n4 = teste.substring(3, 4);
		String n5 = teste.substring(4, 5);
		String n6 = teste.substring(5, 6);
		String n7 = teste.substring(6, 7);
		String n8 = teste.substring(7, 8);
		String n9 = teste.substring(8, 9);
		String n10 = teste.substring(9, 10);
		String n11 = teste.substring(10, 11);
		String n12 = teste.substring(11, 12);

		//converter para int cada um deles aqui
		
		int n_1 = Integer.parseInt(n1);
		int resultn1 = n_1 *5; 
		
		int n_2 = Integer.parseInt(n2);
		int resultn2 = n_2 *4; 

		int n_3 = Integer.parseInt(n3); 
		int resultn3 = n_3 *3; 

		int n_4 = Integer.parseInt(n4);
		int resultn4 = n_4 *2; 

		int n_5 = Integer.parseInt(n5);
		int resultn5 = n_5 *9; 

		int n_6 = Integer.parseInt(n6); 
		int resultn6 = n_6 *8; 

		int n_7 = Integer.parseInt(n7); 
		int resultn7 = n_7 *7; 

		int n_8 = Integer.parseInt(n8); 
		int resultn8 = n_8 *6; 

		int n_9 = Integer.parseInt(n9); 
		int resultn9 = n_9 *5; 
		
		int n_10 = Integer.parseInt(n10); 
		int resultn10 = n_10 *4; 
		
		int n_11 = Integer.parseInt(n11); 
		int resultn11 = n_11 *3; 
		
		int n_12 = Integer.parseInt(n12); 
		int resultn12 = n_12 *2; 
		
		int n100;
		int n111;
		
		int soma = resultn1 + resultn2 + resultn3+resultn4+resultn5+resultn6+resultn7+resultn8+resultn9+resultn10+resultn11+resultn12;
		int resto = soma % 11;
		
		if(resto == 0 || resto == 1) {
			n100 = 0;
		}else {
			n100 = 11 - resto;
		}
		
		int resultn1_1 = n_1 *6; 
		int resultn2_2 = n_2 *5; 
		int resultn3_3 = n_3 *4; 
		int resultn4_4 = n_4 *3; 
		int resultn5_5 = n_5 *2; 
		int resultn6_6 = n_6 *9; 
		int resultn7_7 = n_7 *8; 
		int resultn8_8 = n_8 *7; 
		int resultn9_9 = n_9 *6; 
		int resultn10_10 = n_10 *5; 
		int resultn11_11 = n_11 *4; 
		int resultn12_12 = n_12 *3; 
		int resultn13_13 = n100 *2; 
				
		int soma2 = resultn1_1 + resultn2_2+ resultn3_3+resultn4_4+resultn5_5+resultn6_6+resultn7_7+resultn8_8+resultn9_9+resultn10_10+resultn11_11+resultn12_12+resultn13_13;
		int resto2 = soma2 % 11;
		
		if(resto2 == 1 || resto2 == 0) {
			n111 = 0;
		}else {
			n111 = 11 - resto2;
		}
		
		String cnpj = (""+n_1+""+n_2+""+n_3+""+n_4+""+n_5+""+n_6+""+n_7+""+n_8+""+n_9+""+n_10+""+n_11+""+n_12+""+n100+""+n111);
		return cnpj;
	}
	

}
