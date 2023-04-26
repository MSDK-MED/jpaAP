package ma.emsi.jpaap.service;

import ma.emsi.jpaap.entities.Role;
import ma.emsi.jpaap.entities.User;
import ma.emsi.jpaap.repositories.RoleRepository;
import ma.emsi.jpaap.repositories.UserRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User addUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Role findRoleByName(String rolename) {
        return roleRepository.findByRoleName(rolename);
    }

    @Override
    public void  addRoleToUser(String u, String r) {
        User user = findUserByUserName(u);
        Role role  = findRoleByName(r);
        user.getRoles().add(role);
        role.getUsers().add(user);

    }
}
