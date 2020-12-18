package br.com.ifpb.atividade.service;

import br.com.ifpb.atividade.model.Produto;
import java.util.List;



public interface ProdutoService {
    Produto save(Produto p);
    List<Produto> findAll();
    Produto findById(long id);
    boolean delete(long id);
}
