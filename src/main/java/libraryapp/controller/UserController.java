package libraryapp.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;
import libraryapp.dto.UserDto;
import libraryapp.entity.Role;
import libraryapp.entity.User;
import libraryapp.service.RoleService;
import libraryapp.service.UserService;
import libraryapp.util.UserDtoConverterUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/login")
    public String loginUserForm() {
        return "user-login";
    }

    @GetMapping("/registration")
    public String registrationUserForm(Model model) {
        return "user-register";
    }

    @PostMapping("/registration")
    public String registrationUser(@ModelAttribute @Valid UserDto userDto,
                                   BindingResult result, Model model) {
        if (result.getErrorCount() > 0) {
            List<ObjectError> objectErrors = result.getAllErrors();
            model.addAttribute("errors", objectErrors);
            return registrationUserForm(model);
        }
        User user = UserDtoConverterUtil.createUser(userDto);
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(roleService.getRoleByName("USER"));
        user.setRoles(userRoles);
        userService.add(user);
        return "index";
    }
}
