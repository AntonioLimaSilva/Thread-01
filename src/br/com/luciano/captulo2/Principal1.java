package br.com.luciano.captulo2;

import java.io.*;
import java.util.*;

class Principal1 {
	public static void main(String args[]) {

		String nomeProcurado = "a";

		Thread assinaturas1 = new Thread(new TarefaBuscarNome("assinaturas1.txt", nomeProcurado));
		Thread assinaturas2 = new Thread(new TarefaBuscarNome("assinaturas2.txt", nomeProcurado));

		assinaturas1.start();
		//assinaturas2.start();	

	}
}

class TarefaBuscarNome implements Runnable {

	private String nomeArquivo;
	private String nomeProcurado;

	TarefaBuscarNome(String nomeArquivo, String nomeProcurado) {
		this.nomeArquivo = nomeArquivo;
		this.nomeProcurado = nomeProcurado;
	}

	public void run() {
		int count = 1;
		try {
			Scanner entrada = new Scanner(new File(nomeArquivo));
			while(entrada.hasNextLine()) {
				String linha = entrada.nextLine();
				if(linha.contains(nomeProcurado))
					System.out.println(nomeArquivo + " - " + count + " - " + linha);
				count++;
			}
		} catch(FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}