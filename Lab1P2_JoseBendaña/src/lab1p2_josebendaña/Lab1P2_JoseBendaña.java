package lab1p2_josebendaña;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Lab1P2_JoseBendaña {

    public static void main(String[] args) {
        int opcionmenu;
        Scanner menu = new Scanner(System.in);
        do{
            System.out.println("""
                               
                               ------------------MENU DE EJERCICIOS------------------
                               
                               1. Torres de Hanói
                               2. Buscar Fecha
                               3. Sumatoria
                               4. Salir
                               
                               ------------------------------------------------------
                               
                                """);
            System.out.print("Ingrese el ejercicio que quiere evaluar: ");
            opcionmenu = menu.nextInt();
            switch(opcionmenu){
                case 1:
                    Scanner case1 = new Scanner(System.in);
                    System.out.print("Ingrese el numero de discos: ");
                    int n = case1.nextInt();
                    hanoi(n, 1, 2, 3);
                    break;
                case 2:
                    Scanner case2 = new Scanner(System.in);
                    ArrayList<String> arreglo = new ArrayList();
                    System.out.print("""
                                     
                                     Andres aqui hice que se pueda ingresar dos 
                                     tipos de fechas para los puntitos extra :) 
                                     de forma (dd/MM/yyyy) y de la forma de (dd-MM-yyyy)
                                     
                                     """);
                    System.out.print("Ingrese una cadena de strings divididos por (,): ");
                    String cadena = case2.nextLine();
                    arreglo = dividircadena(cadena);
                    fecha(arreglo);
                    break;
                case 3:
                    Scanner case3 = new Scanner(System.in);
                    System.out.print("ingrese un numero: ");
                    int k = case3.nextInt();
                    double total = 4*sumatoria(k,0);
                    System.out.println("La sumatoria de su numero da a: "+total);
                    break;
                case 4:
                    System.out.println("Saliendo.............");
                    break;
                default:
                    System.out.println("Opcion no valida, ingrese una nueva");
                    break;
            }
            
        }while(opcionmenu != 4);
        System.out.println("Se ha salido exitosamente!!!");
    }
    
    public static void hanoi(int n, int origendisco, int apoyo, int palofinal){
        if (n==1){
            System.out.println("Mover disco 1 de "+origendisco+" a "+palofinal);
            return;
        }else{
            hanoi(n-1, origendisco, palofinal, apoyo);
        }
        
        System.out.println("Mover disco "+ n +" de "+origendisco+" a "+palofinal);
        hanoi(n-1, apoyo, origendisco, palofinal);
    }
    
    public static ArrayList<String> dividircadena(String cadena){
        ArrayList<String> arreglo = new ArrayList();
        Scanner dividir = new Scanner(cadena);
        dividir.useDelimiter(",");
        while (dividir.hasNext()) {
            arreglo.add(dividir.next());   
        }
        return arreglo;
    }
    
    public static void fecha(ArrayList<String> arreglo){
        int day = 0;
        int month = 0;
        int year2 = 0;
        if (arreglo.isEmpty()){
            return;
        }else{
            int contadorpleca = 0;
            int contadorguion = 0;
            for (int i = 0; i < arreglo.get(0).length(); i++) {
                if (arreglo.get(0).charAt(i) == '/') {
                    contadorpleca++;
                }else if (arreglo.get(0).charAt(i)=='-'){
                    contadorguion++;
                }
            }
            if ((contadorguion==2)||(contadorpleca==2)) {
                Scanner fechas = new Scanner(arreglo.get(0));
                Scanner fechasguion = new Scanner(arreglo.get(0));
                fechas.useDelimiter("/");
                fechasguion.useDelimiter("-");
                if(contadorpleca==2){
                    while (fechas.hasNext()) {
                        String dia = fechas.next();
                            day = Integer.parseInt(dia);
                            String mes = fechas.next();
                            month = Integer.parseInt(mes)-1;
                            String year = fechas.next();
                            year2 = Integer.parseInt(year)-1900;  
                    }
                }else{
                     while (fechasguion.hasNext()) {
                        String dia = fechasguion.next();
                        day = Integer.parseInt(dia);
                        String mes = fechasguion.next();
                        month = Integer.parseInt(mes)-1;
                        String year = fechasguion.next();
                        year2 = Integer.parseInt(year)-1900;  
                    }
                }   
                Date fechalarga = new Date();
                fechalarga.setDate(day);
                fechalarga.setMonth(month);
                fechalarga.setYear(year2);
                System.out.println(fechalarga);
                arreglo.remove(0);
                fecha(arreglo);
            }else{
                arreglo.remove(0);
                fecha(arreglo);
            }
            
        }
    }
    
    public static double sumatoria(int k, int n){
        double sumatoria;
        double numerador;
        double denominador;
        if (k==n) {
            numerador = Math.pow(-1, n);
            denominador = (2*n+1);
            sumatoria = numerador/denominador;
            return sumatoria;
        }else{
            numerador = Math.pow(-1, n);
            denominador = (2*n+1);
            sumatoria = sumatoria(k,n+1) + numerador/denominador;
            return sumatoria;
        }
    }
    
}
