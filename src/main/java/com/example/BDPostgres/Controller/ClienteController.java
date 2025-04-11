package com.example.BDPostgres.Controller;

import com.example.BDPostgres.Model.Cliente;
import com.example.BDPostgres.Service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Cliente")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService clienteService;

    @GetMapping
    public List<Cliente>  listarClientes() {
        return clienteService.obtenerTodosLosClientes();
    }

    @PostMapping
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return clienteService.guardarCliente(cliente);
    }

    @GetMapping("/{id_cliente}")
    public ResponseEntity<Cliente> obtenerCliente(@PathVariable Integer id_cliente) {
        Optional<Cliente> cliente = clienteService.buscarClientePorId(id_cliente);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id_cliente}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable("id_cliente") Integer id_cliente){
        clienteService.eliminarCliente(id_cliente);
        return ResponseEntity.noContent().build();
    }
}
