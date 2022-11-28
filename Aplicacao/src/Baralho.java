import java.util.Random;

public class Baralho {
    static final int QUANTIDADE_TOTAL_CARTAS = 52;
    Carta[] cartas = new Carta[52];
    int quantidadeDeCartas;
    int indexCarta;

    public Baralho() {
        String[] nomes = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] naipes = {"Paus", "Copas", "Espadas", "Ouros"};
        int cont = 0;
        quantidadeDeCartas = 52;
        indexCarta = 0;

        for (int j = 0; j < naipes.length; j++) {
            for (int i = 0; i < nomes.length; i++) {
                cartas[cont] = new Carta();
                cartas[cont].setNome(nomes[i]);
                cartas[cont].setNaipe(naipes[j]);
                cont++;
            }
        }
    }

    public void embaralhar() {
        Random rd = new Random();
        int tamanhoArray = this.cartas.length;
        for (int i = tamanhoArray - 1; i > 0; i--) {
            int j = rd.nextInt(i + 1);
            Carta temp = this.cartas[i];
            this.cartas[i] = this.cartas[j];
            this.cartas[j] = temp;
        }
    }

    public Carta darCartas(){
        Carta temp = this.cartas[indexCarta];
        for (int i = indexCarta; i < this.cartas.length - 1; i++) {
            if (this.cartas[i].getNome().equals("null")) {
                temp = this.cartas[i];
                indexCarta++;
                quantidadeDeCartas--;
                break;
            }
        }
        return temp;
    }

    public void temCarta(){
        if(quantidadeDeCartas > 0) {
            System.out.println("Existem " + quantidadeDeCartas + " cartas no baralho ainda");
        } else{
            System.out.println("Não existem cartas no baralho");
        }
    }

    public void imprimirBaralho(){
        //Decidi fazer assim para imiprimir somente o baralho que não está na mão dos jogadores, pode ser usado a qualquer momento.
        for (int i = indexCarta; i < QUANTIDADE_TOTAL_CARTAS; i++){
            System.out.println(this.cartas[i].getNome() + " " + this.cartas[i].getNaipe());
        }
    }
    public void imprimirBaralho(int AQuantidadeCartas){
        //Feito um overload para poder utilizar nas cartas comuns
        for (int i = indexCarta; i < (indexCarta + AQuantidadeCartas); i++){
            System.out.println(this.cartas[i].getNome() + " " + this.cartas[i].getNaipe());
        }
    }
}
