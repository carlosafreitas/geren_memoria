/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geren_memoria1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Carlos
 */
public class Geren_memoria1 {

    /**
     * @param args the command line arguments
     */
      /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Lendo o arquivo comos processos");
        System.out.println("");
        int contadorProcessos = 0;
        int contadorMemoria = 0;
        char[] processos = new char[50];
        String nomeProcesso = "ABCDE";
        char[] letras = nomeProcesso.toCharArray();
        Map<String, Processo> todosProcessos = new HashMap<String, Processo>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("c:/arquivo.txt"));
            while (br.ready()) {

                String linha = br.readLine();
                int qteMemoria = Integer.parseInt(linha);

                //Verifica se o processo lido não ultrapassa 50
                if (contadorMemoria + qteMemoria > 50) {
                    System.out.println("Mais de 50 posiçoes de memória!");
                    return;
                }

                // Verifica se não ultrapassa 5 processos
                if (contadorProcessos > 5) {
                    System.out.println("Mais de 5 processos!");
                    return;
                }

                String nome = Character.toString(letras[contadorProcessos]);
                Processo processo = new Processo(nome, contadorMemoria, contadorMemoria + qteMemoria);

                todosProcessos.put(nome, processo);
                int tamanho = qteMemoria + contadorMemoria;
                for (int n = contadorMemoria; n < tamanho; n++) {
                    processos[n] = nome.charAt(0);
                }

                contadorMemoria = contadorMemoria + qteMemoria;
                contadorProcessos++;

            }
            br.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        String opcao = "";

        int somador = 0;
        System.out.println("    |  0  1  2  3  4  5  6  7  8  9  |");
        System.out.println("    |--------------------------------|");
        for (int linha = 0; linha < 5; linha++) {
            System.out.print(linha + " - | ");
            for (int coluna = 0; coluna < 10; coluna++) {
                System.out.print(" " + processos[somador] + " ");
                somador++;
            }
            System.out.println(" |");
        }
        System.out.println("    |--------------------------------|");
        System.out.println("");
        System.out.println("Digite a letra processo: ");
        Scanner ler = new Scanner(System.in);
        String n = ler.next();

        if (todosProcessos.containsKey(n)) {
            Processo processo = todosProcessos.get(n);
            System.out.println("Nome do processo: " + processo.getNomeProcesso());
            System.out.println("Registro Base: " + processo.getInicioProcesso());
            System.out.println("Registro Limite: " + (processo.getTamanhoProcesso() - 1));
            
            System.out.println("Digite a posição da memoria: ");
            int p = ler.nextInt();

            if ((p >= processo.getInicioProcesso()) && (p <= processo.getTamanhoProcesso() - 1)) {
                System.out.println("O endereço TEM  persmissão para gravar ");
            }else
                System.out.println("O endereço NÃO TEM persmissão para gravar ");
        } else {
            System.err.println("Chave não existe");
        }

    }

    
}
