package com.example.demo.service;

import com.example.demo.dto.ItemRequestDto;
import com.example.demo.dto.ItemResponseDto;
import com.example.demo.entity.Item;
import com.example.demo.exception.ItemNotFoundException;
import com.example.demo.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository repo;

    public ItemService(ItemRepository repo) {
        this.repo = repo;
    }

    public ItemResponseDto add(ItemRequestDto dto) {
        Item item = new Item();
        applyRequestDto(item, dto);

        Item saved = repo.save(item);
        return toResponseDto(saved);
    }

    public List<ItemResponseDto> getAll() {
        return repo.findAll().stream().map(this::toResponseDto).toList();
    }

    public ItemResponseDto getById(Long id) {
        Item item = repo.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
        return toResponseDto(item);
    }

    public ItemResponseDto update(Long id, ItemRequestDto dto) {
        Item item = repo.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
        applyRequestDto(item, dto);

        Item saved = repo.save(item);
        return toResponseDto(saved);
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new ItemNotFoundException(id);
        }
        repo.deleteById(id);
    }

    public double getTotalValue() {
        return repo.findAll()
                .stream()
                .mapToDouble(i -> i.getPrice() * i.getQuantity())
                .sum();
    }

    public List<ItemResponseDto> searchByMinQty(int minQty) {
        return repo.findByQuantityGreaterThanEqual(minQty)
                .stream()
                .map(this::toResponseDto)
                .toList();
    }

    // --------------------
    // Mapping helpers
    // --------------------
    private ItemResponseDto toResponseDto(Item item) {
        return new ItemResponseDto(
                item.getId(),
                item.getItemName(),
                item.getQuantity(),
                item.getPrice()
        );
    }

    private void applyRequestDto(Item item, ItemRequestDto dto) {
        item.setItemName(dto.getItemName());
        item.setQuantity(dto.getQuantity());
        item.setPrice(dto.getPrice());
    }
}
