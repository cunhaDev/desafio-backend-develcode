package com.develcode.teste.api.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.develcode.teste.domain.model.Usuario;
import com.develcode.teste.domain.repository.UsuarioRepository;
import com.develcode.teste.domain.upload.FileUploadUtil;
 
@RestController
@RequestMapping({"/api/v2"})
public class UsuarioController {
 
    @Autowired
    private UsuarioRepository candidateRepo;
     
    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public String salvarUsuario(Usuario candidate,
            @RequestParam("profilePictureFile") MultipartFile multipartFile1
            ) throws IOException {
         
        String profilePictureFileName = StringUtils.cleanPath(multipartFile1.getOriginalFilename());
         
        candidate.setFoto(profilePictureFileName);
         
        Usuario savedCandidate = candidateRepo.save(candidate);
        String uploadDir = "candidates/" + savedCandidate.getCodigo();
         
        FileUploadUtil.saveFile(uploadDir, profilePictureFileName, multipartFile1);
         
        return "usuario cadastrado com sucesso!";
    }
     
}