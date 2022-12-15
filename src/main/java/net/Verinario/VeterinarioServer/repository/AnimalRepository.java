package net.Verinario.VeterinarioServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.Verinario.VeterinarioServer.entity.AnimalEntity;


public interface AnimalRepository extends JpaRepository<AnimalEntity, Long> {

}
 
