package hiorder.domain;

import hiorder.MenuApplication;
import hiorder.domain.MenuCreated;
import hiorder.domain.MenuDeleted;
import hiorder.domain.MenuUpdated;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Menu_table")
@Data
//<<< DDD / Aggregate Root
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Integer price;

    @PostPersist
    public void onPostPersist() {
        MenuUpdated menuUpdated = new MenuUpdated(this);
        menuUpdated.publishAfterCommit();

        MenuCreated menuCreated = new MenuCreated(this);
        menuCreated.publishAfterCommit();

        MenuDeleted menuDeleted = new MenuDeleted(this);
        menuDeleted.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {}

    public static MenuRepository repository() {
        MenuRepository menuRepository = MenuApplication.applicationContext.getBean(
            MenuRepository.class
        );
        return menuRepository;
    }
}
//>>> DDD / Aggregate Root
