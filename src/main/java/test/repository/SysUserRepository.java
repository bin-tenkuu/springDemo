package test.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import test.entity.SysUser;

public interface SysUserRepository extends JpaRepositoryImplementation<SysUser, Integer> {
}
