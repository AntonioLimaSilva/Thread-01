package br.com.luciano.captulo4;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.Collections;

public class Principal {
	public static final void main(String args[]) {
 		//List<String> list = new Vector<>();
 		List<String> list = Collections.synchronizedList(new ArrayList<>());

		for(int i = 0; i < 10; i++) 
			new Thread(new TarefaAdicionarElemento(list, i)).start();
		
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e) {}

		for(int i = 0; i < list.size(); i++) 
			System.out.println(list.get(i));
	}
}

class TarefaAdicionarElemento implements Runnable {

	private List<String> list;
	private int numeroDaThread;

	TarefaAdicionarElemento(List<String> list, int numeroDaThread) {
		this.list = list;
		this.numeroDaThread = numeroDaThread;
	}

	public void run() {
		for(int i = 0; i < 100; i++)
			list.add("Thread " + " = " + numeroDaThread + " = " + i);
	}
}