package br.com.vitor.usercrud.controler.form;

import br.com.vitor.usercrud.model.Meta;
import br.com.vitor.usercrud.model.Renda;
import br.com.vitor.usercrud.repository.MetaRepository;
import br.com.vitor.usercrud.repository.RendaRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class MetaForm implements CommonForm{

    @NotNull @NotEmpty
    private String nome;
    private String descricao;
    @NotNull @NotEmpty
    private Boolean metaGasto;
    private Double valorInicial;
    @NotNull @NotEmpty
    private Double valorFinal;

    public MetaForm(String nome, String descricao, Boolean metaGasto, Double valorInicial, Double valorFinal) {
        this.nome = nome;
        this.descricao = descricao;
        this.metaGasto = metaGasto;
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;
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

    public Boolean getMetaGasto() {
        return metaGasto;
    }

    public void setMetaGasto(Boolean metaGasto) {
        this.metaGasto = metaGasto;
    }

    public Double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(Double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public Double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }

    @Override
    public Meta converter() {
        return new Meta(this.nome,this.descricao,this.metaGasto,this.valorInicial,this.valorFinal);
    }

    public Meta atualizar(Long id, MetaRepository metaRepository) {
        Meta meta = metaRepository.getOne(id);

        meta.setNome(this.nome);
        meta.setDescricao(this.descricao);
        meta.setMetaGasto(this.metaGasto);
        meta.setValorInicial(this.valorInicial);
        meta.setValorFinal(this.valorFinal);

        return meta;
    }

}