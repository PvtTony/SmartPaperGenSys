package me.songt.smartpaper.service.impl;

import me.songt.smartpaper.po.Student;
import me.songt.smartpaper.po.Teacher;
import me.songt.smartpaper.po.User;
import me.songt.smartpaper.repository.StudentRepository;
import me.songt.smartpaper.repository.TeacherRepository;
import me.songt.smartpaper.repository.UserRepository;
import me.songt.smartpaper.service.UserAuthService;
import me.songt.smartpaper.vo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tony on 2017/5/26.
 */
@Service
public class UserAuthServiceImpl implements UserAuthService
{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public UserInfo auth(String username, String password)
    {
        User user = userRepository.findByuserName(username);
        UserInfo userInfo = new UserInfo();

        if (user ==  null)
        {
            return null;
        }
        userInfo.setUserId(user.getUserId());
        userInfo.setUserType(user.getUserRoleId());

        userInfo.setUsername(user.getUserName());
        String userPassword = user.getUserPassword();
        if (!password.equals(userPassword))
        {
            return null;
        }

        if (user.getUserRoleId() == UserInfo.TYPE_STUDENT)
        {
            Student student = studentRepository.findBystudentUserId(userInfo.getUserId());
            userInfo.setUserObject(student);
        }
        else if (user.getUserRoleId() == UserInfo.TYPE_TEACHER)
        {
            Teacher teacher = teacherRepository.findByteacherUserId(userInfo.getUserId());
            userInfo.setUserObject(teacher);
        }
        return userInfo;
    }
}
