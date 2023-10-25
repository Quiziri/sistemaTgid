package br.com.sistemaTgid.model;

import br.com.sistemaTgid.util.VerificaCpf;

import javax.persistence.*;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private Integer idade;
    private String email;
    @ManyToOne
    private Empresa empresa;

    public Cliente(String nome, int idade, String cpf, String email, Empresa empresa) {
        if (verificaCpf(cpf)) {
            this.nome = nome;
            this.idade = idade;
            this.cpf = cpf;
            this.email = email;
            this.empresa = empresa;
        } else {
            System.out.println("cliente não cadastrado");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public boolean verificaCpf(String cpf) {
        boolean verificado = VerificaCpf.verificarCpf(cpf);
        if (verificado) {
            System.out.println("Válidado");
        } else {
            System.out.println("CPF Invalido");
        }
        return verificado;
    }

    @Override
    public String toString(){
        return  "nome: " + nome +
                "idade: " + idade +
                "CPF: " + cpf +
                "Email: " + email +
                "Cliente de: " + empresa.getRazao() +
                "Saldo disponível: " + empresa.getSaldo();
    }
}
