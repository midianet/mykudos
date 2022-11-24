package midianet.mykudos.core.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(length = 20)
    private String id;

    @NotBlank
    @Size(min = 3 , max = 80)
    @Column(nullable = false, length = 60)
    private String nome;

    @Email
    @NotBlank
    @Size(min = 3 , max = 60)
    @Column(nullable = false, length = 60, unique = true)
    private String email;

}
