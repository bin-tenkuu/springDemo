package test.controller;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.entity.SysUser;
import test.repository.SysUserRepository;

/**
 * @author bin
 * @since 2024/05/11
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/SysUser")
public class SysUserController {
    private final SysUserRepository sysUserRepository;

    @GetMapping("/init")
    public void init() {
        for (int i = 0; i < 10; i++) {
            val sysUser = new SysUser();
            sysUser.setUsername("user" + i);
            sysUser.setPassword("password" + i);
            sysUser.setStatus(true);
            sysUserRepository.save(sysUser);
        }
    }

    @GetMapping("/get")
    public Page<SysUser> page(@ParameterObject Pageable pageable) {
        return sysUserRepository.findAll(pageable);
    }
}
