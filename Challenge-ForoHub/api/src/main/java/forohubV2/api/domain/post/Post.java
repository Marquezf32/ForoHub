package forohubV2.api.domain.post;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="posts")
@Entity(name = "Post")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private String fecha;
    private String status;
    private String autor;
    @Enumerated
    private Curso curso;

    //Metodo que agrega un nuevo post a la bd
    public Post(DTOPost dtoPost) {
        this.titulo = dtoPost.titulo();
        this.mensaje = dtoPost.mensaje();
        this.fecha = dtoPost.fecha();
        this.status = dtoPost.status();
        this.autor= dtoPost.autor();
        this.curso = dtoPost.curso();
    }


    //metodo que actualiza los datos Titulo, Mensaje y Status
    public void actualizarDatos(DTOActualizarPost dtoActualizarPost) {
        if (dtoActualizarPost.titulo() != null){
            this.titulo = dtoActualizarPost.titulo();
        }

        if (dtoActualizarPost.mensaje() != null){
            this.mensaje = dtoActualizarPost.mensaje();
        }

        if (dtoActualizarPost.status() != null){
            this.status = dtoActualizarPost.status();
        }

    }

    public void finalizarPost() {
        this.status="Finalizado";
    }

}
