package midianet.mykudos.infra.rest;

import lombok.RequiredArgsConstructor;
import midianet.mykudos.core.entity.Sprint;
import midianet.mykudos.core.usecase.NewSprint;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/sprint")
public class SprintResource {

    private final NewSprint newSprint;

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public NewSprint.Out create(@RequestBody NewSprint.In sprint , HttpServletResponse response) {
        final var persistent = newSprint.execute(sprint);
        response.setHeader(HttpHeaders.LOCATION, ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/spk/{id}")
            .buildAndExpand(persistent.getId())
            .toUri()
            .toString());
        return new NewSprint.Out(sprint.description(),response.getHeader(HttpHeaders.LOCATION));
    }


    @GetMapping("/{id}")
    public Sprint get(@PathVariable final String id){
        return listarPedidos.execute();
    }
//
//    @PostMapping("/limpar")
//    public void limpar(){
//        limparTudo.execute();
//    }
//

//    @GetMapping
//    public Page<meta.ecometa.core.entity.Kudo> find(@RequestParam(required = false) final String descricao,
//                                                    @PageableDefault final Pageable pageable) {
//        final var example = meta.ecometa.core.entity.Kudo.builder();
//        Optional.ofNullable(descricao).ifPresent(example::descricao);
//        return listar.execute(example.build(),pageable);
//    }

}
