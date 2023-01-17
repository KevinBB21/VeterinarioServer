package net.Verinario.VeterinarioServer.repository;

import net.Verinario.VeterinarioServer.entity.AnimalEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;




public interface AnimalRepository extends JpaRepository<AnimalEntity, Long> {

   AnimalEntity findByAnimalnameAndPassword(String login, String password); //oAuth

    boolean existsByAnimalname(String login);

    //Page<AnimalEntity> findByTipoAnimalIdAndDniIgnoreCaseContainingOrNameIgnoreCaseContainingOrSurname1IgnoreCaseContainingOrSurname2IgnoreCaseContaining(Long id_Animaltype, String dni, String Name, String Surname1, String Surname2, Pageable oPageable);

   // Page<AnimalEntity> findByDniIgnoreCaseContainingOrNameIgnoreCaseContainingOrSurname1IgnoreCaseContainingOrSurname2IgnoreCaseContaining(String dni, String name, String surname1, String surname2 ,Pageable oPageable);

   Page<AnimalEntity> findByTipoAnimalIdAndNombre_animalIgnoreCaseContainingOrColorIgnoreCaseContainingOrRazaIgnoreCaseContaining(Long id_TipoAnimal , String strFilterNombreAnimal, String strFilterColor, String strFilterRaza, Pageable oPageable);

   Page<AnimalEntity> findByNombre_animalIgnoreCaseContainingOrColorIgnoreCaseContainingOrRazaIgnoreCaseContaining( String strFilterNombreAnimal, String strFilterColor, String strFilterRaza, Pageable oPageable);

    Page<AnimalEntity> findByTipoAnimalId(Long id_TipoAnimal, Pageable oPageable);

    AnimalEntity getById(Long id);
 
    
}
 
