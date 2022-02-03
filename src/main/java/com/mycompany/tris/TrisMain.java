package com.mycompany.tris;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author ut1281
 */
public class TrisMain {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String[][] campo = {
            {"0", "1", "0"},
            {"1", "1", "0"},
            {"1", "0", "1"},};
        String giocatore1, giocatore2 = "";

        System.out.println("Benvenuto al gioco del tris");
        System.out.println("Giocatore 1 scelga X o O per gicoare");
        giocatore1 = reader.nextLine().toUpperCase();
        System.out.println(giocatore1);
        while (!giocatore1.equalsIgnoreCase("x") && !giocatore1.equalsIgnoreCase("o")) {
            System.out.println(" Hai scelto una pedina non valida, ritenta: ");
            giocatore1 = reader.nextLine().toUpperCase();
        }

        System.out.println("Il giocatore 1 ha scelto : " + giocatore1);

        if (giocatore1.equalsIgnoreCase("x")) {
            giocatore2 = "O";
        } else {
            giocatore2 = "X";
        }
        System.out.println("Il giocatore 2 userà la pedina " + giocatore2);
        System.out.println("");
        System.out.println("|------------------------------------|");
        System.out.println("Che la partita abbia inizio");
        System.out.println("|------------------------------------|");

        stampaCampo(campo);
        int riga;
        int colonna;
        int count = 0;
        String vincitore = "";
        boolean controllo = false;
//INSERIMENTO
        while (count < 9 && vincitore.equals("")) {

            if (count % 2 == 0) {
                System.out.println("Turno giocatore 1 \" " + giocatore1 + " \" ");
                System.out.println("Inserisci le cordinate dove mettere la pedina,prima RIGA e poi COLONNA");
                controllo = false;
                while (!controllo) {
                    try {

//                        riga = Integer.parseInt(reader.nextLine());
//                        colonna = Integer.parseInt(reader.nextLine());
                        riga = reader.nextInt();
                        colonna = reader.nextInt();
                        while (true) {
                            if (campo[riga - 1][colonna - 1].equals("0") || campo[riga - 1][colonna - 1].equals("1")) {
                                campo[riga - 1][colonna - 1] = giocatore1;
                                break;
                            } else {
                                System.out.println("OPS!! posizione occupata, ritenta!"
                                        + "inserisci riga e colonna");

                                riga = reader.nextInt();
                                colonna = reader.nextInt();
                            }
                        }
                        controllo = true;
                        stampaCampo(campo);
                        vincitore = vincitore(campo);
                    } catch (ArrayIndexOutOfBoundsException a) {
                        System.out.println("OPPEseee hai inserito delle cordinate non valide, ritenta!");
                        controllo = false;
//                    } catch (NumberFormatException n) {
//                        System.out.println("OPPEseee hai inserito delle cordinate non valide, ritenta!");
//                        controllo = false;
//                    }

// CURIOSO, SI SPACCA TUTTO CON QUESTA CATCH MEEEEEH
                    } catch (InputMismatchException im) {
                        System.out.println("OPPEseee hai inserito delle cordinate non valide, ritenta!");
                        controllo = false;
                    }
                }

            } else {
                System.out.println("Turno giocatore 2 \" " + giocatore2 + " \" ");
                System.out.println("Inserisci le cordinate dove mettere la pedina,prima RIGA e poi COLONNA");
                controllo = false;
                while (!controllo) {
                    try {
                        controllo = true;
                        riga = Integer.parseInt(reader.nextLine());
                        colonna = Integer.parseInt(reader.nextLine());
                        while (true) {
                            if (campo[riga - 1][colonna - 1].equals("0") || campo[riga - 1][colonna - 1].equals("1")) {
                                campo[riga - 1][colonna - 1] = giocatore2;
                                break;
                            } else {
                                System.out.println("OPS!! posizione occupata, ritenta!"
                                        + "inserisci riga e colonna");

                                riga = reader.nextInt();
                                colonna = reader.nextInt();
                            }
                        }

                        stampaCampo(campo);
                        vincitore = vincitore(campo);
                    } catch (ArrayIndexOutOfBoundsException a) {
                        System.out.println("OPPEseee hai inserito delle cordinate non valide, ritenta!");
                        controllo = false;
                    } catch (NumberFormatException n) {
                        System.out.println("OPPEseee hai inserito delle cordinate non valide, ritenta!");
                        controllo = false;
                    }

//  CURIOSO, SI SPACCA TUTTO CON QUESTA CATCH MEEEEEH
//                    } catch (InputMismatchException im) {
//                        System.out.println("OPPEseee hai inserito delle cordinate non valide, ritenta!");
//                        controllo = false;
//                    }
                }
            }
            ++count;
        }
        switch (vincitore) {
            case "":
                System.out.println("Mannaggia, partita finita in parità!");
                break;
            case "X":
                if (giocatore1.equalsIgnoreCase("x")) {
                    System.out.println("CONGRATULATION!!Ha vinto il giocatore 1!!!");
                    break;
                }
                System.out.println("CONGRATULATION!!Ha vinto il giocatore 2!!!");
                break;
            case "O":
                if (giocatore1.equalsIgnoreCase("o")) {
                    System.out.println("CONGRATULATION!!Ha vinto il giocatore 1!!!");
                    break;
                }
                System.out.println("CONGRATULATION!!Ha vinto il giocatore 2!!!");
                break;
        }

    }
// if (vincitore.equals("")) {
// System.out.println("Partita finita in pareggio");
// } else if (vincitore.endsWith(giocatore1)) {
//
// } else {
// System.out.println("Ha vinto il giocatore 2,congratulation senor");
// }
// System.out.println(vincitore(campo));
// }

    public static void stampaCampo(String[][] campo) {
        for (String[] a : campo) {
            for (String b : a) {
                System.out.print("|");
                System.out.print(" ");
                if (b.equals("0") || b.equals("1")) {
                    System.out.print("");
                } else {
                    System.out.print(b);
                }

                System.out.print(" ");

            }
            System.out.print("|");
            System.out.println("");
        }
    }

// public static void inserisci(String[][] campo, int riga, int colonna, String giocatore) {
// if (campo[riga][colonna].equals("")) {
// campo[riga][colonna] = giocatore;
// }
//
// }
    public static String vincitore(String[][] campo) {

        if (campo[0][0].equals(campo[0][1]) && campo[0][1].equals(campo[0][2])) {
            return campo[0][0].toString();

        } else if (campo[1][0].equals(campo[1][1]) && campo[1][1].equals(campo[1][2])) {
            return campo[1][0].toString();

        } else if (campo[2][0].equals(campo[2][1]) && campo[2][1].equals(campo[2][2])) {
            return campo[2][0].toString();

        } else if (campo[0][0].equals(campo[1][0]) && campo[1][0].equals(campo[2][0])) {
            return campo[0][0].toString();

        } else if (campo[0][1].equals(campo[1][1]) && campo[1][1].equals(campo[2][1])) {
            return campo[0][1].toString();

        } else if (campo[0][2].equals(campo[1][2]) && campo[1][2].equals(campo[2][2])) {
            return campo[0][2].toString();

        } else if (campo[0][0].equals(campo[1][1]) && campo[1][1].equals(campo[2][2])) {
            return campo[0][0].toString();

        } else if (campo[0][2].equals(campo[1][1]) && campo[1][1].equals(campo[2][0])) {
            return campo[0][2].toString();
        } else {
            return "";
        }

    }

}
