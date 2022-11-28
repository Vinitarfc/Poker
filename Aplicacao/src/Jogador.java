public class Jogador {
    Carta[] cartas = new Carta[2];
    boolean jogando = true;
    int valorAposta = 0;
    String nome;

    int valorCaixa = 1000;

    public Jogador(int ANumJogador){
        this.nome = "Jogador " + (ANumJogador + 1);
    }

    public void mostrarCartas(){
        System.out.println("Cartas " + this.nome);
        for (int i = 0; i < cartas.length; i++) {
            System.out.println(this.cartas[i].getNome() + " " + this.cartas[i].getNaipe());
        }
    }

    public void diminuirCaixa(){
        this.valorCaixa -= this.valorAposta;
    }

}
