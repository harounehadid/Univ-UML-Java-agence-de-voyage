import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("----------------------- Trips management system -------------------------------");

        Scanner keyboard = new Scanner(System.in);
        String stayOrQuit;
        
        Agence curAgency = null;

        do {
            System.out.print("\nYou are?  >  [0] client     [1] agent \n >> ");
            int userType = keyboard.nextInt();
            keyboard.nextLine();

            String doneBtn;

            Client client = null;
            boolean userIsIdentified = false;

            do {
                if (userType == 0) {
                    if (curAgency == null) {
                        System.out.println("\nThere is no active agency at the moment sorry for the inconvenience");
                        break;
                    }

                    if (!userIsIdentified) System.out.print("\n [0] sign up");
                    System.out.println("\n [1] display available trips");
                    if (userIsIdentified) {
                        System.out.println(" [2] display your reservations");
                        System.out.println(" [3] reserve a trip");
                        System.out.println(" [4] confirm a trip");
                        System.out.println(" [5] cancel a trip");
                    }

                    System.out.print(" >>  ");
                    int clientChoice = keyboard.nextInt();
                    keyboard.nextLine();

                    if (clientChoice == 0 && !userIsIdentified) {
                        System.out.println("\nEnter name:  ");
                        String name = keyboard.nextLine();
                        System.out.println("Enter id:  ");
                        String id = keyboard.nextLine();

                        curAgency.identifier(name, id);
                        userIsIdentified = true;
                        client = curAgency.getClient(id);
                    }
                    else if (clientChoice == 1) {
                        curAgency.afficherLesVoyages();
                    }
                    else if (clientChoice == 2) {
                        client.afficherLesReservation();
                    }
                    else if (clientChoice == 3) {
                        if (curAgency.getVoyages().size() > 0) {
                            curAgency.afficherLesVoyagesAvecIndice();
                            System.out.print("\nChoose trip number you want to reserve:  ");
                            int tripIndex = keyboard.nextInt();
                            keyboard.nextLine();
                            Voyage newTrip = curAgency.getVoyageObjet(tripIndex);
                            System.out.print("\nChoose how many people you are going to reserve to:  ");
                            int passengersNum = keyboard.nextInt();
                            keyboard.nextLine();

                            client.reserver(newTrip, passengersNum);
                        }
                        else System.out.println("\nSorry there is no trip to reserve at the moment");
                    }
                    else if (clientChoice == 4) {
                        client.changerEtatDeReservation(true);
                    }
                    else if (clientChoice == 5) {
                        client.changerEtatDeReservation(false);
                    }
                    else System.out.println("\nWrong input!");
                }
                else if (userType == 1) {
                    System.out.println("\n [1] create an agency");
                    if (curAgency != null) {
                        System.out.println(" [2] display all trips");
                        System.out.println(" [3] add a trip");
                        System.out.println(" [4] close a trip");
                        System.out.println(" [5] open a trip");
                        System.out.println(" [6] display all reservations");
                    }

                    System.out.print(" >>  ");
                    int agentChoice = keyboard.nextInt();
                    keyboard.nextLine();

                    if (agentChoice == 1) {
                        System.out.print("Enter the name of the agency:  ");
                        String agencyName = keyboard.nextLine();
                        System.out.print("Enter agency phone number:  ");
                        String agencyPhoneNumber = keyboard.nextLine();

                        curAgency = new Agence(agencyName, agencyPhoneNumber);

                        System.out.println("\nAn agency is created!");
                    }
                    else if (agentChoice == 2) {
                        curAgency.afficherLesVoyages();
                    }
                    else if (agentChoice == 3) {
                        System.out.print("\nEnter departure city:  ");
                        String depCity = keyboard.nextLine();
                        System.out.print("\nEnter arrival city:  ");
                        String arrCity = keyboard.nextLine();

                        boolean correctDateFormat = true;

                        LocalDate depDate = null;

                        do {
                            try {
                                System.out.println("\nEnter departuer date:  ");
                                System.out.print(">> ");
                                System.out.print(" day - ");
                                int day = keyboard.nextInt();
                                keyboard.nextLine();
                                System.out.print(" month - ");
                                int month = keyboard.nextInt();
                                keyboard.nextLine();
                                System.out.print(" year - ");
                                int year = keyboard.nextInt();
                                keyboard.nextLine();

                                depDate = LocalDate.of(year, month, day);

                                correctDateFormat = true;
                            }
                            catch(Exception e) {
                                System.out.println("\nSomething wrong with the date!");
                                correctDateFormat = false;
                            }
                        } while (!correctDateFormat);

                        LocalDate arrDate = null;

                        do {
                            try {
                                System.out.println("\nEnter departuer date:  ");
                                System.out.print(">> ");
                                System.out.print(" day - ");
                                int day = keyboard.nextInt();
                                keyboard.nextLine();
                                System.out.print(" month - ");
                                int month = keyboard.nextInt();
                                keyboard.nextLine();
                                System.out.print(" year - ");
                                int year = keyboard.nextInt();
                                keyboard.nextLine();

                                arrDate = LocalDate.of(year, month, day);

                                correctDateFormat = true;
                            }
                            catch(Exception e) {
                                System.out.println("\nSomething wrong with the date!");
                                correctDateFormat = false;
                            }
                        } while (!correctDateFormat);

                        System.out.print("\nEnter departure hour (format h.m):  ");
                        float depHour = keyboard.nextFloat();
                        System.out.print("Enter arrival hour (format h.m):  ");
                        float arrHour = keyboard.nextFloat();

                        Boolean state = true;
                        System.out.print("Enter trip state [0] active   [1] suspended:  ");
                        System.out.print("\n >>  ");
                        int voyChoice = keyboard.nextInt();
                        keyboard.nextLine();
                        
                        if (voyChoice == 1) state = false;
                        else {
                            if (voyChoice != 0) {
                                System.out.println("\nWrong input! \n State is active by default you can change it later");
                            }
                        }

                        curAgency.ajouterVoyage(depCity, arrCity, depDate, arrDate, depHour, arrHour, state);
                    }
                    else if (agentChoice == 4 || agentChoice == 5) {
                        int tripIndex;
                        curAgency.afficherLesVoyagesAvecIndice();
                        System.out.print("\nPlease enter the index of the trip you want to update:  ");
                        tripIndex = keyboard.nextInt();
                        keyboard.nextLine();

                        Voyage trip = curAgency.getVoyageObjet(tripIndex);

                        if (agentChoice == 4) trip.setOuvert(false);
                        else trip.setOuvert(true);
                    }
                    else if (agentChoice == 6) {
                        curAgency.afficherToutLesReservation();
                    }
                    else System.out.println("\nWrong input!");
                }

                System.out.println("\nPress q to quit if you're done other to continue:  ");
                doneBtn = keyboard.nextLine();

            } while (doneBtn.compareTo("q") != 0);

            System.out.print("\nPress the button Q to quit or any other to continue:  ");
            stayOrQuit = keyboard.nextLine();

        } while (stayOrQuit.compareTo("q") != 0);
    }
}