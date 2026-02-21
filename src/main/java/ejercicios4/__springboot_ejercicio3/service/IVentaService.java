package ejercicios4.__springboot_ejercicio3.service;

import ejercicios4.__springboot_ejercicio3.dto.VentaDTO;
import ejercicios4.__springboot_ejercicio3.model.Venta;

import java.util.List;

interface IVentaService {

    List<VentaDTO> getVentas();

    VentaDTO createVenta(VentaDTO ventaDto);

    VentaDTO updateVenta(Long id, VentaDTO ventaDto);

    void deleteVenta(Long id);
}
