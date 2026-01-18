package SystemDesign.Patterns.AdapterAndFacade;

public class ICICIBankAPiAdapter implements BankApi{

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
