package ma.emsi.jpaap.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public enum StatuRV {
    PENDING,
    CANCELED,
    DONE
}
