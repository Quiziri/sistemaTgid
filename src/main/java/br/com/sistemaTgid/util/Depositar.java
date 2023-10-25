package br.com.sistemaTgid.util;

import br.com.sistemaTgid.callback.EmpresaCallback;
import br.com.sistemaTgid.model.Empresa;

public class Depositar {
    double taxa = 0.05;
    private double saldo;
    private String tipo = "Deposito";

    public double depositar(double quantia) {
        if (quantia > 0) {
            double valorDeposito = quantia - Taxa.aplicarTaxa(quantia, taxa);
            saldo += valorDeposito;
            System.out.println("Depósito de " + quantia + " realizado com sucesso.");
            System.out.println("Taxa de " + (taxa * 100) + "% aplicada: " + taxa);
        } else {
            System.out.println("A quantia de depósito deve ser maior que zero.");
        }
        return saldo;
    }

    private void call(String tipo, double valor, double taxa, Empresa empresa) {
        empresa.setSaldo((empresa.getSaldo() + saldo));
        call(tipo, saldo, taxa, empresa);
        EmpresaCallback callback = new EmpresaCallback();
        callback.callback(tipo, valor, taxa);
    }
}