package med.vol.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.vol.api.medico.DadosCadastrosMedico;
import med.vol.api.medico.DadosListagemMedico;
import med.vol.api.medico.Medico;
import med.vol.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
@CrossOrigin(origins = "http://localhost:8080/medicos", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastrosMedico dados) {
        repository.save(new Medico(dados));
    }
@GetMapping
public DadosListagemMedico[] listar() {
    // Simulando a busca dos médicos do repositório
    Medico[] medicos = repository.findAll().toArray(new Medico[0]); // Supondo que repository.findAll() retorna um array de Medico

    // Criando a pilha para armazenar os DadosListagemMedico
    Pilha<DadosListagemMedico> pilha = new Pilha<>(medicos.length);

    // Colocando os médicos na pilha
    for (Medico medico : medicos) {
        pilha.push(new DadosListagemMedico(medico));
    }

    // Criando um array para armazenar os resultados
    DadosListagemMedico[] dadosListagem = new DadosListagemMedico[pilha.size()];

    // Transferindo os dados da pilha para o array (removendo da pilha)
    for (int i = 0; i < dadosListagem.length; i++) {
        dadosListagem[i] = pilha.pop();
    }

    // Retorna o array de DadosListagemMedico
    return dadosListagem;
}
}

