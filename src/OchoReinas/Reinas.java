/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package OchoReinas;

/**
 *
 * @author Francisco
 */
public class Reinas {
//    int tablero[][];
//
//    public Reinas(int[][] tablero) {
//        this.tablero = tablero;
//    }    
    
    public void ponerReinas(int[][] matriz, int j) {
        if (j < matriz.length) {
            for (int i = 0; i < matriz.length; i++) {//revisa la columna
                if (isValido(matriz, i, j)) {// se valida si se puede poner la reina
                    matriz[i][j] = 1;
                    ponerReinas(matriz, j + 1);// aqui se emplea la recursividad
                    matriz[i][j] = 0;
                }

            }
        } else {
            System.out.println("");
            imprimirTablero(matriz);
        }
    }

    public boolean isValido(int[][] matriz, int i, int j) {
        boolean bandera = true;
        for (int k = 0; k < matriz.length && bandera == true; k++) {
            if (matriz[i][k] == 1) {
                bandera = false;
            }
        }
        
        for (int m = 0; m < matriz.length && bandera == true; m++) {
            for (int n = 0; n < matriz.length && bandera == true; n++) {
                if(m-n == i-j && matriz[m][n] == 1){// valida que la reina no este en la misma fila o columna
                    bandera = false;
                }
                if(m+n == i+j && matriz[m][n] == 1){// valida que la reina no este en la misma fila o columna
                    bandera = false;
                }
            }
            
        }
        return bandera;
    }
    
    public void imprimirTablero(int[][]matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print("["+matriz[i][j]+"]");
                
            }
            
            System.out.println("");
        }
    }
}
