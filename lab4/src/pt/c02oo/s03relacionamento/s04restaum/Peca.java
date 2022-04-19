package pt.c02oo.s03relacionamento.s04restaum;

public class Peca {
    private char tipo;
    private int linhaBoard;
    private int colunaBoard;
    private static Tabuleiro board;

    public Peca(char tipo, int linhaBoard, int colunaBoard) {
        this.tipo = tipo;
        this.linhaBoard = linhaBoard;
        this.colunaBoard = colunaBoard;
        Peca.board = null;
    }

    public static void conectaTabuleiro(Tabuleiro board){
        Peca.board = board;
    }

    public void setTipoPeca(char novoTipo){
        this.tipo = novoTipo;
    }

    public char getTipoDaPeca(){
        return tipo;
    }
    
    public int getLinhaDaPeca(){
        return linhaBoard;
    }

    public int getColunaDaPeca(){
        return colunaBoard;
    }

    public boolean saltaApenasUmaCasa(Peca pecaDestino){
        /** Função que confere se o movimento realizado pela peça é de saltar apenas uma "casa". */

        if ( linhaBoard == pecaDestino.getLinhaDaPeca() ){
            
            if ( colunaBoard - pecaDestino.getColunaDaPeca() == 2 || colunaBoard - pecaDestino.getColunaDaPeca() == -2 )
                return true;
            else 
                return false;
        }
        else {
        
            if ( linhaBoard - pecaDestino.getLinhaDaPeca() == 2 || linhaBoard - pecaDestino.getLinhaDaPeca() == 2 ) 
                return true;
            else 
                return false;
        }
    }

    public boolean movimentoEhValido(Peca pecaDestino){
        /** Função que determina se o destino do movimento é válido, consequentemente, se o movimento pode acontecer.

            - No caso do jogo RestaUm, um movimento é válido:
                -- se a peça "salta" exatamente uma "casa";
                -- se o destino faz parte do tabuleiro (destino != " ");
                -- se o destino já não está ocupado (destino != "P" );
                -- se ao se movimentar a peça captura outra peça;
        */
        if ( saltaApenasUmaCasa(pecaDestino)){
            
            int linhaCapturada = (linhaBoard + pecaDestino.getLinhaDaPeca())/2;
            int colunaCapturada = (colunaBoard + pecaDestino.getColunaDaPeca())/2;
            
            if ( (pecaDestino.getTipoDaPeca() == '-') && (board.temPecaCapturavel(linhaCapturada, colunaCapturada)) )
                return true;
            else 
                return false;
        }
        else 
            return false;
    }

    public void realizaMovimento(Peca pecaDestino){
        /** Função que realiza o movimento solicitado na peça e pedi para que o tabuleiro realize a caputura feita no movimento. */

        if ( movimentoEhValido(pecaDestino)){
            setTipoPeca('-');
            pecaDestino.setTipoPeca('P');
            board.capturaPeca( (linhaBoard + pecaDestino.getLinhaDaPeca())/2, (colunaBoard + pecaDestino.getColunaDaPeca())/2 );
        }
    }
}