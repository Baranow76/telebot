package baranow.laba2.telebot.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Getter
@Setter
@Entity(name = "callJoke")
@Table(name = "callJoke")


public class CallJoke {

    @Id
    @Column(name = "idCallJoke")
    @GeneratedValue(generator = "id_call_joke_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "id_call_joke_seq", sequenceName = "id_call_joke_seq", initialValue = 1, allocationSize = 1)
    private Long idCall;

    @Column(name = "timeCall")
    private LocalDateTime timeCall;

    @Column(name = "idUserCall")
    private Long idUserCall;

}
