package com.example.demo.controller;

import com.example.demo.dto.ItemRequestDto;
import com.example.demo.dto.ItemResponseDto;
import com.example.demo.routes.Routes;
import com.example.demo.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Routes.ITEMS)
public class ItemController {

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

    @GetMapping(Routes.ID)
    public ResponseEntity<ItemResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping(Routes.ID)
    public ResponseEntity<ItemResponseDto> update(@PathVariable Long id, @Valid @RequestBody ItemRequestDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping(Routes.ID)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(Routes.VALUE)
    public ResponseEntity<Double> totalValue() {
        return ResponseEntity.ok(service.getTotalValue());
    }

    @GetMapping(Routes.SEARCH)
    public ResponseEntity<List<ItemResponseDto>> search(@RequestParam int minQty) {
        return ResponseEntity.ok(service.searchByMinQty(minQty));
    }
}
