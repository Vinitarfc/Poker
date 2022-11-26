import java.util.Random;

public class Baralho {
    Carta[] cartas = new Carta[52];

    public Baralho() {
        String[] nomes = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] naipes = {"Paus", "Copas", "Espadas", "Ouros"};
        int cont = 0;

        for (int j = 0; j < naipes.length -1; j++) {
            for (int i = 0; i < nomes.length -1; i++) {
                cartas[cont] = new Carta();
                cartas[cont].setNome(nomes[i]);
                cartas[cont].setNaipe(naipes[j]);
                cont++;
            }
        }
    }

    public void Embaralhar() {
            Random rd = new Random();
            int a = this.cartas.length;
            for (int i = a - 1; i > 0; i--) {
                int j = rd.nextInt(i+1);
                Carta temp = this.cartas[i];
                this.cartas[i] = this.cartas[j];
                this.cartas[j] = temp;
            }
    }

}
