package hiorder.domain;

import hiorder.domain.*;
import hiorder.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class MenuCreated extends AbstractEvent {

    private Long id;
    private String name;
    private Integer price;

    public MenuCreated(Menu aggregate) {
        super(aggregate);
    }

    public MenuCreated() {
        super();
    }
}
//>>> DDD / Domain Event
