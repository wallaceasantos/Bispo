package br.com.afsj.model;

public class Bispo extends Peca {
	@Override
    public boolean movimentoOK(int x, int y) {
        if (posX == -1 && posY == -1) {
            return true;
        }
        
        int diferencaX = Math.abs(x - posX);
        int diferencaY = Math.abs(y - posY);
        
        if (diferencaX == diferencaY) {
            int pX, pY;
            
            if (x > posX) {
                pX = 1;
            } else {
                pX = -1;
            }
            if (y > posY) {
                pY = 1;
            } else {
                pY = -1;
            }
            
            int i = posX + pX;
            int j = posY + pY;
            
            //Verificando se existe alguma peça no caminho
            while (i != x && j != y) {
                Peca pBranca = Tabuleiro.listaBrancas.pecaPosicao(i, j);
                Peca pPreta = Tabuleiro.listaPretas.pecaPosicao(i, j);
                if (pBranca != null || pPreta != null) {
                    return false; 
                }
                i += pX;
                j += pY;
            }
            return true;
        }
        return false;
    }

}
