package br.com.caique.roman;


import br.com.caique.roman.util.Converter;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final Converter CONVERTER = new Converter();

    public static void main(String[] args) {
        Integer opt = 0;
        Scanner sc = new Scanner(System.in);;


            while (opt >= 0){
                try{
                    clearConsole();
                    System.out.println("Escolha: \n" +
                            "1- Romanos -> Arabicos\n" +
                            "2- Arabicos -> Romanos\n" +
                            "9- Sair\n------------------------------");
                    opt = Integer.parseInt(sc.next());

                    switch (opt){
                        case 1:
                            clearConsole();
                            toArabic(sc);
                            break;
                        case 2:
                            clearConsole();
                            toRoman(sc);
                            break;
                        case 9:
                            clearConsole();
                            System.out.println("Bye! Pressione qualquer tecla para sair...");
                            System.in.read();
                            opt = -1;
                            break;
                        default:
                            clearConsole();
                            System.out.println("Opcao invalida! Pressione qualquer tecla para continuar...");
                            opt = 0;
                            System.in.read();
                            clearConsole();
                    }
                } catch (Exception e){
                    clearConsole();
                    System.out.println("Ocorreu um erro, tente novamente...");
                    opt = 0;
                }

            }


    }

    private static void toArabic(Scanner sc) throws IOException {
        System.out.println("Entre com o numero no formato romano:");
        String roman = sc.next();
        System.out.println("O numero inserido no formato arabico e: " + CONVERTER.toArabic(roman).toString());
        System.out.println("Pressione qualquer tecla para voltar ao menu...");
        System.in.read();
    }

    private static void toRoman(Scanner sc) throws IOException {
        System.out.println("Entre com o numero no formato arabico (entre 1 e 3999):");
        Integer arabic = Integer.parseInt(sc.next());
        System.out.println("O numero inserido no formato romano e: " + CONVERTER.toRoman(arabic));
        System.out.println("Pressione qualquer tecla para voltar ao menu...");
        System.in.read();
    }

    private static void clearConsole(){
        System.out.print("\033[H\033[2J");
    }
}
