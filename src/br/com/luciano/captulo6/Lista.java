package br.com.luciano.captulo6;

class Lista {
	private String [] elementos = new String[1000];
	private int indice;

	public String pegaElemento(int i) {
		return this.elementos[i];
	}
	
	public synchronized void adicionaElementos(String elemento) {
		this.elementos[indice] = elemento;
		this.indice++;
		try{
            Thread.sleep(10);
        } catch(InterruptedException e) {}

        if(estaCheia()) {
        	 System.out.println("lista esta cheia, notificando");
        	 this.notify();
        }
	}

	public int tamanho() {
		return this.elementos.length;
	}

	public boolean estaCheia() {
    	return this.indice == this.tamanho();
    }
}