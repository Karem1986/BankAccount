import java.awt.*;

public class BankAccount {
    //Here we show how to create an object with its own characteristics in Java, also how to use Enums:
    private String nameHolder;
    double total;
    String descriptionItem;
    double itemCost;
    //Enum to determine types of bank accounts
    TypesAccountUser typesAccounts;
    //All bank accounts will be based in the Netherlands: a Static member,that means that it is shared among ALL members of the class.
    static String country = "The Netherlands";
    //Adding a color with the built-in Color java class to all bank accounts with a static member:
    static Color color = new Color(103, 34, 8);

    //Functions to define behavior for the bank account
    //1.Updating the total in the user's account:
    void updatedTotal() {
        this.total = this.total - this.itemCost;
        System.out.println( "After buying a " + descriptionItem + " your remaining amount is " + this.total);
    }
    //2.Allow the user to make deposits in the account:
    void deposit() {
        int amountToDeposit = 70;
        double updatedBalance = this.total + amountToDeposit;
        total = updatedBalance;
        System.out.println("You just deposited "+ amountToDeposit );
        System.out.println("Your updated balance is: "+ updatedBalance + " euros");
    }
    //Creating a bank account with a constructor
    BankAccount(String clientName, String description, double total, double itCost, TypesAccountUser typesAccounts) {
        this.nameHolder = clientName;
        this.descriptionItem = description;
        this.total = total;
        this.itemCost = itCost;
        this.typesAccounts = typesAccounts;


    }
   //Defining our new bank account object with a toString method to avoid reference memory being printed:
    public String toString(){
        return "Bank account info: " + nameHolder + " " + descriptionItem + "price: " + itemCost + " type of account is " + typesAccounts + " based in " + country;
    }
    //Applying dynamic behaviour for all accounts that are below the minimum amount so that
    //the user can be warned before purchasing new items:
    void warningLowAmount() {
        if(this.total < 15) {
            System.out.println("Your account has " + this.total + " euros, that is very low for a " + this.typesAccounts + " account!");
        }
    }
    public static void main(String... args) {
        BankAccount firstTransaction = new BankAccount("Karem ", "coffee ", 17.50,2.50, TypesAccountUser.PRIVATE );
        System.out.println(firstTransaction);
        firstTransaction.deposit();
        firstTransaction.updatedTotal();
        firstTransaction.warningLowAmount();

        BankAccount secondTransaction = new BankAccount("Phoebe", "sandwich ", 17.50,6.50, TypesAccountUser.PRIVATE );
        System.out.println(secondTransaction);
        secondTransaction.updatedTotal();
        secondTransaction.warningLowAmount();
        //accessing static member using class name:
        //System.out.println("Account is based in the " + BankAccount.country);
        System.out.println(BankAccount.color);


    }
}
