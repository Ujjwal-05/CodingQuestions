package SystemDesign.Patterns.AdapterAndFacade;

public class AdapterClient {
    public static void main(String[] args) {

        YesBankApi yesBankApi=new YesBankApi();
        ICICIBankAPi iciciBankAPi=new ICICIBankAPi();
//      Phonepe phonepe=new Phonepe(yesBankApi);


        // After implementing Adapter
        BankApi bankApi=new YesBankApiAdapter(yesBankApi);
        Phonepe phonepe=new Phonepe(bankApi);
        phonepe.balance();
        phonepe.transfer();

        // In this if we need to change the bank then change here only.
        BankApi bankApiicici=new ICICIBankAPiAdapter(iciciBankAPi);
        Phonepe phonepeicici=new Phonepe(bankApiicici);
        phonepe.balance();
        phonepe.transfer();



    }
}
