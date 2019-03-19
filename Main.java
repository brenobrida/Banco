import java.util.Scanner;

public class Main {

    /*
        Disponível até: Tuesday, 12 Mar 2019, 23:55
        Arquivos requeridos: Main.java (Baixar)
        Número máximo de arquivos: 6
        Tipo de trabalho: Trabalho individual
        Identifique as classes, atributos e métodos necessários para modelar e implementar:

        a) Uma ContaCorrente que possui um número, um saldo, um status que informa se ela tem cheque especial ou não,
         e seu limite de cheque especial, um limite de saque e um conjunto de movimentações. Crie uma classe Conta como superclasse.

        b) Uma ContaPoupanca que possui uma variação e um valor de rendimento mensal. O limite de saque da poupança é o mesmo da conta corrente.

        b) Uma Movimentação que possui uma descrição, um valor e uma informação se ela é uma movimentação de depósito ou saque.

        c) Um Banco que armazene um conjunto de Contas e forneça métodos que permitam que sejam feitas criações de conta,
         exclusão de contas, saques*, depósitos, emissão de saldo e extrato e transferência entre contas.

        d) Uma classe Main que permita testar suas classes

        *uma conta corrente só pode fazer saques desde que o valor não exceda o saldo e o limite de saque,
         *  somado ao limite do cheque especial, se ela tiver. uma conta poupança só pode fazer saques desde que o valor não exceda o saldo e o limite de saque.
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Banco banco = new Banco();

        String menu = "1. Criar conta\n" +
                "2. Deletar conta\n" +
                "3. Fazer movimentacao\n" +
                "4. Gerar extrato\n" +
                "5. Terminar\n";

        String movimentacao_menu = "1.Saque\n" +
                "2.Deposito\n" +
                "3. Transferencia\n" +
                "4. Nenhuma\n";

        String conta_menu = "1. Conta Corrente\n" +
                "2. Conta Poupanca\n";

        int choice = -1;
        double value;

        while(choice != 5) {

            System.out.println(menu);
            System.out.println("Digite Acao: ");
            choice = input.nextInt();

            switch(choice) {

                case 1:
                    System.out.print(conta_menu);
                    System.out.print("Escolha o tipo de conta: ");
                    choice = input.nextInt();
                    if(choice == 1 || choice == 2) banco.criar_conta(choice);
                    break;
                case 2:
                    System.out.println(banco.listar_clientes());
                    System.out.print("Selecione conta: ");
                    choice = input.nextInt();
                    System.out.println(choice + " vs " + (banco.getList().size()+1));
                    if(choice-1 <= banco.getList().size() -1 && banco.getList().size() != 0) banco.deletar_conta(banco.getList().get(choice-1).getNumero());
                    choice = -1;
                    break;
                case 3:
                    System.out.println(movimentacao_menu);
                    System.out.print("Escolha movimentacao: ");
                    choice = input.nextInt();

                    switch(choice) {
                        case 1:
                            System.out.println(banco.listar_clientes());
                            System.out.print("Selecione conta: ");
                            choice = input.nextInt();
                            System.out.print("Selecione valor: ");
                            value = input.nextInt();

                            if(choice-1 <= banco.getList().size() -1 && banco.getList().size() != 0) banco.montar_movimentacao("saque", banco.getList().get(choice-1), null, value);
                            choice = -1;
                            break;
                        case 2:
                            System.out.println(banco.listar_clientes());
                            System.out.print("Selecione conta: ");
                            choice = input.nextInt();
                            System.out.print("Selecione valor: ");
                            value = input.nextInt();

                            if(choice-1 <= banco.getList().size() -1 && banco.getList().size() != 0) banco.montar_movimentacao("deposito", banco.getList().get(choice-1), null, value);
                            choice = -1;
                            break;
                        case 3:
                            System.out.println(banco.listar_clientes());
                            System.out.print("Selecione a primeira conta: ");
                            choice = input.nextInt();
                            Conta c = null;
                            if(choice-1 <= banco.getList().size() -1 && banco.getList().size() != 0) c = banco.getList().get(choice-1);

                            System.out.println(banco.listar_clientes());
                            System.out.print("Selecione a segunda conta: ");
                            choice = input.nextInt();

                            System.out.print("Selecione valor: ");
                            value = input.nextInt();

                            if(choice-1 <= banco.getList().size() -1 && banco.getList().size() != 0 && c != null) banco.montar_movimentacao("transferencia", c, banco.getList().get(choice-1), value);
                            choice = -1;
                            break;
                    }

                    break;

                case 4:
                    System.out.println(banco.listar_clientes());
                    System.out.print("Selecione conta: ");
                    choice = input.nextInt();

                    if(choice-1 <= banco.getList().size() -1 && banco.getList().size() != 0) System.out.println(banco.getList().get(choice-1).gerar_extrato());


                    break;
            }
        }

    }

}
