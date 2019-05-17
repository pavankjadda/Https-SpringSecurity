package com.springsecurity.httpsdemo.web.api;

import com.springsecurity.httpsdemo.dto.AddressDTO;
import com.springsecurity.httpsdemo.model.Address;
import com.springsecurity.httpsdemo.repo.AddressRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v2/address")
public class AddressController
{

    private AddressRepository addressRepository;

    private final ModelMapper modelMapper;

    public AddressController(AddressRepository addressRepository, ModelMapper modelMapper)
    {
        this.addressRepository=addressRepository;
        this.modelMapper = modelMapper;
    }

    @PostMapping(path = "/create")
    public void createAddress(@RequestBody AddressDTO addressDTO)
    {
        Address address = modelMapper.map(addressDTO, Address.class);
        addressRepository.save(address);
    }

    @GetMapping(value = "/list")
    public List<AddressDTO> getAddresses()
    {
        Type listType = new TypeToken<List<Address>>()
        {
        }.getType();
        return modelMapper.map(addressRepository.findAll(), listType);
    }


    @GetMapping(value = "/find/{id}")
    public AddressDTO getAddressById(@PathVariable Long id)
    {
        Optional<Address> addressOptional = addressRepository.findById(id);
        return addressOptional.map(address -> modelMapper.map(address, AddressDTO.class)).orElse(null);
    }
}
