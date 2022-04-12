package pt.c02oo.s03relacionamento.s04restaum;

public class Tabuleiro {
    Peca[][] board;

    Tabuleiro(Peca[][] board){
        this.board = board;
    }

    Peca mostraPeca(int linha, int coluna){
        return board[linha][coluna];    
    }

    void atualizaTabuleiro(int linhaInicio, int colunaInicio, int linhaDestino, int colunaDestino){
        /** Função que recebe o pedido de atualização do tabuleiro de acordo com o camando fornecido.
            
            - O tabuleiro recebe o pedido de atualização com as informações do movimento;
            - A peça que ira se movimentar é responsável por averiguar se o movimento é possível;
            - Se sim, a peça realiza o movimento. Se não, o comando fornecido não é executado, não havendo alterções no tabuleiro;
            - Após o movimento o tabuleiro atualiza a peça que foi capturada;
        */ 

        int linhaItermediario = (linhaInicio + linhaDestino)/2;
        int colunaItermediario = (colunaInicio + colunaDestino)/2;
        
        if ( board[linhaInicio][colunaInicio].movimentoEhValido(mostraPeca(linhaDestino, colunaDestino), mostraPeca(linhaItermediario, colunaItermediario)) )
            board[linhaInicio][colunaInicio].realizaMovimento(mostraPeca(linhaDestino, colunaDestino), mostraPeca(linhaItermediario, colunaItermediario));     
       
    }

    char[][] tabuleiroEmChar(){
        /** Método que retorna uma matriz de caracteres equivalente ao tabuleiro. */
        char[][] boardChar = new char[7][7];
        for ( int i = 0; i < 7; i++ ){
            for ( int j = 0; j < 7; j++ ){
                boardChar[i][j] = board[i][j].mostraTipoDaPeca();
            }
        }
        return boardChar;
    }
}