package pt.c02oo.s02classe.s03lombriga;

public class Animacao {
    String string_anima;

    Animacao (String string_anima){
        this.string_anima = string_anima;
    }

    String mostraStringAnima(){
        return this.string_anima;
    }

    void atualizaStringAnima(String nova_string ){
        this.string_anima = nova_string;
    }

    String apresenta(AquarioLombriga lombriga_aquario) {
        return lombriga_aquario.apresenta();
    }

    void passo(char passo, AquarioLombriga lombriga_aquario){
        if ( passo == 'C' )
            lombriga_aquario.crescer();
        if ( passo == 'M' )
            lombriga_aquario.mover();
        if ( passo == 'V' ) 
            lombriga_aquario.virar();
    }
}