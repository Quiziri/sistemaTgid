package br.com.sistemaTgid.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

public class TransacaoController {
    private Map<Integer, Double> contas = new HashMap<>();

    @PostMapping("/{id}/depositar")
    public String depositar(@PathVariable int id, @RequestParam double quantia) {
        if (contas.containsKey(id)) {
            double saldoAtual = contas.get(id);
            double novoSaldo = saldoAtual + quantia;
            contas.put(id, novoSaldo);
            return "Depósito de " + quantia + " realizado com sucesso. Novo saldo: " + novoSaldo;
        } else {
            return "Conta não encontrada.";
        }
    }

    @PostMapping("/{id}/sacar")
    public String sacar(@PathVariable int id, @RequestParam double quantia) {
        if (contas.containsKey(id)) {
            double saldoAtual = contas.get(id);
            if (quantia <= saldoAtual) {
                double novoSaldo = saldoAtual - quantia;
                contas.put(id, novoSaldo);
                return "Saque de " + quantia + " realizado com sucesso. Novo saldo: " + novoSaldo;
            } else {
                return "Saldo insuficiente para realizar o saque.";
            }
        } else {
            return "Conta não encontrada.";
        }
    }
}
