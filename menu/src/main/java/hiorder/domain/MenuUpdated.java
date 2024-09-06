package hiorder.domain;

import hiorder.domain.*;
import hiorder.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class MenuUpdated extends AbstractEvent {

    private Long id;
    private String name;
    private Integer price;

    public MenuUpdated(Menu aggregate) {
        super(aggregate);
    }

    public MenuUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
