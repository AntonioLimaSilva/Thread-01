package br.com.luciano.captulo5;

class Banheiro {
	private boolean ehSujo = true;

	public void fazNumero1() {
		String nome = Thread.currentThread().getName();

		System.out.println(nome + " = batendo na porta");

		/* Imagne que esse método é uma chave, um mutex!!!
		*  Vale lembar que esse bloco é executado de forma atômica, ou seja, completamente.
		*/
		synchronized(this) {
			System.out.println(nome + " = entrando no banheiro");

			while(ehSujo) {
				esperaLaFora(nome);
			}

	        System.out.println(nome + " = fazendo coisa rapida");

	        this.ehSujo = true;

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

		System.out.println(nome + " = batendo na porta");

		//Imagne que esse método é uma chave, um mutex!!!
		synchronized(this) {
			System.out.println(nome + " = entrando no banheiro");

			while(ehSujo) {
				esperaLaFora(nome);
			}

	        System.out.println(nome + " = fazendo coisa demorada");

	        this.ehSujo = true;

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

		System.out.println(nome + " = batendo na porta");

		//Imagne que esse método é uma chave, um mutex!!!
		synchronized(this) {
			System.out.println(nome + " = entrando no banheiro");

			if(!ehSujo) {
				System.out.println(nome + " = nao esta sujo, vou sair");
				return;
			}

			System.out.println(nome + " = limpando o banheiro");

			this.ehSujo = false;

			try {
	            Thread.sleep(13000);
	        } catch (InterruptedException e) {}

	        //Aqui as Threads são noficadas para continuarem os seus trabalhos!!!
	        this.notifyAll();

	        System.out.println(nome + " = saindo do banheiro");
    	}
		
	}

	private void esperaLaFora(String nome) {
		 System.out.println(nome + " = eca, banheiro esta sujo");
		 try {
		 	/* deixa o thread no estado de espera, em outras palavras bloqueado
			*  Sempre o método wait trabalha em conjunto com o método notify ou notifyAll
			*  devido a necessidade de notificar as demais threads sobre uma determinda tarefa
			*  e então desbloquear o acesso ou entrar a chave para a demais threads continuar os seus
			*  trabalhos
		 	*/
		 	this.wait(); 
		 }catch(InterruptedException e) {}
	}
}