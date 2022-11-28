import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Baralho meuBaralho = new Baralho();
        meuBaralho.embaralhar();
        boolean numeroValido = false;
        int quantidadeJogadore = 0;
        Scanner entrada = new Scanner(System.in);
        while (!numeroValido) {
            System.out.println("Quantos vão jogar? Digite um número de 2 a 10. Ou 0 para encerrar aplicação.");
            quantidadeJogadore = converterInteger(entrada.nextLine());
            if (quantidadeJogadore == 0){
                System.exit(0);
            }
            numeroValido = (quantidadeJogadore != -1 && (quantidadeJogadore > 1 && quantidadeJogadore <= 10));
        }
        Jogador[] jogadores = new Jogador[quantidadeJogadore];

        for (int i = 0; i < quantidadeJogadore; i++){
            jogadores[i] = new Jogador(i);
            jogadores[i].cartas[0] = meuBaralho.darCartas();
            jogadores[i].cartas[1] = meuBaralho.darCartas();
            jogadores[i].mostrarCartas();
        }
        boolean apostasIguais = false;
        int apostaAnterior = 0;
        int totalAposta = 0;

        while (!apostasIguais){
            for (int i = 0; i < quantidadeJogadore; i++) {
                if (jogadores[i].jogando) {
                    System.out.println(jogadores[i].nome + " qual valor da aposta, digite 0 para sair ou passar.");
                    jogadores[i].valorAposta = converterInteger(entrada.nextLine());

                    if (jogadores[i].valorAposta == -1 || jogadores[i].valorAposta > jogadores[i].valorCaixa){
                        System.out.println("Digite um valor válido e que tenha ele em caixa.");
                        jogadores[i].valorAposta = 0;
                        i--;
                        continue;
                    }

                    if (jogadores[i].valorAposta == 0){
                        jogadores[i].jogando = false;
                        System.out.println(jogadores[i].nome + " saiu do jogo.");
                        System.out.println("Cartas restantes:");
                        for (int j = 0; j < quantidadeJogadore; j++) {
                            if (jogadores[j].jogando) {
                                jogadores[j].mostrarCartas();
                            }
                        }
                        continue;
                    }
                    if (apostaAnterior == jogadores[i].valorAposta){
                        totalAposta += jogadores[i].valorAposta;
                        jogadores[i].diminuirCaixa();
                        continue;
                    } else if (apostaAnterior > jogadores[i].valorAposta) {
                        System.out.println("Existe uma aposta maior, precisa igualar, cobrir ou correr.");
                        i--;
                        continue;
                    }
                    jogadores[i].diminuirCaixa();
                    totalAposta += jogadores[i].valorAposta;
                    apostaAnterior = jogadores[i].valorAposta;
                }
            }
            apostasIguais = verificarApostasIguais(jogadores);
        }

        System.out.println("Cartas comuns:");
        meuBaralho.imprimirBaralho(5);

        System.out.println();
        System.out.println("Cartas dos jogadores:");
        for (int j = 0; j < quantidadeJogadore; j++) {
            if (jogadores[j].jogando) {
                jogadores[j].mostrarCartas();
            }
        }

        int ganhador = -1;
        String mensagem = "";
        while (ganhador == -1) {
            System.out.println("Quem ganhou? Digite o numero do jogador:" + mensagem);
            ganhador = converterInteger(entrada.nextLine());
            if (!jogadores[ganhador - 1].jogando) {
                mensagem = "Anterior informado não está na lista dos que chegaram ao fim do jogo";
            }
        }

        System.out.println(jogadores[ganhador - 1].nome + " ganhou R$" + totalAposta);
    }
    public static Integer converterInteger(String ANumero){
        try {
            if (Integer.parseInt(ANumero) < 0){
                return -1;
            } else {
                return Integer.parseInt(ANumero);
            }
        } catch (NumberFormatException ex) {
            return -1;
        }
    }

    public static boolean verificarApostasIguais(Jogador[] AArrayJogadores){
        boolean resultado = true;
        int apostaAnterior = 0;
        for (int i = 0; i < AArrayJogadores.length; i++){
            if (AArrayJogadores[i].jogando) {
                if (apostaAnterior == 0){
                    apostaAnterior = AArrayJogadores[i].valorAposta;
                } else if (apostaAnterior != AArrayJogadores[i].valorAposta) {
                    resultado = false;
                    break;
                }
            }
        }
        return resultado;
    }
}