package br.com.ifpb.atividade.controller;

import br.com.ifpb.atividade.model.Produto;
import br.com.ifpb.atividade.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.List;

@ApiIgnore
@Controller
public class ProdutoController {

    @Autowired
    //ProdutoRepository produtoRepository;
    ProdutoService produtoService;

    @RequestMapping("/accessdenied")
    public String accessdenied(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication(); // Atributos da sessão
        model.addAttribute("auth", auth);

        if (auth != null){
            return "accessdenied";
        }
        return "produto";
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(path = {"/produtos"}, method = {RequestMethod.GET})
    public String  getProdutos(Model model) {
        List<Produto> produtoList = produtoService.findAll();
        model.addAttribute("produtoList", produtoList);

        return "produto";
    }

    @RequestMapping(path = {"/novoproduto"}, method = {RequestMethod.GET})
    public String getContatoForm() {
        return "produtoForm";
    }

    @RequestMapping(path = {"/novoproduto"}, method = {RequestMethod.POST})
    public String createProduto(@Valid Produto produto, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos.");
            return "redirect:/novoproduto";
        }
        produtoService.save(produto);
        return "redirect:/produtos";
    }

    @RequestMapping(path = {"/editproduto"}, method = {RequestMethod.POST})
    public String updateProduto(@Valid Produto produto, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "TODOS OS CAMPOS OBRIGATÓRIOS DEVEM SER PREENCHIDOS!");
            return "redirect:/produtos";
        }
        Produto newproduto = produto;
        produtoService.save(newproduto);
        return "redirect:/produtos";
    }

    @RequestMapping(path = {"/delete/{id}"})
    public String removeProduto(@PathVariable(name="id") Produto produto) {
        produtoService.delete(produto.getId());
        return "redirect:/produtos";
    }

    @RequestMapping(path = {"/produto/{id}"}, method = {RequestMethod.GET})
    public ModelAndView findProdutoById(@PathVariable(name="id") long id) {
        ModelAndView mv = new ModelAndView("editProduto");
        Produto produto = produtoService.findById(id);
        System.out.println(produto.toString());
        mv.addObject("p", produto);
        return mv;
    }
}
