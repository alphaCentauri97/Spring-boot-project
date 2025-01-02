    package com.example.Relation.Mapping.Repository.ManyToMany;

    import com.example.Relation.Mapping.entities.ManyToMany.Student;
    import org.springframework.data.jpa.repository.JpaRepository;

    public interface StudentRepository extends JpaRepository<Student,Long> {
    }
