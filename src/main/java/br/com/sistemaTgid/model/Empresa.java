package br.com.sistemaTgid.model;

import br.com.sistemaTgid.util.VerificaCnpj;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import static br.com.sistemaTgid.util.VerificaCpf.verificarCpf;

public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String razao;
    private String cnpj;

    private double saldo;

    public Empresa(String nome, int idade, String cpf, String email, Empresa empresa) {
        if (verificaCnpj(cnpj)) {
            this.razao = razao;
            this.cnpj = cnpj;
            this.saldo = 0;
        } else {
            System.out.println("Empresa não cadastrada");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    private boolean verificaCnpj(String cnpj) {
        boolean verificado = VerificaCnpj.verificarCnpj(cnpj);
        if (verificado) {
            System.out.println("Válidado");
        } else {
            System.out.println("CNPJ Invalido");
        }
        return verificado;
    }

    @Override
    public String toString(){
        return "Empresa " + id +
                "razão social: " + razao +
                "CNPJ: " + cnpj +
                "saldo" + saldo;
    }
}
