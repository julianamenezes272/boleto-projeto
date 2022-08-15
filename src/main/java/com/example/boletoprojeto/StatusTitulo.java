package com.example.boletoprojeto;

public enum StatusTitulo {

    PENDENTE(1, "Boleto pendente"),
    ENVIADO( 2,  "Boleto enviado"),
    ACATAD0( 3,  "Boleto acatado"),
    REJEITADO( 4, "Boleto rejeitado"),
    CANCELADO( 5, "Boleto cancelado"),
    BAIXA_AUTOMATICA( 6,  "Boleto baixado");

    private String description;
    private int value;

    public int getValue() { return this.value;}

    public String getDescription() { return this.description;
    }

    StatusTitulo ( int value, String description){
        this.value = value;
        this.description = description;
    }
    public static StatusTitulo find(int value){
        for(StatusTitulo status : StatusTitulo.values()){
            if (status.getValue() == value){
                return status;
            }
        }
        throw new IllegalArgumentException("Status Título não encontrado" +value);
    }

}