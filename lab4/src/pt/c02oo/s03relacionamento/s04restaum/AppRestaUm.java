package pt.c02oo.s03relacionamento.s04restaum;

public class AppRestaUm {

   public static void main(String[] args) {
      AppRestaUm.executaJogo(null,null);
   }

   public static boolean centroTabuleiro(int linha, int coluna){
      /** Função que determina se uma peça é o centro do tabuleiro (inicia nulo '-'). */
      if ( linha == 3 && coluna == 3 ) 
         return true;
      else 
         return false;
   }

   public static boolean dentroDoTabuleiro(int linha, int coluna ){
      /** Função que determina se uma peça esta dentro do tabuleiro. */
      if ( (coluna >= 2 && coluna <= 4) || (linha >= 2 && linha <= 4 ) ) 
         return true;
      else 
         return false;
   }
   
   public static int converteParaInt(char posicao){
      /** Função que converte um numero que esta em "char" para um "int" com o valor desse numero. */
        int posicaoInt = Character.getNumericValue(posicao);
        return posicaoInt;
   }

   public static Peca[][] construirPecasInicial(){
      /** Função que constroi o tabuleiro de peças e determina seus valores iniciais.
         
         - o tabuleio é representado por uma matriz de peças. 
      */
     Peca[][] pecas = new Peca[7][7];

     for ( int i = 0; i < 7; i++ ){
         for ( int j = 0; j < 7; j++ ){
            if ( centroTabuleiro(i, j) )
               pecas[i][j] = new Peca('-', i, j);
            else if ( dentroDoTabuleiro(i, j) )
               pecas[i][j] = new Peca('P', i, j);
            else
               pecas[i][j] = new Peca(' ', i, j);
         }
      }    
      return pecas;
   }
   
   public static void executaJogo(String arquivoEntrada, String arquivoSaida) {
      Toolkit tk = Toolkit.start(arquivoEntrada, arquivoSaida);
      
      String commands[] = tk.retrieveCommands();

      // inica o tabuleiro;
      Tabuleiro restaUm = new Tabuleiro(construirPecasInicial());
      tk.writeBoard("Tabuleiro inicial", restaUm.tabuleiroEmChar());
      
      // passa por cada comando fornecido e realiza a atualização do tabuleiro após cada movimento;
      for ( int i = 0; i < commands.length; i++ ){
         int colunaInicio = commands[i].charAt(0) % 97;
         int linhaInicio = converteParaInt(commands[i].charAt(1)) - 1;
         int colunaDestino = commands[i].charAt(3) % 97;
         int linhaDestino = converteParaInt(commands[i].charAt(4)) - 1;
         
         restaUm.atualizaTabuleiro(linhaInicio, colunaInicio, linhaDestino, colunaDestino);
         tk.writeBoard("source: " + commands[i].substring(0,2) + "; " + "target: " + commands[i].substring(3,5), restaUm.tabuleiroEmChar());
      }
      

      tk.stop();
   }

}
