package com.lopes.curso;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lopes.curso.domain.Categoria;
import com.lopes.curso.domain.Cidade;
import com.lopes.curso.domain.Cliente;
import com.lopes.curso.domain.Endereco;
import com.lopes.curso.domain.Estado;
import com.lopes.curso.domain.ItemPedido;
import com.lopes.curso.domain.Pagamento;
import com.lopes.curso.domain.PagamentoComBoleto;
import com.lopes.curso.domain.PagamentoComCartao;
import com.lopes.curso.domain.Pedido;
import com.lopes.curso.domain.Produto;
import com.lopes.curso.domain.enums.EstadoPagamento;
import com.lopes.curso.domain.enums.TipoCliente;
import com.lopes.curso.repositories.CategoriaRepository;
import com.lopes.curso.repositories.CidadeRepository;
import com.lopes.curso.repositories.ClienteRepository;
import com.lopes.curso.repositories.EnderecoRepository;
import com.lopes.curso.repositories.EstadoRepository;
import com.lopes.curso.repositories.ItemPedidoRepository;
import com.lopes.curso.repositories.PagamentoRepository;
import com.lopes.curso.repositories.PedidoRepository;
import com.lopes.curso.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null,"Escritório");
		Categoria cat3 = new Categoria(null,"Cama mesa e banho");
		Categoria cat4 = new Categoria(null,"pokemons");
		Categoria cat5 = new Categoria(null,"Narcóticos");
		Categoria cat6 = new Categoria(null,"Web namoradas");
		Categoria cat7 = new Categoria(null,"Tatuagens");

		Produto p1 = new Produto(null,"computador",2000.00);
		Produto p2 = new Produto(null,"impressora",800.00);
		Produto p3 = new Produto(null,"mouse",82.00);
		Produto p4 = new Produto(null,"teclado",40.00);
		Produto p5 = new Produto(null,"pikachu",5.00);
		Produto p6 = new Produto(null,"squirtle",100.00);
		Produto p7 = new Produto(null,"fronha",232.00);
		Produto p8 = new Produto(null,"floral",32.00);
		Produto p9 = new Produto(null,"tartarugas ninjas",820.00);
		Produto p10 = new Produto(null,"travesseiro",532.00);
		Produto p11 = new Produto(null,"grampeador",9000.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3,p4));
		cat2.getProdutos().addAll(Arrays.asList(p2,p11));
		cat3.getProdutos().addAll(Arrays.asList(p7,p10));
		cat4.getProdutos().addAll(Arrays.asList(p5,p6));
		cat7.getProdutos().addAll(Arrays.asList(p8,p9));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		p4.getCategorias().addAll(Arrays.asList(cat1));
		p5.getCategorias().addAll(Arrays.asList(cat4));
		p6.getCategorias().addAll(Arrays.asList(cat4));
		p7.getCategorias().addAll(Arrays.asList(cat3));
		p8.getCategorias().addAll(Arrays.asList(cat7));
		p9.getCategorias().addAll(Arrays.asList(cat7));
		p10.getCategorias().addAll(Arrays.asList(cat3));
		p11.getCategorias().addAll(Arrays.asList(cat2));
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5,cat6,cat7));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null,"São Paulo");
		
		Cidade c1 = new Cidade(null,"Uberlandia",est1);
		Cidade c2 = new Cidade(null,"São Paulo",est2);
		Cidade c3 = new Cidade(null,"Campinas",est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "Maria silva", "maria@gmail.com", "123123", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("40028922","éofunkdoyudiquevaidarplaystaton2"));
		Cliente cli2 = new Cliente(null, "FODASE silva", "mariajamal@gmail.com", "123123", TipoCliente.PESSOAFISICA);
		cli2.getTelefones().addAll(Arrays.asList("203819231","128312983"));
		
		Endereco e1 = new Endereco(null,"Rua flores","300", "apto 203", "jardim","298137812",cli1,c1);
		Endereco e2 = new Endereco(null,"Av fodase","123", "apto 123", "fodasi","212312",cli1,c2);
		Endereco e3 = new Endereco(null,"Av fodaseFodase","123fodase", "apto 123fodase", "fodasifodase","212312fodase",cli2,c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		cli2.getEnderecos().addAll(Arrays.asList(e3));
		
		clienteRepository.saveAll(Arrays.asList(cli1,cli2));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"),cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 12:32"),cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null,EstadoPagamento.QUITADO,ped1,6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null,EstadoPagamento.PENDENTE,ped2,sdf.parse("20/10/2017 00:00"),null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItems().addAll(Arrays.asList(ip1,ip2));
		ped2.getItems().addAll(Arrays.asList(ip3));
		
		p1.getItems().addAll(Arrays.asList(ip1));
		p2.getItems().addAll(Arrays.asList(ip3));
		p3.getItems().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
		
		
		
	}

}
