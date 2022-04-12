package pt.c02oo.s03relacionamento.s04restaum;

public class Peca {
    char tipo;
    int linhaBoard;
    int colunaBoard;

    Peca(char tipo, int linhaBoard, int colunaBoard) {
        this.tipo = tipo;
        this.linhaBoard = linhaBoard;
        this.colunaBoard = colunaBoard;
    }

    void alteraTipoPeca(char novoTipo){
        this.tipo = novoTipo;
    }
    char mostraTipoDaPeca(){
        return tipo;
    }

    boolean movimentoEhValido(Peca pecaDestino, Peca pecaIntermediaria){
        /** Função que determina se o destino do movimento é válido, consequentemente, se o movimento pode acontecer.

            - No caso do jogo RestaUm, um movimento é válido:
                -- se o destino faz parte do tabuleiro (destino != " ");
                -- se o destino já não está ocupado (destino != "P" );
                -- se ao se movimentar a peça captura outra peça (intermediária != "-");
        */
        if ( (pecaDestino.mostraTipoDaPeca() != ' ') && (pecaDestino.mostraTipoDaPeca() != 'P') && 
            (pecaIntermediaria.mostraTipoDaPeca() != '-') )
                return true;
        else 
            return false;
    }

    void realizaMovimento(Peca pecaDestino, Peca pecaIntermediaria){
        alteraTipoPeca('-');
        pecaDestino.alteraTipoPeca('P');
        pecaIntermediaria.alteraTipoPeca('-');
    }
}