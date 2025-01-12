package com.apirest.APIRest.service.impl;

import com.apirest.APIRest.pesistence.dao.IUserDAO;
import com.apirest.APIRest.pesistence.entities.UserEntity;
import com.apirest.APIRest.presentation.dto.UserDTO;
import com.apirest.APIRest.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDAO userDAO;

    @Override
    public List<UserDTO> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        return this.userDAO.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(Integer id) {
        Optional<UserEntity> userEntity = this.userDAO.findById(id);

        if (userEntity.isPresent()) {
            ModelMapper modelMapper = new ModelMapper();
            UserEntity dtoUser = userEntity.get();
            return modelMapper.map(dtoUser, UserDTO.class);
        } else {
            return new UserDTO();
        }
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
            this.userDAO.save(userEntity);
            return userDTO;
        } catch (Exception e) {
            throw new UnsupportedOperationException("Error saving");
        }
    }

    @Override
    public UserDTO update(UserDTO userDTO, Integer id) {
        Optional<UserEntity> userEntity = this.userDAO.findById(id);

        if (userEntity.isPresent()) {
            UserEntity dtoUser = userEntity.get();
            dtoUser.setName(userDTO.getName());
            dtoUser.setLastName(userDTO.getLastName());
            dtoUser.setIdDocument(userDTO.getIdDocument());
            dtoUser.setAddress(userDTO.getAddress());
            dtoUser.setPhoneNumber(userDTO.getPhoneNumber());
            dtoUser.setEmail(userDTO.getAddress());
            this.userDAO.update(dtoUser);

            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(dtoUser, UserDTO.class);
        } else {
            throw new IllegalArgumentException("Error updating");
        }
    }

    @Override
    public String delete(Integer id) {
        Optional<UserEntity> userEntity = this.userDAO.findById(id);

        if (userEntity.isPresent()) {
            UserEntity dtoUser = userEntity.get();
            this.userDAO.delete(dtoUser);
            return "NO_CONTENT (This message will not be show)";
        } else {
            return "Error updating";
        }
    }
}
