package com.github.lsdp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "peixes")
public class Peixe extends AbstractEntity<Long>{
    @Column(nullable = false, length = 50, unique = true)
    private String nome;

    @Column(length = 100, unique = true)
    private String descricao;

    @Column(name = "peso_maximo", columnDefinition = "NUMERIC(15,2)")
    private BigDecimal pesoMaximo;

    @Column(name = "data_catalogacao", nullable = false, columnDefinition = "DATE")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCatalogacao;

    public LocalDate getDataCatalogacao() {
        return dataCatalogacao;
    }

    public void setDataCatalogacao(LocalDate dataCatalogacao) {
        this.dataCatalogacao = dataCatalogacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(BigDecimal pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }
}
