package org.lab;

public class ExpenseView {
    public static void expenseTracker(String[] args) {
        if (args.length == 0) {
            System.out.println("Use: java -jar expense-tracker.jar <command>");
            System.exit(1);
        }

        String command = args[0].toLowerCase();

        switch (command) {
            case "add" :
                if (args.length != 5) {
                    System.out.println("Use: java -jar expense-tracker.jar add --description <description> --amount <amount>");
                    System.exit(1);
                }

                ExpenseController.add(args[2], args[4]);
                break;

            case "delete" :
                if (args.length != 3) {
                    System.out.println("Use: java -jar expense-tracker.jar delete --id <id>");
                    System.exit(1);
                }

                ExpenseController.delete(args[2]);
                break;

            case "list" :
                ExpenseController.list();
                break;

            case "summary" :
                if (args.length == 1) {
                    ExpenseController.listSummary();
                    break;
                }
                if (args.length != 3) {
                    System.out.println("Use: java -jar expense-tracker.jar summary --mouth <mouth>");
                    System.exit(1);
                }

                ExpenseController.listSummaryMouth(args[2]);
                break;

            case "--help" :
                ExpenseRepository.help();
                break;

            default:
                System.out.println("Use: java -jar expense-tracker.jar --help");
        }
    }
}
