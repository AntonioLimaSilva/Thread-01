package br.com.luciano.captulo2;

import java.io.*;
import java.util.*;

class Principal {
	public static void main(String args[]) {

		String nomeProcurado = "Luc";

		Runnable tarefaBuscaNome = () -> {			
			int count = 1;
			try {
				Scanner entrada = new Scanner(new FileInputStream("assinaturas1.txt"));
				while(entrada.hasNextLine()) {
					String linha = entrada.nextLine();
					if(linha.contains(nomeProcurado))
						System.out.println("assinaturas1.txt" + " - " + count + " - " + linha);
				}
			} catch(FileNotFoundException e) {
				throw new RuntimeException(e);
			}
		};	

		Thread assinaturas1 = new Thread(tarefaBuscaNome);
		assinaturas1.start();	

	}
}