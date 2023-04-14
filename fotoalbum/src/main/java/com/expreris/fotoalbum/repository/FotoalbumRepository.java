package com.expreris.fotoalbum.repository;

import com.expreris.fotoalbum.model.FotoAlbum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FotoalbumRepository extends JpaRepository<FotoAlbum, Integer> {

}
