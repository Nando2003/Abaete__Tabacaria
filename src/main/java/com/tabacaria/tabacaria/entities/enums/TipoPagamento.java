package com.tabacaria.tabacaria.entities.enums;

public enum TipoPagamento {

    PIX(1), //1
    CREDITO(2), //2
    DEBITO(3), //3
    LINK(4), //4
    DINHEIRO(5); //5

    private int code;

    private TipoPagamento(int code) {
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static TipoPagamento valueOf(int code){
        for (TipoPagamento value : TipoPagamento.values()){
            if (value.getCode() == code){
                return value;
            }
        }
        throw  new IllegalArgumentException("Código invalido!");
    }
}
