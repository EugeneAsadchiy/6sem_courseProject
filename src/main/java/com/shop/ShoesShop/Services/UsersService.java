package com.shop.ShoesShop.Services;

import com.shop.ShoesShop.models.Products;
import com.shop.ShoesShop.models.Users;
import com.shop.ShoesShop.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;

    public Users getUserById(Long id)
    {
        return usersRepository.findById(id).orElse(null);
    }
    public void saveUsers(Users users) throws IOException {

        Users usersFromDB = usersRepository.save(users);
        usersRepository.save(users);
    }

    public boolean enterUsers(String userLogin, String userPassword) throws IOException
    {
        boolean proverka = usersRepository.existsUsersByUserLoginAndUserPassword(userLogin, userPassword);
        if (proverka)
        {
            Users user = usersRepository.findByUserLogin(userLogin);
            if(user.getRole()==0)
            {
                Users.session=0;
            }
            else {
                Users.session=1;
            }
        }
        return proverka;
    }
    public boolean registrationUsers(String userLogin, String userPassword) throws IOException
    {
        return usersRepository.existsUsersByUserLogin(userLogin);
    }
}
