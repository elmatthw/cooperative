package by.bsuir.rest.requisite.controller;

import by.bsuir.reguisites.service.CrudService;
import by.bsuir.rest.common.mapper.EntityMapper;
import by.bsuir.rest.requisite.IDValidationGroup;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class CrudController<S extends CrudService<E>, D, E> {
    private final S service;
    private final EntityMapper<D, E> entityMapper;

    protected CrudController(S service, EntityMapper<D, E> entityMapper) {
        this.service = service;
        this.entityMapper = entityMapper;
    }

    @GetMapping
    public ResponseEntity<List<D>> get() {
        return ResponseEntity.ok(service.findAll().stream().map(entityMapper::toDto).collect(Collectors.toList()));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<D> update(@RequestBody @Validated(value = IDValidationGroup.class) D d) {
        return ResponseEntity.ok(entityMapper.toDto(service.update(entityMapper.fromDto(d))));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<D> get(@PathVariable(name = "id") String id) {
        E e = service.find(id);
        return e != null ? ResponseEntity.ok(Objects.requireNonNull(entityMapper.toDto(e))) : ResponseEntity.ok().build();
    }

    @GetMapping(path = "/pages/{page}/{limit}")
    public ResponseEntity<List<D>> get(@PathVariable("page") int page, @PathVariable("limit") int limit) {
        return ResponseEntity.ok(service.findAll(page, limit).stream().map(entityMapper::toDto).collect(Collectors.toList()));
    }

    @PostMapping(
            value = "/batch",
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<List<D>> batchUpdate(@RequestBody Collection<String> ids) {
        return ResponseEntity.ok(service.find(ids).stream().map(entityMapper::toDto).collect(Collectors.toList()));
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<D> post(@RequestBody @Valid D d) {
        return ResponseEntity.of(Optional.ofNullable(entityMapper.toDto(service.register(Objects.requireNonNull(entityMapper.fromDto(d))))));
    }

}
