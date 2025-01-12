package com.apirest.APIRest.service;

import com.apirest.APIRest.presentation.dto.UserDTO;
import java.util.List;

public interface IUserService {
    List<UserDTO> findAll();
    UserDTO findById(Integer id);
    UserDTO save(UserDTO userDTO);
    UserDTO update(UserDTO userDTO, Integer id);
    String delete(Integer id);
}