package com.packt.modern.api.controller;

import com.packt.modern.api.AddressApi;
import com.packt.modern.api.entity.RoleEnum.Const;
import com.packt.modern.api.hateoas.AddressRepresentationModelAssembler;
import com.packt.modern.api.model.AddAddressReq;
import com.packt.modern.api.model.Address;
import com.packt.modern.api.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.*;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter06 - Modern API Development with Spring and Spring Boot Ed 2
 */
@RestController
public class AddressController implements AddressApi {

  private final AddressRepresentationModelAssembler assembler;
  private AddressService service;

  public AddressController(
      AddressService addressService, AddressRepresentationModelAssembler assembler) {
    this.service = addressService;
    this.assembler = assembler;
  }

  @Override
  public ResponseEntity<Address> createAddress(@Valid AddAddressReq addAddressReq) {
    return status(HttpStatus.CREATED)
        .body(service.createAddress(addAddressReq).map(assembler::toModel).get());
  }

  @PreAuthorize("hasRole('" + Const.ADMIN + "')")
  @Override
  public ResponseEntity<Void> deleteAddressesById(String id) {
    service.deleteAddressesById(id);
    return accepted().build();
  }

  @Override
  public ResponseEntity<Address> getAddressesById(String id) {
    return service
        .getAddressesById(id)
        .map(assembler::toModel)
        .map(ResponseEntity::ok)
        .orElse(notFound().build());
  }

  @Override
  public ResponseEntity<List<Address>> getAllAddresses() {
    return ok(assembler.toListModel(service.getAllAddresses()));
  }
}
