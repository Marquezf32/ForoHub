package forohubV2.api.domain.post;

public record DTOListaPost(
        Long id,
        String titulo,
        String mensaje,
        String fecha,
        String status,
        String autor,
        String curso
) {
    public DTOListaPost(Post post){
        this(
                post.getId(),
                post.getTitulo(),
                post.getMensaje(),
                post.getFecha(),
                post.getStatus(),
                post.getAutor(),
                post.getCurso().toString());
    }
}
