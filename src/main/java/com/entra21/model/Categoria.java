package com.entra21.model;

import java.util.Objects;

public class Categoria {
    private int id;
    private String decricao;

    public Categoria() {}

    public Categoria(int id, String decricao) {
        this.id = id;
        this.decricao = decricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDecricao() {
        return decricao;
    }

    public void setDecricao(String decricao) {
        this.decricao = decricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return id == categoria.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", decricao='" + decricao + '\'' +
                '}';
    }
}
