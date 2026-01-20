package SystemDesign.Patterns.AdapterAndFacade;

class YesBankApi {

    public int getBalance(){
        return 100;
    }

    public void transferMoney(){
    }
}

class ICICIBankAPi {

    public int findBalance(){
        return 10000;
    }

    public void fundTransfer(){
        return;
    }
}

interface BankApi {

    public int checkBalance();

    public void moneyTransfer();
}

class ICICIBankAPiAdapter implements BankApi{

    private ICICIBankAPi iciciBankAPi;

    public ICICIBankAPiAdapter(ICICIBankAPi iciciBankAPi) {
        this.iciciBankAPi = iciciBankAPi;
    }

    @Override
    public int checkBalance() {
        return iciciBankAPi.findBalance();
    }

    @Override
    public void moneyTransfer() {
        iciciBankAPi.fundTransfer();
    }
}

class YesBankApiAdapter implements BankApi{

    private YesBankApi yesBankApi;

    public YesBankApiAdapter(YesBankApi yesBankApi) {
        this.yesBankApi = yesBankApi;
    }

    @Override
    public int checkBalance() {
        return yesBankApi.getBalance();
    }

    @Override
    public void moneyTransfer() {
        yesBankApi.transferMoney();
    }
}

class Phonepe{

    private BankApi bankApi;

    public Phonepe(BankApi bankApi) {
        this.bankApi = bankApi;
    }

    public int balance(){
        return bankApi.checkBalance();
    }

    public void transfer(){
        bankApi.moneyTransfer();
    }


}

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
