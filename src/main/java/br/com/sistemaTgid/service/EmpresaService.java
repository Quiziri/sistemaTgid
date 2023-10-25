package br.com.sistemaTgid.service;

import br.com.sistemaTgid.model.Empresa;

import java.util.ArrayList;
import java.util.List;

public class EmpresaService {
    private List<Empresa> empresas;

    public EmpresaService() {
        empresas = new ArrayList<>();
    }

    public void adicionarEmpresa(Empresa empresa) {
        empresas.add(empresa);
    }

    public List<Empresa> obterTodasEmpresas() {
        return empresas;
    }

    public Empresa obterEmpresaPorId(int id) {
        for (Empresa empresa : empresas) {
            if (empresa.getId() == id) {
                return empresa;
            }
        }
        return null;
    }

    public void atualizarEmpresa(int id, Empresa novaEmpresa) {
        for (int i = 0; i < empresas.size(); i++) {
            if (empresas.get(i).getId() == id) {
                empresas.set(i, novaEmpresa);
                return;
            }
        }
    }

    public void excluirEmpresa(int id) {
        empresas.removeIf(empresa -> empresa.getId() == id);
    }
}
