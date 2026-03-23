package com.example.danilo.service;

import com.example.danilo.entity.Pedido;
import com.example.danilo.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> findById(Long id){
        return pedidoRepository.findById(id);
    }

    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public void deleteById(Long id){
        pedidoRepository.deleteById(id);
    }

    public Pedido update(Long id, Pedido pedido){
        Pedido novoPedido = pedidoRepository.findById(id).get();

        novoPedido.setData(pedido.getData());
        novoPedido.setStatus(pedido.getStatus());
        novoPedido.setValorTotal(pedido.getValorTotal());

        return pedidoRepository.save(novoPedido);
    }
}
