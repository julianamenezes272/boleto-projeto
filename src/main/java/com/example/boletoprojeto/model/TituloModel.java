package com.example.boletoprojeto.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table (name = "TB_TITULO_CB")
public class TituloModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private UUID id;

    @Column (nullable = false, unique = true , length = 15)
    private String CPF;

    @Column
    private String nomeSacado;

    @Column
    private String razaoSocialSacador;

    @Column (nullable = false, unique = true , length = 12)
    private String nossoNumero;

    @Column (nullable = false, unique = true , length = 15)
    private String seuNumero;

    @Column (nullable = false, unique = true , length = 130)
    private LocalDateTime registrationDate;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TituloModel that = (TituloModel) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
