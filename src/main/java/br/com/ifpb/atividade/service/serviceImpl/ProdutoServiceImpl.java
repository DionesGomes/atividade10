package br.com.ifpb.atividade.service.serviceImpl;

import java.util.List;

import br.com.ifpb.atividade.model.Produto;
import br.com.ifpb.atividade.repository.ProdutoRepository;
import br.com.ifpb.atividade.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public Produto save(Produto p) {
        return produtoRepository.save(p);
    }

    @Override
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto findById(long id) {
        return produtoRepository.getOne(id);
    }

    @Override
    public boolean delete(long id) {
        produtoRepository.deleteById(id);
        return true;
    }
    
}
