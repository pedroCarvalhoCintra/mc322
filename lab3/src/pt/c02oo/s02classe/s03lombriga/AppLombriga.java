package pt.c02oo.s02classe.s03lombriga;

public class AppLombriga {

    public static int converteParaInt(String lombriga_dados){
        int dadoInt = Integer.parseInt(lombriga_dados);
        return dadoInt;
    }

    public static void main(String[] args) {
        Toolkit tk = Toolkit.start();
      
        String lombrigas[] = tk.recuperaLombrigas();

        for ( int it = 0; it < lombrigas.length ; it++ ){
            
            Animacao anima = new Animacao(lombrigas[it]);

            int tamanho_aquario = converteParaInt(anima.mostraStringAnima().substring(0,2));
            int tamanho_lombriga = converteParaInt(anima.mostraStringAnima().substring(2,4));
            int posicao_cabeca = converteParaInt(anima.mostraStringAnima().substring(4,6));
            AquarioLombriga lombriga_aquario = new AquarioLombriga(tamanho_aquario, tamanho_lombriga, posicao_cabeca);
            anima.atualizaStringAnima(anima.mostraStringAnima().substring( 6, anima.mostraStringAnima().length()));

            tk.gravaPasso("=====");
            tk.gravaPasso(anima.apresenta(lombriga_aquario));
            while ( anima.mostraStringAnima().length() != 0 ){
                anima.passo(anima.mostraStringAnima().charAt(0), lombriga_aquario);
                anima.atualizaStringAnima(anima.mostraStringAnima().substring(1, anima.mostraStringAnima().length()));
                tk.gravaPasso(anima.apresenta(lombriga_aquario));
            }
        }
        tk.stop();
    }
}
