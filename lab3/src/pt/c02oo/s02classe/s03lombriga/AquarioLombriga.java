package pt.c02oo.s02classe.s03lombriga;

public class AquarioLombriga {
    int tamanho_aquario;
    int tamanho_lombriga;
    int posicao_cabeca;
    int lado_cabeca;
 
    AquarioLombriga (int tamanho_aquario, int tamanho_lombriga, int posicao_cabeca){
        this.tamanho_aquario = tamanho_aquario;
        
        if ( tamanho_lombriga > tamanho_aquario ) this.tamanho_lombriga = tamanho_aquario;
        else this.tamanho_lombriga = tamanho_lombriga;
        
        if ( (posicao_cabeca + tamanho_lombriga) > tamanho_aquario || posicao_cabeca > tamanho_aquario || posicao_cabeca < 1 ) this.posicao_cabeca = 1;
        else this.posicao_cabeca = posicao_cabeca;
        
        this.lado_cabeca = 0;
    }
 
    void crescer(){
        if (lado_cabeca == 0){ 
            if ( (posicao_cabeca + tamanho_lombriga) <= tamanho_aquario ) tamanho_lombriga++;
        }
        else{
            if ( (posicao_cabeca - tamanho_lombriga) >= 1 ) tamanho_lombriga++;
        }
    }
 
    void virar(){
        if ( lado_cabeca == 0 ) {
            posicao_cabeca = posicao_cabeca + tamanho_lombriga - 1;
            lado_cabeca = 1;
        }
        else {
            posicao_cabeca = posicao_cabeca - tamanho_lombriga + 1;
            lado_cabeca = 0;
        }
    }
 
    void mover(){
        if ( lado_cabeca == 0 ) {
            if ( posicao_cabeca - 1 == 0 ) virar();
            else posicao_cabeca = posicao_cabeca - 1;
        }
        else {
            if ( posicao_cabeca + 1 == tamanho_aquario + 1 ) virar();
            else posicao_cabeca = posicao_cabeca + 1;
        }
    }
    
    String apresenta(){
        String lombriga_no_aquario = "";
        if ( lado_cabeca == 0 ) {
            for ( int i = 1; i <= posicao_cabeca-1; i++ ) 
                lombriga_no_aquario += "#";
            lombriga_no_aquario += "O";
            for ( int i = posicao_cabeca+1; i <= posicao_cabeca + tamanho_lombriga-1; i++ )
                lombriga_no_aquario += "@";
            for ( int i = posicao_cabeca + tamanho_lombriga+1; i <= tamanho_aquario+1; i++ )
                lombriga_no_aquario += "#";   
        } 
        else {
            for ( int i = 1; i <= posicao_cabeca - tamanho_lombriga; i++ )
                lombriga_no_aquario += "#";
            for ( int i = posicao_cabeca - tamanho_lombriga + 1; i <= posicao_cabeca-1; i++ )
                lombriga_no_aquario += "@";
            lombriga_no_aquario += "O";
            for ( int i = posicao_cabeca+1; i <= tamanho_aquario; i++ )
                lombriga_no_aquario += "#";
        }
        return lombriga_no_aquario;
    }
}