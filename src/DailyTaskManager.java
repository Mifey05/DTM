
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class DailyTaskManager {
    // ANSI Colors. The Constant's name are self explanatory.
    public static final String RED = "\033[;31m"; 
    public static final String RESET = "\033[0m";

    static void remstack(Stack<Boolean> stakark, Stack<Integer> lastak, int i, Stack<String> stak) {
        if (lastak.contains(i - 1)) {
            lastak.removeElement(i - 1);
            for (int j = 0; j < lastak.size(); j++) {
                if (lastak.get(j) > i - 1) {
                    lastak.set(j, lastak.get(j) - 1);
                }
            } // this part handles the desync of index if the deleted index is in the middle
        } // This removes the relevant index that contains the index of the marked task along with removing it from the history stack.
        int falseCount = 0;
        for (int j = 0; j < stakark.size(); j++) {
            if (!stakark.get(j)) {
                falseCount++;
                if (falseCount == i - 1) {
                    stakark.remove(j);
                    stak.remove(j);
                    break;
                } // this removes the (j)th occurrence of "false", which is used to differentiate between the stack and the linked list.
            } // following the same logic, it uses the same loop for both stakark and stak, the latter of which is used in the tcpeek method.
        } // the history stack keeps track from both the stack (pre-defined task) and the linked list ("Dynamic task"), so it's more elaborate
    } // helps complete the deletion process of a dynamic task after marked as complete.

    static void pdtlist(String[] arr) {
        System.out.print("\033c"); // printing "\033c" would clear the terminal.
        System.out.println("Pre-defined task list");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + 1 + ". " + arr[i]);
        }
        System.out.println("");
    } // This method loops through the array to print a list of the pre-defined tasks.
    static void pdtupdt(String[] arr, int i, String updt) {
        System.out.print("\033c");
        arr[i - 1] = updt;
        System.out.println("Task no. " + i + " has been updated. Check the list for doublecheck.\n");
    } // this method offer a way to change the pre-defined task
    static void pdtnum(String[] arr) {
        System.out.print("\033c");
        System.out.println("Current total of pre-defined task is " + arr.length + ".\n");
    } // this method shows the total amount of pre-defined task, in case you're curious or there's a change to the pre-defined task.
    
    static void tcadda(Stack<String> stak, String[] arr, int i, Stack<Integer> lastak, Stack<Boolean> stakark) {
        System.out.print("\033c");
        if (!arr[i - 1].endsWith(" - Complete.")) {
            stak.push(arr[i - 1]);
            arr[i - 1] += " - Complete.";
            System.out.println("Task has been marked as complete!\n");
            lastak.push(i - 1);
            stakark.push(true);
        } else {
            System.out.println(RED + "Task has already been marked as complete.\n" + RESET);
        }
    } // This method marks a pre-defined task (array) as complete. instead of just adding the mark, it also puts the task into a history stack. each stack is explained in main.
    static void tcaddll(Stack<String> stak, LinkedList<String> ll, int i, Stack<Integer> lastak, Stack<Boolean> stakark) {
        System.out.print("\033c");
        if (!(ll.get(i - 1)).endsWith(" - Complete.")) {
            stak.push(ll.get(i-1));
            ll.set(i-1, ll.get(i - 1) + " - Complete.");
            System.out.println("Task has been marked as complete!\n");
            lastak.push(i - 1);
            stakark.push(false);
        } else {
            System.out.println(RED + "Task has already been marked as complete.\n" + RESET);
        }
    } // This method is the exact same as tcadda, except it's for the dynamic task (linked list).
    static void tcrema(Stack<String> stak, String[] arr, Integer i) {
        System.out.print("\033c");
            if (stak.isEmpty()) {
                System.out.print(RED + "You've yet to complete a task. Perhaps get off your lazy ahh and get to work.\n" + RESET);
            } else {
                if (arr[i].endsWith(" - Complete.")) {
                    arr[i] = arr [i].replace(" - Complete.", "");
                    System.out.println("Task '" + stak.pop() + "' has been demarked.\n");                   
                } else {
                    System.out.println(RED + "Task hasn't been marked as complete.\n" + RESET);
                }
            }
    } // This method demarks a task as part of the undo function. if it's a part of the pre-defined task, it's funneled into this method.
    static void tcremll(Stack<String> stak, LinkedList<String> ll, Integer i) {
        System.out.print("\033c");
            if (stak.isEmpty()) {
                System.out.println(RED + "You've yet to complete a task. Perhaps get off your lazy ahh and get to work.\n" + RESET);
            } else {
                if ((ll.get(i)).endsWith(" - Complete.")) {
                    ll.set(i, ll.get(i).replace(" - Complete.", ""));
                    System.out.println("Task '" + stak.pop() + "' has been demarked.\n");
                } else {
                    System.out.println(RED + "Task hasn't been marked as complete.\n" + RESET);
                }
            }
    } // This method is the exact same as tcrema, except it's for the dynamic task (linked list).
    static void tcpeek(Stack<String> stak) {
        System.out.print("\033c");
        if (stak.isEmpty()) {
            System.out.println(RED + "You've yet to complete a task. Perhaps get off your lazy ahh and get to work.\n" + RESET);
        } else {
            System.out.println("The last completed task is " + stak.peek() + "\n");
        }
    } // This method checks the last task marked as complete that's added into the history stack
    
    static void tadd(LinkedList<String> ll, String task) {
        System.out.print("\033c");
        ll.addLast(task);
        System.out.println("Task '" + task + "' has been added to the list.\n");
    } // This method add a dynamic task, utilizing a linked list.
    static void trem(LinkedList<String> ll, int i) {
        System.out.print("\033c");
        if (ll.isEmpty()) {
            System.out.println(RED + "You're attempting to remove nothing from nothing, no. Perhaps try adding one!\n" + RESET);
        } else {
            System.out.println("Task '" + ll.get(i - 1) + "' has been removed from the list.\n");
            ll.remove(i - 1);
        }
    } // This method deletes a dynamic task
    static void tlist(LinkedList<String> ll) {
        System.out.print("\033c");
        if (ll.isEmpty()) {
            System.out.println(RED + "I'm afraid you've yet to add a task onto the list. Perhaps try adding one!\n" + RESET);
        } else {
            System.out.println("Task List");
            for (int i = 0; i < ll.size(); i++) {
                System.out.println(i + 1 + ". " + ll.get(i));
            }
            System.out.println("");
        }
    } // This method loops through the linked list to print a list of the dynamic tasks.

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String[] pretask = {"Sweep the yard.", "Feed the dog.", "Charge your prostethic leg.", "5 minute exercise.", "Check for assignments."}; // pre-defined task, utilizing array.
        Stack<String> comptask = new Stack<>(); // History stack that keeps track of the name of the task marked as complete.
        Stack<Boolean> comptaskmark = new Stack<>(); // History stack that keeps tracks of the mark of the task marked as complete. The mark differentiates whether the task is from the array or the linked list.
        LinkedList<String> task = new LinkedList<>(); // Dynamic task, utilizing linked list.
        Stack<Integer> lastCompA = new Stack<>(); // History stack that keeps track of the index of which pre-defined task is marked
        Stack<Integer> lastCompLL = new Stack<>(); // History stack that keeps track of the index of which dynamic task is marked
        int choice;
        System.out.print("\033c");
        mainloop: // labels that's used because a break within a case only breaks out of the case, not the loop.
        while (true) {
            System.out.println("Daily Task Manager - by Mifey05");
            System.out.println("1. Pre-defined task list.\n2. Update a pre-defined task.\n3. Total amount of pre-defined task.\n4. Complete task.\n5. Undo task completion.\n6. Check last completed task\n7. Add task.\n8. Remove task.\n9. Task list.\n0. Exit.");
            System.out.print("Please enter your choice: ");
            try { // context for every try and catch pair, it handles errors not handleable by the code. it stops whatever code within the "try" and runs the "catch" instead. sort of a plan B if the code in "try" meets an error
                choice = scanner.nextInt(); // receives an input
                switch (choice) {
                    case 1 -> {
                        try {
                            pdtlist(pretask);
                            break;
                        } catch (Exception e) {
                            System.out.println(RED + "Something went wrong.\n" + RESET);
                        }
                    } // Pre-defined task list, using pdtlist method
                    case 2 -> {
                        try {
                            pdtlist(pretask);
                            System.out.print("Which task would you like to update? ");
                            while (true) {
                                choice = scanner.nextInt();
                                scanner.nextLine();
                                if (choice-1 < pretask.length) {
                                    break;
                                } else {
                                    System.out.print("Invalid input!\nChoice: ");
                                }
                            }
                            System.out.print("Update: ");
                            String updt = scanner.nextLine();
                            pdtupdt(pretask, choice, updt);
                        } catch (Exception e) {
                            System.out.print("\033c");
                            System.out.println(RED + "Something went wrong. Possibly a misinput.\n" + RESET);
                            scanner.nextLine();
                        }
                    } // Update pre-defined task, using pdtupdt
                    case 3 -> {
                        try {
                            pdtnum(pretask);
                            break;
                        } catch (Exception e) {
                            System.out.println(RED + "Something went wrong.\n" + RESET);
                        }
                    } // Shows the total amount of pre-defined task, using pdtnum
                    case 4 -> {
                        try {
                        System.out.print("\033c");
                        loop1: // see, mainloop
                        while (true) {
                            System.out.println("Would you like to mark the pre-defined tasks or the regular tasks?\n1. Pre-defined tasks.\n2. Regular tasks.\n3. Return.");
                            System.out.print("Please enter your choice: ");
                                choice = scanner.nextInt();
                                switch (choice) {
                                    case 1 -> {
                                        pdtlist(pretask);
                                        while (true) {
                                            try {
                                                System.out.print("Which task would you like to mark as complete? (1-5) ");
                                                choice = scanner.nextInt();
                                            } catch (Exception e) {
                                                System.out.print("\033c");
                                                System.out.println(RED + "Something went wrong. Possibly a misinput.\n" + RESET);
                                                scanner.nextLine(); // consumes the "newline" pressed in every input
                                                continue; // resets the loop at this point instead of continuing to the end
                                            }
                                            if (choice < 1 || choice > pretask.length) {
                                                System.out.print("\033c");
                                                System.out.print(RED + "Invalid input"+ RESET + ", try again! ");
                                            } else {
                                                break;
                                            }
                                            break;
                                        }
                                        tcadda(comptask, pretask, choice, lastCompA, comptaskmark);
                                        break loop1;
                                    } // funnels the code into marking a pre-defined task
                                    case 2 -> {
                                        if (task.isEmpty()) {
                                            System.out.print("\033c");
                                            System.out.println(RED + "You've yet to add a task. Perhaps try adding one!" + RESET);
                                        } else {
                                            tlist(task);
                                            System.out.print("Which task would you like to mark as complete? ");
                                            while (true) {
                                                try {
                                                    choice = scanner.nextInt();
                                                    if (choice > task.size()) {
                                                        System.out.print("\033c");
                                                        System.out.print(RED + "Invalid input" + RESET + ", try again! ");
                                                    }
                                                } catch (Exception e) {
                                                    System.out.print("\033c");
                                                    System.out.println(RED + "Something went wrong. Possibly a misinput\n" + RESET);
                                                    scanner.nextLine();
                                                }
                                                break;
                                            }
                                            tcaddll(comptask, task, choice, lastCompLL, comptaskmark);
                                        }
                                        break loop1;
                                    } // funnels the code into marking a dynamic task
                                    case 3 -> {
                                        System.out.print("\033c");
                                        break loop1;
                                    } // returns to the main menu
                                    default ->
                                        System.out.println(RED + "Invalid input." + RESET);
                                } // in case of input is not 1,2, or 3.
                        }
                        } catch (Exception e) {System.out.println(RED + "Something went wrong.\n" + RESET);}
                        break;
                    } // Completes a task, using tcadda or tcaddll for pre-defined task and dynamic task respectively
                    case 5 -> {
                        try {
                        if (!comptask.isEmpty()) { // checks that the history stack is NOT empty
                        System.out.print("\033c");
                            loop2: // see, mainloop
                            while (true) {
                            System.out.println("Are you sure?\n1. Yes\n2. No");
                            System.out.print("Please enter your choice: ");
                            choice = scanner.nextInt();
                        switch (choice) {
                            case 1 -> {
                                if (comptaskmark.peek() == true) {
                                    comptaskmark.pop();
                                    tcrema(comptask, pretask, lastCompA.pop());
                                    break loop2;
                                } else if (comptaskmark.peek() == false) {
                                    comptaskmark.pop();
                                    tcremll(comptask, task, lastCompLL.pop());
                                    break loop2;
                                }
                            } // checks which the last task marked belonged to, utilizing comptaskmark's true and false as a differentiator
                            case 2 -> {
                                System.out.print("\033c");
                                break loop2;
                                  }
                            default -> System.out.println(RED + "Invalid input." + RESET);
                        }
                    }
                    } else {
                        System.out.print("\033c");
                        System.out.println(RED + "You've yet to complete a task. Perhaps get off your lazy ahh.\n" + RESET);
                        break;
                    } // Immediately returns into the main menu if there hasn't been a marked task yet
                } catch (Exception e) {System.out.print("\033c"); System.out.println(RED + "Something went wrong. Possibly a misinput or history is empty.\n" + RESET); scanner.nextLine();}
                } // Undo a completion mark
                    case 6 -> {
                    try{
                        tcpeek(comptask);
                        break;
                    } catch (Exception e) {System.out.println(RED + "Something went wrong.\n" + RESET);}
                } // Check last completed task, using tcpeek method
                    case 7 -> {
                    try {
                        System.out.print("\033c");
                        System.out.print("What task would you like to add? ");
                        scanner.nextLine();
                        String name = scanner.nextLine();
                        tadd(task, name);
                    } catch (Exception e) {System.out.println(RED + "Something went wrong.\n" + RESET);}
                    break;
                } // Adds a dynamic task, using tadd
                    case 8 -> {
                    try {
                        System.out.print("\033c");
                        if (task.isEmpty()) {
                            System.out.println(RED + "You can't remove what you don't have. Perhaps try adding one!" + RESET);
                        } else {
                            tlist(task);
                            System.out.print("Which task would you like to remove? ");
                            choice = scanner.nextInt();
                            trem(task, choice);
                            remstack(comptaskmark, lastCompLL, choice, comptask);
                            break;
                        }
                    } catch (Exception e) { System.out.print("\033c"); System.out.println(RED + "Something went wrong. Possibly a misinput.\n" + RESET); scanner.nextLine();}
                } // Removes a dynamic task, using trem along with remstack to keep the data synced
                    case 9 -> {
                    try {
                        tlist(task);
                        break;
                    } catch (Exception e) {System.out.println(RED + "Something went wrong. Regular Task is likely empty.\n" + RESET);}
                } // Shows the dynamic task list, using tlist
                    case 0 -> {
                        System.out.print("\033c");
                        System.out.print("Exiting now...");
                        break mainloop;
                    } // Exits the whole program
                    default -> {
                        System.out.print("\033c");
                        System.out.println(RED + "Invalid input!\n" + RESET);
                    } // Default for any input that's not included as a proper input
            }
        } catch (Exception e) {
            System.out.print("\033c");
            System.out.println(RED + "Something went wrong. Possibly a misinput.\n" + RESET);
            scanner.nextLine();
        }
        }
        scanner.close();
    }
}
