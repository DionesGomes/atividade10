package br.com.ifpb.atividade.repository;

import br.com.ifpb.atividade.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
