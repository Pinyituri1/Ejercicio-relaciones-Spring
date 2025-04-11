package com.example.BDPostgres.Service;

import com.example.BDPostgres.Model.Cliente;
import com.example.BDPostgres.Model.DetalleVenta;
import com.example.BDPostgres.Repository.ClienteRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {


    private final ClienteRepositorio clienteRepositorio;

    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    public void eliminarCliente(Integer id_cliente) {
        clienteRepositorio.deleteById(id_cliente);
    }

    public Cliente actualizarCliente(Integer id_cliente, Cliente clienteActualizado) {
        Optional<Cliente> clienteExistente = clienteRepositorio.findById(id_cliente);
        if (clienteExistente.isPresent()) {
            Cliente cliente = clienteExistente.get();
            cliente.setNombre(clienteActualizado.getNombre());
            cliente.setCedula(clienteActualizado.getCedula());
            cliente.setCorreo(clienteActualizado.getCorreo());
            cliente.setTelefono(clienteActualizado.getTelefono());
            return clienteRepositorio.save(cliente);
        } else {
            return null;
        }
    }

    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepositorio.findAll();
    }

    public Optional<Cliente> buscarClientePorId(Integer id_cliente) {
        return clienteRepositorio.findById(id_cliente);
    }
}
