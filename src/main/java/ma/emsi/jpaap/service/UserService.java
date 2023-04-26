package ma.emsi.jpaap.service;

import ma.emsi.jpaap.entities.Role;
import ma.emsi.jpaap.entities.User;

public interface UserService {
    User addUser (User user);
    Role addRole (Role role);
    User findUserByUserName(String username);
    Role findRoleByName(String rolename);
    void addRoleToUser(String u,String r);
}
