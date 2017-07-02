/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geren_memoria1;

/**
 *
 * @author Carlos
 */
class Processo {
    private String nomeProcesso;
    private int inicioProcesso;
    private int tamanhoProcesso;

    public Processo(String nomeProcesso, int inicioProcesso,  int tamanhoProcesso) {
        this.nomeProcesso = nomeProcesso;
        this.inicioProcesso = inicioProcesso;
        this.tamanhoProcesso = tamanhoProcesso;
    }
    public Processo() {
        
    }

    public String getNomeProcesso() {
        return nomeProcesso;
    }

    public void setNomeProcesso(String nomeProcesso) {
        this.nomeProcesso = nomeProcesso;
    }

    public int getInicioProcesso() {
        return inicioProcesso;
    }

    public void setInicioProcesso(int inicioProcesso) {
        this.inicioProcesso = inicioProcesso;
    }

    public int getTamanhoProcesso() {
        return tamanhoProcesso;
    }

    public void setTamanhoProcesso(int tamanhoProcesso) {
        this.tamanhoProcesso = tamanhoProcesso;
    }
    
}
