import java.util.ArrayList;
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
            System.out.println("6. Sair");
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
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 6);

        scanner.close();
    }

    public static void executarPessoa() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        System.out.println("Idade: ");
        int idade = scanner.nextInt();
        System.out.println("Profissão: ");
        String profissao = scanner.next();

        Pessoa pessoa = new Pessoa(nome, idade, profissao);
        pessoa.exibirInformacoes();
    }

    public static void executarCirculo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Raio do círculo: ");
        double raio = scanner.nextDouble();

        Circulo circulo = new Circulo(raio);
        System.out.println("Área: " + circulo.calcularArea());
        System.out.println("Perímetro: " + circulo.calcularPerimetro());
    }

    public static void executarContaBancaria() {
        ContaBancaria conta = new ContaBancaria("12345", "Maria", 1000.0);
        conta.depositar(500);
        conta.sacar(200);
        System.out.println("Saldo final: " + conta.getSaldo());
    }

    public static void executarTriangulo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lado 1: ");
        double lado1 = scanner.nextDouble();
        System.out.println("Lado 2: ");
        double lado2 = scanner.nextDouble();
        System.out.println("Lado 3: ");
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
        ArrayList<Double> numeros = new ArrayList<>();
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
}

class Pessoa {
    private String nome;
    private int idade;
    private String profissao;

    public Pessoa(String nome, int idade, String profissao) {
        this.nome = nome;
        this.idade = idade;
        this.profissao = profissao;
    }

    public int calcularAnosBissextos() {
        int bissextos = 0;
        for (int i = 1; i <= idade; i++) {
            if ((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0)) {
                bissextos++;
            }
        }
        return bissextos;
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Profissão: " + profissao);
        System.out.println("Anos bissextos vividos: " + calcularAnosBissextos());
    }
}

class Circulo {
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
}

class ContaBancaria {
    private String numeroConta;
    private String nomeTitular;
    private double saldo;

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
    private ArrayList<Double> numeros;

    public Calculadora(ArrayList<Double> numeros) {
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
