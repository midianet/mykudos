package midianet.mykudos.core.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sprint {
    @Id
    @Column(length = 20)
    private String id;

    @NotBlank
    @Size(min = 3 , max = 60)
    @Column(nullable = false, length = 60)
    private String description;

    @NotNull
    @PastOrPresent
    private LocalDateTime date;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="sprint_kudos",
            joinColumns=@JoinColumn(name="sprint_id"),
            inverseJoinColumns=@JoinColumn(name="id"))
    private List<Kudo> kudos = new ArrayList<>();

    @Data
    @Entity(name = "sprint_kudos")
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Kudo{

        @Id
        @Column(length = 20)
        private String id;

        @NotBlank
        @Size(min = 3 , max = 60)
        @Column(name = "user_id", nullable = false, length = 60)
        private String user;

        @NotBlank
        @Size(min = 3 , max = 60)
        @Column(name = "praised_id", nullable = false, length = 60)
        private String praised;

        @NotBlank
        @Size(min = 10 , max = 500)
        @Column(nullable = false, length = 500)
        private String message;

    }

}
