package br.com.luciano.captulo7;

public class Principal {

    public static void main(String[] args) {

 		PoolDeConexao pool = new PoolDeConexao();
        GerenciadorDeTransacao tx = new GerenciadorDeTransacao();      

        new Thread(new TarefaAcessaBanco(pool, tx)).start();
        new Thread(new TarefaAcessaBancoProcedimento(pool, tx)).start();

    }
}