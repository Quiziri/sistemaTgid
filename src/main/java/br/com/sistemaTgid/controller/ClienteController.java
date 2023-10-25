package br.com.sistemaTgid.controller;

import br.com.sistemaTgid.model.Cliente;
import br.com.sistemaTgid.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ClienteController {
    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public void adicionarCliente(@RequestBody Cliente cliente) {
        clienteService.adicionarCliente(cliente);
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.obterTodosClientes();
    }

    @GetMapping("/{id}")
    public Cliente obterCliente(@PathVariable int id) {
        return clienteService.obterClientePorId(id);
    }

    @PutMapping("/{id}")
    public void atualizarCliente(@PathVariable int id, @RequestBody Cliente novoCliente) {
        clienteService.atualizarCliente(id, novoCliente);
    }

    @DeleteMapping("/{id}")
    public void excluirCliente(@PathVariable int id) {
        clienteService.excluirCliente(id);
    }
}
