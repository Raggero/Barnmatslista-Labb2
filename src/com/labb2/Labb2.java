package com.labb2;
import java.util.Scanner;

public class Labb2 {

    private static Scanner scan = new Scanner(System.in);
    private static BarnmatLista barnmatLista = new BarnmatLista();

    public static void main(String[] args) {

        boolean avsluta = false;
        int menyVal;

        skrivUtMeny();

        while(!avsluta){
            System.out.println(" ");
            System.out.print("Vad vill du göra?(Tryck 0 för att se menyn)");
            menyVal = scan.nextInt();
            scan.nextLine();

            switch(menyVal){
                case 0:
                    skrivUtMeny();
                    break;
                case 1:
                    barnmatLista.skrivUtLista();
                    break;
                case 2:
                    skrivUtSpecifikBarnmat();
                    break;
                case 3:
                    laggTillBarnmat();
                    break;
                case 4:
                    uppdateraBarnmat();
                    break;
                case 5:
                    taBortBarnmat();
                    break;
                case 6:
                    laggTillFavorit();
                    break;
                case 7:
                    taBortFavorit();
                    break;
                case 8:
                    barnmatLista.skrivUtFavoriter();
                    break;
                case 9:
                    System.out.println("Programmet avslutas...");
                    avsluta = true;
                    break;
                default:
                    System.out.println("Felaktigt val, försök igen");
                    break;
                }
            }
        }

        public static void skrivUtMeny(){
            System.out.println("---Meny---");
            System.out.println("1. Se min lista");
            System.out.println("2. Se fullständig information på valfri barnmatsburk");
            System.out.println("3. Lägg till");
            System.out.println("4. Ändra");
            System.out.println("5. Ta bort");
            System.out.println("6. Lägg till ny favorit");
            System.out.println("7. Ta bort favorit");
            System.out.println("8. Se favoriter");
            System.out.println("9. Avsluta programmet");
        }

        // Skriver ut fullständig information på vald barnmatsburk.
        private static void skrivUtSpecifikBarnmat(){
            barnmatLista.skrivUtLista();
            System.out.println("Vilken barnmatsburk vill du se utökad information på? (Skriv siffran)");
            int skrivUtMatVal = scan.nextInt();
            scan.nextLine();

            barnmatLista.skrivUtLista(skrivUtMatVal);
        }

        // Lägger in en ny barnmatsburk på listan.
        private static void laggTillBarnmat(){
            System.out.print("Vad heter maten? ");
            String namn = scan.nextLine();
            System.out.print("Vilket märke? ");
            String marke = scan.nextLine();
            System.out.print("Omdöme: Vad tycker barnet om maten?");
            String omdome = scan.nextLine();
            System.out.print("Vilken är den primära kolhydratkällan? ");
            String kolhydrat = scan.nextLine();
            System.out.print("Vilken är den primära proteinkällan? ");
            String protein = scan.nextLine();

            BarnmatsBurkar nyBarnmatsBurk = new BarnmatsBurkar(namn, marke, omdome, kolhydrat, protein);
            barnmatLista.laggTillMat(nyBarnmatsBurk);
        }

        // Ändrar vald variabel på vald barnmatsburk.
        private static void uppdateraBarnmat(){
            barnmatLista.skrivUtLista();
            System.out.print("Vilken barnmatsburk vill du ändra?");
            int uppdateraMatVal = scan.nextInt();
            BarnmatsBurkar matAttUppdatera = barnmatLista.letaIListan(uppdateraMatVal);
            if(matAttUppdatera != null) {
                System.out.println("Vad vill du ändra? \n1. Namn \n2. Märke \n3. Omdöme" +
                        "\n4. Primär kolhydratkälla \n5. Primär proteinkälla");
                int uppdateraSpecifikVariabel = scan.nextInt();
                scan.nextLine();
                switch (uppdateraSpecifikVariabel) {
                    case 1:
                        System.out.print("Uppdatera namnet: ");
                        String nyttNamn = scan.nextLine();
                        barnmatLista.uppdateraNamn(uppdateraMatVal,nyttNamn);
                        break;
                    case 2:
                        System.out.print("Uppdatera märket: ");
                        String nyttMarke = scan.nextLine();
                        barnmatLista.uppdateraMarke(uppdateraMatVal,nyttMarke);
                        break;
                    case 3:
                        System.out.print("Omdöme: Vad tycker barnet om maten nu?");
                        String nyttOmdome = scan.nextLine();
                        barnmatLista.uppdateraOmdome(uppdateraMatVal,nyttOmdome);
                        break;
                    case 4:
                        System.out.print("Uppdatera primär kolhydratkälla: ");
                        String nyKolhydrat = scan.nextLine();
                        barnmatLista.uppdateraKolhydratKalla(uppdateraMatVal,nyKolhydrat);
                        break;
                    case 5:
                        System.out.print("Uppdatera primär proteinkälla: ");
                        String nyProtein = scan.nextLine();
                        barnmatLista.uppdateraProteinKalla(uppdateraMatVal,nyProtein);
                        break;
                    default:
                        System.out.print("Ändrar inget, felaktigt val");
                        break;
                }
            } else{
                System.out.println("Felaktigt val, finns inte på listan.");
            }
    }

    // Tar bort vald barnmatsburk från listan.
    private static void taBortBarnmat(){
        barnmatLista.skrivUtLista();
        System.out.print("Vad vill du ta bort från listan? (Skriv siffran)");
        int taBortVal = scan.nextInt();
        scan.nextLine();

        if(barnmatLista.skrivUtLista(taBortVal)) {
            System.out.print("Vill du ta bort denna maten från listan? (ja/nej)");
            String konfirmeringTaBort = scan.nextLine();
            if (konfirmeringTaBort.toLowerCase().equals("ja")) {
                barnmatLista.taBortMat(taBortVal);
            } else {
                System.out.println("Ok! Den behåller vi!");
            }
        }
    }

    // Sätter vald barnmatsburk till favorit.
    private static void laggTillFavorit(){
        barnmatLista.skrivUtLista();
        System.out.print("Vilken mat vill du göra till favorit? (Skriv siffran)");
        int favoritVal = scan.nextInt();
        scan.nextLine();

        barnmatLista.laggTillFavorit(favoritVal);
    }

    // Tar bort vald barnmatsburk som favorit.
    private static void taBortFavorit() {
        barnmatLista.skrivUtFavoriter();
        System.out.print("Vilken favorit skall tas bort? (Skriv siffran)");
        int taBortVal = scan.nextInt();
        scan.nextLine();

        barnmatLista.taBortFavorit(taBortVal);
    }
}

