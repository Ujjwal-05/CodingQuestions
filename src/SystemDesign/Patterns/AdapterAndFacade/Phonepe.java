package SystemDesign.Patterns.AdapterAndFacade;

public class Phonepe {

/*
    public  YesBankApi yesBankApi;

    Phonepe(YesBankApi yesBankApi){
        this.yesBankApi=yesBankApi;
    }

    public int balance(){
        yesBankApi.getBalance();
    }


    In this we see Phone is directly depend on the YesBankApi which breaks the DI in Solid. Also if suppose we need to change the YesBankApi to icici so we need to change the code, the code is tightly coupled here. And we are directly calling getBalance if the function name got changed we need to change the code. So as we studied in DI high level module should not depend on the implementation rather than it should depend on  the Abstraction.
    And if we need to add new bank then simply implement the BankApi interface.

*/

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
