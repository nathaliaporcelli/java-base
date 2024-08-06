package capitulo15.entities;

import capitulo15.BusinesException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;
    private Double amount;

    public Account() {
    }

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double amount) {

        balance += amount;

    }

    public void withDraw(Double amount) throws BusinesException {
        validadeWithDraw(amount);
        balance -= amount;
    }

    private void validadeWithDraw(double amount) throws BusinesException {
        if (amount > getWithdrawLimit()) {
            throw new BusinesException("Erro de saque: Valor solicitado maior que o limite permitido");

        }
        if (amount > getBalance()) {
            throw new BusinesException("Erro de saque: Você não possui saldo suficiente");
        }

    }
}




