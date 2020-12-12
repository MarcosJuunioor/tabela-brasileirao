/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author marcosantonio
 */
public class Time {
    private int classificacao;
    private String nomeDoClube;
    private int totalDePontos;
    private int quantidadeDeVitorias;
    private int empates;
    private int derrotas;
    private int golsPro;
    private int golsContra;
    private int saldoDeGols;
    
    public Time(String nomeDoClube){
        this.classificacao = 0;
        this.nomeDoClube = nomeDoClube;
        this.totalDePontos = 0;
        this.quantidadeDeVitorias = 0;
        this.empates = 0;
        this.derrotas = 0;
        this.golsPro = 0;
        this.golsContra = 0;
        this.saldoDeGols = 0;
    }
    
    public void disputar(int golsPro, int golsContra){
        if(golsPro > golsContra){
            this.totalDePontos+=3;
            this.quantidadeDeVitorias++;
            this.golsPro+=golsPro;
            this.golsContra+=golsContra;
            this.saldoDeGols = this.golsPro - this.golsContra;
        }else if(golsPro == golsContra){
            this.totalDePontos+=1;
            this.empates++;
            this.golsPro+=golsPro;
            this.golsContra+=golsContra;
            this.saldoDeGols = this.golsPro - this.golsContra;
        }else{
            this.derrotas++;
            this.golsPro+=golsPro;
            this.golsContra+=golsContra;
            this.saldoDeGols = this.golsPro - this.golsContra;
        }
    }
    /**
     * @return the classificacao
     */
    public int getClassificacao() {
        return classificacao;
    }

    /**
     * @param classificacao the classificacao to set
     */
    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    /**
     * @return the nomeDoClube
     */
    public String getNomeDoClube() {
        return nomeDoClube;
    }

    /**
     * @param nomeDoClube the nomeDoClube to set
     */
    public void setNomeDoClube(String nomeDoClube) {
        this.nomeDoClube = nomeDoClube;
    }

    /**
     * @return the totalDePontos
     */
    public int getTotalDePontos() {
        return totalDePontos;
    }

    /**
     * @param totalDePontos the totalDePontos to set
     */
    public void setTotalDePontos(int totalDePontos) {
        this.totalDePontos = totalDePontos;
    }

    /**
     * @return the quantidadeDeVitorias
     */
    public int getQuantidadeDeVitorias() {
        return quantidadeDeVitorias;
    }

    /**
     * @param quantidadeDeVitorias the quantidadeDeVitorias to set
     */
    public void setQuantidadeDeVitorias(int quantidadeDeVitorias) {
        this.quantidadeDeVitorias = quantidadeDeVitorias;
    }

    /**
     * @return the empates
     */
    public int getEmpates() {
        return empates;
    }

    /**
     * @param empates the empates to set
     */
    public void setEmpates(int empates) {
        this.empates = empates;
    }

    /**
     * @return the derrotas
     */
    public int getDerrotas() {
        return derrotas;
    }

    /**
     * @param derrotas the derrotas to set
     */
    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    /**
     * @return the golsPro
     */
    public int getGolsPro() {
        return golsPro;
    }

    /**
     * @param golsPro the golsPro to set
     */
    public void setGolsPro(int golsPro) {
        this.golsPro = golsPro;
    }

    /**
     * @return the golsContra
     */
    public int getGolsContra() {
        return golsContra;
    }

    /**
     * @param golsContra the golsContra to set
     */
    public void setGolsContra(int golsContra) {
        this.golsContra = golsContra;
    }

    /**
     * @return the saldoDeGols
     */
    public int getSaldoDeGols() {
        return saldoDeGols;
    }

    /**
     * @param saldoDeGols the saldoDeGols to set
     */
    public void setSaldoDeGols(int saldoDeGols) {
        this.saldoDeGols = saldoDeGols;
    }
    
    
    
    
    
}
