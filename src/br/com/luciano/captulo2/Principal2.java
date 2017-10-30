package br.com.luciano.captulo2;

import java.io.*;
import java.util.*;

class Principal2 {
	public static void main(String args[]) {
		long numero = 10l;
		int numero1 = 20;
		//Thread imprineNumero1 = new Thread(new TarefaImprimeNumero(numero));
		//Thread imprineNumero2 = new Thread(new TarefaImprimeNumero(numero1));

		new Thread(() -> {
			for(int i = 0; i < numero; i++)
			System.out.println(i);
		}).start();

		//imprineNumero1.start();
		//System.out.println("ID: " + imprineNumero1.getId());
		//imprineNumero2.start();	
		//System.out.println("ID: " + imprineNumero2.getId());

	}
}

class TarefaImprimeNumero implements Runnable {

	private long numero;

	TarefaImprimeNumero(long numero) {
		this.numero = numero;
	}

	public void run() {
		for(int i = 0; i < numero; i++)
			System.out.println(i);
	}
	
}