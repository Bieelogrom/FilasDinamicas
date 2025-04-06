package view;

import edu.br.fateczl.gabriel.Fila;
import model.Cliente;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    static Fila<Cliente> ordemAtendimento = new Fila<>();

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Fila<Cliente> filaPrioritarios = new Fila<>();
        Fila<Cliente> filaNormal = new Fila<>();
        int tamanho_fila, qntd_priot, qntd_norm, cont_fila = 0;
        String entrada;
        boolean prioritario;

        while(true){
            System.out.println("*======* SISTEMA DE ATENDIMENTO *======*" +
                    "\n1. Cadastrar proximo da fila." +
                    "\n2. Ordenar fila. " +
                    "\n3. Verificar fila. " +
                    "\n4. Encerrar dia (zerar fila). " +
                    "\n5. Encerrar programa." +
                    "\n*=======================================*");
            int opt = sc.nextInt();
            switch(opt){
                case 1:
                    System.out.print("Digite o numero: ");
                    int numero = sc.nextInt();
                    System.out.print("Digite o nome: ");
                    String nome = sc.next();
                    System.out.print("É prioritário? (S/n): ");
                    entrada = sc.next();
                    prioritario = entrada.equalsIgnoreCase("S");
                    Cliente novoCliente = new Cliente(numero,nome,prioritario);
                    if(prioritario){
                        filaPrioritarios.insert(novoCliente);
                    } else {
                        filaNormal.insert(novoCliente);
                    }
                    break;
                case 2:
                    ordenarFila(filaNormal, filaPrioritarios);
                    break;
                case 3:
                    verificarFila();
                    break;
                case 4:
                    encerrarAtendimento();
                    break;
                case 5:
                    System.out.println("Encerrando programa...");
                    return;
                default:
                    System.out.println("Opção desconhecida!");
                    break;
            }
        }
    }

    public static void ordenarFila(Fila<Cliente> flNormal, Fila<Cliente> flPrioritaria) throws Exception {
        int cont_fila = 0;
        while(!flPrioritaria.isEmpty() || !flNormal.isEmpty()){
            if(cont_fila <= 3 && !flPrioritaria.isEmpty()){
                ordemAtendimento.insert(flPrioritaria.remove());
                cont_fila++;
            }else{
                ordemAtendimento.insert(flNormal.remove());
                cont_fila = 0;
            }
        }
    }

    public static void verificarFila() throws Exception {
        if(ordemAtendimento.isEmpty()){
            System.out.println("Fila vazia!");
        }else{
            ordemAtendimento.list();
        }
    }

    public static void encerrarAtendimento() throws Exception {
        while(!ordemAtendimento.isEmpty()){
            ordemAtendimento.remove();
        }
        System.out.println("Fila liberada!");
    }
}
