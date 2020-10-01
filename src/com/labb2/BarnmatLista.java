package com.labb2;
import java.util.ArrayList;

public class BarnmatLista {

    private ArrayList<BarnmatsBurkar> minBarnmatsLista;

    public BarnmatLista(){
        this.minBarnmatsLista = new ArrayList<>();
    }

    /*Lägger till ny barnmatsburk i arraylistan. Namn och märke skickas till metoden LetaIListan för att kontrollera att
     den inte redan finns på listan. */
    public void laggTillMat(BarnmatsBurkar barnmatsBurk){
        if(letaIListan(barnmatsBurk.getNamn(), barnmatsBurk.getMarke()) < 0){
            minBarnmatsLista.add(barnmatsBurk);
            System.out.println("Maten har lagts till i listan.");
        } else{
            System.out.println("Maten har inte lagts till. Den finns redan på listan.");
        }
    }

    //Tar bort vald barnmatsburk från arraylistan.
    public void taBortMat(int nummer){
        int index = nummer - 1;
        minBarnmatsLista.remove(index);
        System.out.println("Maten är borttagen.");
    }

    // Ändrar namn för vald barnmatsburk
    public void uppdateraNamn(int nummer, String nyttNamn){
        int index = nummer - 1;
        minBarnmatsLista.get(index).setNamn(nyttNamn);
        System.out.println("Namnet är uppdaterat");
    }

    // Ändrar märke för vald barnmatsburk
    public void uppdateraMarke(int nummer, String nyttMarke){
        int index = nummer - 1;
        minBarnmatsLista.get(index).setMarke(nyttMarke);
        System.out.println("Märket är uppdaterat");
    }

    // Ändrar omdöme för vald barnmatsburk
    public void uppdateraOmdome(int nummer, String nyOmdome){
        int index = nummer - 1;
        minBarnmatsLista.get(index).setOmdome(nyOmdome);
        System.out.println("Omdömet på maten har uppdaterats");
    }

    // Ändrar primär kolhydratskälla för vald barnmatsburk
    public void uppdateraKolhydratKalla(int nummer, String nyKolhydrat){
        int index = nummer - 1;
        minBarnmatsLista.get(index).setKolhydratKalla(nyKolhydrat);
        System.out.println("Primär kolhydratkälla är uppdaterad");
    }

    // Ändrar primär proteinkälla för vald barnmatsburk
    public void uppdateraProteinKalla(int nummer, String nyProtein){
        int index = nummer - 1;
        minBarnmatsLista.get(index).setProteinKalla(nyProtein);
        System.out.println("Primär proteinkälla är uppdaterad");
    }

    //Metod som kontrollerar namn och märke på barnmatsburkarna i arraylistan mot parametrarna namn och märke.
    private int letaIListan(String namn, String marke) {
        for (int i = 0; i < minBarnmatsLista.size(); i++) {
            BarnmatsBurkar burk = minBarnmatsLista.get(i);
            if (burk.getNamn().toLowerCase().trim().equals(namn.toLowerCase().trim()) && burk.getMarke().toLowerCase().equals(marke.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }

    // Metod som kontrollerar att det nummer användaren valt faktiskt finns på listan. Finns det returneras barnmatsburken/objektet.
    public BarnmatsBurkar letaIListan(int nummer){
        int index = nummer - 1;
        if(index >= 0 && index < minBarnmatsLista.size()){
            return minBarnmatsLista.get(index);
        }
        return null;
    }

    // Skriver ut arraylistan med namn, märke och omdöme.
    public void skrivUtLista(){
        System.out.println("--- Min lista ---");
        System.out.println("");
        for(int i = 0; i < minBarnmatsLista.size(); i++){
            System.out.println((i+1) + "." + "Namn: " + minBarnmatsLista.get(i).getNamn() +
                    "   Märke: " + minBarnmatsLista.get(i).getMarke() +  "  Omdöme: " + minBarnmatsLista.get(i).getOmdome());
        }
    }

    // Skriver ut fullständig information för valt nummer på listan.
    public boolean skrivUtLista(int nummer) {
        int position = nummer - 1;
        if (position >= 0 && position < minBarnmatsLista.size()) {
            System.out.println(nummer + ". \nNamn: " + minBarnmatsLista.get(position).getNamn() +
                    "\nMärke: " + minBarnmatsLista.get(position).getMarke() +
                    "\nOmdöme: " + minBarnmatsLista.get(position).getOmdome() +
                    "\nPrimär kolhydratkälla: " + minBarnmatsLista.get(position).getKolhydratKalla() +
                    "\nPrimär proteinkälla: " + minBarnmatsLista.get(position).getProteinKalla());
            return true;
        } else {
            System.out.println("Felaktigt val, försök igen");
            return false;
        }
    }

    // Sätter vald barnmatsburk till favorit om användaren gjort ett giltligt val. (Burken finns på listan samt att den inte redan är en favorit)
    public void laggTillFavorit(int nummer){
        int index = nummer - 1;
        if(letaIListan(nummer) != null) {
            if(!minBarnmatsLista.get(index).getFavorit()){
                minBarnmatsLista.get(index).setFavorit(true);
                System.out.println("Du har lagt till en favorit!");
            } else{
                System.out.println("Den är redan en favorit!");
            }
        } else{
            System.out.println("Felaktigt val, försök igen.");
        }
    }

    // Tar bort vald barnmatsburk som favorit om användaren gjort ett giltligt val. (Burken finns på listan samt att den är en favorit)
    public void taBortFavorit(int nummer){
        int index = nummer - 1;
        if(letaIListan(nummer) != null){
            if(minBarnmatsLista.get(index).getFavorit()){
                minBarnmatsLista.get(index).setFavorit(false);
                System.out.println("Favorit borttagen");
            } else{
                System.out.println("Ditt val är inte en favorit.");
            }
        } else{
            System.out.println("Felaktigt val, försök igen.");
        }
    }

    // Skriver ut de barnmatsburkar som är favoriter.
    public void skrivUtFavoriter(){
        System.out.println("--- Mina favoriter ---");
        System.out.println(" ");
        for(int i = 0; i < minBarnmatsLista.size(); i++){
            if(minBarnmatsLista.get(i).getFavorit()){
                System.out.println((i+1) + ". Namn: " + minBarnmatsLista.get(i).getNamn() +
                        "   Märke: " + minBarnmatsLista.get(i).getMarke() +
                        "   Omdöme: " + minBarnmatsLista.get(i).getOmdome());
            }
        }
    }
}




