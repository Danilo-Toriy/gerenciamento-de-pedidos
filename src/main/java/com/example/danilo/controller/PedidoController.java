package com.example.danilo.controller;

import com.example.danilo.entity.Pedido;
import com.example.danilo.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> save(@RequestBody Pedido novoPedido){
        Pedido pedido = pedidoService.save(novoPedido);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> findAll(){
        List<Pedido> pedidoList = pedidoService.findAll();

        return pedidoList.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok().body(pedidoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Long id){
        Optional<Pedido> pedidoAchado = pedidoService.findById(id);
        return pedidoAchado.isPresent()
                ? ResponseEntity.ok().body(pedidoAchado.get())
                : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> update(@PathVariable Long id, @RequestBody Pedido pedidoAtualizado){
        Pedido pedido = pedidoService.update(id, pedidoAtualizado);
        return  ResponseEntity.ok(pedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        pedidoService.deleteById(id);
        return ResponseEntity.status(204).build();
    }
}
