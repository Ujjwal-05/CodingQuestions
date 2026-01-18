package SystemDesign.Patterns.AdapterAndFacade;

public class YesBankApiAdapter implements BankApi{

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
