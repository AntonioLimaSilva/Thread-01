package br.com.luciano.captulo3;

class Banheiro {
	private boolean ehSujo = true;

	public void fazNumero1() {
		String nome = Thread.currentThread().getName();

		System.out.println(nome + " batendo na porta");

		synchronized(this) {
			System.out.println(nome + " = entrando no banheiro");

			if(ehSujo) {
				esperaLaFora(nome);
			}

	        System.out.println(nome + " = fazendo coisa rapida");

	        try {
	        	Thread.sleep(15000);
	        } catch(InterruptedException e) {}

	        System.out.println(nome + " = dando descarga");
	        System.out.println(nome + " = lavando a mao");
	        System.out.println(nome + " = saindo do banheiro");
        }
	}	

	public void fazNumero2() {
		String nome = Thread.currentThread().getName();

		System.out.println(nome + " batendo na porta");

		synchronized(this) {
			System.out.println(nome + " = entrando no banheiro");

			if(ehSujo) {
				esperaLaFora(nome);
			}

	        System.out.println(nome + " = fazendo coisa demorada");

	        try {
	        	Thread.sleep(15000);
	        } catch(InterruptedException e) {}

	        System.out.println(nome + " = dando descarga");
	        System.out.println(nome + " = lavando a mao");
	        System.out.println(nome + " = saindo do banheiro");
        }
	}

	public void limpa() {
		String nome = Thread.currentThread().getName();

		System.out.println(nome + " batendo na porta");

		synchronized(this) {
			System.out.println(nome + " entrando no banheiro");

			if(!ehSujo) {
				System.out.println(nome + ", não está sujo, vou sair");
				return;
			}

			System.out.println(nome + " limpando o banheiro");

			this.ehSujo = false;

			try {
	            Thread.sleep(13000);
	        } catch (InterruptedException e) {}

	        this.notifyAll();

	        System.out.println(nome + " saindo do banheiro");
    	}
		
	}

	//É possivel usar o syncronized assim no método também
	public synchronized void imprimirNome() {}

	private void esperaLaFora(String nome) {
		 System.out.println(nome + ", eca, banheiro está sujo");
		 try {
		 	this.wait();
		 }catch(InterruptedException e) {}
	}
}

public class Principal {
	public static final void main(String args[]) {

		Banheiro banheiro = new Banheiro();

		new Thread(() -> {
			banheiro.fazNumero1(); 
		}, "Joao").start();	

		new Thread(() -> {
			banheiro.fazNumero2();
		}, "Luciano").start();

		new Thread(() -> {
			banheiro.limpa();
		}, "Limpeza").start();

	}
}