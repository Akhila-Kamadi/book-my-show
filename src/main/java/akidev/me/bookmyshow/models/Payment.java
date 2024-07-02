package akidev.me.bookmyshow.models;

import akidev.me.bookmyshow.models.enums.PaymentMethod;
import akidev.me.bookmyshow.models.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Payment extends BaseModel{
    private String paymentReferenceId;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    private double amount;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    private Date time;

    // P : T
    // 1 : 1
    // M : 1
    // -> if previous payment failed we retry -> many payments for 1 ticket
    @ManyToOne
    private Ticket ticket;
}
