package Cadastro.CadastroAluno.repository;

import Cadastro.CadastroAluno.models.CadastroModel;
import org.springframework.data.repository.CrudRepository;

public interface CadastroRepository extends CrudRepository <CadastroModel, String> {
}