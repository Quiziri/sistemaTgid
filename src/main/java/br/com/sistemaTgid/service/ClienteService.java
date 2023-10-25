package br.com.sistemaTgid.service;

import br.com.sistemaTgid.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    private List<Cliente> clientes;

    public ClienteService() {
        clientes = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Cliente> obterTodosClientes() {
        return clientes;
    }

    public Cliente obterClientePorId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    public void atualizarCliente(int id, Cliente novoCliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == id) {
                clientes.set(i, novoCliente);
                return;
            }
        }
    }

    public void excluirCliente(int id) {
        clientes.removeIf(cliente -> cliente.getId() == id);
    }
}
