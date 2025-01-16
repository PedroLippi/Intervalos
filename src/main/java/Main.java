import java.util.Scanner;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        Intervalo intervalo1 = null;
        Intervalo intervalo2 = null;

        while (opcao != 8) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Criar o primeiro intervalo");
            System.out.println("2 - Criar o segundo intervalo");
            System.out.println("3 - Verificar se um valor está no primeiro intervalo");
            System.out.println("4 - Verificar se os intervalos se interceptam");
            System.out.println("5 - Calcular a média do primeiro intervalo");
            System.out.println("6 - Calcular o produto dos dois intervalos");
            System.out.println("7 - Calcular a união dos dois intervalos");
            System.out.println("8 - Sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Criar o primeiro intervalo
                    System.out.print("Digite o limite inferior do primeiro intervalo: ");
                    int inf1 = scanner.nextInt();
                    System.out.print("Digite o limite superior do primeiro intervalo: ");
                    int sup1 = scanner.nextInt();
                    System.out.print("O limite inferior é fechado? (true/false): ");
                    boolean fechInf1 = scanner.nextBoolean();
                    System.out.print("O limite superior é fechado? (true/false): ");
                    boolean fechSup1 = scanner.nextBoolean();

                    intervalo1 = new Intervalo(inf1, sup1, fechInf1, fechSup1);
                    System.out.println("Primeiro intervalo criado: " + intervalo1.formatarIntervalo(intervalo1.getInf(), intervalo1.getSup(), intervalo1.isFechInf(), intervalo1.isFechSup()));
                    break;

                case 2:
                    // Criar o segundo intervalo
                    System.out.print("Digite o limite inferior do segundo intervalo: ");
                    int inf2 = scanner.nextInt();
                    System.out.print("Digite o limite superior do segundo intervalo: ");
                    int sup2 = scanner.nextInt();
                    System.out.print("O limite inferior é fechado? (true/false): ");
                    boolean fechInf2 = scanner.nextBoolean();
                    System.out.print("O limite superior é fechado? (true/false): ");
                    boolean fechSup2 = scanner.nextBoolean();

                    intervalo2 = new Intervalo(inf2, sup2, fechInf2, fechSup2);
                    System.out.println("Segundo intervalo criado: " + intervalo2.formatarIntervalo(intervalo2.getInf(), intervalo2.getSup(), intervalo2.isFechInf(), intervalo2.isFechSup()));
                    break;

                case 3:
                    // Verificar se um valor está no primeiro intervalo
                    if (intervalo1 == null) {
                        System.out.println("Primeiro, crie o primeiro intervalo.");
                    } else {
                        System.out.print("Digite o valor a ser verificado no primeiro intervalo: ");
                        int valor1 = scanner.nextInt();
                        if (intervalo1.contem(valor1)) {
                            System.out.println(valor1 + " está no primeiro intervalo " + intervalo1.formatarIntervalo(intervalo1.getInf(), intervalo1.getSup(), intervalo1.isFechInf(), intervalo1.isFechSup()));
                        } else {
                            System.out.println(valor1 + " não está no primeiro intervalo " + intervalo1.formatarIntervalo(intervalo1.getInf(), intervalo1.getSup(), intervalo1.isFechInf(), intervalo1.isFechSup()));
                        }
                    }
                    break;

                case 4:
                    // Verificar se os intervalos se interceptam
                    if (intervalo1 == null || intervalo2 == null) {
                        System.out.println("Primeiro, crie os dois intervalos.");
                    } else {
                        if (intervalo1.intercepta(intervalo2)) {
                            System.out.println("Os intervalos se interceptam.");
                        } else {
                            System.out.println("Os intervalos não se interceptam.");
                        }
                    }
                    break;

                case 5:
                    // Calcular a média do primeiro intervalo
                    if (intervalo1 == null) {
                        System.out.println("Primeiro, crie o primeiro intervalo.");
                    } else {
                        try {
                            float media1 = intervalo1.media();
                            System.out.println("A média do primeiro intervalo " + intervalo1.formatarIntervalo(intervalo1.getInf(), intervalo1.getSup(), intervalo1.isFechInf(), intervalo1.isFechSup()) + " é " + media1);
                        } catch (IllegalStateException e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                    }
                    break;

                case 6:
                    // Calcular o produto dos dois intervalos
                    if (intervalo1 == null || intervalo2 == null) {
                        System.out.println("Primeiro, crie os dois intervalos.");
                    } else {
                        Intervalo produto = intervalo1.produto(intervalo2);
                        System.out.println("O produto dos dois intervalos é: " + produto.formatarIntervalo(produto.getInf(), produto.getSup(), produto.isFechInf(), produto.isFechSup()));
                    }
                    break;

                case 7:
                    // Calcular a união dos dois intervalos
                    if (intervalo1 == null || intervalo2 == null) {
                        System.out.println("Primeiro, crie os dois intervalos.");
                    } else {
                        String uniao = intervalo1.uniao(intervalo2);
                        System.out.println("A união dos dois intervalos é: " + uniao);
                    }
                    break;

                case 8:
                    // Sair
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }
}
