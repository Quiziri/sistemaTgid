package br.com.sistemaTgid.controller;

import br.com.sistemaTgid.model.Empresa;
import br.com.sistemaTgid.service.EmpresaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class EmpresaController {
    private EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    // Endpoint para criar uma nova empresa
    @PostMapping
    public void adicionarEmpresa(@RequestBody Empresa empresa) {
        empresaService.adicionarEmpresa(empresa);
    }

    // Endpoint para listar todas as empresas
    @GetMapping
    public List<Empresa> listarEmpresas() {
        return empresaService.obterTodasEmpresas();
    }

    @GetMapping("/{id}")
    public Empresa obterEmpresa(@PathVariable int id) {
        return empresaService.obterEmpresaPorId(id);
    }

    @PutMapping("/{id}")
    public void atualizarEmpresa(@PathVariable int id, @RequestBody Empresa novaEmpresa) {
        empresaService.atualizarEmpresa(id, novaEmpresa);
    }

    @DeleteMapping("/{id}")
    public void excluirEmpresa(@PathVariable int id) {
        empresaService.excluirEmpresa(id);
    }
}
