package com.tabacaria.tabacaria.config;

import com.tabacaria.tabacaria.entities.*;
import com.tabacaria.tabacaria.entities.enums.TipoPagamento;
import com.tabacaria.tabacaria.repositories.*;
import com.tabacaria.tabacaria.services.CategoriaService;
import com.tabacaria.tabacaria.services.ClienteService;
import com.tabacaria.tabacaria.services.EnderecoService;
import com.tabacaria.tabacaria.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

@Configuration
@Profile(value = "test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private PedidoProdutoRepository pedidoProdutoRepository;

    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void run(String... args) throws Exception {

        Cliente cliente1 = new Cliente(null, "Fernando", "Fontes", "123", "123", "2003-03-03");
        Endereco endereco1 = new Endereco(null, "Comandante Rubens Silva", "700", "bloco 2, 301", cliente1);
        Endereco endereco2 = new Endereco(null, "Três rios", "100", "bloco 2, 301", cliente1);

        clienteRepository.saveAll(Arrays.asList(cliente1));
        enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2));

        int choice;

        do {
            System.out.println("-=-= Gerenciar =-=-");
            System.out.println("1. Clientes");
            System.out.println("2. Endereços");
            System.out.println("3. Pedidos");
            System.out.println("4. Produtos");
            System.out.println("5. Categorias");
            System.out.println("0. Sair");

            System.out.print("Escolha a opção: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    clientes_interface();
                    break;
                case 2:
                    enderecos_interface();
                    break;
                case 3:
                    //produtos_interface();
                    break;
                case 4:
                    produtos_interface();
                    break;
                case 5:
                    categorias_interface();
                    break;
                case 0:
                    System.out.println("Saindo do programa.");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (choice != 0);

        scanner.close();

    }

    public void clientes_interface() throws ParseException {
        int choice;

        do {
            System.out.println("-=-= CLIENTE =-=-");
            System.out.println("1. Inserir");
            System.out.println("2. Listar");
            System.out.println("3. Atualizar");
            System.out.println("4. Excluir");
            System.out.println("0. Voltar");

            System.out.print("Escolha a opção: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    adicionarCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    atualizarCliente();
                    break;
                case 4:
                    deletarCliente();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (choice != 0);

    }

    public void enderecos_interface() throws ParseException {
        int choice;

        do {
            System.out.println("-=-= ENDEREÇOS =-=-");
            System.out.println("1. Inserir");
            System.out.println("2. Listar");
            System.out.println("3. Atualizar");
            System.out.println("4. Excluir");
            System.out.println("0. Voltar");

            System.out.print("Escolha a opção: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    adicionarEndereco();
                    break;
                case 2:
                    listarEnderecos();
                    break;
                case 3:
                    atualizarEndereco();
                    break;
                case 4:
                    deletarEndereco();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (choice != 0);

    }

    public void categorias_interface() throws ParseException {
        int choice;

        do {
            System.out.println("-=-= CATEGORIA =-=-");
            System.out.println("1. Inserir");
            System.out.println("2. Listar");
            System.out.println("3. Atualizar");
            System.out.println("4. Excluir");
            System.out.println("0. Voltar");

            System.out.print("Escolha a opção: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    adicionarCategoria();
                    break;
                case 2:
                    listarCategorias();
                    break;
                case 3:
                    atualizarCategoria();
                    break;
                case 4:
                    deletarCategoria();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (choice != 0);

    }

    public void produtos_interface() throws ParseException {
        int choice;

        do {
            System.out.println("-=-= PRODUTO =-=-");
            System.out.println("1. Inserir");
            System.out.println("2. Listar");
            System.out.println("3. Atualizar");
            System.out.println("4. Excluir");
            System.out.println("0. Voltar");

            System.out.print("Escolha a opção: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    atualizarProduto();
                    break;
                case 4:
                    deletarProduto();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (choice != 0);

    }

    private void adicionarCategoria() throws ParseException {

        System.out.print("Nome da categoria: ");
        String nome = scanner.nextLine();

        Categoria novaCategoria = new Categoria();
        novaCategoria.setName(nome);

        categoriaService.salvarCategoria(novaCategoria);
        System.out.println("Categoria adicionada com sucesso!");

    }

    private void adicionarEndereco(){
        System.out.print("Digite o ID do Cliente que deseja adicionar um endereço: ");
        Long clienteId = scanner.nextLong();
        scanner.nextLine();

        Optional<Cliente> clienteOptional = clienteRepository.findById(clienteId);

        if (clienteOptional.isPresent()){

            Cliente cliente = clienteOptional.get();

            System.out.print("Rua do Cliente: ");
            String rua = scanner.nextLine();

            System.out.print("Número do Cliente: ");
            String numero = scanner.nextLine();

            System.out.print("Complemento do Cliente: ");
            String complemento = scanner.nextLine();

            Endereco novoEndereco = new Endereco();
            novoEndereco.setCliente(cliente);
            novoEndereco.setRoad(rua);
            novoEndereco.setNumber(numero);
            novoEndereco.setComplement(complemento);

            enderecoService.salvarEndereco(novoEndereco);
            System.out.println("Endereço adicionado com sucesso");

        }
        else{
            System.out.println("Cliente não existe");
        }

    }

    private void adicionarProduto() {
        System.out.print("Digite o ID da Categoria que deseja adicionar ao produto: ");
        Long categoriaId = scanner.nextLong();
        scanner.nextLine();

        Optional<Categoria> categoriaOptional = categoriaRepository.findById(categoriaId);

        if (categoriaOptional.isPresent()) {

            System.out.print("Nome do produto: ");
            String nome = scanner.nextLine();

            System.out.print("Preço: ");
            Double price = scanner.nextDouble();

            System.out.print("Quantidade em estoque: ");
            Integer estoque = scanner.nextInt();

            Produto novoProduto = new Produto();
            novoProduto.setName(nome);
            novoProduto.setPrice(price);
            novoProduto.setStock(estoque);
            novoProduto.setCategoria(categoriaOptional.get());

            produtoService.salvarProduto(novoProduto);
            System.out.println("Produto adicionado com sucesso");

        } else {
            System.out.println("Categoria não existe");
        }
    }

    private void adicionarCliente() throws ParseException {
        Date date_birth;

        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();

        System.out.print("Sobrenome do Cliente: ");
        String sobrenome = scanner.nextLine();

        System.out.print("CPF do Cliente: ");
        String cpf = scanner.nextLine();

        System.out.print("E-mail do Cliente: ");
        String email = scanner.nextLine();

        System.out.print("Data de nascimento do Cliente: ");
        String string_date_birth = scanner.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        date_birth = dateFormat.parse(string_date_birth);

        Cliente novoCliente = new Cliente();
        novoCliente.setName(nome);
        novoCliente.setLastname(sobrenome);
        novoCliente.setCpf(cpf);
        novoCliente.setEmail(email);
        novoCliente.setDate_birth(date_birth);

        clienteService.salvarCliente(novoCliente);
        System.out.println("Cliente adicionado com sucesso!");

    }

    private void listarCategorias() {
        List<Categoria> categorias = categoriaService.findAll();
        for (Categoria categoria : categorias) {
            System.out.println(categorias);
        }
    }

    private void listarProdutos() {
        List<Produto> produtos = produtoService.findAll();
        for (Produto produto : produtos) {
            System.out.println(produtos);
        }
    }

    private void listarEnderecos() {
        List<Endereco> enderecos = enderecoService.findAll();
        for (Endereco endereco : enderecos) {
            System.out.println(endereco);
        }
    }

    private void listarClientes() {
        List<Cliente> clientes = clienteService.findAll();
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    private void deletarProduto() {
        System.out.print("Digite o ID da Produto a ser excluída: ");
        Long produtoId = scanner.nextLong();
        scanner.nextLine();

        Optional<Produto> produtoOptional = produtoRepository.findById(produtoId);

        if (produtoOptional.isPresent()) {
            produtoService.deleteProduto(produtoId);
            System.out.println("Produto excluído com sucesso!");
        } else {
            System.out.println("Produto não encontrado com o ID fornecido.");
        }
    }

    private void deletarCategoria() {
        System.out.print("Digite o ID da Categoria a ser excluída: ");
        Long categoriaId = scanner.nextLong();
        scanner.nextLine();

        Optional<Categoria> categoriaOptional = categoriaRepository.findById(categoriaId);

        if (categoriaOptional.isPresent()) {
            categoriaService.deleteCategoria(categoriaId);
            System.out.println("Categoria excluída com sucesso!");
        } else {
            System.out.println("Categoria não encontrada com o ID fornecido.");
        }
    }

    private void deletarEndereco(){
        System.out.print("Digite o ID do Endereço a ser excluído: ");
        Long enderecoId = scanner.nextLong();
        scanner.nextLine();

        Optional<Endereco> enderecoOptional = enderecoRepository.findById(enderecoId);

        if (enderecoOptional.isPresent()) {
            enderecoService.deleteEndereco(enderecoId);
            System.out.println("Endereço excluído com sucesso!");
        } else {
            System.out.println("Endereço não encontrado com o ID fornecido.");
        }
    }

    private void deletarCliente() {
        System.out.print("Digite o ID do Cliente a ser excluído: ");
        Long clienteId = scanner.nextLong();
        scanner.nextLine();

        Optional<Cliente> clienteOptional = clienteRepository.findById(clienteId);

        if (clienteOptional.isPresent()) {
            clienteService.deleteCliente(clienteId);
            System.out.println("Cliente excluído com sucesso!");
        } else {
            System.out.println("Cliente não encontrado com o ID fornecido.");
        }
    }

    private void atualizarEndereco() throws ParseException {
        System.out.print("Digite o ID do Endereço a ser atualizado: ");
        Long enderecoId = scanner.nextLong();
        scanner.nextLine();

        Optional<Endereco> enderecoOptional = enderecoRepository.findById(enderecoId);

        if (enderecoOptional.isPresent()) {
            Endereco enderecoAtualizado = obterDadosAtualizadosEndereco(enderecoOptional.get());

            enderecoService.update(enderecoId, enderecoAtualizado);

            System.out.println("Endereço atualizado com sucesso!");
        } else {
            System.out.println("Endereço não encontrado com o ID fornecido.");
        }
    }

    private Endereco obterDadosAtualizadosEndereco(Endereco enderecoExiste) throws ParseException {
        System.out.println("Digite os novos dados do Endereço (pressione Enter para manter os dados existentes):");

        System.out.print("Nova rua [" + enderecoExiste.getRoad() + "]: ");
        String novoNome = scanner.nextLine();

        System.out.print("Nova número [" + enderecoExiste.getNumber() + "]: ");
        String novoSobrenome = scanner.nextLine();

        System.out.print("Novo complemento [" + enderecoExiste.getComplement() + "]: ");
        String novoCpf = scanner.nextLine();

        System.out.print("Novo cliente [" + enderecoExiste.getCliente().getId() + "]: ");
        Long novoCliente = scanner.nextLong();

        Optional<Cliente> clienteOptional = clienteRepository.findById(novoCliente);

        if (clienteOptional.isPresent()) {

            Endereco enderecoAtualizado = new Endereco();
            enderecoAtualizado.setId(enderecoExiste.getId());
            enderecoAtualizado.setRoad(novoNome.isEmpty() ? enderecoExiste.getRoad() : novoNome);
            enderecoAtualizado.setNumber(novoSobrenome.isEmpty() ? enderecoExiste.getNumber() : novoSobrenome);
            enderecoAtualizado.setComplement(novoCpf.isEmpty() ? enderecoExiste.getComplement() : novoCpf);
            enderecoAtualizado.setCliente(clienteOptional.get());

            return enderecoAtualizado;
        }
        else{

            Endereco enderecoAtualizado = new Endereco();
            enderecoAtualizado.setId(enderecoExiste.getId());
            enderecoAtualizado.setRoad(novoNome.isEmpty() ? enderecoExiste.getRoad() : novoNome);
            enderecoAtualizado.setNumber(novoSobrenome.isEmpty() ? enderecoExiste.getNumber() : novoSobrenome);
            enderecoAtualizado.setComplement(novoCpf.isEmpty() ? enderecoExiste.getComplement() : novoCpf);

            return enderecoAtualizado;
        }
    }


    private void atualizarProduto() throws ParseException {
        System.out.print("Digite o ID do Produto a ser atualizado: ");
        Long produtoId = scanner.nextLong();
        scanner.nextLine();

        Optional<Produto> produtoOptional = produtoRepository.findById(produtoId);

        if (produtoOptional.isPresent()) {
            Produto produtoAtualizado = obterDadosAtualizadosProduto(produtoOptional.get());

            produtoService.update(produtoId, produtoAtualizado);

        } else {
            System.out.println("Produto não encontrado com o ID fornecido.");
        }
    }

    private Produto obterDadosAtualizadosProduto(Produto produtoExiste) throws ParseException {
        System.out.println("Digite os novos dados do Produto:");

        System.out.print("Novo Nome do Produto [" + produtoExiste.getName() + "]: ");
        String novoNome = scanner.nextLine();

        System.out.print("Novo Preço do Produto [" + produtoExiste.getPrice() + "]: ");
        Double novoPreco = scanner.nextDouble();

        System.out.print("Nova Quantidade em estoque [" + produtoExiste.getStock() + "]: ");
        Integer novoEstoque = scanner.nextInt();

        System.out.print("Nova Categoria [" + produtoExiste.getCategoria().getName() + " (id=" + produtoExiste.getCategoria().getId() + ")]: ");
        Long novaCategoria = scanner.nextLong();

        Optional<Categoria> categoriaOptional = categoriaRepository.findById(novaCategoria);

        if (categoriaOptional.isPresent()) {

            Produto produtoAtualizado = new Produto();
            produtoAtualizado.setId(produtoExiste.getId());
            produtoAtualizado.setName(novoNome.isEmpty() ? produtoExiste.getName() : novoNome);
            produtoAtualizado.setPrice(novoPreco);
            produtoAtualizado.setStock(novoEstoque);
            produtoAtualizado.setCategoria(categoriaOptional.get());

            System.out.println("Produto e Categoria atualizado com sucesso!");
            return produtoAtualizado;
        }
        else{

            Produto produtoAtualizado = new Produto();
            produtoAtualizado.setId(produtoExiste.getId());
            produtoAtualizado.setName(novoNome.isEmpty() ? produtoExiste.getName() : novoNome);
            produtoAtualizado.setPrice(novoPreco);
            produtoAtualizado.setStock(novoEstoque);

            System.out.println("Produto atualizado com sucesso!");
            return produtoAtualizado;
        }
    }

    private void atualizarCliente() throws ParseException {
        System.out.print("Digite o ID do Cliente a ser atualizado: ");
        Long clienteId = scanner.nextLong();
        scanner.nextLine();

        Optional<Cliente> clienteOptional = clienteRepository.findById(clienteId);

        if (clienteOptional.isPresent()) {
            Cliente clienteAtualizado = obterDadosAtualizados(clienteOptional.get());

            clienteService.update(clienteId, clienteAtualizado);

            System.out.println("Cliente atualizado com sucesso!");
        } else {
            System.out.println("Cliente não encontrado com o ID fornecido.");
        }
    }

    private Cliente obterDadosAtualizados(Cliente clienteExistente) throws ParseException {
        System.out.println("Digite os novos dados do Cliente (pressione Enter para manter os dados existentes):");

        System.out.print("Novo Nome do Cliente [" + clienteExistente.getName() + "]: ");
        String novoNome = scanner.nextLine();

        System.out.print("Novo Sobrenome do Cliente [" + clienteExistente.getLastname() + "]: ");
        String novoSobrenome = scanner.nextLine();

        System.out.print("Novo CPF do Cliente [" + clienteExistente.getCpf() + "]: ");
        String novoCpf = scanner.nextLine();

        System.out.print("Novo E-mail do Cliente [" + clienteExistente.getEmail() + "]: ");
        String novoEmail = scanner.nextLine();

        System.out.print("Nova Data de Nascimento do Cliente [" + clienteExistente.getDate_birth() + "]: ");
        String novaDataNascimento = scanner.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date novaData = novaDataNascimento.isEmpty() ? clienteExistente.getDate_birth() : dateFormat.parse(novaDataNascimento);

        Cliente clienteAtualizado = new Cliente();
        clienteAtualizado.setId(clienteExistente.getId());
        clienteAtualizado.setName(novoNome.isEmpty() ? clienteExistente.getName() : novoNome);
        clienteAtualizado.setLastname(novoSobrenome.isEmpty() ? clienteExistente.getLastname() : novoSobrenome);
        clienteAtualizado.setCpf(novoCpf.isEmpty() ? clienteExistente.getCpf() : novoCpf);
        clienteAtualizado.setEmail(novoEmail.isEmpty() ? clienteExistente.getEmail() : novoEmail);
        clienteAtualizado.setDate_birth(novaData);

        return clienteAtualizado;
    }

    private void atualizarCategoria() throws ParseException {
        System.out.print("Digite o ID do categoria a ser atualizado: ");
        Long categoriaId = scanner.nextLong();
        scanner.nextLine();

        Optional<Categoria> categoriaOptional = categoriaRepository.findById(categoriaId);

        if (categoriaOptional.isPresent()) {
            Categoria categoriaAtualzida = obterDadosAtualizadosCategoria(categoriaOptional.get());

            categoriaService.update(categoriaId, categoriaAtualzida);

            System.out.println("Cliente atualizado com sucesso!");
        } else {
            System.out.println("Cliente não encontrado com o ID fornecido.");
        }
    }

    private Categoria obterDadosAtualizadosCategoria(Categoria categoriaExistente) throws ParseException {
        System.out.println("Digite os novos dados do Categoria (pressione Enter para manter os dados existentes):");

        System.out.print("Novo nome da Categoria [" + categoriaExistente.getName() + "]: ");
        String novoNome = scanner.nextLine();

        Categoria categoriaAtualizada = new Categoria();
        categoriaAtualizada.setId(categoriaExistente.getId());
        categoriaAtualizada.setName(novoNome.isEmpty() ? categoriaExistente.getName() : novoNome);

        return categoriaAtualizada;
    }


}
