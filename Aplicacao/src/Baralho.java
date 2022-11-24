public class Baralho {
    Carta[] cartas = new Carta[52];

    public Baralho() {
        int indiceMin = 0;
        final int NUM_CARTAS_POR_NAIPE = 13;
        final int NUM_NAIPES = 4;
        String descricaoNaipe = "";
        for(int numNaipes = 1; numNaipes <= NUM_NAIPES; numNaipes++){
            int indiceMax = (NUM_CARTAS_POR_NAIPE * numNaipes);
            switch (numNaipes){
                case 1:
                    descricaoNaipe = "Paus";
                    break;
                case 2:
                    descricaoNaipe = "Copas";
                    break;
                case 3:
                    descricaoNaipe = "Espadas";
                    break;
                case 4:
                    descricaoNaipe = "Ouros";
                    break;
            }
            for(int i = indiceMin; i < indiceMax; i++){
                cartas[i].setNaipe(descricaoNaipe);
                switch (i){
                    case 0:
                        cartas[i].setNome("A");
                        break;
                    case 1:
                        cartas[i].setNome("2");
                        break;
                    case 2:
                        cartas[i].setNome("3");
                        break;
                    case 3:
                        cartas[i].setNome("4");
                        break;
                    case 4:
                        cartas[i].setNome("5");
                        break;
                    case 5:
                        cartas[i].setNome("6");
                        break;
                    case 6:
                        cartas[i].setNome("7");
                        break;
                    case 7:
                        cartas[i].setNome("8");
                        break;
                    case 8:
                        cartas[i].setNome("9");
                        break;
                    case 9:
                        cartas[i].setNome("10");
                        break;
                    case 10:
                        cartas[i].setNome("J");
                        break;
                    case 11:
                        cartas[i].setNome("Q");
                        break;
                    case 12:
                        cartas[i].setNome("K");
                        break;
                }
            }
            indiceMin = indiceMax;
        }







    }
}
