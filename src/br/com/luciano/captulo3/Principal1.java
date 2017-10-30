package br.com.luciano.captulo3;

import java.util.concurrent.locks.*;

class Banheiro {
	private Lock lock = new ReentrantLock();

	public void fazNumero1() {
		String nome = Thread.currentThread().getName();

		System.out.println(nome + " batendo na porta");

		lock.lock();
			System.out.println(nome + " = entrando no banheiro");
	        System.out.println(nome + " = fazendo coisa rapida");

	        try {
	        	Thread.sleep(15000);
	        } catch(InterruptedException e) {}

	        System.out.println(nome + " = dando descarga");
	        System.out.println(nome + " = lavando a mao");
	        System.out.println(nome + " = saindo do banheiro");
        lock.unlock();
	}	

	public void fazNumero2() {
		String nome = Thread.currentThread().getName();

		System.out.println(nome + " batendo na porta");

		lock.lock();
			System.out.println(nome + " = entrando no banheiro");
	        System.out.println(nome + " = fazendo coisa demorada");

	        try {
	        	Thread.sleep(15000);
	        } catch(InterruptedException e) {}

	        System.out.println(nome + " = dando descarga");
	        System.out.println(nome + " = lavando a mao");
	        System.out.println(nome + " = saindo do banheiro");
        lock.unlock();
	}
}

public class Principal1 {
	public static final void main(String args[]) {

		Banheiro banheiro = new Banheiro();

		new Thread(() -> {
			banheiro.fazNumero1(); 
		}, "Joao").start();	

		new Thread(() -> {
			banheiro.fazNumero2();
		}, "Luciano").start();

	}
}