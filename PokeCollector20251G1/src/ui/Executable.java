package ui;

import java.util.Scanner;
import model.Controller;

public class Executable{

    private static Scanner input;
    private static Controller controller; //
    
    public static void main(String[] args) {

        initializer();
        menu();
        
    }

    public static void initializer(){

        input = new Scanner(System.in);
        controller = new Controller(); //
       

    }

    public static void registerPokemonCard(){

        System.out.println("Digite el nombre");
        String name = input.nextLine();

        System.out.println("Digite los puntos de vida");
        int hp = input.nextInt();

        System.out.println(controller.getPokemonTypeList());

        System.out.println("Digite el tipo del Pokemon");
        int type = input.nextInt();

        System.out.println("Digite el poder de ataque");
        int aP = input.nextInt();
       
        if(controller.savePokemonCard(name, hp, type, aP)){
            System.out.println("Carta registrada exitosamente");
        }else{
            System.out.println("Coleccion llena");
        }
    }

    public static void modifyPokemonCard(){
        System.out.println(controller.getCollection());
        System.out.println("");
        System.out.println("digite la posicion de la carta la cual quiere modificar");
        int cardmod = input.nextInt();
        if((cardmod>200)||(cardmod<0)){
            System.out.println("digite una posicion valida");
        }else if(controller.verifyCard(cardmod-1)){
            
            input.nextLine();
            System.out.println("digite el nombre del pokemon: ");
            String name= input.nextLine();
    
            System.out.println("digite los puntos de vida");
            int hp=input.nextInt();
                
            System.out.println(controller.getPokemonTypeList());
            System.out.println("digite el tipo de pokemon: ");
            int type= input.nextInt();
    
            System.out.println("digite el poder de ataque: ");
            int aP =input.nextInt();

            controller.modifyCard(name, hp, type, aP, cardmod);
             
        }
    }



    public static void modifyFieldPokemonCard(){
        System.out.println(controller.getCollection());
        System.out.println("");
        System.out.println("digite la posicion de la carta la cual quiere modificar");
        int cardmod = input.nextInt();
        if((cardmod>200)||(cardmod<0)){
            System.out.println("digite una posicion valida");
        }else if(controller.verifyCard(cardmod-1)){
            System.out.println("DIGITE QUÉ QUIERE MODIFICAR \n1. Nombre\n2.Tipo\n3. Puntos de vida\n4. Puntos de ataque");
            int option = input.nextInt();
            String data = "";
            input.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Digite el nuevo nombre: ");
                    break;
                case 2: 
                    System.out.println("Digite el nuevo tipo: ");
                    break;
                case 3:
                    System.out.println("Digite los nuevos puntos de vida: ");
                    break;
                case 4:
                    System.out.println("Digite los nuevos puntos de ataque: ");
                    break;
            }
            data = input.nextLine();
            boolean result = controller.modifyFieldPokemonCard(cardmod, option, data);
            if (result) {
                System.out.println("Campo actualizado correctamente.");
            }else{
                System.out.println("Error. No fue posible actualizar el campo. ");
            }
        }
    }
    public static void deletePokemonCard(){
        System.out.println(controller.getCollection());
        System.out.println("");
        System.out.println("digite la posicion de la carta la cual quiere borrar");
        int carddel = input.nextInt();
        if (controller.deleteCard(carddel-1)) {
            System.out.println("Esta carta fue borrada con éxito.");
        }
        else{
            System.out.println("En esa casilla no se encuentra ninguna carta");
        }
    }

    public static void menu(){
        int option = 0;
        do {
            System.out.println("BIENVENIDO A LA CENTRAL DE POKECOLLECTOR");
            System.out.println("DIGITA UNA OPCIÓN: ");
            System.out.println("[1] REGISTRAR CARTA ");
            System.out.println("[2] CONSULTAR COLECCIÓN ");
            System.out.println("[3] MODIFICAR CARTA");
            System.out.println("[4] BORRAR CARTA");
            System.out.println("[0] SALIR");
            option = input.nextInt();

            switch (option) {
                case 1:
                    registerPokemonCard();
                    break;
                case 2:
                    System.out.println(controller.getCollection());
                    break;
                case 3:
                    modifyPokemonCard();
                case 4:
                    deletePokemonCard();
                case 0:

                default:
                    System.out.println("Opción INVÁLIDA.");
            }
            
        } while (option != 0);
        registerPokemonCard();
        System.out.println(controller.getCollection());
    }





}