package br.com.ifpb.atividade.controller;

import br.com.ifpb.atividade.model.Produto;
import br.com.ifpb.atividade.service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "API REST Produto")
@RestController
@RequestMapping(value = "/api")
public class ProdutoApiController {

    @Autowired
    ProdutoService produtoService;

    @ApiOperation(value = "Retorna uma lista de Produtos")
    @GetMapping("/produtos")
    public List<Produto> listaProdutos() {
        return produtoService.findAll();
    }

    @ApiOperation(value = "Retorna um produto unico")
    @GetMapping("/produto/{id}")
    public @ResponseBody Produto listaProdutoUnico(@PathVariable(value = "id") long id) {
        Produto produto = produtoService.findById(id);
        return produto;
    }

    @ApiOperation(value="Salva um produto")
    @PostMapping("/produto")
    public @ResponseBody Produto salvaProduto(@RequestBody @Valid Produto produto) {
        return produtoService.save(produto);
    }

    @ApiOperation(value="Deleta um produto")
    @DeleteMapping("/produto")
    public @ResponseBody boolean deletaProduto(long id) {
        return produtoService.delete(id);
    }

    @ApiOperation(value="Atualiza um produto")
    @PutMapping("/produto")
    public @ResponseBody Produto atualizaProduto(@RequestBody @Valid Produto produto) {
        return produtoService.save(produto);
    }
}
