package akidev.me.bookmyshow.models;

import akidev.me.bookmyshow.models.enums.PaymentMethod;
import akidev.me.bookmyshow.models.enums.PaymentStatus;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Payment extends BaseModel{
    private String paymentReferenceId;
    private PaymentMethod paymentMethod;
    private double amount;
    private PaymentStatus paymentStatus;
    private Date time;
    private Ticket ticket;
}
