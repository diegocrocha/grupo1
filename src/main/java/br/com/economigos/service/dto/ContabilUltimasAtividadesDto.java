package br.com.economigos.service.dto;

import br.com.economigos.service.utils.converters.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.zip.DataFormatException;

public class ContabilUltimasAtividadesDto implements Comparable<ContabilUltimasAtividadesDto> {
    private Long id;
    private String descricao;
    private String data;
    private Double valor;
    private String tipo;
    private String categoria;
    private String fonte;

    public ContabilUltimasAtividadesDto() {
    }

    public ContabilUltimasAtividadesDto(String descricao, String data, Double valor, String tipo, String categoria, String fonte) {
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
        this.tipo = tipo;
        this.categoria = categoria;
        this.fonte = fonte;
    }

    public ContabilUltimasAtividadesDto(Long id, String descricao, String data, Double valor, String tipo, String categoria, String fonte) {
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
        this.tipo = tipo;
        this.categoria = categoria;
        this.fonte = fonte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    @Override
    public int compareTo(ContabilUltimasAtividadesDto o) {

        LocalDateTime thisRendaDate = Data.converterDateTime(this.getData());
        LocalDateTime outraRendaDate = Data.converterDateTime(o.getData());

        if (thisRendaDate.isAfter(outraRendaDate)) {
            return -1;
        }
        if (thisRendaDate.isBefore(outraRendaDate)) {
            return 1;
        }
        return 0;
    }
}
