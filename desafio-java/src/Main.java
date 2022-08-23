public class Main {
    public static void main(String[] args) {

        Endereco endereco = new Endereco();
        Pais pais = new Pais();
        pais.setCodigo(1);
        pais.setNome("Brasil");
        Estado estado = new Estado();
        estado.setCodigo(1);
        estado.setNome("Sao Paulo");
        Cidade cidade = new Cidade();
        cidade.setCodigo(1);
        cidade.setNome("Sao Paulo");
        endereco.setPais(pais);
        endereco.setEstado(estado);
        endereco.setCidade(cidade);
        endereco.setBairro("Brooklin");
        endereco.setRua("Rua Nova York");
        endereco.setNumero(4);
        endereco.setComplemento("Ap 122");

        Cliente cliente = new Cliente(endereco);
        cliente.setNome("Rafael");

        Conta cc = new ContaCorrente(cliente);
        Conta poupanca = new ContaPoupanca(cliente);

        cc.depositar(100);
        cc.transferir(100,poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}
