package interfaceExercicioFixacao.services;

public interface OnlinePaymentService {
    double paymentFee(Double amount);
    double interest(Double amount, int months);


}
