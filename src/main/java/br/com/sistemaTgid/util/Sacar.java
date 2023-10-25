package br.com.sistemaTgid.util;

import br.com.sistemaTgid.callback.EmpresaCallback;
import br.com.sistemaTgid.model.Empresa;

public class Sacar {
    private double saldo;
    private double taxa = 0.10;
    private String tipo = "Saque";

    public double sacar(double quantia) {
        if (quantia > 0 && quantia <= saldo) {
            double valorSaque = quantia - Taxa.aplicarTaxa(quantia, taxa);
            saldo -= valorSaque;
            System.out.println("Saque de " + quantia + " realizado com sucesso.");
            System.out.println("Taxa de " + (taxa * 100) + "% aplicada: " + taxa);
        } else if (quantia <= 0) {
            System.out.println("A quantia de saque deve ser maior que zero.");
        } else {
            System.out.println("Saldo insuficiente para realizar o saque.");
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