import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Pessoa");
            System.out.println("2. Círculo");
            System.out.println("3. Conta Bancária");
            System.out.println("4. Triângulo");
            System.out.println("5. Calculadora");
            System.out.println("6. Simulação de Pessoa dirigindo um carro");
            System.out.println("7. Fatura");
            System.out.println("8. Empregado");
            System.out.println("9. Cálculo de Imposto (Pessoa Física/Jurídica)");
            System.out.println("10. Área Calculável (Quadrado, Retângulo e Círculo)");
            System.out.println("11. Sistema Tributável (ContaCorrente e Seguro de Vida)");
            System.out.println("12. Sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    executarPessoa();
                    break;
                case 2:
                    executarCirculo();
                    break;
                case 3:
                    executarContaBancaria();
                    break;
                case 4:
                    executarTriangulo();
                    break;
                case 5:
                    executarCalculadora();
                    break;
                case 6:
                    executarSimulacaoCarro();
                    break;
                case 7:
                    executarFatura();
                    break;
                case 8:
                    executarEmpregado();
                    break;
                case 9:
                    executarCalculoImposto();
                    break;
                case 10:
                    executarAreaCalculavel();
                    break;
                case 11:
                    executarSistemaTributavel();
                    break;
                case 12:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 12);

        scanner.close();
    }

    public static void executarPessoa() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.println("Digite a idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite a profissão: ");
        String profissao = scanner.nextLine();

        Pessoa pessoa = new Pessoa(nome, idade, profissao);
        pessoa.exibirInformacoes();
    }

    public static void executarCirculo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o raio do círculo: ");
        double raio = scanner.nextDouble();

        Circulo circulo = new Circulo(raio);
        System.out.println("Área: " + circulo.calcularArea());
        System.out.println("Perímetro: " + circulo.calcularPerimetro());
    }

    public static void executarContaBancaria() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o número da conta: ");
        scanner.nextLine();
        String numeroConta = scanner.nextLine();
        
        System.out.println("Digite o nome do titular: ");
        String nomeTitular = scanner.nextLine();
        
        System.out.println("Digite o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();
        
        System.out.println("Tipo de conta: 1. Conta Poupança | 2. Conta Especial");
        int tipoConta = scanner.nextInt();
        
        if (tipoConta == 1) {
            System.out.println("Digite o dia de rendimento: ");
            int diaRendimento = scanner.nextInt();
            ContaPoupanca conta = new ContaPoupanca(numeroConta, nomeTitular, saldoInicial, diaRendimento);
            
            int opcao;
            do {
                System.out.println("\nEscolha uma operação:");
                System.out.println("1. Depositar");
                System.out.println("2. Sacar");
                System.out.println("3. Exibir Saldo");
                System.out.println("4. Calcular Novo Saldo com Rendimento");
                System.out.println("5. Sair");
                opcao = scanner.nextInt();
                
                switch (opcao) {
                    case 1:
                        System.out.println("Digite o valor para depósito: ");
                        double deposito = scanner.nextDouble();
                        conta.depositar(deposito);
                        break;
                    case 2:
                        System.out.println("Digite o valor para saque: ");
                        double saque = scanner.nextDouble();
                        conta.sacar(saque);
                        break;
                    case 3:
                        System.out.println("Saldo atual: " + conta.getSaldo());
                        break;
                    case 4:
                        System.out.println("Digite a taxa de rendimento: ");
                        double taxa = scanner.nextDouble();
                        conta.calcularNovoSaldo(taxa);
                        System.out.println("Novo saldo com rendimento: " + conta.getSaldo());
                        break;
                    case 5:
                        System.out.println("Saindo da Conta Poupança...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } while (opcao != 5);
        } else if (tipoConta == 2) {
            System.out.println("Digite o limite da conta especial: ");
            double limite = scanner.nextDouble();
            ContaEspecial conta = new ContaEspecial(numeroConta, nomeTitular, saldoInicial, limite);
            
            int opcao;
            do {
                System.out.println("\nEscolha uma operação:");
                System.out.println("1. Depositar");
                System.out.println("2. Sacar");
                System.out.println("3. Exibir Saldo");
                System.out.println("4. Sair");
                opcao = scanner.nextInt();
                
                switch (opcao) {
                    case 1:
                        System.out.println("Digite o valor para depósito: ");
                        double deposito = scanner.nextDouble();
                        conta.depositar(deposito);
                        break;
                    case 2:
                        System.out.println("Digite o valor para saque: ");
                        double saque = scanner.nextDouble();
                        conta.sacar(saque);
                        break;
                    case 3:
                        System.out.println("Saldo atual: " + conta.getSaldo());
                        break;
                    case 4:
                        System.out.println("Saindo da Conta Especial...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } while (opcao != 4);
        }
    }

    public static void executarTriangulo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o lado 1 do triângulo: ");
        double lado1 = scanner.nextDouble();
        System.out.println("Digite o lado 2 do triângulo: ");
        double lado2 = scanner.nextDouble();
        System.out.println("Digite o lado 3 do triângulo: ");
        double lado3 = scanner.nextDouble();

        Triangulo triangulo = new Triangulo(lado1, lado2, lado3);
        if (triangulo.isValido()) {
            System.out.println("Área: " + triangulo.calcularArea());
        } else {
            System.out.println("Não é um triângulo válido.");
        }
    }

    public static void executarCalculadora() {
        Scanner scanner = new Scanner(System.in);
        List<Double> numeros = new ArrayList<>();
        System.out.println("Digite números (digite -1 para encerrar):");

        double num;
        while ((num = scanner.nextDouble()) != -1) {
            numeros.add(num);
        }

        Calculadora calculadora = new Calculadora(numeros);
        System.out.println("Soma: " + calculadora.soma());
        System.out.println("Subtração: " + calculadora.subtracao());
        System.out.println("Multiplicação: " + calculadora.multiplicacao());
        System.out.println("Divisão: " + calculadora.divisao());
    }

    public static void executarSimulacaoCarro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome da pessoa: ");
        String nome = scanner.nextLine();
        System.out.println("Digite a marca do carro: ");
        String marca = scanner.nextLine();
        System.out.println("Digite a velocidade do carro: ");
        int velocidade = scanner.nextInt();

        Pessoa pessoa = new Pessoa(nome, 30, "Motorista");
        Carro carro = new Carro(marca, velocidade);

        pessoa.dirigir(carro);
    }

    public static void executarFatura() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número da fatura: ");
        String numero = scanner.nextLine();
        System.out.println("Digite a descrição do item: ");
        String descricao = scanner.nextLine();
        System.out.println("Digite a quantidade comprada: ");
        int quantidade = scanner.nextInt();
        System.out.println("Digite o preço por item: ");
        double preco = scanner.nextDouble();

        Fatura fatura = new Fatura(numero, descricao, quantidade, preco);
        System.out.println("Valor total da fatura: " + fatura.getTotalFatura());
    }

    public static void executarEmpregado() {
        Empregado empregado1 = new Empregado("João", "Silva", 2000);
        Empregado empregado2 = new Empregado("Maria", "Oliveira", 2500);

        System.out.println("Salário anual de João: " + empregado1.getSalarioAnual());
        System.out.println("Salário anual de Maria: " + empregado2.getSalarioAnual());

        empregado1.aumentarSalario(10);
        empregado2.aumentarSalario(10);

        System.out.println("Salário anual de João após aumento: " + empregado1.getSalarioAnual());
        System.out.println("Salário anual de Maria após aumento: " + empregado2.getSalarioAnual());
    }

    public static void executarCalculoImposto() {
        Contribuinte[] contribuintes = new Contribuinte[6];
        contribuintes[0] = new PessoaFisica("Carlos", 30000);
        contribuintes[1] = new PessoaFisica("Ana", 25000);
        contribuintes[2] = new PessoaFisica("Pedro", 40000);
        contribuintes[3] = new PessoaJuridica("Empresa A", 500000);
        contribuintes[4] = new PessoaJuridica("Empresa B", 200000);
        contribuintes[5] = new PessoaJuridica("Empresa C", 1000000);

        for (Contribuinte contribuinte : contribuintes) {
            System.out.println("Imposto a pagar por " + contribuinte.getNome() + ": " + contribuinte.calcularImposto());
        }
    }

    public static void executarAreaCalculavel() {
        AreaCalculavel quadrado = new Quadrado(4);
        AreaCalculavel retangulo = new Retangulo(3, 5);
        AreaCalculavel circulo = new Circulo(2);

        System.out.println("Área do quadrado: " + quadrado.calculaArea());
        System.out.println("Área do retângulo: " + retangulo.calculaArea());
        System.out.println("Área do círculo: " + circulo.calculaArea());
    }

    public static void executarSistemaTributavel() {
        Tributavel contaCorrente = new ContaCorrente(5000);
        Tributavel seguroDeVida = new SeguroDeVida();

        System.out.println("Tributos da Conta Corrente: " + contaCorrente.calculaTributos());
        System.out.println("Tributos do Seguro de Vida: " + seguroDeVida.calculaTributos());
    }
}

// Classes adicionais

class Pessoa {
    private String nome;
    private int idade;
    private String profissao;

    public Pessoa(String nome, int idade, String profissao) {
        this.nome = nome;
        this.idade = idade;
        this.profissao = profissao;
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Profissão: " + profissao);
    }

    public void dirigir(Carro carro) {
        System.out.println(nome + " está dirigindo um " + carro.getMarca() + " a " + carro.getVelocidade() + " km/h.");
    }
}

class Circulo implements AreaCalculavel {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double calcularArea() {
        return Math.PI * raio * raio;
    }

    public double calcularPerimetro() {
        return 2 * Math.PI * raio;
    }

    @Override
    public double calculaArea() {
        return calcularArea();
    }
}

class ContaBancaria {
    protected String numeroConta;
    protected String nomeTitular;
    protected double saldo;

    public ContaBancaria(String numeroConta, String nomeTitular, double saldo) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public double getSaldo() {
        return saldo;
    }
}

class ContaPoupanca extends ContaBancaria {
    private int diaRendimento;

    public ContaPoupanca(String numeroConta, String nomeTitular, double saldo, int diaRendimento) {
        super(numeroConta, nomeTitular, saldo);
        this.diaRendimento = diaRendimento;
    }

    public void calcularNovoSaldo(double taxaRendimento) {
        saldo += saldo * (taxaRendimento / 100);
    }
}

class ContaEspecial extends ContaBancaria {
    private double limite;

    public ContaEspecial(String numeroConta, String nomeTitular, double saldo, double limite) {
        super(numeroConta, nomeTitular, saldo);
        this.limite = limite;
    }

    @Override
    public void sacar(double valor) {
        if (saldo + limite >= valor) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente e limite excedido.");
        }
    }
}

class Triangulo {
    private double lado1;
    private double lado2;
    private double lado3;

    public Triangulo(double lado1, double lado2, double lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    public boolean isValido() {
        return lado1 + lado2 > lado3 && lado1 + lado3 > lado2 && lado2 + lado3 > lado1;
    }

    public double calcularArea() {
        double s = (lado1 + lado2 + lado3) / 2;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }
}

class Calculadora {
    private List<Double> numeros;

    public Calculadora(List<Double> numeros) {
        this.numeros = numeros;
    }

    public double soma() {
        double resultado = 0;
        for (double numero : numeros) {
            resultado += numero;
        }
        return resultado;
    }

    public double subtracao() {
        double resultado = numeros.get(0);
        for (int i = 1; i < numeros.size(); i++) {
            resultado -= numeros.get(i);
        }
        return resultado;
    }

    public double multiplicacao() {
        double resultado = 1;
        for (double numero : numeros) {
            resultado *= numero;
        }
        return resultado;
    }

    public double divisao() {
        double resultado = numeros.get(0);
        for (int i = 1; i < numeros.size(); i++) {
            if (numeros.get(i) != 0) {
                resultado /= numeros.get(i);
            } else {
                System.out.println("Erro: divisão por zero.");
                return 0;
            }
        }
        return resultado;
    }
}

class Carro {
    private String marca;
    private int velocidade;

    public Carro(String marca, int velocidade) {
        this.marca = marca;
        this.velocidade = velocidade;
    }

    public String getMarca() {
        return marca;
    }

    public int getVelocidade() {
        return velocidade;
    }
}

class Fatura {
    private String numero;
    private String descricao;
    private int quantidade;
    private double precoPorItem;

    public Fatura(String numero, String descricao, int quantidade, double precoPorItem) {
        this.numero = numero;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.precoPorItem = precoPorItem;
    }

    public double getTotalFatura() {
        if (quantidade < 0) {
            quantidade = 0;
        }
        if (precoPorItem < 0) {
            precoPorItem = 0.0;
        }
        return quantidade * precoPorItem;
    }
}

class Empregado {
    private String nome;
    private String sobrenome;
    private double salarioMensal;

    public Empregado(String nome, String sobrenome, double salarioMensal) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        if (salarioMensal < 0) {
            this.salarioMensal = 0;
        } else {
            this.salarioMensal = salarioMensal;
        }
    }

    public double getSalarioAnual() {
        return salarioMensal * 12;
    }

    public void aumentarSalario(double porcentagem) {
        salarioMensal += salarioMensal * (porcentagem / 100);
    }
}

abstract class Contribuinte {
    protected String nome;
    protected double rendaBruta;

    public Contribuinte(String nome, double rendaBruta) {
        this.nome = nome;
        this.rendaBruta = rendaBruta;
    }

    public String getNome() {
        return nome;
    }

    public abstract double calcularImposto();
}

class PessoaFisica extends Contribuinte {
    public PessoaFisica(String nome, double rendaBruta) {
        super(nome, rendaBruta);
    }

    @Override
    public double calcularImposto() {
        return rendaBruta * 0.15;
    }
}

class PessoaJuridica extends Contribuinte {
    public PessoaJuridica(String nome, double rendaBruta) {
        super(nome, rendaBruta);
    }

    @Override
    public double calcularImposto() {
        return rendaBruta * 0.10;
    }
}

interface AreaCalculavel {
    double calculaArea();
}

class Quadrado implements AreaCalculavel {
    private double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calculaArea() {
        return lado * lado;
    }
}

class Retangulo implements AreaCalculavel {
    private double base;
    private double altura;

    public Retangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calculaArea() {
        return base * altura;
    }
}

interface Tributavel {
    double calculaTributos();
}

class ContaCorrente implements Tributavel {
    private double saldo;

    public ContaCorrente(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public double calculaTributos() {
        return saldo * 0.01;
    }
}

class SeguroDeVida implements Tributavel {

    @Override
    public double calculaTributos() {
        return 42.0;
    }
}
