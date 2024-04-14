package com.sst.productservicesst.Repository;
import com.sst.productservicesst.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Override
    Category save (Category category);
}
