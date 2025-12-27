package com.example.demo.controller;

import com.example.demo.dto.ItemRequestDto;
import com.example.demo.dto.ItemResponseDto;
import com.example.demo.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ItemController.BASE_PATH)
public class ItemController {

    public static final String BASE_PATH = "/items";
    public static final String ID_PATH = "/{id}";
    public static final String VALUE_PATH = "/value";
    public static final String SEARCH_PATH = "/search";

    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ItemResponseDto> add(@Valid @RequestBody ItemRequestDto dto) {
        ItemResponseDto saved = service.add(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<ItemResponseDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping(ID_PATH)
    public ResponseEntity<ItemResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping(ID_PATH)
    public ResponseEntity<ItemResponseDto> update(@PathVariable Long id, @Valid @RequestBody ItemRequestDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping(ID_PATH)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(VALUE_PATH)
    public ResponseEntity<Double> totalValue() {
        return ResponseEntity.ok(service.getTotalValue());
    }

    @GetMapping(SEARCH_PATH)
    public ResponseEntity<List<ItemResponseDto>> search(@RequestParam int minQty) {
        return ResponseEntity.ok(service.searchByMinQty(minQty));
    }
}
