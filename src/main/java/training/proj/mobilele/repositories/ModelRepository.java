package training.proj.mobilele.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import training.proj.mobilele.models.entities.ModelEntity;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity,Long> {


}
