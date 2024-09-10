package forohubV2.api.controller;

import forohubV2.api.domain.post.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostRepository postRepository;


    @PostMapping
    public void registrarPost(@RequestBody @Valid DTOPost dtoPost){
        postRepository.save(new Post(dtoPost));
    }


    @GetMapping
    public ResponseEntity<Page<DTOListaPost>> listaposteos(@PageableDefault(size = 10)Pageable pageable){
        return ResponseEntity.ok(postRepository.findAll(pageable).map(DTOListaPost::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<DTOListaPost>> devolverId(@PathVariable Long id){
        return ResponseEntity.ok(postRepository.findById(id).map(DTOListaPost::new));
    }

    @PutMapping
    @Transactional
    public void actualizarPost(@RequestBody @Valid DTOActualizarPost dtoActualizarPost){
        Post post = postRepository.getReferenceById(dtoActualizarPost.id());
        post.actualizarDatos(dtoActualizarPost);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void finalizarPost(@PathVariable Long id){
        Post post = postRepository.getReferenceById(id);
        post.finalizarPost();
    }


    @DeleteMapping("/eliminar/{id}")
    @Transactional
    public void eliminarPost(@PathVariable Long id){
        Post post = postRepository.getReferenceById(id);
        postRepository.delete(post);
    }



    }
