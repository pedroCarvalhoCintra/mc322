package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
    private Peca[][] board;

    public Tabuleiro(Peca[][] board){
        this.board = board;
    }

    public Peca getPeca(int linha, int coluna){
        return board[linha][coluna];    
    }

    public boolean temPecaCapturavel(int linhaCapturada, int colunaCapturada){
        /** Função que determina se há uma peça na posição de captura. */

        if ( board[linhaCapturada][colunaCapturada].getTipoDaPeca() == 'P' ) 
            return true;
        else 
            return false;
    }

    public void capturaPeca(int linhaCapturada, int colunaCapturada){
        /** Função que realiza a captura da uma peça. */

        board[linhaCapturada][colunaCapturada].setTipoPeca('-');
    }

    public void atualizaTabuleiro(int linhaInicio, int colunaInicio, int linhaDestino, int colunaDestino){
        /** Função que recebe o pedido de atualização do tabuleiro de acordo com o camando fornecido.
            
            - O tabuleiro recebe o pedido de atualização com as informações do movimento;
            - então ele pedi para que a peça realize o movimento, fornecendo para a peça o seu destino;
        */ 
        board[linhaInicio][colunaInicio].realizaMovimento(getPeca(linhaDestino, colunaDestino));

    }

    public char[][] tabuleiroEmChar(){
        /** Método que retorna uma matriz de caracteres equivalente ao tabuleiro. */

        char[][] boardChar = new char[7][7];
        for ( int i = 0; i < 7; i++ ){
            for ( int j = 0; j < 7; j++ ){
                boardChar[i][j] = board[i][j].getTipoDaPeca();
            }
        }
        return boardChar;
    }
}